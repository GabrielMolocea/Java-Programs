package com.beginner;

import java.util.Scanner;

class SimpleCash{
    public static void main(String[] args){
        System.out.print("We spend o lot of money daily let's see how much we spend in a month. \n");
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter how much you spend in a working day: \n");
                double MoneyWorkDay = scan.nextDouble();
            System.out.print("And in week-end? \n");
                double MoneyWeekEnd = scan.nextDouble();
            System.out.print("Do you want to know how much you spend in: 1 month (Enter: 1) 3 months (Enter: 2) 6 months (Enter: 3) 1 year (Enter: 4)\n");
                int time = scan.nextInt();
                double AvrgWorkDays = 21.62;
                double AvrgDaysMonth = 30.50;
                double AvrgWeekEndsDays = AvrgDaysMonth - AvrgWorkDays;
                double oneMonth = (MoneyWorkDay * AvrgWorkDays) + (MoneyWeekEnd * AvrgWeekEndsDays);
                //Calculating for each chose

        switch (time){
            case 1:

                System.out.print("In a Month you are spending a average of: " + oneMonth );
                break;
            case 2:
                System.out.print("In 3 months you'r average spending is: " + (3 * oneMonth));
                break;
            case 3:
                System.out.print("In 6 months you'r average spending is: " + (6 * oneMonth));
                break;
            case 4:
                System.out.print("In a year you'r average spending is: " + (12 * oneMonth));
                break;
        }

    }
}