package project.x9.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import project.x9.view.Alerts;
import project.x9.view.GerenciadorTelas;

public class LoginController {

    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField txtSenha;

    @FXML
    private Button btnEntrar;

    @FXML
    private Hyperlink linkCadastro;
    @FXML
    private AnchorPane panePrincipal;

    // O nome do método deve ser o mesmo que você colocou em "On Action" no Scene Builder
    @FXML
    public void initialize() {
        // Isso tira o foco dos campos e joga para o fundo da tela
        Platform.runLater(() -> panePrincipal.requestFocus());
    }

    @FXML
    private void fazerLogin(){
        //Recebe o que o usuario digitou
        String email = txtEmail.getText();
        String senha = txtSenha.getText();

        System.out.println("Tentativa de Login: " + email);
        if (email.isEmpty() || senha.isEmpty()){
            Alerts.mostarErro("Campos Vazios", "Por favor, preencha e-mail e senha!");
            return;
        }
        //Simulação do login (Atualizar depois com dados do banco) e mandar pra pagina inicial
        if (email.equals("admin") && senha.equals("123")){
            System.out.println("Login Autorizado");
            Alerts.mostrarSucesso("Acesso Sucedido", "Bem vindo ao X9 Cidadão");
        }
        else {
            Alerts.mostarErro("Acesso Negado", "Usuario ou Senha incorretos.");
        }
    }

    @FXML
    private void irParaCadastro() {
        System.out.println("Link clicado! Redirecionando...");
        // Aqui depois colocaremos o código para mudar de tela
        //GerenciarTelas.irCadastro()
    }

}