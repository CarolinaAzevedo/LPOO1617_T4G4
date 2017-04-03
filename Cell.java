import java.util.ArrayList;

public class Cell extends Character {
	
	private char map [][];

	public Cell(int x, int y, char symbol){
	
	super(x,y,symbol);
	this.map=getMap2();
	
	}
	
	
}
