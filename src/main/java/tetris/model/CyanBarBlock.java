package tetris.model;

import tetris.controller.TetrisController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Dominika on 2016-07-03.
 */
public class CyanBarBlock extends Block implements ActionListener {

    public int x1, x2, x3;
    public int y1, y2, y3;
    public int offSet, offSet2, dropDownTo;
    public boolean onSide;
    public static int num = 0;

    Timer time;

    public CyanBarBlock() {
        onSide = true;
        if (tetris.view.Panel.spin != 0) {
            tetris.view.Panel.spin = 0;
        }
        time = new Timer(50, this);
        time.stop();
        coordinates();
    }

    @Override
    public Block getBlock() {
        return this;
    }

    public void coordinates() {
        //onSide=true;
        x1 = 120;
        x2 = 140;
        x3 = 160;
        y1 = 60;
        y2 = 60;
        y3 = 60;
        this.dropDownTo = 500;

        if (tetris.view.Panel.spin == 1) {
            tetris.view.Panel.spin = 2;
        }
        if (tetris.view.Panel.spin == 3) {
            tetris.view.Panel.spin = 0;
        }
        if (onSide == false) {
            this.onSide = true;
        }
        tetris.view.Panel.offSet = this.y2;
        tetris.view.Panel.offSet2 = this.x2;
    }

    public void paint(Graphics g) {
        if (onSide == false) {
            this.dropDownTo = tetris.view.Panel.dropDownTo;
            if (y1 >= dropDownTo + 20) {
                tetris.view.Panel.shapeEnd = true;
                tetris.view.Panel.num = 2;
                coordinates();
            }
        }
        if (onSide == true) {
            this.dropDownTo = tetris.view.Panel.dropDownTo;
            if (y1 >= dropDownTo + 20) {
                tetris.view.Panel.shapeEnd = true;
                tetris.view.Panel.num = 2;
                coordinates();
            }
        }
        if (y1 < dropDownTo + 20) {
            tetris.view.Panel.reached = false;
            y1 = y1 + 1;
            y2 = y2 + 1;
            y3 = y3 + 1;
        }
        if (y1 >= this.dropDownTo + 20) {
            tetris.view.Panel.reached = true;
        }
        g.setColor(Color.cyan);
        TetrisController.colr = 1;
        g.fillRect(x1, y1, 20, 20);
        g.fillRect(x2, y2, 20, 20);
        g.fillRect(x3, y3, 20, 20);
        checkColumn();
        checkRow();
    }

    public void bar() {
        x1 = offSet2;
        x2 = offSet2;
        x3 = offSet2;
        y1 = offSet + 20;
        y2 = offSet;
        y3 = offSet - 20;
    }

    public void barOnItsSide() {
        x1 = offSet2 - 20;
        x2 = offSet2;
        x3 = offSet2 + 20;
        y1 = offSet;
        y2 = offSet;
        y3 = offSet;
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
