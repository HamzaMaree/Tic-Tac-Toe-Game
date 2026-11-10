package application;

import java.util.ArrayList;
import java.util.Random;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

public class GameHandler implements EventHandler<MouseEvent> {

	
	XOGame frame;
	public GameHandler(XOGame frame) {
		this.frame = frame;
	}
	
	int xx = 0;
	int computerTurn = -1; // 0 : X ,  1 : O
	int turn = 0;
	int flag = 0;
	ArrayList<Cell> turns = new ArrayList<>();
	ArrayList<Integer> computer = new ArrayList<>();
	Random random = new Random();
	@Override
	public void handle(MouseEvent arg) {
		
		
		if(arg.getSource() == frame.userB) {
			xx = 1;
		}else if(arg.getSource() == frame.computerB) {
			xx = 2;
		}
		
		if(xx == 1) {
			frame.userB.setStyle("-fx-border-color : black;");
			frame.buttons.setDisable(true);
			
			if(frame.cells.values().contains(arg.getSource()) == true) {
				if((turn+1) % 2 == 0)
					frame.turnL.setText("Turn : X");
				else 
					frame.turnL.setText("Turn : O");
				
				if(turn%2 == 0 && turns.contains(arg.getSource()) == false) {
					((Cell)arg.getSource()).setText("X");
					++turn;
					turns.add((Cell)arg.getSource());
					if(check() == 0) {
						return;
					}
				}else if(turn%2 == 1 && turns.contains(arg.getSource()) == false) {
					((Cell)arg.getSource()).setText("O");
					++turn;
					turns.add((Cell)arg.getSource());
					if(check() == 0) {
						return;
					}
				}
				
				
			}
		}
		else if(xx == 2) {
			frame.computerB.setStyle("-fx-border-color : black;");
			frame.buttons.setDisable(true);
			frame.xo.setVisible(true);
			if(arg.getSource() == frame.x) {
				frame.x.setStyle("-fx-border-color : black;");
				frame.xo.setDisable(true);
				computerTurn = 1;
			}else if(arg.getSource() == frame.o) {
				frame.o.setStyle("-fx-border-color : black;");
				frame.xo.setDisable(true);
				computerTurn = 0;
			}
			
			
				
				
			if(computerTurn == 1) {
					
					if(arg.getSource() instanceof Cell & turns.contains(arg.getSource()) == false) {
						((Cell)arg.getSource()).setText("X");
						turns.add((Cell)arg.getSource());
						turn++;
						for(int i : frame.cells.keySet()) {
							if(frame.cells.get(i) == (Cell)arg.getSource()) {
								computer.add(i);
							}
						}
						if(check() == 0) {
							return;
						}
						//System.out.println(frame.cells.values().contains(arg.getSource()));
						
						
						int r = random.nextInt(9)+1;
						while(computer.contains(r) == true) {
							r = random.nextInt(9)+1;	
						}
						turn++;
						computer.add(r);
							for(int i : frame.cells.keySet()) {
								if(i == r) {
									frame.cells.get(r).setText("O");
									turns.add(frame.cells.get(r));
								}
							}
							if(check() == 0) {
								return;
							}	
					}
					
					
					
				}
				else if(computerTurn == 0) {
					frame.turnL.setText("Turn : " + "O");
					if(arg.getSource() instanceof Cell & turns.contains(arg.getSource()) == false) {
						((Cell)arg.getSource()).setText("O");
						turns.add((Cell)arg.getSource());
						for(int i : frame.cells.keySet()) {
							if(frame.cells.get(i) == (Cell)arg.getSource()) {
								computer.add(i);
							}
						}
						if(check() == 0) {
							return;
						}
						frame.turnL.setText("Turn : " + "X");
						int r = random.nextInt(9)+1;
						while(computer.contains(r) == true) {
							r = random.nextInt(9)+1;	
						}
						
						computer.add(r);
							for(int i : frame.cells.keySet()) {
								if(i == r) {
									frame.cells.get(r).setText("X");
									turns.add(frame.cells.get(r));
								}
							}
							if(check() == 0) {
								return;
							}
					}
					
					
					
					
				}
				
			}
			
			
		}
		
		
		// System.out.println(frame.cells.get(arg.getSource()));
		
		
	
	
	public int check() {
		if(frame.cells.get(1).getText().equals("X") && frame.cells.get(2).getText().equals("X") && frame.cells.get(3).getText().equals("X")) {
					
					frame.resL.setText("Result : " + "X Won !");
					frame.gp.setDisable(true);
					return 0;
		}
		else if(frame.cells.get(4).getText().equals("X") && frame.cells.get(5).getText().equals("X") && frame.cells.get(6).getText().equals("X")) {
			frame.resL.setText("Result : " + "X Won !");
			frame.gp.setDisable(true);
			return 0;
		}
		else if(frame.cells.get(7).getText().equals("X") && frame.cells.get(8).getText().equals("X") && frame.cells.get(9).getText().equals("X")) {
			frame.resL.setText("Result : " + "X Won !");
			frame.gp.setDisable(true);
			return 0;
		}
		else if(frame.cells.get(1).getText().equals("X") && frame.cells.get(4).getText().equals("X") && frame.cells.get(7).getText().equals("X")) {
			frame.resL.setText("Result : " + "X Won !");
			frame.gp.setDisable(true);
			return 0;
		}
		else if(frame.cells.get(2).getText().equals("X") && frame.cells.get(5).getText().equals("X") && frame.cells.get(8).getText().equals("X")) {
			frame.resL.setText("Result : " + "X Won !");
			frame.gp.setDisable(true);
			return 0;
		}
		else if(frame.cells.get(3).getText().equals("X") && frame.cells.get(6).getText().equals("X") && frame.cells.get(9).getText().equals("X")) {
			frame.resL.setText("Result : " + "X Won !");
			frame.gp.setDisable(true);
			return 0;
		}
		else if(frame.cells.get(1).getText().equals("X") && frame.cells.get(5).getText().equals("X") && frame.cells.get(9).getText().equals("X")) {
			frame.resL.setText("Result : " + "X Won !");
			frame.gp.setDisable(true);
			return 0;
		}
		else if(frame.cells.get(3).getText().equals("X") && frame.cells.get(5).getText().equals("X") && frame.cells.get(7).getText().equals("X")) {
			frame.resL.setText("Result : " + "X Won !");
			frame.gp.setDisable(true);
			return 0;
		}
		else if(frame.cells.get(1).getText().equals("O") && frame.cells.get(2).getText().equals("O") && frame.cells.get(3).getText().equals("O")) {
			frame.resL.setText("Result : " + "O Won !");
			frame.gp.setDisable(true);
			return 0;
		}
		else if(frame.cells.get(4).getText().equals("O") && frame.cells.get(5).getText().equals("O") && frame.cells.get(6).getText().equals("O")) {
			frame.resL.setText("Result : " + "O Won !");
			frame.gp.setDisable(true);
			return 0;
		}
		else if(frame.cells.get(7).getText().equals("O") && frame.cells.get(8).getText().equals("O") && frame.cells.get(9).getText().equals("O")) {
			frame.resL.setText("Result : " + "O Won !");
			frame.gp.setDisable(true);
			return 0;
		}
		else if(frame.cells.get(1).getText().equals("O") && frame.cells.get(4).getText().equals("O") && frame.cells.get(7).getText().equals("O")) {
			frame.resL.setText("Result : " + "O Won !");
			frame.gp.setDisable(true);
			return 0;
		}
		else if(frame.cells.get(2).getText().equals("O") && frame.cells.get(5).getText().equals("O") && frame.cells.get(8).getText().equals("O")) {
			frame.resL.setText("Result : " + "O Won !");
			frame.gp.setDisable(true);
			return 0;
		}
		else if(frame.cells.get(3).getText().equals("O") && frame.cells.get(6).getText().equals("O") && frame.cells.get(9).getText().equals("O")) {
			frame.resL.setText("Result : " + "O Won !");
			frame.gp.setDisable(true);
			return 0;
		}
		else if(frame.cells.get(1).getText().equals("O") && frame.cells.get(5).getText().equals("O") && frame.cells.get(9).getText().equals("O")) {
			frame.resL.setText("Result : " + "O Won !");
			frame.gp.setDisable(true);
			return 0;
		}
		else if(frame.cells.get(3).getText().equals("O") && frame.cells.get(5).getText().equals("O") && frame.cells.get(7).getText().equals("O")) {
			frame.resL.setText("Result : " + "O Won !");
			frame.gp.setDisable(true);
			return 0;
		}
		if(turn == 9) {
			frame.resL.setText("Result : " + "Draw !");
			frame.gp.setDisable(true);
			return 0;
		}
		
		return 1;
	}

}
