package com.mycompany.jadwalpiketkelas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/HomePageView.fxml"));
            Scene scene = new Scene(loader.load());
            stage.setTitle("📅 Jadwal Piket Kelas");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.err.println("❌ Gagal memuat FXML! Pastikan file 'HomePageView.fxml' ada di folder: src/main/resources/view/");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
