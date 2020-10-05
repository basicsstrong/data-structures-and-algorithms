class Graph:

    def __init__(self, v):
        self.v = v
        self.graph = []

    def add_edge(self, s, d, w):
        self.graph.append([s,d,w])

    def bellman_ford(self, src):

        dist = [float('inf')]* self.v
        dist[src] = 0

        # Relax v-1

        for i in range(self.v - 1):
            for u, v, c in self.graph:
                if dist[u] != float('inf') and dist[u] + c < dist[v]:
                    dist[v] = dist[u] + c

        # - ve cycles
        for u, v, c in self.graph:
            if dist[u] != float('inf') and dist[u] + c < dist[v]:
                print('Graph contains -ve cycle')

        print("vertex distance from the source :")

        for i in range(self.v):
            print(i, ' : ', dist[i])


g = Graph(6)
g.add_edge(0, 1, 8)
g.add_edge(0, 5, 5)
g.add_edge(0, 3, 3)
g.add_edge(1, 2, 6)
g.add_edge(2, 4, 4)
g.add_edge(3, 4, -1)
g.add_edge(5, 1, -4)
g.add_edge(5, 2, -1)
g.add_edge(5, 4, -3)
g.bellman_ford(0)

