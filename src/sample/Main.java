package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {

    private static final int MARK_FR = 0;
    private static final int MARK_DE = 1;
    private static final int MARK_CH = 2;

    public static Label globalErrors = new Label("No Error");

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        BorderPane root = new BorderPane();

        primaryStage.setTitle("Trinat Marks (in development)");


        SemesterInterface semester1 = Read.read();

        HBox errorHBox = new HBox();
        Label errorLine = new Label("Error Line : ");
        errorHBox.getChildren().addAll(errorLine, globalErrors);
        errorHBox.setPrefHeight(10);

        root.setLeft(semester1);

        root.setBottom(errorHBox);

        System.out.println("THREAD : " + Thread.currentThread().getName() + Thread.currentThread().getState());
        //root.getChildren().addAll(semester1, errorHBox);
        primaryStage.setScene(new Scene(root, 1200, 500));
        primaryStage.show();

    }


    public static void main(String[] args) {


		/*System.out.println("HellWorld");
		Mark mark = new Mark("Mathe", 5, 0.5); //creation of a simple mark
		Mark manote = new Mark("Transformation", 5, 0.5);
		System.out.println("note fr : " + mark.getMark() + "\nnote de : " + mark.markConversion(MARK_DE) + "\nnote CH : " + mark.markConversion(MARK_CH)); //display all language of the mark
		System.out.println(mark.toString()); //display Object caracteristics of the mark

		Exam mathe = new Exam("Mathe"); //building new Exam

		mathe.addMark(new Mark("kurztest", 6, MARK_CH, 0.2)); //add mark to Exam
		mathe.addMark(new Mark("test", 5, MARK_CH, 0.4));
		mathe.addMark(new Mark("test2", 4, MARK_CH, 0.4));



		//btn.set.on.action ->
		FileWriter fileWriter = new FileWriter("data.txt");
		PrintWriter printWriter = new PrintWriter(fileWriter);
		Save.save(mathe, printWriter);
		printWriter.close();

		System.out.println(mathe.getMark() + " DE : " + mathe.markConversion(MARK_DE)); //display average of the Exam in FRENch and German
        */
		launch(args);



    }
}
