T = int(input())
if T % 10: print(-1)
else:
    a, b, c = 0, 0, 0
    a = T // 300; T %= 300
    b = T // 60; T %= 60
    c = T // 10
    print(a, b, c)
