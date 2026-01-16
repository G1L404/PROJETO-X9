package project.x9.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.AnchorPane;

public class LoginController {

    // O nome 'linkCadastro' deve ser igual ao fx:id da sua imagem 17
    @FXML
    private Hyperlink linkCadastro;
    @FXML // Adicione esta linha!
    private AnchorPane panePrincipal;

    // O nome do método deve ser o mesmo que você colocou em "On Action" no Scene Builder
    @FXML
    public void initialize() {
        // Isso tira o foco dos campos e joga para o fundo da tela
        Platform.runLater(() -> panePrincipal.requestFocus());
    }
    @FXML
    private void irParaCadastro() {
        System.out.println("Link clicado! Redirecionando...");
        // Aqui depois colocaremos o código para mudar de tela

    }

}