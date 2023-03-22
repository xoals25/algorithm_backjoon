import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N; // 숫자 개수
    static int[] nums; // 숫자들
    static int[] tools; //연산자의 개수
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        nums = new int[N];
        tools = new int[4];

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < 4; i++) {
            tools[i] = Integer.parseInt(st.nextToken());
        }

        calc(nums[0], 0);
        System.out.println(max);
        System.out.println(min);

        br.close();
    }

    public static void calc(int num, int numIdx) {
        if (numIdx + 1>= N) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        for (int i = 0; i < tools.length; i++) {
            if (tools[i] != 0) {
                tools[i]--;
                int calcNum = calulator(num, i, nums[numIdx + 1]);
                calc(calcNum, numIdx + 1);
                tools[i]++;
            }
        }
    }

    public static int calulator(int a, int toolIdx, int b) {
        if (toolIdx == 0) {
            return plus(a, b);
        } else if (toolIdx == 1) {
            return minus(a, b);
        } else if (toolIdx == 2) {
            return multi(a, b);
        } else {
            return divide(a, b);
        }
    }

    public static int plus(int a, int b) {
        return a + b;
    }

    public static int minus(int a, int b) {
        return a - b;
    }

    public static int multi(int a, int b) {
        return a * b;
    }

    public static int divide(int a, int b) {
        if (a < 0 && b > 0) {
            return -a / b * -1;
        } else if (a > 0 && b < 0) {
            return a / -b * -1;
        }

        return a / b;
    }
}