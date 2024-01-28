package io.github.libsdl4j.jna;

public class StringRef {

    private String value;

    public StringRef() {
    }

    public void setValue(String newValue) {
        value = newValue;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.format("String=%s", value);
    }
}
