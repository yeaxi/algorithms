package ua.dudka.coloured.triangles;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.*;

public class ColouredTrianglesTests {

    private List<List<ColouredPoint>> arguments = Arrays.asList( Arrays.asList(new ColouredPoint(new int[] {3, -4}, "blue"),  new ColouredPoint(new int[] {-7, -1}, "red"),   new ColouredPoint(new int[] {7, -6}, "yellow"),
                                                                          new ColouredPoint(new int[] {2, 5}, "yellow"), new ColouredPoint(new int[] {1, -5}, "red"),    new ColouredPoint(new int[] {-1, 4}, "red"),
                                                                          new ColouredPoint(new int[] {1, 7}, "red"),    new ColouredPoint(new int[] {-3, 5}, "red"),    new ColouredPoint(new int[] {-3, -5}, "blue"),
                                                                          new ColouredPoint(new int[] {4, 1}, "blue")),
                                                                          
                                                           Arrays.asList( new ColouredPoint(new int[] {3, -4}, "blue"),  new ColouredPoint(new int[] {-7, -1}, "red"),   new ColouredPoint(new int[] {7, -6}, "yellow"), 
                                                                          new ColouredPoint(new int[] {2, 5}, "yellow"), new ColouredPoint(new int[] {1, -5}, "red"),    new ColouredPoint(new int[] {1, 1}, "red"),
                                                                          new ColouredPoint(new int[] {1, 7}, "red"),    new ColouredPoint(new int[] {1, 4}, "red"),     new ColouredPoint(new int[] {-3, -5}, "blue"),
                                                                          new ColouredPoint(new int[] {4, 1}, "blue")),
                                                                          
                                                           Arrays.asList( new ColouredPoint(new int[] {1, -2}, "red"),   new ColouredPoint(new int[] {7, -6}, "yellow"), new ColouredPoint(new int[] {2, 5}, "yellow"),
                                                                          new ColouredPoint(new int[] {1, -5}, "red"),   new ColouredPoint(new int[] {1, 1}, "red"),     new ColouredPoint(new int[] {1, 7}, "red"),
                                                                          new ColouredPoint(new int[] {1, 4}, "red"),    new ColouredPoint(new int[] {-3, -5}, "blue"),  new ColouredPoint(new int[] {4, 1}, "blue")));

    private List<TriangleResult> expected = Arrays.asList( new TriangleResult(10, 3, 11, Arrays.asList("red"),    10),
                                                      new TriangleResult(10, 3, 7,  Arrays.asList("red"),     6),
                                                      new TriangleResult(9,  3, 0,  new ArrayList<String>(),  0));
    @Test
    public void test_BasicTests() {
        for (int n = 0; n < expected.size() ; n++)
            assertEquals(expected.get(n), ColouredTriangles.countColouredTriangles( arguments.get(n) ));
    }
}