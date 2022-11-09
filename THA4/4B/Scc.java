//XI Huijia, A0220056W
import java.util.*;

class Scc {
	public int numOfVertices;
	public ArrayList< ArrayList<Integer> > adjList = new ArrayList< ArrayList<Integer> >();
	public static ArrayList<Integer> result = new ArrayList<Integer>();

	Scc(int numOfVertices) {
		this.numOfVertices = numOfVertices;
		for (int i = 0; i <= numOfVertices; i++) {
			adjList.add(new ArrayList<Integer>());
			result.add(-1);
		}
	}

	void add(int vertex, int neighbor) {
		this.adjList.get(vertex).add(neighbor);
	}

	void dfs(int vertex, boolean visited[]) {
		visited[vertex] = true;

		ArrayList<Integer> neighbors = adjList.get(vertex);

		int current;
		Iterator<Integer> temp = neighbors.iterator();
		while (temp.hasNext()) {
			current = temp.next();
			if (visited[current] == false) {
			    result.set(current, vertex); 				
				dfs(current, visited);
			}
		}
	}

	Scc transpose() {
		Scc graph = new Scc(numOfVertices);
		for(int i = 1; i <= numOfVertices; i++) {
			Iterator<Integer> temp = this.adjList.get(i).listIterator();
			while (temp.hasNext()) {
				graph.adjList.get(temp.next()).add(i);
			}
		}
		return graph;
	}

	void order(int vertex, boolean visited[], Stack stack) {
		visited[vertex] = true;

		Iterator<Integer> temp = this.adjList.get(vertex).iterator();
		while(temp.hasNext()) {
			int current = temp.next();
			if(visited[current] == false) {
				order(current, visited, stack);
			}
		}
		stack.push(vertex);
	}

	int count() {
		Stack stack = new Stack();
		boolean visited[] = new boolean[numOfVertices+1];
		for(int i = 1; i <= numOfVertices; i++) {
			visited[i] = false;
		}

		for(int i = 1; i <= numOfVertices; i++) {
			if (visited[i] == false) {
				this.order(i, visited, stack);
			}
		}

		Scc transposed = this.transpose();
		for(int i = 1; i <= numOfVertices; i++) {
			visited[i] = false;
		}

		int num = 0;
		while (!stack.isEmpty()) {
			int vertex = (int)stack.pop();

			if (visited[vertex] == false) {
				num ++;
				transposed.dfs(vertex, visited);				
			}
		}
		return num;
	}
}