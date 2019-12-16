package sample;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SemesterInterface extends Parent {


    private static final int MARK_FR = 0;
    private static final int MARK_DE = 1;
    private static final int MARK_CH = 2;

    //public Subject subject = new Subject();
    private ArrayList<SubjectInterface> subjectInterfaceArrayList = new ArrayList<>(); //Array of all Subjects
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
            subjectInterfaceArrayList.remove(number);
            generateHBox(subjectInterfaceArrayList);
        }
    }


    /*------CONSTRUCTOR------*/


    public SemesterInterface() {
        Platform.runLater(() -> {
            System.out.println("Constructor of SemesterInterface");


            //------LAYOUTS-------


        //Layout Page
        VBox vBox = new VBox(10);
        vBox.setPadding(new Insets(10, 10, 10, 10));

            //Layout Title line
            HBox hBoxTitleButton = new HBox(30);
            hBoxTitleButton.setAlignment(Pos.CENTER_LEFT);

            //Layout Subtitles
            HBox hBoxSubtitle = new HBox(30);
            hBoxSubtitle.setAlignment(Pos.BOTTOM_LEFT);

        //Layout Exams
        hBoxMarks.setStyle("-fx-border-color: black" +  "-fx-border-width: 5;\n" +"-fx-border-outsets: 5;\n");
        hBoxMarks.setPadding(new Insets(0, 0, 0, 0)); //padding

        //-------LABELS--------
        Label semester = new Label("Semester");
        semester.setStyle("-fx-font: 30 berlin; -fx-font-weight: bold;");

        //-------TEXTFIELDS----
        TextField semesterNum = new TextField();
        semesterNum.setPromptText("1");
        semesterNum.setStyle("-fx-font: 30 berlin; -fx-font-weight: bold;");
        semesterNum.setPrefWidth(55);


            //------BUTTONS------

            Button newExamButton = new Button("Add Subject");

            newExamButton.setOnAction(e -> {

                subjectInterfaceArrayList.add(new SubjectInterface());
                generateHBox(subjectInterfaceArrayList);

            });

            Button saveSemesterButton = new Button("Save Semester");

            saveSemesterButton.setOnAction(e -> {
                try {
                    FileWriter fileWriter = new FileWriter("data.txt");
                    PrintWriter printWriter = new PrintWriter(fileWriter);
                    Save.save(this, printWriter);
                    printWriter.close();
                } catch (IOException ex) {
                    System.out.println("oups");
                }
            });


            //-------ADD DEFAULT EXAM------

            //subjectInterfaceArrayList.add(new SubjectInterface());
            //generateHBox(subjectInterfaceArrayList);


            //--------ADD ELEMENTS TO LAYOUTS------

        hBoxTitleButton.getChildren().addAll(semester, semesterNum, newExamButton, saveSemesterButton);
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
    public void generateHBox(ArrayList<SubjectInterface> subjectInterfaceArrayList) {
        this.hBoxMarks.getChildren().clear();
        for (int i = 0; i < subjectInterfaceArrayList.size(); i++) {
            VBox vBox = new VBox();
            vBox.setStyle("-fx-border-color: #F5F1E8;"  + "-fx-background-color: white;" + "-fx-border-width: 10;\n");
            vBox.setPadding(new Insets(10, 10, 0, 10)); //padding
            vBox.getChildren().add(createDeleteButton(i, this.hBoxMarks));
            vBox.getChildren().add(subjectInterfaceArrayList.get(i));
            this.hBoxMarks.getChildren().add(vBox);
        }
    }


    /*--------GETTER--------*/


    public ArrayList<SubjectInterface> getSubjectInterfaceArrayList() {
        return subjectInterfaceArrayList;
    }
}

