package com.company;
public class Main {
    public static void main(String[] args) {
        sqldb sdb=new sqldb();
        sdb.getConnection();
        com.company.event eve= new com.company.event();
        eve.getWelcome();
        eve.cmd();
    }
}

