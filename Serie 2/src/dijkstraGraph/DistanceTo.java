package dijkstraGraph;

public final class DistanceTo implements Comparable<DistanceTo> {
    private Node target;
    private int distance;

    public DistanceTo(Node node, int dist) {
        target = node;
        distance = Math.abs(dist);
    }

    public Node getTarget() {
        return target;
    }

    public int getDistance() {
        return distance;
    }

    public int compareTo(DistanceTo other) {
        return Integer.compare(distance, other.distance);
    }

    @Override
    public String toString () {
        if (target != null && distance > 0) {
            return String.format("%s %d", target, distance);
        }
        return super.toString();
    }

}

enum Node { A, B, C, D, E, F }