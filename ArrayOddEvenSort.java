import java.io.*;
public class MyClass{
    public static void main(String... args) throws IOException{
        BufferedReader input =  new BufferedReader(new InputStreamReader(System.in));
        String str = input.readLine();
        String[] strArr = (str.split(","));
        int[] intArr = new int[strArr.length];
        for(int i = 0; i< strArr.length;i++)
            intArr[i] = Integer.parseInt(strArr[i]);
        for(int i = 0; i< intArr.length;i++){
            for(int j = i; j < intArr.length;j=j+2){
                if(i == 0 || i % 2 ==0){
                    if(intArr[i] < intArr[j]){
                        int temp = intArr[i];
                        intArr[i] = intArr[j];
                        intArr[j] = temp;
                    }
                }
                else{
                    if(intArr[i] > intArr[j]){
                        int temp = intArr[i];
                        intArr[i] = intArr[j];
                        intArr[j] = temp;
                }
            }
        }//9,2,7,4,5,6,3,8,1 
    }//13,2 4,15,12,10,5
    for(int x : intArr)
    System.out.print(" "+x);
}
}
