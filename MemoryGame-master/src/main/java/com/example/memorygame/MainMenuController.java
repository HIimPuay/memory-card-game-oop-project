package com.example.memorygame;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainMenuController {

    @FXML
    private void handleStartGame(ActionEvent event) {
        try {
            // โหลด FXML ของ Memory Game
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("memory-game.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            // นำ Stage (หน้าต่างปัจจุบัน) มาจาก ActionEvent
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // เปลี่ยน Scene ไปที่ Memory Game
            stage.setTitle("Memory Game");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            // จัดการข้อผิดพลาดหากไม่สามารถโหลด FXML ได้
            System.err.println("Error loading memory-game.fxml: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    private void handleViewHighScores(ActionEvent event) {
        System.out.println("Viewing High Scores...");
        // Add logic to display High Scores
    }

    @FXML
    private void handleExit(ActionEvent event) {
        System.out.println("Exiting Game...");
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.close();
    }
}
