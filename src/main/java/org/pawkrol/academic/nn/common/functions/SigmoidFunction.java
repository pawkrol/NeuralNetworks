package org.pawkrol.academic.nn.common.functions;

/**
 * Created by pawkrol on 10/22/16.
 */
public class SigmoidFunction implements ActivationFunction{

    public float f(float x) {
        return (float)(1 / (1 + Math.exp(-x)));
    }

}
