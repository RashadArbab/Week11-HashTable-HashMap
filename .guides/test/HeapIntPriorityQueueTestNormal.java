

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class HeapIntPriorityQueueTestNormal {
    @Parameters(name = "{0}")
    public static Object[][] data() {
        return new Object[][] { //
                { Arrays.asList(3, 4, 6, 7, 5) }, // normal
                { Arrays.asList(42, 60, 15, 55, 56, 12, 97, 63, 46, 61, 39, 47, 43, 51,
                        87, 95, 82, 11, 73, 81, 25, 30, 48, 80, 9, 76, 50, 94,
                        96, 70, 74, 19, 93, 54, 69, 85, 40, 8, 66, 71, 37, 13,
                        17, 57, 22, 68, 33, 78, 35, 67) }, // big
                { Arrays.asList(73, -37, 99, -72, -92, 17, -79, 39, -85, 12) }, // negatives
                { Arrays.asList(2, 9, 1, 2, 7, 4, 5, 2, 2, 4, 1, 9, 1, 9, 1, 3, 5, 6, 7,
                        2) }, // duplicates
                { Arrays.asList(100) }, // singleton
        };
    }

    private List<Integer> numbers;

    public HeapIntPriorityQueueTestNormal(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Test
    public void test() {
        check(numbers);
    }

    private HeapIntPriorityQueue createPriorityQueue(List<Integer> numbers) {
        HeapIntPriorityQueue pq = new HeapIntPriorityQueue();
        for (int i : numbers) {
            pq.add(i);
        }
        return pq;
    }

    private void check(List<Integer> numbers) {
        HeapIntPriorityQueue pq = createPriorityQueue(numbers);

        List<Integer> sorted = new ArrayList<>(numbers);
        sorted.sort(Integer::compareTo);

        for (int i : sorted) {
            assertEquals(i, pq.remove());
        }
    }
}
