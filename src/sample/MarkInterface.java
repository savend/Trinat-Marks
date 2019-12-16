package sample;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableStringValue;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.ObservableValueBase;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;

import javax.xml.soap.Text;
import java.security.spec.ECField;
import java.util.concurrent.Callable;

public class MarkInterface extends Parent {


    private static final int MARK_FR = 0;
    private static final int MARK_DE = 1;
    private static final int MARK_CH = 2;
    private static final int COEFFICIENT = 3;
    private static final int NAME = 4;
    private static final int NULL = 10;


    Mark mark;


    /*------CONSTRUCTOR------*/

    public MarkInterface(Subject subject) {
        this(subject, new Exam(), false);
    }


    public MarkInterface(Mark markBuffer, Exam exam, boolean newMark) {

        System.out.println("Constructor of MarkInterface");

        Platform.runLater(() -> {

            mark = markBuffer.getMarkObject();


            /*------Layout Boxes-----*/

            HBox hBox = new HBox(10);
            hBox.setPadding(new Insets(0, 0, 0, 0));
            hBox.setAlignment(Pos.CENTER_LEFT);


            /*----Labels for Textfield description----*/

            Label procentLabel = new Label("%    ");
            procentLabel.setStyle("-fx-font: 14 berlin; -fx-font-weight: bold;");
            Label examAverageLabel = new Label("Exam Average : ");
            Label subjectAverageLabel = new Label("Subject Average : ");


            /*------Textfields-----*/

            TextField markNameField = new TextField();
            markNameField.setPrefWidth(150);
            if (newMark)
                markNameField.setPromptText("Test Name");
            else
                markNameField.setText(mark.getMarkName());

            TextField markCoefficientField = new TextField();
            markCoefficientField.setPrefWidth(40);
            if (newMark)
                markCoefficientField.setPromptText("100");
            else
                markCoefficientField.setText(String.valueOf((int) mark.getCoefficient() * 100));

            TextField markFField = new TextField();
            markFField.setPrefWidth(40);
            if (newMark)
                markFField.setPromptText("16.0");
            else
                markFField.setText(String.valueOf(mark.getMark()));

            TextField markDField = new TextField();
            markDField.setMaxWidth(40);
            if (newMark)
                markDField.setPromptText("1.0");
            else
                markDField.setText(String.valueOf(mark.markConversion(MARK_DE)));

            TextField markCHField = new TextField();
            markCHField.setMaxWidth(40);
            if (newMark)
                markCHField.setPromptText("6.0");
            else
                markCHField.setText(String.valueOf(mark.markConversion(MARK_CH)));

            /*-----Event Handlers-----*/

            EventHandler<ActionEvent> eventHandlerNameField = event -> {
                if (mark.getClass().equals(Mark.class))
                    updateMarkInterface(markNameField, markCoefficientField, markFField, markDField, markCHField, NAME);
            };

            markNameField.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!mark.getClass().equals(Mark.class))
                    updateMarkInterface(markNameField, markCoefficientField, markFField, markDField, markCHField, NULL);
                else if (oldValue) {
                    updateMarkInterface(markNameField, markCoefficientField, markFField, markDField, markCHField, NAME);
                }
            });

            EventHandler<ActionEvent> eventHandlerCoefficientField = event -> {
                if (!mark.getClass().equals(Subject.class))
                    updateMarkInterface(markNameField, markCoefficientField, markFField, markDField, markCHField, COEFFICIENT);
            };

            markCoefficientField.textProperty().addListener((observable, oldValue, newValue) -> {
                if (markCoefficientField.getText().length() >= 3) {
                    if (!mark.getClass().equals(Subject.class))
                        updateMarkInterface(markNameField, markCoefficientField, markFField, markDField, markCHField, COEFFICIENT);
                }
            });

