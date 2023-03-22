import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] people = new int[9];
        int sum = 0;
        
        for (int i = 0; i < 9; i++) {
            people[i] = Integer.parseInt(br.readLine());
            sum += people[i];
        }
        
        for (int i = 0; i < 9; i++) {
            int a = people[i];
            
            for (int j = i + 1; j < 9; j++) {
                int b = people[j];
                
                if (sum - a - b == 100) {
                    sum = 100;
                    people[i] = Integer.MAX_VALUE;
                    people[j] = Integer.MAX_VALUE;
                    break;
                }
            }
            
            if (sum == 100) {
                break;
            }
        }
        
        Arrays.sort(people);
        
        for (int i = 0; i < 7; i++) {
            System.out.println(people[i]);
        }

        br.close();
    }
}
