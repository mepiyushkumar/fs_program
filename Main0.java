import java.util.*;

public class Main0{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        if(s.length()<3){
            System.out.println("false");
        }
        else{
            StringBuilder sb=new StringBuilder(s);
            int flag=1;
            while(sb.length()>0 && flag == 1){
                for( int i=0;i<sb.length()-3;i++){
                    
                    if(sb.charAt(i)=='p'&&sb.charAt(i+1)=='q'&&sb.charAt(i+2)=='r'){
                        flag = 0;
                        sb.delete(i,i+3);
                        System.out.println("asc"+sb.toString());

                    }


                }
                if(flag!=0){
                    break;
                }
                else{
                    flag=0;
                }
            }


            if(sb.length()==0){
                System.out.println("true");
            }
        
            else{
                System.out.println("false");
            }

    }
    }
}