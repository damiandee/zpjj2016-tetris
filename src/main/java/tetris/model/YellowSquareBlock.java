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
        switch (x3) {
            case 40:
                tetris.view.Panel.xNum = 2;
                break;
            case 60:
                tetris.view.Panel.xNum = 3;
                break;
            case 80:
                tetris.view.Panel.xNum = 4;
                break;
            case 100:
                tetris.view.Panel.xNum = 5;
                break;
            case 120:
                tetris.view.Panel.xNum = 6;
                break;
            case 140:
                tetris.view.Panel.xNum = 7;
                break;
            case 160:
                tetris.view.Panel.xNum = 8;
                break;
            case 180:
                tetris.view.Panel.xNum = 9;
                break;
            case 200:
                tetris.view.Panel.xNum = 10;
                break;
            case 220:
                tetris.view.Panel.xNum = 11;
                break;
            case 240:
                tetris.view.Panel.xNum = 12;
                break;
            case 260:
                tetris.view.Panel.xNum = 13;
                break;
            case 280:
                tetris.view.Panel.xNum = 14;
                break;
        }
    }

    public void checkRow() {
        switch (y1) {
            case 40:
                tetris.view.Panel.yNum = 2;
                break;
            case 60:
                tetris.view.Panel.yNum = 3;
                break;
            case 80:
                tetris.view.Panel.yNum = 4;
                break;
            case 100:
                tetris.view.Panel.yNum = 5;
                break;
            case 120:
                tetris.view.Panel.yNum = 6;
                break;
            case 140:
                tetris.view.Panel.yNum = 7;
                break;
            case 160:
                tetris.view.Panel.yNum = 8;
                break;
            case 180:
                tetris.view.Panel.yNum = 9;
                break;
            case 200:
                tetris.view.Panel.yNum = 10;
                break;
            case 220:
                tetris.view.Panel.yNum = 11;
                break;
            case 240:
                tetris.view.Panel.yNum = 12;
                break;
            case 260:
                tetris.view.Panel.yNum = 13;
                break;
            case 280:
                tetris.view.Panel.yNum = 14;
                break;
            case 300:
                tetris.view.Panel.yNum = 15;
                break;
            case 320:
                tetris.view.Panel.yNum = 16;
                break;
            case 340:
                tetris.view.Panel.yNum = 17;
                break;
            case 360:
                tetris.view.Panel.yNum = 18;
                break;
            case 380:
                tetris.view.Panel.yNum = 19;
                break;
            case 400:
                tetris.view.Panel.yNum = 20;
                break;
            case 420:
                tetris.view.Panel.yNum = 21;
                break;
            case 440:
                tetris.view.Panel.yNum = 22;
                break;
            case 460:
                tetris.view.Panel.yNum = 23;
                break;
            case 480:
                tetris.view.Panel.yNum = 24;
                break;
            case 500:
                tetris.view.Panel.yNum = 25;
                break;
            case 520:
                tetris.view.Panel.yNum = 26;
                break;
        }
    }

    public void actionPerformed(ActionEvent e) {
    }
}

