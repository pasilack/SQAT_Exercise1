import static org.junit.Assert.*;

import org.junit.Test;

public class TestBowling {

	@Test
	public void testStrike() {
		BowlingGame bg = new BowlingGame();
		bg.addFrame(new Frame(10, 0));
		bg.addFrame(new Frame(4, 5));
		assertEquals(10, bg.score());
	}

}
