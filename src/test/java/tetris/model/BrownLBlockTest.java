package tetris.model;

import org.junit.Before;
import org.junit.Test;
import tetris.model.factory.BlockType;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by Damian Deska on 2016-07-06.
 */
public class BrownLBlockTest {

    int[][] expectedCoordinates;
    BrownLBlock brownLBlock;

    @Before
    public void setUp() {
        brownLBlock = new BrownLBlock();
        expectedCoordinates = new int[][] {{1, -1}, {0, -1}, {0, 0}, {0, 1}};
    }

    @Test
    public void checkBlueSBlockTypeTest(){
        assertEquals(brownLBlock.getBlockType(), BlockType.BrownLBlock);
    }

    @Test
    public void checkCoordinatesTest() {

        assertArrayEquals(brownLBlock.getCoordinates(), expectedCoordinates);
    }

    @Test
    public void getXTest() {
        assertEquals(brownLBlock.getX(3), 0);
    }

    @Test
    public void getYTest() {
        assertEquals(brownLBlock.getY(3), 1);
    }

    @Test
    public void setXTest() {
        int newX = 5;
        brownLBlock.setX(0, newX);

        assertEquals(brownLBlock.getX(0), newX);
    }

    @Test
    public void setYTest() {
        int newY = 5;
        brownLBlock.setY(0, newY);

        assertEquals(brownLBlock.getY(0), newY);
    }

    @Test
    public void getMinYTest() {
        int newMinY = 10;

        for(int i = 0; i < 4; i++) {
            brownLBlock.setY(i, newMinY + i);
        }

        assertEquals(brownLBlock.getMinY(), newMinY);
    }

    @Test
    public void rotateLeftTest() {
        for(int i = 0; i < 4; i++) {
            int tmpValue = -expectedCoordinates[i][0];
            expectedCoordinates[i][0] = expectedCoordinates[i][1];
            expectedCoordinates[i][1] = tmpValue;
        }

        brownLBlock.rotateLeft();

        assertArrayEquals(brownLBlock.rotateLeft().getCoordinates(), expectedCoordinates);
    }

    @Test
    public void rotateRightTest() {
        for(int i = 0; i < 4; i++) {
            int tmpValue = expectedCoordinates[i][0];
            expectedCoordinates[i][0] = -expectedCoordinates[i][1];
            expectedCoordinates[i][1] = tmpValue;
        }

        brownLBlock.rotateRight();

        assertArrayEquals(brownLBlock.rotateRight().getCoordinates(), expectedCoordinates);
    }
}
