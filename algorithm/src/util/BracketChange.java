package util;

public class BracketChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String squareBracket = "[[0,3,3,0],[3,2,2,3],[0,3,2,0],[0,3,3,3]]";
		squareBracket = squareBracket.replaceAll("\\[", "{");
		squareBracket = squareBracket.replaceAll("\\]", "}");
		System.out.println(squareBracket);
		
	}

}
