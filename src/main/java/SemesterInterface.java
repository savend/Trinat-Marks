import java.io.File;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SemesterInterface extends Parent {


    private static final int MARK_FR = 0;
    private static final int MARK_DE = 1;
    private static final int MARK_CH = 2;

    //public Module module = new Module();
    private ArrayList<ModuleInterface> moduleInterfaceArrayList = new ArrayList<>(); //Array of all Modules
    private HBox hBoxMarks = new HBox();
    private String name = "1";


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
            moduleInterfaceArrayList.remove(number);
            generateHBox(moduleInterfaceArrayList);
        }
    }


    /*------CONSTRUCTOR------*/


    public SemesterInterface(File fileWriter) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                System.out.println("Constructor of SemesterInterface");


                //------LAYOUTS-------


                //Layout Page
                VBox vBox = new VBox(10);
                vBox.setPadding(new Insets(10, 10, 10, 10));

                //Layout Title line
                HBox hBoxTitleButton = new HBox(30);
                hBoxTitleButton.setAlignment(Pos.TOP_LEFT);

                //Layout Subtitles
                HBox hBoxSubtitle = new HBox(30);
                hBoxSubtitle.setAlignment(Pos.BOTTOM_LEFT);

                //Layout Subjects
                hBoxMarks.setStyle("-fx-border-color: black;" + "-fx-border-width: 1px;\n" + "-fx-border-outsets: 5px;\n");
                hBoxMarks.setPadding(new Insets(0, 0, 0, 0)); //padding

                //-------LABELS--------
                Label semester = new Label("Semester " + name);
                semester.setStyle("-fx-font: 30 berlin; -fx-font-weight: bold;");

                //-------TEXTFIELDS----
                //TextField semesterNum = new TextField();
                //semesterNum.setText(name);
                //semesterNum.setStyle("-fx-font: 30 berlin; -fx-font-weight: bold;");
                //semesterNum.setPrefWidth(55);


                //------BUTTONS------

                Button newSubjectButton = new Button("Add Module");

                newSubjectButton.setOnAction(e -> {

                    moduleInterfaceArrayList.add(new ModuleInterface());
                    SemesterInterface.this.generateHBox(moduleInterfaceArrayList);

                });

                Button saveSemesterButton = new Button("Save Semester");

                saveSemesterButton.setOnAction(e -> {
                    try {
                        fileWriter.delete();
                        PrintWriter printWriter = new PrintWriter(fileWriter);
                        Save.save(SemesterInterface.this, printWriter);
                        printWriter.close();
                    } catch (IOException ex) {
                        System.out.println("oups");
                    }
                });


                //-------ADD DEFAULT EXAM------

                //moduleInterfaceArrayList.add(new ModuleInterface());
                //generateHBox(moduleInterfaceArrayList);


                //--------ADD ELEMENTS TO LAYOUTS------

                hBoxTitleButton.getChildren().addAll(semester, newSubjectButton, saveSemesterButton);
                vBox.getChildren().addAll(hBoxTitleButton, hBoxMarks, hBoxSubtitle);
                SemesterInterface.this.getChildren().add(vBox);
            }
        });
    }

    /*--------METHODS--------*/


    //create Delete Button with specific eventHandler for every button
    public Button createDeleteButton(int number, HBox hBox) {
        Button deleteButton = new Button("Delete Module");
        deleteButton.setOnAction(new DeleteButtonEvent(number, hBox));
        return deleteButton;
    }

    //update box with all subjects
    public void generateHBox(ArrayList<ModuleInterface> moduleInterfaceArrayList) {
        this.hBoxMarks.getChildren().clear();
        for (int i = 0; i < moduleInterfaceArrayList.size(); i++) {
            VBox vBox = new VBox();
            vBox.setStyle("-fx-border-color: #F5F1E8;" + "-fx-background-color: white;" + "-fx-border-width: 10;\n");
            vBox.setPadding(new Insets(10, 10, 0, 10)); //padding
            vBox.getChildren().add(createDeleteButton(i, this.hBoxMarks));
            vBox.getChildren().add(moduleInterfaceArrayList.get(i));
            this.hBoxMarks.getChildren().add(vBox);
        }
    }


    /*--------GETTER--------*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<ModuleInterface> getModuleInterfaceArrayList() {
        return moduleInterfaceArrayList;
    }
}

