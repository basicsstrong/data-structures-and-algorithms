class Graph{  
    
    constructor(numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
        this.adjacencyList = [];
        
        for (let i = 0; i < this.numberOfVertices; i++) {
            this.adjacencyList[i] = []
        }
    }
    
    addEdge(u, v) {
        this.adjacencyList[u].push(v);  
    }

    topologicalSort() {
        
        const indegree = new Array(this.numberOfVertices).fill(0);
        
        for (let i = 0; i < this.numberOfVertices; i++) {

            console.log(this.adjacencyList);
            
            //indegree
            
            this.adjacencyList[i].forEach(vertex =>indegree[vertex]=indegree[vertex]+1);
            
        }
        
        //the vertex that we are selecting
        
        const queue = [];
        
        for (let i = 0; i < this.numberOfVertices; i++) {
            //console.log(indegree);
            if(indegree[i] == 0)
            queue.unshift(i);
            console.log(queue)
        }
        
        //keep track of the number selected vertices
        let c = 0;
        
        const linearOrder = [];
        
        while(queue.length !== 0) {
            const x = queue.shift();
            linearOrder.push(x);
            
            this.adjacencyList[x].forEach(vertex => {
                if(--indegree[vertex] == 0)
                queue.unshift(vertex);
            });

            c++;
        }
        
        if(c != this.numberOfVertices) {
            console.log(c + "="+ this.numberOfVertices)
            console.log("Graph contains -ve cycle.");
            return;
        }
        
        console.log(" The Linear Order is :");
        
        linearOrder.forEach(e => console.log(e + " "));
        
    }

}


const graph = new Graph(5);
graph.addEdge(0, 1);
graph.addEdge(0, 3);
graph.addEdge(1, 2);
graph.addEdge(3, 1);
graph.addEdge(3, 2);
graph.addEdge(3, 4);

graph.topologicalSort();