            markCoefficientField.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (mark.getClass().equals(Subject.class))
                    updateMarkInterface(markNameField, markCoefficientField, markFField, markDField, markCHField, NULL);
                else if (oldValue) {
                    updateMarkInterface(markNameField, markCoefficientField, markFField, markDField, markCHField, COEFFICIENT);
                }
            });

            EventHandler<ActionEvent> eventHandlerFField = event -> {
                if (mark.getClass().equals(Mark.class))
                    updateMarkInterface(markNameField, markCoefficientField, markFField, markDField, markCHField, MARK_FR);
                else
                    updateMarkInterface(markNameField, markCoefficientField, markFField, markDField, markCHField, NULL);

            };

            markFField.textProperty().addListener((observable, oldValue, newValue) -> {
                if (mark.getClass().equals(Mark.class)) {
                    if (markFField.getText().length() >= 5) {
                        updateMarkInterface(markNameField, markCoefficientField, markFField, markDField, markCHField, MARK_FR);
                    }
                } else
                    updateMarkInterface(markNameField, markCoefficientField, markFField, markDField, markCHField, NULL);

            });

            markFField.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!mark.getClass().equals(Mark.class))
                    updateMarkInterface(markNameField, markCoefficientField, markFField, markDField, markCHField, NULL);
                else if (oldValue) {
                    updateMarkInterface(markNameField, markCoefficientField, markFField, markDField, markCHField, MARK_FR);
                }
            });

            EventHandler<ActionEvent> eventHandlerDField = event -> {
                if (mark.getClass().equals(Mark.class))
                    updateMarkInterface(markNameField, markCoefficientField, markFField, markDField, markCHField, MARK_DE);
                else
                    updateMarkInterface(markNameField, markCoefficientField, markFField, markDField, markCHField, NULL);
            };

            markDField.textProperty().addListener((observable, oldValue, newValue) -> {
                if (mark.getClass().equals(Mark.class)) {
                    if (markDField.getText().length() >= 4) {
                        updateMarkInterface(markNameField, markCoefficientField, markFField, markDField, markCHField, MARK_DE);
                    }
                } else
                    updateMarkInterface(markNameField, markCoefficientField, markFField, markDField, markCHField, NULL);

            });

            markDField.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!mark.getClass().equals(Mark.class))
                    updateMarkInterface(markNameField, markCoefficientField, markFField, markDField, markCHField, NULL);
                else if (oldValue) {
                    updateMarkInterface(markNameField, markCoefficientField, markFField, markDField, markCHField, MARK_DE);
                }
            });

            EventHandler<ActionEvent> eventHandlerCHField = event -> {
                if (mark.getClass().equals(Mark.class))
                    updateMarkInterface(markNameField, markCoefficientField, markFField, markDField, markCHField, MARK_CH);
                else
                    updateMarkInterface(markNameField, markCoefficientField, markFField, markDField, markCHField, NULL);
            };

            markCHField.textProperty().addListener((observable, oldValue, newValue) -> {
                if (mark.getClass().equals(Mark.class)) {
                    if (markCHField.getText().length() >= 4) {
                        updateMarkInterface(markNameField, markCoefficientField, markFField, markDField, markCHField, MARK_CH);
                    }
                } else
                    updateMarkInterface(markNameField, markCoefficientField, markFField, markDField, markCHField, NULL);

            });

            markCHField.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!mark.getClass().equals(Mark.class))
                    updateMarkInterface(markNameField, markCoefficientField, markFField, markDField, markCHField, NULL);
                else if (oldValue) {
                    updateMarkInterface(markNameField, markCoefficientField, markFField, markDField, markCHField, MARK_CH);
                }
            });


            //Set EventHandler to every Field
            markNameField.setOnAction(eventHandlerNameField);
            markCoefficientField.setOnAction(eventHandlerCoefficientField);
            markFField.setOnAction(eventHandlerFField);
            markDField.setOnAction(eventHandlerDField);
            markCHField.setOnAction(eventHandlerCHField);


            /*-----Add Mark to Exam------*/

            if (!mark.getClass().equals(Subject.class))
                exam.addMark(mark);


            /*-----Add Elements to Layout-----*/

            if (mark.getClass().equals(Mark.class))
                hBox.getChildren().add(markNameField);
            else if (mark.getClass().equals(Subject.class))
                hBox.getChildren().add(subjectAverageLabel);
            else if (mark.getClass().equals(Exam.class))
                hBox.getChildren().add(examAverageLabel);
            if (mark.getClass().equals(Mark.class) || mark.getClass().equals(Exam.class))
                hBox.getChildren().addAll(markCoefficientField, procentLabel);

            hBox.getChildren().addAll(markFField, markDField, markCHField);


            this.getChildren().add(hBox);
        });
    }


    /*------METHODS-------*/

    //verify if coefficient are entered
    private void verifyCoefficient(TextField textfield) {
        //System.out.println("Verification of coefficient entered or not");
        if (!(textfield.getText().isEmpty()) && (Double.parseDouble(textfield.getText()) >= 0) && (Double.parseDouble(textfield.getText()) <= 100)) {
            //System.out.println("yes");
            mark.setCoefficient(Double.parseDouble(textfield.getText()) / 100);
            Main.globalErrors.setText(Main.globalErrors.getText() + "");
        } else {
            //System.out.println("no");
            Main.globalErrors.setText("Enter Coefficient !");
        }
    }

    /*private void verifyMark(TextField textField) {
        System.out.println("Verification of mark entered or not");
        if (!textField.getText().isEmpty()) {
            System.out.println("yes");
            Main.globalErrors.setText("");
        } else {
            Main.globalErrors.setText("Enter Mark Name !");
        }


    }

    public void updateAverage(TextField markFField, TextField markDField, TextField markCHField) {
        markFField.setText(String.valueOf(mark.getMark()));
        markDField.setText(String.valueOf(mark.markConversion(MARK_DE)));
        markCHField.setText(String.valueOf(mark.markConversion(MARK_CH)));
    }


    public Mark getMark() {
        return mark;
    }*/

    //update MarkInterface dependent of the activated field
    private void updateMarkInterface(TextField markNameField, TextField markCoefficientField, TextField markFField, TextField markDField, TextField markCHField, int change) {
        if (change == MARK_FR) {
            mark.setMark(Double.parseDouble(markFField.getText()));
        } else if (change == MARK_DE) {
            mark.setMarkConvLine(Double.parseDouble(markDField.getText()), MARK_DE);
        } else if (change == MARK_CH) {
            mark.setMarkConvLine(Double.parseDouble(markDField.getText()), MARK_CH);
        } else if (change == COEFFICIENT) {
            verifyCoefficient(markCoefficientField);
        } else if (change == NAME) {
            mark.setMarkName(markNameField.getText());
        }

        markNameField.setText(mark.getMarkName());
        markCoefficientField.setText(String.valueOf((int) (mark.getCoefficient() * 100)));
        markFField.setText(String.valueOf(mark.getMark()));
        markDField.setText(String.valueOf(mark.markConversion(MARK_DE)));
        markCHField.setText(String.valueOf(mark.markConversion(MARK_CH)));
    }

}
