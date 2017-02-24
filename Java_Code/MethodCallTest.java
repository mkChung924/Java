import com.kosta.gildong.Greetings;

class MethodCallTest extends Greetings
{
	void callTest(){
		hello("길동"); //public 메소드 호출 가능
		hi("라임"); //protected 메소드 호울 가능(자식 클래스였을 때 다른 패키지에서도 호출 가능)
		//goodByd("주원");//디폴트 메소드 호출 불가능
		//yahoo(); //private 메소드 호출 불가
	}

	public static void main(String[] args) 
	{

//		Greetings g = new Greetings();
//		g.hello("주원");
//		g.hi("라임");

		MethodCallTest mct = new MethodCallTest();
		mct.callTest();
		
	}
}
