// Java Program shows the implementation Dijkstra's Algorithm  
// Using the Priority Queue  

// import statement  
import java.util.*;

// Main class Dijkstra
public class transfare {

    // Member variables of the class
    private int fare[];
    private Set<Integer> settld;
    private PriorityQueue<Node> pQue;

    // Total count of the vertices
    private int totalNodes;
    List<List<Node>> adjacent;

    // Constructor of the class
    public transfare(int totalNodes) {

        this.totalNodes = totalNodes;
        fare = new int[totalNodes];
        settld = new HashSet<Integer>();
        pQue = new PriorityQueue<Node>(totalNodes, new Node());
    }

    public void dijkstra(List<List<Node>> adjacent, int s) {
        this.adjacent = adjacent;

        for (int j = 0; j < totalNodes; j++) {
            // initializing the fare of every node to infinity (a large number)
            fare[j] = Integer.MAX_VALUE;
        }

        // Adding the source node to pQue
        pQue.add(new Node(s, 0));

        // fare of the source is always zero
        fare[s] = 0;

        while (settld.size() != totalNodes) {

            // Terminating condition check when
            // the priority queue contains zero elements, return
            if (pQue.isEmpty()) {
                return;
            }

            // Deleting the node that has the minimum fare from the priority queue
            int ux = pQue.remove().n;

            // Adding the node whose fare is
            // confirmed
            if (settld.contains(ux)) {
                continue;
            }

            // We don't have to call eNeighbors(ux)
            // if ux is already present in the settled set.
            settld.add(ux);

            eNeighbours(ux);
        }
    }

    private void eNeighbours(int ux) {

        int edgeDist = -1;
        int newDist = -1;

        // All of the neighbors of vx
        for (int j = 0; j < adjacent.get(ux).size(); j++) {
            Node vx = adjacent.get(ux).get(j);

            // If the current node hasn't been already processed
            if (!settld.contains(vx.n)) {
                edgeDist = vx.fare;
                newDist = fare[ux] + edgeDist;

                // If the new fare is lesser in the cost
                if (newDist < fare[vx.n]) {
                    fare[vx.n] = newDist;
                }

                // Adding the current node to the priority queue pQue
                pQue.add(new Node(vx.n, fare[vx.n]));
            }
        }
    }

    // Main method
    public static void main(String argvs[]) {

        Scanner input = new Scanner(System.in);

        int totalNodes = 17;
        System.out.println("Enter starting node:");
        int s = input.nextInt();
        System.out.println("Enter end node:");
        int e = input.nextInt();

        int totalFare = 0;
        // representation of the connected edges
        // using the adjacency list
        // by declaration of the List class object

        // Declaring and object of the type List<Node>
        List<List<Node>> adjacent = new ArrayList<List<Node>>();

        // Initialize list for every node
        for (int i = 0; i < totalNodes; i++) {
            List<Node> itm = new ArrayList<Node>();
            adjacent.add(itm);
        }

        // adding the edges
        // The statement adjacent.get(0).add(new Node(1, 3)); means
        // to travel from node 0 to 1, one has to cover 3 units of fare
        // it does not mean one has to travel from 1 to 0
        // To travel from 1 to 0, we have to add the statement
        // adjacent.get(1).add(new Node(0, 3));
        // Note that the fare is the same i.e., 3 units in both the cases.
        // Similarly, we have added other edges too.

        adjacent.get(0).add(new Node(1, 20));
        adjacent.get(0).add(new Node(13, 11));
        adjacent.get(1).add(new Node(16, 10));
        adjacent.get(1).add(new Node(0, 20));
        adjacent.get(1).add(new Node(8, 9));
        adjacent.get(1).add(new Node(11, 20));
        adjacent.get(1).add(new Node(15, 15));
        adjacent.get(1).add(new Node(9, 10));
        adjacent.get(1).add(new Node(10, 15));
        adjacent.get(1).add(new Node(14, 11));
        adjacent.get(2).add(new Node(16, 8));
        adjacent.get(2).add(new Node(3, 23));
        adjacent.get(2).add(new Node(4, 35));
        adjacent.get(3).add(new Node(2, 23));
        adjacent.get(4).add(new Node(2, 35));
        adjacent.get(5).add(new Node(6, 20));
        adjacent.get(5).add(new Node(10, 15));
        adjacent.get(5).add(new Node(9, 15));
        adjacent.get(6).add(new Node(5, 20));
        adjacent.get(6).add(new Node(7, 9));
        adjacent.get(7).add(new Node(6, 9));
        adjacent.get(7).add(new Node(8, 9));
        adjacent.get(8).add(new Node(7, 9));
        adjacent.get(8).add(new Node(1, 9));
        adjacent.get(9).add(new Node(1, 10));
        adjacent.get(9).add(new Node(5, 15));
        adjacent.get(10).add(new Node(5, 15));
        adjacent.get(10).add(new Node(2, 15));
        adjacent.get(10).add(new Node(1, 15));
        adjacent.get(10).add(new Node(15, 20));
        adjacent.get(11).add(new Node(1, 20));
        adjacent.get(12).add(new Node(16, 15));
        adjacent.get(13).add(new Node(0, 11));
        adjacent.get(13).add(new Node(14, 11));
        adjacent.get(14).add(new Node(1, 11));
        adjacent.get(14).add(new Node(13, 11));
        adjacent.get(15).add(new Node(1, 15));
        adjacent.get(15).add(new Node(10, 20));
        adjacent.get(16).add(new Node(12, 15));
        adjacent.get(16).add(new Node(2, 8));
        adjacent.get(16).add(new Node(1, 10));

        // creating an object of the class DijkstraExample1
        transfare obj = new transfare(totalNodes);
        obj.dijkstra(adjacent, s);

        // Printing the shortest path to all the nodes
        // from the source node
        // System.out.println("The shortest path from the node :");

        // for (int j = 0; j < obj.fare.length; j++) {
        // System.out.println(s + " to " + j + " is " + obj.fare[j]);
        // }

        for (int j = 0; j < obj.fare.length; j++) {
            // System.out.println(s + " to " + j + " is " + obj.fare[j]);
            // add result in variable destination
            if (j == e) {
                totalFare = obj.fare[j];
                // System.out.println("ETO NA YUNG RESULT: " + destination);
            }
        }

        System.out.println();
        System.out.println("The total fare of the cheapest route from " + s + " to " + e + " is " + totalFare);

    }
}

// The Node class implementing the Comparator interface
// The object of this class represents a node of the graph
class Node implements Comparator<Node> {

    // Member variables of the Node class
    public int n;
    public int fare;

    // Constructors of this class

    // Constructor 1
    public Node() {

    }

    // Constructor 2
    public Node(int n, int fare) {
        this.n = n;
        this.fare = fare;
    }

    @Override
    public int compare(Node n1, Node n2) {

        if (n1.fare < n2.fare) {
            return -1;
        }
        if (n1.fare > n2.fare) {
            return 1;
        }

        return 0;
    }
}
