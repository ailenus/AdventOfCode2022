package DayOne;

import java.util.ArrayList;
import java.util.List;

public class Elf {
    private final List<Integer> CALORIES;

    public Elf() {
        CALORIES = new ArrayList<>();
    }

    public boolean add(int calorie) {
        return CALORIES.add(calorie);
    }

    public int sum() {
        return CALORIES.stream().reduce(0, Integer::sum);
    }
}
