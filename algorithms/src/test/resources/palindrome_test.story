Scenario: Testing palindrome
Given a word <word>
When I check if word is a palindrome
Then the word is a palindrome <bool>

Examples:
|word|bool|
|anna|true|
|civic|true|
|kayak|true|
|noon|true|
|radar|true|
|stats|true|
|true|false|
|false|false|
|z|true|
||true|