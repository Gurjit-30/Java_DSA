

 public class factorial {
    public static int fact(int n){
        int product=1;
        for(int i=1;i<=n;i++){
            product *=i;
        }
        return product;
    }
    public static void main(String []args){
        
        System.out.println(fact(9));
    }
    
}
