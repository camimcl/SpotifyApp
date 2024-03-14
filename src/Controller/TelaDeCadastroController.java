package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import musicaspackage.Musicas;
import java.io.File;
import java.io.IOException;


import Model.Db4oManager;

public class TelaDeCadastroController{
    
    @FXML
    private TextField albumContainer;
    @FXML
    private Pane pane;
    @FXML
    private TextField nameContainer;
    @FXML
    private Button botaoSelecionarImagem;
    @FXML
    private TextField artistaContainer;

    ControllerPrincipal controllerPrincipal = new ControllerPrincipal();

    private Db4oManager dbManager = Db4oManager.getInstance();
    String caminhoDaImagem ;
    String selectedMusic="";
   
  
     @FXML
    private void selecionarImagem() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Selecione uma imagem");
        Stage stage = (Stage) botaoSelecionarImagem.getScene().getWindow();
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            caminhoDaImagem = file.getAbsolutePath();
            exibirImagem(caminhoDaImagem);
        }
    }
    @FXML
    private void escolherAudio(){
        FileChooser audioChooser = new FileChooser();
        audioChooser.setTitle("Escolha um áudio");
        File file = audioChooser.showOpenDialog(null);
        if (file != null) {
            selectedMusic = file.toURI().toString();
        }
    }


    private void exibirImagem(String caminhoDaImagem) {
        pane.getChildren().clear();
        Image imagem = new Image("file:" + caminhoDaImagem);
        ImageView imageView = new ImageView(imagem);
        // Define o tamanho da ImageView 
        imageView.setFitWidth(153); 
        imageView.setFitHeight(140); 
        // Adiciona a ImageView a um Pane 
        pane.getChildren().add(imageView);
         // Centralizar o ImageView dentro do Pane
         imageView.layoutXProperty().bind(pane.widthProperty().subtract(imageView.fitWidthProperty()).divide(2));
         imageView.layoutYProperty().bind(pane.heightProperty().subtract(imageView.fitHeightProperty()).divide(2));
 
    }

    public void voltar(ActionEvent event) throws IOException{
        controllerPrincipal.abrirTelaSelect(event);
    }

    //pegar informacoes do novo cliente e mandar pro banco 
    public void fazerCadastro(ActionEvent event) throws IOException{
        String nome = nameContainer.getText();
        String album = albumContainer.getText();
        String artista = artistaContainer.getText();
        
        Musicas musica = new Musicas(nome,album,artista);
      
        musica.setCaminhoImagem(caminhoDaImagem);
        musica.setCaminhoAudio(selectedMusic);
        
        dbManager.inserirMusica(musica);
        System.out.println(musica.getCaminhoAudio());
        controllerPrincipal.abrirTelaSelect(event);
    }
        
}
