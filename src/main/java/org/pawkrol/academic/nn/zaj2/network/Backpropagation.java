package org.pawkrol.academic.nn.zaj2.network;

import org.pawkrol.academic.nn.common.ErrorTimePair;

import java.util.ArrayList;
import java.util.List;

public class Backpropagation {

    private final NetManager manager;
    private List<ErrorTimePair> errorTimePairs = new ArrayList<>();

    public Backpropagation(NetManager manager) {
        this.manager = manager;
    }

    public void learn(float[][] inputValues, float[][] outputValues, double minError, int maxInterations) {
        float error;
        long startTime = System.currentTimeMillis();
        long itTime;

        for (int j = 0; j <= maxInterations; j++) {
            error = 0;

            for (int i = 0; i < inputValues.length; i++) {
                manager.propagateInput(inputValues[i]);
                manager.calculateOutputDeltas(outputValues[i]);
                manager.calculateHiddenDeltas();
                manager.updateWeights(inputValues[i]);

                error += manager.getError() * manager.getError();
            }

            itTime = System.currentTimeMillis();
            errorTimePairs.add(new ErrorTimePair(error, itTime - startTime));

            if (error <= minError) break;
        }

    }

    public List<ErrorTimePair> getErrorTimePairs() {
        return errorTimePairs;
    }
}
