package com.tms.task1;

public class MainTask1 {
    public static void main(String[] args) {
        /**
         * 1) Вырезать подстроку из строки начиная с первого вхождения символа(А) до, последнего вхождения сивола(B).*/
        StringBuilder s = new StringBuilder("AUBERGINE");
        if (s.indexOf("A") != -1 && s.indexOf("B") != -1) {
            System.out.println(s.substring(s.indexOf("A"), s.lastIndexOf("B") + 1)); //включая символ B
        }
    }
}



