package tetris.model;

import org.junit.Before;
import org.junit.Test;
import tetris.model.factory.BlockType;
import static org.junit.Assert.*;

/**
 * Created by Dominika on 2016-07-05.
 */
public class BlueSBlockTest {

    int[][] expectedCoordinates;
    BlueSBlock blueSBlock;

    @Before
    public void setUp() {
        blueSBlock = new BlueSBlock();
        expectedCoordinates = new int[][] {{0, -1}, {0, 0}, {-1,0}, {-1, 1}};
    }

    @Test
    public void checkBlueSBlockTypeTest(){
        assertEquals(blueSBlock.getBlockType(), BlockType.BlueSBlock);
    }

    @Test
    public void checkCoordinatesTest() {

        assertArrayEquals(blueSBlock.getCoordinates(), expectedCoordinates);
    }

    @Test
    public void getXTest() {
        assertEquals(blueSBlock.getX(3), -1);
    }

    @Test
    public void getYTest() {
        assertEquals(blueSBlock.getY(3), 1);
    }

    @Test
    public void setXTest() {
        int newX = 5;
        blueSBlock.setX(0, newX);

        assertEquals(blueSBlock.getX(0), newX);
    }

    @Test
    public void setYTest() {
        int newY = 5;
        blueSBlock.setY(0, newY);

        assertEquals(blueSBlock.getY(0), newY);
    }

    @Test
    public void getMinYTest() {
        int newMinY = 10;

        for(int i = 0; i < 4; i++) {
            blueSBlock.setY(i, newMinY + i);
        }

        assertEquals(blueSBlock.getMinY(), newMinY);
    }

    @Test
    public void rotateLeftTest() {
        for(int i = 0; i < 4; i++) {
            int tmpValue = -expectedCoordinates[i][0];
            expectedCoordinates[i][0] = expectedCoordinates[i][1];
            expectedCoordinates[i][1] = tmpValue;
        }

        blueSBlock.rotateLeft();

        assertArrayEquals(blueSBlock.rotateLeft().getCoordinates(), expectedCoordinates);
    }

    @Test
    public void rotateRightTest() {
        for(int i = 0; i < 4; i++) {
            int tmpValue = expectedCoordinates[i][0];
            expectedCoordinates[i][0] = -expectedCoordinates[i][1];
            expectedCoordinates[i][1] = tmpValue;
        }

        blueSBlock.rotateRight();

        assertArrayEquals(blueSBlock.rotateRight().getCoordinates(), expectedCoordinates);
    }
}