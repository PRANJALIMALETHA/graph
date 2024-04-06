import java.util.*;
public class cycledetect{
    static class edge{
        int src;
        int dest;

        edge(int src,int dest)
        {
            this.src=src;
            this.dest=dest;
        }
    }


    public static void dfs(ArrayList<edge>graph[])
    {
        boolean vis[]=new boolean[graph.length];
        boolean b=false;
        for(int i=0;i<graph.length;i++)
        {
            if(!vis[i])
            {
                b=dfscycledetect(graph,0,-1,vis );
            }

        }
        System.out.println(b);

    }
    public static boolean  dfscycledetect(ArrayList<edge>graph[],int curr,int parent,boolean vis[])
    {
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++)
        {
            edge e=graph[curr].get(i);
            if(!vis[e.dest]&&dfscycledetect(graph,e.dest,curr,vis))
            {
                return true;
            }
            else  if(vis[e.dest]&&e.dest!=parent)
            {
                return true;
            }
        }
        return false;
    }
    public static void main(String args[])
    {
        ArrayList<edge>graph[]=new ArrayList[5];
        for(int i=0;i<graph.length;i++)
        {
            graph[i]=new ArrayList<>();
        }

        graph[0].add(new edge(0,1));
        // graph[0].add(new edge(0,2));
        graph[0].add(new edge(0,3));

        graph[1].add(new edge(1,0));
        graph[1].add(new edge(1,2));
        // graph[1].add(new edge(2,0));
        graph[1].add(new edge(2,1));

        graph[3].add(new edge(3,0));
        graph[3].add(new edge(3,4));

        graph[4].add(new edge(4,3));

        dfs(graph);
        
    }
}