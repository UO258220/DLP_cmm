package parser;

public class LexerHelper {
	
	public static int lexemeToInt(String str) {
		try {
			return Integer.parseInt(str);
		}
		catch(NumberFormatException e) {
			System.out.println(e);
		}
		return -1;
	}

	public static char lexemeToChar(String str) {
		if (str.length() == 3) {
			return str.charAt(1);
		} else if (str.length() == 4) {
			if (str.charAt(2) == 'n') {
				return '\n';
			} else if (str.charAt(2) == 't') {
				return '\t';
			}
		} else if (str.length() > 0) {
			String traversedString = "";
			for (int i = 2; i < str.length() - 1; i++) {
				if (Character.isDigit(str.charAt(i))) {
					traversedString += str.charAt(i);
				} else return 0;
			}
			return (char) Integer.parseInt(traversedString);
		}
		return 0;
	}

	public static double lexemeToReal(String str) {
		try {
			return Double.parseDouble(str);
		}
		catch(NumberFormatException e) {
			System.out.println(e);
		}
		return -1;
	}
	
}
