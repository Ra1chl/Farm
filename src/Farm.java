import Animal.Animal;
import Flowers.Flower;

import java.util.ArrayList;

import Animal.Size;



public class Farm {
private int money = 100000;

private double plocha = 100;

    private ArrayList<Animal> animals = new ArrayList<>();
    private ArrayList<Flower> flowers = new ArrayList<>();
    public void addAnimal(Animal a) {

        int spaceSmall = 0;
        int spaceBig = 0;

        for (Animal animal : animals) {
            if (animal.getSize().equals(Size.SMALL)) {
                spaceSmall++;
            } else if (animal.getSize().equals(Size.BIG)) {
                spaceBig++;
            }
        }

        if (a.getSize() == Size.SMALL) {
            if (spaceSmall > 10) {
                animals.add(a);
            } else {
                System.out.println("neni misto");
            }
        }

        if (a.getSize() == Size.BIG) {
            if (spaceBig > 10) {
                animals.add(a);
            } else {
                System.out.println("neni misto");
            }
        }
    }

    public void sellAnimal(Animal a){

        if (animals.contains(a)){
            if (a.getSize() == Size.SMALL){
                animals.remove(a);
                money += 5000;

            }else if (a.getSize() == Size.BIG){
                animals.remove(a);
                money += 10000;
            }
        }
    }

    public void addFlower (Flower f){
        if (plocha > f.getNeededArea()){
            flowers.add(f);
            plocha = plocha - f.getNeededArea();
            money = (int) ( money - f.getPrice());
        }
    }

    public String removeFlower(Flower f){
        if (flowers.contains(f)){
            flowers.remove(f);
            return "flower removed";
        }else {
            return "flower doesnt exist";
        }
    }

}
