import java.util.Random;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;



class BD{   //生日类，Staff，Manager，Holder的父类
	int By;  //出生年
	int Bm;  //出生月
	int Bd;  //出生日
	
	static String[] name={"田","李","王","吴","崔","郑","刘","彭"};
	static String[] num={"一","二","三","四","五","六","七","八"};
	static String[] num1={"一","二","三","四","五","六","七","八"};//存放随机的名和姓
	
	int nameLength=name.length;
	int numLength=num.length;
	int num1Length=num1.length;//3个数组的长度
	
	int rand1=(int)(Math.random()*nameLength);
	int rand2=(int)(Math.random()*numLength);
	int rand3=(int)(Math.random()*num1Length);//从3个数组中分别随机取字组成名字
	
	public BD(){//随机生成生日
	By=(int)(Math.random()*30+1980);
	Bm=(int)(Math.random()*12);
	Bd=(int)(Math.random()*30);
	}
}



class Staff extends BD{
	String Sname;   //职工的姓名
	int Smoney;     //职工的工资
	public Staff()throws IOException{            //构造函数
		Sname=name[rand1]+num[rand2]+num[rand3]; //名字随机生成
		Smoney=(int)(Math.random()*1000+4000);   //工资随机生成4000-5000
		
		File file =new File("D:\\Staff.txt");    //将员工信息存入D盘的Staff.txt文件
		if (!file.exists()) {
            file.createNewFile();
		}  //若没有Staff.txt文件则新建
		Writer out =new FileWriter(file,true);     //向文件写入数据不覆盖
		String data="员工姓名:"+Sname+" 工资:"+Smoney+" 出生年月日:"+By+"."+Bm+"."+Bd+"\r\n";
		out.write(data);    //写入的信息并自动换行
		out.close();        
		}
}



class Manager extends BD{
	String Mname;   //经理的姓名
	int Mmoney;     //经理的工资
	int Mbonus;     //经理的奖金
	public Manager()throws IOException{
		Mname=name[rand1]+num[rand2]+"经理";       //名字随机生成
		Mmoney=(int)(Math.random()*1000+9000);     //工资随机生成
		Mbonus=(int)(Math.random()*5000+5000);     //奖金随机生成 
		
		File file =new File("D:\\Manager.txt");    //将经理信息存入D盘的Manager.txt文件
		if (!file.exists()) {
            file.createNewFile();
		} //若没有Manager.txt文件则新建
		Writer out =new FileWriter(file,true);     //向文件写入数据不覆盖
		String data="经理姓名:"+Mname+" 工资:"+Mmoney+" 奖金"+Mbonus+" 出生年月日:"+By+"."+Bm+"."+Bd+"\r\n";
		out.write(data);      //写入的信息并自动换行
		out.close();
		}	
}


class Holder extends BD{
	String Hname;     //股东的姓名
	double Hmoney;    //股东的分红
	public Holder(double a)throws IOException{
		Hname=name[rand1]+"股东";         //名字随机生成
		Hmoney=a*0.1;                     //分红为公司收入的10%
		
		File file =new File("D:\\Holder.txt");     //将经理信息存入D盘的Holder.txt文件
		if (!file.exists()) {
            file.createNewFile();
		} 
		Writer out =new FileWriter(file,true);     //向文件写入数据不覆盖
		String data="股东姓名:"+Hname+" 分红:"+Hmoney+" 出生年月日:"+By+"."+Bm+"."+Bd+"\r\n";
		out.write(data);      //写入的信息并自动换行
		out.close();
	}
}



class Company {
	double Cincome;  //公司收入
	ArrayList<Staff> Stafflist=new ArrayList<Staff>();        //存放该公司的员工
	ArrayList<Manager> Managerlist=new ArrayList<Manager>();  //存放该公司的经理
	ArrayList<Holder> Holderlist=new ArrayList<Holder>();     //存放该公司的股东
	
	public Company()throws IOException{
		Cincome=(int)(Math.random()*10)*1000000+1000000;      //收入随机生成1百万到1千万
		for(int i=0;i<(int)(Math.random()*10+10);i++){        //创建公司对象时，创建随机个数的公司员工，并存入Stafflist
			Stafflist.add(new Staff());}
		for(int i=0;i<(int)(Math.random()*2+5);i++){          //创建公司对象时，创建随机个数的公司经理，并存入Managerlist
			Managerlist.add(new Manager());}
		for(int i=0;i<(int)(Math.random()*4+1);i++){          //创建公司对象时，创建随机个数的公司股东，并存入Holderlist
			Holderlist.add(new Holder(this.Cincome));}
	}
	
