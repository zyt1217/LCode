package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution797 {
    public List<List<Integer>> ans = new LinkedList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> path = new LinkedList<>();
        traverse(graph,0, path);
        return ans;
    }

    public void traverse(int[][] graph, int point, List<Integer> path){
        path.add(point);
        if(point == graph.length-1){
            ans.add(new LinkedList<>(path));
            path.remove(path.size()-1);
            return;
        }
        for(int v : graph[point]){
            traverse(graph,v,path);
        }
        path.remove(path.size()-1);
    }
}

class test{
    public static void main(String[] args){
        int[][] graph = new int[][]{{1,2},{3},{3},{}};
        Solution797 a = new Solution797();
        a.allPathsSourceTarget(graph);
    }
}