package project.x9;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import project.x9.view.GerenciadorTelas;
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        GerenciadorTelas.setStage(primaryStage);
        // Carregue a tela de login (caminho relativo dentro de resources)
        GerenciadorTelas.trocarTela("project/x9/login.fxml", "X9 Cidadão - Login");
        primaryStage.setMaximized(true); // se quiser abrir maximizado
    }



    public static void main(String[] args) {
        launch(args);
    }
}