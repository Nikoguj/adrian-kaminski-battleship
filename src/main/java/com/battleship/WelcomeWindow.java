package com.battleship;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WelcomeWindow {
    public WelcomeWindow(GridPane gridPane, GUI gui, Player player1, Player player2) {
        Stage newWindow = new Stage();
        newWindow.setTitle("Welcome in Battleship!");
        GridPane secondaryLayout = new GridPane();
        secondaryLayout.setAlignment(Pos.CENTER);

        GridPane topGridPane = new GridPane();

        Label firstLine = new Label("Battleship game rules:");
        firstLine.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        firstLine.setFont(Font.font("", 20));
        firstLine.setAlignment(Pos.CENTER);
        GridPane.setConstraints(firstLine, 0, 0);


        Label rulesLabel = new Label();
        GridPane.setConstraints(rulesLabel, 0, 1);
        topGridPane.getChildren().addAll(firstLine, rulesLabel);

        ClassLoader classLoader = getClass().getClassLoader();
        File file= new File(classLoader.getResource("rules.txt").getFile());
        Path path = Paths.get(file.getPath());

        try {
            Stream<String> fileLines = Files.lines(path);

            String rulesString = fileLines.collect(Collectors.joining("\n"));
            rulesLabel.setText(rulesString);
        } catch (IOException e) {
            e.printStackTrace();
        }

        rulesLabel.setFont(Font.font("", 16));
        rulesLabel.setWrapText(true);
        rulesLabel.setTextAlignment(TextAlignment.JUSTIFY);
        //rulesLabel.setTextAlignment(TextAlignment.CENTER);


        RowConstraints row1 = new RowConstraints();
        row1.setPrefHeight(300);
        RowConstraints row2 = new RowConstraints();
        row2.setPrefHeight(60);
        secondaryLayout.getRowConstraints().addAll(row1, row2);
        ColumnConstraints secondaryLayoutColumn1 = new ColumnConstraints();
        secondaryLayoutColumn1.setPrefWidth(550);
        secondaryLayout.getColumnConstraints().addAll(secondaryLayoutColumn1);

        GridPane secondaryLayoutBottom = new GridPane();
        //secondaryLayoutBottom.setGridLinesVisible(true);
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPrefWidth(120);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPrefWidth(120);
        ColumnConstraints column3 = new ColumnConstraints();
        column3.setPrefWidth(120);

        secondaryLayoutBottom.getColumnConstraints().addAll(column1, column2, column3);
        secondaryLayoutBottom.setAlignment(Pos.CENTER);
        GridPane.setConstraints(secondaryLayoutBottom, 0, 1);

        Label secondLabel = new Label("Enter your name = ");
        GridPane.setConstraints(secondLabel, 0, 0);

        TextField textField = new TextField();
        GridPane.setConstraints(textField, 1, 0);

        Button button = new Button("Start");
        button.setPrefSize(120, 30);
        GridPane.setConstraints(button, 2, 0);
        button.setOnAction(e -> {
            VariableContainer.PAYER_NAME = textField.getText();
            newWindow.close();
            System.out.println(VariableContainer.PAYER_NAME);
            gui.SpawnLabelWithName(gridPane, player1, player2);
        });

        secondaryLayoutBottom.getChildren().addAll(secondLabel, textField, button);

        //secondaryLayout.setGridLinesVisible(true);
        secondaryLayout.getChildren().addAll(secondaryLayoutBottom, topGridPane);
        Scene secondScene = new Scene(secondaryLayout, 560, 340);

        newWindow.setScene(secondScene);
        newWindow.show();

    }
}
