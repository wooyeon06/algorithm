package copy;


public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		
		String squareBracket = "[[1,2,3], [5,6,7]]";
		squareBracket = squareBracket.replaceAll("\\[", "{");
		squareBracket = squareBracket.replaceAll("\\]", "}");
		System.out.println(squareBracket);
		
		Object obj = solution.solution(
				""
				);
		
		String typeName = obj.getClass().getTypeName();
		
		//System.out.println(typeName);
		if("java.lang.Integer".equals(typeName)) {
			System.out.println("answer : " + (int) obj);
		} else if("".equals(typeName)) {
			
		}
		
		
	}

}
