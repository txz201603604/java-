import java.util.Random;
import java.util.Scanner;




abstract class Transportation
{   int Sign;          //�жϽ�ͨ����
    double tostationT;//����վʱ��
	double returnT;   //�ӳ�վ����ʱ��
	double getticketT; //ȡƱʱ��
	double checkT;    //��Ʊʱ��
	double waitT;     //��ʱ��
	//����ȡ���ֵ
	
	double PT;       //���ɻ�����ʱ
	double TT;       //��������ʱ
	double CT;       //����������ʱ
	
	double Pspeed;   //�ɻ��ٶȣ�����ÿСʱ
	double Tspeed;   //���ٶȣ�����ÿСʱ
	double Cspeed;   //�����ٶȣ�����ÿСʱ
	
	
	double pprice;   //�ɻ�ÿ����۸�
	double tprice;   //��ÿ����۸�
	double cprice;   //����ÿ����۸�
	
	double Pprice;   //���ɻ��ܼ۸�
	double Tprice;   //�����ܼ۸�
	double Cprice;   //�������ܼ۸�
	
	
	public Transportation()
	{	
		Sign=0;
		
		tostationT=(double)(Math.random()*10);       
		returnT=(double)(Math.random()*10);
		getticketT=(double)(Math.random()*10);
		checkT=(double)(Math.random()*10);
		waitT=(double)(Math.random()*10);
		//����ȡ0~10֮�䣬��λΪ����
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
	 void Out()//���3�ֽ�ͨ���߸��Եļ۸��ʱ��
	{
		if(this.Sign==1)
		System.out.println("�ɻ�����ʱ�䣺"+String.format("%.2f",PT)+"����"+" �۸�"+String.format("%.2f",Pprice));
		if(this.Sign==2)
		System.out.println("������ʱ�䣺"+String.format("%.2f",TT)+"����"+" �۸�"+String.format("%.2f",Tprice));
		if(this.Sign==3)
		System.out.println("��������ʱ�䣺"+String.format("%.2f",CT)+"����"+" �۸�"+String.format("%.2f",Cprice));
	}
}

class Plane extends Transportation
{	
	String Start;  //������
	String Over;   //Ŀ�ĵ�
	double distance;    //���룬��λ����
	void Calculate()    //�������ɻ��ļ۸��ʱ��  
	{
		Pprice=distance*pprice; 
		PT=tostationT+returnT+getticketT+checkT+waitT+(60*distance/Pspeed);//ͳһʱ�䵥λ
		
	}
	public Plane(String a,String b,double c)//���캯����������أ�Ŀ�ĵغ;���
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
	double distance; //ͬ��
		void Calculate() //�������𳵵ļ۸��ʱ��
	{
		Tprice=distance*tprice;
		TT=tostationT+returnT+getticketT+checkT+waitT+(60*distance/Tspeed);//ͳһʱ�䵥λ
		
	}
	public Train(String a,String b,double c) //���캯����������أ�Ŀ�ĵغ;���
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
	double distance;//ͬ��
		void Calculate()//�����������ļ۸��ʱ��
	{
		Cprice=distance*cprice;
		CT=tostationT+returnT+getticketT+checkT+waitT+(60*distance/Cspeed);//ͳһʱ�䵥λ
		
	}
	public Car(String a,String b,double c)//���캯����������أ�Ŀ�ĵغ;���
	{
		this.Start=a;
		this.Over=b;
		this.distance=c;
		Sign=3;
	}
	
}


public class Control//������
{
	public static void main(String[] arge)
	{	
		for(;;)//��Ʊ�������������
		{
			System.out.println("��ӭʹ��,��Ʊ�밴1");
			Scanner cs = new Scanner(System.in);
			int X = cs.nextInt();
			if(X==1)
				{
					for(;;)
					{
						System.out.println("�����������");
						Scanner sc = new Scanner(System.in);
						String name1 = sc.nextLine();
						System.out.println("������Ŀ�ĵ�");
						String name2 = sc.nextLine();
						System.out.println("���������");
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
						System.out.println("�˳�ʹ���밴0");
						Scanner ab = new Scanner(System.in);
						int Y = ab.nextInt();
						if(Y==0) break;
					}
				}						
			
		}
	}
}


















