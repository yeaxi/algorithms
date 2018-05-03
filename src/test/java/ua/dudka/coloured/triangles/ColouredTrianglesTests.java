package ua.dudka.coloured.triangles;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ColouredTrianglesTests {

    private List<ColouredPoint> colouredPoints;
    private TriangleResult expectedResult;

    public ColouredTrianglesTests(List<ColouredPoint> colouredPoints, TriangleResult expectedResult) {
        this.colouredPoints = colouredPoints;
        this.expectedResult = expectedResult;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                        {
                                List.of(new ColouredPoint(new int[]{3, -4}, "blue"), new ColouredPoint(new int[]{-7, -1}, "red"), new ColouredPoint(new int[]{7, -6}, "green"),
                                        new ColouredPoint(new int[]{2, 5}, "green"), new ColouredPoint(new int[]{1, -5}, "red"), new ColouredPoint(new int[]{-1, 4}, "red"),
                                        new ColouredPoint(new int[]{1, 7}, "red"), new ColouredPoint(new int[]{-3, 5}, "red"), new ColouredPoint(new int[]{-3, -5}, "blue"),
                                        new ColouredPoint(new int[]{4, 1}, "blue")),
                                new TriangleResult(10, 3, 11, List.of("red"), 10)
                        },
                        {
                                List.of(new ColouredPoint(new int[]{3, -4}, "blue"), new ColouredPoint(new int[]{-7, -1}, "red"), new ColouredPoint(new int[]{7, -6}, "green"),
                                        new ColouredPoint(new int[]{2, 5}, "green"), new ColouredPoint(new int[]{1, -5}, "red"), new ColouredPoint(new int[]{1, 1}, "red"),
                                        new ColouredPoint(new int[]{1, 7}, "red"), new ColouredPoint(new int[]{1, 4}, "red"), new ColouredPoint(new int[]{-3, -5}, "blue"),
                                        new ColouredPoint(new int[]{4, 1}, "blue")),
                                new TriangleResult(10, 3, 7, List.of("red"), 6)
                        },
                        {
                                List.of(new ColouredPoint(new int[]{1, -2}, "red"), new ColouredPoint(new int[]{7, -6}, "green"), new ColouredPoint(new int[]{2, 5}, "green"),
                                        new ColouredPoint(new int[]{1, -5}, "red"), new ColouredPoint(new int[]{1, 1}, "red"), new ColouredPoint(new int[]{1, 7}, "red"),
                                        new ColouredPoint(new int[]{1, 4}, "red"), new ColouredPoint(new int[]{-3, -5}, "blue"), new ColouredPoint(new int[]{4, 1}, "blue")),

                                new TriangleResult(9, 3, 0, new ArrayList<>(), 0)
                        },
                        {
                                List.of(
                                        new ColouredPoint(new int[]{0, 0}, "red"),
                                        new ColouredPoint(new int[]{0, 1}, "red"),
                                        new ColouredPoint(new int[]{0, 2}, "red"),
                                        new ColouredPoint(new int[]{1, 0}, "red")),
                                new TriangleResult(4, 1, 3, List.of("red"), 3)
                        }
                }
        );
    }


    @Test
    public void test() {
        assertEquals(expectedResult, ColouredTriangles.countColouredTriangles(colouredPoints));
    }
}