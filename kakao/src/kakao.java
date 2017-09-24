class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int index = -1;
        int[] result = new int[3];  // 각 라운드 점수 계산

        for(int i=0;i<dartResult.length();i++){
            if(dartResult.charAt(i)>='0' && dartResult.charAt(i) <='9'){
                if(dartResult.charAt(i)=='1'&& dartResult.charAt(i+1)=='0') {
                    index++;
                    result[index] = 10;
                    i++;
                }
                else {
                    index++;
                    result[index] = dartResult.charAt(i)-48;
                }

            }
            else if(dartResult.charAt(i)=='D') {
                result[index] *= result[index];
            }
            else if(dartResult.charAt(i)=='T') {
                result[index] *= result[index] * result[index];
            }
            else if(dartResult.charAt(i)=='*') {
                if(index>=1) {
                    result[index] *= 2;
                    result[index-1] *= 2;
                }
                else{
                    result[index] *= 2;
                }
            }
            else if(dartResult.charAt(i)=='#') {
                result[index] *= (-1);

            }
        }


        for(int i=0;i<3;i++) {
            answer += result[i];
        }


        return answer;
    }
}