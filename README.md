# SlowLifeGUI
# Deliverable 4

1. Profiling (before)

![alt text](https://github.com/lszlawrence/deliverable4/blob/master/before3.png)
![alt text](https://github.com/lszlawrence/deliverable4/blob/master/before1.png)
![alt text](https://github.com/lszlawrence/deliverable4/blob/master/before2.png)

From the pic I decided to refactor MainPanel.getNumNeibors(), MainPanel.runContinuous(), Cell.tostring()

2.Refactor
a. MainPanel.getNumNeibors()
```java
private int getNumNeighbors(int x, int y) {
	int size = _size;
	int leftX = (x - 1) % size;
	int rightX = (x + 1) % size;
	int upY = (y - 1) % size;
	int downY = (y + 1) % size;

	if (leftX == -1) { leftX = size - 1; }
	if (rightX == -1) { rightX = size - 1; }
	if (upY == -1) { upY = size - 1; }
	if (downY == -1) { downY = size - 1; }
		
	int numNeighbors = 0;

	if (_cells[leftX][upY].getAlive())    { numNeighbors++; }
	if (_cells[leftX][downY].getAlive())  { numNeighbors++; }
	if (_cells[leftX][y].getAlive())      { numNeighbors++; }
	if (_cells[rightX][upY].getAlive())   { numNeighbors++; }
	if (_cells[rightX][downY].getAlive()) { numNeighbors++; }
	if (_cells[rightX][y].getAlive())     { numNeighbors++; }
	if (_cells[x][upY].getAlive())        { numNeighbors++; }
	if (_cells[x][downY].getAlive())      { numNeighbors++; }
	    
	return numNeighbors;
    }
```
b.MainPanel.runContinuous()
```java
 public void runContinuous() {
	_running = true;
	while (_running) {
	    System.out.println("Running...");
	    int origR = _r;
	    try {
		Thread.sleep(20);
	    } catch (InterruptedException iex) { }
	   // for (int j=0; j < _maxCount; j++) {
	    //	_r += (j % _size) % _maxCount;
	//	_r += _maxCount;
	  //  }
	    _r = origR;
	    backup();
	    calculateNextIteration();
	}
    }
```
c.Cell.toString()
```java
public String toString() {
	String toReturn = getText();
	//String currentState = getText();
	//for (int j = 0; j < _maxSize; j++) {
	  //  toReturn += currentState;
	//}
	if (toReturn.substring(0,1).equals("X")) {
	    return toReturn.substring(0,1);
	} else {
	    return ".";
	}

    }
```
3.Pinning test

a.MainPanel.getNumNeibors() [click here](https://github.com/lszlawrence/deliverable4/blob/master/test/MainPanelTest.java)

b. Cell.toString() [click here](https://github.com/lszlawrence/deliverable4/blob/master/test/CellTest.java)

c.MainPanel.runContinuous() 

Manual Test must be used here because runContinuous do not have return value.


IDENTIFIER: runContinuousTest

TEST CASE: crossline flashing

PRECONDITIONS: Start program, (3,3)(4,3) alive, (3,2)(3,3)(3,4)dead 

INPUT VALUES: 5

EXECUTION STEPS: Click "Run Continuous"

OUTPUT VALUES:n/a

POSTCONDITIONS: Cross line flashing until click "Stop"




IDENTIFIER: runContinuousTest

TEST CASE: parallel line flashing

PRECONDITIONS: Start program, (3,3)(3,4)(3,5)(4,2)(4,3)(4,4)dead

INPUT VALUES: 6

EXECUTION STEPS: Click "Run Continuous"

OUTPUT VALUES:n/a

POSTCONDITIONS: parallel line flashing until click "Stop"



IDENTIFIER: runContinuousTest

TEST CASE: square

PRECONDITIONS: Start program, make a 6 X 6 square dead

INPUT VALUES: 15

EXECUTION STEPS: 
1.Click "Write"

2.Click "run" until the shape not change

3.clear

4.Click "Load"

5.Click "Run Continuous"

6.When the shape not change, click "stop"

OUTPUT VALUES:n/a

POSTCONDITIONS: Step 6 and Step 2 shall have same shape.


4.Profile(after)

![alt text](https://github.com/lszlawrence/deliverable4/blob/master/after3.png)

![alt text](https://github.com/lszlawrence/deliverable4/blob/master/after1.png)

![alt text](https://github.com/lszlawrence/deliverable4/blob/master/after2.png)


