package com.example.dl_fx.controller.main;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    private static final String FXML_PACKAGE = "/com/example/dl_fx/";

    public String getFxmlPackage() {
        return FXML_PACKAGE;
    }

    public void nextPage(Button button, String title, String pageLocation) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource(pageLocation));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        Stage stage = (Stage) button.getScene().getWindow();
        stage.setTitle(title);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
}
