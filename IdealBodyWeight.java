package com.beginner;

import java.util.Scanner;

class IdealBodyWeight {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome!\nEnter if you are choosing for a child (at most 10 years old) enter 1 else enter 2\n");
        int choose = scan.nextInt();
        switch (choose) {
            case 1:
                System.out.print("Your child is under one year old or over? (enter yes or no) \n");
                String age = scan.next();
                if(age.equals("yes")){
                    System.out.println("Enter how old is your child in months: \n");
                    double ChildEage = scan.nextDouble();
                    double ChildUnder1YearOld = (0.5 * ChildEage) + 4;
                        System.out.format("Your child ideal weight is: %.2f", ChildUnder1YearOld);
                }

                if(age.equals("no")) {
                    System.out.println("Enter how old is your child in years (maximum 10 years old): \n");
                    double ChildEage = scan.nextDouble();
                    double ChildOver1YearOld = (2 * ChildEage) + 10;
                    System.out.format("Your child ideal weight is: %.2f", ChildOver1YearOld);
                }
                break;
            case 2:
                System.out.print("Enter your height in cm: \n");
                double YourHeight = scan.nextDouble();
                System.out.print("Select witch method do you like to use Devine or Hamwi: \n");
                String Choose = scan.next();
                if (Choose.equals("Devine")) {
                    System.out.print("Type if you'r a male of female: \n");
                    String Gender = scan.next();
                    if (Gender.equals("male")) {
                        double DevineFormulaMales = 50 + 0.9 * (YourHeight - 152);
                        System.out.format("You'r ideal body weight for a male is: %.2f", DevineFormulaMales);
                    }
                    if (Gender.equals("female")) {
                        double DevibeFormulaFemales = 45.5 + 0.9 * (YourHeight - 152);
                        System.out.format("You'r ideal body weight for a male is: %.2f", DevibeFormulaFemales);
                    }
                }
                if (Choose.equals("Hamwi")) {
                    System.out.print("Type if you'r a male of female: \n");
                    String Gender = scan.next();
                    if (Gender.equals("male")) {
                        double HamwiFormulaMales = 48 + 1.1 * (YourHeight - 152);
                        System.out.format("You'r ideal body weight for a male is: %.2f kg", HamwiFormulaMales);
                    }
                    if (Gender.equals("female")) {
                        double HanwiFormukaFemakes = 45.4 + 0.9 * (YourHeight - 152);
                        System.out.format("You'r ideal body weight for a male is: %.2f kg", HanwiFormukaFemakes);
                    }
                }
                break;
        }
    }
}