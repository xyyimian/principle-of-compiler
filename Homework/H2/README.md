# H2

## introduction
the program is written in C++.

## Usage
this program has following functions:
- match source string with regular expression "aa*|bb*"
- print substring and their start position
- skip undefined character and otuput a warning "Unknown Character"

## Building
Initialization:input a string and define an iterator
A circulation to traverse the string
A state machine


## Principle
There is a outer circulation scanning the whole string for one pass. We use iterator to traverse the string.
In the circulation it is a state machine. 

* When it encounters some undefinite divisions, it selects one of paths and marks it.
* When it encounters a character fitted in regex, it transfers to another state;
* When it encounters a character not fitted:
  * if it is a terminal state, output string found and go back to the first state and clear mark array at the same time.
  * if it is not a terminal state, the iterator retraces and goes back to last state and try to select another path.
    * if there is still another path, select it.
    * if not, output error message.
* When traverse ends, if there is a remaining substring, output.

## Example
Take string "aaab" as an example.
The state machine's transferred sequence is as followed:

```
state[0] --> state[1] --> state[3] --> state[3] -->
state[3] --> state[0]
(have read 'b', output "aaa", retrace)
-->state[1] -->state[0] -->state[2] -->state[4]
(the string has ended)
output 'b'
```


