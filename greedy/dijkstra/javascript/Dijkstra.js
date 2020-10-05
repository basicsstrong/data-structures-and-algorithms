const adjacencyMatrix = [
    [0, 3, 5, 6, 0, 8, 0],
    [3, 0, 0, 4, 2, 0, 5],
    [5, 0, 0, 0, 0, 4, 0],
    [6, 4, 0, 0, 0, 1, 6],
    [0, 2, 0, 0, 0, 0, 10],
    [8, 0, 6, 1, 0, 0, 8],
    [0, 8, 0, 6, 10, 8, 0]
]

function findMinVertex(distance, visited) {
    let minVertex = -1;
    for (let i = 0; i < distance.length; i++) {
        if (!visited[i] && (minVertex == -1 || distance[i] < distance[minVertex]))
            minVertex = i;
    }
    return minVertex;
}

function dijkstra(adjacencyMatrix) {

    var v = adjacencyMatrix.length;
    visited = new Array(v);
    distance = new Array(v);

    //start

    distance[0] = 0;

    for (let i = 1; i < v; i++) {
        distance[i] = Number.MAX_SAFE_INTEGER;
    }

    for (let i = 0; i < v - 1; i++) {

        let minVertex = findMinVertex(distance, visited);

        visited[minVertex] = true;

        for (let j = 0; j < v; j++) {

            if (adjacencyMatrix[minVertex][j] != 0 && !visited[j]) {
                let newDist = distance[minVertex] + adjacencyMatrix[minVertex][j];

                if (newDist < distance[j]) {
                    distance[j] = newDist;
                }
            }
        }
    }


    for (let i = 0; i < v; i++) {
        console.log(i + " " + distance[i]);
    }
}

dijkstra(adjacencyMatrix);
