package com.battleship;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import javax.swing.*;
import java.util.ArrayList;

public class GUI {

    public GUI(GridPane gridPane, GridPane player1ShipsChoose, GridPane player2ShipsChoose, Logic logic, Bridge bridge, GridPane player1Board,  GridPane player2Board, Player player1, Player player2, Computer computer) {
        SetBackgroundOnGrid(gridPane);
        SetRowColumnHeightWeight(gridPane);
        MakeGridPaneForShipsChoose(gridPane, player1ShipsChoose, 0);
        MakeGridPaneForShipsChoose(gridPane, player2ShipsChoose, 1);
        MakeGridShipChoose(player1ShipsChoose);
        MakeGridShipChoose(player2ShipsChoose);
        SpawnButtonInChoosePlayer(logic, VariableContainer.array, bridge, gridPane);
        SpawnButtonInChooseComputer();
        FillLabelOnStart(player1ShipsChoose, true);
        FillLabelOnStart(player2ShipsChoose, false);
        MakeGridBoard(gridPane, player1Board, 0);
        MakeGridBoard(gridPane, player2Board, 1);
        SpawnIndexInGrid(player1Board);
        SpawnIndexInGrid(player2Board);
        SpawnLabelHowManyLeftToPlace(gridPane);
        SpawnButtonInPayerBoard(logic, VariableContainer.array, bridge, player1Board, player1, gridPane);
        SpawnButtonInComputerBoard(player2Board, bridge, logic, player1, computer, player2);
    }

