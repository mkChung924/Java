package com.kosta.j0306;

public class MatchesTest {
	public static void main(String args[]){
		
		//String str ="";
		String str = "b";
		
		//boolean str.matches(String regex)
		//regex ---> regular expression (Á¤±Ô Ç¥Çö½Ä)
		//regex¸¦ ÅëÇØ Àü´ŞµÇ´Â ÆĞÅÏ¿¡ strÀÌ ºÎÇÕ(match)µÇ¸é true¸¦ ¸®ÅÏ
		
		System.out.println(str.matches("[a]"));// a¹®ÀÚ ÇÑ¹ø
		System.out.println(str.matches("[a]?"));// a¹®ÀÚ 0,1
		System.out.println(str.matches("[a]*"));// a¹®ÀÚ 0~¹«ÇÑ´ë
		System.out.println(str.matches("[a]+"));// a¹®ÀÚ 1~¹«ÇÑ´ë
		//?,*,+ : È½¼ö¸¦ Ç¥ÇöÇÏ´Â ºÎÈ£
		
		System.out.println(str.matches("[abc]+"));// a ¶Ç´Â b ¶Ç´Â c ¹®ÀÚ Áß 1¹ø ÃâÇö
		
		String name = "gildong";
		
		//name º¯¼ö¿¡ ´ëÇØ ¿µ¹®ÀÚ Ã¼Å©!!
		System.out.println(name.matches("[a-zA-Z]+"));
		
		String number = "12345";
		System.out.println(number.matches("[0-9]+"));
		
		String korean = "³ªÇÑ±Û";
		
		System.out.println(korean.matches("[¤¡-ÆR]+"));
		
		String id = "mkchung924";
		//id º¯¼ö´Â 8~12ÀÚ¸®, ¿µ¹®ÀÚ¿Í ¼ıÀÚ Á¶ÇÕ
		
		System.out.println(id.matches("[a-zA-Z0-9]{8,12}"));
	}

}
