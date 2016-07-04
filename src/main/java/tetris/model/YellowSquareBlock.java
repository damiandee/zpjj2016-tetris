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
public class YellowSquareBlock implements ActionListener {

    public int x1, x2, x3, x4;
    public int y1, y2, y3, y4;
    public int offSet, offSet2;
    public int dropDownTo;
    public boolean onSide;
    public static int num = 0;

    Timer time;

    public YellowSquareBlock() {
        onSide = true;
        coordinates();
        time = new Timer(30, this);
        time.stop();
    }

    public void paint(Graphics g) {
        g.setColor(Color.yellow);
        TetrisController.colr = 3;
        this.dropDownTo = tetris.view.Panel.dropDownTo;
        if (y1 >= this.dropDownTo) {
            Panel.num = 4;
            coordinates();
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
        g.fillRect(x1, y1, 20, 20);
        g.fillRect(x2, y2, 20, 20);
        g.fillRect(x3, y3, 20, 20);
        g.fillRect(x4, y4, 20, 20);
        checkColumn();
        checkRow();

    }

    public void coordinates() {
        x1 = 120;
        x2 = 140;
        x3 = 140;
        x4 = 120;
        y1 = 100;
        y2 = 100;
        y3 = 120;
        y4 = 120;
        this.dropDownTo = 500;
        if (onSide == false) {
            this.onSide = true;
        }
    }

    public void square() {
        coordinates();
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

