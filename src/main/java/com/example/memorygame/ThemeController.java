package com.example.memorygame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThemeController {

    private ArrayList<MemoryCard> defaultCards = new ArrayList<>();
    private ArrayList<MemoryCard> customCards = new ArrayList<>();
    private ArrayList<MemoryCard> cardsInGame = new ArrayList<>();

    @FXML
    void handleStartLevel1(ActionEvent event) {
        startGameWithLevel(event, 1);
    }

    @FXML
    void handleStartLevel2(ActionEvent event) {
        startGameWithLevel(event, 2);
    }

    @FXML
    void handleStartLevel3(ActionEvent event) {
        startGameWithLevel(event, 3);
    }

    @FXML
    void handleStartLevel4(ActionEvent event) {
        startGameWithLevel(event, 4); // ส่งข้อมูลด่าน 4
    }

    private void startGameWithLevel(ActionEvent event, int level) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("memory-game.fxml"));
            Parent root = fxmlLoader.load();
            MemoryGameController controller = fxmlLoader.getController();
            controller.setLevel(level); // ส่งระดับด่านไปยัง Controller

            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Memory Game");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.err.println("Error loading memory-game.fxml: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    void handleBackToMainMenu(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MainMenu.fxml"));
        Parent root = fxmlLoader.load();
        Scene mainMenuScene = new Scene(root, 800, 600);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Main Menu");
        stage.setScene(mainMenuScene);
        stage.show();
    }

}
