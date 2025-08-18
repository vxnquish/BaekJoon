n = int(input())
a = list(map(int, input().split()))
m = max(a)
print(sum(a) / n / m * 100)
