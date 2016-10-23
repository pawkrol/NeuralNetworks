package org.pawkrol.academic.nn.common.functions;

/**
 * Created by pawkrol on 10/22/16.
 */
public class BipolarFunction implements ActivationFunction{

    @Override
    public float f(float x) {
        if (x >= 0)
            return 1;
        else
            return -1;
    }

    @Override
    public float df(float x) {
        return 0;
    }
}
