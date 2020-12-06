import java.util.NoSuchElementException;

import org.junit.Test;

public class HeapIntPriorityQueueExceptionTest {

    @Test(expected = NoSuchElementException.class)
    public void testException() {
        HeapIntPriorityQueue pq = new HeapIntPriorityQueue();
        pq.remove();
    }

}
