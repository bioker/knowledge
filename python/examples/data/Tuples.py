#!/usr/bin/env python3.5
print('Tuples:')

t = 1,2,3

print(t)

print('Nested tuples')
tt = t, 4,5,6

print(tt)

try:
    tt[2] = 1
except Exception:
    print('Tuples are immutable')

ttt = 1,2,[3,4,5]

print(ttt)

print('Tuples can contains mutable objects')
ttt[2][2] = 0

print(ttt)

print('Unpacking sequence')
x,y,z = t
print(x,y,z)
