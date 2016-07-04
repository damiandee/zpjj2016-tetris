package tetris.controller;

import tetris.view.Panel;

/**
 * Created by Damian Deska on 2016-07-04.
 */

public class TetrisController {

    public int[][] controler;
    public static int colr = 0, row = 1, col = 1;
    int num1, num2;
    private boolean rowCompleted = false;
    public boolean test;

    public TetrisController() {
        num1 = 0;
        num2 = 0;
        test = false;
        controler = new int[27][15];
        int num = 0;
        for (int row = 1; row < 27; row++) {
            for (int col = 1; col < 15; col++) {

                num++;
                if (num > 5) {
                    num = num - 6;
                }
                controler[row][col] = 0;
            }

        }
        for (int numb = 1; numb < 15; numb++) {
            //cont[5][numb]=2;
        }

    }

    public void checkCols1(int x3) {
        int x = x3;
        test = false;
        Panel.dropDownTo = 500;

        for (int j = 1; j < 27; j++) {
            if (controler[j][x] > 0 || controler[j][x - 1] > 0 || controler[j - 1][x + 1] > 0) {

                if (test == false) {
                    num1 = j;
                    test = true;

                    Panel.dropDownTo = ((num1 - 2) * 20);
                }
            }
        }
    }

    public void checkCols2(int x3) {
        int x = x3;
        test = false;
        Panel.dropDownTo = 500;

        for (int j = 1; j < 27; j++) {
            if (controler[j][x] > 0 || controler[j - 1][x + 1] > 0) {

                if (test == false) {
                    num1 = j;
                    test = true;

                    Panel.dropDownTo = ((num1 - 2) * 20);

                }
            }
        }
    }

    public void checkCols3(int x3) {
        int x = x3;
        test = false;
        Panel.dropDownTo = 500;

        for (int j = 1; j < 27; j++) {
            if (controler[j][x] > 0 || controler[j - 1][x - 1] > 0) {

                if (test == false) {
                    num1 = j;
                    test = true;

                    Panel.dropDownTo = ((num1 - 2) * 20);
                }
            }
        }
    }

    public void checkCols4(int x3) {
        int x = x3 - 1;
        test = false;
        Panel.dropDownTo = 500;
        for (int j = 1; j < 27; j++) {
            if (controler[j][x] > 0 || controler[j][x + 1] > 0 || controler[j][x - 1] > 0) {

                if (test == false) {
                    num1 = j;
                    test = true;
                    Panel.dropDownTo = ((num1 - 2) * 20);

                }
            }
        }

    }

    public void checkCols5(int x3) {
        int x = x3;
        test = false;
        Panel.dropDownTo = 500;

        for (int j = 1; j < 27; j++) {
            if (controler[j][x] > 0 || controler[j][x + 1] > 0 || controler[j - 1][x - 1] > 0) {

                if (test == false) {
                    num1 = j;
                    test = true;
                    if (controler[j - 1][x - 1] > 0) {
                        Panel.dropDownTo = ((num1 - 2) * 20);
                    } else {
                        Panel.dropDownTo = ((num1 - 2) * 20);
                    }
                }
            }
        }
    }

    public void checkCols6(int x3) {
        int x = x3;
        test = false;
        Panel.dropDownTo = 500;

        for (int j = 1; j < 27; j++) {
            if (controler[j][x] > 0 || controler[j - 1][x - 1] > 0 || controler[j - 1][x + 1] > 0) {

                if (test == false) {
                    num1 = j;
                    test = true;
                    if (controler[j - 1][x - 1] > 0) {
                        Panel.dropDownTo = ((num1 - 2) * 20);
                    } else {
                        Panel.dropDownTo = ((num1 - 2) * 20);
                    }
                }
            }
        }
    }

    public void checkCols7(int x3) {
        int x = x3;
        test = false;
        Panel.dropDownTo = 500;

        for (int j = 1; j < 27; j++) {
            if (controler[j][x] > 0) {

                if (test == false) {
                    num1 = j;
                    test = true;

                    Panel.dropDownTo = ((num1 - 2) * 20);
                }
            }
        }
    }

    public void checkCols8(int x3) {
        int x = x3;
        test = false;
        Panel.dropDownTo = 500;

        for (int j = 1; j < 27; j++) {
            if (controler[j][x] > 0 || controler[j][x - 1] > 0) {

                if (test == false) {
                    num1 = j;
                    test = true;

                    Panel.dropDownTo = ((num1 - 2) * 20);
                }
            }
        }
    }

    public void checkCols9(int x3) {
        int x = x3;
        test = false;
        Panel.dropDownTo = 500;

        for (int j = 1; j < 27; j++) {
            if (controler[j][x] > 0 || controler[j - 1][x - 1] > 0) {

                if (test == false) {
                    num1 = j;
                    test = true;

                    Panel.dropDownTo = ((num1 - 2) * 20);
                }
            }
        }
    }

    public void checkCols10(int x3) {
        int x = x3;
        test = false;
        Panel.dropDownTo = 500;

        for (int j = 1; j < 27; j++) {
            if (controler[j][x] > 0 || controler[j][x + 1] > 0 || controler[j - 1][x - 1] > 0) {

                if (test == false) {
                    num1 = j;
                    test = true;

                    Panel.dropDownTo = ((num1 - 2) * 20);
                }
            }
        }
    }

    int completedRow = 1;

    public void checkRow1() {
        for (int i = 1; i < 27; i++) {
            completedRow = 0;
            for (int j = 1; j < 15; j++) {

                if (controler[i][j] != 0) {
                    completedRow++;
                    if (completedRow == 14) {
                        makeRow100(i);
                    }
                }
            }
        }

    }
    int zeroRow = 1;

    public void checkCompletedRows() {
        if (rowCompleted == true) {
            for (int i = 26; i > 0; i--) {
                if (controler[i][0] == 100) {
                    for (int j = 0; j < 15; j++) {

                        controler[i][j] = controler[i - 1][j];
                        controler[i - 1][0] = 100;
                    }
                }
            }
        }
    }

    public void makeRow100(int row) {
        int r = row;

        for (int num = 0; num < 15; num++) {
            controler[r][num] = 100;
            rowCompleted = true;
        }
        moveDownTo100(r);
    }

    public void moveDownTo100(int row) {
        int r = row;
        checkCompletedRows();
    }
}
