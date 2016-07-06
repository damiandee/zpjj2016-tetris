package tetris.model;

import tetris.model.factory.Block;
import tetris.model.factory.BlockType;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Dominika on 2016-07-03.
 */
public class YellowSquareBlock extends Block implements ActionListener {

    private BlockType yellowSquareBlockType = BlockType.YellowSquareBlock;
    private int coords[][];

    public YellowSquareBlock() {
        coords = new int[4][2];
        setBlockType(BlockType.YellowSquareBlock);
    }

    public void setBlockType(BlockType shape) {
        coords = new int[][]{{0, 0}, {1, 0}, {0, 1}, {1, 1}};
        yellowSquareBlockType = shape;
    }

    private void setX(int index, int x) {
        coords[index][0] = x;
    }

    private void setY(int index, int y) {
        coords[index][1] = y;
    }

    @Override
    public int getX(int index) {
        return coords[index][0];
    }

    @Override
    public int getY(int index) {
        return coords[index][1];
    }

    @Override
    public int minX() {
        int m = coords[0][0];
        for (int i = 0; i < 4; i++) {
            m = Math.min(m, coords[i][0]);
        }
        return m;
    }

    @Override
    public int getMinY() {
        int m = coords[0][1];
        for (int i = 0; i < 4; i++) {
            m = Math.min(m, coords[i][1]);
        }
        return m;
    }

    @Override
    public YellowSquareBlock rotateLeft() {

        return this;
    }

    @Override
    public YellowSquareBlock rotateRight() {

        return this;
    }

    @Override
    public Block getBlock() {
        return this;
    }

    @Override
    public BlockType getBlockType() {
        return this.yellowSquareBlockType;
    }

    public void actionPerformed(ActionEvent e) {
    }
}

