import java.util.*;
public class dikshtaraalgori {
    static class edge{
        int src;
        int dest;
        int weight;
        edge(int src,int destination,int weight)
        {
            this.src=src;
            this.dest=destination;
            this.weight=weight;

        }
    }

     static class pair implements Comparable<pair>{
        int n;
        int distance;
        pair(int n,int distance)
        {
            this.n=n;
            this.distance=distance;

        }
        @override
        public int compareTo(pair p2)
        {
            return this.distance-p2.distance;
        }
     }
     public static int dikstra(ArrayList<edge>graph[],int src)
     {
       PriorityQueue<pair>q=new PriorityQueue<>();
        q.add(new pair(0,0));
         int initializer[]=new int [graph.length];
         for(int i=0;i<initializer.length;i++)
         {
            if(src!=i)
            { 
                initializer[i]=Integer.MAX_VALUE;

            }
         }

        boolean vis[]=new boolean[graph.length];
        while(!q.isEmpty())
        {
            pair curr=q.remove();
            if(!vis[curr.n])
            {
                vis[curr.n]=true;
                for(int i=0;i<graph[curr.n].size();i++)
                {
                    edge e=graph[curr.n].get(i);
                    int u=e.src;
                    int v=e.dest;
                    int weight=e.weight;
                    if(initializer[u]+weight<initializer[v])
                    {
                        initializer[v]=initializer[u]+weight;
                        q.add(new pair(v,initializer[v]));


                    }
                }
            }

        }
        return initializer[initializer.length-1];
    

     }
    public static void main(String args[])
    {
        int v=6;
        ArrayList<edge>graph[]=new ArrayList[v];
        for(int i=0;i<graph.length;i++)
        {
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new edge(0,1,2));
        graph[0].add(new edge(0,2,4));


        graph[1].add(new edge(1,3,7));
        graph[1].add(new edge(1,2,1));

        graph[2].add(new edge(0,2,4));
        graph[2].add(new edge(2,4,3));

        graph[3].add(new edge(3,5,1));

        graph[4].add(new edge(4,3,2));
        graph[4].add(new edge(4,5,5));



        int src=0;
       System.out.println(dikstra(graph,src));

    }
    
}
