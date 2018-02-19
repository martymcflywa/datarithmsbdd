import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class BinarySearchSteps {

    private BinarySearch finder;
    private String[] source;
    private boolean isFound;

    @Given("a collection of alphabetically sorted words: $words")
    public void aCollectionOfAlphabeticallySortedWords(ExamplesTable words) {
        List<String> wordList = new ArrayList<>();
        for (Map<String, String> row : words.getRows()) {
            wordList.add(row.get("words"));
        }
        source = wordList.toArray(new String[wordList.size()]);
    }

    @When("I search for a target <target>")
    public void iSearchForTarget(@Named("target") String target) {
        finder = new BinarySearch();
        isFound = finder.searchIterative(source, target)
                && finder.searchRecursive(source, target);
    }

    @Then("the target was found: <bool>")
    public void theTargetWasFound(@Named("bool") String bool) {
        assertEquals(bool, String.valueOf(isFound));
    }
}
