package project.x9;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // O caminho "/login.fxml" aponta para a pasta src/main/resources
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));

        primaryStage.setTitle("X9 Cidadão - Login");

        // Define o tamanho da janela (ajuste conforme seu design)
        Scene scene = new Scene(root, 1366, 768);

        primaryStage.setScene(scene);
        primaryStage.setResizable(true); // Impede que o usuário redimensione e quebre o layout
        primaryStage.show();
        primaryStage.setMaximized(true);
    }

    public static void main(String[] args) {
        launch(args);
    }
}