package 数据结构课设.项目1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class project1 {
    static List<dataConstruct>list=new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    //菜单实现
    public static void menu(){
        System.out.println("1,初始化信息");
        System.out.println("2,统计各学校总分");
        System.out.println("3,按学校名称显示学校总分");
        System.out.println("4，按学校名称或编号显示各项目总分排序");
        System.out.println("5,按学校编号查询某个项目的获奖状况");
        System.out.println("6,按项目编号查询取得前三名的学校");
        System.out.println("7,打印所有学校信息");
        System.out.println("8,保存文件");
        System.out.println("9,读取文件");
        System.out.println("0,退出");
    }
    //初始化信息
    public static void initial(){
        char select='y';
        while(select!='n') {
            dataConstruct d = new dataConstruct();
            //项目设为五个，初始化设学校有五个，每个学校有五个队伍
            System.out.println("请输入学校编号:");
            int id = sc.nextInt();
            d.setId(id);
            sc.nextLine();
            System.out.println("请输入学校名称:");
            String name=sc.nextLine();
            d.setName(name);
            //sc.nextLine();
            System.out.println("请输入参赛队伍数目:");
            int count = sc.nextInt();
            d.setCount(count);
            int choice;
            int score = 0;
            for (int i = 0; i < d.count; i++) {
                System.out.println("请输入参赛项目:(1-项目1,2-项目2...");
                choice = sc.nextInt();
                System.out.println("请输入项目成绩:");
                score = sc.nextInt();
                if (choice == 1)
                    d.p1[d.p11++] += score;
                else if (choice == 2)
                    d.p2[d.p22++] += score;
                else if (choice == 3)
                    d.p3[d.p33++] += score;
                else if (choice == 4)
                    d.p4[d.p44++] += score;
                else if (choice == 5)
                    d.p5[d.p55++] += score;
                else {
                    System.out.println("您的输入有误");
                }
            }
            list.add(d);
            System.out.println("是否继续输入数据？(y/n)");
            select=sc.next().charAt(0);
        }

    }
    //输出各学校的总分
    public static void printSumOfAllSchool(){
        int result;
        int t;
        for (dataConstruct d : list) {
            result=0;
            t=d.p11;
            while(t!=0) {
                result += d.p1[--t];
            }
            t=d.p22;
            while(t!=0) {
                result += d.p2[--t];
            }
            t=d.p33;
            while(t!=0) {
                result += d.p3[--t];
            }
            t=d.p44;
            while(t!=0) {
                result += d.p4[--t];
            }
            t=d.p55;
            while(t!=0) {
                result += d.p5[--t];
            }
            System.out.println(d.name+"的总分为:"+result);
        }
    }
    //按照学校名称显示各项目总分的排序
    public static void sortBySchool(){
      
        for (dataConstruct d: list) {
            System.out.println(d.name+"排序如下:");

        }
    }
    //按学校名称显示学校总分
    public static void sumOfSchool(){
        String name;
        int result=0;
        int t;
        System.out.print("请输入学校名称:");
        name=sc.nextLine();
        boolean flag=false;
        for (dataConstruct d : list) {
            if (name.equals(d.name)) {
                flag=true;
                t=d.p11;
                while(t!=0) {
                    result += d.p1[--t];
                }
                t=d.p22;
                while(t!=0) {
                    result += d.p2[--t];
                }
                t=d.p33;
                while(t!=0) {
                    result += d.p3[--t];
                }
                t=d.p44;
                while(t!=0) {
                    result += d.p4[--t];
                }
                t=d.p55;
                while(t!=0) {
                    result += d.p5[--t];
                }
                System.out.println(name+"的总分为:"+result);
            }
        }
        if(flag==false)
            System.out.println("您的输入有误！该学校未参加本次比赛！");
    }
    //按学校编号查询某个学校获奖情况（一等奖，二等奖，三等奖，未获奖）
    public static void prize(){

    }
    //按项目编号输出前三名学校
    public static void top_Three(){

    }
    public static void print(){
        int t;
        //System.out.println("学校编号       学校名称");
        for (dataConstruct d : list) {
            System.out.println("   "+d.id+"         "+d.name);
            System.out.println("项目得分如下:");
            System.out.print("项目一得分:    ");
            t=d.p11;
            while(t!=0) {
                System.out.print(d.p1[--t] + " ");
            }
            System.out.println();
            System.out.print("项目二得分:    ");
            t=d.p22;
            while(t!=0) {
                System.out.print(d.p2[--t] + " ");
            }
            System.out.println();
            System.out.print("项目三得分:    ");
            t=d.p33;
            while(t!=0) {
                System.out.print(d.p3[--t] + " ");
            }
            System.out.println();
            System.out.print("项目四得分:    ");
            t=d.p44;
            while(t!=0) {
                System.out.print(d.p4[--t] + " ");
            }
            System.out.println();
            System.out.print("项目五得分:    ");
            t=d.p55;
            while(t!=0) {
                System.out.print(d.p5[--t] + " ");
            }
            System.out.println();
            System.out.println("-----------------------------------------------------------");

        }
    }
    //保存文件的函数
    public static void storage(){

    }
    public static void readStorage(){

    }
    //主函数
    public static void main(String[] args) {
        int choice=-1;
        while (choice!=0) {
            menu();
            System.out.print("请输入您的选择:");
            choice =sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    initial();
                    break;
                case 2:
                    printSumOfAllSchool();
                    break;
                case 3:
                    sumOfSchool();
                    break;
                case 4:
                    sortBySchool();
                    break;
                case 5:
                    prize();
                    break;
                case 6:
                    top_Three();
                    break;
                case 7:
                    print();
                    break;
                case 8:
                    storage();
                    break;
                case 9:
                    readStorage();
                case 0:
                    System.exit(0);
                default:
                    System.out.println("您的输入有误！");
            }
        }
        sc.close();
    }
}
