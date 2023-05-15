package dataStruct;

import java.util.Scanner;
import java.util.Stack;

public class BDSQZ{
    public static void main(String[] args) {
        Stack<Character> OPTR = new Stack<>();
        OPTR.push('#');                           //先放入#来帮助最后结束
        Stack<Integer> OPND = new Stack<>();
        Scanner sc = new Scanner(System.in);
        String c = sc.nextLine();
        int i = 0;
        while(c.charAt(i) != '#' || OPTR.peek() != '#'){
            if(Character.isDigit(c.charAt(i))){        //为数则加入OPND栈
                if(!OPND.isEmpty() && Character.isDigit(c.charAt(i - 1))){
                    OPND.push(OPND.pop() * 10 + c.charAt(i) - '0');
                }else {
                    OPND.push(c.charAt(i) - '0');
                }
                i++;
            }else {
                switch (compare(c.charAt(i), OPTR.peek())) {
                    case 1:
                        OPTR.push(c.charAt(i));
                        i++;
                        break;
                    case 2:
                        OPTR.pop();
                        i++;
                        break;
                    case 0:
                        OPND.push(operate(OPND.pop(), OPTR.pop(), OPND.pop()));
                        break;
                    case 4:
                        while(OPTR.peek()!='('){
                            OPND.push(operate(OPND.pop(), OPTR.pop(), OPND.pop()));
                        }
                        break;
                    case 3:
                        System.out.println("wrong");
                        return;
                }
            }
        }
        System.out.println(OPND.peek());
    }

    public static int compare(char a, char b){
        int c = 0, d = 0;
        switch (a){
            case '+': c = 0;break;
            case '-': c = 1;break;
            case '*': c = 2;break;
            case '/': c = 3;break;
            case '(': c = 4;break;
            case ')': c = 5;break;
            case '#': c = 6;break;
        }
        switch (b){
            case '+': d = 0;break;
            case '-': d = 1;break;
            case '*': d = 2;break;
            case '/': d = 3;break;
            case '(': d = 4;break;
            case ')': d = 5;break;
            case '#': d = 6;break;
        }
        int pre[][] = {{1,1,0,0,1,1,1},
                       {1,1,0,0,1,1,1},
                       {1,1,1,1,1,1,1},
                       {1,1,1,1,1,1,1},
                       {1,1,1,1,1,3,1},
                       {4,4,4,4,2,1,3},
                       {0,0,0,0,0,3,2}};
        return pre[c][d];
    }

    public static int operate(int a, char b, int c){
        switch (b){
            case '+': return c + a;
            case '-': return c - a;
            case '*': return c * a;
            case '/': return c / a;
        }
        return 0;
    }
}
