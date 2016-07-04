package tetris.model.factory;

/**
 * Created by Damian Deska on 2016-07-04.
 */
public abstract class Block {
    protected BlockType blockType;

    public abstract Block getBlock();
    public abstract BlockType getBlockType();
    public abstract void setBlockType(BlockType blockType);
    public abstract int x(int index);
    public abstract int y(int index);
    public abstract int minX();
    public abstract int minY();
    public abstract Block rotateLeft();
    public abstract Block rotateRight();
}
