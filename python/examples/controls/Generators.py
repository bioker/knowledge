#!/usr/bin/env python3.5
print('Generators:')

def firstn_simple(n):
    num = 1
    nums = []
    while num <= n:
        nums.append(num)
        num += 1
    return nums

print('Sum of first 5 numbers: ' + str(sum(firstn_simple(5))))

print("If amoun of elements too big for memory - use generator (iterator)")

def firstn_generator(n):
    num = 1
    while num < n:
        yield num
        num += 1

print('Sum of first 100 numbers: ' + str(sum(firstn_generator(100))))
