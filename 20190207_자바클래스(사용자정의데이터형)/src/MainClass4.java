import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MainClass4 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		MovieReserve[] mr=movieReserveData();
		System.out.println("===========��ȭ��ũ����============");
		
		for(MovieReserve m:mr)
		{
		System.out.println("����:"+m.rank);
		System.out.println("����:"+m.title);
		System.out.println("����:"+m.score);
		System.out.println("����:"+m.icon+"("+m.idcrement+")");
		System.out.println("===============================");
		}
		
		System.out.println("===========��ȭ�󼼺���============");
		Scanner scan=new Scanner(System.in);
		System.out.print("�����Է�:");
		String s=scan.next();
		
		MovieReserve mm=movieDetail(s);
		System.out.println("����:"+mm.rank);
		System.out.println("����:"+mm.title);
		System.out.println("����:"+mm.icon+"("+mm.idcrement+")");
		
		
		
		
		
		

	}
	//��ü�� �迭�� �Ѿ
	static  MovieReserve[] movieReserveData() throws Exception
	{
		MovieReserve[] mr=new MovieReserve[10];
		Document doc=Jsoup.connect("https://movie.naver.com/movie/sdb/rank/rmovie.nhn?sel=cur&date=20190206").get();
		Elements title=doc.select("td.title div.tit5 a");
		Elements icon=doc.select("td.ac img");
		Elements idcrement=doc.select("td.range");
		Elements score=doc.select("td.point");
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
			MovieReserve m=new MovieReserve();
			//System.out.println("m"+(i+1)+":"+m);
			//new�� ����� ������ �޸� ������ �ٸ���
			m.rank=i+1;
			m.score=Double.parseDouble(score.get(i).text());
			m.icon=ss.charAt(0);
			m.idcrement=Integer.parseInt(idcrement.get(i).text());
			//���ڿ�=>���� Integer.parseInt()
			//����=>���ڿ� valueOf()
			m.title=title.get(i).text();
			mr[i]=m;
		}
		return mr;
	}
	static MovieReserve movieDetail(String title) throws Exception
	{
		MovieReserve mr=new MovieReserve();
		MovieReserve[] movies=movieReserveData();  //10��
		for(MovieReserve m:movies)
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


