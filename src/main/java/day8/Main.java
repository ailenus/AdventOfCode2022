package day8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "src/main/resources/day8.txt";
        List<String> input;
        try (Stream<String> lines = Files.lines(Path.of(url))) {
            input = lines.toList();
        }
        int rowCount = input.size();
        int columnCount = input.get(0).length();
        int[][] matrix = new int[rowCount][columnCount];
        for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
            for (int columnIndex = 0; columnIndex < columnCount;
                 columnIndex++) {
                matrix[rowIndex][columnIndex] = Integer.parseInt(
                        String.valueOf(
                                input.get(rowIndex).charAt(columnIndex)));
            }
        }
        int count = 2 * (rowCount + columnCount) - 4;
        int max = 1;
        for (int rowIndex = 1; rowIndex < rowCount - 1; rowIndex++) {
            for (int columnIndex = 1; columnIndex < columnCount - 1;
                 columnIndex++) {
                int value = matrix[rowIndex][columnIndex];
                int[] row = matrix[rowIndex];
                int finalColumnIndex = columnIndex;
                int[] column = Arrays.stream(matrix)
                        .mapToInt(array -> array[finalColumnIndex]).toArray();
                int[] first = Arrays.copyOfRange(row, 0, columnIndex);
                int[] second = Arrays.copyOfRange(row, columnIndex + 1, columnCount);
                int[] third = Arrays.copyOfRange(column, 0, rowIndex);
                int[] fourth = Arrays.copyOfRange(column, rowIndex + 1, rowCount);
                if (allLessThan(first, value) || allLessThan(second, value) ||
                        allLessThan(third, value) || allLessThan(fourth, value)) {
                    count++;
                }
                int firstScore = 1;
                for (int index = first.length - 1; index >= 1; index--) {
                    if (first[index] < value) {
                        firstScore++;
                    } else {
                        break;
                    }
                }
                int secondScore = 1;
                for (int index = 0; index < second.length - 1; index++) {
                    if (second[index] < value) {
                        secondScore++;
                    } else {
                        break;
                    }
                }
                int thirdScore = 1;
                for (int index = third.length - 1; index >= 1; index--) {
                    if (third[index] < value) {
                        thirdScore++;
                    } else {
                        break;
                    }
                }
                int fourthScore = 1;
                for (int index = 0; index < fourth.length - 1; index++) {
                    if (fourth[index] < value) {
                        fourthScore++;
                    } else {
                        break;
                    }
                }
                int score = firstScore * secondScore * thirdScore * fourthScore;
                if (score > max) {
                    max = score;
                }
            }
        }
        System.out.println(count);
        System.out.println(max);
    }

    private static boolean allLessThan(int[] array, int value) {
        return Arrays.stream(array).allMatch(v -> v < value);
    }
}
