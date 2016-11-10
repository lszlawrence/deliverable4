import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by lszlawrence on 2016/11/10.
 */
public class CellTest {
    @Test
    public void testToString(){
        Cell cell = new Cell(true);
        cell.setAlive(true);
        assertEquals(cell.toString(),"X");
    }

    @Test
    public void testAliveString(){
        Cell cell = new Cell(true);
        assertTrue(cell.toString().contains("X"));
    }

    @Test
    public void testDeadString(){
        Cell cell = new Cell(false);
        assertTrue(cell.toString().contains("."));

    }

}
