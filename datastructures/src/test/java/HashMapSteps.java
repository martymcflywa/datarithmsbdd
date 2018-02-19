import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class HashMapSteps {

    private HashMap<String, String> hashMap;
    private Map<String, String> input;
    private List<String> returns;

    @Given("a set of key value pairs: $keyValuePairs")
    public void aSetOfKeyValuePairs(ExamplesTable keyValuePairs) {
        input = new java.util.HashMap<>();
        for (Map<String, String> row : keyValuePairs.getRows()) {
            input.put(row.get("key"), row.get("val"));
        }
    }

    @Given("the keys don't exist")
    public void theKeyDoesntExist() {
        hashMap = new HashMap<>();
    }

    @Given("the keys already exist: $keyValuePairs")
    public void theKeysAlreadyExist(ExamplesTable keyValuePairs) {
        hashMap = new HashMap<>();
        for (Map<String, String> row : keyValuePairs.getRows()) {
            hashMap.put(row.get("key"), row.get("val"));
        }
    }

    @When("I store the key value pairs in the hash map")
    public void iStoreTheKeyValuePairsInTheHashMap() {
        returns = new ArrayList<>();
        for (Map.Entry<String, String> entry : input.entrySet()) {
            returns.add(hashMap.put(entry.getKey(), entry.getValue()));
        }
    }

    @When("I remove the keys from the hash map")
    public void iRemoveTheKeysFromTheHashMap() {
        returns = new ArrayList<>();
        for (Map.Entry<String, String> entry : input.entrySet()) {
            returns.add(hashMap.remove(entry.getKey()));
        }
    }

    @When("I retrieve the keys from the hash map")
    public void iRetrieveTheKeysFromTheHashMap() {
        returns = new ArrayList<>();
        for (Map.Entry<String, String> entry : input.entrySet()) {
            returns.add(hashMap.get(entry.getKey()));
        }
    }

    @Then("nothing is returned")
    public void nothingIsReturned() {
        for (String item : returns) {
            assertNull(item);
        }
    }

    @Then("the values are returned: $values")
    public void theValuesAreReturned(ExamplesTable values) {
        List<String> expected = new ArrayList<>();
        for (Map<String, String> row : values.getRows()) {
            expected.add(row.get("val"));
        }
        assertEquals(expected, returns);
    }
}
