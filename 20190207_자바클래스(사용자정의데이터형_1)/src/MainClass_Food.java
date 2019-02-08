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
                              <span class="title">���� ���� ����Ʈ 25��</span>

                              <p class="desc">"���� ������ ������ �޶�!"</p>
 */
public class MainClass_Food {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		CategoryData[] cate=foodCategory();
		System.out.println("===============�޴� ���=============");
		for(CategoryData c:cate)
		{
			System.out.println("��ȣ:"+c.num);
			System.out.println("��ü��:"+c.title);
			System.out.println("�ο�����:"+c.subject);
			//System.out.println("��ũ:"+c.link);
			System.out.println("===================================");
		}
		
		Scanner scan=new Scanner(System.in);
		System.out.print("�޴�����(1-9):");
		int index=scan.nextInt();
		String s=cate[index-1].title;
		s=s.replaceAll("[^0-9]", "");   //���� ���� �� �������� 
		int a=0;
		if(Integer.parseInt(s)>10)
			a=10;
		else
			a=Integer.parseInt(s);
		
		
		
		System.out.println("����� ������="+a);
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
			 * System.out.println("��ȣ:"+(i+1));
			 * System.out.println("����:"+title.get(i).text());
			 * System.out.println("�ο�:"+subject.get(i).text());
			 * System.out.println("��ũ:"+link.get(i).attr("href"));
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
		 * System.out.println("����="+index); System.out.println("link="+link);
		 */
		Document doc=Jsoup.connect(link).get();
		Elements title=doc.select("div.info span.title a");
		Elements address=doc.select("div.info p.etc");
		Elements score=doc.select("div.info strong.point");
		System.out.println("====�˻����:"+index+"�� �˻�====");
		
		for(int i=0; i<index; i++)    //for(int i=0; i<fd.length; i++)
		{
			System.out.println(title.get(i).text());
			System.out.println("����:"+score.get(i).text());
			System.out.println("�ּ�:"+address.get(i).text());
		}
		return fd;
	}

}
