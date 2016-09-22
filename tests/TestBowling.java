import static org.junit.Assert.*;

import org.junit.Test;

public class TestBowling {

	@Test
	public void testStrike() {
		BowlingGame bg = new BowlingGame();
		bg.addFrame(new Frame(10, 0));
		bg.addFrame(new Frame(4, 5));
		assertEquals(19, bg.score());
	}
	
	@Test
	public void testSpare() {
		BowlingGame bg = new BowlingGame();
		bg.addFrame(new Frame(5, 5));
		bg.addFrame(new Frame(4, 5));
		assertEquals(14, bg.score());
	}
	
	@Test
	public void test10FramesWithNoSparesOrStrikes() {
		BowlingGame bg = new BowlingGame();
		bg.addFrame(new Frame(5, 0));
		bg.addFrame(new Frame(0, 5));
		bg.addFrame(new Frame(0, 5));
		bg.addFrame(new Frame(5, 0));
		bg.addFrame(new Frame(4, 5));
		bg.addFrame(new Frame(4, 5));
		bg.addFrame(new Frame(4, 5));
		bg.addFrame(new Frame(4, 0));
		bg.addFrame(new Frame(4, 5));
		bg.addFrame(new Frame(0, 5));
		assertEquals(64, bg.score());
	}

}
