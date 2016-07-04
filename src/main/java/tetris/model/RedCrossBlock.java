package tetris.model;

import tetris.controller.TetrisController;
import tetris.view.*;
import tetris.view.Panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Dominika on 2016-07-03.
 */
public class RedCrossBlock implements ActionListener {

    public int x1, x2, x3, x4;
    public int y1, y2, y3, y4;
    public int onSide;
    public int offSet, offSet2, dropDownTo;
    public static boolean pointTop, pointBottom, pointLeft, pointRight;
    public static int num = 0;

    Timer time;

    public RedCrossBlock() {
        coordinates();
        time = new Timer(40, this);
        time.stop();
    }

    public void coordinates() {
        this.onSide = 1;
        x1 = 120;
        x2 = 120;
        x3 = 120;
        x4 = 140;
        y1 = 100;
        y2 = 120;
        y3 = 140;
        y4 = 120;
        this.dropDownTo = 500;
        tetris.view.Panel.offSet = this.y2;
        tetris.view.Panel.offSet2 = this.x2;
    }

    public void paint(Graphics g) {
        if (tetris.view.Panel.spin == 0) {
            Panel.firstShape = true;
        }
        g.setColor(Color.red);
        TetrisController.colr = 2;
        switch (onSide) {
            case 1:
                this.dropDownTo = Panel.dropDownTo - 20;
                break;

            case 4:
                this.dropDownTo = Panel.dropDownTo + 20;
                break;

            default:
                this.dropDownTo = Panel.dropDownTo;
                break;
        }
        if (y1 >= dropDownTo) {
            Panel.shapeEnd = true;
            Panel.num = 3;
            coordinates();
        }

        if (y1 < dropDownTo) {
            Panel.reached = false;
            y1 = y1 + 1;
            y2 = y2 + 1;
            y3 = y3 + 1;
            y4 = y4 + 1;
        }
        if (y1 >= this.dropDownTo) {
            Panel.reached = true;
        }
        g.fillRect(x1, y1, 20, 20);
        g.fillRect(x2, y2, 20, 20);
        g.fillRect(x3, y3, 20, 20);
        g.fillRect(x4, y4, 20, 20);
        checkColumn();
        checkRow();
    }

    public void shapeTeeRight() {
        x1 = offSet2;
        x2 = offSet2;
        x3 = offSet2;
        x4 = offSet2 + 20;
        y1 = offSet - 20;
        y2 = offSet;
        y3 = offSet + 20;
        y4 = offSet;
    }

    public void shapeTeeBottom() {
        x1 = offSet2 - 20;
        x2 = offSet2;
        x3 = offSet2;
        x4 = offSet2 + 20;
        y1 = offSet;
        y2 = offSet;
        y3 = offSet + 20;
        y4 = offSet;
    }

    public void shapeTeeLeft() {
        x1 = offSet2;
        x2 = offSet2;
        x3 = offSet2;
        x4 = offSet2 - 20;
        y1 = offSet + 20;
        y2 = offSet;
        y3 = offSet - 20;
        y4 = offSet;
    }

    public void shapeTeeUp() {
        x1 = offSet2;
        x2 = offSet2;
        x3 = offSet2 + 20;
        x4 = offSet2 - 20;
        y1 = offSet - 20;
        y2 = offSet;
        y3 = offSet;
        y4 = offSet;
    }

    public void checkColumn() {
        tetris.view.Panel.xNum = (x3/20);
    }

    public void checkRow() {
        tetris.view.Panel.yNum = (y1/20);
    }

    public void actionPerformed(ActionEvent arg0) {
    }
}
