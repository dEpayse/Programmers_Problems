package lv1;

import java.util.ArrayList;
import java.util.Arrays;

public class Pr17681 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        ArrayList<String> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] binaryString1 = String.format("%0" + n + "d", Long.parseLong(Integer.toBinaryString(arr1[i]))).toCharArray();
            char[] binaryString2 = String.format("%0" + n + "d", Long.parseLong(Integer.toBinaryString(arr2[i]))).toCharArray();

            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j++) {
                if(binaryString1[j]=='1' || binaryString2[j]=='1') {
                    sb.append('#');
                    continue;
                }
                sb.append(' ');
            }
            answer.add(sb.toString());
        }
        return answer.toArray(new String[n]);
    }

    public static void main(String[] args) {
        Pr17681 obj = new Pr17681();
        System.out.println(Arrays.toString(obj.solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28})));
        System.out.println(Arrays.toString(obj.solution(6, new int[]{46, 33, 33, 22, 31, 50}, new int[]{27, 56, 19, 14, 14, 10})));
    }
}
