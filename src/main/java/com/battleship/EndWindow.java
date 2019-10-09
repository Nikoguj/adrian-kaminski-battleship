package com.battleship;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class EndWindow {
    public EndWindow(Player player) {
        Stage newWindow = new Stage();
        newWindow.setTitle("Thanks for game!");
        GridPane secondaryLayout = new GridPane();
        secondaryLayout.setAlignment(Pos.CENTER);

        RowConstraints row1 = new RowConstraints();
        row1.setPrefHeight(100);
        RowConstraints row2 = new RowConstraints();
        row2.setPrefHeight(40);
        secondaryLayout.getRowConstraints().addAll(row1, row2);
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPrefWidth(360);
        secondaryLayout.getColumnConstraints().addAll(column1);

        Label label = new Label(player.getName() + " win game!");
        label.setFont(new Font("Arial", 30));
        label.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
        label.setAlignment(Pos.CENTER);
        GridPane.setConstraints(label, 0, 0);

        Button button = new Button();
        GridPane.setConstraints(button, 0, 1);
        button.setText("EXIT");
        button.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Platform.exit();
            }
        });

        secondaryLayout.getChildren().addAll(label, button);
        Scene secondScene = new Scene(secondaryLayout, 360, 140);

        newWindow.setScene(secondScene);
        newWindow.show();
    }
}
