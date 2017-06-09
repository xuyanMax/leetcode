package zooPackage;

// author Chris.Trathen
public class Bird extends Animal {

    public Bird(String name) {
        this.name = name;
        this.typeOfAnimal = "Bird";
    }

    @Override
    public void speak() {
        System.out.println("Chirp");
    }

    @Override
    public boolean canFly() {
        return true;
    }

}
