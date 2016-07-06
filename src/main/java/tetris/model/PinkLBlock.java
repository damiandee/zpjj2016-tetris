package tetris.model;

import tetris.model.factory.Block;
import tetris.model.factory.BlockType;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Damian Deska on 2016-07-06.
 */

public class PinkLBlock extends Block implements ActionListener {

    private BlockType pinkLBlock = BlockType.PinkLBlock;
    private int coords[][];

    public PinkLBlock() {
        setBlockType(BlockType.PinkLBlock);
    }

    @Override
    public void setBlockType(BlockType shape) {
        coords = new int[][] {{-1, -1}, {0, -1}, {0, 0}, {0, 1}};
        pinkLBlock = shape;
    }

    public void setX(int index, int x) {
        coords[index][0] = x;
    }

    public void setY(int index, int y) {
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
    public PinkLBlock rotateLeft() {

        PinkLBlock result = new PinkLBlock();
        result.pinkLBlock = pinkLBlock;

        for (int i = 0; i < 4; ++i) {
            result.setX(i, getY(i));
            result.setY(i, -getX(i));
        }
        return result;
    }

    @Override
    public PinkLBlock rotateRight() {

        PinkLBlock result = new PinkLBlock();
        result.pinkLBlock = pinkLBlock;

        for (int i = 0; i < 4; ++i) {
            result.setX(i, -getY(i));
            result.setY(i, getX(i));
        }
        return result;
    }

    @Override
    public Block getBlock() {
        return this;
    }

    @Override
    public BlockType getBlockType(){
        return this.pinkLBlock;
    }

    public int[][] getCoordinates() {
        return coords;
    }

    public void actionPerformed(ActionEvent e) {
    }
}
