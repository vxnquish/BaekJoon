import sys
input = sys.stdin.readline

M = int(input())
S = 0
out = []
for _ in range(M):
    cmd =* input().split(), 
    c = cmd[0]
    if c == "add":
        x = int(cmd[1]); S |= 1 << x
    elif c == "remove":
        x = int(cmd[1]); S &= ~(1 << x)
    elif c == "check":
        x = int(cmd[1]); out.append("1" if S & (1 << x) else "0")
    elif c == "toggle":
        x = int(cmd[1]); S ^= 1 << x
    elif c == "all":
        S = (1 << 21) - 2
    else:
        S = 0
print("\n".join(out))
