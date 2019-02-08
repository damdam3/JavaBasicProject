import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/*
 * �޼ҵ� ==>�����͸� ����
 * 		  ==========
 * 			1.�Ѱ�
 * 			2.������(��� ����)
 * 			=�迭
 *			=Ŭ����  
 */
public class MainClass3 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		MovieRank[] mr=movieRankData();
		System.out.println("===========��ȭ��ũ����============");
		
		for(MovieRank m:mr)
		{
		System.out.println("����:"+m.rank);
		System.out.println("����:"+m.title);
		System.out.println("����:"+m.icon+"("+m.idcrement+")");
		System.out.println("===============================");
		}
		
		System.out.println("===========��ȭ�󼼺���============");
		Scanner scan=new Scanner(System.in);
		System.out.print("�����Է�:");
		String s=scan.next();
		
		MovieRank mm=movieDetail(s);
		System.out.println("����:"+mm.rank);
		System.out.println("����:"+mm.title);
		System.out.println("����:"+mm.icon+"("+mm.idcrement+")");
		

	}
	//��ü�� �迭�� �Ѿ
	static  MovieRank[] movieRankData() throws Exception
	{
		MovieRank[] mr=new MovieRank[10];
		Document doc=Jsoup.connect("https://movie.naver.com/movie/sdb/rank/rmovie.nhn").get();
		Elements title=doc.select("td.title div.tit3 a");
		Elements icon=doc.select("td.ac img");
		Elements idcrement=doc.select("td.range");
		int j=1;
		for(int i=0; i<10; i++)
		{
			//System.out.println("��ȭ��:"+title.get(i).text());
			
			String s=icon.get(j).attr("src");
			String ss="";
			s=s.substring(s.lastIndexOf("/"));
			if(s.contains("na"))
				ss="-";
			else if(s.contains("up"))
				ss="��";
			else if(s.contains("down"))
				ss="��";
			/*
			 * System.out.println("����:"+(i+1)); System.out.println("������:"+ss);
			 * System.out.println("����:"+idcrement.get(i).text());
			 * System.out.println("==============================");
			 */
			j+=2;
			MovieRank m=new MovieRank();
			//System.out.println("m"+(i+1)+":"+m);
			//new�� ����� ������ �޸� ������ �ٸ���
			m.rank=i+1;
			m.icon=ss.charAt(0);
			m.idcrement=Integer.parseInt(idcrement.get(i).text());
			//���ڿ�=>���� Integer.parseInt()
			//����=>���ڿ� valueOf()
			m.title=title.get(i).text();
			mr[i]=m;
		}
		return mr;
	}
	/*
	 * int a=10;
	 * int b=20;
	 * 
	 * b=a;
	 * 
	 * A aa=new A();
	 * A bb=new A();
	 * bb=aa;
	 */
	//�󼼺��� 
	static MovieRank movieDetail(String title) throws Exception
	{
		MovieRank mr=new MovieRank();
		MovieRank[] movies=movieRankData();  //10��
		for(MovieRank m:movies)
		{
			if(m.title.contains(title))
			{
				mr=m;
				break;
			}
		}
		return mr;
	}

}
