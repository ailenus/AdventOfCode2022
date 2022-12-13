package day6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "src/main/resources/day6.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(url));
        String input = bufferedReader.readLine();
        int length = input.length();
        int index;
        for (index = 14; index < length; index++) {
            String slice = input.substring(index - 14, index);
            if (slice.chars().distinct().count() == 14) {
                break;
            }
        }
        System.out.println(index);
    }
}
