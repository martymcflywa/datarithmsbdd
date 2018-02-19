Meta:

Narrative:
As a MergeSort class user
I want to sort some data
So that I can prove that MergeSort works

Scenario: Sorting strings
Given a collection of items:
|items|
|golf|
|hotel|
|alfa|
|india|
|romeo|
|foxtrot|
When I sort the collection
Then the collection is sorted:
|items|
|alfa|
|foxtrot|
|golf|
|hotel|
|india|
|romeo|