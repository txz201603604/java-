import java.util.LinkedList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.UUID;



public class TestFC   {
   public static void main(String[] args)  {

       int n=1000;

//测试Arraylist
       long T1=0;               
       long SumT1=0;                             //T1存放查找每个元素所用时间，SumT1是所有T1的合

       ArrayList<String> arraylist= new ArrayList<String>();
       
       for(int i=0;i<n;i++){
           String s1=UUID.randomUUID().toString();
           arraylist.add(s1);}                                //给arraylist加1000个随机字符
       
       for(int i=0;i<n;i++){
           String s1=arraylist.get(i);              //取得arraylist的每个字符
           long Stime=System.nanoTime();            //开始计时
           arraylist.contains(s1);                  //查找每个字符
           long Otime=System.nanoTime();            //计时结束
           T1=Otime-Stime;                          //查找每个元素所用时间
           SumT1=SumT1+T1;}                         //全部时间求和
           System.out.println("Arraylist查找时间："+SumT1);


//测试LinkedList       
       long T2=0;
       long SumT2=0;                            //T2存放查找每个元素所用时间，SumT2是所有T2的合
     
       LinkedList<String> linkedlist=new LinkedList<String>();
       
       for(int i=0;i<n;i++){
           String s2=UUID.randomUUID().toString();
           linkedlist.add(s2);}                            //给linkedlist加1000个随机字符

       for(int i=0;i<n;i++){
           String s2=linkedlist.get(i);             //取得linkedlist的每个字符
           long Stime=System.nanoTime();            //开始计时
           linkedlist.contains(s2);                 //查找每个字符
           long Otime=System.nanoTime();            //计时结束
           T2=Otime-Stime;                          //查找每个元素所用时间
           SumT2=SumT2+T2;}                         //全部时间求和
           System.out.println("linkedlist查找时间："+SumT2);



//测试HashMap
       long T3=0;
       long SumT3=0;                          //T3存放查找每个元素所用时间，SumT3是所有T3的合
     
       HashMap<String,String> hashmap=new HashMap<String,String>();
       ArrayList<String> list= new ArrayList<String>();
       
       for(int i=0;i<n;i++){
           String s3=UUID.randomUUID().toString();
           list.add(s3);
           hashmap.put(s3,s3);
            }                                    //给hashmap加1000个随机字符

       for(int i=0;i<n;i++){
           String s3=list.get(i);            //取得hashmap的每个字符
           long Stime=System.nanoTime();        //开始计时
           hashmap.containsKey(s3);             //查找每个字符
           long Otime=System.nanoTime();        //计时结束
           T3=Otime-Stime;                      //查找每个元素所用时间
           SumT3=SumT3+T3;}                     //全部时间求和
           System.out.println("hashmap查找时间："+SumT3);




//测试HashSet
       long T4=0;
       long SumT4=0;                          //T4存放查找每个元素所用时间，SumT4是所有T4的合
     
       HashSet<String> hashset=new HashSet<String>();
       ArrayList<String> list1= new ArrayList<String>();
       
       for(int i=0;i<n;i++){
           String s4=UUID.randomUUID().toString();
           list1.add(s4);
           hashset.add(s4);
            }                                    //给hashset加1000个随机字符

       for(int i=0;i<n;i++){
           String s4=list1.get(i);                  //取得hashset的每个字符
           long Stime=System.nanoTime();            //开始计时
           hashset.contains(s4);                    //查找每个字符
           long Otime=System.nanoTime();           //计时结束
           T4=Otime-Stime;                         //查找每个元素所用时间
           SumT4=SumT4+T4;}                        //全部时间求和
           System.out.println("hashset查找时间："+SumT4);
       



//测试TreeMap
       long T5=0;
       long SumT5=0;                          //T5存放查找每个元素所用时间，SumT5是所有T5的合
     
       TreeMap<String,String> treemap=new TreeMap<String,String>();
       ArrayList<String> list2= new ArrayList<String>();
       
       for(int i=0;i<n;i++){
           String s5=UUID.randomUUID().toString();
           list2.add(s5);
           treemap.put(s5,s5);
            }                                    //给treemap加1000个随机字符

       for(int i=0;i<n;i++){
           String s5=list2.get(i);                  //取得treemap的每个字符
           long Stime=System.nanoTime();            //开始计时
           treemap.containsKey(s5);                    //查找每个字符
           long Otime=System.nanoTime();           //计时结束
           T5=Otime-Stime;                         //查找每个元素所用时间
           SumT5=SumT5+T5;}                        //全部时间求和
           System.out.println("treemap查找时间："+SumT5);


//测试TreeSet
       long T6=0;
       long SumT6=0;                          //T6存放查找每个元素所用时间，SumT6是所有T6的合
     
       TreeSet<String> treeset=new TreeSet<String>();
       ArrayList<String> list3= new ArrayList<String>();
       
       for(int i=0;i<n;i++){
           String s6=UUID.randomUUID().toString();
           list3.add(s6);
           treeset.add(s6);
            }                                    //给treeset加1000个随机字符

       for(int i=0;i<n;i++){
           String s6=list3.get(i);                  //取得treeset的每个字符
           long Stime=System.nanoTime();            //开始计时
           treeset.contains(s6);                    //查找每个字符
           long Otime=System.nanoTime();           //计时结束
           T6=Otime-Stime;                         //查找每个元素所用时间
           SumT6=SumT6+T6;}                        //全部时间求和
           System.out.println("treeset查找时间："+SumT6);

       }
}


/*  结果
Arraylist查找时间：15767566
linkedlist查找时间：8532767
hashmap查找时间：255856
hashset查找时间：215537
treemap查找时间：1226528
treeset查找时间：503290
*/






