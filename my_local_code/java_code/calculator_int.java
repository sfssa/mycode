package 数据结构课设.项目3;

import java.util.Stack;

public class Calculator {
    public static void main(String[] args) {
        //声明两个栈（数栈，符号栈）
        Stack<Double> numberStack = new Stack<>();
        Stack<String> operStack = new Stack<>();

        String express = "3 * ( ( 2 + 5 ) + 8 / ( 2 * 2 + 2 * 2 ) )";
        //将字符串转化为数组
        String[] strings = express.split(" ");
        //遍历数组字符串
        for (String itme : strings) {
            //首先判断是否为数字
            if (!isOper(itme)) {//表示位数字，直接入数栈
                System.out.println(itme);
                numberStack.push(Double.valueOf(itme));
            } else {
                //判断栈是否为空,为空直接入栈
                if (operStack.isEmpty()) {
                    operStack.push(itme);
                } else {//不为空
                    if (itme.equals("(") || itme.equals(")")){//判断是否为括号
                        if(itme.equals("(")){
                            operStack.push(itme);
                        }else {
                            while (true){
                                String oper = operStack.pop();
                                if (oper.equals("(")){
                                    break;
                                }
                                Double num1 = numberStack.pop();
                                Double num2 = numberStack.pop();
                                numberStack.push(calculation(num1,num2,oper));
                            }
                        }
                    }else {
                        if (priority(itme) > priority(operStack.peek())) {
                            operStack.push(itme);
                        }else if (priority(itme) <= priority(operStack.peek())){
                            System.out.println(operStack.peek());
                            Double num1 = numberStack.pop();
                            Double num2 = numberStack.pop();
                            String oper = operStack.pop();
                            numberStack.push(calculation(num1,num2,oper));
                            operStack.push(itme);//当前符号栈进栈
                        }
                    }
                }
            }
        }
        Double res;
        while (true) {
            if (numberStack.size() == 1) {
                res = numberStack.pop();
                break;
            }
            Double num1 = numberStack.pop();
            Double num2 = numberStack.pop();
            String oper = operStack.pop();
            numberStack.push(calculation(num1, num2, oper));
        }
        System.out.println("表达式计算结果为：" + res);
    }

    //判断是否为运算符
    public static boolean isOper(String e) {
        if (e.equals("*")){
            return true;
        }else if (e.equals("/")){
            return true;
        }else if (e.equals("+")){
            return true;
        }else if (e.equals("-")){
            return true;
        }else if (e.equals("(")){
            return true;
        }else if (e.equals(")")){
            return true;
        }else{
            return false;
        }
    }

    //计算
    public static double calculation(Double num1, Double num2, String e) {
        Double res= Double.valueOf(0);
        switch (e) {
            case "+":
                res = num1 + num2;
                break;
            case "*":
                res = num1 * num2;
                break;
            case "-":
                res = num2 - num1;
                break;
            case "/":
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }

    //符号的优先级
    public static int priority(String e) {
        if (e.equals("*") || e.equals("/")) {
            return 1;
        } else if (e.equals("+") || e.equals("-")) {
            return 0;
        } else {
            return -1;
        }
    }
}
