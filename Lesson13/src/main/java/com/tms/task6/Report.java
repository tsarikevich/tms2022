package com.tms.task6;

public class Report implements Reporting {
    @Override
    public void generateReport(Employee[] employees) {
        for (Employee employee : employees) {
            System.out.printf("| %-20s|%15.2f|%n", getFormattingFullName(employee), employee.getSalary());
        }
    }

    private String getFormattingFullName(Employee employee) {
        String[] partNames = employee.getFullName().split(" ");
        StringBuilder name = new StringBuilder();
        for (int i = partNames.length - 1; i > 0; i--) {
            name.append(partNames[i].toCharArray()[0]).append(".");
        }
        name.append(" ").append(partNames[0]);
        return name.toString();
    }

}
