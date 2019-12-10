package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    private static final int MARK_FR = 0;
    private static final int MARK_DE = 1;
    private static final int MARK_CH = 2;

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        VBox root = new VBox();
        primaryStage.setTitle("Hello World");

        Exam physik = new Exam("physik");
        MarkInterface note = new MarkInterface(physik);
        MarkInterface note2 = new MarkInterface(physik);
        MarkInterface note3 = new MarkInterface(physik);
        Label average = new Label("average" + physik.getMark());
        root.getChildren().addAll(note, note2, note3, average);
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println(physik.toString());
                average.setText("average" + physik.getMark());
            }
        });
        primaryStage.setScene(new Scene(root, 1200, 500));
        primaryStage.show();


    }


    public static void main(String[] args) {


        System.out.println("salut");
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
