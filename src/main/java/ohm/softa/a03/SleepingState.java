package ohm.softa.a03;

public class SleepingState extends State {
    protected SleepingState(int duration) {
        super(duration);
    }

    @Override
    public State successor(Cat cat) {
        logger.info("I'm getting hungry");
        return new HungryState(cat.getAwake());
    }
}
