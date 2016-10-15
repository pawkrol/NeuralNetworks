package org.pawkrol.academic.nn.zaj1;

import java.util.Random;

/**
 * Created by Pawel on 2016-10-13.
 */
public class Perceptron {

    private double[] weights;

    public int output(float[] inputs){
        float sum = 0;
        for (int i = 0; i < inputs.length; i++){
            sum += inputs[i] * weights[i];
        }

        sum += weights[weights.length - 1];

        if (sum >= 0)
            return 1;
        else
            return -1;
    }

    public void learn(float inputs[][], float[] outputs, float lFactor, int maxIterations){
        initWeights(inputs[0].length);

        for (int i = 0; i < maxIterations; i++){
            int globalError = 0;

            for (int p = 0; p < outputs.length; p++){
                int output = output(inputs[p]);
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

    private void initWeights(int size){
        Random rand = new Random();

        size++; //to fit bias

        weights = new double[size];
        for (int i = 0; i < size; i++){
            weights[i] = rand.nextFloat();
        }
    }

}
