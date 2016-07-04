package tetris.model.factory;

import tetris.model.*;

/**
 * Created by Damian Deska on 2016-07-04.
 */
public class TetrisBlockFactory implements BlockFactory {

    //@Override
    public Block makeBlock(BlockType blockType) {
        Block block = null;

        switch(blockType) {
            case BlueSBlock:
                block = new BlueSBlock();
                break;

            case CyanBarBlock:
                block = new CyanBarBlock();
                break;

            case GreenSBlock:
                block = new GreenSBlock();
                break;

            case RedCrossBlock:
                block = new RedCrossBlock();
                break;

            case YellowSquareBlock:
                block = new YellowSquareBlock();
                break;
        }
        return block;
    }

}
