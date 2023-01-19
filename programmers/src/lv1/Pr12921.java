package lv1;

public class Pr12921 {
    public int solution(int n) {
        int answer = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrimeNum(i)) answer++;
        }
        return answer;
    }

    public boolean isPrimeNum(int n) {
        double sqrtValue = Math.sqrt(n);
        for (int i = 2; i <= sqrtValue; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Pr12921 obj = new Pr12921();
        System.out.println(obj.solution(10));
        System.out.println(obj.solution(5));
    }
}
