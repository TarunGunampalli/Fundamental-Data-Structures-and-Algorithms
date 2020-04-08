import java.util.Vector;

/**
 * Class Maze represents a bidimensional maze 
 * to traverse and find a path through
 * @author Raquel M. Crespo-Garcia <rcrespo@it.uc3m.es>
 */
public class Maze {

	private MazeStatus[][] maze;
	
	/**
     * Creates an square Maze of given size
     */
	public Maze(int size) {
		this(size, size);
	}
	
    /**
     * Creates a bidimensional Maze of given height and size,
     * with all positions initially open
     */
	public Maze(int width, int height) {
    	maze = new MazeStatus[width][height];
    	for (int i = 0; i < width; i++) {
    	    for (int j = 0; j < height; j++) {
        	    maze[i][j] = MazeStatus.OPEN;
    	    }
    	}
	}

    /**
     * Initializes a Maze from the given textual representation
     */
	public Maze(String sMaze) {
		this.maze = stringToMaze(sMaze);
	}

	
    /**
     * Returns the MazeStatus value corresponding to the given cell, 
     * specified by its row and column
     */
	public MazeStatus getPosStatus(int row, int col) {
		return maze[row][col]; // TO DO: change appropriately
	}
	
    /**
     * Sets the cell corresponding to the specified row and column to 
     * the given status value
     */
	public void setPosStatus(int row, int col, MazeStatus newStatus) {
		maze[row][col] = newStatus;
	}
	
    /**
     * Creates and returns an String with 
     * the text-based representation of the given Maze
     */
	public String toString() {
		String s = null;

		for (int i = 0; i < maze.length; i++) {
		    for (int j = 0; j < maze[i].length; j++) {
		        if (s == null) {
		            s = String.valueOf(maze[i][j].text());
		            continue;
		        }
		        s += maze[i][j].text();
		    }
		    s += "\n";
		}

		return s;
	}

    /**
     * Transforms a text-based Maze into a bidimensional array 
     * of positions with the corresponding status.
     * It creates the array maze and assign to each of its cells
     * the corresponding status value based on the given text representation.
     */
	private MazeStatus[][] stringToMaze(String sMaze) {
		String[] rows = sMaze.split("\n");
		int height = rows.length;
		int width = rows[0].length();
		maze = new MazeStatus[height][width];
		for (int j = 0; j < height; j++) {
		    char[] chars = rows[j].toCharArray();
		    for (int i = 0; i < width; i++) {
		        if (chars[i] == MazeStatus.OPEN.text()) {
		            maze[j][i] = MazeStatus.OPEN;
		        }
		        if (chars[i] == MazeStatus.GOAL.text()) {
		            maze[j][i] = MazeStatus.GOAL;
		        }
		        if (chars[i] == MazeStatus.VISITED.text()) {
		            maze[j][i] = MazeStatus.VISITED;
		        }
		        if (chars[i] == MazeStatus.OBSTACLE.text()) {
		            maze[j][i] = MazeStatus.OBSTACLE;
		        }
		    }
		        
		}
		return maze;
	}
	

    /**
     * Calculates the destination position in the Maze
     * given an starting position (row, col) and  a Movement (mov)
     * 
     * @returns the coordinates of the next position, if its is a valid position. 
     * Returns null if the destination position is outside the limits of the array.
     */
	public int[] getNeighbourCoords(int row, int col, Movement mov) {
		int[] neighbourCoords = new int[2];
        neighbourCoords[0] = row + mov.vShift();
        neighbourCoords[1] = col + mov.hShift();
		return neighbourCoords; // TO DO: change appropriately
	}
	

    /**
     * Changes the state of the maze positions following the given path.
     * If the initial status of the position to visit is OPEN or VISITED 
     * (can step into the position), change it to VISITED.
     * If the initial status of the position to visit is GOAL, does not 
     * change it so that the goal keeps displaying in the maze. 
     * If the initial status of the position to visit is OBSTACLE or 
     * the position is outside the limits of the Maze, it is an invalid move,
     * stop and finish. 
     * Empties the received path as it traverses it.
     * 
     */
    public void followPath(Path path) {
        
        int[] coords = path.extractFirst();
        while (coords != null) {
            switch (this.getPosStatus(coords[0], coords[1])) {
                case OPEN:
                case VISITED:
                    setPosStatus(coords[0], coords[1], MazeStatus.VISITED);
                    coords = path.extractFirst();
                    break;
                case OBSTACLE:
                    return;
                case GOAL:
                    coords = path.extractFirst();
                    break;
            }
        }
		

    }

}
