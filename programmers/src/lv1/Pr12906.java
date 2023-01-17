package lv1;

import java.util.ArrayList;
import java.util.Arrays;

public class Pr12906 {
    public int[] solution(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        int temp = -1;
        for(int it : arr) {
            if(it!=temp) {
                list.add(it);
                temp = it;
            }
        }

        return list.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        Pr12906 obj = new Pr12906();
        System.out.println(Arrays.toString(obj.solution(new int[]{1, 1, 3, 3, 0, 1, 1})));
        System.out.println(Arrays.toString(obj.solution(new int[]{4, 4, 4, 3, 3})));
    }
}