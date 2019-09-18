package com.battleship;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class BattleshipApplication extends Application {

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane gridPane = new GridPane();

        GUI gui = new GUI();

        gui.SetBackgroundOnGrid(gridPane);
        gui.SetRowColumnHeightWeight(gridPane);

        GridPane player1ShipsChoose = new GridPane();
        GridPane player2ShipsChoose = new GridPane();
        gui.MakeGridPaneForShipsChoose(gridPane, player1ShipsChoose, 0);
        gui.MakeGridPaneForShipsChoose(gridPane, player2ShipsChoose, 1);

        gui.MakeGridShipChoose(player1ShipsChoose);
        gui.MakeGridShipChoose(player2ShipsChoose);

        Array array = new Array();
        array.SetArrayEmpty();

        Ship ship = new Ship();
        Bridge bridge = new Bridge();
        gui.SpawnButtonInChoose(ship, VariableContainer.array, bridge);

        GridPane player1Board = new GridPane();
        GridPane player2Board = new GridPane();

        gui.MakeGridBoard(gridPane, player1Board, 0);
        gui.MakeGridBoard(gridPane, player2Board, 1);

        gui.SpawnIndexInGrid(player1Board);
        gui.SpawnIndexInGrid(player2Board);

        gui.SpawnButtonInBoard(1, ship, VariableContainer.array, bridge, player1Board);

        gridPane.setAlignment(Pos.CENTER);
        gridPane.setGridLinesVisible(true);
        gridPane.getChildren().addAll();
        Scene scene = new Scene(gridPane, 960, 540);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
