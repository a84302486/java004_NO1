package _00_Util;

public class SerialNumGenerator {
	
	public static String generator(int strLen){
		
		String outStr = "";	
		int num = 0;

		while(outStr.length() < strLen)  {

			num = (int)(Math.random()*(90-50+1))+50;	//亂數取編號為 50~90 的字符	(排除 0 和 1)

			if (num > 57 && num < 65)

				continue;			//排除非數字非字母

			else if (num == 73 || num == 76 || num == 79)

				continue;			//排除 I、L、O

			outStr += (char)num;

		}

		return outStr.toLowerCase();

	}
}
