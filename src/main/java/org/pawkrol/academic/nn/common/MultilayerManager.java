package org.pawkrol.academic.nn.common;

import org.pawkrol.academic.nn.common.functions.ActivationFunction;

/**
 * Created by pawkrol on 10/22/16.
 */
public class MultilayerManager {

    private int size;
    private float lFactor;
    private ActivationFunction function;

    private Layer[] layers;

    public MultilayerManager(int initInputs, int[] sizes, float lFactor, ActivationFunction function){
        this.size = sizes.length;
        this.lFactor = lFactor;
        this.function = function;

        layers = new Layer[size];
        layers[0] = new Layer(initInputs, sizes[0], function);
        for (int i = 1; i < size; i++){
            layers[i] = new Layer(sizes[i - 1], sizes[i], function);
        }
    }

    public float[] output(float[] input){
        float[] tmpInput = input;

        for (int i = 0; i < size; i++){
            tmpInput = layers[i].output(tmpInput);
        }

        return tmpInput;
    }

    public void learnWithBP(float[] input, float[] output) {
        Perceptron p, prevP;
        Layer prevLayer;
        float tmpDelta;
        double[] weights;

        float[] dvalues;
        float[] values = output(input);

        //last layer deltas
        for (int i = 0; i < values.length; i++) {
            layers[layers.length - 1]
                    .getPerceptron(i)
                    .setDelta(output[i] - values[i]);
        }

        //propagate deltas
        for (int i = layers.length - 2; i >= 0; i--) {
            prevLayer = layers[i + 1];

            for (int j = 0; j < layers[i].getSize(); j++) {
                p = layers[i].getPerceptron(j);
                tmpDelta = 0;

                for (int k = 0; k < prevLayer.getSize(); k++) {
                    prevP = prevLayer.getPerceptron(k);
                    tmpDelta += prevP.getDelta() * prevP.getWeights()[j];
                }

                p.setDelta(tmpDelta);

            }
        }

        //calculate weights
        values = input;
        dvalues = layers[0].doutput(input);
        for (int i = 0; i < layers.length; i++) {

            if (i != 0){
                values = layers[i - 1].output(values);
                dvalues = layers[i - 1].doutput(values);
            }

            for (int j = 0; j < layers[i].getSize(); j++) {
                p = layers[i].getPerceptron(j);
                weights = p.getWeights();

                for (int k = 0; k < weights.length - 1; k++) {
                    weights[k] += lFactor * p.getDelta() * dvalues[k] * values[k];
                }

                weights[weights.length - 1] += lFactor * p.getDelta();

                p.setWeights(weights);
            }
        }
    }
}
