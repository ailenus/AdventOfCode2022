package day9;

public class TenKnotRope {
    private final Rope[] KNOTS;

    public TenKnotRope() {
        KNOTS = new Rope[9];
        for (int index = 0; index < 9; index++) {
            KNOTS[index] = new Rope();
        }
    }
}
