package org.pawkrol.academic.nn.zaj2;

/**
 * Created by pawkrol on 10/15/16.
 */
public class OneLayerNetwork {

    public static void main(String[] args){
        float[][] input = {
                {0.64f, 0.56f, 0f},
                {0.68f, 0.32f, 0.23f},
                {0.82f, 0.17f, 0.15f},
                {0.59f, 0f, 0.58f},
                {0.68f, 0.15f, 0.65f},
                {0.64f, 0.68f, 0.65f},
                {0.73f, 0.34f, 0.77f},
                {0.77f, 0.29f, 0.92f},
                {0.86f, 0.27f, 0.88f},
                {1f, 0.17f, 0.73f},
                {1f, 0.12f, 0.54f},
                {0.86f, 0.59f, 0.5f},
                {0.64f, 0.56f, 0.62f},
                {0.64f, 0.54f, 0.62f},
                {0.68f, 0.2f, 0.54f},
                {0.82f, 0.1f, 0.54f},
                {0.82f, 0.39f, 0.62f},
                {0.86f, 0.12f, 0.5f},
                {0.64f, 0.59f, 0.65f},
                {0.59f, 0.17f, 0.77f},
                {0.64f, 0.05f, 0.62f},
                {0.64f, 0.29f, 0.46f},
                {0.55f, 0f, 0.69f},
                {0.59f, 0.12f, 0.69f},
                {0.68f, 0.22f, 0.54f},
                {0.68f, 0.12f, 0.62f},
                {0.82f, 0.1f, 0.46f},
                {0.86f, 0.46f, 0.42f},
                {0.77f, 0.66f, 0.38f},
                {0.59f, 0.71f, 0.19f},
                {0.45f, 0.39f, 0.69f},
                {0.5f, 0.66f, 0.77f},
                {0.55f, 0.8f, 0.62f},
                {0.55f, 0.71f, 0.65f},
                {0.59f, 0.68f, 0.73f},
                {0.64f, 0.39f, 0.69f},
                {0.64f, 0.22f, 0.58f},
                {0.73f, 0.1f, 0.58f},
                {0.68f, 0.17f, 0.62f},
                {0.77f, 0.24f, 0.65f},
                {0.82f, 0.59f, 0.62f},
                {0.86f, 0.71f, 0.62f},
                {0.86f, 0.56f, 0.58f},
                {0.73f, 0.78f, 0.54f},
                {0.82f, 0.73f, 0.5f},
                {0.77f, 0.41f, 0.5f},
                {0.86f, 0.61f, 0.46f},
                {0.68f, 0.66f, 0.5f},
                {0.59f, 0.27f, 0.65f},
                {0.73f, 0.27f, 0.58f},
                {0.86f, 0.32f, 0.5f},
                {0.86f, 0.34f, 0.46f},
                {0.55f, 0.8f, 0.77f},
                {0.59f, 0.32f, 0.96f},
                {0.68f, 0.22f, 0.77f},
                {0.73f, 0.46f, 0.58f},
                {0.36f, 0.9f, 0.62f},
                {0.41f, 0.68f, 0.77f},
                {0.36f, 0.37f, 0.88f},
                {0.55f, 0.61f, 0.85f},
                {0.64f, 0.61f, 0.77f},
                {0.64f, 0.32f, 0.77f},
                {0.59f, 0.39f, 0.62f},
                {0.55f, 0.54f, 0.46f},
                {0.55f, 0.29f, 0.42f},
                {0.64f, 0.27f, 0.46f},
                {0.73f, 0.34f, 0.58f},
                {0.68f, 0.73f, 0.62f},
                {0.55f, 0.83f, 0.85f},
                {0.59f, 0.49f, 0.96f},
                {0.68f, 0.44f, 0.96f},
                {0.64f, 0.41f, 0.92f},
                {0.68f, 0.32f, 0.85f},
                {0.73f, 0.32f, 0.81f},
                {0.77f, 0.37f, 0.69f},
                {0.77f, 0.56f, 0.58f},
                {0.64f, 0.34f, 0.81f},
                {0.45f, 0.34f, 0.92f},
                {0.59f, 0.34f, 0.77f},
                {0.64f, 0.37f, 0.73f},
                {0.64f, 0.46f, 0.69f},
                {0.68f, 0.32f, 0.5f},
                {0.59f, 0.73f, 0.42f},
                {0.59f, 0.88f, 0.81f},
                {0.68f, 0.71f, 0.92f},
                {0.73f, 0.51f, 0.65f},
                {0.73f, 0.41f, 0.62f},
                {0.73f, 0.46f, 0.65f},
                {0.73f, 0.44f, 0.69f},
                {0.73f, 0.37f, 0.77f},
                {0.73f, 0.34f, 0.69f},
                {0.59f, 0.37f, 0.65f},
                {0.55f, 0.37f, 0.62f},
                {0.64f, 0.37f, 0.5f},
                {0.55f, 0.93f, 0.38f},
                {0.41f, 1f, 0.46f},
                {0.32f, 0.98f, 0.46f},
                {0.32f, 0.41f, 0.54f},
                {0.27f, 0.73f, 0.65f},
                {0.23f, 0.71f, 0.81f}
        };

        float[][] output = {
                {//Punkt rosy
                        0.67f,0.67f,0.73f,0.4f,0.6f,0.8f,0.73f,0.73f,0.93f,1f,0.93f,1f,0.73f,0.73f,0.6f,
                        0.73f,0.93f,0.8f,0.73f,0.4f,0.47f,0.53f,0.27f,0.4f,0.6f,0.6f,0.8f,1f,0.93f,0.8f,
                        0.53f,0.6f,0.73f,0.73f,0.73f,0.6f,0.53f,0.6f,0.6f,0.8f,0.93f,1f,1f,1f,1f,0.87f,
                        0.93f,0.87f,0.53f,0.67f,0.93f,0.93f,0.73f,0.53f,0.6f,0.8f,0.53f,0.47f,0.33f,0.67f,
                        0.8f,0.6f,0.53f,0.53f,0.4f,0.53f,0.73f,0.87f,0.73f,0.67f,0.73f,0.6f,0.67f,0.73f,
                        0.87f,0.87f,0.6f,0.4f,0.53f,0.6f,0.67f,0.67f,0.73f,0.73f,0.87f,0.73f,0.73f,0.73f,
                        0.73f,0.73f,0.67f,0.6f,0.53f,0.67f,0.87f,0.67f,0.53f,0.27f,0.33f,0.27f,
                },
                {//Widzialność
                        0.19f,0.12f,0.31f,0.35f,0.42f,0.31f,0.23f,0.38f,0.42f,0.38f,0.42f,0.35f,0.31f,
                        0.27f,0.27f,0.35f,0.42f,0.31f,0.23f,0.35f,0.38f,0.23f,0.23f,0.54f,0.35f,0.23f,
                        0.54f,0.42f,0.23f,0.15f,0.19f,0.23f,0.27f,0.31f,0.35f,0.31f,0.35f,0.46f,0.35f,
                        0.38f,0.42f,0.19f,0.35f,0.19f,0.15f,0.27f,0.38f,0.19f,0.38f,0.38f,0.38f,0.46f,
                        0.31f,0.19f,1f,0.38f,0.15f,0.27f,0.23f,0.46f,0.27f,0.31f,0.38f,0.38f,0.27f,0.58f,
                        0.5f,0.31f,0.15f,0.15f,0.31f,0.42f,0.69f,0.62f,0.5f,0.38f,0.19f,0.65f,0.58f,0.38f,
                        0.27f,0.23f,0.31f,0.31f,0.27f,0.12f,0.38f,0.23f,0.27f,0.31f,0.35f,0.35f,0.88f,0.42f,
                        0.04f,0f,0.08f,0.27f,0.27f,0.31f
                }
        };

        Layer layer = new Layer(2);
        layer.learn(input, output, .6f, 700);

        float[] out;

        out = layer.output(new float[]{0.27f, 0.59f, 0.62f});
        System.out.println(out[0] + ", " + out[1]); //0.38, 0.2

        out = layer.output(new float[]{0.09f, 0.66f, 0.81f});
        System.out.println(out[0] + ", " + out[1]); //0.31,	0

        out = layer.output(new float[]{0f, 0.76f, 0.77f});
        System.out.println(out[0] + ", " + out[1]); //0.35, 0

        out = layer.output(new float[]{0.14f, 0.93f, 0.54f});
        System.out.println(out[0] + ", " + out[1]); //0.12, 0.2
    }

}
