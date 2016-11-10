package org.pawkrol.academic.nn.zaj5;

import org.pawkrol.academic.nn.common.functions.ActivationFunction;
import org.pawkrol.academic.nn.common.functions.BipolarFunction;

import java.util.Random;

public class HopfieldManager {

    private float[][] weights;
    private float[] outputs;
    private ActivationFunction function;

    private int n;

    public HopfieldManager(int n){
        this.n = n;

        weights = new float[n][n];
        outputs = new float[n];

        function = new BipolarFunction();
    }

    public float[] calcOutputAsync(float[] input, int asyncs){
        float v;
        int i;
        Random random = new Random();

        for (int a = 0; a < asyncs; a++) {
            i = random.nextInt(n);

            v = 0;
            for (int j = 0; j < n; j++) {
                v += weights[i][j] * outputs[j];
            }
            v += input[i];

            outputs[i] = function.f(v);
        }

        return outputs;
    }

    public float[] calcOutputSync(float[] input){
        float v;

        for (int i = 0; i < input.length; i++) {

            v = 0;
            for (int j = 0; j < n; j++) {
                v += weights[i][j] * outputs[j];
            }
            v += input[i];

            outputs[i] = function.f(v);
        }

        return outputs;
    }

    public void learn(float[][] patterns){
        float sum;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (i == j) {
                    weights[i][j] = 0;
                    continue;
                }

                sum = 0;
                for (float[] pattern : patterns){
                    sum += pattern[i] * pattern[j];
                }

                weights[i][j] = sum / (n / 2);
            }
        }
    }

    public void setOutputs(float[] outputs) {
        this.outputs = outputs;
    }

    public int getN() {
        return n;
    }
}
