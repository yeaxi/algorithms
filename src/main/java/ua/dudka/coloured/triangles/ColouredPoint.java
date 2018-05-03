package ua.dudka.coloured.triangles;

import java.util.Arrays;
import java.util.Objects;

class ColouredPoint {
    private final int[] position;
    private final String colour;

    public ColouredPoint(final int[] position, final String colour) {
        this.position = position;
        this.colour = colour;
    }

    public int[] getPosition() {
        return position;
    }

    public String getColour() {
        return colour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColouredPoint that = (ColouredPoint) o;
        return Arrays.equals(position, that.position) &&
                Objects.equals(colour, that.colour);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(colour);
        result = 31 * result + Arrays.hashCode(position);
        return result;
    }

    @Override
    public String toString() {
        return "[" + Arrays.toString(position) + "," + colour + "]";
    }
}