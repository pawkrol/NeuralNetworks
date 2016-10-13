/**
 * Created by Pawel on 2016-10-09.
 */
public class NeuralNetwork {

    public static void main(String[] args){
        Perceptron perceptron = new Perceptron(.2);
//        double[][] inputs = {
//                {0, 0}, {0, 1}, {1, 0}, {1, 1}
//        };
// //       int[] outputs = {0, 0, 0, 1}; //AND
//        int[] outputs = {1, 1, 1, 0}; //OR
        double[][] inputs = { {0}, {1} };
        int[] outputs = {1, 0};

        perceptron.learn(inputs, outputs, .1, 400);

        System.out.println(perceptron.output(new double[]{0}));
        System.out.println(perceptron.output(new double[]{1}));

//        System.out.println(perceptron.output(new double[]{0, 0}));
//        System.out.println(perceptron.output(new double[]{0, 1}));
//        System.out.println(perceptron.output(new double[]{1, 0}));
//        System.out.println(perceptron.output(new double[]{1, 1}));

        System.out.println(); ///////////////////////////////////////////////////////////////////

        Perceptron2 perceptron2 = new Perceptron2();

        float[][] inputs2 = {
                {-1, -1}, {-1, 1}, {1, -1}, {1, 1}
        };
//        float[] outputs2 = {-1, -1, -1, 1};
        float[] outputs2 = {1, 1, 1, -1};

        perceptron2.learn(inputs2, outputs2, .1f, 100);

        System.out.println(perceptron2.output(new float[]{-1, -1}));
        System.out.println(perceptron2.output(new float[]{-1, 1}));
        System.out.println(perceptron2.output(new float[]{1, -1}));
        System.out.println(perceptron2.output(new float[]{1, 1}));
    }

}
