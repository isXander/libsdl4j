package io.github.libsdl4j.jna;

public class FloatRef {

    private float value;

    public FloatRef(float value) {
        this.value = value;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
