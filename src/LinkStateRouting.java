// Program to show the concept of Link State Routing in Computer Networks

import java.util.Scanner;
public class LinkStateRouting {
    public static void main(String[] args) {
        System.out.println("Name : Suraj Kumar");
        System.out.println("Registration Number : 20BCE2835");
        System.out.println("----------------------------------------------------------------");
        Scanner sc = new Scanner(System.in);
        // Take the number of node as input from the user
        System.out.print("Enter the number of nodes in the network : ");
        int nodes = sc.nextInt();
        int[] preArr = new int[nodes];
        int[] distance = new int[nodes]; // Array for storing the distance of each node of the network
        int[][] matrix = new int[nodes][nodes]; // 2D array for storing the cost of the nodes in the network
        int[] visited = new int[nodes]; // Array for keeping track of the nodes visited
        int min = 99999, nextNode = 0;
        System.out.println("Enter the elements in the cost matrix");

        for (int i = 0; i < distance.length; i++) {
            visited[i] = 0;
            preArr[i] = 0;

            for (int j = 0; j < distance.length; j++) {
                matrix[i][j] = sc.nextInt();
                if (matrix[i][j] == 0)
                    matrix[i][j] = 999;
            }
        }

        distance = matrix[0];
        visited[0] = 1;
        distance[0] = 0;

        for (int counter = 0; counter < nodes; counter++) {
            min = 999;
            for (int i = 0; i < nodes; i++) {
                if (min > distance[i] && visited[i] != 1) {
                    min = distance[i];
                    nextNode = i;
                }
            }

            visited[nextNode] = 1;
            for (int i = 0; i < nodes; i++) {
                if (visited[i] != 1) {
                    int val = min + matrix[nextNode][i];
                    if (val < distance[i]) {
                        distance[i] = val;
                        preArr[i] = nextNode;
                    }
                }
            }
        }


        int j;
        for (int i = 0; i < nodes; i++) {
            System.out.print("Cost = " + distance[i]);
            System.out.println();
        }
        System.out.println("\n");
    }
}
