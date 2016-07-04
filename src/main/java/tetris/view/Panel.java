package tetris.view;

import tetris.controller.TetrisController;
import tetris.model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Dominika on 2016-07-03.
 */
public class Panel extends JPanel implements KeyListener, ActionListener {

    private static final long serialVersionUID = 1L;

    TetrisController tetrisController;
    public static int spin, num = 1, yNum = 1, xNum = 1, offSet, offSet2, dropDownTo = 500;
    public static boolean shapeEnd, reached = false, onSide = true, firstShape = false;

    public int iPlus20, jPlus20;

    CyanBarBlock cyanBarBlock;
    RedCrossBlock redCrossBlock;
    YellowSquareBlock yellowSquareBlock;
    GreenStairBlock greenStairBlock;
    BlueStairsBlock blueStairsBlock;

    Timer time;

    public Panel() throws InterruptedException {
        tetrisController = new TetrisController();
        cyanBarBlock = new CyanBarBlock();
        redCrossBlock = new RedCrossBlock();
        yellowSquareBlock = new YellowSquareBlock();
        greenStairBlock = new GreenStairBlock();
        blueStairsBlock = new BlueStairsBlock();
        spin = 0;
        this.setSize(350, 300);
        this.setVisible(true);
        addKeyListener(this);
        this.setFocusable(true);
        this.requestFocus();
        time = new Timer(10, this);
        time.start();
    }

    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, 350, 560);
        for (int i = 0; i < 375; i++) {
            System.out.println();
        }
        for (int i = 1; i < 27; i++) {
            iPlus20 = i * 20;
            for (int j = 1; j < 15; j++) {
                jPlus20 = j * 20;

                if (tetrisController.controler[i][j] == 0) {
                    g.setColor(Color.white);
                }
                if (tetrisController.controler[i][j] == 1) {
                    g.setColor(Color.cyan);
                }
                if (tetrisController.controler[i][j] == 2) {
                    g.setColor(Color.red);
                }
                if (tetrisController.controler[i][j] == 3) {
                    g.setColor(Color.yellow);
                }
                if (tetrisController.controler[i][j] == 4) {
                    g.setColor(Color.green);
                }
                if (tetrisController.controler[i][j] == 5) {
                    g.setColor(Color.blue);
                }
                if (tetrisController.controler[i][j] == 100) {
                    g.setColor(Color.white);
                }
                g.fillRect(jPlus20, iPlus20, 20, 20);
            }
        }

        if (num == 1) {
            CyanBarBlock.num = 1;
            cyanBarBlock.paint(g);
            Panel.shapeEnd = false;
            tetrisController.checkRow1();
            if (cyanBarBlock.onSide == false) {
                tetrisController.checkCols7(xNum);
            }
            if (cyanBarBlock.onSide == true) {
                tetrisController.checkCols4(xNum);
            }

            if (reached == true) {

                if (cyanBarBlock.onSide == false) {
                    tetrisController.controler[yNum - 2][xNum] = TetrisController.colr;
                    tetrisController.controler[yNum - 1][xNum] = TetrisController.colr;
                    tetrisController.controler[yNum][xNum] = TetrisController.colr;
                }

                if (cyanBarBlock.onSide == true) {
                    tetrisController.controler[yNum][xNum - 2] = TetrisController.colr;
                    tetrisController.controler[yNum][xNum - 1] = TetrisController.colr;
                    tetrisController.controler[yNum][xNum] = TetrisController.colr;
                }

            }
        }
        if (num == 2) {
            RedCrossBlock.num = 2;
            redCrossBlock.paint(g);
            Panel.shapeEnd = false;
            tetrisController.checkRow1();
            if (redCrossBlock.onSide == 1) {
                tetrisController.checkCols2(xNum);
            }
            if (redCrossBlock.onSide == 2) {
                tetrisController.checkCols4(xNum);
            }
            if (redCrossBlock.onSide == 3) {
                tetrisController.checkCols6(xNum);
            }
            if (redCrossBlock.onSide == 4) {
                tetrisController.checkCols3(xNum);
            }
            //tetrisController.controler[1][9]=TetrisController.colr;
            if (reached == true) {
                if (redCrossBlock.onSide == 1) {

                    tetrisController.controler[yNum][xNum] = TetrisController.colr;
                    tetrisController.controler[yNum + 1][xNum] = TetrisController.colr;
                    tetrisController.controler[yNum + 2][xNum] = TetrisController.colr;
                    tetrisController.controler[yNum + 1][xNum + 1] = TetrisController.colr;
                }

                if (redCrossBlock.onSide == 2) {
                    tetrisController.controler[yNum + 1][xNum - 1] = TetrisController.colr;
                    tetrisController.controler[yNum + 1][xNum] = TetrisController.colr;
                    tetrisController.controler[yNum + 1][xNum - 2] = TetrisController.colr;
                    tetrisController.controler[yNum][xNum - 1] = TetrisController.colr;
                }

                if (redCrossBlock.onSide == 3) {
                    tetrisController.controler[yNum][xNum] = TetrisController.colr;
                    tetrisController.controler[yNum][xNum + 1] = TetrisController.colr;
                    tetrisController.controler[yNum][xNum - 1] = TetrisController.colr;
                    tetrisController.controler[yNum + 1][xNum] = TetrisController.colr;
                }

                if (redCrossBlock.onSide == 4) {
                    tetrisController.controler[yNum - 2][xNum] = TetrisController.colr;
                    tetrisController.controler[yNum - 1][xNum] = TetrisController.colr;
                    tetrisController.controler[yNum][xNum] = TetrisController.colr;
                    tetrisController.controler[yNum - 1][xNum - 1] = TetrisController.colr;
                }
            }
        }
        if (num == 3) {
            YellowSquareBlock.num = 3;
            yellowSquareBlock.paint(g);
            Panel.shapeEnd = false;
            tetrisController.checkRow1();
            tetrisController.checkCols8(xNum);
            //tetrisController.controler[1][9]=TetrisController.colr;
            if (reached == true) {
                if (yellowSquareBlock.onSide == true) {
                    tetrisController.controler[yNum][xNum - 1] = TetrisController.colr;
                    tetrisController.controler[yNum][xNum] = TetrisController.colr;
                    tetrisController.controler[yNum + 1][xNum - 1] = TetrisController.colr;
                    tetrisController.controler[yNum + 1][xNum] = TetrisController.colr;
                }
                if (yellowSquareBlock.onSide == false) {
                    tetrisController.controler[yNum][xNum - 1] = TetrisController.colr;
                    tetrisController.controler[yNum][xNum] = TetrisController.colr;
                    tetrisController.controler[yNum + 1][xNum - 1] = TetrisController.colr;
                    tetrisController.controler[yNum + 1][xNum] = TetrisController.colr;
                }
            }
        }
        if (num == 4) {
            GreenStairBlock.num = 4;
            greenStairBlock.paint(g);
            Panel.shapeEnd = false;
            tetrisController.checkRow1();
            if (greenStairBlock.onSide == false) {
                tetrisController.checkCols9(xNum);
            }
            if (greenStairBlock.onSide == true) {
                tetrisController.checkCols1(xNum);
            }
            //tetrisController.controler[1][9]=TetrisController.colr;
            if (reached == true) {
                if (greenStairBlock.onSide == true) {
                    tetrisController.controler[yNum + 1][xNum] = TetrisController.colr;
                    tetrisController.controler[yNum][xNum] = TetrisController.colr;
                    tetrisController.controler[yNum][xNum + 1] = TetrisController.colr;
                    tetrisController.controler[yNum + 1][xNum - 1] = TetrisController.colr;
                }
                if (greenStairBlock.onSide == false) {
                    tetrisController.controler[yNum][xNum - 1] = TetrisController.colr;
                    tetrisController.controler[yNum + 1][xNum - 1] = TetrisController.colr;
                    tetrisController.controler[yNum + 1][xNum] = TetrisController.colr;
                    tetrisController.controler[yNum + 2][xNum] = TetrisController.colr;
                }
            }
        }
        if (num == 5) {
            BlueStairsBlock.num = 5;
            blueStairsBlock.paint(g);
            Panel.shapeEnd = false;
            tetrisController.checkRow1();
            if (blueStairsBlock.onSide == false) {
                tetrisController.checkCols2(xNum);
            }
            if (blueStairsBlock.onSide == true) {
                tetrisController.checkCols10(xNum);
            }
            if (reached == true) {
                if (blueStairsBlock.onSide == true) {
                    tetrisController.controler[yNum + 1][xNum] = TetrisController.colr;
                    tetrisController.controler[yNum][xNum] = TetrisController.colr;
                    tetrisController.controler[yNum + 1][xNum + 1] = TetrisController.colr;
                    tetrisController.controler[yNum][xNum - 1] = TetrisController.colr;
                }
                if (blueStairsBlock.onSide == false) {
                    tetrisController.controler[yNum][xNum + 1] = TetrisController.colr;
                    tetrisController.controler[yNum + 1][xNum + 1] = TetrisController.colr;
                    tetrisController.controler[yNum + 1][xNum] = TetrisController.colr;
                    tetrisController.controler[yNum + 2][xNum] = TetrisController.colr;
                }
            }
        }

        repaint();

        g.dispose();

    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (cyanBarBlock.onSide == false) {
                if (cyanBarBlock.x3 > 20) {
                    cyanBarBlock.x1 = cyanBarBlock.x1 - 20;
                    cyanBarBlock.x2 = cyanBarBlock.x2 - 20;
                    cyanBarBlock.x3 = cyanBarBlock.x3 - 20;
                }
            }
            if (cyanBarBlock.onSide == true) {
                if (cyanBarBlock.x3 > 60) {
                    cyanBarBlock.x1 = cyanBarBlock.x1 - 20;
                    cyanBarBlock.x2 = cyanBarBlock.x2 - 20;
                    cyanBarBlock.x3 = cyanBarBlock.x3 - 20;
                }
            }
            if (redCrossBlock.onSide == 1) {
                if (redCrossBlock.x3 > 20) {
                    redCrossBlock.x1 = redCrossBlock.x1 - 20;
                    redCrossBlock.x2 = redCrossBlock.x2 - 20;
                    redCrossBlock.x3 = redCrossBlock.x3 - 20;
                    redCrossBlock.x4 = redCrossBlock.x4 - 20;
                }
            }
            if (redCrossBlock.onSide == 2) {
                if (redCrossBlock.x3 > 60) {
                    redCrossBlock.x1 = redCrossBlock.x1 - 20;
                    redCrossBlock.x2 = redCrossBlock.x2 - 20;
                    redCrossBlock.x3 = redCrossBlock.x3 - 20;
                    redCrossBlock.x4 = redCrossBlock.x4 - 20;
                }
            }
            if (redCrossBlock.onSide == 3) {
                if (redCrossBlock.x3 > 40) {
                    redCrossBlock.x1 = redCrossBlock.x1 - 20;
                    redCrossBlock.x2 = redCrossBlock.x2 - 20;
                    redCrossBlock.x3 = redCrossBlock.x3 - 20;
                    redCrossBlock.x4 = redCrossBlock.x4 - 20;
                }
            }
            if (redCrossBlock.onSide == 4) {
                if (redCrossBlock.x3 > 40) {
                    redCrossBlock.x1 = redCrossBlock.x1 - 20;
                    redCrossBlock.x2 = redCrossBlock.x2 - 20;
                    redCrossBlock.x3 = redCrossBlock.x3 - 20;
                    redCrossBlock.x4 = redCrossBlock.x4 - 20;
                }
            }
            if (yellowSquareBlock.x3 > 40) {
                yellowSquareBlock.x1 = yellowSquareBlock.x1 - 20;
                yellowSquareBlock.x2 = yellowSquareBlock.x2 - 20;
                yellowSquareBlock.x3 = yellowSquareBlock.x3 - 20;
                yellowSquareBlock.x4 = yellowSquareBlock.x4 - 20;
            }

            if (greenStairBlock.onSide == true) {
                if (greenStairBlock.x3 > 40) {
                    greenStairBlock.x1 = greenStairBlock.x1 - 20;
                    greenStairBlock.x2 = greenStairBlock.x2 - 20;
                    greenStairBlock.x3 = greenStairBlock.x3 - 20;
                    greenStairBlock.x4 = greenStairBlock.x4 - 20;
                }
            }
            if (greenStairBlock.onSide == false) {
                if (greenStairBlock.x3 > 40) {
                    greenStairBlock.x1 = greenStairBlock.x1 - 20;
                    greenStairBlock.x2 = greenStairBlock.x2 - 20;
                    greenStairBlock.x3 = greenStairBlock.x3 - 20;
                    greenStairBlock.x4 = greenStairBlock.x4 - 20;
                }
            }
            if (blueStairsBlock.onSide == true) {
                if (blueStairsBlock.x3 > 40) {
                    blueStairsBlock.x1 = blueStairsBlock.x1 - 20;
                    blueStairsBlock.x2 = blueStairsBlock.x2 - 20;
                    blueStairsBlock.x3 = blueStairsBlock.x3 - 20;
                    blueStairsBlock.x4 = blueStairsBlock.x4 - 20;
                }
            }
            if (blueStairsBlock.onSide == false) {
                if (blueStairsBlock.x3 > 20) {
                    blueStairsBlock.x1 = blueStairsBlock.x1 - 20;
                    blueStairsBlock.x2 = blueStairsBlock.x2 - 20;
                    blueStairsBlock.x3 = blueStairsBlock.x3 - 20;
                    blueStairsBlock.x4 = blueStairsBlock.x4 - 20;
                }
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (cyanBarBlock.x3 < 261) {
                cyanBarBlock.x1 = cyanBarBlock.x1 + 20;
                cyanBarBlock.x2 = cyanBarBlock.x2 + 20;
                cyanBarBlock.x3 = cyanBarBlock.x3 + 20;
            }
            if (redCrossBlock.onSide == 1) {
                if (redCrossBlock.x3 < 260) {
                    redCrossBlock.x1 = redCrossBlock.x1 + 20;
                    redCrossBlock.x2 = redCrossBlock.x2 + 20;
                    redCrossBlock.x3 = redCrossBlock.x3 + 20;
                    redCrossBlock.x4 = redCrossBlock.x4 + 20;
                }
            }
            if (redCrossBlock.onSide == 2) {
                if (redCrossBlock.x3 < 280) {
                    redCrossBlock.x1 = redCrossBlock.x1 + 20;
                    redCrossBlock.x2 = redCrossBlock.x2 + 20;
                    redCrossBlock.x3 = redCrossBlock.x3 + 20;
                    redCrossBlock.x4 = redCrossBlock.x4 + 20;
                }
            }
            if (redCrossBlock.onSide == 3) {
                if (redCrossBlock.x3 < 260) {
                    redCrossBlock.x1 = redCrossBlock.x1 + 20;
                    redCrossBlock.x2 = redCrossBlock.x2 + 20;
                    redCrossBlock.x3 = redCrossBlock.x3 + 20;
                    redCrossBlock.x4 = redCrossBlock.x4 + 20;
                }
            }
            if (redCrossBlock.onSide == 4) {
                if (redCrossBlock.x3 < 280) {
                    redCrossBlock.x1 = redCrossBlock.x1 + 20;
                    redCrossBlock.x2 = redCrossBlock.x2 + 20;
                    redCrossBlock.x3 = redCrossBlock.x3 + 20;
                    redCrossBlock.x4 = redCrossBlock.x4 + 20;
                }
            }
            if (yellowSquareBlock.x3 < 261) {
                yellowSquareBlock.x1 = yellowSquareBlock.x1 + 20;
                yellowSquareBlock.x2 = yellowSquareBlock.x2 + 20;
                yellowSquareBlock.x3 = yellowSquareBlock.x3 + 20;
                yellowSquareBlock.x4 = yellowSquareBlock.x4 + 20;
            }
            if (greenStairBlock.onSide == true) {
                if (greenStairBlock.x3 < 260) {
                    greenStairBlock.x1 = greenStairBlock.x1 + 20;
                    greenStairBlock.x2 = greenStairBlock.x2 + 20;
                    greenStairBlock.x3 = greenStairBlock.x3 + 20;
                    greenStairBlock.x4 = greenStairBlock.x4 + 20;
                }
            }
            if (greenStairBlock.onSide == false) {
                if (greenStairBlock.x3 < 280) {
                    greenStairBlock.x1 = greenStairBlock.x1 + 20;
                    greenStairBlock.x2 = greenStairBlock.x2 + 20;
                    greenStairBlock.x3 = greenStairBlock.x3 + 20;
                    greenStairBlock.x4 = greenStairBlock.x4 + 20;
                }
            }

            if (blueStairsBlock.onSide == true) {
                if (blueStairsBlock.x3 < 260) {
                    blueStairsBlock.x1 = blueStairsBlock.x1 + 20;
                    blueStairsBlock.x2 = blueStairsBlock.x2 + 20;
                    blueStairsBlock.x3 = blueStairsBlock.x3 + 20;
                    blueStairsBlock.x4 = blueStairsBlock.x4 + 20;
                }
            }
            if (blueStairsBlock.onSide == false) {
                if (blueStairsBlock.x3 < 260) {
                    blueStairsBlock.x1 = blueStairsBlock.x1 + 20;
                    blueStairsBlock.x2 = blueStairsBlock.x2 + 20;
                    blueStairsBlock.x3 = blueStairsBlock.x3 + 20;
                    blueStairsBlock.x4 = blueStairsBlock.x4 + 20;
                }
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            ++spin;
            if (spin == 1 || spin == 3) {
                if (Panel.shapeEnd == false) {

                    cyanBarBlock.onSide = false;
                    yellowSquareBlock.onSide = false;
                    greenStairBlock.onSide = false;
                    blueStairsBlock.onSide = false;
                    cyanBarBlock.offSet = cyanBarBlock.y2;
                    cyanBarBlock.offSet2 = cyanBarBlock.x2;
                    greenStairBlock.offSet = greenStairBlock.y3;
                    greenStairBlock.offSet2 = greenStairBlock.x3;
                    blueStairsBlock.offSet = blueStairsBlock.y3;
                    blueStairsBlock.offSet2 = blueStairsBlock.x3;
                    if (greenStairBlock.onSide == false) {
                        greenStairBlock.shape();
                    }
                    if (cyanBarBlock.onSide == false) {
                        cyanBarBlock.bar();
                    }
                    if (cyanBarBlock.onSide == false) {
                        yellowSquareBlock.square();
                    }
                    if (blueStairsBlock.onSide == false) {
                        blueStairsBlock.shape();
                    }
                }
                System.out.println(spin);
            }
            if (spin == 2 || spin == 4) {
                if (Panel.shapeEnd == false) {
                    cyanBarBlock.onSide = true;
                    yellowSquareBlock.onSide = true;
                    greenStairBlock.onSide = true;
                    blueStairsBlock.onSide = true;
                    cyanBarBlock.offSet = cyanBarBlock.y2;
                    cyanBarBlock.offSet2 = cyanBarBlock.x2;
                    greenStairBlock.offSet = greenStairBlock.y3;
                    greenStairBlock.offSet2 = greenStairBlock.x3;
                    blueStairsBlock.offSet = blueStairsBlock.y3;
                    blueStairsBlock.offSet2 = blueStairsBlock.x3;
                    if (cyanBarBlock.onSide == true) {
                        cyanBarBlock.barOnItsSide();
                    }
                    if (cyanBarBlock.onSide == true) {
                        yellowSquareBlock.square();
                    }
                    if (greenStairBlock.onSide == true) {
                        greenStairBlock.shapeOnItsSide();
                    }
                    if (blueStairsBlock.onSide == true) {
                        blueStairsBlock.shapeOnItsSide();
                    }
                }
            }
            System.out.println(" spin : " + spin);
            //redCrossBlock.onSide=1;
            if (firstShape == true) {
                spin = 2;
            }
            if (spin == 1 && spin != 3) {
                System.out.println("   inside it now!");
                if (Panel.shapeEnd == false) {
                    redCrossBlock.onSide = 1;
                    redCrossBlock.offSet = redCrossBlock.y2;
                    redCrossBlock.offSet2 = redCrossBlock.x2;
                    //redCrossBlock.shapeTeeUp();
                    redCrossBlock.shapeTeeRight();
                }
            }
            if (spin == 2 && spin != 4) {
                firstShape = false;  //bug fix
                if (Panel.shapeEnd == false) {
                    redCrossBlock.onSide = 2;
                    redCrossBlock.offSet = redCrossBlock.y2;
                    redCrossBlock.offSet2 = redCrossBlock.x2;
                    //redCrossBlock.shapeTeeRight();
                    redCrossBlock.shapeTeeUp();
                }
            }
            if (spin == 3 && spin != 1) {

                if (Panel.shapeEnd == false) {
                    redCrossBlock.onSide = 3;
                    redCrossBlock.offSet = redCrossBlock.y2;
                    redCrossBlock.offSet2 = redCrossBlock.x2;
                    redCrossBlock.shapeTeeBottom();
                }
            }
            if (spin == 4 && spin != 2) {
                if (Panel.shapeEnd == false) {
                    redCrossBlock.onSide = 4;
                    redCrossBlock.offSet = redCrossBlock.y2;
                    redCrossBlock.offSet2 = redCrossBlock.x2;
                    redCrossBlock.shapeTeeLeft();
                    spin = 0;
                }
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (cyanBarBlock.y3 < 261) {
                cyanBarBlock.y1 = cyanBarBlock.y1 + 1000;
                cyanBarBlock.y2 = cyanBarBlock.y2 + 1000;
                cyanBarBlock.y3 = cyanBarBlock.y3 + 1000;
            }
            if (redCrossBlock.onSide == 1) {
                if (redCrossBlock.y3 < 260) {
                    redCrossBlock.y1 = redCrossBlock.y1 + 1000;
                    redCrossBlock.y2 = redCrossBlock.y2 + 1000;
                    redCrossBlock.y3 = redCrossBlock.y3 + 1000;
                    redCrossBlock.y4 = redCrossBlock.y4 + 1000;
                }
            }
            if (redCrossBlock.onSide == 2) {
                if (redCrossBlock.y3 < 280) {
                    redCrossBlock.y1 = redCrossBlock.y1 + 1000;
                    redCrossBlock.y2 = redCrossBlock.y2 + 1000;
                    redCrossBlock.y3 = redCrossBlock.y3 + 1000;
                    redCrossBlock.y4 = redCrossBlock.y4 + 1000;
                }
            }
            if (redCrossBlock.onSide == 3) {
                if (redCrossBlock.y3 < 260) {
                    redCrossBlock.y1 = redCrossBlock.y1 + 1000;
                    redCrossBlock.y2 = redCrossBlock.y2 + 1000;
                    redCrossBlock.y3 = redCrossBlock.y3 + 1000;
                    redCrossBlock.y4 = redCrossBlock.y4 + 1000;
                }
            }
            if (redCrossBlock.onSide == 4) {
                if (redCrossBlock.y3 < 280) {
                    redCrossBlock.y1 = redCrossBlock.y1 + 1000;
                    redCrossBlock.y2 = redCrossBlock.y2 + 1000;
                    redCrossBlock.y3 = redCrossBlock.y3 + 1000;
                    redCrossBlock.y4 = redCrossBlock.y4 + 1000;
                }
            }
            if (yellowSquareBlock.y3 < 261) {
                yellowSquareBlock.y1 = yellowSquareBlock.y1 + 1000;
                yellowSquareBlock.y2 = yellowSquareBlock.y2 + 1000;
                yellowSquareBlock.y3 = yellowSquareBlock.y3 + 1000;
                yellowSquareBlock.y4 = yellowSquareBlock.y4 + 1000;
            }
            if (greenStairBlock.onSide == true) {
                if (greenStairBlock.y3 < 260) {
                    greenStairBlock.y1 = greenStairBlock.y1 + 1000;
                    greenStairBlock.y2 = greenStairBlock.y2 + 1000;
                    greenStairBlock.y3 = greenStairBlock.y3 + 1000;
                    greenStairBlock.y4 = greenStairBlock.y4 + 1000;
                }
            }
            if (greenStairBlock.onSide == false) {
                if (greenStairBlock.y3 < 280) {
                    greenStairBlock.y1 = greenStairBlock.y1 + 1000;
                    greenStairBlock.y2 = greenStairBlock.y2 + 1000;
                    greenStairBlock.y3 = greenStairBlock.y3 + 1000;
                    greenStairBlock.y4 = greenStairBlock.y4 + 1000;
                }
            }

            if (blueStairsBlock.onSide == true) {
                if (blueStairsBlock.y3 < 260) {
                    blueStairsBlock.y1 = blueStairsBlock.y1 + 1000;
                    blueStairsBlock.y2 = blueStairsBlock.y2 + 1000;
                    blueStairsBlock.y3 = blueStairsBlock.y3 + 1000;
                    blueStairsBlock.y4 = blueStairsBlock.y4 + 1000;
                }
            }
            if (blueStairsBlock.onSide == false) {
                if (blueStairsBlock.y3 < 260) {
                    blueStairsBlock.y1 = blueStairsBlock.y1 + 1000;
                    blueStairsBlock.y2 = blueStairsBlock.y2 + 1000;
                    blueStairsBlock.y3 = blueStairsBlock.y3 + 1000;
                    blueStairsBlock.y4 = blueStairsBlock.y4 + 1000;
                }
            }
        }

    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public void actionPerformed(ActionEvent e) {
    }
}

