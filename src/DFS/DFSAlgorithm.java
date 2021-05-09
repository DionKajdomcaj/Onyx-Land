package DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import Buildings.Path;
public class DFSAlgorithm {

    HashMap<Path, Path> parents = new HashMap<>();
    HashSet<Path> visited = new HashSet<>();

    public DFSAlgorithm() {}

    public LinkedList<Path> DFS(Path from, Path to){
        if (visited != null) visited.clear();
        if (parents != null) parents.clear();
        if (from.equals(to)) return new LinkedList<>();

        for (Path n : from.nodes){
            //System.out.println("Position: " + n.getPosition().x + " " + n.getPosition().y);
            if (visited.contains(n)) continue;
            visited.add(n);
            parents.put(n, from);
            if (DFS2(n, to)) break;
        }

        LinkedList<Path> path = new LinkedList<>();
        Path curr = to;
        path.add(to);
        while (!curr.equals(from)){
            curr = parents.get(curr);
            path.addFirst(curr);
        }
        return path;
    }
    
    public boolean DFS2(Path from, Path to){
        for (Path n : from.nodes){
            if (visited.contains(n)) continue;
            visited.add(n);
            parents.put(n, from);
            if (n.equals(to))
                return true;
            else if (DFS2(n, to)) return true;
        }
        return false;
    }    
    
}
