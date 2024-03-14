package Controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import musicaspackage.Musicas;

//classe para controlar fluxo de telas
public class ControllerPrincipal {


   
    //levar para tela de atualizacao + chama o controller da classe pra passar info do cliente 
    public void abrirTelaUpdate(ActionEvent event, Musicas musicaSelecionada) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/TelaUpdateMusica.fxml"));
        
        Parent root = loader.load();

        //acesso ao cotroller da tela p passar informacao
        TelaUpdateMusicaController controller = loader.getController();
        controller.receberMusica(musicaSelecionada);
    
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);

        String css =this.getClass().getResource("../style/style.css").toExternalForm();
        scene.getStylesheets().add(css);

        stage.setScene(scene);
        stage.show();
    }

    //levar para tela de cadastro
    public void abrirTelaCadastro(ActionEvent event) throws IOException{ 
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/TelaDeCadastro.fxml"));

        Parent root = loader.load();

        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);

        String css =this.getClass().getResource("../style/style.css").toExternalForm();
        scene.getStylesheets().add(css);

        stage.setScene(scene);
        stage.show();
    }
    
    //levar para tela de selecao
    public void abrirTelaSelect(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/TelaSelect.fxml"));

        Parent root = loader.load();
        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);

        //adicao de estilizacao para scene
        String css =this.getClass().getResource("../style/style.css").toExternalForm();
        scene.getStylesheets().add(css);

        stage.setScene(scene);
        stage.show();
    }
}
