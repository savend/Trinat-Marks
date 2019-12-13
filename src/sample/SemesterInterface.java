package sample;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SemesterInterface extends Parent {


    private static final int MARK_FR = 0;
    private static final int MARK_DE = 1;
    private static final int MARK_CH = 2;

    //public Subject subject = new Subject();
    private ArrayList<SubjectInterface> subjectInterfaceArrayList = new ArrayList<>(); //Array of all Subjects


    /*------CLASS-----*/
    //EventHandler Class to assign specific event to every DeleteButton -----


    class DeleteButtonEvent implements EventHandler<ActionEvent> {

        private final int number;
        HBox hbox;

        //Constructor of DeleteButtonEvent
        DeleteButtonEvent(int number, HBox box) {
            this.hbox = box;
            this.number = number;
        }

        //EventHandler for every button
        @Override
        public void handle(ActionEvent event) {
            subjectInterfaceArrayList.remove(number);
            generateHBox(hbox, subjectInterfaceArrayList);
        }
    }


    /*------CONSTRUCTOR------*/


    public SemesterInterface() {

        System.out.println("Constructor of SemesterInterface");


        //------LAYOUTS-------


        //Layout Page
        VBox vBox = new VBox(10);
        vBox.setStyle("-fx-border-color: red;\n" + "-fx-border-insets: 5;\n" + "-fx-border-width: 1;\n");

        //Layout Title line
        HBox hBoxTitleButton = new HBox(30);
        hBoxTitleButton.setAlignment(Pos.CENTER_LEFT);

        //Layout Subtitles
        HBox hBoxSubtitle = new HBox(30);
        hBoxSubtitle.setAlignment(Pos.BOTTOM_LEFT);

        //Layout Exams
        HBox hBoxMarks = new HBox();
        hBoxMarks.setStyle("-fx-border-color: red;\n" + "-fx-border-insets: 5;\n" + "-fx-border-width: 1;\n");


        //-------LABELS--------

        Label title = new Label("Semester 1.");
        title.setStyle("-fx-font: 30 berlin; -fx-font-weight: bold;");


        //------BUTTONS------

        Button newExamButton = new Button("Add Subject");

        newExamButton.setOnAction(e -> {

            subjectInterfaceArrayList.add(new SubjectInterface());
            generateHBox(hBoxMarks, subjectInterfaceArrayList);

        });


        //-------ADD DEFAULT EXAM------

        subjectInterfaceArrayList.add(new SubjectInterface());
        generateHBox(hBoxMarks, subjectInterfaceArrayList);


        //--------ADD ELEMENTS TO LAYOUTS------

        hBoxTitleButton.getChildren().addAll(title, newExamButton);
        vBox.getChildren().addAll(hBoxTitleButton, hBoxMarks, hBoxSubtitle);
        this.getChildren().add(vBox);
    }


    /*--------METHODS--------*/


    //create Delete Button with specific eventHandler for every button
    public Button createDeleteButton(int number, HBox hBox) {
        Button deleteButton = new Button("Delete Subject");
        deleteButton.setOnAction(new DeleteButtonEvent(number, hBox));
        return deleteButton;
    }

    //update box with all exams
    public void generateHBox(HBox hBox, ArrayList<SubjectInterface> subjectInterfaceArrayList) {
        hBox.getChildren().clear();
        for (int i = 0; i < subjectInterfaceArrayList.size(); i++) {
            VBox vBox = new VBox();
            vBox.setStyle("-fx-border-color: black;\n" + "-fx-border-insets: 5;\n" + "-fx-border-width: 1;\n");
            vBox.getChildren().add(createDeleteButton(i, hBox));
            vBox.getChildren().add(subjectInterfaceArrayList.get(i));
            hBox.getChildren().add(vBox);
        }
    }

}
