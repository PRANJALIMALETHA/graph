import java.util.*;
public class topologicalsort {
     static class edge{
        int src;
        int dest;
        edge(int src,int dest)
        {
            this.src=src;
            this.dest=dest;
        }
     }
     public static void toposortusingbfs(ArrayList<edge>graph[])
     {
       int indeg[]=new int[graph.length];
       Queue<Integer>q=new LinkedList<>();
       
     }

     public static  void topologicalsort(ArrayList<edge>graph[])
     {
        Stack<Integer>st=new Stack<>();
        boolean vis[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++)
        {
            if(!vis[i])
            {
                topo(graph,st,i,vis);
            }
        }
        while(!st.isEmpty())
        {
            System.out.println(st.pop()+" ");
        }
     }
     public static void topo(ArrayList<edge>graph[],Stack<Integer>st,int curr,boolean vis[])
     {
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++)
        {
            edge e=graph[curr].get(i);
            if(!vis[e.dest])
            {
                topo(graph,st,e.dest,vis);
            }
        }
        st.push(curr);

     }
    public static void main(String args[])
    {
        ArrayList<edge>graph[]=new ArrayList[6];
        for(int i=0;i<graph.length;i++)
        {
            graph[i]=new ArrayList<>();
        }
        graph[2].add(new edge(2,3));
        graph[3].add(new edge(3,1));
        graph[4].add(new edge(4,1));
        graph[4].add(new edge(4,0));
        graph[5].add(new edge(5,0));
        graph[5].add(new edge(5,2));


        topologicalsort(graph);
    }
    
}
