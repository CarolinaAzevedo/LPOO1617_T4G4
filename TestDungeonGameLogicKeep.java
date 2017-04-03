import static org.junit.Assert.*;
import org.junit.Test;


//Hero moves into an adjacent position to the Ogre and the game ends with defeat. check
//Hero moves into the Keep's exit door key cell and changes its representation to "K". check
//Hero moves into the closed Keep's exit door, without the key, and fails to open it. check
//Hero moves into the closed Keep's exit door, with the key, and the door opens. check
//Hero moves into the open Keep's exit door and the game ends with victory. merda

public class TestDungeonGameLogicKeep  {	
	// probablidade entre a média e dois desvios padrões ao lado
	private static final double prob2sigma = 0.477250; 	
	private static final double precision  = 5E-7;
	
	Level2 nivel2= new Level2();

	@Test
	public void testMoveHeroToAdjacentPositionOgre() {
		nivel2.CreateMapLevel(2);
		nivel2.anyOgre();
		nivel2.getHero2().setX(4);
		nivel2.getHero2().setY(4);
		
		nivel2.getOgres().get(0).setX(4);
		nivel2.getOgres().get(0).setY(3);
		
		assertEquals(4, nivel2.getHero2().getX());
		assertEquals(4, nivel2.getHero2().getY());
		assertEquals(4, nivel2.getOgres().get(0).getX());
		assertEquals(3, nivel2.getOgres().get(0).getY());
		nivel2.displayLevel2();
		assertEquals(1, nivel2.ChangeMap(0, 0, 1, 1));

	}
	
	@Test
	public void testMoveHeroToKeyCellAndChangeToK(){
		nivel2.CreateMapLevel(2);
		nivel2.getHero2().setX(6);
		nivel2.getHero2().setY(1);
		assertEquals(6,nivel2.getHero2().getX());
		assertEquals(1, nivel2.getHero2().getY());
		nivel2.ChangeMap(1, 0, 1, 1);
		assertEquals('K', nivel2.getHero2().getSymbol());
	}
	
	
	@Test
	public void testMoveHeroToCloseDoorAndFail(){
		nivel2.CreateMapLevel(2);
		nivel2.getHero2().setX(6);
		nivel2.getHero2().setX(1);
		nivel2.getHero2().setY(1);
		nivel2.ChangeMap(-1, 0, 1, 1);
		assertEquals(1,nivel2.getHero2().getX());
		assertEquals(1, nivel2.getHero2().getY());		
	}
	
	@Test
	public void testMoveHeroIntoTheLeverCellExitDoorsOpen() {
		nivel2.CreateMapLevel(2);
		nivel2.getHero2().setX(7);
		nivel2.getHero2().setY(2);
		
		assertEquals(7, nivel2.getHero2().getX());
		assertEquals(2, nivel2.getHero2().getY());
		
		System.out.println("key: " + nivel2.getKey2().getX() + nivel2.getKey2().getY());
		
		assertEquals('I', nivel2.getMapa().getCoord2(1, 0));
		
		nivel2.ChangeMap(0, -1, 1,1);
		assertTrue(nivel2.getKey().getHaveKey());
		
		nivel2.getHero2().setX(1);
		nivel2.getHero2().setY(1);
		
		nivel2.ChangeMap(-1, 0, 1, 1);
		
		
		assertEquals('S', nivel2.getMapa().getCoord2(1, 0));
		
	}
	
	@Test
	public void testMoveHeroIntoDoorOpenWins() {
		nivel2.CreateMapLevel(2);
		nivel2.getHero2().setX(7);
		nivel2.getHero2().setY(2);
		
		assertEquals(7, nivel2.getHero2().getX());
		assertEquals(2, nivel2.getHero2().getY());
		
		System.out.println("key: " + nivel2.getKey2().getX() + nivel2.getKey2().getY());
		
		assertEquals('I', nivel2.getMapa().getCoord2(1, 0));
		
		nivel2.ChangeMap(0, -1, 1,1);
		assertTrue(nivel2.getKey().getHaveKey());
		
		nivel2.getHero2().setX(1);
		nivel2.getHero2().setY(1);
		
		nivel2.ChangeMap(-1, 0, 1, 1); //Segundo a tua logica tens de andar uma vez no sentido da porta por alguma razao
		
		
		assertEquals(1, nivel2.ChangeMap(-1, 0, 1, 1));
		
		
	}
}
