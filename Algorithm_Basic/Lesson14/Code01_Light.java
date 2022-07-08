package lesson14;

public class Code01_Light {
	
	public static int minLight(String road) {
		char[] str = road.toCharArray();
		int i = 0;
		int light = 0;
		while(i < str.length) {
			if(str[i] == 'X') {
				i++;
			}else {
				light++;
				if(i + 1 == str.length) {
					break;
				}else {
					if(str[i + 1] == 'X') {
						i +=2;
					}else {
						i +=3;
					}
				}
			}
		}
		return light;
	}
}
