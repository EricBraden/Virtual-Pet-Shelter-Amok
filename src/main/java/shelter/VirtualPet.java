package shelter;

public class VirtualPet {
    private String name;
    private String description;
    private int hunger;
    private int boredom;
    private int thirst;



    public VirtualPet(String name, String description, int hunger, int boredom, int thirst) {
        this.name = name;
        this.description = description;
        this.hunger = hunger;
        this.boredom = boredom;
        this.thirst = thirst;
    }

    public VirtualPet(String name, String description) {
        this.name = name;
        this.description = description;
        this.hunger = 20;
        this.boredom = 20;
        this.thirst = 20;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getHunger() {
        return hunger;
    }

    public int getBoredom() {
        return boredom;
    }

    public int getThirst() {
        return thirst;
    }

    public void updateLevels() {
        this.hunger -= 2;
        this.boredom -= 2;
        this.thirst -= 2;
    }

    public void feedPets() {
        this.hunger += 5;
    }

    public void waterPets() {
        this.thirst += 5;
    }

    public void play() {
        this.boredom += 8;
    }

    public void examinePet() {
        this.hunger += 5;
        this.thirst += 5;
        this.boredom += 5;
        System.out.println(name + " is happy you are paying attention to them!");
    }

    @Override
    public String toString(){
        return "Name:  " + this.name + "\t\t\t\t\t" + "Description:   " + this.description + "\n";
    }
}
