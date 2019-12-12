package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;

public class MarkInterface extends Parent {


	private static final int MARK_FR = 0;
	private static final int MARK_DE = 1;
	private static final int MARK_CH = 2;


	Mark mark = new Mark();


	/*------CONSTRUCTOR------*/


	public MarkInterface(Exam exam) {
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

		//Event Handler for french entry
		EventHandler<ActionEvent> eventHandlerFField = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				mark.setMarkName(markNameField.getText());
				System.out.println("French field activated");
				if (!markFField.getText().isEmpty()) {
					System.out.println("French field activated with a mark");
					mark.setMark(Double.parseDouble(markFField.getText()));
					markFField.setText(String.valueOf(mark.getMark()));
					markDField.setText(String.valueOf(mark.markConversion(MARK_DE)));
					markCHField.setText(String.valueOf(mark.markConversion(MARK_CH)));
				}

				warnLabel.setText(verifyCoefficient(coefficientField, warnLabel.getText()));

				System.out.println(mark.toString());
			}
		};

		//Event Handler for german entry
		EventHandler<ActionEvent> eventHandlerDField = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				mark.setMarkName(markNameField.getText());
				System.out.println("German field activated");
				if (!markDField.getText().isEmpty()) {
					System.out.println("German field activated with a mark");
					mark.setMarkConvLine(Double.parseDouble(markDField.getText()), MARK_DE);
					markFField.setText(String.valueOf(mark.getMark()));
					markDField.setText(String.valueOf(mark.markConversion(MARK_DE)));
					markCHField.setText(String.valueOf(mark.markConversion(MARK_CH)));
				}

				warnLabel.setText(verifyCoefficient(coefficientField, warnLabel.getText()));

				System.out.println(mark.toString());
			}
		};

		//Event Handler for swiss entry
		EventHandler<ActionEvent> eventHandlerCHField = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Swiss field activated");
				mark.setMarkName(markNameField.getText());
				if (!markCHField.getText().isEmpty()) {
					System.out.println("Swiss field activated with a mark");
					mark.setMarkConvLine(Double.parseDouble(markCHField.getText()), MARK_CH);
					markFField.setText(String.valueOf(mark.getMark()));
					markDField.setText(String.valueOf(mark.markConversion(MARK_DE)));
					markCHField.setText(String.valueOf(mark.markConversion(MARK_CH)));
				}

				warnLabel.setText(verifyCoefficient(coefficientField, warnLabel.getText()));

				System.out.println(mark.toString());
			}
		};

		//Event Handler for name and coefficient entry
		EventHandler<ActionEvent> eventHandlerField = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Name or coefficient field activated");
				mark.setMarkName(markNameField.getText());
				if (!markFField.getText().isEmpty()) {
					eventHandlerFField.handle(event);
				} else if (!markDField.getText().isEmpty()) {
					eventHandlerDField.handle(event);
				} else if (!markCHField.getText().isEmpty()) {
					eventHandlerCHField.handle(event);
				} else
					warnLabel.setText("Enter Mark !!");


				warnLabel.setText(verifyCoefficient(coefficientField, warnLabel.getText()));


				System.out.println(mark.toString());
			}
		};

		//Set Event Handler on Textfields
		markNameField.setOnAction(eventHandlerField);
		coefficientField.setOnAction(eventHandlerField);
		markFField.setOnAction(eventHandlerFField);
		markDField.setOnAction(eventHandlerDField);
		markCHField.setOnAction(eventHandlerCHField);


		//add mark to exam
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
			mark.setCoefficient(Double.parseDouble(textfield.getText()));
			if (warnLabel.equals("Enter coefficient !!"))
				return "";
			else
				return (warnLabel + "");
		} else
			return (warnLabel + "Enter coefficient !!");
	}


	public Mark getMark() {
		return mark;
	}


}
