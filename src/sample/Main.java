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
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {


        System.out.println("Hello World");
        Mark mark = new Mark("Mathe", 5, 0.5); //creation of a simple mark
        System.out.println("note fr : " + mark.getMark() + "\nnote de : " + mark.markConversion(MARK_DE) + "\nnote CH : " + mark.markConversion(MARK_CH)); //display all language of the mark
        System.out.println(mark.toString()); //display Object caracteristics of the mark

        Exam mathe = new Exam("Mathe"); //building new Exam
        mathe.addMark(new Mark("kurztest", 6, MARK_CH, 0.2)); //add mark to Exam
        mathe.addMark(new Mark("test", 5, MARK_CH, 0.4));
        mathe.addMark(new Mark("test2", 4, MARK_CH, 0.4));
        System.out.println(mathe.getMark() + " DE : " + mathe.markConversion(MARK_DE)); //display average of the Exam in FRENch and German
        launch(args);

    }
}
