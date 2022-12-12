package day5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "src/main/resources/day5.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(url));
        String firstLine = bufferedReader.readLine();
        int size = (firstLine.length() + 1) / 4;
        SupplyStack[] supplyStacks = new SupplyStack[size];
        for (int index = 0; index < size; index++) {
            supplyStacks[index] = new SupplyStack();
        }
        List<String> configuration = new ArrayList<>();
        configuration.add(firstLine);
        String line;
        while (!"".equals(line = bufferedReader.readLine())) {
            configuration.add(line);
        }
        for (int index = configuration.size() - 2; index >= 0; index--) {
            String row = configuration.get(index);
            for (int i = 0; i < size; i++) {
                char character = row.charAt(i * 4 + 1);
                if (character != ' ') {
                    supplyStacks[i].push(character);
                }
            }
        }
        List<int[]> moves = new ArrayList<>();
        while ((line = bufferedReader.readLine()) != null) {
            String[] tokens = line.split(" ");
            moves.add(new int[] {
                    Integer.parseInt(tokens[1]), Integer.parseInt(tokens[3]),
                    Integer.parseInt(tokens[5])
            });
        }
        for (int index = 0; index < moves.size(); index++) {
            int[] row = moves.get(index);
            int count = row[0];
            int fromIndex = row[1] - 1;
            int toIndex = row[2] - 1;
            for (int i = 0; i < count; i++) {
                supplyStacks[toIndex].push(supplyStacks[fromIndex].pop());
            }
        }
        StringBuilder result = new StringBuilder();
        for (int index = 0; index < supplyStacks.length; index++) {
            result.append(supplyStacks[index].peek());
        }
        System.out.println(result);
    }
}
