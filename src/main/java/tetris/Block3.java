package tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Dominika on 2016-07-03.
 */
public class Block3 implements ActionListener {

    public int x1, x2, x3, x4;
    public int y1, y2, y3, y4;
    public int offSet, offSet2;
    public int dropDownTo;
    public boolean onSide;
    public static int num = 0;

    Timer time;

    public Block3() {
        onSide = true;
        coordinates();
        time = new Timer(30, this);
        time.stop();
    }

    public void paint(Graphics g) {
        g.setColor(Color.yellow);
        //Controler.colr = 3;

        this.dropDownTo = Panel.dropDownTo;
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
                Panel.xNum = 2;
                break;
            case 60:
                Panel.xNum = 3;
                break;
            case 80:
                Panel.xNum = 4;
                break;
            case 100:
                Panel.xNum = 5;
                break;
            case 120:
                Panel.xNum = 6;
                break;
            case 140:
                Panel.xNum = 7;
                break;
            case 160:
                Panel.xNum = 8;
                break;
            case 180:
                Panel.xNum = 9;
                break;
            case 200:
                Panel.xNum = 10;
                break;
            case 220:
                Panel.xNum = 11;
                break;
            case 240:
                Panel.xNum = 12;
                break;
            case 260:
                Panel.xNum = 13;
                break;
            case 280:
                Panel.xNum = 14;
                break;
        }

    }

    public void checkRow() {

        switch (y1) {

            case 40:
                Panel.yNum = 2;
                break;
            case 60:
                Panel.yNum = 3;
                break;
            case 80:
                Panel.yNum = 4;
                break;
            case 100:
                Panel.yNum = 5;
                break;
            case 120:
                Panel.yNum = 6;
                break;
            case 140:
                Panel.yNum = 7;
                break;
            case 160:
                Panel.yNum = 8;
                break;
            case 180:
                Panel.yNum = 9;
                break;
            case 200:
                Panel.yNum = 10;
                break;
            case 220:
                Panel.yNum = 11;
                break;
            case 240:
                Panel.yNum = 12;
                break;
            case 260:
                Panel.yNum = 13;
                break;
            case 280:
                Panel.yNum = 14;
                break;
            case 300:
                Panel.yNum = 15;
                break;
            case 320:
                Panel.yNum = 16;
                break;
            case 340:
                Panel.yNum = 17;
                break;
            case 360:
                Panel.yNum = 18;
                break;
            case 380:
                Panel.yNum = 19;
                break;
            case 400:
                Panel.yNum = 20;
                break;
            case 420:
                Panel.yNum = 21;
                break;
            case 440:
                Panel.yNum = 22;
                break;
            case 460:
                Panel.yNum = 23;
                break;
            case 480:
                Panel.yNum = 24;
                break;
            case 500:
                Panel.yNum = 25;
                break;
            case 520:
                Panel.yNum = 26;
                break;
        }

    }
    
    public void actionPerformed(ActionEvent e) {

    }
}

