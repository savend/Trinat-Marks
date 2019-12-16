package sample;

import java.util.ArrayList;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SubjectInterface extends Parent {


    private static final int MARK_FR = 0;
    private static final int MARK_DE = 1;
    private static final int MARK_CH = 2;

    private Subject subject = new Subject();
    private ArrayList<ExamInterface> examInterfaceArrayList = new ArrayList<>(); //Array of all Exams
    private HBox hBoxMarks = new HBox();

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
            examInterfaceArrayList.remove(number);
            subject.deleteMark(number);
            generateHBox(examInterfaceArrayList);
        }
    }


    /*------CONSTRUCTOR------*/


    public SubjectInterface() {
        Platform.runLater(() -> {


            System.out.println("Constructor of SubjectInterface");


            //------LAYOUTS-------


            //Layout Page
            VBox vBox = new VBox(10);


            //Layout Title line
            HBox hBoxTitleButton = new HBox(30);
            hBoxTitleButton.setAlignment(Pos.CENTER_LEFT);

            //Layout Subtitles
            HBox hBoxSubtitle = new HBox(30);
            hBoxSubtitle.setAlignment(Pos.BOTTOM_LEFT);

            //Layout Exams
            hBoxMarks.setPadding(new Insets(10, 10, 10, 10));


            //-------TEXTFIELD--------

            TextField subjectName = new TextField();
            subjectName.setStyle("-fx-font: 30 berlin; -fx-font-weight: bold;");
            subjectName.setText(subject.getMarkName());

            subjectName.textProperty().addListener((observable, oldValue, newValue) -> subject.setMarkName(subjectName.getText()));

            subjectName.setStyle("-fx-font: 20 berlin; -fx-font-weight: bold;");
            subjectName.setPrefWidth(220);


            //------AVERAGE LINE------

            MarkInterface subjectAverage = new MarkInterface(subject);


            //------BUTTONS------

            Button newExamButton = new Button("Add Exam");

            newExamButton.setOnAction(e -> {

                examInterfaceArrayList.add(new ExamInterface(subject));
                generateHBox(examInterfaceArrayList);

            });


            //-------ADD DEFAULT EXAM------

            //examInterfaceArrayList.add(new ExamInterface(subject));
            //generateHBox(examInterfaceArrayList);


            //--------ADD ELEMENTS TO LAYOUTS------

            hBoxTitleButton.getChildren().addAll(subjectName, newExamButton);
            vBox.getChildren().addAll(hBoxTitleButton, subjectAverage, hBoxMarks, hBoxSubtitle);
            this.getChildren().add(vBox);
        });

    }


    /*--------METHODS--------*/


    //create Delete Button with specific eventHandler for every button
    public Button createDeleteButton(int number, HBox hBox) {
        Button deleteButton = new Button("Delete Exam");
        deleteButton.setOnAction(new DeleteButtonEvent(number, hBox));
        return deleteButton;
    }

    //update box with all exams
    public void generateHBox(ArrayList<ExamInterface> examInterfaceArrayList) {
        this.hBoxMarks.getChildren().clear();
        for (int i = 0; i < examInterfaceArrayList.size(); i++) {
            VBox vBox = new VBox(10);
            vBox.setStyle("-fx-border-color: black;\n" + "-fx-border-width: 1;\n" + "-fx-background-color: #F5F1E8;\n");
            vBox.setPadding(new Insets(10, 10, 10, 10)); //padding
            vBox.getChildren().add(createDeleteButton(i, this.hBoxMarks));
            vBox.getChildren().add(examInterfaceArrayList.get(i));
            this.hBoxMarks.getChildren().add(vBox);
        }
    }


    /*--------GETTER--------*/


    public Subject getSubject() {
        return subject;
    }

    public ArrayList<ExamInterface> getExamInterfaceArrayList() {
        return examInterfaceArrayList;
    }


}
