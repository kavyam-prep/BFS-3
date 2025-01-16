import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import org.w3c.dom.Node;

public class CloneGraph {
     //o(n+m) o(n)
    // HashMap<Node, Node> visited = new HashMap<>();
    // public Node cloneGraph(Node node) {
    //     if(node == null) return node;

    //     if(visited.containsKey(node)){
    //         return visited.get(node);
    //     }
    //     Node cloneNode = new Node(node.val, new ArrayList<>());
    //     visited.put(node, cloneNode);
    //     for(Node neighbor: node.neighbors){
    //         cloneNode.neighbors.add(cloneGraph(neighbor));
    //     }
    //     return cloneNode;
    // }

    //s30 
    //bfs - tc o(v+e) sc - o(v)
    HashMap<Node, Node> visited = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        while(!q.isEmpty()){
            Node curr = q.poll();
            Node copyCurr = clone(curr);
            for(Node ne: curr.neighbors){
                if(!visited.containsKey(ne)){
                    q.add(ne);
                }
                copyCurr.neighbors.add(clone(ne));
            }
        }
        return visited.get(node);
    }

    public Node clone(Node node){
        if(node == null) return node;
        if(!visited.containsKey(node)){
            visited.put(node, new Node(node.val));
        }
        return visited.get(node);
    }
}
