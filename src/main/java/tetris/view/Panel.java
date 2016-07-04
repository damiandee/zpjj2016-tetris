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

    //OrangeLeftLBlock orangeLeftLBlock;
    CyanBarBlock cyanBarBlock;
    RedCrossBlock redCrossBlock;
    YellowSquareBlock yellowSquareBlock;
    GreenSBlock greenSBlock;
    BlueSBlock blueSBlock;

    Timer time;

    public Panel() throws InterruptedException {
        tetrisController = new TetrisController();
        //orangeLeftLBlock = new OrangeLeftLBlock();
        cyanBarBlock = new CyanBarBlock();
        redCrossBlock = new RedCrossBlock();
        yellowSquareBlock = new YellowSquareBlock();
        greenSBlock = new GreenSBlock();
        blueSBlock = new BlueSBlock();
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
        for (int i = 0; i < 3750; i++) {
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
            GreenSBlock.num = 4;
            greenSBlock.paint(g);
            Panel.shapeEnd = false;
            tetrisController.checkRow1();
            if (greenSBlock.onSide == false) {
                tetrisController.checkCols9(xNum);
            }
            if (greenSBlock.onSide == true) {
                tetrisController.checkCols1(xNum);
            }
            //tetrisController.controler[1][9]=TetrisController.colr;
            if (reached == true) {
                if (greenSBlock.onSide == true) {
                    tetrisController.controler[yNum + 1][xNum] = TetrisController.colr;
                    tetrisController.controler[yNum][xNum] = TetrisController.colr;
                    tetrisController.controler[yNum][xNum + 1] = TetrisController.colr;
                    tetrisController.controler[yNum + 1][xNum - 1] = TetrisController.colr;
                }
                if (greenSBlock.onSide == false) {
                    tetrisController.controler[yNum][xNum - 1] = TetrisController.colr;
                    tetrisController.controler[yNum + 1][xNum - 1] = TetrisController.colr;
                    tetrisController.controler[yNum + 1][xNum] = TetrisController.colr;
                    tetrisController.controler[yNum + 2][xNum] = TetrisController.colr;
                }
            }
        }
        if (num == 5) {
            BlueSBlock.num = 5;
            blueSBlock.paint(g);
            Panel.shapeEnd = false;
            tetrisController.checkRow1();
            if (blueSBlock.onSide == false) {
                tetrisController.checkCols2(xNum);
            }
            if (blueSBlock.onSide == true) {
                tetrisController.checkCols10(xNum);
            }
            if (reached == true) {
                if (blueSBlock.onSide == true) {
                    tetrisController.controler[yNum + 1][xNum] = TetrisController.colr;
                    tetrisController.controler[yNum][xNum] = TetrisController.colr;
                    tetrisController.controler[yNum + 1][xNum + 1] = TetrisController.colr;
                    tetrisController.controler[yNum][xNum - 1] = TetrisController.colr;
                }
                if (blueSBlock.onSide == false) {
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

            if (greenSBlock.onSide == true) {
                if (greenSBlock.x3 > 40) {
                    greenSBlock.x1 = greenSBlock.x1 - 20;
                    greenSBlock.x2 = greenSBlock.x2 - 20;
                    greenSBlock.x3 = greenSBlock.x3 - 20;
                    greenSBlock.x4 = greenSBlock.x4 - 20;
                }
            }
            if (greenSBlock.onSide == false) {
                if (greenSBlock.x3 > 40) {
                    greenSBlock.x1 = greenSBlock.x1 - 20;
                    greenSBlock.x2 = greenSBlock.x2 - 20;
                    greenSBlock.x3 = greenSBlock.x3 - 20;
                    greenSBlock.x4 = greenSBlock.x4 - 20;
                }
            }
            if (blueSBlock.onSide == true) {
                if (blueSBlock.x3 > 40) {
                    blueSBlock.x1 = blueSBlock.x1 - 20;
                    blueSBlock.x2 = blueSBlock.x2 - 20;
                    blueSBlock.x3 = blueSBlock.x3 - 20;
                    blueSBlock.x4 = blueSBlock.x4 - 20;
                }
            }
            if (blueSBlock.onSide == false) {
                if (blueSBlock.x3 > 20) {
                    blueSBlock.x1 = blueSBlock.x1 - 20;
                    blueSBlock.x2 = blueSBlock.x2 - 20;
                    blueSBlock.x3 = blueSBlock.x3 - 20;
                    blueSBlock.x4 = blueSBlock.x4 - 20;
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
            if (greenSBlock.onSide == true) {
                if (greenSBlock.x3 < 260) {
                    greenSBlock.x1 = greenSBlock.x1 + 20;
                    greenSBlock.x2 = greenSBlock.x2 + 20;
                    greenSBlock.x3 = greenSBlock.x3 + 20;
                    greenSBlock.x4 = greenSBlock.x4 + 20;
                }
            }
            if (greenSBlock.onSide == false) {
                if (greenSBlock.x3 < 280) {
                    greenSBlock.x1 = greenSBlock.x1 + 20;
                    greenSBlock.x2 = greenSBlock.x2 + 20;
                    greenSBlock.x3 = greenSBlock.x3 + 20;
                    greenSBlock.x4 = greenSBlock.x4 + 20;
                }
            }

            if (blueSBlock.onSide == true) {
                if (blueSBlock.x3 < 260) {
                    blueSBlock.x1 = blueSBlock.x1 + 20;
                    blueSBlock.x2 = blueSBlock.x2 + 20;
                    blueSBlock.x3 = blueSBlock.x3 + 20;
                    blueSBlock.x4 = blueSBlock.x4 + 20;
                }
            }
            if (blueSBlock.onSide == false) {
                if (blueSBlock.x3 < 260) {
                    blueSBlock.x1 = blueSBlock.x1 + 20;
                    blueSBlock.x2 = blueSBlock.x2 + 20;
                    blueSBlock.x3 = blueSBlock.x3 + 20;
                    blueSBlock.x4 = blueSBlock.x4 + 20;
                }
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            ++spin;
            if (spin == 1 || spin == 3) {
                if (Panel.shapeEnd == false) {

                    cyanBarBlock.onSide = false;
                    yellowSquareBlock.onSide = false;
                    greenSBlock.onSide = false;
                    blueSBlock.onSide = false;
                    cyanBarBlock.offSet = cyanBarBlock.y2;
                    cyanBarBlock.offSet2 = cyanBarBlock.x2;
                    greenSBlock.offSet = greenSBlock.y3;
                    greenSBlock.offSet2 = greenSBlock.x3;
                    blueSBlock.offSet = blueSBlock.y3;
                    blueSBlock.offSet2 = blueSBlock.x3;
                    if (greenSBlock.onSide == false) {
                        greenSBlock.shape();
                    }
                    if (cyanBarBlock.onSide == false) {
                        cyanBarBlock.bar();
                    }
                    if (cyanBarBlock.onSide == false) {
                        yellowSquareBlock.square();
                    }
                    if (blueSBlock.onSide == false) {
                        blueSBlock.shape();
                    }
                }
                System.out.println(spin);
            }
            if (spin == 2 || spin == 4) {
                if (Panel.shapeEnd == false) {
                    cyanBarBlock.onSide = true;
                    yellowSquareBlock.onSide = true;
                    greenSBlock.onSide = true;
                    blueSBlock.onSide = true;
                    cyanBarBlock.offSet = cyanBarBlock.y2;
                    cyanBarBlock.offSet2 = cyanBarBlock.x2;
                    greenSBlock.offSet = greenSBlock.y3;
                    greenSBlock.offSet2 = greenSBlock.x3;
                    blueSBlock.offSet = blueSBlock.y3;
                    blueSBlock.offSet2 = blueSBlock.x3;
                    if (cyanBarBlock.onSide == true) {
                        cyanBarBlock.barOnItsSide();
                    }
                    if (cyanBarBlock.onSide == true) {
                        yellowSquareBlock.square();
                    }
                    if (greenSBlock.onSide == true) {
                        greenSBlock.shapeOnItsSide();
                    }
                    if (blueSBlock.onSide == true) {
                        blueSBlock.shapeOnItsSide();
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
            if (greenSBlock.onSide == true) {
                if (greenSBlock.y3 < 260) {
                    greenSBlock.y1 = greenSBlock.y1 + 1000;
                    greenSBlock.y2 = greenSBlock.y2 + 1000;
                    greenSBlock.y3 = greenSBlock.y3 + 1000;
                    greenSBlock.y4 = greenSBlock.y4 + 1000;
                }
            }
            if (greenSBlock.onSide == false) {
                if (greenSBlock.y3 < 280) {
                    greenSBlock.y1 = greenSBlock.y1 + 1000;
                    greenSBlock.y2 = greenSBlock.y2 + 1000;
                    greenSBlock.y3 = greenSBlock.y3 + 1000;
                    greenSBlock.y4 = greenSBlock.y4 + 1000;
                }
            }

            if (blueSBlock.onSide == true) {
                if (blueSBlock.y3 < 260) {
                    blueSBlock.y1 = blueSBlock.y1 + 1000;
                    blueSBlock.y2 = blueSBlock.y2 + 1000;
                    blueSBlock.y3 = blueSBlock.y3 + 1000;
                    blueSBlock.y4 = blueSBlock.y4 + 1000;
                }
            }
            if (blueSBlock.onSide == false) {
                if (blueSBlock.y3 < 260) {
                    blueSBlock.y1 = blueSBlock.y1 + 1000;
                    blueSBlock.y2 = blueSBlock.y2 + 1000;
                    blueSBlock.y3 = blueSBlock.y3 + 1000;
                    blueSBlock.y4 = blueSBlock.y4 + 1000;
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

