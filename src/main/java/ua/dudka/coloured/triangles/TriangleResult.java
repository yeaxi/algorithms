package ua.dudka.coloured.triangles;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

class TriangleResult {
    private final int nGivenPoints;
    private final int nGivenColours;
    private final int nTriangles;
    private final List<String> colours;
    private final int maxFromColour;

    public TriangleResult() {
        nGivenPoints = 0;
        nGivenColours = 0;
        nTriangles = 0;
        colours = Collections.emptyList();
        maxFromColour = 0;
    }

    public TriangleResult(final int nGivenPoints, final int nGivenColours, final int nTriangles, final List<String> colours, final int maxFromColour) {
        this.nGivenPoints = nGivenPoints;
        this.nGivenColours = nGivenColours;
        this.nTriangles = nTriangles;
        this.colours = colours;
        this.maxFromColour = maxFromColour;
    }

    public int getnGivenPoints() {
        return nGivenPoints;
    }

    public int getnGivenColours() {
        return nGivenColours;
    }

    public int getnTriangles() {
        return nTriangles;
    }

    public List<String> getColours() {
        return colours;
    }

    public int getMaxFromColour() {
        return maxFromColour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TriangleResult that = (TriangleResult) o;
        return nGivenPoints == that.nGivenPoints &&
                nGivenColours == that.nGivenColours &&
                nTriangles == that.nTriangles &&
                maxFromColour == that.maxFromColour &&
                Objects.equals(colours, that.colours);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nGivenPoints, nGivenColours, nTriangles, colours, maxFromColour);
    }

    @Override
    public String toString() {
        return "TriangleResult{" +
                "nGivenPoints=" + nGivenPoints +
                ", nGivenColours=" + nGivenColours +
                ", nTriangles=" + nTriangles +
                ", colours=" + colours +
                ", maxFromColour=" + maxFromColour +
                '}';
    }
}