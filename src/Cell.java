package application;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class Cell extends Label {

	public Cell() {
		this.setPrefHeight(120);
		this.setPrefWidth(120);
		this.setAlignment(Pos.CENTER);
		this.setFont(new Font(20));
		this.setStyle("-fx-border-color : black ; -fx-border-width : 4px;");
	}
}
