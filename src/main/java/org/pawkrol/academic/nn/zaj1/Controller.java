package org.pawkrol.academic.nn.zaj1;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import org.pawkrol.academic.nn.common.Perceptron;
import org.pawkrol.academic.nn.common.functions.BipolarFunction;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML
    private Canvas canvas;

    private GraphicsContext gc;
    private double width;
    private double height;

    private Random random;
    private Perceptron perceptron;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.width = canvas.getWidth();
        this.height = canvas.getHeight();

        random = new Random();
        perceptron = new Perceptron(new BipolarFunction());

        gc = canvas.getGraphicsContext2D();
        gc.setStroke(Color.RED);
        gc.setFill(Color.RED);

        gc.strokeLine(0, 0, width, f((float)width));

        learn();
    }

    public void onButton(){
        float x = random.nextFloat() * 1000;
        float y = random.nextFloat() * 1000;
        float o = perceptron.output(new float[]{x, y});

        paintPoint(x, y, o, false);
    }

    private void learn(){
        float inputs[][] = new float[1000][2];
        float outputs[] = new float[1000];

        for (int i = 0; i < 1000; i++){
            inputs[i][0] = random.nextFloat() * 1000;
            inputs[i][1] = random.nextFloat() * 1000;

            if ( inputs[i][1] > f(inputs[i][0])){
                outputs[i] = 1.f;
            } else {
                outputs[i] = -1.f;
            }
        }

        perceptron.learn(inputs, outputs, .6f, 400);

        for (int i = 0; i < 1000; i++) {
            paintPoint(inputs[i][0], inputs[i][1], outputs[i], true);
        }
    }

    private void paintPoint(float x, float y, float o, boolean learning){
        if (o > 0.f) {
            if (learning)
                gc.setStroke(Color.BLUE);
            else
                gc.setStroke(Color.YELLOW);
        } else {
            if (learning)
                gc.setStroke(Color.RED);
            else
                gc.setStroke(Color.GREEN);
        }

        gc.strokeOval(x - 2f, y - 2f, 4f, 4f);
    }

    private float f(float x){
        return (float)(height / width) * x;
    }

//    private void createContent(){
//
//        Perceptron perceptron = new Perceptron();
//
//        float[][] inputs = {
//                {-1, -1}, {-1, 1}, {1, -1}, {1, 1}
//        };
////        float[] outputs = {-1, -1, -1, 1};
//        float[] outputs = {1, 1, 1, -1};
//
//        perceptron.learn(inputs, outputs, .1f, 100);
//
//        System.out.println(perceptron.output(new float[]{-1, -1}));
//        System.out.println(perceptron.output(new float[]{-1, 1}));
//        System.out.println(perceptron.output(new float[]{1, -1}));
//        System.out.println(perceptron.output(new float[]{1, 1}));
//    }


}
