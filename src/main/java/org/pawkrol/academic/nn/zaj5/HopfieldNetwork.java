package org.pawkrol.academic.nn.zaj5;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class HopfieldNetwork extends Application{

    public static void main(String[] args){
        launch(args);
    }

    private static float[][] getPatterns() throws URISyntaxException, IOException {
        File screens = new File(HopfieldNetwork.class.getClassLoader().getResource("chars/").toURI());

        String[] files = screens.list();
        if (files == null) return null;

        System.out.println("Loading patterns...");
        float[][] patterns = new float[files.length][];
        for (int i = 0; i < files.length; i++){
            System.out.println(HopfieldNetwork.class.getResource("/chars/" + files[i]));
            patterns[i] = readDataFromImage("/chars/" + files[i]);
        }
        System.out.println("done!");

        return patterns;
    }

    private static float[] readDataFromImage(String file) throws IOException {
        BufferedImage img = ImageIO.read(HopfieldNetwork.class.getResource(file));

        float[] buff = new float[img.getWidth() * img.getHeight()];
        int b = 0;
        for (int j = 0; j < img.getHeight(); j++){
            for (int i = 0; i < img.getWidth(); i++){
                int rgb = img.getRGB(i, j);
                int r = (rgb & 0x00ff0000) >> 16; //assume its only white or black

                buff[b++] = (r == 255) ? -1.f : 1.f;
            }
        }

        return buff;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        float[][] patterns = null;

        try {
            patterns = getPatterns();
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }

        if (patterns == null) throw new Exception("Patterns cannot be loaded!");

        HopfieldManager hopfieldManager = new HopfieldManager(16 * 16);
        hopfieldManager.learn(patterns);

        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = fxmlLoader.load(getClass().getClassLoader().getResource("zaj5.fxml").openStream());
        Controller controller = fxmlLoader.getController();
        controller.setManager(hopfieldManager);
        controller.setPatterns(patterns);

        primaryStage.setTitle("Neural Network - Paweł Król");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