    public void SetBackgroundOnGrid(GridPane gridPane) {
        Image backgroundImage = new Image("background.jpg");
        BackgroundSize backgroundSize = new BackgroundSize(960, 560, false, false, false, true);
        BackgroundImage myBI = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, backgroundSize);
        gridPane.setBackground(new Background(myBI));
    }

    public void SetRowColumnHeightWeight(GridPane gridPane) {
        RowConstraints row1 = new RowConstraints();
        row1.setPrefHeight(40);
        RowConstraints row2 = new RowConstraints();
        row2.setPrefHeight(80);
        RowConstraints row3 = new RowConstraints();
        row3.setPrefHeight(420);
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPrefWidth(480);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPrefWidth(480);

        gridPane.getRowConstraints().addAll(row1, row2, row3);
        gridPane.getColumnConstraints().addAll(column1, column2);
    }

    public static Label label = new Label();

    public void SpawnLabelHowManyLeftToPlace(GridPane gridPane) {
        try {
            label.setText("How many boxes left to place = " + VariableContainer.HOW_MANY_LEFT_TO_PLACE);
            label.setPrefHeight(50);
            label.setMaxWidth(Double.MAX_VALUE);
            label.setAlignment(Pos.CENTER);
            GridPane.setConstraints(label, 0, 3);
            gridPane.getChildren().addAll(label);
        } catch (Exception e) {

        }
    }

    public void SpawnLabelWithName(GridPane gridPane, Player player1, Player player2) {
        Label label = new Label(VariableContainer.PAYER_NAME);
        label.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        label.setAlignment(Pos.CENTER);
        GridPane.setConstraints(label, 0, 0);
        Label label2 = new Label(player2.getName());
        label2.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        label2.setAlignment(Pos.CENTER);
        GridPane.setConstraints(label2, 1, 0);
        gridPane.getChildren().addAll(label, label2);
    }

    public void MakeGridPaneForShipsChoose(GridPane gridPane, GridPane playerShips, int whichColumn) {
        ColumnConstraints shipsColumn1 = new ColumnConstraints();
        shipsColumn1.setPrefWidth(130);
        ColumnConstraints shipsColumn2 = new ColumnConstraints();
        shipsColumn2.setPrefWidth(100);
        ColumnConstraints shipsColumn3 = new ColumnConstraints();
        shipsColumn3.setPrefWidth(80);
        ColumnConstraints shipsColumn4 = new ColumnConstraints();
        shipsColumn4.setPrefWidth(40);
        playerShips.getColumnConstraints().addAll(shipsColumn1, shipsColumn2, shipsColumn3, shipsColumn4);

        RowConstraints shipRow1 = new RowConstraints();
        shipRow1.setPrefHeight(55);
        RowConstraints shipRow2 = new RowConstraints();
        shipRow2.setPrefHeight(25);
        playerShips.getRowConstraints().addAll(shipRow1, shipRow2);

        playerShips.setAlignment(Pos.CENTER);
        //playerShips.setGridLinesVisible(true);
        GridPane.setConstraints(playerShips, whichColumn, 1);

        gridPane.getChildren().addAll(playerShips);
    }

    public void FillLabelOnStart(GridPane playerShips, boolean player) {
        if (player) {
            Label label1 = new Label(String.valueOf(VariableContainer.PLAYER1_FOUR_MASTED_SHIP));
            Label label2 = new Label(String.valueOf(VariableContainer.PLAYER1_THREE_MASTED_SHIP));
            Label label3 = new Label(String.valueOf(VariableContainer.PLAYER1_TWO_MASTED_SHIP));
            Label label4 = new Label(String.valueOf(VariableContainer.PLAYER1_ONE_MASTED_SHIP));

            LabelSettings(label1, label2, label3, label4);

            VariableContainer.PLAYER1_FOUR_MASTED_SHIP_LABEL = label1;
            VariableContainer.PLAYER1_THREE_MASTED_SHIP_LABEL = label2;
            VariableContainer.PLAYER1_TWO_MASTED_SHIP_LABEL = label3;
            VariableContainer.PLAYER1_ONE_MASTED_SHIP_LABEL = label4;


            GridPane.setConstraints(label1, 0, 1);
            GridPane.setConstraints(label2, 1, 1);
            GridPane.setConstraints(label3, 2, 1);
            GridPane.setConstraints(label4, 3, 1);

            playerShips.getChildren().addAll(label1, label2, label3, label4);
        } else {
            Label label1 = new Label(String.valueOf(VariableContainer.PLAYER2_FOUR_MASTED_SHIP));
            Label label2 = new Label(String.valueOf(VariableContainer.PLAYER2_THREE_MASTED_SHIP));
            Label label3 = new Label(String.valueOf(VariableContainer.PLAYER2_TWO_MASTED_SHIP));
            Label label4 = new Label(String.valueOf(VariableContainer.PLAYER2_ONE_MASTED_SHIP));

            VariableContainer.PLAYER2_FOUR_MASTED_SHIP_LABEL = label1;
            VariableContainer.PLAYER2_THREE_MASTED_SHIP_LABEL = label2;
            VariableContainer.PLAYER2_TWO_MASTED_SHIP_LABEL = label3;
            VariableContainer.PLAYER2_ONE_MASTED_SHIP_LABEL = label4;

            LabelSettings(label1, label2, label3, label4);

            GridPane.setConstraints(label1, 0, 1);
            GridPane.setConstraints(label2, 1, 1);
            GridPane.setConstraints(label3, 2, 1);
            GridPane.setConstraints(label4, 3, 1);

            playerShips.getChildren().addAll(label1, label2, label3, label4);
        }
    }

    private void LabelSettings(Label label1, Label label2, Label label3, Label label4) {
        label1.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        label2.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        label3.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        label4.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        label1.setAlignment(Pos.CENTER);
        label2.setAlignment(Pos.CENTER);
        label3.setAlignment(Pos.CENTER);
        label4.setAlignment(Pos.CENTER);
    }

    public static ArrayList<GridPane> arrayListGridPane = new ArrayList<>();


    public void MakeGridShipChoose(GridPane playerShip) {
        RowConstraints shipRow = new RowConstraints();
        shipRow.setPrefHeight(27);
        ColumnConstraints shipColumn = new ColumnConstraints();
        shipColumn.setPrefWidth(27);

        for (int i = 0; i < 4; i++) {
            GridPane shipGrid = new GridPane();
            arrayListGridPane.add(shipGrid);
            shipGrid.getRowConstraints().addAll(shipRow);
            for (int j = 0; j < 4 - i; j++) {
                shipGrid.getColumnConstraints().addAll(shipColumn);
            }
            shipGrid.setAlignment(Pos.CENTER);
            shipGrid.setGridLinesVisible(true);

            GridPane.setConstraints(shipGrid, i, 0);
            playerShip.getChildren().addAll(shipGrid);
        }
    }

    public void MakeGridBoard(GridPane gridPane, GridPane playerBoard, int columnInGrid) {
        for (int i = 0; i < 11; i++) {
            RowConstraints row = new RowConstraints(35);
            playerBoard.getRowConstraints().add(row);
            ColumnConstraints column = new ColumnConstraints(35);
            playerBoard.getColumnConstraints().add(column);
        }
        playerBoard.setGridLinesVisible(true);
        playerBoard.setAlignment(Pos.CENTER);
        GridPane.setConstraints(playerBoard, columnInGrid, 2);
        gridPane.getChildren().addAll(playerBoard);
    }

    public void SpawnIndexInGrid(GridPane playerBoard) {
        for (int i = 0; i < 10; i++) {
            Label number = new Label(String.valueOf(i + 1));
            GridPane.setConstraints(number, 0, i + 1);

            Label letter = new Label(Character.toString((char) (65 + i)));
            GridPane.setConstraints(letter, i + 1, 0);

            number.setMaxWidth(Double.MAX_VALUE);
            letter.setMaxWidth(Double.MAX_VALUE);
            number.setAlignment(Pos.CENTER);
            letter.setAlignment(Pos.CENTER);
            playerBoard.getChildren().addAll(number, letter);
        }
    }

    public void SpawnButtonInChooseComputer() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4 - i; j++) {
                Button button = new Button();
                button.setStyle(VariableContainer.PLACECOLOUR);
                button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                GridPane.setConstraints(button, j, 0);
                arrayListGridPane.get(i + 4).getChildren().addAll(button);
            }
        }
    }

    Array array1 = new Array();

    public void SpawnButtonInChoosePlayer(Logic logic, String[][] array, Bridge bridge, GridPane gridPane) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4 - i; j++) {
                Button button = new Button();
                button.setStyle(VariableContainer.PLACECOLOUR);
                if (i == 0) {
                    button.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            if (VariableContainer.HOW_MANY_LEFT_TO_PLACE == 0 && VariableContainer.PLAYER1_FOUR_MASTED_SHIP > 0) {
                                bridge.PlayerChooseShip(4, logic, array);
                                SetColourButtonInPlayerBoard();
                                VariableContainer.PLAYER1_FOUR_MASTED_SHIP = VariableContainer.PLAYER1_FOUR_MASTED_SHIP - 1;
                                VariableContainer.PLAYER1_FOUR_MASTED_SHIP_LABEL.setText(String.valueOf(VariableContainer.PLAYER1_FOUR_MASTED_SHIP));
                                SpawnLabelHowManyLeftToPlace(gridPane);
                            }
                        }
                    });
                } else if (i == 1) {
                    button.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            if (VariableContainer.HOW_MANY_LEFT_TO_PLACE == 0 && VariableContainer.PLAYER1_THREE_MASTED_SHIP > 0) {
                                bridge.PlayerChooseShip(3, logic, array);
                                SetColourButtonInPlayerBoard();

                                VariableContainer.PLAYER1_THREE_MASTED_SHIP = VariableContainer.PLAYER1_THREE_MASTED_SHIP - 1;
                                VariableContainer.PLAYER1_THREE_MASTED_SHIP_LABEL.setText(String.valueOf(VariableContainer.PLAYER1_THREE_MASTED_SHIP));
                                SpawnLabelHowManyLeftToPlace(gridPane);
                            }
                        }
                    });
                } else if (i == 2) {
                    button.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            if (VariableContainer.HOW_MANY_LEFT_TO_PLACE == 0 && VariableContainer.PLAYER1_TWO_MASTED_SHIP > 0) {
                                bridge.PlayerChooseShip(2, logic, array);
                                SetColourButtonInPlayerBoard();
                                VariableContainer.PLAYER1_TWO_MASTED_SHIP = VariableContainer.PLAYER1_TWO_MASTED_SHIP - 1;
                                VariableContainer.PLAYER1_TWO_MASTED_SHIP_LABEL.setText(String.valueOf(VariableContainer.PLAYER1_TWO_MASTED_SHIP));
                                SpawnLabelHowManyLeftToPlace(gridPane);
                            }
                        }
                    });
                } else if (i == 3) {
                    button.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            if (VariableContainer.HOW_MANY_LEFT_TO_PLACE == 0 && VariableContainer.PLAYER1_ONE_MASTED_SHIP > 0) {
                                bridge.PlayerChooseShip(1, logic, array);
                                SetColourButtonInPlayerBoard();
                                VariableContainer.PLAYER1_ONE_MASTED_SHIP = VariableContainer.PLAYER1_ONE_MASTED_SHIP - 1;
                                VariableContainer.PLAYER1_ONE_MASTED_SHIP_LABEL.setText(String.valueOf(VariableContainer.PLAYER1_ONE_MASTED_SHIP));
                                SpawnLabelHowManyLeftToPlace(gridPane);
                            }
                        }
                    });
                }

                button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                GridPane.setConstraints(button, j, 0);
                arrayListGridPane.get(i).getChildren().addAll(button);

            }
        }
    }

    public void SpawnButtonInPayerBoard(Logic logic, String[][] array, Bridge bridge, GridPane boardGrid, Player player, GridPane gridPane) {
        for (int i = 0; i < VariableContainer.array.length; i++) {
            for (int j = 0; j < VariableContainer.array.length; j++) {
                Button button = new Button();
                button.setStyle(VariableContainer.EMPTYCOLOUR);
                VariableContainer.arrayButton[i][j] = button;
                int finalJ = j;
                int finalI = i;
                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        bridge.PlayerClickButtonInBoard(logic, array, finalJ, finalI, player);
                        SetColourButtonInPlayerBoard();
                        SpawnLabelHowManyLeftToPlace(gridPane);
                    }
                });

                button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                GridPane.setConstraints(button, j + 1, i + 1);
                boardGrid.getChildren().addAll(button);
            }
        }
    }

    public void SetColourButtonInPlayerBoard() {
        for (int i = 0; i < VariableContainer.arrayButton.length; i++) {
            for (int j = 0; j < VariableContainer.arrayButton.length; j++) {
                if (VariableContainer.array[i][j].equals(VariableContainer.EMPTY)) {
                    VariableContainer.arrayButton[i][j].setStyle(VariableContainer.EMPTYCOLOUR);
                } else if (VariableContainer.array[i][j].equals(VariableContainer.UNLOCK)) {
                    VariableContainer.arrayButton[i][j].setStyle(VariableContainer.UNLOCKCOLOUR);
                } else if (VariableContainer.array[i][j].equals(VariableContainer.LOCK)) {
                    VariableContainer.arrayButton[i][j].setStyle(VariableContainer.LOCKCOLOUR);
                } else if (VariableContainer.array[i][j].equals(VariableContainer.HIT)) {
                    VariableContainer.arrayButton[i][j].setStyle(VariableContainer.HITCOLOUR);
                } else if (VariableContainer.array[i][j].equals(VariableContainer.HITSINK)) {
                    VariableContainer.arrayButton[i][j].setStyle(VariableContainer.HITSINKCOLOUR);
                } else if (VariableContainer.array[i][j].equals(VariableContainer.PLACE)) {
                    VariableContainer.arrayButton[i][j].setStyle(VariableContainer.PLACECOLOUR);
                } else if (VariableContainer.array[i][j].equals(VariableContainer.MISS)) {
                    VariableContainer.arrayButton[i][j].setStyle(VariableContainer.MISSCOLOUR);
                }
            }
        }
    }

    public void SetColourButtonInComputerBoard() {
        for (int i = 0; i < VariableContainer.arrayButtonPC.length; i++) {
            for (int j = 0; j < VariableContainer.arrayButtonPC.length; j++) {
                if (VariableContainer.arrayPC[i][j].equals(VariableContainer.EMPTY)) {
                    VariableContainer.arrayButtonPC[i][j].setStyle(VariableContainer.EMPTYCOLOUR);
                } else if (VariableContainer.arrayPC[i][j].equals(VariableContainer.HIT)) {
                    VariableContainer.arrayButtonPC[i][j].setStyle(VariableContainer.HITCOLOUR);
                } else if (VariableContainer.arrayPC[i][j].equals(VariableContainer.HITSINK)) {
                    VariableContainer.arrayButtonPC[i][j].setStyle(VariableContainer.HITSINKCOLOUR);
                } else if (VariableContainer.arrayPC[i][j].equals(VariableContainer.MISS)) {
                    VariableContainer.arrayButtonPC[i][j].setStyle(VariableContainer.MISSCOLOUR);
                }
            }
        }
    }

    public void SpawnButtonInComputerBoard(GridPane player2Board, Bridge bridge, Logic logic, Player player1, Computer computer, Player player2) {
        for (int i = 0; i < VariableContainer.arrayPC.length; i++) {
            for (int j = VariableContainer.arrayPC.length - 1; j >= 0; j--) {
                Button button = new Button();
                int finalJ = j;
                int finalI = i;
                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if (player1.getNumberBoxesLeft() == 0 && !VariableContainer.arrayPC[finalI][finalJ].equals(VariableContainer.HIT) && !VariableContainer.arrayPC[finalI][finalJ].equals(VariableContainer.MISS)) {
                            bridge.PlayerShotInBoard(logic, VariableContainer.arrayPC, finalJ, finalI, player1);
                            computer.RandomShot(logic, VariableContainer.array, player2);
                            logic.HitSink(VariableContainer.array);
                            SetColourButtonInComputerBoard();
                            SetColourButtonInPlayerBoard();
                            SetColourButtonInComputerBoard();
                            player1.setName(VariableContainer.PAYER_NAME);
                            if(player1.getNumberBoxesHitLeft() == 0)
                            {
                                EndWindow endWindow = new EndWindow(player1);
                            } else if (player2.getNumberBoxesHitLeft() == 0)
                            {
                                EndWindow endWindow = new EndWindow(player2);
                            }
                        }
                    }
                });
                button.setStyle(VariableContainer.EMPTYCOLOUR);
                VariableContainer.arrayButtonPC[i][j] = button;
                button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                GridPane.setConstraints(button, j + 1, i + 1);
                player2Board.getChildren().addAll(button);
            }
        }
    }


}
