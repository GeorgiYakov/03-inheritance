package ohm.softa.a03;

public class DigestingState extends State {

    private final int remainingAwakeTime;
    protected DigestingState(int duration, int remaining) {
        super(duration);
        remainingAwakeTime = remaining;
    }

    @Override
    public State successor(Cat cat) {

        return new PlayfulState(remainingAwakeTime - duration); // or - cat.getDigest
    }


}
