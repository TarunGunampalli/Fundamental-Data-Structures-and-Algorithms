import java.util.Stack;

/**
 * Class StackPathFinder implements an algorithm for finding a path using a Stack
 * @author Raquel M. Crespo-Garcia <rcrespo@it.uc3m.es>
 *
 */
public class StackPathFinder implements PathFinder {

    /*
     * ** IMPORTANT: 
     * The exploration order determines the path found
     * even forcing to traverse every cell in the maze. 
     * The algorithm takes profit of knowing the start position to be top-left
     * and the goal towards bottom-right.
     * Notice that using a Stack means retrieving elements in reverse order.
     * Thus, most promising directions are inserted last in the Stack 
     * in order to get them explored first.
     */
    private static final Movement[] DIRS_TO_EXPLORE = new Movement[] {
        	Movement.LEFT, 
        	Movement.UP, 
        	Movement.DOWN,
        	Movement.RIGHT
    };

	public Path findPath(Maze maze) {

        /*
         * // TO DO
         * 
         * Create empty Stack to store maze positions for future visit.
         * You can use the java.util.Stack class 
         * or the Deque interface and one of its implementations (e.g. ArrayDeque) 
         * in the Java API for convenience.
         * 
         * Start at position (0, 0)
         *
         * While there is any position yet to be explored in the Stack :
         *      * check the status of the position
         *      * if GOAL: objective found, finish
         *      * if VISITED: already explored => nothing to do, continue to next position to explore
         *      * if OBSTACLE: must be an error => return null
         *      * if OPEN:
         *          * change position status to VISITED
         *          * get adjacent positions to explore in the future; 
         *            insert into Stack only the ones to be explored (i.e. OPEN or GOAL, ignore VISIED or OBSTACLE)
         *            Notice that the exploration order determines the path found; 
         *            you are suggested to get neighbours in the order defined in DIRS_TO_EXPLORE
         *
         */
        MazePosition start = new MazePosition(0, 0);
        
        Stack<MazePosition> toExplore = new Stack<MazePosition>();
        toExplore.push(start);
        
        MazePosition current = start;
        MazePosition next;
        
        while (!toExplore.isEmpty()) {
            current = toExplore.pop();
            
            switch (maze.getPosStatus(current)) {
                case OPEN:
                    maze.setPosStatus(current, MazeStatus.VISITED);
                    
                    for (Movement mov : DIRS_TO_EXPLORE) {
                        next = maze.getNeighbour(current, mov);
                        if (next != null) {
                            if (maze.getPosStatus(next) == MazeStatus.OPEN || maze.getPosStatus(next) == MazeStatus.GOAL) {
                                toExplore.push(next);
                            }
                        }
                    }
                    break;
                case VISITED:
                    break;
                case OBSTACLE:
                    return null;
                case GOAL:
                    Path path = new Path();
                    MazePosition pathStep = current;
                    
                    while (pathStep != null) {
                        path.insertFirst(pathStep.getCoords()[0], pathStep.getCoords()[1]);
                        pathStep = pathStep.getFrom();
                    }
                    return path;
            }
        }

		return null;  // TO DO: modify appropriately

	}

}
