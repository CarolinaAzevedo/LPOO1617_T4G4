import java.util.Scanner;

public class Level1 extends Level {



	public void displayLevel1(){



		for(int j=0; j < getMapa().getMap().length; j++){

			for(int i = 0; i < getMapa().getMap()[j].length; i++){
				System.out.print(getMapa().getMap()[j][i]);
				System.out.print(' ');
			}
			System.out.println(' ');

		}

	}

	public void displayAfterKey(){
		for(int j=0; j < getMapa().getMap().length; j++){
			for(int i = 0; i < getMapa().getMap()[j].length; i++){
				if( getMapa().getMap()[j][i] == 'I'){
					getMapa().getMap()[j][i] = 'S';}
					System.out.print(getMapa().getMap()[j][i]);
					System.out.print(' ');
				}
			System.out.println(' ');
			}
		

		}
	
	public boolean canMove(int y, int x){
		if (getMapa().getSymbol(x, y)== 'X'  || getMapa().getSymbol(x, y)== 'I' ){
			return false;
		}
		else{
			return true;
		}

	}
	
	public boolean isKey(int y, int x){
		return (getMapa().getSymbol(x, y)==getKey().getSymbol());
	}
	
	public boolean isGuard(){
		int x = getHero().getX();
		int y = getHero().getY();
		char symbol  = getGuard().getSymbol();
		
		
		if(getMapa().getSymbol(y-1,x)==symbol||
				getMapa().getSymbol(y+1,x)==symbol||
				getMapa().getSymbol(y, x-1)==symbol||
				getMapa().getSymbol(y, x+1)==symbol||
				getMapa().getSymbol(y,x)==symbol)
		{

			return true;
		}
		else{
			return false;
		}
	}
	public boolean isDoor(int x, int y){
		if(getMapa().getSymbol(y, x)=='S'){
			return true;
		}
		else{
			return false;
		}
	}
	
	public int ChangeMap(int dx, int dy, int i) {
		int y = getHero().getY();  // debug from this point forward
		int x = getHero().getX();
		int ty = y + dy;
		int tx = x + dx;
		int yg= getGuard().getY();
		int xg= getGuard().getX();
		int tyg=getGuard().getCord(i, 1);
		int txg=getGuard().getCord(i, 0);
		char symbol = getHero().getSymbol();
		char symbolGuard = getGuard().getSymbol();
		
		if (canMove(tx, ty)) {
			if (isKey(tx, ty)) {
				getMapa().setMap(x, y, ' ');
				getHero().setY(ty);
				getHero().setX(tx);
				getMapa().setMap(tx, ty, symbol);
				getMapa().setMap(xg, yg, ' ');
				getGuard().setX(txg);
				getGuard().setY(tyg);
				getMapa().setMap(txg, tyg, symbolGuard);
				
				displayAfterKey();
				System.out.println("Parabéns! Apanhou a chave! ");
				if (isGuard()) {
					System.out.println("Perdeu! ");
					return 1;
				} else return 0;
			}
			
			if (isDoor(tx, ty)) {
				getMapa().setMap(x, y, ' ');
				getHero().setY(ty);
				getHero().setX(tx);
				getMapa().setMap(tx, ty, symbol);
				getMapa().setMap(xg, yg, ' ');
				getGuard().setX(txg);
				getGuard().setY(tyg);
				getMapa().setMap(txg, tyg, symbolGuard);
				displayLevel1();
				System.out.println("Parabéns! Passou ao próximo nível ");
				return 2;
			} else {
				getMapa().setMap(x, y, ' ');
				getHero().setY(ty);
				getHero().setX(tx);
				getMapa().setMap(tx, ty, symbol);
				
				getMapa().setMap(xg, yg, ' ');
				getGuard().setX(txg);
				getGuard().setY(tyg);
				getMapa().setMap(txg, tyg, symbolGuard);
				displayLevel1();
				if(isGuard()){
					System.out.println("Perdeu! ");
					return 1;}
				else{
					return 0;
				}
			}
		} else {
			System.out.println("Movimento inválido! ");
			return 0;
		}		
	}
	
	public int ChangeMapW(int i) { return ChangeMap(0, -1, i); }
	public int ChangeMapS(int i) { return ChangeMap(0, +1, i); }
	public int ChangeMapA(int i) { return ChangeMap(-1, 0, i); }
	public int ChangeMapD(int i) { return ChangeMap(+1, 0, i); }


	public void Move(){
		int a =0;
		int i=1;
		
		while(a ==0){
			
			if(i ==24){
				i=0;
			}
			
			Scanner user_input = new Scanner(System.in); 
			System.out.print("Choose the direction of the character: ");

			char tecla = user_input.next().charAt(0);


			switch(tecla){
			case 'W':
				a = ChangeMapW(i);
				break;
				
			case 'S':
				a = ChangeMapS(i);
				break;
				
			case 'A':
				a = ChangeMapA(i);
				break;
			case 'D':
				a = ChangeMapD(i);
				break;
			}
			i++;
			
		}
		if (a==2){
//			Level2 nivel2= new Level2();
//			nivel2.CreateMapLevel(2);
//			nivel2.Move();
		}
	}
}
