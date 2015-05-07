import sys


def insert(val, heap):
    heap.append(val)
    curr = len(heap) - 1
    par = curr//2
    while (heap[curr] > heap[par]) and curr != 1:
        temp = heap[par]
        heap[par] = heap[curr]
        heap[curr] = temp
        curr = par
        par = curr//2


def extract(heap):
    if len(heap) < 2:
        return None
    retval = heap[1]
    #print(heap)
    #print('heap[-1] = ', heap[-1])
    heap[1] = heap[-1]
    #print('after move h[1] = ', heap[1])
    #print(heap)
    del heap[-1]
    #print('after removal', heap)
    curr = 1
    cl = curr*2
    cr = cl + 1
    while cr < len(heap):
        if heap[curr] < heap[cl] or heap[curr] < heap[cr]:

            if heap[cl] > heap[cr]:
                temp = heap[curr]
                heap[curr] = heap[cl]
                heap[cl] = temp
                curr = cl
            else:
                temp = heap[curr]
                heap[curr] = heap[cr]
                heap[cr] = temp
                curr = cr
        else:
            break

        cl = curr*2
        cr = cl + 1

    if cl < len(heap):
        #print('entered here')
        #print('curr = ', curr)
        #print('cl = ', cl)
        #print('heap[curr] = ', heap[curr])
        #print('heap[cl] = ', heap[cl])
        if heap[curr] < heap[cl]:
            #print('switching')
            temp = heap[curr]
            heap[curr] = heap[cl]
            heap[cl] = temp

    return retval


def main():
    heap = []
    heap.append(float('inf'))
    data = dataset.split("\n")
    n = int(data[0])
    for i in range(n):
        a = data[i+1].split()
        if (a[0] == "Insert"):
            yourinsert(a[1])
        else:
            yourextract()
    # n = int(sys.stdin.readline()[:-1])
    # for i in range(n):
    #     line = sys.stdin.readline()[:-1]
    #     #print line
    #     spline = line.split(' ')
    #     #print spline
    
    #     if spline[0] == 'Insert':
    #         insert(int(spline[1]), heap)
        
    #     elif spline[0] == 'Extract':
    #         extracted = extract(heap)
    #         if extracted is not None:
    #             print(extracted)

        #print('Heap = ', heap)

main()