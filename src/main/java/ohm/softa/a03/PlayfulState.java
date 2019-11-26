package ohm.softa.a03;

public class PlayfulState extends State {
    protected PlayfulState(int duration) {
        super(duration);
    }

    @Override
    public State successor(Cat cat) {
        logger.info("I'm getting tired");
        return new SleepingState(cat.getSleep());
    }
}
