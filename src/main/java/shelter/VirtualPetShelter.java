package shelter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VirtualPetShelter {


    Map<String, VirtualPet> pets = new HashMap<String, VirtualPet>();

//    public VirtualPet getPet(String name) {
//        return pets.get(name);
//    }

    public Collection<VirtualPet> getAllPets() {
        return pets.values();
    }

    public void addPet(VirtualPet newPet) {
        pets.put(newPet.getName(), newPet);
        System.out.println(newPet.getName() + " has been added to the list of pets!");
        System.out.println("-------------------------------------");
    }


    public void adoptPet(String petChoice) {
        String petName = "";
        int count = 0;
        for (VirtualPet pet : getAllPets()) {
            if (petChoice.equalsIgnoreCase(pet.getName())) {
                System.out.println(pet.getName() + " Has been adopted!");
                petName = pet.getName();
                pets.remove(petName);
                break;
            } else {
                count++;
                if (count >= pets.size()) {
                    System.out.println(petChoice + " was not found");
                }
            }
        }
    }


    public void tick() {
        System.out.println("Ticking! All pets need some love!");
        System.out.println("-------------------------------------");
        for (VirtualPet pet : getAllPets()) {
            pet.updateLevels();
            if(pet instanceof Robotic_I){
                ((Robotic_I) pet).updateRoboticLevels();
            } else if(pet instanceof Organic_I){
                ((Organic_I) pet).updateOrganicLevels();
            }
        }
    }

    public VirtualPet createPet() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Lets add a pet!");
        System.out.println("What type of pet is this?");
        System.out.println("1. Robotic Dog");
        System.out.println("2. Robotic Cat");
        System.out.println("3. Organic Dog");
        System.out.println("4. Organic Cat");
        System.out.println("5. Regular Virtual Pet");
        System.out.println("Selection : ");
        String petTypeSelection = scanner.nextLine();
        VirtualPet newPet = null;
        switch (petTypeSelection) {
            case "1":
                System.out.println("What is the new pets name: ");
                String newPetRoboDogName = scanner.nextLine();
                System.out.println("Add a description for the new pet: ");
                String newPetRoboDogDescription = scanner.nextLine();
                VirtualPet newPetRoboDog = new RoboticDog(newPetRoboDogName, newPetRoboDogDescription, 20, 20, 20, 20);
                return newPetRoboDog;
            case "2":
                System.out.println("What is the new pets name: ");
                String newPetRoboCatName = scanner.nextLine();
                System.out.println("Add a description for the new pet: ");
                String newPetRoboCatDescription = scanner.nextLine();
                VirtualPet newPetRoboCat = new RoboticCat(newPetRoboCatName, newPetRoboCatDescription, 20, 20, 20, 20);
                return newPetRoboCat;
            case "3":
                System.out.println("What is the new pets name: ");
                String newPetOrgDogName = scanner.nextLine();
                System.out.println("Add a description for the new pet: ");
                String newPetOrgDogDescription = scanner.nextLine();
                VirtualPet newPetOrgDog = new OrganicDog(newPetOrgDogName, newPetOrgDogDescription, 20, 20, 20, 20);
                return newPetOrgDog;
            case "4":
                System.out.println("What is the new pets name: ");
                String newPetOrgCatName = scanner.nextLine();
                System.out.println("Add a description for the new pet: ");
                String newPetOrgCatDescription = scanner.nextLine();
                VirtualPet newPetOrgCat = new OrganicCat(newPetOrgCatName, newPetOrgCatDescription, 20, 20, 20, 20);
                return newPetOrgCat;
            case "5":
                System.out.println("What is the new pets name: ");
                String newPetName = scanner.nextLine();
                System.out.println("Add a description for the new pet: ");
                String newPetDescription = scanner.nextLine();
                newPet = new VirtualPet(newPetName, newPetDescription);
                return newPet;
            default:
                System.out.println("Invalid Choice!");
        }
        return newPet;
    }

    public int numberOfPets() {
        return pets.size();
    }

    public void feedAllPets() {
        for (VirtualPet pet : getAllPets()) {
            pet.feedPets();
        }
        System.out.println("All pets Have been fed!");
    }

    public void waterAllPets() {
        for (VirtualPet pet : getAllPets()) {
            pet.waterPets();
        }
        System.out.println("All pets Have been watered!!");
    }

    public void playWithPet(String petChoice) {
        int count = 0;
        for (VirtualPet pet : getAllPets()) {
            if (pet.getName().equalsIgnoreCase(petChoice)) {
                System.out.println("You have played with " + pet.getName());
                pet.play();
            } else {
                count++;
                if (count >= pets.size())
                    System.out.println(petChoice + " was not found!");
            }
        }
    }

    public String listPetNameAndDescription(){
        String toReturn = "";
        for(VirtualPet pet : getAllPets()){
            toReturn += pet.toString();
        }
        return toReturn;
    }

    public void examinePet(String petChoice) {
        int count = 0;
        for (VirtualPet pet : getAllPets()) {
            if (pet.getName().equalsIgnoreCase(petChoice)) {
                System.out.println("-------------------------------------");
                System.out.println("Name : " + pet.getName());
                System.out.println("Description: " + pet.getDescription());
                pet.examinePet();
                System.out.println("-------------------------------------");
                break;
            } else {
                count++;
                if (count >= pets.size()) {
                    System.out.println(petChoice + " was not found pet");
                }
            }
        }
    }


    public void displayLevels() {
        System.out.println("Name \t\t" + "Hunger \t\t" + "Thirst \t\t" + "Boredom \t\t" + "Oil Level" + "\t\t" + "Cage/Liter status");
        for (VirtualPet pet : getAllPets()) {
//            System.out.println(pet.getName() + "\t\t" + pet.getHunger() + "\t\t\t" + pet.getThirst() + "\t\t\t\t" + pet.getBoredom());
            if(pet instanceof Robotic_I){
                System.out.println(pet.getName() + "\t\t" + pet.getHunger() + "\t\t\t" + pet.getThirst() + "\t\t\t\t" + pet.getBoredom() + "\t\t\t\t" + ((Robotic_I) pet).getOilLevel());
            } else if(pet instanceof Organic_I) {
                System.out.println(pet.getName() + "\t\t" + pet.getHunger() + "\t\t\t" + pet.getThirst() + "\t\t\t\t" + pet.getBoredom() + "\t\t\t\t\t\t\t\t" + ((Organic_I) pet).getBathroomCleanliness());
            } else {
                System.out.println(pet.getName() + "\t\t" + pet.getHunger() + "\t\t\t" + pet.getThirst() + "\t\t\t\t" + pet.getBoredom());
            }
        }
    }

    public String getAction() {
        Scanner scanner = new Scanner(System.in);
        String choice = "";
        System.out.println("What would you like to do next?");
        System.out.println("1. Feed the pets");
        System.out.println("2. Water the pets");
        System.out.println("3. Play with a pet");
        System.out.println("4. Adopt a pet");
        System.out.println("5. Admit a pet");
        System.out.println("6. Examine a pet");
        System.out.println("7. Run Maintenance on Robo Pets");
        System.out.println("8. Clean Cage/Liter Box");
        System.out.println("9. Walk Dogs");
        System.out.println("10.Quit");
        return choice = scanner.nextLine();
    }

    public void runMaintenance(){
        for(VirtualPet pet : getAllPets()){
            if(pet instanceof Robotic_I){
                ((Robotic_I) pet).maintenance();
            }
        }
    }

    public void cleanBathroom(){
        for(VirtualPet pet : getAllPets()){
            if(pet instanceof Organic_I){
                ((Organic_I) pet).cleanBathroom();
            }
        }
    }

    public void walk(){
        for(VirtualPet pet : getAllPets()){
            if(pet instanceof RoboticDog){
                ((RoboticDog) pet).walk();
            } else if(pet instanceof  OrganicDog){
                ((OrganicDog) pet).walk();
            }
        }
    }

    public void initializePetsDatabase() {

        VirtualPet joey = new VirtualPet("Joseph", "Looks like hes seen better days", 23, 25, 22);
        VirtualPet johnny = new VirtualPet("Johnny", "is a bit nervous", 20, 18, 24);
        VirtualPet deedee = new VirtualPet("Dee Dee", "probably didnt start with that many legs", 19, 21, 22);
        VirtualPet tommy = new VirtualPet("Tommy", "Smells like a stargazer lily fresh with morning dew", 22, 22, 21);
        VirtualPet roboFido = new RoboticDog("RFido","A Robotic Dog",20,20,20,20);
        VirtualPet roboFelix = new RoboticCat("Rfelix","A Robotic Cat",20,20,20,20);
        VirtualPet orgMax = new OrganicDog("OMax","An Organic Dog",20,20,20,20);
        VirtualPet orgFelix = new OrganicCat("OFelix","An Organic Cat",20,20,20,20);
        addPet(roboFelix);
        addPet(roboFido);
        addPet(orgMax);
        addPet(orgFelix);
        addPet(joey);
        addPet(johnny);
        addPet(deedee);
        addPet(tommy);
    }


}
