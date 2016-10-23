package org.pawkrol.academic.nn.common.functions;

/**
 * Created by pawkrol on 10/22/16.
 */
public interface ActivationFunction {
    float f(float x);
    float df(float x);
}
