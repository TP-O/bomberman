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

    private Handler handler;

    private Character target;

    private TileNode endNode;

    private TileNode startNode;

    private long foundAt = 0;

    private int xPrevTile = 0;

    private int yPrevTile = 0;

    private ArrayList<Integer> moves = new ArrayList<Integer>();

    private ArrayList<TileNode> map1D = new ArrayList<TileNode>();

    private ArrayList<ArrayList<TileNode>> map2D = new ArrayList<ArrayList<TileNode>>();

    public Follow(Move move, Character target) {
        super(move);

        this.target = target;
        this.handler = Handler.getInstance();
    }

    @Override
    protected void decorate() {
        long now = System.currentTimeMillis();

        if (moves.size() == 0) {
            dijkstra();
            foundAt = now;
        }

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

    private void dijkstra() {
        resetMoves();

        createMaps();

        setNodes();

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

            // Skip the obstacles in the map
            if (isImpassablekNode(node)) {
                continue;
            }

            // Make the current is visited
            node.visited();

            if (node == endNode) {
                setMoves(node);

                break;
            }

            updateNeighbors(node);
        }
    }

    private void resetMoves() {
        this.moves.clear();
    }

    private void setMoves(TileNode node) {
        TileNode curNode = node;

        while (curNode != null) {
            curNode = curNode.prev;

            if (curNode != null) {
                if (curNode.getTile().getX() > endNode.getTile().getX()) {
                    moves.add(3);
                } else if (curNode.getTile().getX() < endNode.getTile().getX()) {
                    moves.add(4);
                } else if (curNode.getTile().getY() > endNode.getTile().getY()) {
                    moves.add(1);
                } else if (curNode.getTile().getY() < endNode.getTile().getY()) {
                    moves.add(2);
                }

                endNode = curNode;
            }
        }
    }

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

    private void setNodes() {
        int xEnd = Helper.getXOfTile(target.getX());
        int yEnd = Helper.getYOfTile(target.getY());
        int xStart = (int) getEntity().getX() / TileConfig.WIDTH;
        int yStart = (int) getEntity().getY() / TileConfig.HEIGHT;

        endNode = map2D.get(xEnd).get(yEnd);
        startNode = map2D.get(xStart).get(yStart);

        startNode.setDistance(0);
    }

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

    private void updateNeighbors(TileNode node) {
        int x = node.getTile().getX();
        int y = node.getTile().getY();

        try {
            if (!map2D.get(x - 1).get(y).isVisited()) {
                map2D.get(x - 1).get(y).prev = node;
                map2D.get(x - 1).get(y).setDistance(node.getDistance() + 1);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("hi 1");
        }

        try {
            if (!map2D.get(x + 1).get(y).isVisited()) {
                map2D.get(x + 1).get(y).prev = node;
                map2D.get(x + 1).get(y).setDistance(node.getDistance() + 1);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("hi 2");
        }

        try {
            if (!map2D.get(x).get(y - 1).isVisited()) {
                map2D.get(x).get(y - 1).prev = node;
                map2D.get(x).get(y - 1).setDistance(node.getDistance() + 1);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("hi 3");
        }

        try {
            if (!map2D.get(x).get(y + 1).isVisited()) {
                map2D.get(x).get(y + 1).prev = node;
                map2D.get(x).get(y + 1).setDistance(node.getDistance() + 1);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("hi 4");
        }
    }

    // public void findPath() {
    // // Reset the move commands
    // this.moves.clear();

    // // Create the map containing the tile nodes
    // ArrayList<TileNode> map1D = new ArrayList<TileNode>();
    // ArrayList<ArrayList<TileNode>> map2D = new ArrayList<ArrayList<TileNode>>();

    // for (Tile[] tiles : handler.getMap().getTiles().clone()) {
    // ArrayList<TileNode> map2DRow = new ArrayList<TileNode>();
    // for (Tile tile : tiles) {
    // TileNode node = new TileNode(tile);
    // map1D.add(node);
    // map2DRow.add(node);
    // }

    // map2D.add(map2DRow);
    // }

    // // Set start node and end node
    // int xStart = (int) getEntity().getX() / TileConfig.WIDTH;
    // int yStart = (int) getEntity().getY() / TileConfig.HEIGHT;
    // int xEnd = 3;
    // int yEnd = 4;

    // TileNode start = map2D.get(xStart).get(yStart);
    // TileNode end = map2D.get(xEnd).get(yEnd);
    // start.setDistance(0);

    // while (map1D.size() > 0) {
    // // Move the nodes having smallest distance to the end
    // map1D.sort((n1, n2) -> {
    // if (n1.getDistance() > n2.getDistance()) {
    // return -1;
    // } else if (n1.getDistance() < n2.getDistance()) {
    // return 1;
    // } else {
    // return 0;
    // }
    // });

    // // Get the node with smallest distance
    // TileNode node = map1D.remove(map1D.size() - 1);

    // // Skip the obstacles in the map
    // if (node.getTile().isSolid() || node.isVisited() || node.getDistance() == 99)
    // {
    // continue;
    // }

    // // Make the current is visited
    // node.visited();

    // if (node == end) {
    // TileNode curNode = node;

    // while (curNode != null) {
    // curNode = curNode.prev;

    // if (curNode != null) {
    // if (curNode.getTile().getX() > end.getTile().getX()) {
    // moves.add(3);
    // } else if (curNode.getTile().getX() < end.getTile().getX()) {
    // moves.add(4);
    // } else if (curNode.getTile().getY() > end.getTile().getY()) {
    // moves.add(1);
    // } else if (curNode.getTile().getY() < end.getTile().getY()) {
    // moves.add(2);
    // }

    // end = curNode;
    // }
    // }

    // break;
    // }

    // // Update the neighbors
    // int x = node.getTile().getX();
    // int y = node.getTile().getY();

    // try {
    // if (!map2D.get(x - 1).get(y).isVisited()) {
    // map2D.get(x - 1).get(y).prev = node;
    // map2D.get(x - 1).get(y).setDistance(node.getDistance() + 1);
    // }
    // } catch (IndexOutOfBoundsException e) {
    // System.out.println("1");
    // }

    // try {
    // if (!map2D.get(x + 1).get(y).isVisited()) {
    // map2D.get(x + 1).get(y).prev = node;
    // map2D.get(x + 1).get(y).setDistance(node.getDistance() + 1);
    // }
    // } catch (IndexOutOfBoundsException e) {
    // System.out.println("2");
    // }

    // try {
    // if (!map2D.get(x).get(y - 1).isVisited()) {
    // map2D.get(x).get(y - 1).prev = node;
    // map2D.get(x).get(y - 1).setDistance(node.getDistance() + 1);
    // }
    // } catch (IndexOutOfBoundsException e) {
    // System.out.println("3");
    // }

    // try {
    // if (!map2D.get(x).get(y + 1).isVisited()) {
    // map2D.get(x).get(y + 1).prev = node;
    // map2D.get(x).get(y + 1).setDistance(node.getDistance() + 1);
    // }
    // } catch (IndexOutOfBoundsException e) {
    // System.out.println("4");
    // }
    // }
    // }
}
