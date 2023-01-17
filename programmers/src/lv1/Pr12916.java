package lv1;

public class Pr12916 {
    boolean solution(String s) {
        boolean answer = false;
        int count = 0;
        for(char alphabet : s.toLowerCase().toCharArray()) {
            if(alphabet=='p') count++;
            else if(alphabet=='y') count--;
        }
        if(count==0) answer = true;
        return answer;
    }

    public static void main(String[] args) {
        Pr12916 obj = new Pr12916();
        System.out.println(obj.solution("pPoooyY"));
        System.out.println(obj.solution("Pyy"));
    }
}

