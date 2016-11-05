package org.pawkrol.academic.nn.zaj4.network;

import org.pawkrol.academic.nn.zaj4.ErrorLogger;

import java.util.Random;

public class KohonenManager {

    private int n;
    private int m;
    private int dim;

    private KohonenPerceptron[][] lattice;

    private ErrorLogger logger;

    public KohonenManager(int n, int m, int dim) {
        this.n = n;
        this.m = m;
        this.dim = dim;

        logger = new ErrorLogger();

        createLattice();
    }

    public void learn(float[][] inputs, float lFactor, int maxIterations){
        KohonenPerceptron p;
        double learning;
        float[] input;
        float error;
        long startTime = System.currentTimeMillis();
        long dTime;

        Random random = new Random();

        for (int i = 0; i < maxIterations; i++) {
            error = 0;

            input = inputs[random.nextInt(inputs.length)];

            p = pickWinner(input);
            learning = (lFactor * Math.exp(-(double)i / (double)maxIterations));
            for (int j = 0; j < dim; j++){
                p.getWeights()[j] += learning * (input[j] - p.getWeights()[j]);

                error += (input[j] - p.getWeights()[j]) * (input[j] - p.getWeights()[j]);
            }

            dTime = System.currentTimeMillis() - startTime;
            logger.log(dTime, error / dim);
        }

        logger.saveLog();
    }

    public KohonenPerceptron[][] getLattice() {
        return lattice;
    }

    private KohonenPerceptron pickWinner(float[] input){
        KohonenPerceptron picked;
        float distance;

        KohonenPerceptron winner = lattice[0][0];
        float bestDistance = getDistance(input, winner.getWeights());

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (i == 0 && j == 0) continue;

                picked = lattice[i][j];
                distance = getDistance(input, picked.getWeights());

                if (distance < bestDistance){
                    bestDistance = distance;
                    winner = picked;
                }
            }
        }

        return winner;
    }

    private float getDistance(float[] vec1, float[] vec2){
        float sum = 0;
        for (int i = 0; i < dim; i++){
            sum += (vec2[i] - vec1[i]) * (vec2[i] - vec1[i]);
        }

        return (float) Math.sqrt(sum);
    }

    private void createLattice(){
        lattice = new KohonenPerceptron[n][m];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                lattice[i][j] = new KohonenPerceptron(dim);
            }
        }
    }
}
