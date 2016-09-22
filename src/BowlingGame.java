import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

//Finish time:
//ID:

public class BowlingGame {
	//a bowling game is made of (at least) 10 frames
	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;
	
	private ListIterator<Frame> it = frames.listIterator();
	
	public BowlingGame(){}
	
	// adds a frame to the game
	public void addFrame(Frame frame){
		frames.add(frame);
	}
	
	// Sets the bonus throws at the end of the game
	public void setBonus(int firstThrow, int secondThrow) {
		if(frames.get(0).isStrike()){
			bonus = frames.get(1);
		}
			
		//to be implemented
	}
	
	// Returns the game score
	public int score(){
		int score = 0;
		for(Frame frame: frames) {
			if(frame.isStrike()) {
				Frame frameplus1 = null;
				if (it.hasNext()) {
					  frameplus1 = it.next();
				}
				score += 10 + frameplus1.score();
			}
		}
		return score;
	}
}
