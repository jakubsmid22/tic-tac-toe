import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String winner = "";

        boolean isRunning = true;

        boolean xIsOnMove = true;

        String move = "";

        char[][] gameField = {
                {'_', '_', '_'},
                {'_', '_', '_'},
                {'_', '_', '_'}
        };

        while (isRunning) {

            printGameField(gameField);

            if (!winner.isEmpty()) {
                if (winner.equals("draw")) {
                    System.out.println("Remíza");
                }
                else {
                    System.out.println("Hráč " + winner + " zvítězil");
                }
                return;
            }

            printInfoMessage(xIsOnMove);

            move = scanner.nextLine();

            switch (move.toLowerCase()) {

                case "a1":
                    try {
                        fillBox(gameField, 0, 0, xIsOnMove);
                        xIsOnMove = !xIsOnMove;
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;

                case "a2":
                    try {
                        fillBox(gameField, 0, 1, xIsOnMove);
                        xIsOnMove = !xIsOnMove;
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;

                case "a3":
                    try {
                        fillBox(gameField, 0, 2, xIsOnMove);
                        xIsOnMove = !xIsOnMove;
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;

                case "b1":
                    try {
                        fillBox(gameField, 1, 0, xIsOnMove);
                        xIsOnMove = !xIsOnMove;
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;

                case "b2":
                    try {
                        fillBox(gameField, 1, 1, xIsOnMove);
                        xIsOnMove = !xIsOnMove;
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;

                case "b3":
                    try {
                        fillBox(gameField, 1, 2, xIsOnMove);
                        xIsOnMove = !xIsOnMove;
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;

                case "c1":
                    try {
                        fillBox(gameField, 2, 0, xIsOnMove);
                        xIsOnMove = !xIsOnMove;
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;

                case "c2":
                    try {
                        fillBox(gameField, 2, 1, xIsOnMove);
                        xIsOnMove = !xIsOnMove;
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;

                case "c3":
                    try {
                        fillBox(gameField, 2, 2, xIsOnMove);
                        xIsOnMove = !xIsOnMove;
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;

                default:
                    System.out.println("Neplatná hodnota!");
                    break;


            }

            winner = checkWinner(gameField);

        }

    }

    public static void printGameField(char[][] gameField) {

        System.out.println();

        System.out.println("  1 | 2 | 3");

        for (int i = 0; i < gameField.length; i++) {

            if (i == 0) {
                System.out.print("A ");
            } else if (i == 1) {
                System.out.print("B ");
            } else {
                System.out.print("C ");
            }

            for (int j = 0; j < gameField[i].length; j++) {

                System.out.print(gameField[i][j]);

                if (j != 2) System.out.print(" | ");

            }

            System.out.println();

        }

        System.out.println();

    }

    public static void printInfoMessage(boolean xIsOnMove) {

        if (xIsOnMove) {
            System.out.print("Hráč X je na tahu. ");
        } else {
            System.out.print("Hráč O je na tahu. ");
        }

        System.out.print("Zadej pole (např. A1): ");

    }

    public static void fillBox(char[][] gameField, int rowIndex, int boxIndex, boolean xIsOnMove) throws Exception {

        if (gameField[rowIndex][boxIndex] == '_') {
            gameField[rowIndex][boxIndex] = xIsOnMove ? 'X' : 'O';
        } else {
            throw new Exception("Toto pole je již zabrané!");
        }

    }

    public static String checkWinner(char[][] gameField) {

        boolean isGameFieldFull = true;

        for (char[] row : gameField) {

            for(char box : row) {

                if (box == '_') {
                    isGameFieldFull = false;
                }

            }

        }

        if (isGameFieldFull) return "draw";

        int[][][] winningCombinations = {
                {
                        {0, 0},
                        {0, 1},
                        {0, 2}
                },
                {
                        {1, 0},
                        {1, 1},
                        {1, 2}
                },
                {
                        {2, 0},
                        {2, 1},
                        {2, 2}
                },
                {
                        {0, 0},
                        {1, 0},
                        {2, 0}
                },
                {
                        {0, 1},
                        {1, 1},
                        {2, 1}
                },
                {
                        {0, 2},
                        {1, 2},
                        {2, 2}
                },
                {
                        {0, 0},
                        {1, 1},
                        {2, 2}
                },
                {
                        {0, 2},
                        {1, 1},
                        {2, 0}
                }
        };


        for (int[][] combination : winningCombinations) {

            char symbol = gameField[combination[0][0]][combination[0][1]];

            if (symbol == '_') continue;

            boolean isWinnig = true;

            for (int[] box : combination) {

                if (gameField[box[0]][box[1]] != symbol) {
                    isWinnig = false;
                    break;
                }

            }

            if (isWinnig) {
                return String.valueOf(symbol);
            }
        }

        return "";


    }

}