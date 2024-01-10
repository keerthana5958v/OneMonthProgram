package org.example;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("\nthis is a Interest calculator");
        System.out.println("enter 1 to calculate Return on investment --- like FD and RD");
        System.out.println("enter 2 to calculate Loss on investment   --- like loan");
        Scanner scan = new Scanner(System.in);
        String temp = scan.nextLine();

        if(temp.equals("1")){
            System.out.println("calculating ROI");
            System.out.println("enter 1 to calculate RD");
            System.out.println("enter 2 to calculate FD");
            String temp2 = scan.nextLine();
            if(temp2.equals("1")){
                System.out.println("calculating RD\n");
            }
            if(temp2.equals("2")){
                System.out.println("calculating FD\n");
            }
            Interest interest = new Interest();
            ROICalculator roiOb = new ROICalculator();

            System.out.println("enter A to enter own value, B to get default ROI for 1 year 1000- principal 8% rate of interest");
            String temp3 = scan.nextLine();
            if(temp3.equalsIgnoreCase("B")){
                if(temp2.equals("1")){
                    roiOb.calculateRD();
                }
                if(temp2.equals("2")){
                    roiOb.calculateFD();
                }
                System.out.println("your roi is : " + roiOb.getROI());
            }
            if(temp3.equalsIgnoreCase("A")) {
                System.out.println("enter principal amount");
                interest.setPrincipalAmount(scan.nextLong());
                System.out.println("enter tenure (year)");
                interest.setTenure(scan.nextInt());
                System.out.println("enter interest rate");
                interest.setInterestRate(scan.nextFloat());

                ROICalculator roi = new ROICalculator(roiOb.getTenure(), roiOb.getPrincipalAmount(), roiOb.getInterestRate());
                if (temp2.equals("1")) {
                    roi.calculateRD(roi.getPrincipalAmount(), roi.getInterestRate(), roi.getTenure());
                }
                if (temp2.equals("2")) { ///long principalAmount,float interestRate,int tenure
                    roi.calculateFD(roi.getPrincipalAmount(), roi.getInterestRate(), roi.getTenure());
                }
                System.out.println("your roi is : " + roi.getROI());
            }
        }
        if(temp.equals("2")){
            System.out.println("calculating LOI");
            LOICalculator loiOb = new LOICalculator();
            System.out.println("enter A to enter own value, B to get default ROI for 1 year 1000- principal 8% rate of interest");
            String temp4 = scan.nextLine();
            if(temp4.equalsIgnoreCase("B")){
                loiOb.calculateLoanAmount();
                System.out.println("your roi is : "+loiOb.getROI());
            }
            if(temp4.equalsIgnoreCase("A")){
                System.out.println("enter principal amount");
                loiOb.setPrincipalAmount(scan.nextLong());
                System.out.println("enter tenure (year)");
                loiOb.setTenure(scan.nextInt());
                System.out.println("enter interest rate");
                loiOb.setInterestRate(scan.nextFloat());
                LOICalculator loi = new LOICalculator(loiOb.getTenure() , loiOb.getPrincipalAmount() , loiOb.getInterestRate());
                loi.calculateLoanAmount(loi.getPrincipalAmount(), loi.getInterestRate(),loi.getTenure());
                System.out.println("your roi is : "+loi.getROI());
            }

        }
    }
}




