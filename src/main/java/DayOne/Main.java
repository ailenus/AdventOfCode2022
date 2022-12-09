package DayOne;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "src/main/resources/day1.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(url));
        List<Elf> elves = new ArrayList<>();
        String line;
        int one = 0, two = 0, three = 0;
        Elf oneElf = null, twoElf = null, threeElf = null;
        outer:
        while (true) {
            Elf elf = new Elf();
            while ((line = bufferedReader.readLine()) != null) {
                if ("".equals(line)) {
                    int totalCalories = elf.sum();
                    if (totalCalories > one) {
                        three = two;
                        threeElf = twoElf;
                        two = one;
                        twoElf = oneElf;
                        one = totalCalories;
                        oneElf = elf;
                    } else if (totalCalories > two) {
                        three = two;
                        threeElf = twoElf;
                        two = totalCalories;
                        twoElf = elf;
                    } else if (totalCalories > three) {
                        three = totalCalories;
                        threeElf = elf;
                    }
                    elves.add(elf);
                    continue outer;
                } else {
                    elf.add(Integer.parseInt(line));
                }
            }
            break;
        }
        System.out.println(one + two + three);
    }
}
