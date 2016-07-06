package tetris.model.factory;

/**
 * Created by Damian Deska on 2016-07-04.
 */
public abstract class Block {
    protected BlockType blockType;

    public abstract Block getBlock();
    public abstract BlockType getBlockType();
    public abstract void setBlockType(BlockType blockType);
    public abstract int getX(int index);
    public abstract int getY(int index);
    public abstract int minX();
    public abstract int getMinY();
    public abstract Block rotateLeft();
    public abstract Block rotateRight();
}
