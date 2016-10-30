package org.pawkrol.academic.nn.zaj3;

import org.pawkrol.academic.nn.common.Perceptron;

public class HebbLearner {

    public void learnUnsupervised(Perceptron perceptron, float inputs[][],
                                  float lFactor, float fFactor, int maxIterations){
        perceptron.setBias(0);
        float[] weights = perceptron.getWeights().clone();

        for (int i = 0; i < maxIterations; i++){

            for (float[] input : inputs) {
                float output = perceptron.calculateOutput(input).getOutput();

                for (int j = 0; j < weights.length; j++) {
                    weights[j] = (weights[j] * (1 - fFactor)) + (lFactor * output * input[j]);
                    //w(t + 1) = w(t)(1 - y) + dw
                }

                perceptron.setWeights(weights);
            }

        }
    }

    public void learnSupervised(Perceptron perceptron, float inputs[][], float[] pattern,
                                float lFactor, float fFactor, int maxIterations){
        perceptron.setBias(0);
        float[] weights = perceptron.getWeights().clone();

//        for (int i = 0; i < maxIterations; i++){

        for (int i = 0; i < inputs.length; i++) {

            for (int j = 0; j < weights.length; j++) {
                weights[j] = (weights[j] * (1 - fFactor)) + (lFactor * pattern[i] * inputs[i][j]);
                //w(t + 1) = w(t)(1 - y) + dw
            }

            perceptron.setWeights(weights);
        }

//        }
    }
}
