import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import java.io.File;

public class JavaFx extends Main {

    private File selectedFile;

    @Override
    public void start(Stage primaryStage) {
        // Título da janela
        primaryStage.setTitle("Escolha e Envie um Arquivo");

        // Label para mostrar o nome do arquivo selecionado
        Label fileLabel = new Label("Nenhum arquivo selecionado");

        // Botão para escolher o arquivo
        Button chooseFileButton = new Button("Escolher Arquivo");
        chooseFileButton.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Escolher Arquivo");
            // Definir o filtro para arquivos (opcional)
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Todos os Arquivos", "*.*"),
                    new FileChooser.ExtensionFilter("Arquivos de Texto", "*.txt"),
                    new FileChooser.ExtensionFilter("Imagens", "*.png", "*.jpg", "*.gif")
            );

            // Mostrar a janela para selecionar o arquivo
            selectedFile = fileChooser.showOpenDialog(primaryStage);
            if (selectedFile != null) {
                fileLabel.setText("Arquivo Selecionado: " + selectedFile.getName());
            }
        });

        // Botão para enviar o arquivo (simulado)
        Button sendFileButton = new Button("Enviar Arquivo");
        sendFileButton.setOnAction(e -> {
            if (selectedFile != null) {
                System.out.println("Arquivo enviado: " + selectedFile.getAbsolutePath());
                // Aqui você pode adicionar o código para "enviar" o arquivo, por exemplo, fazer upload
            } else {
                System.out.println("Nenhum arquivo selecionado para enviar.");
            }
        });

        // Layout simples vertical
        VBox layout = new VBox(10);
        layout.getChildren().addAll(fileLabel, chooseFileButton, sendFileButton);

        // Definir a cena e mostrar a janela
        Scene scene = new Scene(layout, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
