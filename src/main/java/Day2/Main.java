package Day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "src/main/resources/day2.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(url));
        String line;
        int score = 0;
        while ((line = bufferedReader.readLine()) != null) {
            switch (line) {
//                case "A X" -> score += 1 + 3;
//                case "A Y" -> score += 2 + 6;
//                case "A Z" -> score += 3 + 0;
//                case "B X" -> score += 1 + 0;
//                case "B Y" -> score += 2 + 3;
//                case "B Z" -> score += 3 + 6;
//                case "C X" -> score += 1 + 6;
//                case "C Y" -> score += 2 + 0;
//                case "C Z" -> score += 3 + 3;
                case "A X" -> score += 3 + 0;
                case "A Y" -> score += 1 + 3;
                case "A Z" -> score += 2 + 6;
                case "B X" -> score += 1 + 0;
                case "B Y" -> score += 2 + 3;
                case "B Z" -> score += 3 + 6;
                case "C X" -> score += 2 + 0;
                case "C Y" -> score += 3 + 3;
                case "C Z" -> score += 1 + 6;
            }
        }
        System.out.println(score);
    }
}
