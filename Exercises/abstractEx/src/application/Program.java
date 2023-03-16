package application;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<TaxPayer> list = new ArrayList<>();

        System.out.print("Enter the number of Tax Payers: ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i =1; i<=n;i++){
            System.out.println("Tax payer #"+i+" data:");
            System.out.print("Individual or Company (i/c)?");
            char c = sc.next().charAt(0);
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Anual income: ");
            double anualIncome = sc.nextDouble();
            sc.nextLine();
            if (c == 'i'){
                System.out.print("Health expenditures: ");
                double healthExpenditures = sc.nextDouble();
                sc.nextLine();
                list.add(new Individual(name, anualIncome, healthExpenditures));

            }
            else {
                System.out.print("Number of employees: ");
                int numberOfEmployees = sc.nextInt();
                sc.nextLine();
                list.add(new Company(name, anualIncome, numberOfEmployees));
            }
        }


        double total = 0.0;
        System.out.println("TAXES PAID: ");
        for (TaxPayer tp :list) {
            System.out.println(tp.getName()+": $ "+String.format("%.2f",tp.tax()));
            total += tp.tax();

        }
        System.out.println();

        System.out.println("TOTAL TAXES: $ "+String.format("%.2f", total));

        sc.close();
    }
}
