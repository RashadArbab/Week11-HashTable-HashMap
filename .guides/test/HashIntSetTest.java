import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class HashIntSetTest {
    @Parameters(name = "{0}")
    public static Object[][] data() {
        return new Object[][] { //
                { Arrays.asList(-2, 3, 5, 6, 8) }, //
                { Arrays.asList(1, 2, 3) }, //
                { Arrays.asList(1, 2, 22, 42, -2, 3, 92) }, //
                { Arrays.asList(21, -1, 1, 41, 2, 3, 71, 111, 11,
                        91) }, //
                { Arrays.asList() }, //
                { Arrays.asList(42) }, //
        };
    }

    private List<Integer> data;

    public HashIntSetTest(List<Integer> data) {
        this.data = data;
    }

    @Test
    public void test() {
        HashIntSet set = new HashIntSet();
        for (int value : data) {
            set.add(value);
        }

        var elementData = (HashEntry[]) TestUtilities
                .getFieldReference(set, "elementData");

        var size = (int) TestUtilities.getFieldReference(set, "size");
        var elementDataCopy = Arrays.copyOf(elementData,
                elementData.length);

        var str = set.toString();

        if (size == 0) {
            assertEquals("[]", str);
        } else {
            var resultData = Arrays
                    .stream(str.substring(1, str.length() - 1)
                            .split(","))
                    .map(String::trim).mapToInt(Integer::parseInt)
                    .boxed().collect(Collectors.toList());

            assertEquals(size, resultData.size());
            resultData.removeAll(data);
            assertTrue(resultData.isEmpty());
        }

        elementData = (HashEntry[]) TestUtilities
                .getFieldReference(set, "elementData");
        assertTrue(Arrays.deepEquals(elementDataCopy, elementData));
        assertEquals(size, set.size());
    }
}
