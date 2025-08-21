n = int(input())
switches = [0] + list(map(int, input().split()))
m = int(input())

for _ in range(m):
    gender, num = map(int, input().split())
    if gender == 1: # Boys
        for i in range(num, n + 1, num):
            if switches[i] == 0:
                switches[i] = 1
            else:
                switches[i] = 0
    else: # Girls
        if switches[num] == 0:
            switches[num] = 1
        else:
            switches[num] = 0
        
        k = 1
        while num - k > 0 and num + k <= n and switches[num - k] == switches[num + k]:
            if switches[num-k] == 0:
                switches[num-k] = 1
                switches[num+k] = 1
            else:
                switches[num-k] = 0
                switches[num+k] = 0
            k += 1

for i in range(1, n + 1):
    print(switches[i], end = " ")
    if i % 20 == 0:
        print()
