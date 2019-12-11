package sample;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

import javafx.scene.layout.GridPane;

public class ExamInterface extends Parent {
	
	
	
	Exam exam = new Exam("Physik");

	int rowCount=1;
	
	
	private ArrayList<MarkInterface> markInterfaceArrayList = new ArrayList<>();
	
	
		
	
	
	
	
	class DeleteButtonEvent implements EventHandler<ActionEvent> {
		
		private final int number;
		GridPane gridPane;
		DeleteButtonEvent(int number, GridPane grid){
			this.gridPane = grid;
		
		
		this.number= number;
		}
		
		@Override
		
		public void handle (ActionEvent event) {
			
		gridPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == number);
		markInterfaceArrayList.remove(number);
		
			
	//	exam.deleteMark(number);
		
		
			
		}
		
		
	}
	
	public ExamInterface() {
		
		System.out.println("Constructeur of ExamInterface");
		
		GridPane gridPane = new GridPane();    
		gridPane.setPadding(new Insets(10,10,10,10));   
		gridPane.setHgap(10);    
		gridPane.setVgap(10);
		
	//	MarkInterface mark1 = new MarkInterface(exam);
		
	//	Button deleteButton = new Button("Löschen");
		Button neueNoteButton = new Button("neue Note");
		
	

		//------- Set GridPane------
		
		//gridPane.add(mark1, 0, 1);
		//gridPane.add(deleteButton, 1, 1);
		  gridPane.add(neueNoteButton, 0 , 0);
		//gridPane.add(new CheckBox(),1,1);
		
		
		
		//-----Action Buttons (Neue Note) -----
         
		
		neueNoteButton.setOnAction(e -> {
		
			markInterfaceArrayList.add(new MarkInterface(exam));
			
			gridPane.add(createDeleteButton(markInterfaceArrayList.size()+1, gridPane), 1, markInterfaceArrayList.size()+1);
			
			gridPane.add(markInterfaceArrayList.get(markInterfaceArrayList.size()-1),0,markInterfaceArrayList.size()+1);
			
	  	
			

			
	
		});
		
	
			
	//------ Print GridPane--------
		
		
		this.getChildren().add(gridPane);
            
	}

	

	public int incCounter() {
		rowCount++;
		return rowCount;
	}
	
	public Button createDeleteButton (int number, GridPane gridPane) {
		
		
		Button deleteButton = new Button ("Löschen");
		deleteButton.setOnAction(new DeleteButtonEvent(number, gridPane));
		
		
		
		return deleteButton;
	}
	
	
		
}
