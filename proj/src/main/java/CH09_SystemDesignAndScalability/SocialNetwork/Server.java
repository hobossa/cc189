package CH09_SystemDesignAndScalability.SocialNetwork;

import java.util.HashMap;

public class Server {
    HashMap<Integer, Machine> machines = new HashMap<>();
    HashMap<Integer, Integer> personToMachineMap = new HashMap<>();

    public Machine getMachineWithID(int machineID) {
        return machines.get(machineID);
    }

    public int getMachineIDForUser(int personID) {
        Integer machineID = personToMachineMap.get(personID);
        return machineID == null ? -1 : machineID;
    }

    public Person getPersonWithID(int personID) {
        Integer machineID = personToMachineMap.get(personID);
        if (machineID == null) {
            return null;
        }
        Machine machine = getMachineWithID(machineID);
        if (machine == null) {
            return null;
        }

        return machine.getPersonWithID(personID);
    }


    public void addMachine(int numberOfMachines) {
        while (numberOfMachines-- > 0) {
            machines.put(machines.size(), new Machine());
        }
    }

    // In real cases, we can accord to specific strategies to allocate person to different machines to opt performance
    public void addPerson(int personID, Person person) {
        int machineID = personID % machines.size();
        getMachineWithID(machineID).addPerson(personID, person);
        personToMachineMap.put(personID, machineID);
    }
}
