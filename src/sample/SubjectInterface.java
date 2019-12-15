package sample;

import java.util.ArrayList;

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
            generateHBox(hbox, examInterfaceArrayList);
        }
    }


    /*------CONSTRUCTOR------*/


    public SubjectInterface() {

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
        HBox hBoxMarks = new HBox(10);
        hBoxMarks.setPadding(new Insets(10, 10, 10, 10));
     


        //-------TEXTFIELD--------

        TextField title = new TextField();
        title.setStyle("-fx-font: 30 berlin; -fx-font-weight: bold;");
        title.setPromptText("Subject");
        title.setStyle("-fx-font: 20 berlin; -fx-font-weight: bold;");
        title.setPrefWidth(220);


        //------AVERAGE LINE------

        MarkInterface subjectAverage = new MarkInterface(subject, true);


        //------BUTTONS------

        Button newExamButton = new Button("Add Exam");

        newExamButton.setOnAction(e -> {

            examInterfaceArrayList.add(new ExamInterface(subject));
            generateHBox(hBoxMarks, examInterfaceArrayList);

        });


        //-------ADD DEFAULT EXAM------

        examInterfaceArrayList.add(new ExamInterface(subject));
        generateHBox(hBoxMarks, examInterfaceArrayList);


        //--------ADD ELEMENTS TO LAYOUTS------

        hBoxTitleButton.getChildren().addAll(title, newExamButton);
        vBox.getChildren().addAll(hBoxTitleButton, subjectAverage, hBoxMarks, hBoxSubtitle);
        this.getChildren().add(vBox);
    }


    /*--------METHODS--------*/


    //create Delete Button with specific eventHandler for every button
    public Button createDeleteButton(int number, HBox hBox) {
        Button deleteButton = new Button("Delete Exam");
        deleteButton.setOnAction(new DeleteButtonEvent(number, hBox));
        return deleteButton;
    }

    //update box with all exams
    public void generateHBox(HBox hBox, ArrayList<ExamInterface> examInterfaceArrayList) {
        hBox.getChildren().clear();
        for (int i = 0; i < examInterfaceArrayList.size(); i++) {
            VBox vBox = new VBox(10);
            vBox.setStyle("-fx-border-color: black;\n" + "-fx-border-width: 1;\n" + "-fx-background-color: #F5F1E8;\n");
            vBox.setPadding(new Insets(10, 10, 10, 10)); //padding
            vBox.getChildren().add(createDeleteButton(i, hBox));
            vBox.getChildren().add(examInterfaceArrayList.get(i));
            hBox.getChildren().add(vBox);
        }
    }

    public Subject getSubject() {
        return subject;
    }

    public ArrayList<ExamInterface> getExamInterfaceArrayList() {
        return examInterfaceArrayList;
    }
}
