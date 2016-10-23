package org.pawkrol.academic.nn.common;

public class ErrorTimePair {

    private long time;
    private float error;

    public ErrorTimePair(float error, long time) {
        this.error = error;
        this.time = time;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public float getError() {
        return error;
    }

    public void setError(float error) {
        this.error = error;
    }
}
