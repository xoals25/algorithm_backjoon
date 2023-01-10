import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        String num = String.valueOf(T);
        StringBuffer sb = new StringBuffer();
        String[] nums = num.split("");
        
        Arrays.sort(nums, new Comparator<String>(){
           @Override
           public int compare(String o1, String o2) {
               return o2.compareTo(o1);
           }
        });
        
        num = String.join("", nums);
        
        bw.write(Integer.parseInt(num) + "\n");
        
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}