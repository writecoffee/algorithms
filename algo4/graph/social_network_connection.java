import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;

/**
 * How would you design the data structures for a very large social network like Facebook or
 * Linked/n? Describe how you would design an algorithm to show the connection, or path, between two
 * people (e.g., Me -> Bob -> Susan -> Jason -> You).
 * 
 * {@linkplain CC150-10.2}
 * 
 */
public class social_network_connection {
    public class Person {
        private ArrayList<Integer> friendIDs;
        private int personID;

        public Person(int id) {
            this.personID = id;
        }

        public int getID() {
            return personID;
        }

        public void addFriend(int id) {
            friendIDs.add(id);
        }
    }

    public class Machine {
        public HashMap<Integer, Person> persons = new HashMap<Integer, Person>();
        public int machinelD;

        public Person getPersonWithID(int personID) {
            return persons.get(personID);
        }

        public ArrayList<Person> getPersons(ArrayList<Integer> personIds) {
            ArrayList<Person> result = new ArrayList<Person>();

            for (Integer personId : personIds) {
                result.add(persons.get(personId));
            }

            return result;
        }
    }

    public class Server {
        private HashMap<Integer, Machine> hMachine = new HashMap<Integer, Machine>();
        private HashMap<Integer, Integer> hPersonId2MachineId = new HashMap<Integer, Integer>();

        private Person getPersonWithID(int personID) {
            return hMachine.get(hPersonId2MachineId.get(personID)).getPersonWithID(personID);
        }

        public ArrayList<Person> getRelationshipPath(int from, int to) {
            ArrayList<Person> result = new ArrayList<Person>();
            Queue<Person> q = new LinkedList<Person>();
            q.add(getPersonWithID(from));
            HashMap<Integer, Person> hParent = new HashMap<Integer, Person>();

            while (!q.isEmpty()) {
                Person c = q.poll();

                if (c.personID == to) {
                    result.addAll(backtrack(from, to, hParent));
                    break;
                }

                HashMap<Integer, ArrayList<Integer>> hBatch = new HashMap<Integer, ArrayList<Integer>>();

                /*
                 * Rather than randomly dividing people up across machines, try to divide them up by
                 * country, city, state, and so on. This will reduce the number of jumps so we need to
                 * batch the machine jumps (lookup).
                 */
                for (Integer friendId : c.friendIDs) {
                    Integer machineId = hPersonId2MachineId.get(friendId);

                    if (!hBatch.containsKey(machineId)) {
                        hBatch.put(machineId, new ArrayList<Integer>());
                    }

                    hBatch.get(machineId).add(friendId);
                }

                /*
                 * Breadth First Search requires "marking" a node as visited. In the second pass we
                 * should avoid looking-up backwards.
                 */
                for (Entry<Integer, ArrayList<Integer>> ent : hBatch.entrySet()) {
                    Integer machineId = ent.getKey();
                    ArrayList<Integer> nextHop = new ArrayList<Integer>();

                    for (Integer tFriendId : ent.getValue()) {
                        if (!hParent.containsKey(tFriendId)) {
                            nextHop.add(tFriendId);
                            hParent.put(tFriendId, c);
                        }
                    }

                    q.addAll(hMachine.get(machineId).getPersons(nextHop));
                }
            }

            return result;
        }

        private ArrayList<Person> backtrack(int from, int to, HashMap<Integer, Person> hParent) {
            ArrayList<Person> result = new ArrayList<Person>();

            while (to != from) {
                result.add(hParent.get(to));
                to = hParent.get(to).personID;
            }

            return result;
        }
    }
}