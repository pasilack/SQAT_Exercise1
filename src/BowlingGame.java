import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

//Finish time:
//ID:

public class BowlingGame {
	//a bowling game is made of (at least) 10 frames
	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;
	
	
	public BowlingGame(){}
	
	// adds a frame to the game
	public void addFrame (Frame frame) throws BowlingException{
		if(frame.getFirstThrow() > 10 || frame.getFirstThrow() < 0)
			throw new BowlingException("Points of the Frame's first throw are wrong: " + frame.getFirstThrow());
		if(frame.getSecondThrow() > 10 || frame.getSecondThrow() < 0)
			throw new BowlingException("Points of the Frame's second throw are wrong: " + frame.getSecondThrow());
		frames.add(frame);
	}
	
	// Sets the bonus throws at the end of the game
	public void setBonus(int firstThrow, int secondThrow) {
		bonus = new Frame(firstThrow, secondThrow);
	}
	
	// Returns the game score
	public int score(){
		int score = 0;
		int counter = 0;
		for(Frame frame: frames) {
			if(counter == 9 && frame.isStrike()) {
				score += 10 + bonus.score();
			}
			else if (counter == 9 && frame.isSpare()) {
				score += 10 + bonus.getFirstThrow();
			}
			else if(frame.isStrike()) {
				if(counter == 8 && frames.get(counter+1).isStrike())
					score += 20 + bonus.getFirstThrow();
				else if(frames.get(counter+1).isStrike()) {
					score += 20 + frames.get(counter+2).getFirstThrow();
					//System.out.println(score);
				}
				else {
					score += 10 + frames.get(counter+1).score();
					//System.out.println(score);
				}
			}
			else if(frame.isSpare()) {
				score += 10 + frames.get(counter+1).getFirstThrow();
				//System.out.println(score);
			}
			else {
				score += frame.score();
				//System.out.println(score);
			}
			counter++;
			if(counter == 10)
				break;
		}
		return score;
	}
}
