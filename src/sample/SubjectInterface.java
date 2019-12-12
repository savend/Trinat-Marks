package sample;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SubjectInterface extends Parent {


    private static final int MARK_FR = 0;
    private static final int MARK_DE = 1;
    private static final int MARK_CH = 2;

    public Subject subject = new Subject();
    private ArrayList<ExamInterface> examInterfaceArrayList = new ArrayList<>();


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
            examInterfaceArrayList.remove(number);
            subject.deleteMark(number);
        }
    }


    /*------CONSTRUCTOR------*/


    public SubjectInterface() {

        System.out.println("Constructeur of ExamInterface");

        //Layout Page
        VBox vBox = new VBox(10);
        vBox.setStyle("-fx-border-color: red;\n" + "-fx-border-insets: 5;\n" + "-fx-border-width: 1;\n");

        //Layout Title line
        HBox hBoxTitleButton = new HBox(30);
        hBoxTitleButton.setAlignment(Pos.CENTER_LEFT);

        //Layout Subtiles
        HBox hBoxSubtitle = new HBox(30);
        hBoxSubtitle.setAlignment(Pos.BOTTOM_LEFT);

        //Layout Marks and delet boxees
        GridPane gridPane = new GridPane();
        //gridPane.setGridLinesVisible(true);
        gridPane.setPadding(new Insets(0, 0, 0, 0));
        gridPane.setAlignment(Pos.TOP_LEFT);
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        //Labels
        Label title = new Label("Module");
        title.setStyle("-fx-font: 30 berlin; -fx-font-weight: bold;");

        /*-----Add average Mark-----*/
        MarkInterface examAverage = new MarkInterface(subject, true);

        //Buttons
        Button neueNoteButton = new Button("Add Subject");


        //------- Set hBox----------
        hBoxTitleButton.getChildren().addAll(title, neueNoteButton);


        //------- Set GridPane------

        gridPane.add(neueNoteButton, 0, 0);
        examInterfaceArrayList.add(new ExamInterface(subject));
        gridPane.add(createDeleteButton(examInterfaceArrayList.size() + 1, gridPane), 1, examInterfaceArrayList.size() + 1);
        gridPane.add(examInterfaceArrayList.get(examInterfaceArrayList.size() - 1), 0, examInterfaceArrayList.size() + 1);


        //-----Action Buttons (Neue Note) -----


        neueNoteButton.setOnAction(e -> {

            examInterfaceArrayList.add(new ExamInterface(subject));
            gridPane.add(createDeleteButton(examInterfaceArrayList.size() + 1, gridPane), 1, examInterfaceArrayList.size() + 1);
            gridPane.add(examInterfaceArrayList.get(examInterfaceArrayList.size() - 1), 0, examInterfaceArrayList.size() + 1);

        });



        //------ Print GridPane--------


        vBox.getChildren().addAll(hBoxTitleButton, examAverage, hBoxSubtitle, gridPane);
        this.getChildren().add(vBox);
    }

    public Button createDeleteButton(int number, GridPane gridPane) {
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(new DeleteButtonEvent(number, gridPane));
        return deleteButton;
    }

}
