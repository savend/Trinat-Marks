package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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

public class MarkInterface extends Parent {


    private static final int MARK_FR = 0;
    private static final int MARK_DE = 1;
    private static final int MARK_CH = 2;


    Mark mark;


    /*------CONSTRUCTOR------*/


    public MarkInterface(Exam exam, boolean examAverage) {
        //Calculation of a new mark or of a existing mark ( average )
        if (examAverage)
            mark = exam.getMarkObject();
        else
            mark = new Mark();

        System.out.println("Constructor of MarkInterface");
        HBox hBox = new HBox(10); //Horizontal Box with 10px spacing

        hBox.setPadding(new Insets(0, 0, 0, 0)); //padding
        hBox.setAlignment(Pos.CENTER_LEFT);


        /*----Labels for Textfield description----*/

        Label procent = new Label("%    ");
        procent.setStyle("-fx-font: 14 berlin; -fx-font-weight: bold;");


        /*----Textfields----*/

        TextField markNameField = new TextField();
        markNameField.setPromptText("Name Test");
        markNameField.setPrefWidth(150);
        Label examAverageLabel = new Label("Exam Average : ");
        Label subjectAverageLabel = new Label("Subject Average : ");


        TextField coefficientField = new TextField();
        coefficientField.setPromptText(String.valueOf(mark.getCoefficient() * 100));
        coefficientField.setMaxWidth(40);

        TextField markFField = new TextField();
        markFField.setPromptText(String.valueOf(mark.getMark()));
        markFField.setMaxWidth(40);
        TextField markDField = new TextField();
        markDField.setPromptText(String.valueOf(mark.markConversion(MARK_DE)));
        markDField.setMaxWidth(40);
        TextField markCHField = new TextField();
        markCHField.setPromptText(String.valueOf(mark.markConversion(MARK_CH)));
        markCHField.setMaxWidth(40);


        /*-----Eventhandler-----*/

        //Event Handler for french mark entry
        EventHandler<ActionEvent> eventHandlerFField = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!examAverage)
                    mark.setMarkName(markNameField.getText());
                System.out.println("French field activated");
                if (!markFField.getText().isEmpty()) {
                    System.out.println("French field activated with a new mark");
                    mark.setMark(Double.parseDouble(markFField.getText()));
                    markFField.setText(String.valueOf(mark.getMark()));
                    markDField.setText(String.valueOf(mark.markConversion(MARK_DE)));
                    markCHField.setText(String.valueOf(mark.markConversion(MARK_CH)));
                    verifyMark(markFField);
                    verifyCoefficient(coefficientField);
                }
                if (examAverage) {
                    updateAverage(markFField, markDField, markCHField);
                }


