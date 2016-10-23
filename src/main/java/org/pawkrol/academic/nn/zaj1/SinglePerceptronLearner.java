package org.pawkrol.academic.nn.zaj1;

import org.pawkrol.academic.nn.common.Perceptron;

public class SinglePerceptronLearner {

    public void learn(Perceptron perceptron, float inputs[][], float[] outputs,
                      float lFactor, double minError, int maxIterations){
        float[] weights = perceptron.getWeights().clone();
        float bias = perceptron.getBias();

        for (int i = 0; i < maxIterations; i++){
            int globalError = 0;

            for (int p = 0; p < outputs.length; p++){
                float output = perceptron.calculateOutput(inputs[p]).getOutput();
                float localError = outputs[p] - output;

                for (int j = 0; j < weights.length; j++){
                    weights[j] += lFactor * localError * inputs[p][j];
                }
                 bias += lFactor * localError;

                globalError += (localError * localError);
            }

            perceptron.setWeights(weights);
            perceptron.setBias(bias);

            if (globalError == minError) break;
        }

    }
}
