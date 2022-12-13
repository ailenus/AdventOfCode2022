package day7.model;

import java.util.Map;
import java.util.stream.Stream;

public class Directory {
    private final Directory PARENT;
    private final Map<String, Directory> CHILDREN;
    private final Map<String, Integer> FILES;

    public Directory(Directory parent, Map<String, Directory> children,
                     Map<String, Integer> files) {
        PARENT = parent;
        CHILDREN = children;
        FILES = files;
    }

    public Directory getParent() {
        return PARENT;
    }

    public Map<String, Directory> getChildren() {
        return CHILDREN;
    }

    public Map<String, Integer> getFiles() {
        return FILES;
    }

    public Stream<Directory> descendants() {
        return Stream.concat(Stream.of(this), this.CHILDREN.values().stream()
                .flatMap(Directory::descendants));
    }
}
