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
	public void addFrame(Frame frame){
		frames.add(frame);
	}
	
	// Sets the bonus throws at the end of the game
	public void setBonus(int firstThrow, int secondThrow) {
		//to be implemented
	}
	
	// Returns the game score
	public int score(){
		int score = 0;
		int counter = 0;
		for(Frame frame: frames) {
			if(frame.isStrike()) {
				if(frames.get(counter+1).isStrike()) {
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
		}
		return score;
	}
}
