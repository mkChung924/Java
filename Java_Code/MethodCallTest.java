import com.kosta.gildong.Greetings;

class MethodCallTest extends Greetings
{
	void callTest(){
		hello("�浿"); //public �޼ҵ� ȣ�� ����
		hi("����"); //protected �޼ҵ� ȣ�� ����(�ڽ� Ŭ�������� �� �ٸ� ��Ű�������� ȣ�� ����)
		//goodByd("�ֿ�");//����Ʈ �޼ҵ� ȣ�� �Ұ���
		//yahoo(); //private �޼ҵ� ȣ�� �Ұ�
	}

	public static void main(String[] args) 
	{

//		Greetings g = new Greetings();
//		g.hello("�ֿ�");
//		g.hi("����");

		MethodCallTest mct = new MethodCallTest();
		mct.callTest();
		
	}
}
