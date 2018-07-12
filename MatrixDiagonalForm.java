public class MyClass {
    public static void main(String args[]) {
        int i = 0, j = 0 ; int k;
        int mat[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16},{17,18,19,20}};
        while(i <= 3){
             j = 0;
             k= i;
             while(j <= i && k >= 0){
             System.out.print(" "+mat[j][k]);
             j++;
             k--;
             }
             i++;
        }
       
       i = 1;
       
       while(i <= 3){
           j = 3;
           k = i;
       while(j >=1 && k <= 3){
           System.out.print(" "+mat[k][j]);
           k++;
           j--;
       }
       i++;
       }
       
    }
}
