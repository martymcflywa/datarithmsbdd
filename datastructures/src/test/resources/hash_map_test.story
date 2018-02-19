Meta:

Narrative:
As a HashMap class user
I want to store and retrieve data
So that I can prove the hash map works

Scenario: Put key value pairs in the hash map where the keys don't exist
Given a set of key value pairs:
|key|val|
|k1|v1|
|k2|v2|
|k3|v3|
And the keys don't exist
When I store the key value pairs in the hash map
Then nothing is returned

Scenario: Put key value pairs in the hash map where the keys exist
Given a set of key value pairs:
|key|val|
|k1|new1|
|k2|new2|
|k3|new3|
And the keys already exist:
|key|val|
|k1|old1|
|k2|old2|
|k3|old3|
When I store the key value pairs in the hash map
Then the values are returned:
|val|
|old1|
|old2|
|old3|

Scenario: Remove keys from the hash map where the keys don't exist
Given a set of key value pairs:
|key|val|
|k1|v1|
|k2|v2|
|k3|v3|
And the keys don't exist
When I remove the keys from the hash map
Then nothing is returned

Scenario: Remove keys from the hash map where the keys exist
Given a set of key value pairs:
|key|val|
|k1|new1|
|k2|new2|
|k3|new3|
When I store the key value pairs in the hash map
And I remove the keys from the hash map
Then the values are returned:
|val|
|new1|
|new2|
|new3|

Scenario: Retrieve keys from the hash map where the keys don't exist
Given a set of key value pairs:
|key|val|
|k1|v1|
|k2|v2|
|k3|v3|
And the keys don't exist
When I retrieve the keys from the hash map
Then nothing is returned

Scenario: Retrieve keys from the hash map where the keys exist
Given a set of key value pairs:
|key|val|
|k1|new1|
|k2|new2|
|k3|new3|
When I store the key value pairs in the hash map
And I retrieve the keys from the hash map
Then the values are returned:
|val|
|new1|
|new2|
|new3|