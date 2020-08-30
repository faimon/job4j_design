package io;

import java.io.File;

public class Shell {
    private String currentPath = "";
    private final static String ROOT_FLAG = "..";

    public void cd(String path) {
        if (path.contains(ROOT_FLAG)) {
            currentPath = File.separator;
            return;
        }
        if (currentPath.endsWith(File.separator) || path.equals(File.separator)) {
            currentPath += path;
            return;
        }
        currentPath += File.separator + path;
    }

    public String pwd() {
        return currentPath;
    }
}
