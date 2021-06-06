package components.actions.move.type;

import java.util.ArrayList;

import app.cache.EntityCache;
import components.actions.move.Move;
import components.actions.move.MoveDecorator;
import components.entities.dynamics.characters.Character;
import components.tiles.Tile;
import components.tiles.TileNode;
import config.TileConfig;
import core.Handler;
import helper.Helper;

public class Follow extends MoveDecorator {

    /**
     * Game handler.
     */
    private Handler handler;

    /**
     * Move to this target.
     */
    private Character target;

    /**
     * Finish at this node.
     */
    private TileNode endNode;

    /**
     * Start from this node.
     */
    private TileNode startNode;

    /**
     * Latest time that the path was found.
     */
    private long foundAt = 0;

    /**
     * Position x of previous tile that entity just passed.
     */
    private int xPrevTile = 0;

    /**
     * Position y of previous tile that entity just passed.
     */
    private int yPrevTile = 0;

    /**
     * List of moving rules.
     * 1 - Up
     * 2 - Down
     * 3 - Left
     * 4 - Right
     */
    private ArrayList<Integer> moves = new ArrayList<Integer>();

    /**
     * Display map as 1D.
     */
    private ArrayList<TileNode> map1D = new ArrayList<TileNode>();

    /**
     * Display map as 2D.
     */
    private ArrayList<ArrayList<TileNode>> map2D = new ArrayList<ArrayList<TileNode>>();

    /**
     * Constructor.
     *
     * @param move moving action.
     * @param target target is followed.
     */
    public Follow(Move move, Character target) {
        super(move);

        this.target = target;
        this.handler = Handler.getInstance();
    }

    @Override
    protected void decorate() {
        // Get current time
        long now = System.currentTimeMillis();

        // Get list of moving rules if it's empty
        if (moves.size() == 0) {
            dijkstra();
            foundAt = now;
        }

        // Start move rely on list of moving rules
        if (moves.size() > 0) {
            int x = (int) getEntity().getX();
            int y = (int) getEntity().getY();

            if (xPrevTile == 0 && yPrevTile == 0) {
                xPrevTile = Helper.getXOfTile(x) * TileConfig.WIDTH;
                yPrevTile = Helper.getYOfTile(y) * TileConfig.HEIGHT;
            }

            if (moves.get(moves.size() - 1) == 1) {
                moveUp();

                if (yPrevTile - y >= TileConfig.HEIGHT - getEntity().getSpeed() * 2) {
                    moves.remove(moves.size() - 1);
                    xPrevTile = Helper.getXOfTile(x) * TileConfig.WIDTH;
                    yPrevTile = Helper.getYOfTile(y) * TileConfig.HEIGHT;

                    if (now - foundAt >= 2000) {
                        dijkstra();
                        foundAt = now;
                    }
                }
            } else if (moves.get(moves.size() - 1) == 2) {
                moveDown();

                if (y - yPrevTile >= TileConfig.HEIGHT) {
                    moves.remove(moves.size() - 1);
                    xPrevTile = Helper.getXOfTile(x) * TileConfig.WIDTH;
                    yPrevTile = Helper.getYOfTile(y) * TileConfig.HEIGHT;

                    if (now - foundAt >= 2000) {
                        dijkstra();
                        foundAt = now;
                    }
                }
            } else if (moves.get(moves.size() - 1) == 3) {
                moveLeft();

                if (xPrevTile - x >= TileConfig.WIDTH - getEntity().getSpeed() * 2) {
                    moves.remove(moves.size() - 1);
                    xPrevTile = Helper.getXOfTile(x) * TileConfig.WIDTH;
                    yPrevTile = Helper.getYOfTile(y) * TileConfig.HEIGHT;

                    if (now - foundAt >= 2000) {
                        dijkstra();
                        foundAt = now;
                    }
                }
            } else if (moves.get(moves.size() - 1) == 4) {
                moveRight();

                if (x - xPrevTile >= TileConfig.WIDTH) {
                    moves.remove(moves.size() - 1);
                    xPrevTile = Helper.getXOfTile(x) * TileConfig.WIDTH;
                    yPrevTile = Helper.getYOfTile(y) * TileConfig.HEIGHT;

                    if (now - foundAt >= 2000) {
                        dijkstra();
                        foundAt = now;
                    }
                }
            }
        }
    }

