package tetris.model;

import tetris.model.factory.Block;
import tetris.model.factory.BlockType;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Dominika on 2016-07-03.
 */

public class BlueSBlock extends Block implements ActionListener {

    private BlockType blueSBlockType = BlockType.BlueSBlock;
    private int coords[][];
    private int[][][] coordsTable;

    public BlueSBlock() {
        coords = new int[4][2];
        setBlockType(BlockType.BlueSBlock);
    }

    @Override
    public void setBlockType(BlockType shape) {

        coordsTable = new int[][][]{
                {{0, 0}, {0, 0}, {0, 0}, {0, 0}},
                {{0, -1}, {0, 0}, {-1, 0}, {-1, 1}},
                {{0, -1}, {0, 0}, {1, 0}, {1, 1}},
                {{0, -1}, {0, 0}, {0, 1}, {0, 2}},
                {{-1, 0}, {0, 0}, {1, 0}, {0, 1}},
                {{0, 0}, {1, 0}, {0, 1}, {1, 1}},
                {{-1, -1}, {0, -1}, {0, 0}, {0, 1}},
                {{1, -1}, {0, -1}, {0, 0}, {0, 1}}
        };

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; ++j) {
                coords[i][j] = coordsTable[shape.ordinal()][i][j];
            }
        }
        blueSBlockType = shape;

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
    public BlueSBlock rotateLeft() {

        BlueSBlock result = new BlueSBlock();
        result.blueSBlockType = blueSBlockType;

        for (int i = 0; i < 4; ++i) {
            result.setX(i, getY(i));
            result.setY(i, -getX(i));
        }
        return result;
    }

    @Override
    public BlueSBlock rotateRight() {

        BlueSBlock result = new BlueSBlock();
        result.blueSBlockType = blueSBlockType;

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
        return this.blueSBlockType;
    }

    public int[][] getCoordinates() {
        return coords;
    }

    public void actionPerformed(ActionEvent e) {
    }
}
