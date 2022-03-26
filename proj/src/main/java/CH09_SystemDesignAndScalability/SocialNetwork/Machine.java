package CH09_SystemDesignAndScalability.SocialNetwork;

import java.util.HashMap;

public class Machine {
    public HashMap<Integer, Person> persons = new HashMap<>();
    public int machineID;
    public Person getPersonWithID(int personID) {
        return persons.get(personID);
    }

    public void addPerson(int personID, Person person) {
        persons.put(personID, person);
    }
}
