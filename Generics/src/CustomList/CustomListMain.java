package CustomList;

import java.util.Scanner;

public class CustomListMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomList<String> customList = new CustomList<String>();
        
        while (true) {
            System.out.println("Enter command: ");
            String[] command = scanner.nextLine().split("\\s+");
            switch (command[0]) {
                case "Add":
                    customList.add(command[1]);
                    break;

                case "Remove":
                    int index = Integer.parseInt(command[1]);
                    customList.remove(index);
                    break;

                case "Contains":
                    System.out.println(customList.contains(command[1]));
                    break;

                case "Swap":
                    int index1 = Integer.parseInt(command[1]);
                    int index2 = Integer.parseInt(command[2]);
                    customList.swap(index1, index2);
                    break;

                case "Greater":
                    System.out.println(customList.countGreaterThan(command[1]));
                    break;

                case "Max":
                    System.out.println(customList.getMax());
                    break;

                case "Min":
                    System.out.println(customList.getMin());
                    break;

                case "Print":
                    customList.print();
                    break;

                default:
                    System.out.println("Unknown command");
                    break;
            }
        }
    }
}
