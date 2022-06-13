package by.teachmeskills.application;

import by.teachmeskills.mylist.MyLinkedList;

public class Application {
    public static void main(String[] args) {
        MyLinkedList<String> myList = new MyLinkedList<>();
        myList.addLast("11");
        myList.addLast("12");
        myList.addLast("13");
        myList.addFirst("10");
        System.out.println("Get first - " + myList.getFirst());
        myList.addLast("15");
        System.out.println("Get last - " + myList.getLast());
        System.out.println("Element with index 1 - " + myList.getElementByIndex(1));
        myList.setElementByIndex(1, "121");
        System.out.println("New element with index 1 - " + myList.getElementByIndex(1));
        myList.remove("121");
        System.out.println("New element with index 1 - " + myList.getElementByIndex(1));
        myList.removeByIndex(1);
        System.out.println("New element with index 1 - " + myList.getElementByIndex(1));
        myList.removeFirst();
        System.out.println("Get new first - " + myList.getFirst());
        myList.removeLast();
        System.out.println("Get new last - " + myList.getLast());
        System.out.println("Size myLinkedList - " + myList.size());
        myList.setElementByIndex(0, "555");
        System.out.println("Get new first - " + myList.getFirst());
        System.out.println("Get new last - " + myList.getLast());
        System.out.println("Is it contain 555? - " + myList.contains("555"));
        myList.add("11");
        myList.add("12");
        myList.add("13");
        myList.clear();
        System.out.println("Size myLinkedList after clear - " + myList.size());
    }
}
