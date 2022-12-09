package day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "src/main/resources/day4.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(url));
        String line;
        int count = 0;
        int count2 = 0;
        while ((line = bufferedReader.readLine()) != null) {
            String[] assignments = line.split(",");
            String[] first = assignments[0].split("-");
            int startFirst = Integer.parseInt(first[0]);
            int endFirst = Integer.parseInt(first[1]);
            String[] second = assignments[1].split("-");
            int startSecond = Integer.parseInt(second[0]);
            int endSecond = Integer.parseInt(second[1]);
            count2++;
            if ((startFirst <= startSecond && endFirst >= endSecond) ||
                    (startSecond <= startFirst && endSecond >= endFirst)) {
                count++;
            }
            if (startFirst > endSecond || startSecond > endFirst) {
                count2--;
            }
        }
        System.out.println(count);
        System.out.println(count2);
    }
}
