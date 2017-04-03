public class Character extends Map{
	protected int x;
	protected int y;	
	protected char symbol;
	
	public Character(int x, int y, char symbol){
		this.x = x;
		this.y = y;
		this.symbol = symbol;
	}

	public Character(){
		this.x = 0;
		this.y = 0;
		
	}

	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}
	

	public char getSymbol() {
		return symbol;
	}


	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}

}