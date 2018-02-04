#!/usr/bin/env python3.5
print('Loop control:')
print('break loop:')
i = 0
while i < 10:
    i += 1
    if i == 4:
        print('there is no place for 4 number')
        continue
    print(i)
    if i == 5:
        break
while i < 1:
    pass # do nothing
else:
    print('loop condition is false')
