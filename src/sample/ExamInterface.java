package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ExamInterface extends Parent {
	
	
	
	Exam exam = new Exam("Physik");
	int rowCount=1;
	
	
	public ExamInterface() {
		
		System.out.println("Constructeur of ExamInterface");
		
		//Layout Page
		VBox vBox = new VBox(10);
		
		//Layout Title line
		HBox hBoxTitleButton = new HBox(30);
		hBoxTitleButton.setAlignment(Pos.CENTER_LEFT);
		
		//Layout Subtiles
		HBox hBoxSubtitle = new HBox(30);
		hBoxSubtitle.setAlignment(Pos.BOTTOM_LEFT);
		
		//Layout Marks and delet boxees
		GridPane gridPane = new GridPane();    
		gridPane.setPadding(new Insets(0,0,0,0));
		gridPane.setAlignment(Pos.TOP_LEFT);
		gridPane.setHgap(10);    
		gridPane.setVgap(10);
		
		
		//Labels
		Label title = new Label(" Mathematik");
		title.setStyle("-fx-font: 30 berlin; -fx-font-weight: bold;");
		Label topic = new Label("   Fach                          ");
		topic.setStyle("-fx-font: 14 berlin; -fx-font-weight: bold;");
		Label coefficient = new Label("Koeffizient");
		coefficient.setStyle("-fx-font: 14 berlin; -fx-font-weight: bold;");
		Label fMark = new Label("F   ");
		fMark.setStyle("-fx-font: 14 berlin; -fx-font-weight: bold;");
		Label dMark = new Label("D ");
		dMark.setStyle("-fx-font: 14 berlin; -fx-font-weight: bold;");
		Label chMark = new Label("CH");
		chMark.setStyle("-fx-font: 14 berlin; -fx-font-weight: bold;");
		
		//Object MarkInterface
		MarkInterface mark1 = new MarkInterface(exam);
		
		//Buttons
		Button deleteButton = new Button("Delet");
		Button neueNoteButton = new Button("neue Note");
		
		//CheckBox cb1 = new CheckBox();
		
		//------- Set hBox----------
		hBoxTitleButton.getChildren().addAll(title, neueNoteButton, deleteButton);
		hBoxSubtitle.getChildren().addAll(topic, coefficient, fMark, dMark,chMark);
	

		//------- Set GridPane------
		
		gridPane.add(mark1, 0, 0);
		gridPane.add(new CheckBox(),1,0);
		
		
		
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
	
	
	vBox.getChildren().addAll(hBoxTitleButton, hBoxSubtitle, gridPane);
			
	//------ Print vBox--------
		
		this.getChildren().add(vBox);
            
	}

	

	public int incCounter() {
		rowCount++;
		return rowCount;
	}
}
