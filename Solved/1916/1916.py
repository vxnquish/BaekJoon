import sys, heapq
input = sys.stdin.readline

N = int(input())
M = int(input())
g = [[] for _ in range(N + 1)] # g[a] = 도시 a에서 출발하는 (목적지, 비용) 쌍들의 리스트

for _ in range (M):
    a, b, c = map(int, input().split()) # 버스의 정보 (출발, 도착, 비용)
    g[a].append((b, c))

s, t = map(int, input().split()) # 출발점의 도시번호와 도착점의 도시번호

INF = 10**18
dist = [INF] * (N + 1) # dist[i] = 시작점 s에서 도시 i까지의 현재까지 알려진 최소 비용
dist[s] = 0
pq = [(0, s)] # pq : 우선순위 큐 (현재까지 비용, 노드) 형태

while pq:
    d, x = heapq.heappop(pq)
    
    if d!= dist[x]:
        continue
    if x == t:
        break
    for y, w in g[x]:
        nd = d + w
        if nd < dist[y]:
            dist[y] = nd
            heapq.heappush(pq, (nd, y))

print(dist[t])