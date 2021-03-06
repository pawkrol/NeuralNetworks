package org.pawkrol.academic.nn.zaj1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Pawel on 2016-10-09.
 */
public class NeuralNetwork extends Application{

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("zaj1.fxml"));
        primaryStage.setTitle("Neural Network - Paweł Król");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
