import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Level  {

	private Guard guard;
	private Hero hero;
	private Key key;
	private Map map;
	private Hero hero2;
	private Key key2;
	private Club heroclub;
	private Guard Rookie;
	private Guard Drunken;
	private Guard Suspicious;
	private Random randomGenerator;
	private ArrayList<Ogre> ogres;
	

	Level(){
	this.guard=new Guard(1,8,'G');
	this.hero=new Hero();
	this.key=new Key();
	this.map=new Map();
	this.hero2=new Hero(2);
	this.key2=new Key(2);
	this.heroclub= new Club();
	this.Drunken=new Guard(6,1,'D');
	this.Rookie=new Guard(6,1,'R');
	this.Suspicious=new Guard(6,1,'U');
	this.ogres = anyOgre();
	
	
}

	public Map getMapa(){
	return map;
	}

	public Hero getHero(){
		return hero;
	}

	public Hero getHero2(){
		return hero2;
	}
	
	public Guard getGuard(){
		return guard;
	}
	public Guard getRookie(){
		return Rookie;
	}
	public Guard getSuspicious(){
		return Suspicious;
	}
	
	public Guard getDrunken(){
		return Drunken;
	}

	public Key getKey(){
		return key;
	}
	
	public Key getKey2(){
		return key2;
	}
	
	

	
	public ArrayList<Ogre> getOgres(){
		return ogres;
	}
	public void setOgres(ArrayList<Ogre> ogres){
		this.ogres=ogres;
	}
	
	public ArrayList<Ogre> anyOgre()
	{
		ogres = new ArrayList<Ogre>();
		randomGenerator = new Random();
		
		
//		int Low = 1;
//		int High = 7;
		int numOgres = randomGenerator.nextInt(5) + 1;
		for(int i = 0; i < numOgres; i++){
			int x=OgreX();
			int y=OgreY();
			ogres.add(new Ogre(x,y,'O'));
		} 
		return ogres;
	}
	
	
	public Club getClub(Ogre og){
		return og.club;
	}
	public Club getHeroClub(){
		return heroclub;
	}
	public void CreateMapLevel(int i){
		
	
	if(i == 1){
		
		int hx = getHero().getX();
		int hy = getHero().getY();
		char hs = getHero().getSymbol();
		int gx = getGuard().getX();
		int gy = getGuard().getY();
		char gs = getGuard().getSymbol();
		int kx = getKey().getX();
		int ky = getKey().getY();
		char ks = getKey().getSymbol();
		
		getMapa().setMap(hx, hy, hs);
		getMapa().setMap(gx,gy, gs);
		getMapa().setMap( kx,ky, ks);
		getMapa().setMap(4, 1, 'I');
		getMapa().setMap(4, 3, 'I');
		getMapa().setMap(2, 3, 'I');
		getMapa().setMap(0, 5, 'I');
		getMapa().setMap(0, 6, 'I');
		getMapa().setMap(2, 8, 'I');
		getMapa().setMap(4, 8, 'I');
	}
	else{
		getMapa().setMap2(getHero2().getX(),getHero2().getY(), getHero2().getSymbol());
		getMapa().setMap2( getKey2().getX(),getKey2().getY(), getKey2().getSymbol() );
		getMapa().setMap2( getHeroClub().getX(),getHeroClub().getY(), getHeroClub().getSymbol() );
			
		
		getMapa().setMap2(0, 1, 'I');
	}
	}

public int OgreX(){
	Random ran = new Random();
	int Low = 1;
	int High = 8;
	int r = ran.nextInt(High-Low) + Low;
	return r;
}
public int OgreY(){
	Random ran = new Random();
	int Low = 3;
	int High = 6;
	int r = ran.nextInt(High-Low) + Low;
	return r;
}	
	
}
