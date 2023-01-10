import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        People[] peoples = new People[T];
        People[] tmp = new People[T];
        
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            peoples[i] = new People(Integer.parseInt(st.nextToken()), st.nextToken());
        }
        
        mergeSort(peoples, tmp, 0, T - 1);
        
        for (People p: peoples) {
            bw.write(p.age + " " + p.name + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
    
    public static void mergeSort(People[] ps, People[] tmp, int left, int right) {
        if (left >= right) {
            return;
        }
        
        int mid = left + (right - left) / 2;
        mergeSort(ps, tmp, left, mid);
        mergeSort(ps, tmp, mid + 1, right);
        merge(ps, tmp, left, right, mid);
    }
    
    public static void merge(People[] ps, People[] tmp, int left, int right, int mid) {
        int p = left;
        int q = mid + 1;
        int idx = p;
        
        while (p <= mid || q <= right) {
            if (p <= mid && q <= right) {
                if (ps[p].age <= ps[q].age) {
                    tmp[idx++] = ps[p++];
                } else {
                    tmp[idx++] = ps[q++];
                }
            } else if (p <= mid && q > right) {
                tmp[idx++] = ps[p++];
            } else {
                tmp[idx++] = ps[q++];
            }
        }
        
        for (int i = left; i <= right; i++) {
            ps[i] = tmp[i];
        }
    }
}

class People {
    int age;
    String name;
    
    People(int age, String name) {
        this.age = age;
        this.name = name;
    }
}