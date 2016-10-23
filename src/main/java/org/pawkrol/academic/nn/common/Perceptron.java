package org.pawkrol.academic.nn.common;

import org.pawkrol.academic.nn.common.functions.ActivationFunction;

import java.util.Random;

/**
 * Created by Pawel on 2016-10-13.
 */
public class Perceptron {

    private ActivationFunction activationFunction;
    private double[] weights;
    private float delta;

    public Perceptron(ActivationFunction activationFunction){
        this.activationFunction = activationFunction;
    }

    public Perceptron(int inputs, ActivationFunction activationFunction){
        initWeights(inputs);
        this.activationFunction = activationFunction;
    }

    public float output(float[] inputs){
        float sum = 0;
        for (int i = 0; i < inputs.length; i++){
            sum += inputs[i] * weights[i];
        }

        sum += weights[weights.length - 1];

        return activationFunction.f(sum);
    }

    public float doutput(float[] inputs){
        float sum = 0;
        for (int i = 0; i < inputs.length; i++){
            sum += inputs[i] * weights[i];
        }

        sum += weights[weights.length - 1];

        return activationFunction.df(sum);
    }

    public void learn(float inputs[][], float[] outputs, float lFactor, int maxIterations){
        initWeights(inputs[0].length);

        for (int i = 0; i < maxIterations; i++){
            int globalError = 0;

            for (int p = 0; p < outputs.length; p++){
                float output = output(inputs[p]);
                float localError = outputs[p] - output;

                for (int j = 0; j < weights.length - 1; j++){
                    weights[j] += lFactor * localError * inputs[p][j];
                }
                weights[weights.length - 1] += lFactor * localError;

                globalError += (localError * localError);
            }

            if (globalError == 0) break;
        }
    }

    public double[] getWeights() {
        return weights;
    }

    public void setWeights(double[] weights) {
        this.weights = weights;
    }

    public float getDelta() {
        return delta;
    }

    public void setDelta(float delta) {
        this.delta = delta;
    }

    private void initWeights(int size){
        Random rand = new Random();

        size++; //to fit bias

        weights = new double[size];
        for (int i = 0; i < size; i++){
            weights[i] = rand.nextFloat();
        }
    }

}
