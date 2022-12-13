package day9;

public class Rope {
    private int headAbscissa;
    private int headOrdinate;
    private int tailAbscissa;
    private int tailOrdinate;

    public Rope() {
        headAbscissa = 0;
        headOrdinate = 0;
        tailAbscissa = 0;
        tailOrdinate = 0;
    }

    public void moveLeft() {
        headAbscissa--;
        if (tailAbscissa == headAbscissa + 2) {
            tailAbscissa--;
            if (tailOrdinate != headOrdinate) {
                tailOrdinate = headOrdinate;
            }
        }
    }

    public void moveRight() {
        headAbscissa++;
        if (tailAbscissa == headAbscissa - 2) {
            tailAbscissa++;
            if (tailOrdinate != headOrdinate) {
                tailOrdinate = headOrdinate;
            }
        }
    }

    public void moveUp() {
        headOrdinate++;
        if (tailOrdinate == headOrdinate - 2) {
            tailOrdinate++;
            if (tailAbscissa != headAbscissa) {
                tailAbscissa = headAbscissa;
            }
        }
    }

    public void moveDown() {
        headOrdinate--;
        if (tailOrdinate == headOrdinate + 2) {
            tailOrdinate--;
            if (tailAbscissa != headAbscissa) {
                tailAbscissa = headAbscissa;
            }
        }
    }

    public int getTailAbscissa() {
        return tailAbscissa;
    }

    public int getTailOrdinate() {
        return tailOrdinate;
    }
}
