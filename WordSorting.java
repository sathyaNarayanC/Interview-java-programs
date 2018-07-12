import java.io.*;
import java.util.*;
public class MyClass{
    public static void main(String... args)throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String str = "q wer r fff kkkk fdfdfdsf jkjj fksdjfkdjsfjsdf ls.";
        str = str.replace(".","");
        String[] array = str.split(" ");
       for (int i = 1; i < array.length; i++) {
            for(int j = i ; j > 0 ; j--){
                if(array[j].length() < array[j-1].length()){
                    String temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
        
        String string = "";
      for(String s : array)
        string  = string + " " + s;
        string = string.trim();
    System.out.println(string.substring(0,1).toUpperCase()+string.substring(1)+".");
     }
}
