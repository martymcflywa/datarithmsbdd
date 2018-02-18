import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class BsTreeOrderSteps {

    private BsTree bsTree;
    private List order;

    @Given("the numbers are stored in the bstree: $numbers")
    public void theNumbersAreStoredInTheBsTree(ExamplesTable numbers) {

        bsTree = new BsTree<Integer>();

        for (Map<String, String> row : numbers.getRows()) {
            bsTree.insert(Integer.valueOf(row.get("numbers")));
        }
    }

    @When("I traverse the tree pre order")
    public void iTraverseTheTreePreOrder() {
        order = bsTree.preOrder();
    }

    @Then("traversal is pre order: $preOrder")
    public void traversalIsPreOrder(ExamplesTable preOrder) {

        List expected = new ArrayList<Integer>();

        for (Map<String, String> row : preOrder.getRows()) {
            expected.add(Integer.valueOf(row.get("preOrder")));
        }

        assertEquals(expected, order);
    }

    @When("I traverse the tree in order")
    public void iTraverseTheTreeInOrder() {
        order = bsTree.inOrder();
    }

    @Then("traversal is in order: $inOrder")
    public void traversalIsInOrder(ExamplesTable inOrder) {

        List expected = new ArrayList<Integer>();

        for (Map<String, String> row : inOrder.getRows()) {
            expected.add(Integer.valueOf(row.get("inOrder")));
        }

        assertEquals(expected, order);
    }

    @When("I traverse the tree post order")
    public void iTraverseTheTreePostOrder() {
        order = bsTree.postOrder();
    }

    @Then("traversal is post order: $postOrder")
    public void traversalIsPostOrder(ExamplesTable postOrder) {

        List expected = new ArrayList<Integer>();

        for (Map<String, String> row : postOrder.getRows()) {
            expected.add(Integer.valueOf(row.get("postOrder")));
        }

        assertEquals(expected, order);
    }
}
