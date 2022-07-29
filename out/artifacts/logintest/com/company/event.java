package com.company;

import java.util.Scanner;

/**
 * @author: FuKang.Huang
 * @date: 2022/7/27 9:28
 */
public class event {

    public void getLogin(){
        System.out.println();
        System.out.println("登录");
        System.out.println();
        System.out.println("请输入账号：");
        Scanner getName = new Scanner(System.in);
        String username = getName.nextLine();
        System.out.println("请输入密码：");
        Scanner getPass = new Scanner(System.in);
        String passWd = getPass.nextLine();
        sqldb sdb= new sqldb();
        if(sdb.getLogin(username,passWd)){
            System.out.println("登录成功！");
        }else if(!sdb.getLogin(username,passWd)){
            System.out.println("账号或密码不正确！");
        }
    }


    public void getWelcome(){
        System.out.println("");
        System.out.println("      Alogin!welcome!      ");
        System.out.println("");
        System.out.println("login | authme | quit");
    }


    public void getSignUp(){
        System.out.println();
        System.out.println("注册");
        System.out.println();
        System.out.println("请输入账号：");
        Scanner getName = new Scanner(System.in);
        String username = getName.nextLine();
        System.out.println("请输入密码：");
        Scanner getPass = new Scanner(System.in);
        String passWd = getPass.nextLine();

        sqldb sdb = new sqldb();
        if(sdb.getLogin(username,passWd)){
            System.out.println("错误！账号或已存在！");
        }else if(!sdb.getLogin(username,passWd)){
            sdb.getConnection();
            int id = sdb.getLastId();
            System.out.println(id);
            sdb.getInsert(id,username,passWd);
            sdb.closeConnection();
            System.out.println("注册成功！");
        }
    }

    public void getSignUptest(){
        System.out.println();
        System.out.println("注册");
        System.out.println();
        System.out.println("请输入账号：");
        Scanner getName = new Scanner(System.in);
        String username = getName.nextLine();
        System.out.println("请输入密码：");
        Scanner getPass = new Scanner(System.in);
        String passWd = getPass.nextLine();
        sqldb sdb = new sqldb();
        System.out.println(username);
        System.out.println(sdb.getLogin(username,passWd));
    }
    public void cmd(){
        event eve = new event();
        while (true){
            Scanner getwhat =new Scanner(System.in);
            String a1 = getwhat.next();
            if(a1.equals("login") || a1.equals("l") || a1.equals("lo") || a1.equals("log")){
                eve.getLogin();
                break;
            }else if(a1.equals("a") ||a1.equals("au") ||a1.equals("authme")||a1.equals("auth")){
                eve.getSignUp();
                break;
            }else if(a1.equals("quit") ||a1.equals("q") ){
                break;
            }else{
                System.out.println("错误！请选择一项进行下一步！");
                System.out.println("login | authme | quit");
            }



            //
        }
    }
}
