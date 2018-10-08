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

//����Arraylist
       long T1=0;               
       long SumT1=0;                             //T1��Ų���ÿ��Ԫ������ʱ�䣬SumT1������T1�ĺ�

       ArrayList<String> arraylist= new ArrayList<String>();
       
       for(int i=0;i<n;i++){
           String s1=UUID.randomUUID().toString();
           arraylist.add(s1);}                                //��arraylist��1000������ַ�
       
       for(int i=0;i<n;i++){
           String s1=arraylist.get(i);              //ȡ��arraylist��ÿ���ַ�
           long Stime=System.nanoTime();            //��ʼ��ʱ
           arraylist.contains(s1);                  //����ÿ���ַ�
           long Otime=System.nanoTime();            //��ʱ����
           T1=Otime-Stime;                          //����ÿ��Ԫ������ʱ��
           SumT1=SumT1+T1;}                         //ȫ��ʱ�����
           System.out.println("Arraylist����ʱ�䣺"+SumT1);


//����LinkedList       
       long T2=0;
       long SumT2=0;                            //T2��Ų���ÿ��Ԫ������ʱ�䣬SumT2������T2�ĺ�
     
       LinkedList<String> linkedlist=new LinkedList<String>();
       
       for(int i=0;i<n;i++){
           String s2=UUID.randomUUID().toString();
           linkedlist.add(s2);}                            //��linkedlist��1000������ַ�

       for(int i=0;i<n;i++){
           String s2=linkedlist.get(i);             //ȡ��linkedlist��ÿ���ַ�
           long Stime=System.nanoTime();            //��ʼ��ʱ
           linkedlist.contains(s2);                 //����ÿ���ַ�
           long Otime=System.nanoTime();            //��ʱ����
           T2=Otime-Stime;                          //����ÿ��Ԫ������ʱ��
           SumT2=SumT2+T2;}                         //ȫ��ʱ�����
           System.out.println("linkedlist����ʱ�䣺"+SumT2);



//����HashMap
       long T3=0;
       long SumT3=0;                          //T3��Ų���ÿ��Ԫ������ʱ�䣬SumT3������T3�ĺ�
     
       HashMap<String,String> hashmap=new HashMap<String,String>();
       ArrayList<String> list= new ArrayList<String>();
       
       for(int i=0;i<n;i++){
           String s3=UUID.randomUUID().toString();
           list.add(s3);
           hashmap.put(s3,s3);
            }                                    //��hashmap��1000������ַ�

       for(int i=0;i<n;i++){
           String s3=list.get(i);            //ȡ��hashmap��ÿ���ַ�
           long Stime=System.nanoTime();        //��ʼ��ʱ
           hashmap.containsKey(s3);             //����ÿ���ַ�
           long Otime=System.nanoTime();        //��ʱ����
           T3=Otime-Stime;                      //����ÿ��Ԫ������ʱ��
           SumT3=SumT3+T3;}                     //ȫ��ʱ�����
           System.out.println("hashmap����ʱ�䣺"+SumT3);




//����HashSet
       long T4=0;
       long SumT4=0;                          //T4��Ų���ÿ��Ԫ������ʱ�䣬SumT4������T4�ĺ�
     
       HashSet<String> hashset=new HashSet<String>();
       ArrayList<String> list1= new ArrayList<String>();
       
       for(int i=0;i<n;i++){
           String s4=UUID.randomUUID().toString();
           list1.add(s4);
           hashset.add(s4);
            }                                    //��hashset��1000������ַ�

       for(int i=0;i<n;i++){
           String s4=list1.get(i);                  //ȡ��hashset��ÿ���ַ�
           long Stime=System.nanoTime();            //��ʼ��ʱ
           hashset.contains(s4);                    //����ÿ���ַ�
           long Otime=System.nanoTime();           //��ʱ����
           T4=Otime-Stime;                         //����ÿ��Ԫ������ʱ��
           SumT4=SumT4+T4;}                        //ȫ��ʱ�����
           System.out.println("hashset����ʱ�䣺"+SumT4);
       



//����TreeMap
       long T5=0;
       long SumT5=0;                          //T5��Ų���ÿ��Ԫ������ʱ�䣬SumT5������T5�ĺ�
     
       TreeMap<String,String> treemap=new TreeMap<String,String>();
       ArrayList<String> list2= new ArrayList<String>();
       
       for(int i=0;i<n;i++){
           String s5=UUID.randomUUID().toString();
           list2.add(s5);
           treemap.put(s5,s5);
            }                                    //��treemap��1000������ַ�

       for(int i=0;i<n;i++){
           String s5=list2.get(i);                  //ȡ��treemap��ÿ���ַ�
           long Stime=System.nanoTime();            //��ʼ��ʱ
           treemap.containsKey(s5);                    //����ÿ���ַ�
           long Otime=System.nanoTime();           //��ʱ����
           T5=Otime-Stime;                         //����ÿ��Ԫ������ʱ��
           SumT5=SumT5+T5;}                        //ȫ��ʱ�����
           System.out.println("treemap����ʱ�䣺"+SumT5);


//����TreeSet
       long T6=0;
       long SumT6=0;                          //T6��Ų���ÿ��Ԫ������ʱ�䣬SumT6������T6�ĺ�
     
       TreeSet<String> treeset=new TreeSet<String>();
       ArrayList<String> list3= new ArrayList<String>();
       
       for(int i=0;i<n;i++){
           String s6=UUID.randomUUID().toString();
           list3.add(s6);
           treeset.add(s6);
            }                                    //��treeset��1000������ַ�

       for(int i=0;i<n;i++){
           String s6=list3.get(i);                  //ȡ��treeset��ÿ���ַ�
           long Stime=System.nanoTime();            //��ʼ��ʱ
           treeset.contains(s6);                    //����ÿ���ַ�
           long Otime=System.nanoTime();           //��ʱ����
           T6=Otime-Stime;                         //����ÿ��Ԫ������ʱ��
           SumT6=SumT6+T6;}                        //ȫ��ʱ�����
           System.out.println("treeset����ʱ�䣺"+SumT6);

       }
}


/*  ���
Arraylist����ʱ�䣺15767566
linkedlist����ʱ�䣺8532767
hashmap����ʱ�䣺255856
hashset����ʱ�䣺215537
treemap����ʱ�䣺1226528
treeset����ʱ�䣺503290
*/






