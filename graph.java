import java.util.*;
public class graph{
     static class edge
     {
        int src;
        int dest;
        int weight;

        edge(int src,int dest,int weight)
        {
            this.src=src;
            this.dest=dest;
            this.weight=weight;
        }
    }
    public  static void Breadthfirsttraversal(ArrayList<edge>list[])
    { 
        Queue<Integer>q=new LinkedList<>();
        boolean vis[]=new boolean[list.length];
        q.add(0);
        while(!q.isEmpty())
        {
            int curr=q.remove();
            if(!vis[curr])
            {
                System.out.println(curr);
                vis[curr]=true;
                for(int i=0;i<list[curr].size();i++)
                {
                    edge e=list[curr].get(i);
                    q.add(e.dest);
                }
            }

        }
    }
    public static void dfs(ArrayList<edge>graph[],int curr,boolean b[])
    {
        System.out.println(curr);
        b[curr]=true;
        for(int i=0;i<graph[curr].size();i++)
        {
            edge e=graph[curr].get(i);
            if(!b[e.dest])
            {
               dfs(graph,e.dest,b);
            }
        }

    }



    public static boolean  haspath(ArrayList<edge>graph[],int src,int dest,boolean b[])
    {
        if(src==dest)
        {
            return true;
        }
        int curr=src;
        b[curr]=true;
        for(int i=0;i<graph[curr].size();i++)
        {
            edge e=graph[curr].get(i);
            if(!b[e.dest]&&haspath(graph,e.dest,dest,b)){
                return true;
            }
        }
        return false;

    }
    public static void main(String args[])
    {
        int V=5;
        ArrayList<edge>[]graph=new ArrayList[V];
        for(int i=0;i<V;i++)
        {
         graph[i]=new ArrayList<>();

        }

        graph[0].add(new edge(0,1,5));
        
        //1 vertex
        graph[1].add(new edge(1,2,1));
        graph[1].add(new edge(1,0,5));
        graph[1].add(new edge(1,3,5));


        //2 vertex
        graph[2].add(new edge(2,4,4));
        graph[2].add(new edge(2,3,1));
        graph[2].add(new edge(2,1,1));

        graph[3].add(new edge(3,1,3));
        graph[3].add(new edge(3,2,1));


        graph[4].add(new edge(4,2,2));
        boolean b[]=new boolean[graph.length];
        int curr=0;
        Breadthfirsttraversal(graph);
        dfs(graph,curr,b);
        int src=0;
        int dest=4;

        System.out.println(haspath(graph,src,dest,b));

    }
}