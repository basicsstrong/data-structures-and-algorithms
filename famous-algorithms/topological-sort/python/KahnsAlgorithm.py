from collections import defaultdict


class Graph:

    def __init__(self, vertices):
        self.v = vertices
        self.adj = defaultdict(list)

    def add_edge(self, u, v):
        self.adj[u].append(v)

    def topological_sort(self):
        in_degree = [0] * self.v

        for i in self.adj:
            for j in self.adj[i]:
                in_degree[j] += 1

        # creating queue
        q = []
        for i in range(self.v):
            if in_degree[i] == 0:
                q.append(i)

        c = 0
        linear_order = []

        # One by one pop vertices from queue and append adjacents if indegree of adjacent becomes 0

        while q:
            x = q.pop()
            linear_order.append(x)
            for vertex in self.adj[x]:
                in_degree[vertex] -= 1
                if in_degree[vertex] == 0:
                    q.append(vertex)
            c += 1

        # check for negative cycle | print the linear order

        if c != self.v:
            print('Graph contains -ve cycle')
            return
        print('linear order is: ', linear_order)


g = Graph(5);
g.add_edge(0, 1);
g.add_edge(0, 3);
g.add_edge(1, 2);
g.add_edge(3, 1);
g.add_edge(3, 2);
g.add_edge(3, 4);

g.topological_sort();