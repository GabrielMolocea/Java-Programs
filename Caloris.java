package com.beginner;

import java.util.Scanner;

class Caloris{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Welcome to a calories/exercise (walking): \nTo start the calculator please type:\n 1 for Male and 2 for Female\n");
        int gender = scan.nextInt();
            System.out.print("Enter you'r weight: \n");
                double Weight1 = scan.nextDouble();
            System.out.print("Enter you'r height: \n");
                double Height = scan.nextDouble();
            System.out.print("Enter you'r age: \n");
                int Age = scan.nextInt();
            System.out.print("Time you walk per day: \n");
                double WalkTime = scan.nextDouble();
                    if (WalkTime < 30)
                       WalkTime = 1.2;
                    if (WalkTime == 30)
                        WalkTime = 1.55;
                    else
                        WalkTime = 1.725;
        switch (gender){
            default:
                System.out.print("Enter a real gender!");
            case 1:
                    double BMRM = 66 + (6.2 * Weight1 * 2.2) + (12.7 * (Height * 2.54)) - (6.76 * Age);
                    double TotalCaloriesBurnedMale = BMRM * WalkTime;
                System.out.print("To maintain you'r weight you need burn: " + TotalCaloriesBurnedMale + " calories per day");
                break;

            case 2:
                    double BMRF = 655.1 + (4.35 * Weight1 * 2.2) + (4.7 * (Height * 2.54)) - (4.7 * Age);
                    double TotalCaloriesBurnedFemale = BMRF * WalkTime;
                System.out.print("To maintain you'r weight you need burn: " + TotalCaloriesBurnedFemale + " calories per day");

                break;

    }

    }
}