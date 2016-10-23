package org.pawkrol.academic.nn.zaj1;

import javafx.application.Platform;
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

    private final int POINTS_AT_CLICK = 1000;

    @FXML
    private Canvas canvas;

    private GraphicsContext gc;
    private double width;
    private double height;

    private Random random;
    private Perceptron perceptron;
    private SinglePerceptronLearner learner;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.width = canvas.getWidth();
        this.height = canvas.getHeight();

        random = new Random();
        perceptron = new Perceptron(2, new BipolarFunction());
        learner = new SinglePerceptronLearner();

        gc = canvas.getGraphicsContext2D();
        gc.setStroke(Color.RED);
        gc.setFill(Color.RED);

        gc.strokeLine(0, 0, width, height);

        Platform.runLater(this::learn);
    }

    public void onButton(){
        Platform.runLater(() -> {
            for (int i = 0; i < POINTS_AT_CLICK; i++) {
                float x = random.nextFloat() * 1000;
                float y = random.nextFloat() * 1000;
                float o = perceptron.calculateOutput(new float[]{x, y}).getOutput();

                paintPoint(x, y, o, false);
            }
        });
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

        learner.learn(perceptron, inputs, outputs, .6f, 0.00001, 1000);

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

}
