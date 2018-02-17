import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.junit.Assert.assertEquals;

public class StackReverseWordSteps {

    private Stack stack;
    private char[] popped;

    @Given("<word> is stored in the stack")
    public void wordIsStoredInTheStack(@Named("word") String word) {

        stack = new Stack<Character>();

        for (char c : word.toCharArray()) {
            stack.push(c);
        }
    }

    @When("I pop the stack")
    public void iPopTheStack() {

        int size = stack.count();
        popped = new char[size];

        for (int i = 0; i < size; i++) {
            popped[i] = (char) stack.pop();
        }
    }

    @Then("the order of the word is reversed to <reverse>")
    public void theOrderOfTheWordIsReversedTo(@Named("reverse") String reverse) {
        String actual = new String(popped);
        assertEquals(reverse, actual);
    }
}
