package pl.bioinformatyka.common;

public class Edge {
    private String one;
    private String two;

    public Edge(String one, String two) {
        this.one = one;
        this.two = two;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        if (other == this) return true;
        if (!(other instanceof Edge))return false;
        Edge otherEdge = (Edge) other;
        if (this.one.equals(otherEdge.one) && this.two.equals(otherEdge.two)) {
            return true;
        }
        if (this.one.equals(otherEdge.two) && this.two.equals(otherEdge.one)) {
            return true;
        }
        return false;
    }
}
