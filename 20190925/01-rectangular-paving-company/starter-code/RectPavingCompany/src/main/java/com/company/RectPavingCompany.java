package com.company;

import java.util.Scanner;

public class RectPavingCompany {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Width of Driveway(ft): ");
        int drivewayWidth = scanner.nextInt();

        System.out.println("Length of Driveway(ft): ");
        int drivewayLength = scanner.nextInt();

        int drivewayArea = drivewayLength * drivewayWidth;
        System.out.println("Area of Driveway is " + drivewayArea);

        int drivewayPerimeter = drivewayLength * 2 + drivewayWidth * 2;
        System.out.println("Perimeter of Driveway is " + drivewayPerimeter);

        float costCement = 12.50f * drivewayArea;
        float framingCost = 8.25f * drivewayPerimeter;
        float totalCost = costCement + framingCost;

        String formattedCostCement = String.format("%.2f", costCement);
        String formattedCostFraming = String.format("%.2f", framingCost);
        String formattedTotalCost = String.format("%.2f", totalCost);

        System.out.println("Cement Subtotal: " + formattedCostCement);
        System.out.println("Framing/Footer Subtotal: " + formattedCostFraming);
        System.out.println("Total Cost: " + formattedTotalCost);

    }
}
