import java.util.*;
public class allpathfromsource {
     static class edge{
        int src;
        int dest;
        edge(int src,int dest)
        {
            this.src=src;
            this.dest=dest;

        }

    }
    public static void pathssourcetodestination(ArrayList<edge>graph[],int src,int dest,String path)
    {
        if(src==dest)
        {
            System.out.print(path+dest+"  ");
            return;

        }
        for(int i=0;i<graph[src].size();i++)
        {
            edge e=graph[src].get(i);
            pathssourcetodestination(graph,e.dest,dest,path+src);
        }
    }
    public static void main(String args[])
    {
        ArrayList<edge>graph[]=new ArrayList[6];
        for(int i=0;i<graph.length;i++)
        {
            graph[i]=new ArrayList<>();
        }
        graph[5].add(new edge(5,2));
        graph[5].add(new edge(5,0));
        graph[2].add(new edge(2,3));
        graph[3].add(new edge(3,1));
        graph[0].add(new edge(0,3));
        graph[4].add(new edge(4,0));
        graph[4].add(new edge(4,1));

        String path=new String("");
        pathssourcetodestination(graph,5,1,path);
    }
    
}
