import java.util.*;
class uni{
public static void main(String[] args){
HashSet<Integer>hs=new HashSet<>();
int[] arr={1,2,4,6,7};
int[] arr1={4,6,7,3,2};
//union
for(int i=0;i<arr.length;i++){
hs.add(arr[i]);
}
for(int i=0;i<arr1.length;i++){
hs.add(arr1[i]);
}
Iterator it=hs.iterator();
while(it.hasNext()){
System.out.print(it.next()+" ");
}
hs.clear();
//intersection
int c=0;
for(int i=0;i<arr.length;i++){
hs.add(arr[i]);
}
for(int i=0;i<arr1.length;i++){
if(hs.contains(arr1[i])){
System.out.print(arr1[i]);
hs.remove(arr1[i]);

}

}
}
}
