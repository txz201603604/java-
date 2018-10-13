import java.util.Random;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;



class BD{   //�����࣬Staff��Manager��Holder�ĸ���
	int By;  //������
	int Bm;  //������
	int Bd;  //������
	
	static String[] name={"��","��","��","��","��","֣","��","��"};
	static String[] num={"һ","��","��","��","��","��","��","��"};
	static String[] num1={"һ","��","��","��","��","��","��","��"};//��������������
	
	int nameLength=name.length;
	int numLength=num.length;
	int num1Length=num1.length;//3������ĳ���
	
	int rand1=(int)(Math.random()*nameLength);
	int rand2=(int)(Math.random()*numLength);
	int rand3=(int)(Math.random()*num1Length);//��3�������зֱ����ȡ���������
	
	public BD(){//�����������
	By=(int)(Math.random()*30+1980);
	Bm=(int)(Math.random()*12);
	Bd=(int)(Math.random()*30);
	}
}



class Staff extends BD{
	String Sname;   //ְ��������
	int Smoney;     //ְ���Ĺ���
	public Staff()throws IOException{            //���캯��
		Sname=name[rand1]+num[rand2]+num[rand3]; //�����������
		Smoney=(int)(Math.random()*1000+4000);   //�����������4000-5000
		
		File file =new File("D:\\Staff.txt");    //��Ա����Ϣ����D�̵�Staff.txt�ļ�
		if (!file.exists()) {
            file.createNewFile();
		}  //��û��Staff.txt�ļ����½�
		Writer out =new FileWriter(file,true);     //���ļ�д�����ݲ�����
		String data="Ա������:"+Sname+" ����:"+Smoney+" ����������:"+By+"."+Bm+"."+Bd+"\r\n";
		out.write(data);    //д�����Ϣ���Զ�����
		out.close();        
		}
}



class Manager extends BD{
	String Mname;   //���������
	int Mmoney;     //����Ĺ���
	int Mbonus;     //����Ľ���
	public Manager()throws IOException{
		Mname=name[rand1]+num[rand2]+"����";       //�����������
		Mmoney=(int)(Math.random()*1000+9000);     //�����������
		Mbonus=(int)(Math.random()*5000+5000);     //����������� 
		
		File file =new File("D:\\Manager.txt");    //��������Ϣ����D�̵�Manager.txt�ļ�
		if (!file.exists()) {
            file.createNewFile();
		} //��û��Manager.txt�ļ����½�
		Writer out =new FileWriter(file,true);     //���ļ�д�����ݲ�����
		String data="��������:"+Mname+" ����:"+Mmoney+" ����"+Mbonus+" ����������:"+By+"."+Bm+"."+Bd+"\r\n";
		out.write(data);      //д�����Ϣ���Զ�����
		out.close();
		}	
}


class Holder extends BD{
	String Hname;     //�ɶ�������
	double Hmoney;    //�ɶ��ķֺ�
	public Holder(double a)throws IOException{
		Hname=name[rand1]+"�ɶ�";         //�����������
		Hmoney=a*0.1;                     //�ֺ�Ϊ��˾�����10%
		
		File file =new File("D:\\Holder.txt");     //��������Ϣ����D�̵�Holder.txt�ļ�
		if (!file.exists()) {
            file.createNewFile();
		} 
		Writer out =new FileWriter(file,true);     //���ļ�д�����ݲ�����
		String data="�ɶ�����:"+Hname+" �ֺ�:"+Hmoney+" ����������:"+By+"."+Bm+"."+Bd+"\r\n";
		out.write(data);      //д�����Ϣ���Զ�����
		out.close();
	}
}



class Company {
	double Cincome;  //��˾����
	ArrayList<Staff> Stafflist=new ArrayList<Staff>();        //��Ÿù�˾��Ա��
	ArrayList<Manager> Managerlist=new ArrayList<Manager>();  //��Ÿù�˾�ľ���
	ArrayList<Holder> Holderlist=new ArrayList<Holder>();     //��Ÿù�˾�Ĺɶ�
	
	public Company()throws IOException{
		Cincome=(int)(Math.random()*10)*1000000+1000000;      //�����������1����1ǧ��
		for(int i=0;i<(int)(Math.random()*10+10);i++){        //������˾����ʱ��������������Ĺ�˾Ա����������Stafflist
			Stafflist.add(new Staff());}
		for(int i=0;i<(int)(Math.random()*2+5);i++){          //������˾����ʱ��������������Ĺ�˾����������Managerlist
			Managerlist.add(new Manager());}
		for(int i=0;i<(int)(Math.random()*4+1);i++){          //������˾����ʱ��������������Ĺ�˾�ɶ���������Holderlist
			Holderlist.add(new Holder(this.Cincome));}
	}
	
