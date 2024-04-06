import java.util.*;
public class topologicalsortusingbfs {
    static class edge{
        int src;
        int dest;
         edge(int src,int dest)
         {
            this.src=src;
            this.dest=dest;
         }
    }
    public static void intializer(ArrayList<edge>graph[])
    {
        int inciming[]=new int[graph.length];
        for(int i=0;i<graph.length;i++)
        {
            for(int j=0;j<graph[i].size();j++)
            {
                 edge e=graph[i].get(j);
                 inciming[e.dest]++;
            }
        }
        bfstopsort(graph,inciming);
    }
    public static void bfstopsort(ArrayList<edge>graph[],int inciming[])
    {
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<inciming.length;i++)
        {
            if(inciming[i]==0)
            {
                q.add(i);
            }
        }

        while(!q.isEmpty())
        {
            int curr=q.remove();
            System.out.println(curr +" ");
            for(int i=0;i<graph[curr].size();i++)
            {
                edge  e=graph[curr].get(i);
                inciming[e.dest]--;
                if(inciming[e.dest]==0)
                {
                    q.add(e.dest);
                }
            }

        }

    }
    public static void main(String args[])
    {
        ArrayList<edge>graph[]=new ArrayList[6];
        for(int i=0;i<graph.length;i++)
        {
            graph[i]=new ArrayList<>();
        }
        graph[4].add(new edge(4,0));
        graph[4].add(new edge(4,1));
        graph[5].add(new edge(5,0));
        graph[5].add(new edge(5,2));
        graph[2].add(new edge(2,3));
        graph[3].add(new edge(3,1));



        intializer(graph);

    }
    
}
