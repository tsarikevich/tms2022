package com.tms.task2;

public class MainTask2 {
    public static void main(String[] args) {
        /** 2) Заменить все вхождения символа стоящего в позиции (3) на символ стоящий в позиции 0*/
        StringBuilder s1 = new StringBuilder("Hello World");
        if (!s1.isEmpty() && s1.length() >= 3) {
            StringBuilder s2 = new StringBuilder().insert(0, s1.charAt(3));
            for (int i = 0; i < s1.length(); i++) {
                if (s2.charAt(0) == s1.charAt(i)) {
                    s1.setCharAt(i, s1.charAt(0));
                }
            }
            System.out.println(s1);
            //или
            String s4 = "Hello World";
            if (!s4.isEmpty()) {
                s4 = s4.replace('l', 'H');
                System.out.println(s4);
            }
        }
    }
}



