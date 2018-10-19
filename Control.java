import java.util.Random;
import java.util.Scanner;




abstract class Transportation
{   int Sign;          //判断交通工具
    double tostationT;//到车站时间
	double returnT;   //从车站返回时间
	double getticketT; //取票时间
	double checkT;    //检票时间
	double waitT;     //候车时间
	//以上取随机值
	
	double PT;       //坐飞机总用时
	double TT;       //坐火车总用时
	double CT;       //坐汽车总用时
	
	double Pspeed;   //飞机速度，公里每小时
	double Tspeed;   //火车速度，公里每小时
	double Cspeed;   //汽车速度，公里每小时
	
	
	double pprice;   //飞机每公里价格
	double tprice;   //火车每公里价格
	double cprice;   //汽车每公里价格
	
	double Pprice;   //坐飞机总价格
	double Tprice;   //坐火车总价格
	double Cprice;   //坐汽车总价格
	
	
	public Transportation()
	{	
		Sign=0;
		
		tostationT=(double)(Math.random()*10);       
		returnT=(double)(Math.random()*10);
		getticketT=(double)(Math.random()*10);
		checkT=(double)(Math.random()*10);
		waitT=(double)(Math.random()*10);
		//以上取0~10之间，单位为分钟
		PT=0;
		TT=0;
		CT=0;
		
		pprice=0.75;
		tprice=0.45;
		cprice=0.32;
		
		Pspeed=75;
		Tspeed=45;
		Cspeed=32;
		
		Tprice=0;
		Pprice=0;
		Cprice=0;
		
	
	}
	abstract void Calculate();
	 void Out()//输出3种交通工具各自的价格和时间
	{
		if(this.Sign==1)
		System.out.println("飞机所需时间："+String.format("%.2f",PT)+"分钟"+" 价格："+String.format("%.2f",Pprice));
		if(this.Sign==2)
		System.out.println("火车所需时间："+String.format("%.2f",TT)+"分钟"+" 价格："+String.format("%.2f",Tprice));
		if(this.Sign==3)
		System.out.println("汽车所需时间："+String.format("%.2f",CT)+"分钟"+" 价格："+String.format("%.2f",Cprice));
	}
}

class Plane extends Transportation
{	
	String Start;  //出发地
	String Over;   //目的地
	double distance;    //距离，单位公里
	void Calculate()    //计算坐飞机的价格和时间  
	{
		Pprice=distance*pprice; 
		PT=tostationT+returnT+getticketT+checkT+waitT+(60*distance/Pspeed);//统一时间单位
		
	}
	public Plane(String a,String b,double c)//构造函数输入出发地，目的地和距离
	{
		this.Start=a;
		this.Over=b;
		this.distance=c;
		Sign=1;
	}
}

class Train extends Transportation
{
	String Start;
	String Over;
	double distance; //同上
		void Calculate() //计算坐火车的价格和时间
	{
		Tprice=distance*tprice;
		TT=tostationT+returnT+getticketT+checkT+waitT+(60*distance/Tspeed);//统一时间单位
		
	}
	public Train(String a,String b,double c) //构造函数输入出发地，目的地和距离
	{
		this.Start=a;
		this.Over=b;
		this.distance=c;
		Sign=2;
	}
	
}

class Car extends Transportation
{
	String Start;
	String Over;
	double distance;//同上
		void Calculate()//计算坐汽车的价格和时间
	{
		Cprice=distance*cprice;
		CT=tostationT+returnT+getticketT+checkT+waitT+(60*distance/Cspeed);//统一时间单位
		
	}
	public Car(String a,String b,double c)//构造函数输入出发地，目的地和距离
	{
		this.Start=a;
		this.Over=b;
		this.distance=c;
		Sign=3;
	}
	
}


public class Control//主程序
{
	public static void main(String[] arge)
	{	
		for(;;)//购票界面和输入数据
		{
			System.out.println("欢迎使用,购票请按1");
			Scanner cs = new Scanner(System.in);
			int X = cs.nextInt();
			if(X==1)
				{
					for(;;)
					{
						System.out.println("请输入出发地");
						Scanner sc = new Scanner(System.in);
						String name1 = sc.nextLine();
						System.out.println("请输入目的地");
						String name2 = sc.nextLine();
						System.out.println("请输入距离");
						double number=sc.nextDouble();
						Plane a=new Plane(name1,name2,number);
						Train b=new Train(name1,name2,number);
						Car c=new Car(name1,name2,number);
						a.Calculate();
						b.Calculate();
						c.Calculate();
						a.Out();
						b.Out();
						c.Out();
						System.out.println("退出使用请按0");
						Scanner ab = new Scanner(System.in);
						int Y = ab.nextInt();
						if(Y==0) break;
					}
				}						
			
		}
	}
}


















