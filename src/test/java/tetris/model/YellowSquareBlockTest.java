package tetris.model;

import org.junit.Before;
import org.junit.Test;
import tetris.model.factory.BlockType;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by Dominika on 2016-07-05.
 */
public class YellowSquareBlockTest {

    int[][] expectedCoordinates;
    YellowSquareBlock yellowSquareBlock;

    @Before
    public void setUp() {
        yellowSquareBlock = new YellowSquareBlock();
        expectedCoordinates = new int[][] {{0, 0}, {1, 0}, {0, 1}, {1, 1}};
    }

    @Test
    public void checkBlueSBlockTypeTest(){
        assertEquals(yellowSquareBlock.getBlockType(), BlockType.YellowSquareBlock);
    }

    @Test
    public void checkCoordinatesTest() {

        assertArrayEquals(yellowSquareBlock.getCoordinates(), expectedCoordinates);
    }

    @Test
    public void getXTest() {
        assertEquals(yellowSquareBlock.getX(3), 1);
    }

    @Test
    public void getYTest() {
        assertEquals(yellowSquareBlock.getY(3), 1);
    }

    @Test
    public void setXTest() {
        int newX = 5;
        yellowSquareBlock.setX(0, newX);

        assertEquals(yellowSquareBlock.getX(0), newX);
    }

    @Test
    public void setYTest() {
        int newY = 5;
        yellowSquareBlock.setY(0, newY);

        assertEquals(yellowSquareBlock.getY(0), newY);
    }

    @Test
    public void getMinYTest() {
        int newMinY = 10;

        for(int i = 0; i < 4; i++) {
            yellowSquareBlock.setY(i, newMinY + i);
        }

        assertEquals(yellowSquareBlock.getMinY(), newMinY);
    }

    @Test
    public void rotateLeftTest() {
        yellowSquareBlock.rotateLeft();
        assertArrayEquals(yellowSquareBlock.rotateLeft().getCoordinates(), expectedCoordinates);
    }

    @Test
    public void rotateRightTest() {
        yellowSquareBlock.rotateRight();
        assertArrayEquals(yellowSquareBlock.rotateRight().getCoordinates(), expectedCoordinates);
    }
}