import java.util.*;
public class breadthserach{
   static  class edge{
        int src;
        int dest;
        public edge(int src,int dest)
        {
            this.src=src;
            this.dest=dest;
        }

    }
    public static  void breadthfirstsearch(ArrayList<edge>graph[])
    {
        Queue<Integer>q=new LinkedList<>();
        boolean b[]=new boolean[graph.length];
        q.add(0);
        while(!q.isEmpty())
        {
            int curr=q.remove();
            if(!b[curr])
            {
                System.out.println(curr);
                b[curr]=true;
                for(int i=0;i<graph[curr].size();i++)
                {
                    edge e=graph[curr].get(i);
                    q.add(e.dest);

                }
            }
        }
    }
   
    public static void main(String args[])
    {
        int v=7;
        ArrayList<edge> graph[]=new ArrayList[v];
        for(int i=0;i<v;i++)
        {
            graph[i]=new ArrayList<>();
        }
        //adding to graph index 0;
        graph[0].add(new edge(0,1));
        graph[0].add(new edge(0,2));
        //adding to graph index1;
    
    
        graph[1].add(new edge(1,3));
        graph[1].add(new edge(1,0));
    
        //adding to graph index2;
        graph[2].add(new edge(2,0));
        graph[2].add(new edge(2,4));
    
        //adding to graph index 3
        graph[3].add(new edge(3,1));
        graph[3].add(new edge(3,5));
        //adding to graph index 4
    
        graph[4].add(new edge(4,2));
        graph[4].add(new edge(4,5));
    
        graph[5].add(new edge(5,3));
        graph[5].add(new edge(5,4));
        graph[5].add(new edge(5,6));
    
        graph[6].add(new edge(6,5));
        
        breadthfirstsearch(graph);
    }
    
}
