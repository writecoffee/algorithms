import java.util.PriorityQueue;

public class elevator {
    enum State {
        IDLE, GOING_UP, GOING_DOWN
    }

    class Passenger {
        int weight;
        int volumn;
    }

    class Floor {
        int id;
    }

    class Elevator {
        State currentState;
        PriorityQueue<Floor> pqDown;
        PriorityQueue<Floor> pqUp;
        PriorityQueue<Floor> pq;
        Floor destinationFloor;
        Floor currentFloor;

        private void doSchedule() {
            switch (currentState) {
            case IDLE:
                if (pqDown.isEmpty() && pqUp.isEmpty()) {
                    currentState = State.IDLE;
                } else if (pqDown.isEmpty()) {
                    currentState = State.GOING_UP;
                    pq = pqUp;
                } else if (pqUp.isEmpty()) {
                    currentState = State.GOING_DOWN;
                    pq = pqDown;
                }
                break;
            case GOING_UP:
                if (pqUp.isEmpty() && pqDown.isEmpty()) {
                    currentState = State.IDLE;
                } else if (pqUp.isEmpty()) {
                    currentState = State.GOING_DOWN;
                    pq = pqDown;
                }
                break;
            case GOING_DOWN:
                if (pqUp.isEmpty() && pqDown.isEmpty()) {
                    currentState = State.IDLE;
                } else if (pqDown.isEmpty()) {
                    currentState = State.GOING_DOWN;
                    pq = pqDown;
                }
                break;
            default:
                break;
            }

            destinationFloor = pq.poll();
        }
        
        public void onDoorOpened() {
            doUnload();
            doLoad();
        }

        private void doUnload() {
        }

        private void doLoad() {
        }

        public void onDloorClosed() {
            doSchedule();
        }

        public void acceptRequest(Floor floor) {
            if (floor.id > currentFloor.id) {
                pqUp.add(floor);
            } else if (floor.id < currentFloor.id) {
                pqDown.add(floor);
            }
        }
    }
}