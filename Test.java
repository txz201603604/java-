import java.util.*;
import java.io.*;




 class Song     //歌曲信息
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
   System.out.println("歌名"+songName);
   System.out.println("歌手"+Singer);
   System.out.println("时长"+Time);
}
}





class Master extends Songdrive   //主持人可以切换歌曲
{
   static ArrayList<Song> songlist; 
   public Master()
{
   ArrayList<Song> songlist=new ArrayList<Song>();
{
        songbase.add(new Song("一个人失忆","薛凯琪",4));
	songbase.add(new Song("吻得太逼真","张敬轩",4));
	songbase.add(new Song("男人女人","许茹芸",4));
	
}

        public boolean Play() 
{
	System.out.println("开始播放!");
	System.out.println(Master.songlist.get(0));
	return true;
}
	
	public void NextSong()     //切歌方法
{
        if(this.IsEmply()) 
{
        System.out.println("切歌成功!");	
	Master.songlist.remove(0);
	this.Play();
 }
        else 
{
        System.out.println("歌单歌已空!");
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
{      static int playernum=0;                 //统计歌手数量
       public Player()
{
       System.out.println("歌手"+playernum+"号就位");
       playernum++;
}
}






class Songdrive           //Player与Master的父类   实现1.添加歌曲   2.显示已点歌曲
{
    	public boolean addSong(String SongName)      //添加歌曲方法（只能点Songbase中存在的歌曲）
{       
        for(int i=0;i<Songbase.songbase.size();i++)         //输入的SongName 与歌库中的进行逐项对比，相同了 跳出循环
{
        if(Songbase.songbase.get(i).songName.equals(SongName)) 
{
        System.out.println("歌曲添加成功!");
	Master.songlist.add(Songbase.songbase.get(i));
	return true;
 }
else 
{
        System.out.println("歌曲不存在");
	return false;
}
}
        return false;
}

       public  void put()    //显示已点歌曲方法
{
       System.out.println("已点歌曲：");
       for(int i=0;i<Master.songlist.size();i++)
{
       System.out.println(Master.songlist.get(i));
}
       
}
}  



class Songbase  //存放可以点的歌曲
{
      static ArrayList<Song> songbase;
      public Songbase()
{       ArrayList<Song> songbase=new ArrayList<Song>();
        songbase.add(new Song("一个人失忆","薛凯琪",4));
	songbase.add(new Song("吻得太逼真","张敬轩",4));
	songbase.add(new Song("男人女人","许茹芸",4));
	songbase.add(new Song("恋人心","魏新雨",4));
	songbase.add(new Song("丑八怪","薛之谦",4));
	songbase.add(new Song("体面","于文文",4));
	songbase.add(new Song("凉凉","张碧晨/杨宗纬",4));
	songbase.add(new Song("至少还有你","林忆莲",4));
	songbase.add(new Song("死了都要爱","信乐团",4));
	songbase.add(new Song("淘汰","陈奕迅",4));
	songbase.add(new Song("终于等到你","张靓颖",4));
	songbase.add(new Song("林中鸟","葛林",4));
	songbase.add(new Song("月半小夜曲","李克勤",4));
	songbase.add(new Song("烟花易冷","周杰伦",4));
}
     public void show()
{
     System.out.println("能点歌曲如下");
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
       BASE.show();         //初始化
       master.put();         //主持人看歌单
      master.addSong("恋人心");//主持人点歌
      X.addSong("丑八怪");//歌手一号点歌
      Y.addSong("体面");//歌手二号点歌
      X.addSong("lemon");//歌手1号点歌（此歌不存在）
      master.NextSong();//主持人切换歌曲
      X.put();//歌手一号看歌单
           
}
}



/*结果如下
歌手一号就位
歌手二号就位


能点歌曲如下：
一个人失忆
吻得太逼真
男人女人
恋人心
丑八怪
体面
凉凉
至少还有你
死了都要爱
淘汰
终于等到你
林中鸟
月半小夜曲
烟花易冷

一个人失忆
吻得太逼真
男人女人

歌曲添加成功
歌曲添加成功
歌曲添加成功
歌曲不存在

切歌成功

一个人失忆
吻得太逼真
男人女人
恋人心
丑八怪
体面
*/
