
public class Key extends Character{
	boolean HaveKey;
	public Key(int x, int y, char symbol) {

		super(x,y, symbol);
		this.HaveKey=false;
	}
	
	public Key() {

		super(7,8, 'k');
	}
	 
	public Key(int i){
		super(7,1, 'k');
	}
	
	public void setKey(boolean key){
		this.HaveKey=key;
	}
	public boolean getHaveKey(){
		return HaveKey;
	}
}
