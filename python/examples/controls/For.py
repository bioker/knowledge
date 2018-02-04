#!/usr/bin/env python3.5
print('For:')

for w in ['first', 'second', 'third']:
    print(w, len(w))

# For changing target list use slice copy

words = ['first', 'second', 'third']

for w in words[:]:
    if w == 'first':
        words.append(w)
print(words)

print("range to number:")
for i in range(5):
    print("it will be printed 5 times")
print("range between numbers:")
for i in range(5,10):
    print(i)
print("range between numbers with step:")
for i in range(0,10,3):
    print(i)
print("range with len for list iteration:")
for i in range(len(words)):
    print(i,words[i])
