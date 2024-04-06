import java.util.*;
public class depthsearchjava {
    static class edge{
        int src;
        int dest;
        edge(int src,int dest)
        {
            this.src=src;
            this.dest=dest;
        }
    }
        public static  void depthfirstsearch(ArrayList<edge>graph[],int curr,boolean vis[])
        {
            System.out.print(curr);
             vis[curr]=true;
             for(int i=0;i<graph[curr].size();i++)
             {
                edge e=graph[curr].get(i);
                if(!vis[e.dest])
                {
                    depthfirstsearch(graph,e.dest,vis);
                }
    
             }
         }
    public static void main(String args[])
    {
        int v=7;
        ArrayList<edge>graph[]=new ArrayList[v];
        for(int i=0;i<v;i++)
        {
            graph[i]=new ArrayList<>();

        }
        graph[0].add(new edge(0,1));
        graph[0].add(new edge(0,2));


        graph[1].add(new edge(1,3));
        graph[1].add(new edge(1,0));

        graph[2].add(new edge(2,0));
        graph[2].add(new edge(2,4));

        graph[3].add(new edge(3,1));
        graph[3].add(new edge(3,4));
        graph[3].add(new edge(3,5));

        graph[4].add(new edge(4,3));
        graph[4].add(new edge(4,5));
        graph[4].add(new edge(4,2));

        graph[5].add(new edge(5,3));
        graph[5].add(new edge(5,4));
        graph[5].add(new edge(5,6));


        graph[6].add(new edge(6,5));

        boolean vis[]=new boolean[graph.length];
        depthfirstsearch(graph,0,vis);

    }
    
}
