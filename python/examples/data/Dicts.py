#!/usr/bin/env python3.5
print('Dicts:')

d = {
        '1':1,
        '2':2,
        '3':3,
}

print(d)

print('Add element to dict')
d['4'] = 4
print(d)

print('Delete element from dict')
del d['4']
print(d)

print('Get element from dict')
print(d['1'])

try:
    print(d['5'])
except Exception:
    print('Error while getting element by non existed key')

print('Check key is exist in dict')
print('1' in d)
