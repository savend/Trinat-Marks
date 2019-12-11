package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

import javafx.scene.layout.GridPane;

public class ExamInterface extends Parent {
	
	
	
	Exam exam = new Exam("Physik");
	int rowCount=1;
	
	
	public ExamInterface() {
		
		System.out.println("Constructeur of ExamInterface");
		
		GridPane gridPane = new GridPane();    
		gridPane.setPadding(new Insets(10,10,10,10));   
		gridPane.setHgap(10);    
		gridPane.setVgap(10);
		
		MarkInterface mark1 = new MarkInterface(exam);
		
		Button deleteButton = new Button("Löschen");
		Button neueNoteButton = new Button("neue Note");
		
		//CheckBox cb1 = new CheckBox();

		//------- Set GridPane------
		
		gridPane.add(mark1, 0, 1);
		gridPane.add(deleteButton, 1, 0);
		gridPane.add(neueNoteButton, 0 , 0);
		gridPane.add(new CheckBox(),1,1);
		
		
		
		//-----Action Buttons (Neue Note) -----
         
		
		neueNoteButton.setOnAction(e -> {
		
			
			gridPane.add(new MarkInterface(exam),0,rowCount+1);
			
			gridPane.add(new CheckBox(),1,rowCount+1);
		
			

			rowCount = rowCount+1;
			
	
		});
		
		/// -----Action Button (delete Checkbox)--------
		
			deleteButton.setOnAction(e -> {
				
				if (new CheckBox().isSelected()){
					
				//	gridPane.getChildren().removeIf(node -> GridPane.getRowIndex());
				}
				
				/*	if(new CheckBox().isSelected()) {
					
					gridPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 2);
				}*/
				
					
				//gridPane.getChildren().removeRow();
				//	gridPane.removeAll();
				//getSelectedItems().clear();
			
				//rowCount = rowCount-1;
			
		});
		
	
			
	//------ Print GridPane--------
		
		
		this.getChildren().add(gridPane);
            
	}

	

	public int incCounter() {
		rowCount++;
		return rowCount;
	}
}
