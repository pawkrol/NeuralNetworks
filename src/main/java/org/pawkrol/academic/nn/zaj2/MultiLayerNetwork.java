package org.pawkrol.academic.nn.zaj2;

import org.pawkrol.academic.nn.common.MultilayerManager;
import org.pawkrol.academic.nn.common.functions.SigmoidFunction;

/**
 * Created by pawkrol on 10/22/16.
 */
public class MultiLayerNetwork {

    public static void main(String[] args){
        MultilayerManager manager = new MultilayerManager(
                2,
                new int[]{2, 1},
                .6f,
                new SigmoidFunction()
        );

        float[][] input = { {0, 0}, {0, 1}, {1, 0}, {1, 1} };
        float[] output = { 0, 1, 1, 0 };

        for (int j = 0; j < 10000; j++) {
            for (int i = 0; i < input.length; i++)
                manager.learnWithBP(input[i], new float[]{output[i]});
        }

        System.out.println("{0, 0} => " + Math.round(manager.output(new float[]{0, 0})[0]));
        System.out.println("{0, 1} => " + Math.round(manager.output(new float[]{0, 1})[0]));
        System.out.println("{1, 0} => " + Math.round(manager.output(new float[]{1, 0})[0]));
        System.out.println("{1, 1} => " + Math.round(manager.output(new float[]{1, 1})[0]));

    }
}
