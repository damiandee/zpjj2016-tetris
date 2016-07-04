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

public class BlueStairsBlock implements ActionListener {

    Timer time;

    public int x1, x2, x3, x4;
    public int y1, y2, y3, y4;
    public int offSet, offSet2, dropDownTo;
    public boolean onSide, standingOffset = false;

    public static int num = 0;

    public BlueStairsBlock() {
        onSide = true;
        coordinates();
        time = new Timer(10, this);
        time.stop();
    }

    public void coordinates() {
        x1 = 120;
        x2 = 140;
        x3 = 140;
        x4 = 160;
        y1 = 40;
        y2 = 40;
        y3 = 60;
        y4 = 60;
        this.dropDownTo = 500;
        if (onSide == false) {
            this.onSide = true;
        }
        tetris.view.Panel.offSet2 = this.x3;
        tetris.view.Panel.offSet = this.y3;
    }

    public void paint(Graphics g) {
        if (onSide == false) {

            this.dropDownTo = tetris.view.Panel.dropDownTo - 20;

            if (y1 >= this.dropDownTo) {
                Panel.shapeEnd = true;
                Panel.num = 1;
                coordinates();
            }
        }
        if (onSide == true) {
            this.dropDownTo = Panel.dropDownTo;

            if (y1 >= this.dropDownTo) {
                Panel.shapeEnd = true;
                Panel.num = 1;
                coordinates();
            }
        }
        if (y1 < this.dropDownTo) {
            Panel.reached = false;
            y1 = y1 + 1;
            y2 = y2 + 1;
            y3 = y3 + 1;
            y4 = y4 + 1;
        }
        if (y1 >= this.dropDownTo) {
            Panel.reached = true;
        }
        g.setColor(Color.blue);
        TetrisController.colr = 5;
        //Controler.col=x3;
        //Controler.row=this.dropDownTo;
        int nums = 0;
        g.fillRect(x1, y1, 20, 20);
        g.fillRect(x2, y2, 20, 20);
        g.fillRect(x3, y3, 20, 20);
        g.fillRect(x4, y4, 20, 20);
        checkColumn();
        checkRow();
    }

    public void shape() {
        standingOffset = true;
        x1 = offSet2 + 20;
        x2 = offSet2 + 20;
        x3 = offSet2;
        x4 = offSet2;
        y1 = offSet - 40;
        y2 = offSet - 20;
        y3 = offSet;
        y4 = offSet - 20;
    }

    public void shapeOnItsSide() {
        standingOffset = false;
        x1 = offSet2 - 20;
        x2 = offSet2;
        x3 = offSet2;
        x4 = offSet2 + 20;
        y1 = offSet - 20;
        y2 = offSet - 20;
        y3 = offSet;
        y4 = offSet;
    }

    public void checkColumn() {
        tetris.view.Panel.xNum = (x3/20);
    }

    public void checkRow() {
        tetris.view.Panel.yNum = (y1/20);
    }

    public void actionPerformed(ActionEvent e) {
    }
}
