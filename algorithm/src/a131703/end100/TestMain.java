package a131703.end100;


public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		
		String squareBracket = "[[0, 0, 0, 1, 1], [0, 0, 0, 0, 1], [0, 0, 1, 0, 1], [0, 0, 0, 1, 0], [0, 0, 0, 0, 1]]";
		squareBracket = squareBracket.replaceAll("\\[", "{");
		squareBracket = squareBracket.replaceAll("\\]", "}");
		//System.out.println(squareBracket);
		
		Object obj = solution.solution(
				
				//new int[][]{{0, 1, 0, 0, 0}, {1, 0, 1, 0, 1}, {0, 1, 1, 1, 0}, {1, 0, 1, 1, 0}, {0, 1, 0, 1, 0}}
				new int[][]{{ 1, 0, 0, 0}, { 0, 1, 0, 1}, { 1, 1, 1, 0}, { 0, 1, 1, 0}, { 1, 0, 1, 0}}
				,
				//new int[][]{{0, 0, 0, 1, 1}, {0, 0, 0, 0, 1}, {0, 0, 1, 0, 1}, {0, 0, 0, 1, 0}, {0, 0, 0, 0, 1}}
				new int[][]{{ 0, 0, 1, 1}, { 0, 0, 0, 1}, { 0, 1, 0, 1}, { 0, 0, 1, 0}, { 0, 0, 0, 1}}

				);
		
		String typeName = obj.getClass().getTypeName();
		//System.out.println(typeName);
		if("java.lang.Integer".equals(typeName)) {
			System.out.println("answer : " + (int) obj);
		} else if("".equals(typeName)) {
			
		}
		
	}

}
