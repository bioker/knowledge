#!/usr/bin/env python3.5
print('Strings:')

s1 = "That's it"
s2 = '"Just like that"'
s3 = 'That\'s it'
s4 = "\"Just like that\""
s5 = "\"Just \nlike that\""
s6 = r'"Just \nlike that"'
s7 = """
Here 
you
are
"""
s8 = '''
Here 
you
are
'''
s9 = '''\
Here 
you
are
'''

print(s1)
print(s2)
print(s3)
print(s4)
print(s5)
print(s6)
print(s7)
print(s8)
print(s9)
print('It will be ' 'concateneted')
print(s1 + ' ' + s2)
print(s1[0])
print(s1[1])
print(s1[-1])
print(s1[0:5])
print(s1[:5])
print(s1[2:])
print(s1[2:][0])
print(len(s1))
