package sample;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.Parent;

public class MarkInterface extends Parent{	
	


	public MarkInterface() {

		GridPane gridpane = new GridPane();


	Label F_Note = new Label("F_Note");
	Label D_Note = new Label("D_Note");
	Label CH_Note = new Label("CH_Note");

		TextField test = new TextField();
		test.setPromptText(" Name Test ");

		TextField koeffzient = new TextField();
		koeffzient.setPromptText(" k ");

		TextField Fnote = new TextField();
		Fnote.setPromptText(" F ");
	TextField Dnote = new TextField();
		Fnote.setPromptText(" D ");
		TextField CHnote = new TextField();
		CHnote.setPromptText(" CH ");

	Button deleteButton = new Button("Löschen");
	Button neueNoteButton = new Button("neue Note");


		gridpane.add(test, 0, 0);
		gridpane.add(koeffzient, 1, 0);
		gridpane.add(F_Note, 2, 0);
		gridpane.add(Fnote, 3, 0);
		gridpane.add(D_Note, 4, 0);
		gridpane.add(Dnote, 5, 0);
		gridpane.add(CH_Note, 6, 0);
		gridpane.add(CHnote, 7, 0);

	GridPane.setConstraints(deleteButton, 8 , 0);
	GridPane.setConstraints(neueNoteButton, 4 , 1);
		this.getChildren().add(gridpane);
}
	
	
	
}
