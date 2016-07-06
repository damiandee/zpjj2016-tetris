package tetris.model;

import org.junit.Before;
import org.junit.Test;
import tetris.model.factory.BlockType;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by Dominika on 2016-07-05.
 */
public class RedCrossBlockTest {

    int[][] expectedCoordinates;
    RedCrossBlock redCrossBlock;

    @Before
    public void setUp() {
        redCrossBlock = new RedCrossBlock();
        expectedCoordinates = new int[][] {{-1, 0}, {0, 0}, {1, 0}, {0, 1}};
    }

    @Test
    public void checkBlueSBlockTypeTest(){
        assertEquals(redCrossBlock.getBlockType(), BlockType.RedCrossBlock);
    }

    @Test
    public void checkCoordinatesTest() {

        assertArrayEquals(redCrossBlock.getCoordinates(), expectedCoordinates);
    }

    @Test
    public void getXTest() {
        assertEquals(redCrossBlock.getX(3), 0);
    }

    @Test
    public void getYTest() {
        assertEquals(redCrossBlock.getY(3), 1);
    }

    @Test
    public void setXTest() {
        int newX = 5;
        redCrossBlock.setX(0, newX);

        assertEquals(redCrossBlock.getX(0), newX);
    }

    @Test
    public void setYTest() {
        int newY = 5;
        redCrossBlock.setY(0, newY);

        assertEquals(redCrossBlock.getY(0), newY);
    }

    @Test
    public void getMinYTest() {
        int newMinY = 10;

        for(int i = 0; i < 4; i++) {
            redCrossBlock.setY(i, newMinY + i);
        }

        assertEquals(redCrossBlock.getMinY(), newMinY);
    }

    @Test
    public void rotateLeftTest() {
        for(int i = 0; i < 4; i++) {
            int tmpValue = -expectedCoordinates[i][0];
            expectedCoordinates[i][0] = expectedCoordinates[i][1];
            expectedCoordinates[i][1] = tmpValue;
        }

        redCrossBlock.rotateLeft();

        assertArrayEquals(redCrossBlock.rotateLeft().getCoordinates(), expectedCoordinates);
    }

    @Test
    public void rotateRightTest() {
        for(int i = 0; i < 4; i++) {
            int tmpValue = expectedCoordinates[i][0];
            expectedCoordinates[i][0] = -expectedCoordinates[i][1];
            expectedCoordinates[i][1] = tmpValue;
        }

        redCrossBlock.rotateRight();

        assertArrayEquals(redCrossBlock.rotateRight().getCoordinates(), expectedCoordinates);
    }
}