package day9;

import java.util.Objects;

public class Point {
    private final int ABSCISSA;
    private final int ORDINATE;

    public Point(int abscissa, int ordinate) {
        ABSCISSA = abscissa;
        ORDINATE = ordinate;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Point point) {
            return ABSCISSA == point.ABSCISSA && ORDINATE == point.ORDINATE;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(ABSCISSA, ORDINATE);
    }
}
