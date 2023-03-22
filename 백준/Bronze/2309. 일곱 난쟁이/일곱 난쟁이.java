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
        
        findSeven(sum, people);
        
        Arrays.sort(people);
        
        for (int i = 0; i < 7; i++) {
            System.out.println(people[i]);
        }

        br.close();
    }
    
    public static void findSeven(int sum, int[] people) {
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - people[i] -  people[j] != 100) {
                    continue;
                }
                
                people[i] = Integer.MAX_VALUE;
                people[j] = Integer.MAX_VALUE;
                return;
            }
        }
    }
}
