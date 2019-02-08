import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MainClass4 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		MovieReserve[] mr=movieReserveData();
		System.out.println("===========영화랭크순위============");
		
		for(MovieReserve m:mr)
		{
		System.out.println("순위:"+m.rank);
		System.out.println("제목:"+m.title);
		System.out.println("평점:"+m.score);
		System.out.println("등폭:"+m.icon+"("+m.idcrement+")");
		System.out.println("===============================");
		}
		
		System.out.println("===========영화상세보기============");
		Scanner scan=new Scanner(System.in);
		System.out.print("제목입력:");
		String s=scan.next();
		
		MovieReserve mm=movieDetail(s);
		System.out.println("순위:"+mm.rank);
		System.out.println("제목:"+mm.title);
		System.out.println("등폭:"+mm.icon+"("+mm.idcrement+")");
		
		
		
		
		
		

	}
	//전체는 배열로 넘어감
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
			//System.out.println("영화명:"+title.get(i).text());
			
			String s=icon.get(j).attr("src");
			String ss="";
			s=s.substring(s.lastIndexOf("/"));
			if(s.contains("na"))
				ss="-";
			else if(s.contains("up"))
				ss="↑";
			else if(s.contains("down"))
				ss="↓";
			/*
			 * System.out.println("순위:"+(i+1)); System.out.println("아이콘:"+ss);
			 * System.out.println("등폭:"+idcrement.get(i).text());
			 * System.out.println("==============================");
			 */
			j+=2;
			MovieReserve m=new MovieReserve();
			//System.out.println("m"+(i+1)+":"+m);
			//new는 사용할 때마다 메모리 공간이 다르다
			m.rank=i+1;
			m.score=Double.parseDouble(score.get(i).text());
			m.icon=ss.charAt(0);
			m.idcrement=Integer.parseInt(idcrement.get(i).text());
			//문자열=>정수 Integer.parseInt()
			//정수=>문자열 valueOf()
			m.title=title.get(i).text();
			mr[i]=m;
		}
		return mr;
	}
	static MovieReserve movieDetail(String title) throws Exception
	{
		MovieReserve mr=new MovieReserve();
		MovieReserve[] movies=movieReserveData();  //10개
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


