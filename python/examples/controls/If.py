#!/usr/bin/env python3.5
print('If:')

x = int(input("Enter integer: "))

if x < 0:
    print("number less than 0")
elif x == 0:
    print("number equal 0")
else:
    print("number more than 0")

y = 1

if y in [1,2,3]:
    print('element in array')
