package util;

public class P {

    public static void arr(Object[] args) {

        StringBuilder sb = new StringBuilder();

        sb.append("[");

        for(int i=0 ; i<args.length ; i++) {
            Object item = args[i];
            if(i == args.length-1) {
                sb.append(item);
            } else {
                sb.append(item + ", ");
            }
        }
        sb.append("]");

        System.out.println(sb);
    }


    public static void arr2(int[][] array) {
        // 각 열의 최대 너비 계산
        int[] columnWidths = new int[array[0].length];
        for (int[] row : array) {
            for (int j = 0; j < row.length; j++) {
                int width = String.valueOf(row[j]).length();
                columnWidths[j] = Math.max(columnWidths[j], width);
            }
        }

        // 출력
        System.out.print("  |  ");
        for (int i = 0; i < array[0].length; i++) {
            System.out.printf("%-" + (columnWidths[i] + 5) + "s", i);
        }
        System.out.println();
        for (int i = 0; i < ((columnWidths[0]+5) * array[0].length) ; i++) {
            System.out.print("ㅡ");
        }
        System.out.println();


        for (int i = 0; i < array.length; i++) {
            System.out.print(i + " |  ");
            for (int j = 0; j < array[i].length; j++) {
                // 각 열의 값 출력 후 공백 삽입하여 간격 맞춤
                System.out.printf("%-" + (columnWidths[j] + 5) + "s", array[i][j]);
            }
            System.out.println(); // 개행
        }
    }

    public static void arr2(String[][] array) {
        // 각 열의 최대 너비 계산
        int[] columnWidths = new int[array[0].length];
        for (String[] row : array) {
            for (int j = 0; j < row.length; j++) {
                int width = String.valueOf(row[j]).length();
                columnWidths[j] = Math.max(columnWidths[j], width);
            }
        }

        // 출력
        System.out.print("  |  ");
        for (int i = 0; i < array[0].length; i++) {
            System.out.printf("%-" + (columnWidths[i] + 5) + "s", i);
        }
        System.out.println();
        for (int i = 0; i < ((columnWidths[0]+5) * array[0].length) ; i++) {
            System.out.print("ㅡ");
        }
        System.out.println();



        for (int i = 0; i < array.length; i++) {
            System.out.print(i + " |  ");
            for (int j = 0; j < array[i].length; j++) {
                // 각 열의 값 출력 후 공백 삽입하여 간격 맞춤
                System.out.printf("%-" + (columnWidths[j] + 5) + "s", array[i][j]);
            }
            System.out.println(); // 개행
        }
    }


    public static void arr2(String[][] array, String[] rows, String[] cols) {

        boolean b_row = false;
        boolean b_col = false;

        if(rows != null && rows.length > 0) b_row = true;
        if(cols != null && cols.length > 0) b_col = true;

        // 각 열의 최대 너비 계산
        int[] columnWidths = new int[array[0].length];
        int leftColumnWidths = 0;
        for (String[] row : array) {
            for (int j = 0; j < row.length; j++) {
                int width = String.valueOf(row[j]).length();
                columnWidths[j] = Math.max(columnWidths[j], width);
            }
        }

        for (int i = 0; i < rows.length; i++) {
            int width = String.valueOf(rows[i]).length();
            columnWidths[i] = Math.max(columnWidths[i], width);
        }

        for (int i = 0; i < rows.length; i++) {
            int width = String.valueOf(rows[i]).length();
            leftColumnWidths = Math.max(leftColumnWidths, width);
        }

        // 출력
        System.out.printf("%-" + (leftColumnWidths) + "s | ", " ");
        for (int i = 0; i < array[0].length; i++) {
            if(b_row) {
                System.out.printf("%-" + (columnWidths[i] + 5) + "s", rows[i]);
            } else {
                System.out.printf("%-" + (columnWidths[i] + 5) + "s", i);
            }
        }
        System.out.println();
        for (int i = 0; i < ((columnWidths[0]+5) * array[0].length) ; i++) {
            System.out.print("ㅡ");
        }
        System.out.println();



        for (int i = 0; i < array.length; i++) {
            if(b_col) {
                System.out.printf("%-" + (leftColumnWidths) + "s | ", cols[i]);
            } else {
                System.out.print(i + " |  ");
            }


            for (int j = 0; j < array[i].length; j++) {
                // 각 열의 값 출력 후 공백 삽입하여 간격 맞춤
                System.out.printf("%-" + (columnWidths[j] + 5) + "s", array[i][j]);
            }
            System.out.println(); // 개행
        }
    }


    public static void main(String args[]) {
        String[][] arr = new String[][]{{"joy", "brad", "alessandro", "conan", "david"}, {"joy", "brad", "alessandro", "conan", "david"},{"joy", "alessandro", "alessandro", "alessandro", "alessandro"},{"joy", "joy", "joy", "conan", "david"}};
        P.arr2(arr, new String[]{"a111111", "b123123123123213",  "123123c", "d", "e"}, new String[] {"asdfsdf", "sdfsdfdsfsd", "sdfsdfsd", "546465465465465", "23r893hfuierajfklsdfklsd"});
    }


}