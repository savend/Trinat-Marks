package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.control.ScrollBar;

public class Main extends Application {

    private static final int MARK_FR = 0;
    private static final int MARK_DE = 1;
    private static final int MARK_CH = 2;

    public static Label globalErrors = new Label("No Error");


    @Override
    public void start(Stage primaryStage) throws Exception {


    	VBox content = new VBox(5);

    	Pane root = new Pane();

    	ScrollPane scroller = new ScrollPane(content);
        scroller.setFitToWidth(true);

        primaryStage.setTitle("Trinat Marks (in development)");


        SemesterInterface semester1 = Read.read();

        //----PROGRAMMTITEL----
        HBox titelBoxLeft = new HBox();
        HBox titelBoxRight = new HBox();
        HBox titelBoxGeneral = new HBox();

        Image logo = new Image("file:logo_trinational.jpg");
        ImageView logoView = new ImageView();
        logoView.setImage(logo);


        Label titel = new Label("Notenberechnung");
        titel.setStyle("-fx-font: 45 berlin; -fx-font-weight: bold;");
        titel.setMinWidth(450);

        titelBoxLeft.getChildren().add(titel);
        titelBoxLeft.setAlignment(Pos.TOP_LEFT);
        titelBoxRight.getChildren().add(logoView);
        titelBoxRight.setAlignment(Pos.TOP_RIGHT);
        titelBoxGeneral.getChildren().addAll(titelBoxLeft, titelBoxRight);


        SemesterInterface semester1 = Read.read();


        HBox errorHBox = new HBox();
        Label errorLine = new Label("Error Line : ");
        errorHBox.getChildren().addAll(errorLine, globalErrors);
        errorHBox.setPrefHeight(10);

        content.getChildren().addAll( titelBoxGeneral, semester1, root, errorHBox);
        content.setStyle("-fx-background-color: white;");


        primaryStage.setScene(new Scene(new BorderPane(scroller, null, null, null, null), 1000, 625));

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
