package com.hackerRank;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        
        //Receive input
        int n,k;
        int result = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        n = Integer.parseInt(s.split(" ")[0]);
        k = Integer.parseInt(s.split(" ")[1]);
        int[][] arr = new int[n][n];
        for(int i=0; i<n;i++){
            for(int j=0; j<n; j++) {
                arr[i][j] = 0;
            }
        }
        for(int i=0; i < k; i++){
            s = br.readLine();
            int x = Integer.parseInt(s.split(" ")[0]);
            int y = Integer.parseInt(s.split(" ")[1]);
            arr[x][y] = 1;
        }
        
        //Start processing
        for(int j = 1; j < n-1; j++){
            int x = 0, y=n-1;
            while(x < n && arr[x][j] != 1 )
                x++;
            while(y >= 0 && arr[y][j] != 1)
                y--;
            if(x<y){
                for(int i=x+1; i<y; i++)
                    if(arr[i][j] == 0)
                        arr[i][j] = 3;
            }
        }
        for(int i = 1; i < n-1; i++){
            int x = 0, y=n-1;
            while(x < n && arr[i][x] != 1 )
                x++;
            while(y >= 0 && arr[i][y] != 1)
                y--;
            if(x<y){
                for(int j=x+1; j<y; j++) {
                    if(arr[i][j] == 3)
                        arr[i][j] = 4;
                }
            }
        }
        for(int i=0; i<n;i++){
            for(int j=0; j<n; j++) {
                if (arr[i][j] == 4)
                    result++;
            }
        }
        System.out.println(result);
    }
}