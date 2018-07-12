import java.io.*;
public class MyClass{
    public static void main(String... args)throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String str = input.readLine();
        char[] chArr = str.toCharArray();
        int mid = str.length()/2;
        for(int i = 0; i < str.length();i++){
            for(int j = 0;j < str.length();j++){
                if(mid == i && i ==j)
                    System.out.print(chArr[j]);
                else if(j == i || j == (str.length()-1)-i)
                    System.out.print(chArr[j]);
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}
