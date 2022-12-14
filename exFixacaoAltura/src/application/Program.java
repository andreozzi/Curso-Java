package application;

import entities.Person;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Quantas pessoas serao digitadas? ");
        int n = sc.nextInt();
        sc.nextLine();

        Person[] vect = new Person[n];

        for(int i = 0; i< vect.length; i++){

            System.out.printf("Dados da %da pessoa: \n", i + 1);
            System.out.println("Nome: ");
            String name = sc.nextLine();
            System.out.println("Idade: ");
            int age = sc.nextInt();
            sc.nextLine();
            System.out.println("Altura: ");
            double height = sc.nextDouble();

            sc.nextLine();
            vect[i] = new Person(name, height, age);


        }
        System.out.println(vect[0].getAge()< 16);
        double sumH = 0.0;
        for (Person person : vect) {
            sumH += person.getHeight();

        }
        double avgH = sumH/ vect.length;
        System.out.printf("Altura media: %.2f%n",avgH);
        int underage = 0;
        for (Person person : vect) {
            if (person.getAge() < 16)
            {
                underage++;
            }
        }

        double underage_percent = ((double) underage/ vect.length)*100;

        System.out.printf("Pessoas com menos de 16 anos: %.1f%%\n", underage_percent);
        for (Person person : vect) {
            if (person.getAge() < 16) {
                System.out.printf("%s\n", person.getName());
            }
        }




        sc.close();
    }
}
