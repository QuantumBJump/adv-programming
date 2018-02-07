package zoo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static ZooController zooControllerHandle;
    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("zooView.fxml"));

        Parent root = loader.load();
        zooControllerHandle = (ZooController)loader.getController();

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        zooControllerHandle.updateObservableLists();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
