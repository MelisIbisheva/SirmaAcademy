import GenericArrayCreator.ArrayCreator;
import GenericBox.Box;
import GenericCountMethodStrings.CompareElement;
import GenericSwapMethod.SwapMethod;
import Jar.Jar;
import Scale.Scale;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.SplittableRandom;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* //ArrayCreator
        Integer [] arr = ArrayCreator.create(5,7);
        printArray(arr);

         */

        /*
        //Box
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Box<String> box = new Box<>(input);
            System.out.println(box);
            System.out.println();

        }

         */

        /*
        //Box of Integer
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(scanner.nextLine());
            Box<Integer> box = new Box<>(input);
            System.out.println(box);
            System.out.println();

        }

         */



        /*
        //SwapMethod
        System.out.println("Enter count: ");
        int n = Integer.parseInt(scanner.nextLine());


        List<Box<String>> stringBox = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Box<String> box = new Box<>(input);
            stringBox.add(box);
        }

        System.out.println("Enter indexes for swap");
        String swapCommand = scanner.nextLine();
        String[] commandData = swapCommand.split(" ");
        int index1 = Integer.parseInt(commandData[0]);
        int index2 = Integer.parseInt(commandData[1]);
        SwapMethod.swap(stringBox, index1,index2);

        for (Box e : stringBox){
            System.out.println(e);
        }


        // With type Integer

        List<Box<Integer>> integerBox = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(scanner.nextLine());
            Box<Integer> box = new Box<>(input);
            integerBox.add(box);
        }

        String swapCommand2 = scanner.nextLine();
        String[] commandData2 = swapCommand2.split(" ");
        int indexOne = Integer.parseInt(commandData2[0]);
        int indexTwo = Integer.parseInt(commandData2[1]);
        SwapMethod.swap(integerBox, indexOne,indexTwo);

        for (Box e : integerBox){
            System.out.println(e);
        }


         */


        /*
        // CompareElements
        System.out.println("Enter count of elements: ");
        int count = Integer.parseInt(scanner.nextLine());
        List<String> listOfStrings = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            System.out.println("Enter element: ");
            String input = scanner.nextLine();
            listOfStrings.add(input);
        }

        System.out.println("Enter element for compare: ");
        String elementForCompare = scanner.nextLine();
        System.out.println("Count greater element: "
                + CompareElement.countGreaterThan(listOfStrings, elementForCompare));


         */


    }

    public static void printArray(Object[] array) {
        for (Object element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}