
package a1q7;
import java.util.Scanner; 
import java.io.*;

public class A1q7 {

    
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        FileInputStream fstream = new FileInputStream("D:\\java.txt");
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String strLine="";
        String str="";
        while ((strLine = br.readLine()) != null)   {
            str+=strLine;
        }
        String st=str.replaceAll(" ", "");
        char[]third =st.toCharArray();
        System.out.println("Character     Total");
        for(int counter =0;counter<third.length;counter++){
            char ch= third[counter];
            int count=0;
            for ( int i=0; i<third.length; i++){
                if (ch==third[i])
                count++;
            }
            boolean flag=false;
            for(int j=counter-1;j>=0;j--){
            if(ch==third[j])
            flag=true;
            }
            if(!flag){
            System.out.println(ch+"                  "+count);
            }
        }
    }
}
