

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//저장공간 만들기=new
		Movie m=new Movie();
		System.out.println("m="+m);
		Movie m1=new Movie(); //new를 이여
		System.out.println("m="+m1);
		Movie m2=new Movie();
		System.out.println("m="+m2);
		
		m.title="극한직업";
		m.director="이병헌";
		m1.title="알리타:배틀엔젤";
		m1.director="로버트 로드리게즈";
		m2.title="드래곤길들이기";
		
		System.out.println(m.title);
		System.out.println(m.director);
		System.out.println(m1.title);
		System.out.println(m1.director);
							
			
			
																			
	}

}
