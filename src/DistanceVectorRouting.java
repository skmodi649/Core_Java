// Program to show the concept of Distance Vector Routing

import java.util.Scanner;

public class DistanceVectorRouting {
    static int Graph[][];
    static int via[][];
    static int rt[][];
    static int v;
    static int e;

    public static void main(String args[])
    {
        System.out.println("Name : Suraj Kumar");
        System.out.println("Registration Number : 20BCE2835");
        System.out.println("---------------------------------------------------");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices : ");
        v = sc.nextInt();
        System.out.println("Enter the number of edges : ");
        e = sc.nextInt();

        Graph = new int[v][v];
        via = new int[v][v];
        rt = new int[v][v];
        for(int i = 0; i < v; i++)
            for(int j = 0; j < v; j++)
            {
                if(i == j)
                    Graph[i][j] = 0;
                else
                    Graph[i][j] = 99999;
            }
        for(int i = 0; i < e; i++)
        {
            System.out.println("Edge " + (i + 1) + ":");
            System.out.print("Source: ");
            int s = sc.nextInt();
            s--;
            System.out.print("Destination: ");
            int d = sc.nextInt();
            d--;
            System.out.print("Cost: ");
            int c = sc.nextInt();
            Graph[s][d] = c;
            Graph[d][s] = c;
        }

        calc_disp("INTITIAL ROUTING TABLES : ");

        System.out.print("Source of the changed node : ");
        int s = sc.nextInt();
        s--;
        System.out.print("Destination of the changed node : ");
        int d = sc.nextInt();
        d--;
        System.out.print("Cost : ");
        int c = sc.nextInt();
        Graph[s][d] = c;
        Graph[d][s] = c;

        calc_disp("NEW ROUTING TABLES : ");
    }

    // method for calulating the distance
    static void calc_disp(String message)
    {
        System.out.println();
        init_tables();
        update_tables();
        System.out.println(message);
        print_tables();
        System.out.println();
    }

    // method for updating the distance vector table
    static void update_table(int source)
    {
        for(int i = 0; i < v; i++)
        {
            if(Graph[source][i] != 9999)
            {
                int dist = Graph[source][i];
                for(int j = 0; j < v; j++)
                {
                    int inter_dist = rt[i][j];
                    if(via[i][j] == source)
                        inter_dist = 9999;
                    if(dist + inter_dist < rt[source][j])
                    {
                        rt[source][j] = dist + inter_dist;
                        via[source][j] = i;
                    }
                }
            }
        }
    }

    static void update_tables()
    {
        int k = 0;
        for(int i = 0; i < 4*v; i++)
        {
            update_table(k);
            k++;
            if(k == v)
                k = 0;
        }
    }

    static void init_tables()
    {
        for(int i = 0; i < v; i++)
        {
            for(int j = 0; j < v; j++)
            {
                if(i == j)
                {
                    rt[i][j] = 0;
                    via[i][j] = i;
                }
                else
                {
                    rt[i][j] = 9999;
                    via[i][j] = 100;
                }
            }
        }
    }

    static void print_tables()
    {
        for(int i = 0; i < v; i++)
        {
            for(int j = 0; j < v; j++)
            {
                System.out.print("Dist: " + rt[i][j] + "    ");
            }
            System.out.println();
        }
    }
}
