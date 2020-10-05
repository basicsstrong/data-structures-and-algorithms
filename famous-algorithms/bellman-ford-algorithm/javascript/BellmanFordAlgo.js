class Graph {
    constructor(totalVertices) {
        this.edges = [];
        this.totalVertices = totalVertices;
    }

    addEdge(source, destination, weight) {

        const totalPossibleEdges = this.totalVertices * (this.totalVertices - 1);

        if (totalPossibleEdges && totalPossibleEdges > this.edges.length) {
            this.edges.push(new Edge(source, destination, weight));
        }
    }

    // Bellman Ford
    shortestDistance(source) {
        const distanceFromSource = new Array(this.totalVertices).fill(Number.MAX_SAFE_INTEGER);
        distanceFromSource[source] = 0;

        console.log(distanceFromSource);

        distanceFromSource.forEach(() => {
            this.edges.forEach(edge => {
                const u = edge.source;
                const v = edge.destination;
                const c = edge.weight;
                if (distanceFromSource[u] !== Number.MAX_SAFE_INTEGER && distanceFromSource[u] + c < distanceFromSource[v])
                    distanceFromSource[v] = distanceFromSource[u] + c;
            });
        });

        console.log(distanceFromSource);

        this.edges.forEach((edge) => {
            const u = edge.source;
            const v = edge.destination;
            const c = edge.weight;

            if (distanceFromSource[u] != Number.MAX_SAFE_INTEGER && distanceFromSource[u] + c < distanceFromSource[v]) {
                console.log("Graph containes -ve cycle.");
                return;
            }
        });

        distanceFromSource.forEach((e, i) => {
            console.log(i + " : " + distanceFromSource[i]);
        });
    }
}

class Edge {
    constructor(source, destination, weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}

const graph = new Graph(6);

graph.addEdge(0, 1, 8);
graph.addEdge(0, 5, 5);
graph.addEdge(0, 3, 3);
graph.addEdge(1, 2, 6);
graph.addEdge(2, 4, 4);
graph.addEdge(3, 4, -1);
graph.addEdge(5, 1, -4);
graph.addEdge(5, 2, -1);
graph.addEdge(5, 4, -3);
graph.shortestDistance(0);
console.log(graph);