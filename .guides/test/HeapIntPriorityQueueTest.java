import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ //
    HeapIntPriorityQueueTestNormal.class, //
    HeapIntPriorityQueueExceptionTest.class, //
})
public class HeapIntPriorityQueueTest {
    @Test
    public void dummyTest() {
        
    }
}
