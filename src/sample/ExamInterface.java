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
        VBox vbox;

        DeleteButtonEvent(int number, VBox box) {
            this.vbox = box;
            this.number = number;
        }

        @Override
        public void handle(ActionEvent event) {
            // gridPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == number);
            markInterfaceArrayList.remove(number);
            exam.deleteMark(number);
            generateVBox(vbox, markInterfaceArrayList);
        }
    }


    /*------CONSTRUCTOR------*/


    public ExamInterface(Subject subject) {

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
        Label title = new Label(" Mathematik");
        title.setStyle("-fx-font: 30 berlin; -fx-font-weight: bold;");
        Label topic = new Label("   Fach                          ");
        topic.setStyle("-fx-font: 14 berlin; -fx-font-weight: bold;");
        Label coefficient = new Label("Koeffizient");
        coefficient.setStyle("-fx-font: 14 berlin; -fx-font-weight: bold;");
        Label fMark = new Label("F   ");
        fMark.setStyle("-fx-font: 14 berlin; -fx-font-weight: bold;");
        Label dMark = new Label("D ");
        dMark.setStyle("-fx-font: 14 berlin; -fx-font-weight: bold;");
        Label chMark = new Label("CH");
        chMark.setStyle("-fx-font: 14 berlin; -fx-font-weight: bold;");

        //Buttons
        Button neueNoteButton = new Button("Add Mark");


        //------- Set hBox----------
        hBoxTitleButton.getChildren().addAll(title, neueNoteButton);
        hBoxSubtitle.getChildren().addAll(topic, coefficient, fMark, dMark, chMark);


        //------- Set GridPane------

        VBox vBoxMarks = new VBox();
        vBoxMarks.setStyle("-fx-border-color: red;\n" + "-fx-border-insets: 5;\n" + "-fx-border-width: 1;\n");
        //markInterfaceArrayList.add(new MarkInterface(exam, false));
        //generateVBox(vBoxMarks, markInterfaceArrayList);
        /*gridPane.add(createDeleteButton(markInterfaceArrayList.size() + 1, gridPane), 1, markInterfaceArrayList.size() + 1);
        gridPane.add(markInterfaceArrayList.get(markInterfaceArrayList.size() - 1), 0, markInterfaceArrayList.size() + 1);*/


        //-----Action Buttons (Neue Note) -----


        neueNoteButton.setOnAction(e -> {

            markInterfaceArrayList.add(new MarkInterface(exam, false));
            generateVBox(vBoxMarks, markInterfaceArrayList);
            /*gridPane.add(createDeleteButton(markInterfaceArrayList.size() + 1, gridPane), 1, markInterfaceArrayList.size() + 1);
            gridPane.add(markInterfaceArrayList.get(markInterfaceArrayList.size() - 1), 0, markInterfaceArrayList.size() + 1);*/

        });

        /*-----Add average Mark-----*/
        MarkInterface examAverage = new MarkInterface(exam, true);

        //------ Print GridPane--------


        vBox.getChildren().addAll(hBoxTitleButton, hBoxSubtitle, neueNoteButton, vBoxMarks, examAverage);
        this.getChildren().add(vBox);
        //add exam Mark to Subject
        subject.addMark(exam.getMarkObject());
    }

    public Button createDeleteButton(int number, VBox vBox) {
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(new DeleteButtonEvent(number, vBox));
        return deleteButton;
    }

    public void generateVBox(VBox vBox, ArrayList<MarkInterface> markInterfaceArrayList) {
        vBox.getChildren().clear();
        for (int i = 0; i < markInterfaceArrayList.size(); i++) {
            HBox hBox = new HBox();
            hBox.setStyle("-fx-border-color: black;\n" + "-fx-border-insets: 5;\n" + "-fx-border-width: 1;\n");
            hBox.getChildren().add(markInterfaceArrayList.get(i));
            hBox.getChildren().add(createDeleteButton(i, vBox));
            vBox.getChildren().add(hBox);
        }
    }

}
