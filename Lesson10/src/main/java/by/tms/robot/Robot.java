package by.tms.robot;

import by.tms.robot.hands.IHand;
import by.tms.robot.heads.IHead;
import by.tms.robot.legs.ILeg;
import lombok.ToString;

import java.util.ArrayList;


@ToString
public class Robot implements IRobot {
    private IHead head;
    private IHand hand;
    private ILeg leg;

    public Robot(IHead head, IHand hand, ILeg leg) {
        this.head = head;
        this.hand = hand;
        this.leg = leg;
    }

    public Robot() {
    }

    public IHead getHead() {
        return head;
    }

    public void setHead(IHead head) {
        this.head = head;
    }

    public IHand getHand() {
        return hand;
    }

    public void setHand(IHand hand) {
        this.hand = hand;
    }

    public ILeg getLeg() {
        return leg;
    }

    public void setLeg(ILeg leg) {
        this.leg = leg;
    }

    @Override
    public void action() {
        head.speak();
        hand.upHand();
        leg.step();
    }

    /**
     * Get the cost of a robot
     *
     * @return int
     */
    @Override
    public int getPrice() {
        int price = head.getPrice() + hand.getPrice() + leg.getPrice();
        return price;
    }

    public static void getRobotsWithHigherCost(IRobot... robot) {
        int maxPrice = 0;
        for (int i = 0; i < robot.length; i++) {
            maxPrice = robot[0].getPrice();
            if (maxPrice < robot[i].getPrice()) {
                maxPrice = robot[i].getPrice();
            }
        }
        ArrayList<IRobot> iRobots = new ArrayList<>();
        for (IRobot iRobot : robot) {

            if (maxPrice == iRobot.getPrice()) {
                iRobots.add(iRobot);
            }
        }
        System.out.println("Роботы с наибольшей стоимостью:\n" + iRobots);
    }

}


