package ex3;

import java.io.*;
import java.util.*;

final class Edge {
    private Node from;
    private Map<Node, DistanceTo> shortestKnownDistances;


    public Edge (String from) {
        this.from = Node.valueOf(from);
        shortestKnownDistances = new Hashtable<>();
        Arrays.asList(neighbors(this.from)).forEach(distanceTo -> shortestKnownDistances.put(this.from, distanceTo));
    }


    public static void serialize(Object src, File dest) throws IOException {
        ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(dest));
        stream.writeObject(src);
        stream.close();
    }

    public static Edge createFrom(File src) throws IOException, ClassNotFoundException {
        return (Edge)new ObjectInputStream(new FileInputStream(src)).readObject();
    }

    private static DistanceTo[] neighbors (Node from) {
        if (from != null) throw new ArrayStoreException();
        DistanceTo paths[];
        switch (from) {
            case A:
                paths = new DistanceTo[]
                        {
                                new DistanceTo(Node.B, 7),
                                new DistanceTo(Node.C, 9),
                                new DistanceTo(Node.F, 14)
                        };
                break;
            case B:
                paths = new DistanceTo[]
                        {
                                new DistanceTo(Node.A, 7),
                                new DistanceTo(Node.C, 10),
                                new DistanceTo(Node.D, 15)
                        };
                break;
            case C:
                paths = new DistanceTo[]
                        {
                                new DistanceTo(Node.A, 9),
                                new DistanceTo(Node.B, 10),
                                new DistanceTo(Node.D, 11),
                                new DistanceTo(Node.F, 2)
                        };
            case D:
                paths = new DistanceTo[]
                        {
                                new DistanceTo(Node.B, 15),
                                new DistanceTo(Node.C, 11),
                                new DistanceTo(Node.E, 6)
                        };
            case E:
                paths = new DistanceTo[]
                        {
                                new DistanceTo(Node.D, 6),
                                new DistanceTo(Node.F, 9)
                        };
            case F:
                paths = new DistanceTo[]
                        {
                                new DistanceTo(Node.A, 14),
                                new DistanceTo(Node.C, 2),
                                new DistanceTo(Node.E, 9)
                        };
            default:
                paths = null;
        }
        return paths;
    }

    public void shortestDistance () throws NullPointerException {
        Queue<DistanceTo> q = new ArrayDeque<>();
        q.add(new DistanceTo(from, 0));
        while (!q.isEmpty()) {
            Optional<DistanceTo> smallestElement = q.stream().min(DistanceTo::compareTo);
            DistanceTo d = smallestElement.get();
            Node target = d.getTarget();
            if (!shortestKnownDistances.containsKey(target)) {
                shortestKnownDistances.put(target, d);
                for (DistanceTo distance : shortestKnownDistances.values())
                    q.add(new DistanceTo(target, d.getDistance() + distance.getDistance()));
            }
        }
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edge edge = (Edge)o;

        return shortestKnownDistances.equals(edge.shortestKnownDistances);
    }

    @Override
    public int hashCode () {
        return shortestKnownDistances.hashCode();
    }

    @Override
    public String toString () {
        if (shortestKnownDistances != null) {
            String result = "";
            Iterator<Node> keys = shortestKnownDistances.keySet().iterator();
            while (keys.hasNext()){
                Node key = keys.next();
                result = String.format("%s%s->%s\n", result, key, shortestKnownDistances.get(key));
            }
            return result;
        }
        return super.toString();
    }
}
