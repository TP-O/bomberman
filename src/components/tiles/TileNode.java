package components.tiles;

public class TileNode {

    public TileNode prev;

    private Tile tile;

    private int distance = 99;

    private boolean visited = false;

    public TileNode(Tile tile) {
        this.tile = tile;
    }

    public Tile getTile() {
        return tile;
    }

    public int getDistance() {
        return distance;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setDistance(int distance) {
        this.distance = distance >= 0 ? distance : this.distance;
    }

    public void visited() {
        visited = true;
    }
}
