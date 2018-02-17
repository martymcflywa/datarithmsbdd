Meta:

Narrative:
As a user of the Stack class
I want to use the stack to reverse words
So that I can prove that the Stack is FILO

Scenario: Stack reverse word
Given <word> is stored in the stack
When I pop the stack
Then the order of the word is reversed to <reverse>

Examples:
| word     | reverse  |
| desserts | stressed |
| god      | dog      |
| live     | evil     |
| lived    | devil    |
| knits    | stink    |
| regal    | lager    |
| pupils   | slipup   |
| raw      | war      |
| smart    | trams    |
| pals     | slap     |
| snug     | guns     |
| straw    | warts    |
| time     | emit     |
| deliver  | reviled  |
| star     | rats     |
| spoons   | snoops   |
| wow      | wow      |
| mum      | mum      |
| 01234    | 43210    |
