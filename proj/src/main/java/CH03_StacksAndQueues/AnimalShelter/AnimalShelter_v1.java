package CH03_StacksAndQueues.AnimalShelter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class AnimalShelter_v1 {
    public enum AnimalType {
        DOG, CAT;
    }

    private static class Animal {
        private final AnimalType type;
        private final String name;
        private final LocalDateTime arrivalTime;

        public Animal(AnimalType type, String name) {
            this.type = type;
            this.name = name;
            this.arrivalTime = LocalDateTime.now();
        }
    }

    private final ArrayList<Animal> cats;
    private final ArrayList<Animal> dogs;

    public AnimalShelter_v1() {
        this.cats = new ArrayList<>();
        this.dogs = new ArrayList<>();
    }

    public void enqueue(AnimalType type, String name) {
        if (AnimalType.DOG == type) {
            dogs.add(new Animal(type, name));
        } else if (AnimalType.CAT == type) {
            cats.add(new Animal(type, name));
        }
    }

    public String dequeueAny() {
        if (0 == size()) {
            throw new NoSuchElementException();
        }
        LocalDateTime oldestDogArrival = LocalDateTime.MAX;
        LocalDateTime oldestCatArrival = LocalDateTime.MAX;
        if (dogs.size() > 0) {
            oldestDogArrival = dogs.get(0).arrivalTime;
        }
        if (cats.size() > 0) {
            oldestCatArrival = cats.get(0).arrivalTime;
        }
        return oldestCatArrival.compareTo(oldestDogArrival) < 0 ? cats.remove(0).name : dogs.remove(0).name;
    }

    public String dequeueDog() {
        if (0 == dogs.size()) {
            throw new NoSuchElementException();
        }
        return dogs.remove(0).name;
    }

    public String dequeueCat() {
        if (0 == cats.size()) {
            throw new NoSuchElementException();
        }
        return cats.remove(0).name;
    }

    public int size() {
        return dogs.size() + cats.size();
    }
}
