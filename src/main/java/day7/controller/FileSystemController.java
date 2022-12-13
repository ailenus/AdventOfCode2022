package day7.controller;

import day7.model.Directory;
import day7.model.FileSystem;

import java.util.stream.IntStream;

public class FileSystemController {
    private final FileSystem FILE_SYSTEM;
    private Directory workingDirectory;

    public FileSystemController() {
        FILE_SYSTEM = new FileSystem();
        workingDirectory = FILE_SYSTEM.getRoot();
    }

    public void toRoot() {
        workingDirectory = FILE_SYSTEM.getRoot();
    }

    public void parentDirectory() {
        workingDirectory = workingDirectory.getParent();
    }

    public void changeDirectory(String directoryName) {
        workingDirectory = workingDirectory.getChildren().get(directoryName);
    }

    public void insert(String directoryName) {
        FileSystem.insert(workingDirectory, directoryName);
    }

    public void insert(String fileName, int fileSize) {
        FileSystem.insert(workingDirectory, fileName, fileSize);
    }

    public int totalSize() {
        return FileSystem.totalSize(workingDirectory);
    }

    public IntStream descendantsTotalSizes() {
        return workingDirectory.descendants().mapToInt(FileSystem::totalSize);
    }
}
