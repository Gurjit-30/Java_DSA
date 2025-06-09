public class Binomial_Coefficient{
    public static int factorial(int x){
        int prod=1;
        for(int i=1;i<=x;i++){
            prod*=i;

        }
        return prod;
    }
    public static void main(String[] args){
        int n=5,r=2;
        System.out.println(factorial(n)/(factorial(r)*factorial(n-r)));
    }
}