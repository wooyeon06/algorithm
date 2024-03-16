package a258705;

public class TestMain {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        //Object obj = solution.solution(4, new int[]{1, 1, 0, 1});
        //Object obj = solution.solution(2, new int[]{0, 1});
        Object obj = solution.solution(10, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});   //17711   17710
        /*Object obj = solution.solution(15, new int[]{
                0, 0, 0, 0, 0,
                0, 0, 0, 0, 0,
                0, 0, 0, 0, 0,
        })*/;   //17711   17710

        System.out.println("\n\n-----------------------------------------------------------------------------------------------------");

        System.out.println(obj);
    }

}
