import java.awt.font.NumericShaper;
import java.util.Scanner;


import java.util.*;
import java.io.*;
import java.net.*;
import java.lang.Math;

class IPAddressing
{

    // Converts IP address to the binary form
    public static int[] bina(String[] str)
    {
        int re[] = new int[32];
        int a, b, c, d, i, rem;
        a = b = c = d = 1;
        Stack<Integer> st = new Stack<Integer>();

        // Separate each number of the IP address
        if (str != null)
        {
            a = Integer.parseInt(str[0]);
            b = Integer.parseInt(str[1]);
            c = Integer.parseInt(str[2]);
            d = Integer.parseInt(str[3]);
        }

        // convert first number to binary
        for (i = 0; i <= 7; i++)
        {
            rem = a % 2;
            st.push(rem);
            a = a / 2;
        }

        // Obtain First octet
        for (i = 0; i <= 7; i++) {
            re[i] = st.pop();
        }

        // convert second number to binary
        for (i = 8; i <= 15; i++) {
            rem = b % 2;
            st.push(rem);
            b = b / 2;
        }

        // Obtain Second octet
        for (i = 8; i <= 15; i++) {
            re[i] = st.pop();
        }

        // convert Third number to binary
        for (i = 16; i <= 23; i++) {
            rem = c % 2;
            st.push(rem);
            c = c / 2;
        }

        // Obtain Third octet
        for (i = 16; i <= 23; i++) {
            re[i] = st.pop();
        }

        // convert fourth number to binary
        for (i = 24; i <= 31; i++) {
            rem = d % 2;
            st.push(rem);
            d = d / 2;
        }

        // Obtain Fourth octet
        for (i = 24; i <= 31; i++) {
            re[i] = st.pop();
        }

        return (re);
    }

    // Converts IP address
    // from binary to decimal form
    public static int[] deci(int[] bi)
    {

        int[] arr = new int[4];
        int a, b, c, d, i, j;
        a = b = c = d = 0;
        j = 7;

        for (i = 0; i < 8; i++) {

            a = a + (int)(Math.pow(2, j)) * bi[i];
            j--;
        }

        j = 7;
        for (i = 8; i < 16; i++) {

            b = b + bi[i] * (int)(Math.pow(2, j));
            j--;
        }

        j = 7;
        for (i = 16; i < 24; i++) {

            c = c + bi[i] * (int)(Math.pow(2, j));
            j--;
        }

        j = 7;
        for (i = 24; i < 32; i++) {

            d = d + bi[i] * (int)(Math.pow(2, j));
            j--;
        }

        arr[0] = a;
        arr[1] = b;
        arr[2] = c;
        arr[3] = d;
        return arr;
    }

    public static int NumberOfAddresses(String ip)
    {

        int i;
        String[] str = new String[4];
        String ipr = ip;
        // Separate IP address and n
        String[] str1 = ipr.split("/");

        // IP address
        String tr = str1[0];

        // Split IP address into 4 subparts x, y, z, t
        str = tr.split("\\.");

        int[] b = new int[32];

        System.out.println();

        // Convert IP address to binary form
        b = bina(str);

        int n = Integer.parseInt(str1[1]);
        int[] ntwk = new int[32];
        int[] brd = new int[32];
        int t = 32 - n;

        // Obtaining network address
        for (i = 0; i <= (31 - t); i++) {

            ntwk[i] = b[i];
            brd[i] = b[i];
        }

        // Set 32-n bits to 0
        for (i = 31; i > (31 - t); i--) {

            ntwk[i] = 0;
        }

        // Obtaining Broadcast address
        // by setting 32-n bits to 1
        for (i = 31; i > (31 - t); i--) {

            brd[i] = 1;
        }

        System.out.println();
        // Converting network address to decimal
        int[] nt = deci(ntwk);

        // Converting broadcast address to decimal
        int[] br = deci(brd);


        int addresses = br[3] - nt[3] + 1 - 2;
        return addresses;
    }
    public static void main(String[] args)
    {
        System.out.println("Name : Suraj Kumar");
        System.out.println("Registration Number : 20BCE2835");
        System.out.println("--------------------------------------------------------");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the IP address of the user : ");
        String ip = sc.next();
        int addresses = NumberOfAddresses(ip);
        int totAddresses = 0;
        System.out.println("Enter the number of groups : ");
        int groups = sc.nextInt();
        for(int i = 1 ; i <= groups ; i++){
            System.out.println("GROUP " + i + ":");
            System.out.println("Enter the number of customers : ");
            int customer = sc.nextInt();
            System.out.println("Enter the number of systems for each customer of the group :");
            int systems = sc.nextInt();
            totAddresses = totAddresses + customer * systems;
        }
        int diff = addresses - totAddresses;
        System.out.println("Number of addresses still left after the allocations : " + diff);
    }
}
