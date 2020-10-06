import java.util.*;

/**
 * A* Pathfinding algorithm
 *
 * It searches for shortest path between two graph nodes using
 * heuristic estimation of a distance to lower the amount of
 * nodes to be visited.
 *
 * It works well in cases of finding a path between geographical
 * objects (like cities or intersections) using connections
 * between them (roads).
 *
 * It minimizes a function: f(x) = g(x) + h(x) where:
 *  g(x) is computed distance from start to x node
 *  h(x) is heuristic distance from x node to the target
 *  f(x) is the total cost of getting from start to goal through x
 *
 * In this example the heurestic distance is an euclidean distance
 * (every node has a cartesian coordinates assigned)
 *
 * Wiki page about the algorithm:
 *  https://en.wikipedia.org/wiki/A*_search_algorithm
 *
 * ===
 *
 * The algorithm is implemented in @see Graph.findShortestPathUsingAStar()
 * The rest of the code helps keeping implementation clear.
 *
 * ===
 *
 * @author Piotr Macha <piotr.macha@owlitdevelopment.com>
 */

final class Graph {
    private final Map<String, Node> nodes = new HashMap<>();

    List<Node> findShortestPathUsingAStar(String startName, String goalName) {
        Node start = nodes.get(startName);
        Node goal = nodes.get(goalName);

        // Nodes already visited
        Set<Node> closedSet = new HashSet<>();

        // Nodes already known but not visited, we put start node as first element
        Set<Node> openSet = new HashSet<>();
        openSet.add(start);

        // Map to rebuild path when we found a route
        Map<Node, Node> cameFrom = new HashMap<>();

        // g(x), g-score contains cost to get from start to given node
        // We initialize it as 0 for start node and infinite for others
        Map<Node, Distance> gScore = new HashMap<>();
        for (Node node : nodes.values()) {
            gScore.put(node, node == start ? Distance.real(0) : Distance.infinite());
        }

        // f(x), f-score is total cost of getting from start to goal thought a specific node
        // We initialize it as heuristic distance estimate for start and infinity for others
        Map<Node, Distance> fScore = new HashMap<>();
        for (Node node : nodes.values()) {
            fScore.put(node, node == start ? node.euqlideanDistanceTo(goal) : Distance.infinite());
        }

        while (!openSet.isEmpty()) {
            // Find a node in open set with the lowest f-score
            Node current = openSet.stream().min(Comparator.comparing(fScore::get)).get();

            if (current == goal) {
                // We found the path and now we can reconstruct it using cameFrom map
                List<Node> path = new ArrayList<>();
                path.add(current);
                while (cameFrom.keySet().contains(current)) {
                    current = cameFrom.get(current);
                    path.add(current);
                }
                Collections.reverse(path);
                return path;
            }

            // Mark node as visited by swapping its set
            openSet.remove(current);
            closedSet.add(current);

            for (Map.Entry<Node, Distance> neighborEntry : current.edges.entrySet()) {
                Node neighbor = neighborEntry.getKey();
                Distance distance = neighborEntry.getValue();

                if (closedSet.contains(neighbor)) {
                    // Ignore neighbor if it was already evaluated
                    continue;
                }

                // Might be a new g-score for current
                Distance gScoreMaybe = gScore.get(current).add(distance);

                if (!openSet.contains(neighbor)) {
                    // We'll evaluate the newly discovered node later
                    openSet.add(neighbor);
                } else if (gScoreMaybe.compareTo(gScore.get(neighbor)) >= 0) {
                    // Path is worse than already discovered
                    continue;
                }

                // We'll use it later to reconstruct the path
                cameFrom.put(neighbor, current);

                // We set f(x) as g(x) + h(x) (heuristic distance)
                gScore.put(neighbor, gScoreMaybe);
                fScore.put(neighbor, gScoreMaybe.add(neighbor.euqlideanDistanceTo(goal)));
            }
        }

        throw new RuntimeException("A* reached end without finding a route (unexpected case)");
    }

    Graph add(Node node) {
        this.nodes.put(node.name, node);
        return this;
    }

    Graph edge(String from, String to, double distance) {
        Node a = nodes.get(from);
        Node b = nodes.get(to);
        a.edges.put(b, Distance.real(distance));
        b.edges.put(a, Distance.real(distance));
        return this;
    }

    final static class Distance implements Comparable<Distance> {
        private final boolean infinite;
        private final double distance;

        private Distance(boolean infinite, double distance) {
            this.infinite = infinite;
            this.distance = distance;
        }

        Distance add(Distance o) {
            return new Distance(this.infinite && o.infinite, this.distance + o.distance);
        }

        static Distance infinite() {
            return new Distance(true, 0);
        }

        static Distance real(double distance) {
            return new Distance(false, distance);
        }

        @Override
        public int compareTo(Distance o) {
            if (o.infinite && this.infinite || (!o.infinite && !this.infinite && o.distance == this.distance)) {
                return 0;
            }

            if (o.infinite || (!this.infinite && this.distance < o.distance)) {
                return -1;
            }

            return 1;
        }
    }

    final static class Node {
        private final String name;
        private final double positionX;
        private final double positionY;
        private final Map<Node, Distance> edges;

        Node(String name, double positionX, double positionY) {
            this.name = name;
            this.positionX = positionX;
            this.positionY = positionY;
            this.edges = new HashMap<>();
        }

        String getName() {
            return name;
        }

        Distance euqlideanDistanceTo(Node o) {
            return Distance.real(Math.sqrt(Math.pow(positionX - o.positionX, 2) + Math.pow(positionY - o.positionY, 2)));
        }
    }
}

public class AStarPathfinding {
    public static void main(String args[]) {
        (new Graph())
                .add(new Graph.Node("A", 1, 4))
                .add(new Graph.Node("B", 1, 3))
                .add(new Graph.Node("C", 2, 3))
                .add(new Graph.Node("D", 3, 4))
                .add(new Graph.Node("E", 1, 2))
                .add(new Graph.Node("F", 3, 2))
                .add(new Graph.Node("G", 2, 1))
                .add(new Graph.Node("H", 1, 0))
                .add(new Graph.Node("I", 0, 2))
                .add(new Graph.Node("J", 0, 0))
                .edge("A", "B", 1.1)
                .edge("A", "C", 1.47)
                .edge("A", "D", 2.2)
                .edge("C", "E", 1.43)
                .edge("D", "F", 2.8)
                .edge("E", "I", 1.01)
                .edge("I", "J", 1.1)
                .edge("J", "H", 1.12)
                .edge("E", "G", 3.44)
                .edge("F", "G", 1.44)
                .edge("H", "G", 1.42)
                .findShortestPathUsingAStar("A", "H")
                .stream()
                .map(Graph.Node::getName)
                .forEach(name -> System.out.println("Route step: " + name));
        ;
    }
}