                System.out.println(mark.toString());
            }
        };

        //Event Handler for german mark entry
        EventHandler<ActionEvent> eventHandlerDField = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!examAverage)
                    mark.setMarkName(markNameField.getText());
                System.out.println("German field activated");
                if (!markDField.getText().isEmpty()) {
                    System.out.println("German field activated with a new mark");
                    mark.setMarkConvLine(Double.parseDouble(markDField.getText()), MARK_DE);
                    markFField.setText(String.valueOf(mark.getMark()));
                    markDField.setText(String.valueOf(mark.markConversion(MARK_DE)));
                    markCHField.setText(String.valueOf(mark.markConversion(MARK_CH)));
                    verifyMark(markFField);
                    verifyCoefficient(coefficientField);
                }
                if (examAverage) {
                    updateAverage(markFField, markDField, markCHField);
                }


                System.out.println(mark.toString());
            }
        };

        //Event Handler for swiss mark entry
        EventHandler<ActionEvent> eventHandlerCHField = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Swiss field activated");
                if (!examAverage)
                    mark.setMarkName(markNameField.getText());
                if (!markCHField.getText().isEmpty()) {
                    System.out.println("Swiss field activated with a new mark");
                    mark.setMarkConvLine(Double.parseDouble(markCHField.getText()), MARK_CH);
                    markFField.setText(String.valueOf(mark.getMark()));
                    markDField.setText(String.valueOf(mark.markConversion(MARK_DE)));
                    markCHField.setText(String.valueOf(mark.markConversion(MARK_CH)));
                    verifyMark(markFField);
                    verifyCoefficient(coefficientField);
                }
                if (examAverage) {
                    updateAverage(markFField, markDField, markCHField);
                }


                System.out.println(mark.toString());
            }
        };

        //Event Handler for name and coefficient entry
        EventHandler<ActionEvent> eventHandlerField = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Name or coefficient field activated");
                if (!examAverage)
                    mark.setMarkName(markNameField.getText());
                verifyMark(markFField);
                verifyCoefficient(coefficientField);
                if (examAverage) {
                    updateAverage(markFField, markDField, markCHField);
                }
                System.out.println(mark.toString());
            }
        };

        //Event Handler for french mark no anymore focus
        markFField.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {

                if (oldValue)
                    if (!markFField.getText().equals(String.valueOf(mark.getMark()))) {
                        ActionEvent event = null;
                        eventHandlerFField.handle(event);

                    }
                if (examAverage) {
                    updateAverage(markFField, markDField, markCHField);
                }
            }
        });

        //Event Handler for german mark no anymore focus
        markDField.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {

                if (oldValue)
                    if (!markDField.getText().equals(String.valueOf(mark.markConversion(MARK_DE)))) {
                        ActionEvent event = null;
                        eventHandlerDField.handle(event);

                    }
                if (examAverage) {
                    updateAverage(markFField, markDField, markCHField);
                }
            }
        });

        //Event Handler for Swiss mark no anymore focus
        markCHField.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {

                if (oldValue)
                    if (!markCHField.getText().equals(String.valueOf(mark.markConversion(MARK_CH)))) {
                        ActionEvent event = null;
                        eventHandlerCHField.handle(event);

                    }
                if (examAverage) {
                    updateAverage(markFField, markDField, markCHField);
                }
            }
        });

        //Event Handler for coefficientField no anymore focus
        coefficientField.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!coefficientField.getText().equals(String.valueOf(mark.getCoefficient()))) {
                    ActionEvent event = null;
                    eventHandlerField.handle(event);
                }
                if (examAverage) {
                    updateAverage(markFField, markDField, markCHField);
                }

            }
        });

        //Event Handler for nameField no anymore focus
        markNameField.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!markNameField.getText().equals(String.valueOf(mark.getMarkName()))) {
                    ActionEvent event = null;
                    eventHandlerField.handle(event);
                }
                if (examAverage) {
                    updateAverage(markFField, markDField, markCHField);
                }


            }
        });


        //Set Event Handler entry on Textfields
        markNameField.setOnAction(eventHandlerField);
        coefficientField.setOnAction(eventHandlerField);
        markFField.setOnAction(eventHandlerFField);
        markDField.setOnAction(eventHandlerDField);
        markCHField.setOnAction(eventHandlerCHField);

        /*-----Mark adding-----*/

        //add mark to exam
        if (!examAverage)
            exam.addMark(mark);


        /*-----Add Elements to Layout-----*/

        //add all elements to hBox
        if (!examAverage)
            hBox.getChildren().add(markNameField);
        else if (exam.getClass().equals(new Exam().getClass()))
            hBox.getChildren().add(examAverageLabel);
        else if (exam.getClass().equals(new Subject().getClass()))
            hBox.getChildren().add(subjectAverageLabel);
        if (!exam.getClass().equals(new Subject().getClass()))
            hBox.getChildren().addAll(coefficientField, procent);
        hBox.getChildren().addAll(markFField, markDField, markCHField);
        //add HBox to the actual object
        this.getChildren().add(hBox);
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

    private void verifyMark(TextField textField) {
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


}
