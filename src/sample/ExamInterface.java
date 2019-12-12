package sample;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;


public class ExamInterface extends Parent {


    private static final int MARK_FR = 0;
    private static final int MARK_DE = 1;
    private static final int MARK_CH = 2;

    public Exam exam = new Exam();
    private ArrayList<MarkInterface> markInterfaceArrayList = new ArrayList<>();


    /*------CLASS-----*/
    //EventHandler Class to assign specific event to every DeleteButton -----


    class DeleteButtonEvent implements EventHandler<ActionEvent> {

        private final int number;
        GridPane gridPane;

        DeleteButtonEvent(int number, GridPane grid) {
            this.gridPane = grid;
            this.number = number;
        }

        @Override
        public void handle(ActionEvent event) {

            gridPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == number);
            markInterfaceArrayList.remove(number);
            exam.deleteMark(number);
        }
    }


    /*------CONSTRUCTOR------*/


    public ExamInterface(Subject subject) {

        System.out.println("Constructeur of ExamInterface");

        VBox vBox = new VBox();
        GridPane gridPane = new GridPane();
        //gridPane.setGridLinesVisible(true);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        Button neueNoteButton = new Button("Add Mark");


        //------- Set GridPane------

        gridPane.add(neueNoteButton, 0, 0);
        markInterfaceArrayList.add(new MarkInterface(exam, false));
        gridPane.add(createDeleteButton(markInterfaceArrayList.size() + 1, gridPane), 1, markInterfaceArrayList.size() + 1);
        gridPane.add(markInterfaceArrayList.get(markInterfaceArrayList.size() - 1), 0, markInterfaceArrayList.size() + 1);


        //-----Action Buttons (Neue Note) -----


        neueNoteButton.setOnAction(e -> {

            markInterfaceArrayList.add(new MarkInterface(exam, false));
            gridPane.add(createDeleteButton(markInterfaceArrayList.size() + 1, gridPane), 1, markInterfaceArrayList.size() + 1);
            gridPane.add(markInterfaceArrayList.get(markInterfaceArrayList.size() - 1), 0, markInterfaceArrayList.size() + 1);

        });

        /*-----Add average Mark-----*/
        MarkInterface examAverage = new MarkInterface(exam, true);

        //------ Print GridPane--------

        vBox.getChildren().addAll(gridPane, examAverage);
        this.getChildren().add(vBox);
        /* ADDING EXAM MARK TO PRECEDENT CLASS : SUBJECT */
    }

    public Button createDeleteButton(int number, GridPane gridPane) {
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(new DeleteButtonEvent(number, gridPane));
        return deleteButton;
    }


}
