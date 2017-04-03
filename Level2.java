import java.util.*;


public class Level2 extends Level{
	private int numGuard=0;
	private int timesStuned=0;

	public int getnumGuard(){
		return numGuard;
	}
	public void setnumGuard(int a){
		this.numGuard=a;
	}
	public int gettimesStuned(){
		return timesStuned;
	}
	public void settimesStuned(int a){
		this.timesStuned=a;
	}
	public void displayLevel2(){


		for(int j=0; j < getMapa().getMap2().length; j++){

			for(int i = 0; i < getMapa().getMap2()[j].length; i++){
				System.out.print(getMapa().getMap2()[j][i]);
				System.out.print(' ');
			}
			System.out.println(' ');

		}

	}

	public boolean isOgre(Ogre og){
		int x = getHero2().getX();
		int y = getHero2().getY();
		char symbol  = og.getSymbol();


		if(getMapa().getSymbol2(y-1,x)==symbol||
				getMapa().getSymbol2(y+1,x)==symbol||
				getMapa().getSymbol2(y, x-1)==symbol||
				getMapa().getSymbol2(y, x+1)==symbol||
				getMapa().getSymbol2(y,x)==symbol)
		{

			return true;
		}
		else{
			return false;
		}
	}

	public boolean isGuard(){
		int x = getHero2().getX();
		int y = getHero2().getY();
		char symbolR  = getRookie().getSymbol();
		char symbolD  = getDrunken().getSymbol();
		char symbolS  = getSuspicious().getSymbol();


		if(getMapa().getSymbol2(y-1,x)==symbolR||getMapa().getSymbol2(y-1,x)==symbolD||getMapa().getSymbol2(y-1,x)==symbolS||
				getMapa().getSymbol2(y+1,x)==symbolR||getMapa().getSymbol2(y+1,x)==symbolD||getMapa().getSymbol2(y+1,x)==symbolS||
				getMapa().getSymbol2(y, x-1)==symbolR||getMapa().getSymbol2(y, x-1)==symbolD||getMapa().getSymbol2(y, x-1)==symbolS||
				getMapa().getSymbol2(y, x+1)==symbolR||getMapa().getSymbol2(y, x+1)==symbolD||getMapa().getSymbol2(y, x+1)==symbolS||
				getMapa().getSymbol2(y,x)==symbolR||getMapa().getSymbol2(y,x)==symbolD||getMapa().getSymbol2(y,x)==symbolS)
		{

			return true;
		}
		else{
			return false;
		}
	}
	public boolean isClub(Ogre og){
		int x = getHero2().getX();
		int y = getHero2().getY();
		char symbol  = getClub(og).getSymbol();


		if(isBadClub(x,y+1)||isBadClub(x,y-1)||isBadClub(x+1,y)||isBadClub(x-1,y))
		{

			return true;
		}
		else{
			return false;
		}
	}

	public boolean canMove(int y, int x){
		if (getMapa().getSymbol2(x, y)== 'X' ){
			return false;
		}
		else{
			return true;
		}

	}
	public boolean canMoveOgre(int y, int x){
		if (getMapa().getSymbol2(x, y)== 'X'  || getMapa().getSymbol2(x, y)== 'I'|| getMapa().getSymbol2(x, y)== 'D'|| getMapa().getSymbol2(x, y)== 'U'|| getMapa().getSymbol2(x, y)== 'R' 
				|| getMapa().getSymbol2(x, y)== 'O'|| getMapa().getSymbol2(x, y)== '*'  	){
			return false;
		}
		else{
			return true;
		}

	}



	public boolean isKey(int y, int x){
		return (getMapa().getSymbol2(x, y)==getKey2().getSymbol());
	}


