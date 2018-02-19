import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertArrayEquals;

public class QuickSortSteps {

    private QuickSort sorter;
    private String[] actual;

    @Given("a collection of items: $items")
    public void aCollectionOfItems(ExamplesTable items) {
        List<String> actual = new ArrayList<>();
        for (Map<String, String> row : items.getRows())
            actual.add(row.get("items"));

        this.actual = actual.toArray(new String[actual.size()]);
    }

    @When("I sort the collection")
    public void iSortTheCollection() {
        sorter = new QuickSort();
        sorter.sort(actual);
    }

    @Then("the collection is sorted: $items")
    public void theCollectionIsSorted(ExamplesTable items) {
        List<String> expected = new ArrayList<>();
        for (Map<String, String> row : items.getRows())
            expected.add(row.get("items"));

        assertArrayEquals(actual, expected.toArray());
    }
}
