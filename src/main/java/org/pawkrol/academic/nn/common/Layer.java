package org.pawkrol.academic.nn.common;

import org.pawkrol.academic.nn.common.functions.ActivationFunction;

/**
 * Created by pawkrol on 10/16/16.
 */
public class Layer {

    private Perceptron[] perceptrons;
    private int size;

    public Layer(int size, ActivationFunction function){
        this.size = size;

        perceptrons = new Perceptron[size];
        for (int i = 0; i < size; i++){
            perceptrons[i] = new Perceptron(function);
        }
    }

    public Layer(int perceptronInputs, int size, ActivationFunction function){
        this.size = size;

        perceptrons = new Perceptron[size];
        for (int i = 0; i < size; i++){
            perceptrons[i] = new Perceptron(perceptronInputs, function);
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

    public float[] doutput(float[] input){
        float[] response = new float[perceptrons.length];
        for (int i = 0; i < perceptrons.length; i++){
            response[i] = perceptrons[i].doutput(input);
        }

        return response;
    }

    public Perceptron getPerceptron(int i){
        return perceptrons[i];
    }

    public Perceptron[] getPerceptrons(){
        return perceptrons;
    }

    public int getSize() {
        return size;
    }
}