	public void GetInfmt(){     //���ȫ����Ա����Ϣ
		for(int i=0;i<Stafflist.size();i++){         //���Stafflist�е�����ְԱ
			Stafflist.get(i);
			System.out.println("Ա����"+Stafflist.get(i).Sname+" ���ʣ�"+Stafflist.get(i).Smoney);}
		for(int i=0;i<Managerlist.size();i++){       //���Managerlist�е����о���
			Managerlist.get(i);
			System.out.println("����"+Managerlist.get(i).Mname+" ���ʣ�"+Managerlist.get(i).Mmoney+" ����"+Managerlist.get(i).Mbonus);}
		for(int i=0;i<Holderlist.size();i++){        //���Managerlist�е����йɶ�
			Holderlist.get(i);
			System.out.println("�ɶ���"+Holderlist.get(i).Hname+" �ֺ죺"+Holderlist.get(i).Hmoney);}
	}
	
	public void ShowProfit(){   //�����˾�����󼰸���֧��
		double Profit=0;        //��˾����
		double SOutput=0;       //��˾ְԱ�Ĺ����ܺ�
		double MOutput=0;       //��˾����Ĺ����뽱����ܺ�
		double HOutput=0;       //��˾�ɶ��ֺ��ܺ�
		
		System.out.println("��˾���룺"+Cincome);             //�����˾����
		for(int i=0;i<Stafflist.size();i++){
			SOutput=SOutput+Stafflist.get(i).Smoney;}  
			System.out.println("Ա�����ʵ��ܺͣ�"+SOutput);//��ְ���Ĺ����ܺͲ����
			
		for(int i=0;i<Managerlist.size();i++){
			MOutput=MOutput+Managerlist.get(i).Mmoney+Managerlist.get(i).Mbonus;}
			System.out.println("����Ĺ��ʺͽ�����ܺͣ�"+MOutput);//�����ʺͽ�����ܺͲ����
			
		HOutput=Cincome*0.1*Holderlist.size();        
		System.out.println("�ɶ��ֺ���ܺͣ�"+HOutput);    //��ɶ��ֺ��ܺͲ����
			
		Profit=Cincome-HOutput-SOutput-MOutput;       //��˾����
		System.out.println("��˾������"+Profit);                     //�����˾����
	}
	
	public void Check(String name,int Bm){   	//�Ա������ͳ����·ݲ�ѯ������������ʺ������µĹ���
		boolean  result=false;                  //�����жϹ�˾�Ƿ���������
		
		for(int i=0;i<Stafflist.size();i++){    //����Ա����Stafflist�в���
			if(Stafflist.get(i).Sname==name){
				if(Stafflist.get(i).Bm==Bm){
				System.out.println("������"+Stafflist.get(i).Sname+" ���ʣ�"+Stafflist.get(i).Smoney+" �����µĹ��ʣ�"+2*Stafflist.get(i).Smoney);
				result=true;
				}
			}
		}
		
		for(int i=0;i<Managerlist.size();i++){  //Ȼ���ھ����Managerlist�в���
			if(Managerlist.get(i).Mname==name){
				if(Managerlist.get(i).Bm==Bm){
				System.out.println("����:"+Managerlist.get(i).Mname+" ���ʣ�"+Managerlist.get(i).Mmoney+" �����¹��ʣ�"+3*Managerlist.get(i).Mmoney+" ����"+Managerlist.get(i).Mbonus);
				result=true;
				}
			}
		}
		
		for(int i=0;i<Holderlist.size();i++){   //����ڹɶ���Holderlist�в���
			if(Holderlist.get(i).Hname==name){
				if(Holderlist.get(i).Bm==Bm){
				System.out.println("������"+Holderlist.get(i).Hname+"�ֺ죺"+Holderlist.get(i).Hmoney);
				result=true;	
				}
			}
		}
	if(result==false)           //û���ҵ������
		System.out.println("���޴���");
	}
	
	
}

public class Testcompany{
     public static void main(String[] arge)throws IOException{
		Company A1=new Company();   //����һ����˾�����г�Ա�ѱ����������������TET�ı���
		A1.GetInfmt();              //���Ի�ȡ��Ϣ����
		A1.ShowProfit();            //�����������֧������
		A1.Check("����һ",9);       //���Բ��ҹ��ʺ��������ڹ�˾��Ա��������ɣ��Ҳ�֪������Щ����������һ����Ա���Լ���Ȼ�ǿ��Բ�õ���
	 }	
	}