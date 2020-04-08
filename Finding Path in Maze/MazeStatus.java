/**
 * Possible states for each position of a maze
 * 
 * @author Raquel M. Crespo-Garcia <rcrespo@it.uc3m.es>
 *
 */
public enum MazeStatus {
	
	OPEN(' '), OBSTACLE('#'), GOAL('x'), VISITED('.');
	
	private char text;
	
	MazeStatus(char s) {
		this.text = s;
	}
	
	public char text() {
		return this.text;
	}
	
}
