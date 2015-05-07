import subprocess
from subprocess import PIPE
from random import random
from math import pow

n = int(random()*pow(10, 5))
input_str = str(n) + ' '
for _ in range(n):
    input_str += str(int(random()*pow(10, 9))) + ' '
input_str += '\n'

print 'input: '
print input_str

print "running Merge Method ... "

p = subprocess.Popen(['java', 'Main'], stdin=PIPE, stdout=PIPE)
output = p.communicate(input=input_str)[0]
print 'output: ' + output

print "running Naive Method ... "

p = subprocess.Popen(['java', 'NaiveNumInversions'], stdin=PIPE, stdout=PIPE)
output = p.communicate(input=input_str)[0]
print 'output: ' + output
