package application;



import java.util.ArrayList;
import java.util.HashMap;




import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class XOGame extends Application{
	GridPane gp = new GridPane();
	Label turnL = new Label("Turn : X");
	Label resL = new Label("Result : ");
	Button userB = new Button("Two Players");
	Button computerB = new Button("One Player");
	VBox comps = new VBox();
	HBox buttons = new HBox();
	HBox xo = new HBox();
	Button x = new Button("X");
	Button o = new Button("O");
	HashMap<Integer,Cell> cells = new HashMap<>();
	
	@Override
	public void start(Stage arg) throws Exception {
		GameHandler gh = new GameHandler(this);
		// Align the turn Label in the center 
		turnL.setAlignment(Pos.CENTER);
		////////////////////////////////////
		
		int counter = 1;
		
		gp.setAlignment(Pos.CENTER);
		for(int i = 0 ; i < 3 ; i++) {
			for(int j = 0 ; j < 3 ; j++) {
				Cell c = new Cell();
				c.setOnMouseClicked(gh);
				cells.put(counter,c);
				gp.add(c, i, j);
				++counter;
			}
		}
		
		
		
		// Align the result Label in the center 
		resL.setAlignment(Pos.CENTER);
		/////////////////////////////////
		
	
		
		
		
		buttons.setAlignment(Pos.CENTER);
		buttons.setSpacing(10);
		
		userB.setOnMouseClicked(gh);
		computerB.setOnMouseClicked(gh);
		
		
		buttons.getChildren().addAll(userB,computerB);
	
	

		xo.setAlignment(Pos.CENTER);
		xo.setSpacing(10);
		
		x.setOnMouseClicked(gh);
		o.setOnMouseClicked(gh);
		xo.setVisible(false);
		
		xo.getChildren().addAll(x,o);
		
		comps.setAlignment(Pos.CENTER);
		comps.setSpacing(5);
		comps.getChildren().addAll(buttons,xo,turnL,gp,resL);
		
		
		Scene scene = new Scene(comps,500,500);
		arg.setScene(scene);
		arg.setTitle("XO Game with JAVAFX ");
		arg.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
