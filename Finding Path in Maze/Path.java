/**
 * Class MazePath represents a path through a maze 
 * composed of a doubly-linked list of MazeSteps (positions)
 * 
 * @author Raquel M. Crespo-Garcia <rcrespo@it.uc3m.es>
 */
public class Path {

    /** First position in the path */    
    private PathStep first;
    
    /** Last position in the path */    
    private PathStep last;
    
    /**
     * Initializes empty path
     */
    public Path() {
        this.first = null;
        this.last = null;
    }
    
    /**
     * Insert the given coordinates as a new step in the first position of the path
     */
    public void insertFirst(int row, int col) {
        // TO DO (Part 3)
        // Learning concepts:
        // Insert first element in doubly linked list
    }
    
    /**
     * Insert the given coordinates as a new step in the last position of the path
     */
    public void insertLast(int row, int col) {
        PathStep pathStep = new PathStep(row, col);
        if (this.last == null) {
            this.first = pathStep;
            this.last = pathStep;
        }
        else {
            this.last.setNext(pathStep);
            pathStep.setPrev(this.last);
            this.last = pathStep;
        }
    }
    
    /**
     * Returns the coordinates of the first step in the path and removes it from the path. 
     * If the Path is empty, returns null.
     */
    public int[] extractFirst() {
        int[] coords = null;
        if (first != null) {
            coords = new int[2];
            coords[0] = first.getRow();
            coords[1] = first.getCol();
            if (first.getNext() != null) {
                first.getNext().setPrev(null);
            }
            first = first.getNext();
        }
        return coords;    // TO DO: modify as appropriate
    }
    
    /**
     * Returns the coordinates of the last step in the path and removes it from the path. 
     * If the Path is empty, returns null.
     */
    public int[] extractLast() {

        // TO DO (Part 3)
        // Learning concepts:
        // Extract last element of doubly linked list

        return null;    // TO DO: modify as appropriate
    }
    
    /**
     * Returns a String based representation of the Path.
     * If the Path is empty, returns an empty String ("")
     * If the Path is not empty, returns an String with the format:
     * (row1, col1), (row2, col2), ..., (rowN, colN)
     */
    public String toString() {
        
        String sPath = "";
        PathStep s = first;
        while (s != null) {
            sPath += "(" + s.getRow() + ", " + s.getCol() + ")";
            s = s.getNext();
        }
        
        return sPath;
    }
    

}
