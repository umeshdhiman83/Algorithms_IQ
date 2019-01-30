package com.qu;

/*
BFS is a traversing algorithm where you should start traversing from a selected node (source or starting node) and traverse the graph layerwise thus exploring the neighbour nodes (nodes which are directly connected to source node). You must then move towards the next-level neighbour nodes.

As the name BFS suggests, you are required to traverse the graph breadthwise as follows:

First move horizontally and visit all the nodes of the current layer
Move to the next layer
* */


/*
* Pseudocode

BFS (G, s)                   //Where G is the graph and s is the source node
      let Q be queue.
      Q.enqueue( s ) //Inserting s in queue until all its neighbour vertices are marked.

      mark s as visited.
      while ( Q is not empty)
           //Removing that vertex from queue,whose neighbour will be visited now
           v  =  Q.dequeue( )

          //processing all the neighbours of v
          for all neighbours w of v in Graph G
               if w is not visited
                        Q.enqueue( w )             //Stores w in Q to further visit its neighbour
                        mark w as visited.
* */

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BreadthFirstSearch {



}

class Node {
    private Node left;
    private Node right;
    private String label;
    public Node(@NotNull String label, @Nullable Node left, @Nullable Node right) {
        this.left = left;
        this.right = right;
        this.label = label;
    }
    @Override
    public String toString() {
        return label;
    }
    public List<Node> getChildren() {
        return Stream.of(left, right)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public List<Node> searchByBreadth() {
        List<Node> visitedNodes = new LinkedList<>();
        List<Node> unvisitedNodes = Arrays.asList(this);
        while(!unvisitedNodes.isEmpty()) {
            List<Node> newNodes = unvisitedNodes
                    .stream()
                    .map(Node::getChildren)
                    .flatMap(List::stream)
                    .filter(node -> !visitedNodes.contains(node))
                    .collect(Collectors.toList());
            visitedNodes.addAll(unvisitedNodes);
            unvisitedNodes = newNodes;
        }
        return visitedNodes;
    }
}