package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
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

		hBox.setPadding(new Insets(10, 10, 10, 10)); //padding

		/*----Labels for Textfield description----*/

		Label markF = new Label("F Mark");
		Label markD = new Label("D Mark");
		Label markCH = new Label("CH Mark");
		Label warnLabel = new Label("");


		/*----Textfields----*/

		TextField markNameField = new TextField();
		markNameField.setPromptText("Name Test");

		TextField coefficientField = new TextField();
		coefficientField.setPromptText(String.valueOf(mark.getCoefficient()));

		TextField markFField = new TextField();
		markFField.setPromptText(String.valueOf(mark.getMark()));
		TextField markDField = new TextField();
		markDField.setPromptText(String.valueOf(mark.markConversion(MARK_DE)));
		TextField markCHField = new TextField();
		markCHField.setPromptText(String.valueOf(mark.markConversion(MARK_CH)));

		/*-----Eventhandler-----*/


		//Event Handler for french mark entry
		EventHandler<ActionEvent> eventHandlerFField = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				mark.setMarkName(markNameField.getText());
				System.out.println("French field activated");
				if (!markFField.getText().isEmpty()) {
					System.out.println("French field activated with a new mark");
					mark.setMark(Double.parseDouble(markFField.getText()));
					markFField.setText(String.valueOf(mark.getMark()));
					markDField.setText(String.valueOf(mark.markConversion(MARK_DE)));
					markCHField.setText(String.valueOf(mark.markConversion(MARK_CH)));
					warnLabel.setText(verifyMark(markFField, warnLabel.getText()));
					warnLabel.setText(verifyCoefficient(coefficientField, warnLabel.getText()));
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
				mark.setMarkName(markNameField.getText());
				System.out.println("German field activated");
				if (!markDField.getText().isEmpty()) {
					System.out.println("German field activated with a new mark");
					mark.setMarkConvLine(Double.parseDouble(markDField.getText()), MARK_DE);
					markFField.setText(String.valueOf(mark.getMark()));
					markDField.setText(String.valueOf(mark.markConversion(MARK_DE)));
					markCHField.setText(String.valueOf(mark.markConversion(MARK_CH)));
					warnLabel.setText(verifyMark(markFField, warnLabel.getText()));
					warnLabel.setText(verifyCoefficient(coefficientField, warnLabel.getText()));
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
				mark.setMarkName(markNameField.getText());
				if (!markCHField.getText().isEmpty()) {
					System.out.println("Swiss field activated with a new mark");
					mark.setMarkConvLine(Double.parseDouble(markCHField.getText()), MARK_CH);
					markFField.setText(String.valueOf(mark.getMark()));
					markDField.setText(String.valueOf(mark.markConversion(MARK_DE)));
					markCHField.setText(String.valueOf(mark.markConversion(MARK_CH)));
					warnLabel.setText(verifyMark(markFField, warnLabel.getText()));
					warnLabel.setText(verifyCoefficient(coefficientField, warnLabel.getText()));
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
				mark.setMarkName(markNameField.getText());
				warnLabel.setText(verifyMark(markFField, warnLabel.getText()));
				warnLabel.setText(verifyCoefficient(coefficientField, warnLabel.getText()));
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


		//add mark to exam
		if (!examAverage)
			exam.addMark(mark);
		//add all elements to hBox
		hBox.getChildren().addAll(markNameField, coefficientField, markF, markFField, markD, markDField, markCH, markCHField, warnLabel);
		//add HBox to the actual object
		this.getChildren().add(hBox);
	}


	/*------METHODS-------*/

	//verify if coefficient are entered
	private String verifyCoefficient(TextField textfield, String warnLabel) {
		System.out.println("Verification of coefficient entered or not");
		if (!(textfield.getText().isEmpty()) && (Double.parseDouble(textfield.getText()) >= 0) && (Double.parseDouble(textfield.getText()) <= 1.0)) {
			System.out.println("yes");
			mark.setCoefficient(Double.parseDouble(textfield.getText()));
			if (warnLabel.contains("Enter coefficient !!"))
				return "";
			else
				return (warnLabel + "");
		} else {
			System.out.println("no");
			if (warnLabel.contains("Enter coefficient !!") && warnLabel.contains("Enter Mark !!"))
				return "Enter Mark !! Enter coefficient !!";
			else
				return (warnLabel + " Enter coefficient !!");
		}
	}

	private String verifyMark(TextField textField, String warnLabel) {
		System.out.println("Verification of mark entered or not");
		if (!textField.getText().isEmpty()) {
			System.out.println("yes");
			return (warnLabel + "");
		} else {
			System.out.println("no");
			return warnLabel + " Enter Mark !!";

		}


	}

	public void updateAverage(TextField markFField, TextField markDField, TextField markCHField) {
		markFField.setText(String.valueOf(mark.getMark()));
		markDField.setText(String.valueOf(mark.markConversion(MARK_DE)));
		markCHField.setText(String.valueOf(mark.markConversion(MARK_CH)));
	}


}
