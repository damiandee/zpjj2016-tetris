package tetris.model;

import org.junit.Before;
import org.junit.Test;
import tetris.model.factory.BlockType;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by Damian Deska on 2016-07-06.
 */
public class PinkLBlockTest {

    int[][] expectedCoordinates;
    PinkLBlock pinkLBlockTest;

    @Before
    public void setUp() {
        pinkLBlockTest = new PinkLBlock();
        expectedCoordinates = new int[][] {{-1, -1}, {0, -1}, {0, 0}, {0, 1}};
    }

    @Test
    public void checkBlueSBlockTypeTest(){
        assertEquals(pinkLBlockTest.getBlockType(), BlockType.PinkLBlock);
    }

    @Test
    public void checkCoordinatesTest() {

        assertArrayEquals(pinkLBlockTest.getCoordinates(), expectedCoordinates);
    }

    @Test
    public void getXTest() {
        assertEquals(pinkLBlockTest.getX(3), 0);
    }

    @Test
    public void getYTest() {
        assertEquals(pinkLBlockTest.getY(3), 1);
    }

    @Test
    public void setXTest() {
        int newX = 5;
        pinkLBlockTest.setX(0, newX);

        assertEquals(pinkLBlockTest.getX(0), newX);
    }

    @Test
    public void setYTest() {
        int newY = 5;
        pinkLBlockTest.setY(0, newY);

        assertEquals(pinkLBlockTest.getY(0), newY);
    }

    @Test
    public void getMinYTest() {
        int newMinY = 10;

        for(int i = 0; i < 4; i++) {
            pinkLBlockTest.setY(i, newMinY + i);
        }

        assertEquals(pinkLBlockTest.getMinY(), newMinY);
    }

    @Test
    public void rotateLeftTest() {
        for(int i = 0; i < 4; i++) {
            int tmpValue = -expectedCoordinates[i][0];
            expectedCoordinates[i][0] = expectedCoordinates[i][1];
            expectedCoordinates[i][1] = tmpValue;
        }

        pinkLBlockTest.rotateLeft();

        assertArrayEquals(pinkLBlockTest.rotateLeft().getCoordinates(), expectedCoordinates);
    }

    @Test
    public void rotateRightTest() {
        for(int i = 0; i < 4; i++) {
            int tmpValue = expectedCoordinates[i][0];
            expectedCoordinates[i][0] = -expectedCoordinates[i][1];
            expectedCoordinates[i][1] = tmpValue;
        }

        pinkLBlockTest.rotateRight();

        assertArrayEquals(pinkLBlockTest.rotateRight().getCoordinates(), expectedCoordinates);
    }

}
