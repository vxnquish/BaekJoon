n = int(input())

l = r = 1
s = 1
cnt = 0

while l <= n:
    if s == n: 
        cnt += 1
        r += 1
        s += r
    elif s < n:
        r += 1
        s += r
    else:
        s -= l
        l += 1
print(cnt)