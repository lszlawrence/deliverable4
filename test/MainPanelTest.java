/**
 * Created by lszlawrence on 2016/11/10.
 */
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;

public class MainPanelTest {
    MainPanel panel;
    private Cell[][] cells;

    @Before
    public void start(){
        panel = new MainPanel(15);
        cells = new Cell[15][15];
    }

    //test delection  of ConvertToInt()
    //all cells die,test num neihbors of 13,2
    @Test
    public void getNumNeihbors() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method getNumNeighbors = MainPanel.class.getDeclaredMethod("getNumNeighbors", int.class, int.class);
        getNumNeighbors.setAccessible(true);
        int testOut = (int)getNumNeighbors.invoke(panel,12,1);
        assertEquals(0,testOut);
    }


    //all cells around 1,1 alive,test num neihbors of 1,1
    @Test
    public void getNumNeibors2()throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        for(int i=0; i<15; i++) {
            for(int j=0; j<15; j++) {
                cells[i][j] = new Cell();
                if(i<3 && j<3) {
                    cells[i][j].setAlive(true);
                } else {
                    cells[i][j].setAlive(false);
                }
            }
        }
        panel.setCells(cells);
        Method getNumNeighbors = MainPanel.class.getDeclaredMethod("getNumNeighbors", int.class, int.class);
        getNumNeighbors.setAccessible(true);
        int testOut = (int)getNumNeighbors.invoke(panel,1,1);
        assertEquals(8,testOut);
    }

    //all cells die except 2,10, test nums of position 2,10
    @Test
    public void getNumNeibors3throws() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        for(int i=0; i<15; i++) {
            for(int j=0; j<15; j++) {
                cells[i][j] = new Cell();
                if(i<3 && j<11) {
                    cells[i][j].setAlive(true);
                } else {
                    cells[i][j].setAlive(false);
                }
            }
        }
        panel.setCells(cells);
        Method getNumNeighbors = MainPanel.class.getDeclaredMethod("getNumNeighbors", int.class, int.class);
        getNumNeighbors.setAccessible(true);
        int testOut = (int)getNumNeighbors.invoke(panel,1,9);
        assertEquals(8,testOut);
    }
}
