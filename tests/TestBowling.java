import static org.junit.Assert.*;

import org.junit.Test;

public class TestBowling {

	@Test
	public void testStrike() {
		BowlingGame bg = new BowlingGame();
		bg.addFrame(new Frame(10, 0));
		bg.addFrame(new Frame(4, 5));
		assertEquals(28, bg.score());
	}
	
	@Test
	public void testSpare() {
		BowlingGame bg = new BowlingGame();
		bg.addFrame(new Frame(5, 5));
		bg.addFrame(new Frame(4, 5));
		assertEquals(23, bg.score());
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
		assertEquals(65, bg.score());
	}
	
	@Test
	public void test10FramesWith2StrikesAtStart() {
		BowlingGame bg = new BowlingGame();
		bg.addFrame(new Frame(10, 0));
		bg.addFrame(new Frame(10, 0));
		bg.addFrame(new Frame(0, 5));
		bg.addFrame(new Frame(5, 0));
		bg.addFrame(new Frame(0, 5));
		bg.addFrame(new Frame(0, 5));
		bg.addFrame(new Frame(0, 5));
		bg.addFrame(new Frame(0, 0));
		bg.addFrame(new Frame(0, 5));
		bg.addFrame(new Frame(0, 5));
		assertEquals(70, bg.score());
	}

}
