package lv1;

import java.util.HashSet;

public class Pr1845 {
    public int solution(int[] nums) {
        HashSet<Integer> selectedPoncketmon = new HashSet<>();
        int maxCnt = nums.length / 2;
        for (int num : nums) {
            if (selectedPoncketmon.size() < maxCnt) {
                selectedPoncketmon.add(num);
            }
            else break;
        }
        return selectedPoncketmon.size();
    }

    public static void main(String[] args) {
        Pr1845 obj = new Pr1845();
        System.out.println(obj.solution(new int[]{3,1,2,3}));
        System.out.println(obj.solution(new int[]{3,3,3,2,2,4}));
        System.out.println(obj.solution(new int[]{3,3,3,2,2,2}));
    }
}
