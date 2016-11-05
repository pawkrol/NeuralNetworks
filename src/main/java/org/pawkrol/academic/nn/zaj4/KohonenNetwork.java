package org.pawkrol.academic.nn.zaj4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.pawkrol.academic.nn.zaj4.network.KohonenManager;

public class KohonenNetwork extends Application{

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
//        float[][] input = {
//                {0, 0, 0}, {0.57735f, 0, 0}, {0, 0.57735f, 0},
//                {0, 0, 0.57735f}, {0.57735f, 0.57735f, 0},
//                {0, 0.57735f, 0.57735f}, {0.57735f, 0, 0.57735f},
//                {0.57735f, 0.57735f, 0.57735f}
//        }; //8 colors normalized
        float[][] input = {
                {0, 0, 0}, {1, 0, 0}, {0, 1, 0},
                {0, 0, 1}, {1, 1, 0},
                {0, 1, 1}, {1, 0, 1},
                {1, 1, 1}
        }; //8 colors normalized

        KohonenManager kohonenManager = new KohonenManager(2, 4, 3);
        kohonenManager.learn(input, .9f, 1000);

        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = fxmlLoader.load(getClass().getClassLoader().getResource("zaj4.fxml").openStream());
        Controller controller = fxmlLoader.getController();
        controller.setLattice(kohonenManager.getLattice());

        primaryStage.setTitle("Neural Network - Paweł Król");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
