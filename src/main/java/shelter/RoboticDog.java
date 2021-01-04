package shelter;

public class RoboticDog extends VirtualPet implements Robotic_I{

    protected int oilLevel;

    public RoboticDog(String name, String description, int hunger, int boredom, int thirst, int oilLevel) {
        super(name, description, hunger, boredom, thirst);
        this.oilLevel = oilLevel;
    }

    @Override
    public void maintenance() {
        System.out.println("You have run maintenance on " + this.getName());
        this.oilLevel += 8;
    }

    @Override
    public void walk(){
        System.out.println("You have walked Robotic Dog " + this.getName());
        this.oilLevel-=6;
    }

    @Override
    public void updateRoboticLevels(){
        this.oilLevel-=2;
        System.out.println("Oil level dropping on " +this.getName());
    }

    @Override
    public int getOilLevel(){
        return this.oilLevel;
    }


}
