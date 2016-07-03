package tetris;

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

    //Controler con;
    public static int spin, num = 1, yNum = 1, xNum = 1, offSet, offSet2, dropDownTo = 500;
    public static boolean shapeEnd, reached = false, onSide = true, firstShape = false;

    public int iPlus20, jPlus20;

    Block1 block1;
    Block2 block2;
    Block3 block3;
    Block4 block4;
    Block5 block5;

    Timer time;

    public Panel() throws InterruptedException {

        //con = new Controler();
        block1 = new Block1();
        block2 = new Block2();
        block3 = new Block3();
        block4 = new Block4();
        block5 = new Block5();
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
        //TODO
    }

    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (block1.onSide == false) {
                if (block1.x3 > 20) {
                    block1.x1 = block1.x1 - 20;
                    block1.x2 = block1.x2 - 20;
                    block1.x3 = block1.x3 - 20;
                }
            }
            if (block1.onSide == true) {
                if (block1.x3 > 60) {
                    block1.x1 = block1.x1 - 20;
                    block1.x2 = block1.x2 - 20;
                    block1.x3 = block1.x3 - 20;
                }
            }
            if (block2.onSide == 1) {
                if (block2.x3 > 20) {
                    block2.x1 = block2.x1 - 20;
                    block2.x2 = block2.x2 - 20;
                    block2.x3 = block2.x3 - 20;
                    block2.x4 = block2.x4 - 20;
                }
            }
            if (block2.onSide == 2) {
                if (block2.x3 > 60) {
                    block2.x1 = block2.x1 - 20;
                    block2.x2 = block2.x2 - 20;
                    block2.x3 = block2.x3 - 20;
                    block2.x4 = block2.x4 - 20;
                }
            }
            if (block2.onSide == 3) {
                if (block2.x3 > 40) {
                    block2.x1 = block2.x1 - 20;
                    block2.x2 = block2.x2 - 20;
                    block2.x3 = block2.x3 - 20;
                    block2.x4 = block2.x4 - 20;
                }
            }
            if (block2.onSide == 4) {
                if (block2.x3 > 40) {
                    block2.x1 = block2.x1 - 20;
                    block2.x2 = block2.x2 - 20;
                    block2.x3 = block2.x3 - 20;
                    block2.x4 = block2.x4 - 20;
                }
            }
            if (block3.x3 > 40) {
                block3.x1 = block3.x1 - 20;
                block3.x2 = block3.x2 - 20;
                block3.x3 = block3.x3 - 20;
                block3.x4 = block3.x4 - 20;
            }

            if (block4.onSide == true) {
                if (block4.x3 > 40) {
                    block4.x1 = block4.x1 - 20;
                    block4.x2 = block4.x2 - 20;
                    block4.x3 = block4.x3 - 20;
                    block4.x4 = block4.x4 - 20;
                }
            }
            if (block4.onSide == false) {
                if (block4.x3 > 40) {
                    block4.x1 = block4.x1 - 20;
                    block4.x2 = block4.x2 - 20;
                    block4.x3 = block4.x3 - 20;
                    block4.x4 = block4.x4 - 20;
                }
            }
            if (block5.onSide == true) {
                if (block5.x3 > 40) {
                    block5.x1 = block5.x1 - 20;
                    block5.x2 = block5.x2 - 20;
                    block5.x3 = block5.x3 - 20;
                    block5.x4 = block5.x4 - 20;
                }
            }
            if (block5.onSide == false) {
                if (block5.x3 > 20) {
                    block5.x1 = block5.x1 - 20;
                    block5.x2 = block5.x2 - 20;
                    block5.x3 = block5.x3 - 20;
                    block5.x4 = block5.x4 - 20;
                }
            }

        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (block1.x3 < 261) {
                block1.x1 = block1.x1 + 20;
                block1.x2 = block1.x2 + 20;
                block1.x3 = block1.x3 + 20;
            }
            if (block2.onSide == 1) {
                if (block2.x3 < 260) {
                    block2.x1 = block2.x1 + 20;
                    block2.x2 = block2.x2 + 20;
                    block2.x3 = block2.x3 + 20;
                    block2.x4 = block2.x4 + 20;
                }
            }
            if (block2.onSide == 2) {
                if (block2.x3 < 280) {
                    block2.x1 = block2.x1 + 20;
                    block2.x2 = block2.x2 + 20;
                    block2.x3 = block2.x3 + 20;
                    block2.x4 = block2.x4 + 20;
                }
            }
            if (block2.onSide == 3) {
                if (block2.x3 < 260) {
                    block2.x1 = block2.x1 + 20;
                    block2.x2 = block2.x2 + 20;
                    block2.x3 = block2.x3 + 20;
                    block2.x4 = block2.x4 + 20;
                }
            }
            if (block2.onSide == 4) {
                if (block2.x3 < 280) {
                    block2.x1 = block2.x1 + 20;
                    block2.x2 = block2.x2 + 20;
                    block2.x3 = block2.x3 + 20;
                    block2.x4 = block2.x4 + 20;
                }
            }
            if (block3.x3 < 261) {
                block3.x1 = block3.x1 + 20;
                block3.x2 = block3.x2 + 20;
                block3.x3 = block3.x3 + 20;
                block3.x4 = block3.x4 + 20;
            }
            if (block4.onSide == true) {
                if (block4.x3 < 260) {
                    block4.x1 = block4.x1 + 20;
                    block4.x2 = block4.x2 + 20;
                    block4.x3 = block4.x3 + 20;
                    block4.x4 = block4.x4 + 20;
                }
            }
            if (block4.onSide == false) {
                if (block4.x3 < 280) {
                    block4.x1 = block4.x1 + 20;
                    block4.x2 = block4.x2 + 20;
                    block4.x3 = block4.x3 + 20;
                    block4.x4 = block4.x4 + 20;
                }
            }

            if (block5.onSide == true) {
                if (block5.x3 < 260) {
                    block5.x1 = block5.x1 + 20;
                    block5.x2 = block5.x2 + 20;
                    block5.x3 = block5.x3 + 20;
                    block5.x4 = block5.x4 + 20;
                }
            }
            if (block5.onSide == false) {
                if (block5.x3 < 260) {
                    block5.x1 = block5.x1 + 20;
                    block5.x2 = block5.x2 + 20;
                    block5.x3 = block5.x3 + 20;
                    block5.x4 = block5.x4 + 20;
                }
            }

        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            ++spin;

            if (spin == 1 || spin == 3) {
                if (Panel.shapeEnd == false) {

                    block1.onSide = false;
                    block3.onSide = false;
                    block4.onSide = false;
                    block5.onSide = false;
                    block1.offSet = block1.y2;
                    block1.offSet2 = block1.x2;
                    block4.offSet = block4.y3;
                    block4.offSet2 = block4.x3;
                    block5.offSet = block5.y3;
                    block5.offSet2 = block5.x3;

                    if (block4.onSide == false) {
                        block4.shape();
                    }
                    if (block1.onSide == false) {
                        block1.bar();
                    }
                    if (block1.onSide == false) {
                        block3.square();
                    }
                    if (block5.onSide == false) {
                        block5.shape();
                    }
                }
                System.out.println(spin);
            }
            if (spin == 2 || spin == 4) {
                if (Panel.shapeEnd == false) {
                    block1.onSide = true;
                    block3.onSide = true;
                    block4.onSide = true;
                    block5.onSide = true;
                    block1.offSet = block1.y2;
                    block1.offSet2 = block1.x2;
                    block4.offSet = block4.y3;
                    block4.offSet2 = block4.x3;
                    block5.offSet = block5.y3;
                    block5.offSet2 = block5.x3;
                    if (block1.onSide == true) {
                        block1.barOnItsSide();
                    }
                    if (block1.onSide == true) {
                        block3.square();
                    }
                    if (block4.onSide == true) {
                        block4.shapeOnItsSide();
                    }
                    if (block5.onSide == true) {
                        block5.shapeOnItsSide();
                    }
                }

            }
            System.out.println(" spin : " + spin);
            //block2.onSide=1;
            if (firstShape == true) {
                spin = 2;
            } //bug fix
            if (spin == 1 && spin != 3) {
                System.out.println("   inside it now!");
                if (Panel.shapeEnd == false) {
                    block2.onSide = 1;
                    block2.offSet = block2.y2;
                    block2.offSet2 = block2.x2;
                    //block2.shapeTeeUp();
                    block2.shapeTeeRight();
                }
            }
            if (spin == 2 && spin != 4) {
                firstShape = false;  //bug fix
                if (Panel.shapeEnd == false) {
                    block2.onSide = 2;

                    block2.offSet = block2.y2;
                    block2.offSet2 = block2.x2;
                    //block2.shapeTeeRight();
                    block2.shapeTeeUp();
                }
            }
            if (spin == 3 && spin != 1) {

                if (Panel.shapeEnd == false) {
                    block2.onSide = 3;

                    block2.offSet = block2.y2;
                    block2.offSet2 = block2.x2;
                    block2.shapeTeeBottom();

                }
            }
            if (spin == 4 && spin != 2) {
                if (Panel.shapeEnd == false) {
                    block2.onSide = 4;
                    block2.offSet = block2.y2;
                    block2.offSet2 = block2.x2;
                    block2.shapeTeeLeft();
                    spin = 0;
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

