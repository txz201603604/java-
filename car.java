public class car{
public char CN;//���ͺ�
public int Tank;//����
public int Oilconsumption;//��������
public void setcar(char name,int tank,int oilconsumption)//������������
{CN=name;Tank=tank;Oilconsumption=oilconsumption;}

public void printcar()//�����������
{System.out.println("����:"+CN+"����:"+Tank+"������:"+Oilconsumption);}

public static void main(String[] args){
car[] carlist=new car[100];//�������car��������ñ���������

int n=1;
for(;n<4;n++)
{carlist[n]=new car();//ѭ���������е����ñ�����ֵ
 char x=(char)(n+64);//��n+64ת��Ϊascll����Ϊ���ͺ�
 carlist[n].setcar(x,n*100,n*10);}//ѭ��������������

int m=1;
for(;m<4;m++){carlist[m].printcar();}//ѭ�����������
}
}

