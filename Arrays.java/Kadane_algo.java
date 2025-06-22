import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    public static void main(String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
        {
            arr[i] = sc.nextInt();

        }int ma=Integer.MIN_VALUE,cs=0;
        for(int i=0;i<n;i++){
             
            if(cs<0){
                cs=0;
                
            }
             cs+=arr[i];
          
            ma=Math.max(cs,ma);
        }
        System.out.println(ma);
        
    // your code goes here


}
}