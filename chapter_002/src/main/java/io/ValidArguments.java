package io;

public class ValidArguments {
    private final String[] args;

    public ValidArguments(String[] args) {
        this.args = args;
    }

    public boolean valid() {
        if (args.length != 4) {
            throw new IllegalArgumentException("not enough arguments");
        }
        return true;
    }

    public String directory() {
        String[] value = args[0].split("=");
        if (!value[0].equals("-d")) {
            throw new IllegalArgumentException("Argument 'directory' is not exist");
        }
        return value[1];
    }

    public String fileName() {
        String[] value = args[1].split("=");
        if (!value[0].equals("-n")) {
            throw new IllegalArgumentException("Argument 'exclude' is not exist");
        }
        return value[1];
    }

    public String typeSearch() {
        if (!(args[2].equals("-m") || args[2].equals("-f") || args[2].equals("-r"))) {
            throw new IllegalArgumentException("Argument of typeSearch is wrong");
        }
        return args[2];
    }

    public String path() {
        String[] value = args[3].split("=");
        if (!value[0].equals("-o")) {
            throw new IllegalArgumentException("Argument 'exclude' is not exist");
        }
        return value[1];
    }
}
