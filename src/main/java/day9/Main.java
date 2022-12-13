package day9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "src/main/resources/day9.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(url));
        String line;
        Rope rope = new Rope();
        Set<Point> set = new HashSet<>();
        set.add(new Point(0, 0));
        while ((line = bufferedReader.readLine()) != null) {
            String[] tokens = line.split(" ");
            int count = Integer.parseInt(tokens[1]);
            switch (tokens[0]) {
                case "L":
                    for (int index = 0; index < count; index++) {
                        rope.moveLeft();
                        set.add(new Point(rope.getTailAbscissa(),
                                rope.getTailOrdinate()));
                    }
                    break;
                case "R":
                    for (int index = 0; index < count; index++) {
                        rope.moveRight();
                        set.add(new Point(rope.getTailAbscissa(),
                                rope.getTailOrdinate()));
                    }
                    break;
                case "U":
                    for (int index = 0; index < count; index++) {
                        rope.moveUp();
                        set.add(new Point(rope.getTailAbscissa(),
                                rope.getTailOrdinate()));
                    }
                    break;
                case "D":
                    for (int index = 0; index < count; index++) {
                        rope.moveDown();
                        set.add(new Point(rope.getTailAbscissa(),
                                rope.getTailOrdinate()));
                    }
                    break;
            }
        }
        System.out.println(set.size());
    }
}
