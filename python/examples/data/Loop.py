#!/usr/bin/env python3.5
print('Loop with data:')

s = [1,2,3]

print('Loop through sequence')
for e in s:
    print(e)

print('Loop through sequence with indexes')
for i, e in enumerate(s):
    print(i, e)

d = {'1':'one', '2':'two', '3':'three'}

print('Loop through dict')
for i in d:
    print(i)
print('Loop through dict with keys')
for k,v in d.items():
    print(k, v)

s2 = [4,5,6]
print('Loop through two sequences')
for x, y in zip(s, s2):
    print(x,y)

print('Loop through sequence with reversing')
for i in reversed(s):
    print(i)

s3 = [1,6,3,2,7]
print('Loop through sequence with sorting')
for i in sorted(s3):
    print(i)
