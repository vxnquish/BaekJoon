import sys
input = sys.stdin.readline
n = int(input())

def solve(nums):
    nums = nums[::-1]
    a = [0] * (n + 1)

    for i in range(n - 1, -1, -1):
        a[i] = a[i + 1] + nums[i]

    dp = [0] * (n + 1)
    INF = 10 ** 18

    for k in range(n - 1, -1, -1):
        best = INF

        for i in range(k, n):
            seg = a[k] - a[i + 1]
            val = seg - dp[i + 1]

            if val < best:
                best = val
        dp[k] = best

    if dp[0] < 0:  return 'A'
    if dp[0] > 0:  return 'B'

    return 'D'

out = []

for _ in range(3):
    nums = list(map(int, input().split()))
    out.append(solve(nums))

print("\n".join(out))
