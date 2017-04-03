
public class Map {



	private char initialmap [][] = {
			{'X','X','X','X','X','X','X','X','X','X'},
			{'X',' ',' ',' ',' ',' ','X',' ',' ','X'},
			{'X','X','X',' ','X','X','X',' ',' ','X'},
			{'X',' ',' ',' ',' ',' ','X',' ',' ','X'},
			{'X','X','X',' ','X','X','X',' ',' ','X'},
			{' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X','X','X',' ','X','X','X','X',' ','X'},
			{'X',' ',' ',' ',' ',' ','X',' ',' ','X'},
			{'X','X','X','X','X','X','X','X','X','X'}};

	private char initialmap2 [][] = {
			{'X','X','X','X','X','X','X','X','X'},
			{' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X','X','X','X','X','X','X','X','X'}};




	//guarda o simbolo das coisas que nao sao classes 
	public char getSymbol(int y, int x){
		return initialmap[y][x];
	}

	public void setMap(int x, int y, char symbol){
		initialmap[y][x]=symbol;
	}

	public char[][] getMap(){
		return initialmap;
	}

	public char getCoord(int y, int x){

		return initialmap[y][x];

	}

	public char getCoord2(int y, int x){

		return initialmap2[y][x];

	} 

	public char getSymbol2 (int y, int x){
		return initialmap2[y][x];
	}
	public void setMap2(int x, int y, char symbol){
		initialmap2[y][x]=symbol;
	}
	public char[][] getMap2(){
		return initialmap2;
	}

}
