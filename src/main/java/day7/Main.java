package day7;

import day7.controller.FileSystemController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "src/main/resources/day7.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(url));
        String line;
        List<String[]> lines = new ArrayList<>();
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line.split(" "));
        }
        FileSystemController fileSystemController = new FileSystemController();
        for (int index = 0; index < lines.size(); index++) {
            String[] tokens = lines.get(index);
            if ("cd".equals(tokens[1])) {
                String directoryName = tokens[2];
                if ("/".equals(directoryName)) {
                    fileSystemController.toRoot();
                } else if ("..".equals(directoryName)) {
                    fileSystemController.parentDirectory();
                } else {
                    fileSystemController.changeDirectory(directoryName);
                }
            } else {
                index++;
                tokens = lines.get(index);
                String firstToken = tokens[0];
                while (!"$".equals(firstToken)) {
                    if ("dir".equals(firstToken)) {
                        fileSystemController.insert(tokens[1]);
                    } else {
                        fileSystemController.insert(tokens[1],
                                Integer.parseInt(firstToken));
                    }
                    index++;
                    if (index == lines.size()) {
                        break;
                    }
                    tokens = lines.get(index);
                    firstToken = tokens[0];
                }
                index--;
            }
        }
        fileSystemController.toRoot();
        System.out.println(fileSystemController.descendantsTotalSizes()
                .filter(totalSize -> totalSize <= 100_000).sum());

        int minimumExtraSpace = fileSystemController.totalSize() - 40_000_000;
        System.out.println(fileSystemController.descendantsTotalSizes()
                .filter(totalSize -> totalSize >= minimumExtraSpace).min());
    }
}
