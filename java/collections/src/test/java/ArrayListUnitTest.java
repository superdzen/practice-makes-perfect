import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static java.util.stream.Collectors.*;
import static org.junit.Assert.*;

public class ArrayListUnitTest {
    private List<String> stringToSearch;

    @Before
    public void createArrayList() {
        List<String> strings = LongStream.range(0, 16).boxed()
                .map(Long::toHexString)
                .collect(toCollection(ArrayList::new));
        stringToSearch = new ArrayList<>(strings);
        stringToSearch.addAll(strings);
    }

    @Test
    public void createNewList_checkIfNewListIsEmpty() {
        List<String> strings = new ArrayList<>();

        assertTrue(strings.isEmpty());
    }

    @Test
    public void createArrayListFromAnotherCollection_checkSizesAndContent() {
        Collection<Integer> numbers = IntStream.range(0, 50).boxed().collect(toSet());
        List<Integer> listNumbers = new ArrayList<>(numbers);

        assertEquals(listNumbers.size(), 50);
        assertTrue(listNumbers.containsAll(numbers));
    }

    @Test
    public void addElements_CreatedListEqualsReferenceList() {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");

        assertEquals(Arrays.asList("one", "two", "three"), list);
    }

    @Test
    public void addElementsUsingListIteratorInReverse_SourceListEqualsCreatedList() {
        List<Integer> source_List = IntStream.range(0, 50)
                .boxed()
                .collect(toList());
        List<Integer> created_list = new ArrayList<>(source_List.size());

        ListIterator<Integer> integerIterator = source_List.listIterator(source_List.size());
        while (integerIterator.hasPrevious()) {
            created_list.add(integerIterator.previous());
        }
        Collections.reverse(created_list);
        assertEquals(source_List, created_list);
    }

    @Test
    public void searchInArray_GivenIndexEqualsIndexOfValue() {
        assertEquals(11, stringToSearch.indexOf("b"));
        assertEquals(27, stringToSearch.lastIndexOf("b"));
    }
}
