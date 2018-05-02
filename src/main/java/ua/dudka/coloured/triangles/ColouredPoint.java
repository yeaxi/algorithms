package ua.dudka.coloured.triangles;

import java.util.Arrays;
import java.util.Objects;

class ColouredPoint {
    private final int[] pos;
    private final String color;

    public ColouredPoint(final int[] pos, final String color) {
        this.pos = pos;
        this.color = color;
    }

    public int[] getPos() {
        return pos;
    }

    public String getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColouredPoint that = (ColouredPoint) o;
        return Arrays.equals(pos, that.pos) &&
                Objects.equals(color, that.color);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(color);
        result = 31 * result + Arrays.hashCode(pos);
        return result;
    }

    @Override
    public String toString() {
        return "[" + Arrays.toString(pos) + "," + color + "]";
    }
}