	public void GetInfmt(){     //输出全体人员的信息
		for(int i=0;i<Stafflist.size();i++){         //输出Stafflist中的所有职员
			Stafflist.get(i);
			System.out.println("员工："+Stafflist.get(i).Sname+" 工资："+Stafflist.get(i).Smoney);}
		for(int i=0;i<Managerlist.size();i++){       //输出Managerlist中的所有经理
			Managerlist.get(i);
			System.out.println("经理："+Managerlist.get(i).Mname+" 工资："+Managerlist.get(i).Mmoney+" 奖金："+Managerlist.get(i).Mbonus);}
		for(int i=0;i<Holderlist.size();i++){        //输出Managerlist中的所有股东
			Holderlist.get(i);
			System.out.println("股东："+Holderlist.get(i).Hname+" 分红："+Holderlist.get(i).Hmoney);}
	}
	
	public void ShowProfit(){   //输出公司的利润及各种支出
		double Profit=0;        //公司利润
		double SOutput=0;       //公司职员的工资总和
		double MOutput=0;       //公司经理的工资与奖金的总和
		double HOutput=0;       //公司股东分红总和
		
		System.out.println("公司收入："+Cincome);             //输出公司收入
		for(int i=0;i<Stafflist.size();i++){
			SOutput=SOutput+Stafflist.get(i).Smoney;}  
			System.out.println("员工工资的总和："+SOutput);//求职工的工资总和并输出
			
		for(int i=0;i<Managerlist.size();i++){
			MOutput=MOutput+Managerlist.get(i).Mmoney+Managerlist.get(i).Mbonus;}
			System.out.println("经理的工资和奖金的总和："+MOutput);//求经理工资和奖金的总和并输出
			
		HOutput=Cincome*0.1*Holderlist.size();        
		System.out.println("股东分红的总和："+HOutput);    //求股东分红总和并输出
			
		Profit=Cincome-HOutput-SOutput-MOutput;       //求公司利润
		System.out.println("公司的利润："+Profit);                     //输出公司利润
	}
	
	public void Check(String name,int Bm){   	//对比姓名和出生月份查询，输出正常工资和生日月的工资
		boolean  result=false;                  //用来判断公司是否存在这个人
		
		for(int i=0;i<Stafflist.size();i++){    //现在员工表Stafflist中查找
			if(Stafflist.get(i).Sname==name){
				if(Stafflist.get(i).Bm==Bm){
				System.out.println("姓名："+Stafflist.get(i).Sname+" 工资："+Stafflist.get(i).Smoney+" 出生月的工资："+2*Stafflist.get(i).Smoney);
				result=true;
				}
			}
		}
		
		for(int i=0;i<Managerlist.size();i++){  //然后在经理表Managerlist中查找
			if(Managerlist.get(i).Mname==name){
				if(Managerlist.get(i).Bm==Bm){
				System.out.println("姓名:"+Managerlist.get(i).Mname+" 工资："+Managerlist.get(i).Mmoney+" 出生月工资："+3*Managerlist.get(i).Mmoney+" 奖金"+Managerlist.get(i).Mbonus);
				result=true;
				}
			}
		}
		
		for(int i=0;i<Holderlist.size();i++){   //最后在股东表Holderlist中查找
			if(Holderlist.get(i).Hname==name){
				if(Holderlist.get(i).Bm==Bm){
				System.out.println("姓名："+Holderlist.get(i).Hname+"分红："+Holderlist.get(i).Hmoney);
				result=true;	
				}
			}
		}
	if(result==false)           //没有找到就输出
		System.out.println("查无此人");
	}
	
	
}

public class Testcompany{
     public static void main(String[] arge)throws IOException{
		Company A1=new Company();   //创建一个公司，其中成员已被随机创建，并存入TET文本中
		A1.GetInfmt();              //测试获取信息函数
		A1.ShowProfit();            //测试输出利润及支出函数
		A1.Check("吴三一",9);       //测试查找工资函数，由于公司成员是随机生成，我不知道有哪些，所以随便查一个，员工自己当然是可以查得到的
	 }	
	}