	public boolean isDoor(int x, int y){
		if(getMapa().getSymbol2(y, x)=='I'){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean isLever(int x, int y){
		if(getMapa().getSymbol2(y, x)=='S'){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean isBadClub(int x, int y){
		if(getMapa().getSymbol2(y, x)=='*' && x!=3 && y!=7d){
			return true;
		}
		else{
			return false;
		}
	}

	public boolean isHeroClub(int x, int y){
		if(x==3 && y==7){
			return true;
		}
		else{
			return false;
		}}
	public boolean getStuned(int x, int y){
		if(getMapa().getSymbol2(y, x)=='A'||getMapa().getSymbol2(y+1, x)=='A'||
				getMapa().getSymbol2(y, x+1)=='A'||getMapa().getSymbol2(y-1, x)=='A'||
				getMapa().getSymbol2(y, x-1)=='A'||getMapa().getSymbol2(y+1, x)=='K'||
				getMapa().getSymbol2(y, x-1)=='K'||getMapa().getSymbol2(y, x+1)=='K'||
				getMapa().getSymbol2(y-1, x)=='K'||getMapa().getSymbol2(y, x)=='K'){
			return true;
		}else{
			return false;
		}
	}
	public int ChangeMap(int dx, int dy, int i, int guard) {
		int y = getHero2().getY();  
		int x = getHero2().getX();
		int ty = y + dy;
		int tx = x + dx;
		char symbol = getHero2().getSymbol();

		if (canMove(tx, ty)) {

			if(isHeroClub(tx,ty)){
				getMapa().setMap2(x, y, ' ');
				getHero2().setY(ty);
				getHero2().setX(tx);
				getHero2().setSymbol('A');
				symbol=getHero2().getSymbol();
				getMapa().setMap2(tx, ty, symbol);
				whichGuard(guard, i);
				for ( int j = 0 ; j < getOgres().size() ; j++){

					while (OgreMove(getOgres().get(j))){
						OgreMove(getOgres().get(j));
					}
					while(ClubMove(getOgres().get(j))){
						ClubMove(getOgres().get(j));
					}
				}
				displayLevel2();

				System.out.println("Parabéns! Apanhou o bastão! ");

				for ( int j = 0 ; j < getOgres().size(); j++){
					if(isOgre(getOgres().get(j))||isClub(getOgres().get(j))||isGuard()) {
						System.out.println("Perdeu! ");
						return 1;}
				}

				return 0;

			}
			if (isKey(tx, ty)) {
				getMapa().setMap2(x, y, ' ');
				getHero2().setY(ty);
				getHero2().setX(tx);
				getHero2().setSymbol('K');
				symbol=getHero2().getSymbol();
				getMapa().setMap2(tx, ty, symbol);
				getKey().setKey(true);
				whichGuard(guard, i);
				for ( int j = 0 ; j < getOgres().size() ; j++){

					while (OgreMove(getOgres().get(j))){
						OgreMove(getOgres().get(j));
					}
					while(ClubMove(getOgres().get(j))){
						ClubMove(getOgres().get(j));
					}
				}
				displayLevel2();

				System.out.println("Parabéns! Apanhou a chave! ");

				for ( int j = 0 ; j < getOgres().size(); j++){
					if(isOgre(getOgres().get(j))||isClub(getOgres().get(j))||isGuard()) {
						System.out.println("Perdeu! ");
						return 1;}
				}

				return 0;

			}
			if (isDoor(tx, ty)) {
				if(getKey().getHaveKey()){
					getMapa().setMap2(tx, ty, 'S');
					whichGuard(guard, i);
					for ( int j = 0 ; j < getOgres().size() ; j++){

						while (OgreMove(getOgres().get(j))){
							OgreMove(getOgres().get(j));
						};
						while(ClubMove(getOgres().get(j))){
							ClubMove(getOgres().get(j));
						}
					}

					displayLevel2();}
				for ( int j = 0 ; j < getOgres().size(); j++){
					if(isOgre(getOgres().get(j))||isClub(getOgres().get(j))||isGuard()) {
						System.out.println("Perdeu! ");
						return 1;}
				}

				return 0;

			}				

			if (isLever(tx, ty)) {
				getMapa().setMap2(x, y, ' ');
				getHero2().setY(ty);
				getHero2().setX(tx);
				getMapa().setMap2(tx, ty, symbol);
				whichGuard(guard, i);
				for ( int j = 0 ; j < getOgres().size() ; j++){

					while (OgreMove(getOgres().get(j))){
						OgreMove(getOgres().get(j));
					}
					while(ClubMove(getOgres().get(j))){
						ClubMove(getOgres().get(j));
					}
				}

				displayLevel2();
				System.out.println("Parabéns! Ganhou o jogo! ");
				return 1;
			} else {
				getMapa().setMap2(x, y, ' ');
				getHero2().setY(ty);
				getHero2().setX(tx);
				getMapa().setMap2(tx, ty, symbol);
				whichGuard(guard, i);
				for ( int j = 0 ; j < getOgres().size() ; j++){

					while (OgreMove(getOgres().get(j))){
						OgreMove(getOgres().get(j));
					}
					while(ClubMove(getOgres().get(j))){
						ClubMove(getOgres().get(j));
					}
				}

				displayLevel2();			
				for (int j = 0 ; j < getOgres().size(); j++){
					if(isOgre(getOgres().get(j))||isClub(getOgres().get(j))||isGuard()) {
						System.out.println("Perdeu! ");
						return 1;}
				}

				return 0;
			}
		}
		else {
			System.out.println("Movimento inválido! ");
			return 0;
		}
	}

	public int ChangeMapW(int i, int a) { return ChangeMap(0, -1,i, a); }
	public int ChangeMapS(int i, int a) { return ChangeMap(0, +1, i, a); }
	public int ChangeMapA(int i, int a) { return ChangeMap(-1, 0, i, a); }
	public int ChangeMapD(int i, int a) { return ChangeMap(+1, 0, i, a); }

	public void Move(){
		int a =0;
		int i=1;
		setnumGuard(whatGuard());
		int guard=getnumGuard();
		initGuard(guard);
		initOgres();
		displayLevel2();
		while(a ==0){

			if(i ==20){
				i=0;
			}

			Scanner user_input = new Scanner(System.in); 
			System.out.print("Choose the direction of the character: ");

			char tecla = user_input.next().charAt(0);


			switch(tecla){
			case 'W':
				a = ChangeMapW(i, guard);
				break;

			case 'S':
				a = ChangeMapS(i, guard);
				break;

			case 'A':
				a = ChangeMapA(i, guard);
				break;
			case 'D':
				a = ChangeMapD(i, guard);
				break;
			}

			i++;
		}
	}

	public boolean OgreMove(Ogre og){

		Random ran = new Random();
		int Low = 1;
		int High = 5;
		int r = ran.nextInt(High-Low) + Low;


		int x=og.getX();
		int y= og.getY();
		int dx=0;
		int dy=0;
		char OgreSymbol=og.getSymbol();
		if(r==1){
			dy=1;
		}
		if(r==2){
			dy=-1;
		}
		if(r==3){
			dx=-1;
		}
		if(r==4){
			dx=1;
		}
		if(canMoveOgre(y+dy, x+dx)){
			if(getMapa().getSymbol2(y,x)=='8'){

				if(gettimesStuned()==1){
					settimesStuned(2);
					return false;
				}
				if(gettimesStuned()==2){
					settimesStuned(2);
					return false;
				}
				if(gettimesStuned()==3){
					getMapa().setMap2(x, y, ' ');
					og.setY(y+dy);
					og.setX(x+dx);
					getMapa().setMap2(x+dx, y+dy,OgreSymbol);
					return false;
				}
			}
			if(getMapa().getSymbol2(y+dy,x+dx)== getKey().getSymbol()){
				getMapa().setMap2(x, y, ' ');
				og.setY(y+dy);
				og.setX(x+dx);
				getMapa().setMap2(x+dx, y+dy,'$');
				return false;
			}
			if(x==7&&y==1){
				getMapa().setMap2(x, y, 'k');
				og.setY(y+dy);
				og.setX(x+dx);
				getMapa().setMap2(x+dx, y+dy,OgreSymbol);
				return false;
			}
			if(getStuned(x+dx,y+dy) ){
				getMapa().setMap2(x, y, ' ');
				og.setY(y+dy);
				og.setX(x+dx);
				getMapa().setMap2(x+dx, y+dy,'8');
				settimesStuned(1);
				return false;
			}
			else{
				getMapa().setMap2(x, y, ' ');
				og.setY(y+dy);
				og.setX(x+dx);
				getMapa().setMap2(x+dx, y+dy,OgreSymbol);
				return false;
			}
		}else{
			return true;

		}

	}

	public boolean ClubMove(Ogre og){
		int xc=getClub(og).getX();
		int yc=getClub(og).getY();
		int xg=og.getX();
		int yg=og.getY();
		char club= getClub(og).getSymbol();


		int dy=0;
		int dx=0;
		Random ran = new Random();
		int Low = 1;
		int High = 5;
		int r = ran.nextInt(High-Low) + Low;

		if(r==1){
			dy=1;
		}
		if(r==2){
			dy=-1;
		}
		if(r==3){
			dx=-1;
		}
		if(r==4){
			dx=1;
		}

		if(canMoveOgre(yg+dy, xg+dx)){
			if(getMapa().getSymbol2(yg+dy,xg+dx)== getKey().getSymbol()){
				getMapa().setMap2(xc, yc, ' ');
				getClub(og).setY(yg+dy);
				getClub(og).setX(xg+dx);
				getMapa().setMap2(xg+dx, yg+dy,'$');
				return false;
			}
			if(xc==7&&yc==1){
				getMapa().setMap2(xc, yc, 'k');
				getClub(og).setY(yg+dy);
				getClub(og).setX(xg+dx);
				getMapa().setMap2(xg+dx, yg+dy,club);
				return false;
			}
			else{
				getMapa().setMap2(xc, yc, ' ');
				getClub(og).setY(yg+dy);
				getClub(og).setX(xg+dx);
				getMapa().setMap2(xg+dx, yg+dy,club);
				return false;
			}

		}else{
			return true;

		}

	}

	public void DrunkenPatrol(){
		int i=getDrunken().getDrunkenSpot();
		int x= getDrunken().getX();
		int y=getDrunken().getY();
		char D=getDrunken().getSymbol();
		Random ran = new Random();
		int Low = 1;
		int High = 4;
		int r = ran.nextInt(High-Low) + Low;
		if(r==1){

			i++;
			if(i==20){
				i=0;
				getDrunken().setDrunkenSpot(0);}else
				{getSuspicious().setDrunkenSpot(i);}

			int tyg=getDrunken().getCord2(i, 1);
			int txg=getDrunken().getCord2(i, 0);
			getMapa().setMap2(x, y, ' ');
			getDrunken().setX(txg);
			getDrunken().setY(tyg);
			getMapa().setMap2(txg, tyg, D);
		}
		if(r==2){
			i--;
			if(i==-1){
				i=19;
				getDrunken().setDrunkenSpot(19);}else
				{getDrunken().setDrunkenSpot(i);}

			int tyg=getDrunken().getCord2(i, 1);
			int txg=getDrunken().getCord2(i, 0);
			getMapa().setMap2(x, y, ' ');
			getDrunken().setX(txg);
			getDrunken().setY(tyg);
			getMapa().setMap2(txg, tyg, D);
		}
		if(r==3){
			getMapa().setMap2(x, y, 'd');
		}


	}
	public void RookiePatrol(int i){
		int x=getRookie().getX();
		int y=getRookie().getY();
		int tyg=getRookie().getCord2(i, 1);
		int txg=getRookie().getCord2(i, 0);
		char R=getRookie().getSymbol();

		getMapa().setMap2(x, y, ' ');
		getRookie().setX(txg);
		getRookie().setY(tyg);
		getMapa().setMap2(txg, tyg, R);
	}
	public void SuspiciousPatrol(){
		int i = getSuspicious().getSuspiciousSpot();
		int x=getSuspicious().getX();
		int y=getSuspicious().getY();
		char U= getSuspicious().getSymbol();
		Random ran = new Random();
		int Low = 1;
		int High = 3;
		int r = ran.nextInt(High-Low) + Low;
		if(r==1){

			i++;
			if(i==20){
				i=0;
				getSuspicious().setSuspiciousSpot(0);}else
				{getSuspicious().setSuspiciousSpot(i);

				int tyg=getSuspicious().getCord2(i, 1);
				int txg=getSuspicious().getCord2(i, 0);
				getMapa().setMap2(x, y, ' ');
				getSuspicious().setX(txg);
				getSuspicious().setY(tyg);
				getMapa().setMap2(txg, tyg, U);
				}
			if(r==2){
				i--;
				if(i==-1){
					i=19;
					getSuspicious().setSuspiciousSpot(19);}else
					{getSuspicious().setSuspiciousSpot(i);

					int tyg=getSuspicious().getCord2(i, 1);
					int txg=getSuspicious().getCord2(i, 0);
					getMapa().setMap2(x, y, ' ');
					getSuspicious().setX(txg);
					getSuspicious().setY(tyg);
					getMapa().setMap2(txg, tyg, U);
					}

			}
		}
	}
	public int whatGuard(){
		Random ran = new Random();
		int Low = 1;
		int High = 4;
		int r = ran.nextInt(High-Low) + Low;
		return r;
	}
	public void whichGuard(int i,int it){
		if (i==1){
			DrunkenPatrol();}
		if(i==2){
			RookiePatrol(it);	
		}
		if(i==3){	
			SuspiciousPatrol();
		}

	}


	public void initGuard(int i){
		if (i==1){
			getMapa().setMap2( getDrunken().getX(),getDrunken().getY(), getDrunken().getSymbol() );
		}
		if(i==2){
			getMapa().setMap2( getRookie().getX(),getRookie().getY(), getRookie().getSymbol() );

		}
		if(i==3){	
			getMapa().setMap2( getSuspicious().getX(),getSuspicious().getY(), getSuspicious().getSymbol() );
		}
	}

	public void initOgres(){
		setOgres(anyOgre());
		ArrayList<Ogre> ogres=getOgres();
		for (int j = 0 ; j< ogres.size() ; j++){

			getMapa().setMap2( ogres.get(j).getX(), ogres.get(j).getY(), ogres.get(j).getSymbol());
			getMapa().setMap2(getClub(ogres.get(j)).getX(), getClub(ogres.get(j)).getY(), getClub(ogres.get(j)).getSymbol());
		}

	}
}

