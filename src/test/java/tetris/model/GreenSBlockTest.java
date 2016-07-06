package tetris.model;

import org.junit.Before;
import org.junit.Test;
import tetris.model.factory.BlockType;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by Dominika on 2016-07-05.
 */
public class GreenSBlockTest {

    int[][] expectedCoordinates;
    GreenSBlock greenSBlock;

    @Before
    public void setUp() {
        greenSBlock = new GreenSBlock();
        expectedCoordinates = new int[][] {{0, -1}, {0, 0}, {1, 0}, {1, 1}};
    }

    @Test
    public void checkBlueSBlockTypeTest(){
        assertEquals(greenSBlock.getBlockType(), BlockType.GreenSBlock);
    }

    @Test
    public void checkCoordinatesTest() {

        assertArrayEquals(greenSBlock.getCoordinates(), expectedCoordinates);
    }

    @Test
    public void getXTest() {
        assertEquals(greenSBlock.getX(3), 1);
    }

    @Test
    public void getYTest() {
        assertEquals(greenSBlock.getY(3), 1);
    }

    @Test
    public void setXTest() {
        int newX = 5;
        greenSBlock.setX(0, newX);

        assertEquals(greenSBlock.getX(0), newX);
    }

    @Test
    public void setYTest() {
        int newY = 5;
        greenSBlock.setY(0, newY);

        assertEquals(greenSBlock.getY(0), newY);
    }

    @Test
    public void getMinYTest() {
        int newMinY = 10;

        for(int i = 0; i < 4; i++) {
            greenSBlock.setY(i, newMinY + i);
        }

        assertEquals(greenSBlock.getMinY(), newMinY);
    }

    @Test
    public void rotateLeftTest() {
        for(int i = 0; i < 4; i++) {
            int tmpValue = -expectedCoordinates[i][0];
            expectedCoordinates[i][0] = expectedCoordinates[i][1];
            expectedCoordinates[i][1] = tmpValue;
        }

        greenSBlock.rotateLeft();

        assertArrayEquals(greenSBlock.rotateLeft().getCoordinates(), expectedCoordinates);
    }

    @Test
    public void rotateRightTest() {
        for(int i = 0; i < 4; i++) {
            int tmpValue = expectedCoordinates[i][0];
            expectedCoordinates[i][0] = -expectedCoordinates[i][1];
            expectedCoordinates[i][1] = tmpValue;
        }

        greenSBlock.rotateRight();

        assertArrayEquals(greenSBlock.rotateRight().getCoordinates(), expectedCoordinates);
    }
}