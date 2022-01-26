package CH03_StacksAndQueues.AnimalShelter;

// An animal shelter, which holds only dogs and cats, operates on a strictly "first in, first out" basis.
// People must adopt either the "oldest" (based on arrival time) of all animals at the shelter, or they can
// select whether they would prefer a dog or a cat (and will receive the oldest animal of that type). They
// cannot select which specific animal they would like. Create thd data structures to maintain this system
// and implement operations such as enqueue, dequeueAny, dequeueDog, and dequeueCat.
// You may use the built-in LinkedList data structure.
// Hints: #22, #56, #63

public class AnimalShelterTest {
    public static void main(String[] args) {
        AnimalShelter_v1 shelter1 = new AnimalShelter_v1();
        shelter1.enqueue(AnimalShelter_v1.AnimalType.CAT, "Callie");
        shelter1.enqueue(AnimalShelter_v1.AnimalType.CAT, "Kiki");
        shelter1.enqueue(AnimalShelter_v1.AnimalType.DOG, "Fido");
        shelter1.enqueue(AnimalShelter_v1.AnimalType.DOG, "Dora");
        shelter1.enqueue(AnimalShelter_v1.AnimalType.CAT, "Kari");
        shelter1.enqueue(AnimalShelter_v1.AnimalType.DOG, "Dexter");
        shelter1.enqueue(AnimalShelter_v1.AnimalType.DOG, "Dobo");
        shelter1.enqueue(AnimalShelter_v1.AnimalType.CAT, "Copa");

        System.out.println(shelter1.dequeueDog());
        System.out.println(shelter1.dequeueCat());
        System.out.println(shelter1.dequeueDog());

        shelter1.enqueue(AnimalShelter_v1.AnimalType.DOG, "Dapa");
        shelter1.enqueue(AnimalShelter_v1.AnimalType.CAT, "Kilo");

        while (shelter1.size() != 0) {
            System.out.println(shelter1.dequeueAny());
        }
    }


}