    /**
     * Find path.
     */
    private void dijkstra() {
        // Reset list of moving rules
        resetMoves();

        // Create 1D and 2D map
        createMaps();

        // Set start and end node
        setNodes();

        // Start finding
        while (map1D.size() > 0) {
            // Move the nodes having smallest distance to the end
            map1D.sort((n1, n2) -> {
                if (n1.getDistance() > n2.getDistance()) {
                    return -1;
                } else if (n1.getDistance() < n2.getDistance()) {
                    return 1;
                } else {
                    return 0;
                }
            });

            // Get the node with smallest distance
            TileNode node = map1D.remove(map1D.size() - 1);

            // Skip if this node is impassable
            if (isImpassablekNode(node)) {
                continue;
            }

            // Make this node is visited
            node.visited();

            // Create list of moving rules if destination is found
            if (node == endNode) {
                setMoves(node);

                break;
            }

            // Update above, below, left and right node of a node
            updateNeighbors(node);
        }
    }

    /**
     * Clear list of moving rules.
     */
    private void resetMoves() {
        this.moves.clear();
    }

    /**
     * Create list of moving rules.
     *
     * @param node destination node.
     */
    private void setMoves(TileNode node) {
        TileNode curNode = node;

        while (curNode != null) {
            curNode = curNode.prev;

            if (curNode != null) {
                // Add left
                if (curNode.getTile().getX() > endNode.getTile().getX()) {
                    moves.add(3);
                // Add right
                } else if (curNode.getTile().getX() < endNode.getTile().getX()) {
                    moves.add(4);
                // Add up
                } else if (curNode.getTile().getY() > endNode.getTile().getY()) {
                    moves.add(1);
                // Add down
                } else if (curNode.getTile().getY() < endNode.getTile().getY()) {
                    moves.add(2);
                }

                // Move destination node forward
                endNode = curNode;
            }
        }
    }

    /**
     * Create 1D and 2D map.
     */
    private void createMaps() {
        map1D.clear();
        map2D.clear();

        for (Tile[] tiles : handler.getMap().getTiles().clone()) {
            ArrayList<TileNode> map2DRow = new ArrayList<TileNode>();
            for (Tile tile : tiles) {
                TileNode node = new TileNode(tile);
                map1D.add(node);
                map2DRow.add(node);
            }

            map2D.add(map2DRow);
        }
    }

    /**
     * Set start and end node.
     */
    private void setNodes() {
        int xEnd = Helper.getXOfTile(target.getX());
        int yEnd = Helper.getYOfTile(target.getY());
        int xStart = (int) getEntity().getX() / TileConfig.WIDTH;
        int yStart = (int) getEntity().getY() / TileConfig.HEIGHT;

        endNode = map2D.get(xEnd).get(yEnd);
        startNode = map2D.get(xStart).get(yStart);

        startNode.setDistance(0);
    }

    /**
     * Check if node is impassable.
     *
     * @param node node will be checked.
     */
    private boolean isImpassablekNode(TileNode node) {
        boolean isObstacle = false;

        for (int i = 0; i < EntityCache.get("obstacle").size(); i++) {
            if (Helper.getXOfTile(EntityCache.get("obstacle").get(i).getX()) == node.getTile().getX()
                    && Helper.getYOfTile(EntityCache.get("obstacle").get(i).getY()) == node.getTile().getY()) {
                isObstacle = true;
            }
        }

        return node.getTile().isSolid() || node.isVisited() || node.getDistance() == 99 || isObstacle;
    }

    /**
     * Update above, below, left and right node of a node.
     */
    private void updateNeighbors(TileNode node) {
        int x = node.getTile().getX();
        int y = node.getTile().getY();

        try {
            if (!map2D.get(x - 1).get(y).isVisited()) {
                map2D.get(x - 1).get(y).prev = node;
                map2D.get(x - 1).get(y).setDistance(node.getDistance() + 1);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Warning: Can not find left node");
        }

        try {
            if (!map2D.get(x + 1).get(y).isVisited()) {
                map2D.get(x + 1).get(y).prev = node;
                map2D.get(x + 1).get(y).setDistance(node.getDistance() + 1);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Warning: Can not find right node");
        }

        try {
            if (!map2D.get(x).get(y - 1).isVisited()) {
                map2D.get(x).get(y - 1).prev = node;
                map2D.get(x).get(y - 1).setDistance(node.getDistance() + 1);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Warning: Can not find above node");
        }

        try {
            if (!map2D.get(x).get(y + 1).isVisited()) {
                map2D.get(x).get(y + 1).prev = node;
                map2D.get(x).get(y + 1).setDistance(node.getDistance() + 1);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Warning: Can not find below node");
        }
    }
}
