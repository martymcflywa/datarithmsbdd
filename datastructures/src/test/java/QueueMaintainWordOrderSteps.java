import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.junit.Assert.assertEquals;

public class QueueMaintainWordOrderSteps {

    private Queue queue;
    private char[] removed;

    @Given("word <word> is stored in the queue")
    public void wordIsStoredInTheQueue(@Named("word") String word) {

        queue = new Queue<Character>();

        for (char c : word.toCharArray()) {
            queue.add(c);
        }
    }

    @When("I remove all characters from the queue")
    public void iRemoveAllCharactersFromTheQueue() {

        int size = queue.count();
        removed = new char[size];

        for (int i = 0; i < size; i++) {
            removed[i] = (char) queue.remove();
        }
    }

    @Then("word maintains same order as <expected>")
    public void wordMaintainsSameOrderAsExpected(@Named("expected") String expected) {
        String actual = new String(removed);
        assertEquals(expected, actual);
    }
}
