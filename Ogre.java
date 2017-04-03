
public class Ogre extends Character {
	
	public Club club;
	
	public Ogre(int x, int y, char symbol) {
		super(x,y, symbol);
		this.club = new Club(x,y-1,'*');
	}

	
	
}