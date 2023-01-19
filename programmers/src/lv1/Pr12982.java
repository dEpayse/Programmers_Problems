package lv1;

import java.util.Arrays;

public class Pr12982 {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        for(int department : d) {
            if(budget - department >= 0) {
                answer++;
                budget = budget - department;
                continue;
            }
            break;
        }
        return answer;
    }

    public static void main(String[] args) {
        Pr12982 obj = new Pr12982();
        System.out.println(obj.solution(new int[]{1,3,2,5,4}, 9));
        System.out.println(obj.solution(new int[]{2,2,3,3},10));
    }
}
