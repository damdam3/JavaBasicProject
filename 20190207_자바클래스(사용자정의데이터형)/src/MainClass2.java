/*
 * Music genie=new Music[200];==>�޸� ������ġ�� �ٸ���(�ּ�)==>��������
 * int[] a=new int[200]; =====> ���� �����Ͱ� ����
 * �Ϲݺ���: ��
 * Ŭ����(����� ����)=>new�� ����ؼ� �ʱⰪ�� ����� 
 * new=>���� ��쿡�� null�̱� ������ ��� �� �� ����
 * 
 * Ŭ������ �����ֱ� 
 * ===========
 * 		���� 			Ȱ��	  	�Ҹ�
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
		m1.title="�� �뷡�� Ŭ������ ���´ٸ�";
		m1.poster="http://image.genie.co.kr/Y/IMAGE/IMG_ALBUM/081/151/363/81151363_1548226356294_1_600x600.JPG";
		m1.singer="���(Woody)";
		m1.album="�� �뷡�� Ŭ������ ���´ٸ�";
		
		m2.rank=4;
		m2.icon='-';
		m2.idcrement=0;
		m2.title="���� 12��";
		//m2.poster="javascript:photoView('http://cmsimg.mnet.com/clipimage/album/1024/003/223/3223767.jpg','1024','1024');";
		m2.singer="û��";
		m2.album="";
		
		
		System.out.println("����:"+m1.rank);
		System.out.println("����:"+m1.title);
		System.out.println("����:"+m1.singer);
		System.out.println("�ٹ�:"+m1.album);
		System.out.println();
		System.out.println("����:"+m2.rank);
		System.out.println("����:"+m2.title);
		System.out.println("����:"+m2.singer);
		System.out.println("�ٹ�:"+m2.album);
		System.out.println("������:"+m2.poster);
	}

}
