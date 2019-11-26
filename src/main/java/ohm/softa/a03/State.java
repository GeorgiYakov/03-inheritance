package ohm.softa.a03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class State {
    protected static final Logger logger = LogManager.getLogger();

    int t = 0;

    final int duration;

    public int getTime(){
        return t;
    }

    public int getDuration() {
        return duration;
    }

    //constructor
    public State(int duration){
        this.duration = duration;
    }

    final State tick(Cat cat){
        if(duration < 0){
            logger.info("The Cat is dead");
            return  this;
        }

        t = t + 1;
        if(t == duration){
            return successor(cat);
        }
        else{
            return this;
        }

    }
    public abstract State successor(Cat cat);
}
