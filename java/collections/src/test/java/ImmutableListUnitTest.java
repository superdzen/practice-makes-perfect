import com.google.common.collect.ImmutableList;
import org.apache.commons.collections.ListUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ImmutableListUnitTest {
    private List<Integer> list = new ArrayList<>(IntStream.range(0, 10).boxed().collect(Collectors.toList()));

    @Test(expected = UnsupportedOperationException.class)
    public void createImmutableListUsingCollections_TryToAddNewElement_ExceptionThrown() {
        List<Integer> unmodifiableList = Collections.unmodifiableList(list);
        unmodifiableList.add(11);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void createImmutableListUsingGuava_TryToAddNewElement_ExceptionThrown() {
        List<Integer> unmodifiableList = ImmutableList.copyOf(list);
        unmodifiableList.add(11);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void createImmutableListUsingGuavaBuilder_TryToAddNewElement_ExceptionThrown() {
        ImmutableList<Object> unmodifiableList = ImmutableList.builder().addAll(list).build();
        unmodifiableList.add(11);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void createImmutableListUsingApacheCollections_TryToAddNewElement_ExceptionThrown() {
        List<Integer> unmodifiableList = ListUtils.unmodifiableList(list);
        unmodifiableList.add(11);
    }


}
