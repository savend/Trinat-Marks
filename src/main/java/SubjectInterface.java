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

import java.util.ArrayList;

public class SubjectInterface extends Parent {


    private static final int MARK_FR = 0;
    private static final int MARK_DE = 1;
    private static final int MARK_CH = 2;


    private Subject subject = new Subject();
    private ArrayList<MarkInterface> markInterfaceArrayList = new ArrayList<MarkInterface>(); //Array of all Marks
    private VBox vBoxMarks = new VBox();



    /*------CLASS-----*/
    //EventHandler Class to assign specific event to every DeleteButton -----


    class DeleteButtonEvent implements EventHandler<ActionEvent> {

        private final int number;
        VBox vbox;

        //Constructor of DeleteButtonEvent
        DeleteButtonEvent(int number, VBox box) {
            this.vbox = box;
            this.number = number;
        }

        //EventHandler for every button
        @Override
        public void handle(ActionEvent event) {
            markInterfaceArrayList.remove(number);
            subject.deleteMark(number);
            generateVBox(markInterfaceArrayList);
        }
    }


    /*------CONSTRUCTOR------*/


    public SubjectInterface(Module module) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {

                System.out.println("Constructeur of SubjectInterface");


                //------LAYOUTS-------


                //Layout Page
                VBox vBox = new VBox(10);
                vBox.setPadding(new Insets(0, 0, 20, 0));


                //Layout Title line
                HBox hBoxTitleButton = new HBox(30);
                hBoxTitleButton.setAlignment(Pos.CENTER_LEFT);

                //Layout Subtitles
                HBox hBoxSubtitle = new HBox(30);
                hBoxSubtitle.setAlignment(Pos.BOTTOM_LEFT);

                vBoxMarks.setPadding(new Insets(0, 0, 20, 0));


                //Text fields
                TextField subjectName = new TextField();
                subjectName.setText(subject.getMarkName());
                subjectName.setStyle("-fx-font: 20 berlin; -fx-font-weight: bold;");
                subjectName.setPrefWidth(220);

                subjectName.textProperty().addListener((observable, oldValue, newValue) -> subject.setMarkName(subjectName.getText()));


                //-------LABELS--------


                Label coefficient = new Label("                 Koeffizient");
                coefficient.setStyle("-fx-font: 14 berlin; -fx-font-weight: bold;");
                Label fMark = new Label("F   ");
                fMark.setStyle("-fx-font: 14 berlin; -fx-font-weight: bold;");
                Label dMark = new Label("D ");
                dMark.setStyle("-fx-font: 14 berlin; -fx-font-weight: bold;");
                Label chMark = new Label("CH");
                chMark.setStyle("-fx-font: 14 berlin; -fx-font-weight: bold;");


                //------AVERAGE LINE------

                MarkInterface subjectAverage = new MarkInterface(subject, module, false);


                //------BUTTONS------

                Button newMarkButton = new Button("Add Mark");

                newMarkButton.setOnAction(e -> {

                    markInterfaceArrayList.add(new MarkInterface(new Mark(), subject, true));
                    SubjectInterface.this.generateVBox(markInterfaceArrayList);

                });


            /*------- Set GridPane------


             //markInterfaceArrayList.add(new MarkInterface(subject, false));
             //generateVBox(vBoxMarks, markInterfaceArrayList);
             /*gridPane.add(createDeleteButton(markInterfaceArrayList.size() + 1, gridPane), 1, markInterfaceArrayList.size() + 1);
             gridPane.add(markInterfaceArrayList.get(markInterfaceArrayList.size() - 1), 0, markInterfaceArrayList.size() + 1);*/


                //-------ADD DEFAULT MARK------

                //markInterfaceArrayList.add(new MarkInterface(new Mark(), subject, true));
                //generateVBox(markInterfaceArrayList);


                //--------ADD ELEMENTS TO LAYOUTS------

                hBoxTitleButton.getChildren().addAll(subjectName);
                hBoxSubtitle.getChildren().addAll(newMarkButton, coefficient, fMark, dMark, chMark);
                vBox.getChildren().addAll(hBoxTitleButton, hBoxSubtitle, vBoxMarks, subjectAverage);
                SubjectInterface.this.getChildren().add(vBox);
            }
        });
    }


    /*--------METHODS--------*/


    //create Delete Button with specific eventHandler for every button
    public Button createDeleteButton(int number, VBox vBox) {
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(new DeleteButtonEvent(number, vBox));
        return deleteButton;
    }

    //update box with all subjects
    public void generateVBox(ArrayList<MarkInterface> markInterfaceArrayList) {
        this.vBoxMarks.getChildren().clear();
        for (int i = 0; i < markInterfaceArrayList.size(); i++) {

            System.out.println(Thread.currentThread().getName());

            HBox hBox = new HBox();
            //hBox.setStyle("-fx-border-color: black;\n" + "-fx-border-insets: 5;\n" + "-fx-border-width: 1;\n");
            hBox.setPadding(new Insets(5, 5, 5, 5)); //padding
            MarkInterface buff = markInterfaceArrayList.get(i);

            Button buttbuff = createDeleteButton(i, this.vBoxMarks);
            Platform.runLater(() -> {
                hBox.getChildren().add(buff);
                hBox.getChildren().add(buttbuff);
                this.vBoxMarks.getChildren().add(hBox);
            });

        }
    }


    /*--------GETTER--------*/


    public ArrayList<MarkInterface> getMarkInterfaceArrayList() {
        return markInterfaceArrayList;
    }

    public Subject getSubject() {
        return subject;
    }

}
