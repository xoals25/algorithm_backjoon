import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static int[] inArr;
    public static int[] inIdxArr;
    public static int[] postArr;
    public static int[] preArr;
    public static int preIdx = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer inSt = new StringTokenizer(br.readLine(), " ");
        StringTokenizer postSt = new StringTokenizer(br.readLine(), " ");

        inArr = new int[T];
        inIdxArr = new int[T + 1];
        postArr = new int[T];

        for (int i = 0; i < T; i++) {
            inArr[i] = Integer.parseInt(inSt.nextToken());
            postArr[i] = Integer.parseInt(postSt.nextToken());
        }

        for (int i = 0; i < T; i++) {
            inIdxArr[inArr[i]] = i;
        }

        preArr = new int[T];

        setPreOrderArr(0, T - 1, 0, T - 1);

        for (int pre: preArr) {
            bw.write(pre + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void setPreOrderArr(int inStart, int inEed, int postStart, int postEed) {
        if (inStart > inEed || postStart > postEed) {
            return;
        }

        int root = postArr[postEed];
        preArr[preIdx++] = root;

        int rootIdxOfInOrder = inIdxArr[root];
        int postLeftCount = rootIdxOfInOrder - inStart;

        setPreOrderArr(inStart, rootIdxOfInOrder - 1, postStart, postStart + postLeftCount - 1);
        setPreOrderArr(rootIdxOfInOrder + 1, inEed, postStart + postLeftCount, postEed - 1);
    }
}
