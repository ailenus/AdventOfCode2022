package day7.model;

import java.util.HashMap;
import java.util.Map;

public class FileSystem {
    private final Directory ROOT;

    public FileSystem() {
        ROOT = new Directory(null, new HashMap<>(), new HashMap<>());
    }

    public static void insert(Directory directory, String directoryName) {
        directory.getChildren().put(directoryName,
                new Directory(directory, new HashMap<>(), new HashMap<>()));
    }

    public static void insert(Directory directory, String fileName, int fileSize) {
        directory.getFiles().put(fileName, fileSize);
    }

    public static int totalSize(Directory directory) {
        Map<String, Directory> children = directory.getChildren();
        int sum =
                directory.getFiles().values().stream().reduce(0, Integer::sum);
        if (children.size() != 0) {
            for (Directory child : children.values()) {
                sum += totalSize(child);
            }
        }
        return sum;
    }

    public Directory getRoot() {
        return ROOT;
    }
}
