Meta:

Narrative:
As a user of the Queue class
I want to use the queue to maintain the order of words
So that I can prove that the Queue is FIFO

Scenario: Queue maintain word order
Given word <word> is stored in the queue
When I remove all characters from the queue
Then word maintains same order as <expected>

Examples:
| word     | expected |
| desserts | desserts |
| god      | god      |
| live     | live     |
| lived    | lived    |
| knits    | knits    |
| regal    | regal    |
| pupils   | pupils   |
| raw      | raw      |
| smart    | smart    |
| pals     | pals     |
| snug     | snug     |
| straw    | straw    |
| time     | time     |
| deliver  | deliver  |
| star     | star     |
| spoons   | spoons   |
| wow      | wow      |
| mum      | mum      |
| 01234    | 01234    |