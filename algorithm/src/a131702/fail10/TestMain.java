package a131702.fail10;


public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		
		Object obj = solution.solution(
				//new int[][]{{0,3,3,0},{3,2,2,3},{0,3,2,0},{0,3,3,3}}
				//new int[][]{{0, 1, 3, 0},{1, 2, 0, 0},{3, 0, 2, 2},{0, 2, 0, 0}}

				//new int[][]{{0,0,3,0},{0,3,3,3}}
				//new int[][]{{0,3,3,0},{3,2,2,3}}
				//new int[][]{{3,2,3},{2,2,2},{3,2,3}}
				new int[][]{{0,2},{2,3},{2,2},{2,3},{2,2},{2,3},{2,2},{2,3}}
				//new int[][]{{3,3,3},{3,3,3},{3,3,3}}
				
				
				);
		
		String typeName = obj.getClass().getTypeName();
		
		if("java.lang.Integer".equals(typeName)) {
			System.out.println("answer : " + (int) obj);
		} else if("".equals(typeName)) {
			
		}
		
	}

}
