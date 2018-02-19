import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.junit.Assert.assertEquals;

public class PalindromeSteps {

    String input;
    boolean isPalindrome;

    @Given("a word <word>")
    public void aWord(@Named("word") String word) {
        input = word;
    }

    @When("I check if word is a palindrome")
    public void iCheckIfWordIsAPalindrome() {
        isPalindrome = Palindrome.isPalindromeIterative(input)
                && Palindrome.isPalindromeRecursive(input);
    }

    @Then("the word is a palindrome <bool>")
    public void theWordIsAPalindrome(@Named("bool") String bool) {
        assertEquals(bool, String.valueOf(isPalindrome));
    }
}
