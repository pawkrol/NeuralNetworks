package org.pawkrol.academic.nn.zaj4;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import org.pawkrol.academic.nn.zaj4.network.KohonenPerceptron;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Canvas canvas;

    private GraphicsContext gc;
    private double widht;
    private double height;

    private KohonenPerceptron[][] lattice;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.RED);
        widht = canvas.getWidth();
        height = canvas.getHeight();

        Platform.runLater(this::fillCanvas);
    }

    public void setLattice(KohonenPerceptron[][] lattice){
        this.lattice = lattice;
    }

    private void fillCanvas(){
        int n = lattice.length;
        int m = lattice[0].length;
        KohonenPerceptron p;
        float[] weights;
        float x = 0, y = 0;
        double sizeX = widht / m;
        double sizeY = height / n;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                p = lattice[i][j];
                weights = p.getWeights();

                gc.setFill(Color.color(weights[0], weights[1], weights[2]));
                gc.fillRect(x, y, sizeX, sizeY);

                x += sizeX;
            }
            x = 0;
            y += sizeY;
        }
    }
}
