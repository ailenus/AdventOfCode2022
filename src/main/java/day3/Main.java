package day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "src/main/resources/day3.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(url));
        String line;
        int sum = 0;
        while ((line = bufferedReader.readLine()) != null) {
            int totalLength = line.length();
            int length = totalLength / 2;
            String first = line.substring(0, length);
            String second = line.substring(length, totalLength);
            Set<Character> firstSet =
                    first.chars().mapToObj(element -> (char) element)
                            .collect(Collectors.toSet());
            Set<Character> secondSet =
                    second.chars().mapToObj(element -> (char) element)
                            .collect(Collectors.toSet());
            Set<Character> intersection = new HashSet<>(firstSet);
            intersection.retainAll(secondSet);
            for (char element : intersection) {
                int value;
                if (element >= 97 && element <= 122) {
                    value = element - 96;
                } else {
                    value = element - 64 + 26;
                }
                sum += value;
            }
        }
        System.out.println(sum);

        List<String> rucksacks;
        try (Stream<String> lines = Files.lines(Path.of(url))) {
            rucksacks = lines.toList();
        }
        int size = rucksacks.size();
        int sum2 = 0;
        for (int index = 0; index < size - 2; index += 3) {
            Set<Character> first = rucksacks.get(index).chars()
                    .mapToObj(element -> (char) element)
                    .collect(Collectors.toSet());
            Set<Character> second = rucksacks.get(index + 1).chars()
                    .mapToObj(element -> (char) element)
                    .collect(Collectors.toSet());
            Set<Character> third = rucksacks.get(index + 2).chars()
                    .mapToObj(element -> (char) element)
                    .collect(Collectors.toSet());
            Set<Character> intersection = new HashSet<>(first);
            intersection.retainAll(second);
            intersection.retainAll(third);
            char element = (char) intersection.toArray()[0];
            if (element >= 97 && element <= 122) {
                sum2 += element - 96;
            } else {
                sum2 += element - 64 + 26;
            }
        }
        System.out.println(sum2);
    }
}
