# put your python code here
import sys
import __future__
from math import log, ceil

def findMin(root, ss, se, qs, qe, tree):
    if qs <= ss and qe >= se:
        return tree[root]

    if qs >= ss and qe <= se:
        return float('inf')

    mid = (ss + se)//2
    left = findMin(root*2, ss, mid, qs, qe, tree)
    right = findMin(root*2+1, mid+1, se, qs, qe, tree)
    return min(left, right)

def setVal(i, val, tree):
    tree[i] = val

def construct_tree(leaves):
    tree = [None]*(2*len(leaves))
    tree[0] = ''
    for i in reversed(range(1, len(tree))):
        if len(leaves) != 0:
            tree[i] = leaves.pop()
            continue
        tree[i] = min(tree[i*2], tree[i*2 + 1])

    return tree


def main():
    [n, m] = map(int, sys.stdin.readline()[:-1].split())
    leaves = map(int, sys.stdin.readline()[:-1].split())
    dl = int(pow(2, ceil(log(len(leaves), 2))))
    for i in range(dl - len(leaves)):
        leaves.append(float('inf'))
    
    tree = construct_tree(leaves)

    for i in range(m):
        line = sys.stdin.readline()[:-1].split()
        if line[0] == 'Min':
            print findMin(1, 1, n, line[1], line[2], tree)
            continue
        elif line[0] == 'Set':
            setVal(line[1], line[2], tree)
        
if __name__ == '__main__':
    main()