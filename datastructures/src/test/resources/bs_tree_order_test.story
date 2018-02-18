Meta:

Narrative:
As a user of BsTree class
I want to assert preOrder, inOrder, postOrder output
So that I can prove that BsTree class functions correctly.

Scenario: Pre order traversal
Given the numbers are stored in the bstree:
|numbers|
|70|
|49|
|76|
|41|
|74|
|83|
When I traverse the tree pre order
Then traversal is pre order:
|preOrder|
|70|
|49|
|41|
|76|
|74|
|83|

Scenario: In order traversal
Given the numbers are stored in the bstree:
|numbers|
|70|
|49|
|76|
|41|
|74|
|83|
When I traverse the tree in order
Then traversal is in order:
|inOrder|
|41|
|49|
|70|
|74|
|76|
|83|

Scenario: Post order traversal
Given the numbers are stored in the bstree:
|numbers|
|70|
|49|
|76|
|41|
|74|
|83|
When I traverse the tree post order
Then traversal is post order:
|postOrder|
|41|
|49|
|74|
|83|
|76|
|70|
