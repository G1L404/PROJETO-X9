package project.x9.view;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import project.x9.Main; // Importando sua classe Main para pegar o recurso

import java.io.IOException;

    public class GerenciadorTelas {

        private static Stage stageAtual;

        // O Main chama isso quando o programa começa, para a gente ter controle da janela
        public static void setStage(Stage stage) {
            stageAtual = stage;
        }

        // Método genérico para trocar de tela
        public static void trocarTela(String nomeArquivoFxml, String tituloJanela) {
            try {
                // O "/" antes do nome é importante para achar o arquivo na pasta resources
                FXMLLoader loader = new FXMLLoader(Main.class.getResource("/" + nomeArquivoFxml));
                Parent root = loader.load();

                Scene scene = new Scene(root);
                stageAtual.setScene(scene);
                stageAtual.setTitle(tituloJanela);
                stageAtual.show();

            } catch (IOException e) {
                System.out.println("Erro ao abrir a tela: " + nomeArquivoFxml);
                e.printStackTrace();
            }
        }
    }

