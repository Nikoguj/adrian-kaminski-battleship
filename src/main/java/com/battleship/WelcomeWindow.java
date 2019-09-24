package com.battleship;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class WelcomeWindow {
    public WelcomeWindow(GridPane gridPane, GUI gui, Player player1, Player player2)
    {
        Stage newWindow = new Stage();
        newWindow.setTitle("Second Stage");
        GridPane secondaryLayout = new GridPane();

        RowConstraints row1 = new RowConstraints();
        row1.setPrefHeight(350);
        RowConstraints row2 = new RowConstraints();
        row2.setPrefHeight(60);
        secondaryLayout.getRowConstraints().addAll(row1, row2);
        ColumnConstraints secondaryLayoutColumn1 = new ColumnConstraints();
        secondaryLayoutColumn1.setPrefWidth(560);
        secondaryLayout.getColumnConstraints().addAll(secondaryLayoutColumn1);

        GridPane secondaryLayoutBottom = new GridPane();
        //secondaryLayoutBottom.setGridLinesVisible(true);
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPrefWidth(120);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPrefWidth(120);
        ColumnConstraints column3 = new ColumnConstraints();
        column3.setPrefWidth(120);

        secondaryLayoutBottom.getColumnConstraints().addAll(column1,column2, column3);
        secondaryLayoutBottom.setAlignment(Pos.CENTER);
        GridPane.setConstraints(secondaryLayoutBottom, 0, 1);

        Label secondLabel = new Label("Enter your name = ");
        GridPane.setConstraints(secondLabel, 0, 0);

        TextField textField = new TextField();
        GridPane.setConstraints(textField, 1, 0);

        Button button = new Button("Start");
        button.setPrefSize(120, 30);
        GridPane.setConstraints(button, 2, 0);
        button.setOnAction(e ->{
            VariableContainer.PAYER_NAME = textField.getText();
            newWindow.close();
            System.out.println(VariableContainer.PAYER_NAME);
            gui.SpawnLabelWithName(gridPane, player1, player2);
        });

        secondaryLayoutBottom.getChildren().addAll(secondLabel, textField, button);

        secondaryLayout.setGridLinesVisible(true);
        secondaryLayout.getChildren().addAll(secondaryLayoutBottom);
        Scene secondScene = new Scene(secondaryLayout, 560, 340);

        newWindow.setScene(secondScene);
        newWindow.show();

    }
}
