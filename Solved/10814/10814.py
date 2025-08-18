import sys
n = int(sys.stdin.readline())

arr = [tuple(sys.stdin.readline().split()) for _ in range(n)]
arr = [(int(a), b) for a, b in arr]

arr.sort(key = lambda x : x[0])

for a, b in arr: print(a, b)

