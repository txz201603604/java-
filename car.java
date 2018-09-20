public class car{
public char CN;//车型号
public int Tank;//油箱
public int Oilconsumption;//车耗油量
public void setcar(char name,int tank,int oilconsumption)//创建车的属性
{CN=name;Tank=tank;Oilconsumption=oilconsumption;}

public void printcar()//输出车的属性
{System.out.println("车名:"+CN+"油箱:"+Tank+"耗油量:"+Oilconsumption);}

public static void main(String[] args){
car[] carlist=new car[100];//创建存放car对象的引用变量的数组

int n=1;
for(;n<4;n++)
{carlist[n]=new car();//循环给数组中的引用变量赋值
 char x=(char)(n+64);//将n+64转换为ascll码作为车型号
 carlist[n].setcar(x,n*100,n*10);}//循环创建车的属性

int m=1;
for(;m<4;m++){carlist[m].printcar();}//循环输出车属性
}
}

