package org.pawkrol.academic.nn.zaj2;

import org.pawkrol.academic.nn.zaj1.Perceptron;

/**
 * Created by pawkrol on 10/16/16.
 */
public class Layer {

    private Perceptron[] perceptrons;
    private int size;

    Layer(int size){
        this.size = size;

        perceptrons = new Perceptron[size];
        for (int i = 0; i < size; i++){
            perceptrons[i] = new Perceptron();
        }
    }

    public void learn(float[][] inputs, float[][] outputs, float lRate, int maxIterations){
        for (int i = 0; i < size; i++){
            perceptrons[i].learn(inputs, outputs[i], lRate, maxIterations);
        }
    }

    public float[] output(float[] input){
        float[] response = new float[perceptrons.length];
        for (int i = 0; i < perceptrons.length; i++){
            response[i] = perceptrons[i].output(input);
        }

        return response;
    }
}
