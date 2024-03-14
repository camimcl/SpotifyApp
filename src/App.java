import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class App extends Application{
    public static void main(String[] args) throws Exception {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("SpotifyApp");
        stage.getIcons().add(new Image("file:src\\assets\\icons8-spotify-48.png"));

        Parent root = FXMLLoader.load(getClass().getResource("view/TelaSelect.fxml"));

        Scene scene = new Scene(root);

        String css =this.getClass().getResource("style/style.css").toExternalForm();
        scene.getStylesheets().add(css);

        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
}
