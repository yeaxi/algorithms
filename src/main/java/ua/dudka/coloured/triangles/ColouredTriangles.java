package ua.dudka.coloured.triangles;

import java.util.*;

class ColouredTriangles {

    private static class Triangle {
        private final String color;
        private final Set<ColouredPoint> points = new HashSet<>();

        Triangle(ColouredPoint a, ColouredPoint b, ColouredPoint c) {
            this.color = a.getColor();
            points.add(a);
            points.add(b);
            points.add(c);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Triangle triangle = (Triangle) o;
            return Objects.equals(color, triangle.color) &&
                    Objects.equals(points, triangle.points);
        }

        @Override
        public int hashCode() {
            return Objects.hash(color, points);
        }

        @Override
        public String toString() {
            return "Triangle{" +
                    "color='" + color + '\'' +
                    ", points=" + points +
                    '}';
        }
    }


    public static TriangleResult countColouredTriangles(final List<ColouredPoint> givenPoints) {
        Map<String, Integer> amountByColor = new HashMap<>();
        Set<Triangle> triangles = new HashSet<>();
        for (int i = 0; i < givenPoints.size(); i++) {
            ColouredPoint a = givenPoints.get(i);
            amountByColor.putIfAbsent(a.getColor(), 0);
            for (int j = i + 1; j < givenPoints.size(); j++) {
                ColouredPoint b = givenPoints.get(j);
                for (int k = j + 1; k < givenPoints.size(); k++) {
                    ColouredPoint c = givenPoints.get(k);
                    if (haveDifferentColors(a, b, c) || onSameLine(a, b, c)) {
                        continue;
                    }
                    triangles.add(new Triangle(a, b, c));
                    amountByColor.computeIfPresent(a.getColor(), (key, val) -> val + 1);
                }
            }
        }

        int maxFromColour = 0;
        List<String> maxColours = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : amountByColor.entrySet()) {
            int size = entry.getValue();
            if (size > maxFromColour) {
                maxFromColour = size;
                maxColours.clear();
                maxColours.add(entry.getKey());
            } else if (size == maxFromColour && maxFromColour != 0) {
                maxColours.add(entry.getKey());
            }
        }

        int nGivenPoints = givenPoints.size();
        int nGivenColours = amountByColor.size();
        int nTriangles = triangles.size();

        return new TriangleResult(nGivenPoints, nGivenColours, nTriangles, maxColours, maxFromColour);
    }

    private static boolean haveDifferentColors(ColouredPoint a, ColouredPoint b, ColouredPoint c) {
        return !(a.getColor().equals(b.getColor()) && a.getColor().equals(c.getColor()));
    }

    private static boolean onSameLine(ColouredPoint a, ColouredPoint b, ColouredPoint c) {
        return a.getPos()[0] == b.getPos()[0] && a.getPos()[0] == c.getPos()[0]
                || a.getPos()[1] == b.getPos()[1] && a.getPos()[1] == c.getPos()[1];
    }
}