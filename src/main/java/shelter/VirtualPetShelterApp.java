package shelter;

import java.util.Scanner;

public class VirtualPetShelterApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String action = "";
        VirtualPetShelter shelter = new VirtualPetShelter();
        shelter.initializePetsDatabase();

        System.out.println("Welcome to the Shelter of Awesomeness!");

        do {
            shelter.displayLevels();
            action = shelter.getAction();
            switch (action) {
                case "1":
                    shelter.feedAllPets();
                    break;
                case "2":
                    shelter.waterAllPets();
                    break;
                case "3":
                    System.out.println(shelter.listPetNameAndDescription());
                    System.out.println("Who would you like to play with?");
                    String petChoice = scanner.nextLine();
                    shelter.playWithPet(petChoice);
                    break;
                case "4":
                    System.out.println(shelter.listPetNameAndDescription());
                    System.out.println("What is the name of the pet has been adopted?");
                    String petAdoption = scanner.nextLine();
                    shelter.adoptPet(petAdoption);
                    break;
                case "5":
                    shelter.addPet(shelter.createPet());
                    break;
                case "6":
                    System.out.println(shelter.listPetNameAndDescription());
                    System.out.println("What is the name of the pet you would like to examine?");
                    String petExamine = scanner.nextLine();
                    shelter.examinePet(petExamine);
                    break;
                case "7":
                    shelter.runMaintenance();
                    break;
                case "8":
                    shelter.cleanBathroom();
                    break;
                case "9":
                    shelter.walk();
                    break;
                case "10":
                    System.out.println("Exiting the Virtual Pet Shelter! Come back soon!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
            if (!action.equals("10")) {
                shelter.tick();
            }

        } while (!action.equals("10"));
    }
}