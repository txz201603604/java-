public class nursery{
public static void main(String[] a){
int n=99;
while(n>1){
System.out.println(n+" bottles of beer on the wall,"+n+" bottles of beer");
System.out.println("take one down");
System.out.println("pass it around");
n--;
}
while(n==1){
System.out.println("one bottle of beer on the wall,one bottle of beer");
System.out.println("take one down");
System.out.println("pass it around");
n--;
}
while(n==0){
System.out.println("no more bottles of beer on the wall");
n--;
}
}
}