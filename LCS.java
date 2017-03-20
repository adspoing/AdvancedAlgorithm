import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        char[] a=in.next().toCharArray();
        char[] b=in.next().toCharArray();
        LCS(a,b);
    }
    public static void LCS(char[] a,char[] b){
        int lenA=a.length;
        int lenB=b.length;
        int[][] dp=new int[lenA+1][lenB+1];
        int[][] keep=new int[lenA+1][lenB+1];
        for(int i=0;i<=lenA;i++){
            dp[i][0]=0;
        }
        for(int i=0;i<=lenB;i++){
            dp[0][i]=0;
        }
        for(int i=1;i<=lenA;i++){
            for(int j=1;j<=lenB;j++){
                if(a[i-1]==b[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        for(int i=1;i<=lenA;i++){
            for(int j=1;j<=lenB;j++){
                if(dp[i][j]==dp[i-1][j-1]+1){
                    keep[i][j]=2;
                }
                else if(dp[i][j]==dp[i][j-1]){
                    keep[i][j]=1;
                }
                else
                {
                    keep[i][j]=0;
                }
            }
        }
        print(keep,lenA,lenB,a,b);
    }
    public static  void print(int[][] keep,int m,int n,char[] a,char[] b){
        if(keep[m][n]==2&&m>0&&n>0){
            System.out.print(m+" "+n+" ");
            m--;
            n--;
            print(keep,m,n,a,b);
        }else if(keep[m][n]==1&&m>0&&n>0){
            n--;
            print(keep,m,n,a,b);
        }
        else if(keep[m][n]==0&&m>0&&n>0)
        {
            m--;
            print(keep,m,n,a,b);
        }
    }

}