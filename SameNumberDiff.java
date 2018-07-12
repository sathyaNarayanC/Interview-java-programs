import java.util.*;
public class SameNumberDiff {
    public static void main(String args[]) {
        Scanner n = new Scanner(System.in);
        String strInput = n.nextLine();
        int num = n.nextInt();
        String outputStr= "";
        int count =0;
        String[] strArr = strInput.split(",");
        for(int i = 0;i<strArr.length;i++){
            for(int j = i+1; j < strArr.length;j++){
                if(Math.abs(Integer.parseInt(strArr[i]) - Integer.parseInt(strArr[j])) == num){
                    if(!outputStr.contains(strArr[i] + "," + strArr[j])){
                        outputStr = outputStr + "(" + strArr[i] + "," + strArr[j] + ")";
                        count++;
                    }
                }
            }
        }
        System.out.println(outputStr);
        System.out.println(count);
    }
}
