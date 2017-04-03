public class Guard extends Character {

	private int SuspiciousSpot;
	private int DrunkenSpot;
	
	private int trajecto [][] = {
			{8,1},{7,1},{7,2},{7,3},{7,4},{7,5},{6,5},{5,5},{4,5},{3,5},{2,5},{1,5},{1,6},
			{2,6},{3,6},{4,6},{5,6},{6,6},{7,6},{8,6},{8,5},{8,4},{8,3},{8,2}
	};
	private int trajecto2[][]=
	{{6,1},{5,1},{5,2},{5,3},{5,4},{5,5},{4,5},{3,5},{2,5},{1,5},{1,6},
	{2,6},{3,6},{4,6},{5,6},{6,6},{6,5},{6,4},{6,3},{6,2}};
	
	public Guard(int x, int y, char symbol) {
		super(x,y, symbol);
		this.DrunkenSpot=0;
		this.SuspiciousSpot=0;
	}
	
	public int[][] getTrajecto(){
		return trajecto;
	}
	public int[][] getTrajecto2(){
		return trajecto2;
	}
	public int getCord(int y, int x){
		return trajecto[y][x];
		
	}
	public int getCord2(int y, int x){
		return trajecto2[y][x];
		
	}
	public int getDrunkenSpot(){
		return DrunkenSpot;
	}
	public int getSuspiciousSpot(){
		return SuspiciousSpot;
	}
	public void setDrunkenSpot(int i){
		this.DrunkenSpot=i;
	}
	public void setSuspiciousSpot(int i){
		this.SuspiciousSpot=i;
	}
}