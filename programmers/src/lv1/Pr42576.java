package lv1;

import java.util.Arrays;

public class Pr42576 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);
        int idx = 0;
        for(String p : participant) {
            if(idx > completion.length - 1) return p;
            if(!p.equals(completion[idx])) return p;
            idx++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Pr42576 obj = new Pr42576();
        System.out.println(obj.solution(new String[] {"leo", "kiki", "eden"}, new String[] {"eden", "kiki"}));
        System.out.println(obj.solution(new String[] {"marina", "josipa", "nikola", "vinko", "filipa"}, new String[] {"josipa", "filipa", "marina", "nikola"}));
        System.out.println(obj.solution(new String[] {"mislav", "stanko", "mislav", "ana"}, new String[] {"stanko", "ana", "mislav"}));
    }
}
