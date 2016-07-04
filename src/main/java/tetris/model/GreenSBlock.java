package tetris.model;

import tetris.controller.TetrisController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Dominika on 2016-07-03.
 */
public class GreenSBlock extends Block implements ActionListener {

    public int x1, x2, x3, x4;
    public int y1, y2, y3, y4;
    public int spin;
    public int offSet, offSet2, dropDownTo;
    public boolean onSide, standingOffset = false;
    public static int num = 0;
    Timer time;

    public GreenSBlock() {
        onSide = true;
        coordinates();
        time = new Timer(20, this);
        time.stop();
    }

    @Override
    public Block getBlock() {
        return this;
    }

    public void coordinates() {
        x1 = 140;
        x2 = 160;
        x3 = 140;
        x4 = 120;
        y1 = 40;
        y2 = 40;
        y3 = 60;
        y4 = 60;
        this.dropDownTo = 500;
        if (onSide == false) {
            this.onSide = true;
        }
        tetris.view.Panel.offSet = this.y3;
        tetris.view.Panel.offSet2 = this.x3;
    }

    public void paint(Graphics g) {
        g.setColor(Color.green);
        TetrisController.colr = 4;
        if (onSide == false) {
            this.dropDownTo = tetris.view.Panel.dropDownTo - 20;
            if (y1 >= this.dropDownTo) {
                tetris.view.Panel.shapeEnd = true;
                tetris.view.Panel.num = 5;
                coordinates();
            }
        }
        if (onSide == true) {
            this.dropDownTo = tetris.view.Panel.dropDownTo;
            if (y1 >= this.dropDownTo) {
                tetris.view.Panel.shapeEnd = true;
                tetris.view.Panel.num = 5;
                coordinates();
            }
        }
        if (y1 < this.dropDownTo) {
            tetris.view.Panel.reached = false;
            y1 = y1 + 1;
            y2 = y2 + 1;
            y3 = y3 + 1;
            y4 = y4 + 1;
        }
        if (y1 >= this.dropDownTo) {
            tetris.view.Panel.reached = true;
        }
        g.fillRect(x1, y1, 20, 20);
        g.fillRect(x2, y2, 20, 20);
        g.fillRect(x3, y3, 20, 20);
        g.fillRect(x4, y4, 20, 20);
        checkColumn();
        checkRow();
    }

    public void shapeOnItsSide() {
        standingOffset = false;
        x1 = offSet2;
        x2 = offSet2 + 20;
        x3 = offSet2;
        x4 = offSet2 - 20;
        y1 = offSet - 20;
        y2 = offSet - 20;
        y3 = offSet;
        y4 = offSet;
    }

    public void shape() {
        standingOffset = true;
        x1 = offSet2 - 20;
        x2 = offSet2 - 20;
        x3 = offSet2;
        x4 = offSet2;
        y1 = offSet - 20;
        y2 = offSet;
        y3 = offSet;
        y4 = offSet + 20;
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

