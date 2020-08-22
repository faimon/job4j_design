package io;

public class ArgZip {

    private final String[] args;

    public ArgZip(String[] args) {
        this.args = args;
    }

    public boolean valid() {
        if (args.length != 3) {
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

    public String exclude() {
        String[] value = args[1].split("=");
        if (!value[0].equals("-e")) {
            throw new IllegalArgumentException("Argument 'exclude' is not exist");
        }
        return value[1];
    }

    public String output() {
        String[] value = args[2].split("=");
        if (!value[0].equals("-o")) {
            throw new IllegalArgumentException("Argument 'output' is not exist");
        }
        return value[1];
    }
}
