package dijkstraGraph;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class Path {

    private static List<ArrayList<DistanceTo>> graph;

    static {
        graph = new ArrayList<>();
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(Paths.get("graph.txt"));
        int i = 0;
        while (in.hasNextLine()) {
            String line = in.nextLine();
            Scanner in2 = new Scanner(line);
            in2.useDelimiter("->| ");
            Node node = Node.valueOf(in2.next());
            graph.add(i, new ArrayList<>());
            while (in2.hasNext()) {
                graph.get(i).add(new DistanceTo(Node.valueOf(in2.next()), in2.nextInt()));
            }
            i++;
        }

        Node from = Node.A;
        Queue<DistanceTo> q = new PriorityQueue<>();
        q.add(new DistanceTo(from, 0));
        Map<Node, Integer> shortestKnownDistances = new HashMap<>();
        while (!q.isEmpty()) {
            DistanceTo current = q.remove();
            if (shortestKnownDistances.get(current.getTarget()) == null) {
                shortestKnownDistances.put(current.getTarget(), current.getDistance());
                for (DistanceTo distanceTo : getNeighbors(current.getTarget())) {
                    q.add(new DistanceTo(distanceTo.getTarget(), current.getDistance() + distanceTo.getDistance()));
                }
            }
        }
        System.out.println(shortestKnownDistances);
    }

    private static List<DistanceTo> getNeighbors(Node target) {
        int nodePosition = target.toString().charAt(0) - 65;
        List<DistanceTo> temp = new ArrayList<>();
        for (int i = 0; i < graph.size(); i++) {
            for (int j = 0; j < graph.get(i).size(); j++) {
                if (graph.get(i).get(j).getTarget().equals(target)) {
                    temp.add(new DistanceTo(Node.valueOf(String.valueOf((char) (i + 65))), graph.get(i).get(j).getDistance()));
                } else if (i == nodePosition) {
                    temp.add(graph.get(i).get(j));
                }
            }
        }
        return temp;
    }

}
