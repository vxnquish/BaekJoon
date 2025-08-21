N, K = map(int, input().split())
a = -1

for x in range(N + 1):
    if x * (N - x) >= K:
        a = x
        break

if a == -1:
    print(-1)

else:
    b = N - a
    moves = a * b - K
    pre = [0] * a

    for i in range(a - 1, -1, -1):
        t = min(moves, b)
        pre[i] = t
        moves -= t
    
    usedB = 0
    out = []

    for i in range(a):
        out.append('B' * pre[i]); usedB += pre[i]
        out.append('A')
    out.append('B' * (b - usedB))

    print(''.join(out))