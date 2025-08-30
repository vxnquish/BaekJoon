import sys

def find(p, x):
    while p[x] != x:
        p[x] = p[p[x]]
        x = p[x]
    return x

def union(p, r, a, b):
    a = find(p, a)
    b = find(p, b)
    if a == b: 
        return
    if r[a] < r[b]:
        p[a] = b
    elif r[a] > r[b]:
        p[b] = a
    else:
        p[b] = a
        r[a] += 1

input = sys.stdin.readline

n, m = map(int, input().split())
p = list(range(n + 1))
r = [0] * (n + 1)
out = []

for _ in range(m):
    t, a, b = map(int, input().split())

    if t == 0:
        union(p, r, a, b)
    else:
        out.append("YES" if find(p, a) == find(p, b) else "NO")
        
print("\n".join(out))
