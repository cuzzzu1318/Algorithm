
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Main {
    public static void main(String args[]) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        for(int tc = 1; tc<= 10; tc++) {
            int N = Integer.parseInt(br.readLine());
            char[] arr = new char[N];
            String str = br.readLine();
            for(int i = 0; i < N; i++)
                arr[i]=str.charAt(i);

            Deque<Character> stack = new ArrayDeque<>();
            boolean check = true;
            for(int i = 0; i < N; i++) {
                if(arr[i] == '(' || arr[i] == '{' || arr[i] == '<'||arr[i]=='[') {
                    stack.push(arr[i]);
                }
                else {
                    if(!stack.isEmpty()) {
                        char now = stack.pop();
                        if((arr[i] == ')' && now != '(')|| (arr[i] == '}' && now !='{') || (arr[i] == '>' && now !='<')||(arr[i]==']'&&now!='[')) {
                            System.out.println(i+" "+arr[i]+" "+now);
                        	check = false;
                            
                            break;
                        }
                    }
                    else {
                        check = false;
                        break;
                    }

                }
            }
            if(check) System.out.println("#" + tc +" " + "1");
            else System.out.println("#" + tc + " "+"0");
        }
    }
}