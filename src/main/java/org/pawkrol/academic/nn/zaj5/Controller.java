package org.pawkrol.academic.nn.zaj5;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    private final int ASYNC = 32;

    @FXML
    private Canvas canvas;

    @FXML
    private Button asyncButton;

    private HopfieldManager manager;
    private float[][] patterns;
    private float[] input;
    private int n = 16;
    private int m = 16;

    private GraphicsContext gc;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gc = canvas.getGraphicsContext2D();

        asyncButton.setText("Async " + ASYNC);

        Platform.runLater(() -> {
            input = patterns[new Random().nextInt(patterns.length)];
            manager.setOutputs(input);
            PatternSwoosher.swoosh(input, 4);
            makeGrid(input, n, m);
        });
    }

    public void setManager(HopfieldManager manager) {
        this.manager = manager;
    }

    public void setPatterns(float[][] patterns) {
        this.patterns = patterns;
    }

    private void makeGrid(float[] pattern, int n, int m){
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        float x = 0;
        float y = 0;
        float size = (float)canvas.getWidth() / n;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (pattern[i * n + j] == 1.f)
                    gc.setFill(Color.BLUE);
                else
                    gc.setFill(Color.WHITE);

                gc.fillRect(x, y, size, size);

                x += size;
            }
            x = 0;
            y += size;
        }
    }

    @FXML
    private void onAsyncButton(){
        input = manager.calcOutputAsync(input, ASYNC);
        makeGrid(input, n, m);
    }

    @FXML
    private void onSyncButton(){
        input = manager.calcOutputSync(input);
        makeGrid(input, n, m);
    }

    @FXML
    private void onCanvasClicked(){
        input = patterns[new Random().nextInt(patterns.length)];
        PatternSwoosher.swoosh(input, 4);
        makeGrid(input, n, m);
    }
}
