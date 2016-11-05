package org.pawkrol.academic.nn.zaj4.network;

import java.util.Random;

public class KohonenPerceptron {

    private float weights[];
    private int numberOfInputs;

    public KohonenPerceptron(int numberOfInputs) {
        this.numberOfInputs = numberOfInputs;

        initWeights();
    }

    public float[] getWeights() {
        return weights;
    }

    public void setWeights(float[] weights) {
        this.weights = weights;
    }

    private void initWeights(){
        Random random = new Random();

        weights = new float[numberOfInputs];

        for (int i = 0; i < weights.length; i++){
            weights[i] = random.nextFloat();// * .1f;
        }
    }
}
