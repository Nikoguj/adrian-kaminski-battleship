package com.battleship;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class BattleshipApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane gridPane = new GridPane();
        GridPane player1ShipsChoose = new GridPane();
        GridPane player2ShipsChoose = new GridPane();

        Array array = new Array();
        array.SetArrayEmpty(VariableContainer.array);

        Logic logic = new Logic();
        Bridge bridge = new Bridge();
        Computer computer = new Computer();

        GridPane player1Board = new GridPane();
        GridPane player2Board = new GridPane();

        Player player1 = new Player(VariableContainer.PAYER_NAME, false);
        Player player2 = new Player("Computer", false);

        computer.FillComputerArray();

        GUI gui = new GUI(gridPane, player1ShipsChoose, player2ShipsChoose, logic, bridge, player1Board, player2Board, player1, player2, computer);

        primaryStage.setTitle("Battleship");
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setGridLinesVisible(true);
        gridPane.getChildren().addAll();
        Scene scene = new Scene(gridPane, 960, 560);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();


        //Welcome window
        WelcomeWindow welcomeWindow = new WelcomeWindow(gridPane, gui, player1, player2);
    }
}
