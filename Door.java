
public class Door extends Character {

	private boolean isOpen = false;
	
	public void OpenDoor(){
		this.isOpen = true;
	}
	
	public String toString(){
		String s = "S";
		String i = "I";
		if(isOpen) 
			return s;
		else 
			return i;
	}
}
