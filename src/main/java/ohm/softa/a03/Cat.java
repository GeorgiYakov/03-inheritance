package ohm.softa.a03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Cat {
    private static final Logger logger = LogManager.getLogger();

	// state durations (set via constructor), ie. the number of ticks in each state
	private final int sleep;
	private final int awake;
	private final int digest;

	private final String name;

    private State currentState;

	private int time = 0;
	private int timeDigesting = 0;

	public Cat(String name, int sleep, int awake, int digest) {
		this.name = name;
		this.sleep = sleep;
		this.awake = awake;
		this.digest = digest;
		currentState = new SleepingState(sleep);
	}

	public void tick(){
        this.currentState = currentState.tick(this);
	}

	/**
	 * This would be a user interaction: feed the cat to change its state!
	 */
	public void feed(){
        if(!isHungry())
            throw new IllegalStateException("The cat's not hungry at the moment");

        this.currentState = ((HungryState) currentState).feed(this);
	}

	public boolean isAsleep() {
        return currentState instanceof SleepingState;
    }

	public boolean isPlayful() {
        return  currentState instanceof PlayfulState;
    }

	public boolean isHungry() {
        return currentState instanceof HungryState;
	}

	public boolean isDigesting() {
        return currentState instanceof DigestingState;
	}

	public boolean isDead() {
        return currentState instanceof DeathState;
	}

	public int getSleep(){
	    return sleep;
    }

    public int getDigest(){
	    return digest;
    }

    public int getAwake(){
	    return awake;
    }

    public String getName(){
	    return name;
    }
	@Override
	public String toString() {
		return name;
	}

}
