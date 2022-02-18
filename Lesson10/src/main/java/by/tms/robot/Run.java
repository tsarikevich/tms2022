package by.tms.robot;

import by.tms.robot.hands.SamsungHand;
import by.tms.robot.hands.SonyHand;
import by.tms.robot.hands.ToshibaHand;
import by.tms.robot.heads.SamsungHead;
import by.tms.robot.heads.SonyHead;
import by.tms.robot.heads.ToshibaHead;
import by.tms.robot.legs.SamsungLeg;
import by.tms.robot.legs.SonyLeg;
import by.tms.robot.legs.ToshibaLeg;

public class Run {
    public static void main(String[] args) {
        /*
        Создать по 3 реализации(Sony, Toshiba, Samsung) каждой запчасти(IHead, IHand, ILeg)
        Класс SonyHead является примером реализацией головы от Sony.
        Создайте 3 робота с разными комплектующими.
        Например у робота голова и нога от Sony а, рука от Samsung.
        У всех роботов вызовите метод action.
        Среди 3-х роботов найдите самого дорогого.
        */
        IRobot robot1 = new Robot(new ToshibaHead(20), new SamsungHand(10), new SonyLeg(10));
        IRobot robot2 = new Robot(new SonyHead(30), new ToshibaHand(15), new SamsungLeg(20));
        IRobot robot3 = new Robot(new SamsungHead(50), new SonyHand(20), new ToshibaLeg(25));
        IRobot robot4 = new Robot(new SonyHead(50), new SonyHand(20), new ToshibaLeg(25));
        System.out.println("-----------------------------");
        robot1.action();
        System.out.println("-----------------------------");
        robot2.action();
        System.out.println("-----------------------------");
        robot3.action();
        System.out.println("-----------------------------");
        robot4.action();
        System.out.println("-----------------------------");
        System.out.println("Стоимость робота 1 - " + robot1.getPrice());
        System.out.println("Стоимость робота 2 - " + robot2.getPrice());
        System.out.println("Стоимость робота 3 - " + robot3.getPrice());
        System.out.println("Стоимость робота 4 - " + robot4.getPrice());
        Robot.getRobotsWithHigherCost(robot1, robot2, robot3, robot4);

    }
}
