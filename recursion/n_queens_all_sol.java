import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    public static boolean isSafe(char[][] boa,int r,int c){
        //left
        for(int i=r-1,j=c-1;i>=0 && j>=0;i--,j--){
            if(boa[i][j]=='Q'){
                return false;
            }
        }
        //right
        for(int i=r-1,j=c+1;i>=0 && j<boa.length;i--,j++){
            if(boa[i][j]=='Q'){
                return false;
            }
        }
        //super
        for(int i=r-1;i>=0;i--){
            if(boa[i][c]=='Q'){
                return false;
            }
        }
        return true;
    }
    public static void queen(char[][] boa,int r){
        if(r==boa.length){
            System.out.println("-----------chess-----");
            for(int i=0;i<boa.length;i++){
	        for(int j=0;j<boa.length;j++){
	           System.out.print(boa[i][j]+" "); 
	        }
	        System.out.println();
	    }
            return;
        }
        for(int j=0;j<boa.length;j++){
            if(isSafe(boa,r,j)){
                boa[r][j]='Q';
                 queen(boa,r+1);
            boa[r][j]='*';
            }
            
            
        }
        
    }
	public static void main (String[] args) throws java.lang.Exception
	{
	    int n=8;
	    char boa[][]=new char[n][n];
	    for(int i=0;i<n;i++){
	        for(int j=0;j<n;j++){
	            boa[i][j]='*';
	        }
	    }
	    queen(boa,0);
	     
		// your code goes here

	}
}
