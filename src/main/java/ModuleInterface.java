import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class ModuleInterface extends Parent {


    private static final int MARK_FR = 0;
    private static final int MARK_DE = 1;
    private static final int MARK_CH = 2;

    private Module module = new Module();
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
            module.deleteMark(number);
            generateHBox(subjectInterfaceArrayList);
        }
    }


    /*------CONSTRUCTOR------*/


    public ModuleInterface() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {


                System.out.println("Constructor of ModuleInterface");


                //------LAYOUTS-------


                //Layout Page
                VBox vBox = new VBox(10);


                //Layout Title line
                HBox hBoxTitleButton = new HBox(30);
                hBoxTitleButton.setAlignment(Pos.CENTER_LEFT);

                //Layout Subtitles
                HBox hBoxSubtitle = new HBox(30);
                hBoxSubtitle.setAlignment(Pos.BOTTOM_LEFT);

                //Layout Subjects
                hBoxMarks.setPadding(new Insets(10, 10, 10, 10));


                //-------TEXTFIELD--------

                TextField moduleName = new TextField();
                moduleName.setStyle("-fx-font: 30 berlin; -fx-font-weight: bold;");
                moduleName.setText(module.getMarkName());

                moduleName.textProperty().addListener((observable, oldValue, newValue) -> module.setMarkName(moduleName.getText()));

                moduleName.setStyle("-fx-font: 20 berlin; -fx-font-weight: bold;");
                moduleName.setPrefWidth(220);


                //------AVERAGE LINE------

                MarkInterface moduleAverage = new MarkInterface(module);


                //------BUTTONS------

                Button newSubjectButton = new Button("Add Subject");

                newSubjectButton.setOnAction(e -> {

                    subjectInterfaceArrayList.add(new SubjectInterface(module));
                    ModuleInterface.this.generateHBox(subjectInterfaceArrayList);

                });


                //-------ADD DEFAULT EXAM------

                //subjectInterfaceArrayList.add(new SubjectInterface(module));
                //generateHBox(subjectInterfaceArrayList);


                //--------ADD ELEMENTS TO LAYOUTS------

                hBoxTitleButton.getChildren().addAll(moduleName, newSubjectButton);
                vBox.getChildren().addAll(hBoxTitleButton, moduleAverage, hBoxMarks, hBoxSubtitle);
                ModuleInterface.this.getChildren().add(vBox);
            }
        });

    }


    /*--------METHODS--------*/


    //create Delete Button with specific eventHandler for every button
    public Button createDeleteButton(int number, HBox hBox) {
        Button deleteButton = new Button("Delete Subject");
        deleteButton.setOnAction(new DeleteButtonEvent(number, hBox));
        return deleteButton;
    }

    //update box with all subjects
    public void generateHBox(ArrayList<SubjectInterface> subjectInterfaceArrayList) {
        this.hBoxMarks.getChildren().clear();
        for (int i = 0; i < subjectInterfaceArrayList.size(); i++) {
            VBox vBox = new VBox(10);
            vBox.setStyle("-fx-border-color: black;\n" + "-fx-border-width: 1;\n" + "-fx-background-color: #F5F1E8;\n");
            vBox.setPadding(new Insets(10, 10, 10, 10)); //padding
            vBox.getChildren().add(createDeleteButton(i, this.hBoxMarks));
            vBox.getChildren().add(subjectInterfaceArrayList.get(i));
            this.hBoxMarks.getChildren().add(vBox);
        }
    }


    /*--------GETTER--------*/


    public Module getModule() {
        return module;
    }

    public ArrayList<SubjectInterface> getSubjectInterfaceArrayList() {
        return subjectInterfaceArrayList;
    }


}
