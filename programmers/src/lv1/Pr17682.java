package lv1;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pr17682 {
    public int solution(String dartResult) {
        int answer = 0;
        ArrayList<Integer> sumList = new ArrayList<>();
        Matcher matcher = Pattern.compile("\\d+[SDT][*#]?").matcher(dartResult);
        int idx = 0;
        while(matcher.find()) {
            String splitted = matcher.group();
            int score = Integer.parseInt(splitted.split("[SDT]")[0]);
            if(splitted.contains("D")) {
                score = (int)Math.pow(score, 2);
            }
            else if(splitted.contains("T")) {
                score = (int)Math.pow(score, 3);
            }

            if(splitted.contains("*")) {
                if(idx != 0) {
                    sumList.set(idx - 1, sumList.get(idx - 1) * 2);
                }
                sumList.add(score * 2);
            }
            else if(splitted.contains("#")) {
                sumList.add(-score);
            }
            else {
                sumList.add(score);
            }
            idx++;
        }

        for(int it : sumList) {
            answer += it;
        }

        return answer;
    }

    public static void main(String[] args) {
        Pr17682 obj = new Pr17682();
        System.out.println(obj.solution("1S2D*3T"));
        System.out.println(obj.solution("1D2S#10S"));
        System.out.println(obj.solution("1D2S0T"));
        System.out.println(obj.solution("1S*2T*3S"));
        System.out.println(obj.solution("1D#2S*3S"));
        System.out.println(obj.solution("1T2D3D#"));
        System.out.println(obj.solution("1D2S3T*"));
    }
}
