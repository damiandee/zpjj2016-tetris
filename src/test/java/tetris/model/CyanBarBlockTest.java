package tetris.model;

import org.junit.Before;
import org.junit.Test;
import tetris.model.factory.BlockType;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by Dominika on 2016-07-05.
 */
public class CyanBarBlockTest {

    int[][] expectedCoordinates;
    CyanBarBlock cyanBarBlock;

    @Before
    public void setUp() {
        cyanBarBlock = new CyanBarBlock();
        expectedCoordinates = new int[][] {{0, -1}, {0, 0}, {0, 1}, {0, 2}};
    }

    @Test
    public void checkBlueSBlockTypeTest(){
        assertEquals(cyanBarBlock.getBlockType(), BlockType.CyanBarBlock);
    }

    @Test
    public void checkCoordinatesTest() {

        assertArrayEquals(cyanBarBlock.getCoordinates(), expectedCoordinates);
    }

    @Test
    public void getXTest() {
        assertEquals(cyanBarBlock.getX(3), 0);
    }

    @Test
    public void getYTest() {
        assertEquals(cyanBarBlock.getY(3), 2);
    }

    @Test
    public void setXTest() {
        int newX = 5;
        cyanBarBlock.setX(0, newX);

        assertEquals(cyanBarBlock.getX(0), newX);
    }

    @Test
    public void setYTest() {
        int newY = 5;
        cyanBarBlock.setY(0, newY);

        assertEquals(cyanBarBlock.getY(0), newY);
    }

    @Test
    public void getMinYTest() {
        int newMinY = 10;

        for(int i = 0; i < 4; i++) {
            cyanBarBlock.setY(i, newMinY + i);
        }

        assertEquals(cyanBarBlock.getMinY(), newMinY);
    }

    @Test
    public void rotateLeftTest() {
        for(int i = 0; i < 4; i++) {
            int tmpValue = -expectedCoordinates[i][0];
            expectedCoordinates[i][0] = expectedCoordinates[i][1];
            expectedCoordinates[i][1] = tmpValue;
        }

        cyanBarBlock.rotateLeft();

        assertArrayEquals(cyanBarBlock.rotateLeft().getCoordinates(), expectedCoordinates);
    }

    @Test
    public void rotateRightTest() {
        for(int i = 0; i < 4; i++) {
            int tmpValue = expectedCoordinates[i][0];
            expectedCoordinates[i][0] = -expectedCoordinates[i][1];
            expectedCoordinates[i][1] = tmpValue;
        }

        cyanBarBlock.rotateRight();

        assertArrayEquals(cyanBarBlock.rotateRight().getCoordinates(), expectedCoordinates);
    }
}