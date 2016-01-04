
public class Dijkstra {

	final int INFINITY = Integer.MAX_VALUE;
	
	public int[] previous; 		// spanning tree
	public int [] distance; 	//(assumed to be non-negative integers)
	public WeightedGraph G;
	public int start;
	
	public Dijkstra(WeightedGraph G, int s) {
		this.G = G;
		start = s;
		previous = new int[G.numVerts()]; 
		distance = new int[G.numVerts()]; 
		for (int i = 0; i < distance.length; i++) {
			distance[i] = INFINITY;
			previous[i] = -1;
		}
	}
	
	public void search() {
		PoorMansPriorityQueue<Integer, Integer> Q = new PoorMansPriorityQueue<>();
		int N = G.numVerts();
		for (int i = 0; i < N; i++) {
			if (i == start) {
				Q.insert(i, 0);
			} else {
				Q.insert(i, INFINITY);
			}
		}
		while (!Q.isEmpty()) {
			int v = Q.deleteMin();
			int d = distance[v];
			for (int w : G.adjacents(v)) {
				int dist = d + G.weight(v, w);	/// XXX if d == INF trouble
				if (dist < distance[w]) {
					Q.decreaseKey(w, distance[w], dist);
					distance[w] = dist;
					previous[w] = v;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
	}
	
}
