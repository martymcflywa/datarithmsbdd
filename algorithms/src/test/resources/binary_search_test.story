Scenario: Testing binary search
Given a collection of alphabetically sorted words:
|words|
|alfa|
|bravo|
|charlie|
|delta|
|echo|
|foxtrot|
When I search for a target <target>
Then the target was found: <bool>

Examples:
|target|bool|
|alfa|true|
|charlie|true|
|foxtrot|true|
|sierra|false|
|whiskey|false|
|tango|false|