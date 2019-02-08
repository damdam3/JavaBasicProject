/*
 * Music genie=new Music[200];==>메모리 저장위치가 다르다(주소)==>참조변수
 * int[] a=new int[200]; =====> 실제 데이터가 저장
 * 일반변수: 값
 * 클래스(사용자 정의)=>new를 사용해서 초기값을 만든다 
 * new=>없는 경우에는 null이기 때문에 사용 할 수 없다
 * 
 * 클래스의 생명주기 
 * ===========
 * 		생성 			활용	  	소멸
 * A a=new A()   a.title   a=null
 */
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Music m1=new Music();
		Music m2=new Music();
		m1.rank=1;
		m1.icon='-';
		m1.idcrement=0;
		m1.title="이 노래가 클럽에서 나온다면";
		m1.poster="http://image.genie.co.kr/Y/IMAGE/IMG_ALBUM/081/151/363/81151363_1548226356294_1_600x600.JPG";
		m1.singer="우디(Woody)";
		m1.album="이 노래가 클럽에서 나온다면";
		
		m2.rank=4;
		m2.icon='-';
		m2.idcrement=0;
		m2.title="벌써 12시";
		//m2.poster="javascript:photoView('http://cmsimg.mnet.com/clipimage/album/1024/003/223/3223767.jpg','1024','1024');";
		m2.singer="청하";
		m2.album="";
		
		
		System.out.println("순위:"+m1.rank);
		System.out.println("제목:"+m1.title);
		System.out.println("가수:"+m1.singer);
		System.out.println("앨범:"+m1.album);
		System.out.println();
		System.out.println("순위:"+m2.rank);
		System.out.println("제목:"+m2.title);
		System.out.println("가수:"+m2.singer);
		System.out.println("앨범:"+m2.album);
		System.out.println("포스터:"+m2.poster);
	}

}
