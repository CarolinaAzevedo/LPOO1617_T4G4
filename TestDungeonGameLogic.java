import static org.junit.Assert.*;
import org.junit.Test;


//Hero moves successfully into a free cell. check
//Hero tries to, unsuccessfully, move into a wall. check
//Hero moves into an adjacent position to the Guard and the game ends with defeat. check
//Hero moves towards the closed exit doors and fails to leave. check
//Hero moves into the lever cell and the Dungeon exit doors open. check
//Hero moves into the open Dungeon exit doors and progresses into the Keep. check

public class TestDungeonGameLogic  {	
	// probablidade entre a média e dois desvios padrões ao lado
	private static final double prob2sigma = 0.477250; 	
	private static final double precision  = 5E-7;
	
	Level1 nivel1= new Level1();

	@Test
	public void testMoveHero() {
		nivel1.CreateMapLevel(1);
		
		assertEquals(1, nivel1.getHero().getX());
		assertEquals(1, nivel1.getHero().getY());
		
		
		nivel1.ChangeMap(1, 0, 1);
		
		
		assertEquals(2, nivel1.getHero().getX());
		assertEquals(1, nivel1.getHero().getY());
		
		
		
	}
	
	@Test
	public void testMoveHeroToWall() {
		nivel1.CreateMapLevel(1);
		
		assertEquals(1, nivel1.getHero().getX());
		assertEquals(1, nivel1.getHero().getY());
		
		
		nivel1.ChangeMap(-1, 0, 1);
		
		
		assertEquals(1, nivel1.getHero().getX());
		assertEquals(1, nivel1.getHero().getY());
		
		
		
	}
	
	@Test
	public void testMoveHeroToAdjacentPositionGuard() {
		nivel1.CreateMapLevel(1);
		nivel1.getHero().setX(7);
		nivel1.getHero().setY(3);
		
		assertEquals(7, nivel1.getHero().getX());
		assertEquals(3, nivel1.getHero().getY());
		assertEquals(1, nivel1.ChangeMap(0, -1, 1));
		
		
		
	}
	
	@Test
	public void testMoveHeroToClosedDoor() {
		nivel1.CreateMapLevel(1);
		nivel1.getHero().setX(3);
		nivel1.getHero().setY(1);
		
		assertEquals(3, nivel1.getHero().getX());
		assertEquals(1, nivel1.getHero().getY());
		
		nivel1.ChangeMap(1, 0, 1);
		
		assertEquals(3, nivel1.getHero().getX());
		assertEquals(1, nivel1.getHero().getY());
		
		
	}
	
	@Test
	public void testMoveHeroIntoTheLeverCellExitDoorsOpen() {
		nivel1.CreateMapLevel(1);
		nivel1.getHero().setX(8);
		nivel1.getHero().setY(8);
		
		assertEquals(8, nivel1.getHero().getX());
		assertEquals(8, nivel1.getHero().getY());
		
		nivel1.ChangeMap(-1, 0, 1);
		
		assertEquals('S', nivel1.getMapa().getCoord(8, 2));

	}
	
	@Test
	public void testMoveHeroIntoTheExit() {
		nivel1.CreateMapLevel(1);
		nivel1.getHero().setX(8);
		nivel1.getHero().setY(8);
		
		assertEquals(8, nivel1.getHero().getX());
		assertEquals(8, nivel1.getHero().getY());
		
		nivel1.ChangeMap(-1, 0, 1);
		
		nivel1.getHero().setX(1);
		nivel1.getHero().setY(5);
		
		assertEquals(2, nivel1.ChangeMap(-1, 0, 1));
		
		
	}

}
