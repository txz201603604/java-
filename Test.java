import java.util.*;
import java.io.*;




 class Song     //������Ϣ
{
   String songName;
   String Singer;
   double Time;
   public Song(String songname,String singer,double time)
{
   songName=songname;
   Singer=singer;
   Time=time;
}
   public void get()
{
   System.out.println("����"+songName);
   System.out.println("����"+Singer);
   System.out.println("ʱ��"+Time);
}
}





class Master extends Songdrive   //�����˿����л�����
{
   static ArrayList<Song> songlist; 
   public Master()
{
   ArrayList<Song> songlist=new ArrayList<Song>();
{
        songbase.add(new Song("һ����ʧ��","Ѧ����",4));
	songbase.add(new Song("�ǵ�̫����","�ž���",4));
	songbase.add(new Song("����Ů��","����ܿ",4));
	
}

        public boolean Play() 
{
	System.out.println("��ʼ����!");
	System.out.println(Master.songlist.get(0));
	return true;
}
	
	public void NextSong()     //�и跽��
{
        if(this.IsEmply()) 
{
        System.out.println("�и�ɹ�!");	
	Master.songlist.remove(0);
	this.Play();
 }
        else 
{
        System.out.println("�赥���ѿ�!");
}
}
	
	public boolean IsEmply() 
{
	if(Master.songlist.get(0)==null) 
{
	return false;
}
	else 
{
	return true;
}
}

}


class Player extends Songdrive
{      static int playernum=0;                 //ͳ�Ƹ�������
       public Player()
{
       System.out.println("����"+playernum+"�ž�λ");
       playernum++;
}
}






class Songdrive           //Player��Master�ĸ���   ʵ��1.��Ӹ���   2.��ʾ�ѵ����
{
    	public boolean addSong(String SongName)      //��Ӹ���������ֻ�ܵ�Songbase�д��ڵĸ�����
{       
        for(int i=0;i<Songbase.songbase.size();i++)         //�����SongName �����еĽ�������Աȣ���ͬ�� ����ѭ��
{
        if(Songbase.songbase.get(i).songName.equals(SongName)) 
{
        System.out.println("������ӳɹ�!");
	Master.songlist.add(Songbase.songbase.get(i));
	return true;
 }
else 
{
        System.out.println("����������");
	return false;
}
}
        return false;
}

       public  void put()    //��ʾ�ѵ��������
{
       System.out.println("�ѵ������");
       for(int i=0;i<Master.songlist.size();i++)
{
       System.out.println(Master.songlist.get(i));
}
       
}
}  



class Songbase  //��ſ��Ե�ĸ���
{
      static ArrayList<Song> songbase;
      public Songbase()
{       ArrayList<Song> songbase=new ArrayList<Song>();
        songbase.add(new Song("һ����ʧ��","Ѧ����",4));
	songbase.add(new Song("�ǵ�̫����","�ž���",4));
	songbase.add(new Song("����Ů��","����ܿ",4));
	songbase.add(new Song("������","κ����",4));
	songbase.add(new Song("��˹�","Ѧ֮ǫ",4));
	songbase.add(new Song("����","������",4));
	songbase.add(new Song("����","�ű̳�/����γ",4));
	songbase.add(new Song("���ٻ�����","������",4));
	songbase.add(new Song("���˶�Ҫ��","������",4));
	songbase.add(new Song("��̭","����Ѹ",4));
	songbase.add(new Song("���ڵȵ���","����ӱ",4));
	songbase.add(new Song("������","����",4));
	songbase.add(new Song("�°�Сҹ��","�����",4));
	songbase.add(new Song("�̻�����","�ܽ���",4));
}
     public void show()
{
     System.out.println("�ܵ��������");
     for(int i=0;i<songbase.size();i++)
     System.out.println(songbase.get(i).songName);
}
}

public class Test
{
       public static void main(String args[])
{
       Songbase BASE=new Songbase();
       Master master=new Master();
       Player X=new Player();
       Player Y=new Player();
       BASE.show();         //��ʼ��
       master.put();         //�����˿��赥
      master.addSong("������");//�����˵��
      X.addSong("��˹�");//����һ�ŵ��
      Y.addSong("����");//���ֶ��ŵ��
      X.addSong("lemon");//����1�ŵ�裨�˸費���ڣ�
      master.NextSong();//�������л�����
      X.put();//����һ�ſ��赥
           
}
}



/*�������
����һ�ž�λ
���ֶ��ž�λ


�ܵ�������£�
һ����ʧ��
�ǵ�̫����
����Ů��
������
��˹�
����
����
���ٻ�����
���˶�Ҫ��
��̭
���ڵȵ���
������
�°�Сҹ��
�̻�����

һ����ʧ��
�ǵ�̫����
����Ů��

������ӳɹ�
������ӳɹ�
������ӳɹ�
����������

�и�ɹ�

һ����ʧ��
�ǵ�̫����
����Ů��
������
��˹�
����
*/
