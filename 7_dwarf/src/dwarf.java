import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class dwarf {
    static int[] dwarf;
    static boolean flag = false;

    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dwarf = new int[9];
        int[] picked = {-1, -1, -1, -1, -1, -1, -1};
        int sum = 0;

        for (int i = 0; i < 9; i++) {
            dwarf[i] = Integer.parseInt(br.readLine());
        }

        /*for (int i = 0; i < 3; i++) {
            System.out.print(N[i]);
        }*/

        find(9,picked,7,sum);

    }

    public static void find(int n, int[] picked, int toPick, int sum) {
        if(!flag) {
            //기저사례 1
            if(toPick==0 && sum==100) {
                flag = true;
                //정렬
                int[] result = new int[7];
                for(int i=0;i<picked.length; i++) {
                    result[i] = dwarf[picked[i]];
                }
                Arrays.sort(result);
                for(int i=0;i<picked.length; i++) {
                    System.out.println(result[i]);
                }
                return;
            }
            //기저사례 2
            if(toPick==0) { return;}

            //가장 작은 녀석 계산
            int smallest = 0;
            if(picked[0] == -1) {
                smallest = 0;
            }
            else {
                for(int i=1; i<7; i++) {
                    if(picked[i] == -1) {
                        smallest = picked[i-1]+1;
                        break;
                    }
                }
            }

            //한명 뽑고 재귀 돌리기
            for(int next = smallest; next<n;next++) {
                picked[7-toPick] = next;
                sum+=dwarf[next];
                find(n,picked,toPick-1,sum);
                picked[7-toPick] = -1;
                sum-=dwarf[next];
            }
        }
        else {
            return;
        }
    }
}