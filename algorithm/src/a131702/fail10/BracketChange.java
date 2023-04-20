package a131702.fail10;

public class BracketChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String squareBracket = "[0, 1, 3, 0],\r\n"
				+ "[1, 2, 0, 0],\r\n"
				+ "[3, 0, 2, 2],\r\n"
				+ "[0, 2, 0, 0]";
		squareBracket = squareBracket.replaceAll("\\[", "{");
		squareBracket = squareBracket.replaceAll("\\]", "}");
		System.out.println(squareBracket);
		
	}

}
