#!/usr/bin/env python3.5
print('Sets:')

basket = {'1','2','3','1','4','5'}

print('Sets contains only unique elements')
print(basket)

print('Check presence in sequence')
print('1' in basket)

print('Sets can be created from strings')

a = set('asdfasdf')
b = set('abcd')
c = set('qwerty')

print(a)

print('Operations with Sets')

print('Complements (substraction)')
print(a - b)

print('Union (add)')
print(a | b)

print('Intersections (in common)')
print(a | b)

print('Symmetric difference (unique for each set)')
print(a ^ b)
