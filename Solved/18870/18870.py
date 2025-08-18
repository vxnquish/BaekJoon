n = int(input())

a = list(map(int, input().split()))
b = sorted(set(a))

idx = {v: i for i, v in enumerate(b)}

print(*[idx[v] for v in a])