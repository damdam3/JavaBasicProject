import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.util.Scanner;
/*
 *   <a href="/top_lists/936_soondae"
                         onclick="common_ga('PG_MAIN','CLICK_LIST');">
                        <figure class="ls-item">
                          <figcaption class="info">
                            <div class="info_inner_wrap">
                              <span class="title">순대 맛집 베스트 25곳</span>

                              <p class="desc">"순대 맛집은 차원이 달라!"</p>
 */
public class MainClass_Food {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		CategoryData[] cate=foodCategory();
		System.out.println("===============메뉴 출력=============");
		for(CategoryData c:cate)
		{
			System.out.println("번호:"+c.num);
			System.out.println("업체명:"+c.title);
			System.out.println("부연설명:"+c.subject);
			//System.out.println("링크:"+c.link);
			System.out.println("===================================");
		}
		
		Scanner scan=new Scanner(System.in);
		System.out.print("메뉴선택(1-9):");
		int index=scan.nextInt();
		String s=cate[index-1].title;
		s=s.replaceAll("[^0-9]", "");   //숫자 빼고 다 지워버림 
		int a=0;
		if(Integer.parseInt(s)>10)
			a=10;
		else
			a=Integer.parseInt(s);
		
		
		
		System.out.println("출력할 데이터="+a);
		foodDetail(a,cate[index-1].link);
		

	}
	static CategoryData[] foodCategory() throws Exception
	{
		CategoryData[] cate=new CategoryData[9];
		Document doc =Jsoup.connect("https://www.mangoplate.com/").get();
		Elements title=doc.select("div.info_inner_wrap span.title");
		Elements subject=doc.select("div.info_inner_wrap p.desc");
		Elements link=doc.select("div.top_list_slide a");
		for(int i=0; i<9; i++)
		{
			/*
			 * System.out.println("번호:"+(i+1));
			 * System.out.println("제목:"+title.get(i).text());
			 * System.out.println("부연:"+subject.get(i).text());
			 * System.out.println("링크:"+link.get(i).attr("href"));
			 * System.out.println("===================================");
			 */
			
			CategoryData c=new CategoryData();
			c.num=i+1;
			c.title=title.get(i).text();
			c.subject=subject.get(i).text();
			c.link="https://www.mangoplate.com"+link.get(i).attr("href");
			
			cate[i]=c;
		}
		return cate;
		
	}
	static FoodData[] foodDetail(int index,String link) throws Exception
	{
		FoodData[] fd=new FoodData[index];
		/*
		 * System.out.println("갯수="+index); System.out.println("link="+link);
		 */
		Document doc=Jsoup.connect(link).get();
		Elements title=doc.select("div.info span.title a");
		Elements address=doc.select("div.info p.etc");
		Elements score=doc.select("div.info strong.point");
		System.out.println("====검색결과:"+index+"개 검색====");
		
		for(int i=0; i<index; i++)    //for(int i=0; i<fd.length; i++)
		{
			System.out.println(title.get(i).text());
			System.out.println("평점:"+score.get(i).text());
			System.out.println("주소:"+address.get(i).text());
		}
		return fd;
	}

}
