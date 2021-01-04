package shelter;

public class OrganicCat extends VirtualPet implements Organic_I{
    protected int bathroomCleanliness;

    public OrganicCat(String name, String description, int hunger, int boredom, int thirst, int bathroomCleanliness) {
        super(name, description, hunger, boredom, thirst);
        this.bathroomCleanliness = bathroomCleanliness;
    }

    @Override
    public void cleanBathroom() {
        this.bathroomCleanliness +=8;
    }

    @Override
    public void walk() {
        this.bathroomCleanliness+=3;
    }
    @Override
    public void updateOrganicLevels(){
        this.bathroomCleanliness-=2;
    }
    @Override
    public int getBathroomCleanliness(){
        return this.bathroomCleanliness;
    }
}
