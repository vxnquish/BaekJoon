import sys
input = sys.stdin.readline

n = int(input())
lines = []

for _ in range(n):
    a, b, = map(int, input().split())
    if a > b:
        a, b = b, a
    lines.append((a, b))

lines.sort()

cl, cr = lines[0]
ans = 0

for l, r in lines[1:]:
    if l > cr:
        ans += cr - cl
        cl, cr = l, r
    else:
        if r > cr:
            cr = r

ans += cr - cl
print(ans)