#!/usr/bin/env python3.5
print('Lists:')

test = []

print('Append the element')
test.append('1')

print(test)

print('Append several elements')
test.extend([1,2,3])

print(test)

print('Insert the element at the index')
test.insert(0, '2')

print(test)

print('Delete the element at the index')
test.remove(1)

print(test)

try:
    test.remove(10)
except Exception:
    print('error when remove non existent element from list')

print('Extract the element by the index (and delete it from the list)')
print(test.pop(1))

print(test)

print('Extract the last element (and delete it from the list)')
print(test.pop())

print(test)

print('Find an index of the element')
print(test.index(2))

try:
    test.index(10)
except Exception:
    print('error when trying to get non existent element index from list')

test.extend([9,9,9])

print('Get amount of the elements with the same value')
print(test.count(9))

print('Clear the list')
test.clear()

print(test)

test = [3,1,2]

print('Sort the list')
test.sort()
print(test)
test.sort(reverse=True)
print(test)

print('Get the shallow copy of the list')
print(test.copy())

test.clear()

print('List as Stack')
test.append(1)
test.append(2)
test.append(3)
print(test)
test.pop()
test.pop()
test.pop()
print(test)

print('List as Queue')
from collections import deque
test = deque([])
test.append(1)
test.append(2)
test.append(3)
print(test)
test.popleft()
print(test)
test.popleft()
test.popleft()
print(test)

test = [1,2,3,4,5]

print('Delete items with del')
del test[1]
print(test)

del test[1:3]
print(test)

del test[:]
print(test)

print('List comprehensions')

test = [x**2 for x in range(10)]
print(test)
test = [x*y for x in range(10) for y in range(10)]
print(test)
