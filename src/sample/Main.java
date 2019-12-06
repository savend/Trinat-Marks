package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Vector;

public class Main extends Application {

    private static final int MARK_FR = 0;
    private static final int MARK_DE = 1;
    private static final int MARK_CH = 2;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {


        System.out.println("Hello World");
        Mark mark = new Mark("Mathe", 5, 0.5);
        System.out.println("note fr : " + mark.getMark() + "\nnote de : " + mark.markConversion(MARK_DE) + "\nnote CH : " + mark.markConversion(MARK_CH));
        System.out.println(mark.toString());

        launch(args);

    }
}
