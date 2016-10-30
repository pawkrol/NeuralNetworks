package org.pawkrol.academic.nn.zaj3;

import org.pawkrol.academic.nn.common.Perceptron;
import org.pawkrol.academic.nn.common.functions.BipolarFunction;

public class HebbNeuron {

    public static void main(String[] args){
        System.out.println("Supervised Hebb learning for one perceptron: ");
        runSupervised();
    }

    private static void runSupervised(){
        //SUPERVISED

        float[][] learnInput = {

                { //pattern 'X'
                        1, -1, -1, -1, 1,
                        -1, 1, -1, 1, -1,
                        -1, -1, 1, -1, -1,
                        -1, 1, -1, 1, -1,
                        1, -1, -1, -1, 1,
                },
                { //pattern 'O'
                        -1, 1, 1, 1, -1,
                        1, -1, -1, -1, 1,
                        1, -1, -1, -1, 1,
                        1, -1, -1, -1, 1,
                        -1, 1, 1, 1, -1
                }

        };

        float[][] testInput = {

                { //pattern 'X' with noise
                        1, -1, -1, -1, 1,
                        -1, 1, -1, 1, 1,
                        -1, -1, 1, -1, -1,
                        -1, 1, 1, 1, -1,
                        1, -1, -1, 1, 1,
                },
                { //pattern 'O' with noise
                        -1, 1, 1, 1, -1,
                        1, -1, -1, -1, 1,
                        1, -1, 1, -1, -1,
                        1, -1, -1, -1, 1,
                        1, 1, -1, 1, -1
                }

        };

        float[] pattern = {
                1.f, //for 'X'
                -1.f //for 'O'
        };

        Perceptron perceptron = new Perceptron(3, new BipolarFunction());
        perceptron.setWeights(new float[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        new HebbLearner().learnSupervised(perceptron, learnInput, pattern, 1.f, 0.f, 3);

        System.out.println(perceptron.calculateOutput(testInput[0]).getOutput());
        System.out.println(perceptron.calculateOutput(learnInput[1]).getOutput());
    }

}
