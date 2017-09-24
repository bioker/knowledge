# Stream EDitor

+ [Back](../README.md)

## How it works

+ Read input (stdin, file, pipe) to **pattern buffer**
+ Execute SED command on the **pattern buffer**
+ Display modified content to the output stream

## How to launch

+ `sed [-n] [-e] 'command(s)' files`
+ `sed [-n] -f scriptfile files`
