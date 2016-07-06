package tetris.view;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Dominika on 2016-07-05.
 */
public class FrameTest {

    //TODO dokonczyc test po mergu
    Frame frame;

    @Before
    public void setUp() {
        frame = new Frame();
    }

    @Test
    public void checkStatusBarTest() {
        String expectedStatus = "zpjj2016";
        frame.statusbar.setText(expectedStatus);
        assertEquals(frame.statusbar.getText(), expectedStatus);
    }
}