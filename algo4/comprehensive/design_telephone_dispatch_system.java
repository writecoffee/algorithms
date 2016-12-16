import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class design_telephone_dispatch_system
{
    public class Number
    {
        String num;
        AtomicBoolean isTaken;

        Number(String n) {
            num = n;
            isTaken = new AtomicBoolean(false);
        }
    }

    public class DispatchSystem
    {
        Number[] pool;
        List<Number> freeNumber;
        List<Number> takenNumber;
        AtomicInteger index;

        DispatchSystem(int count) {
            pool = new Number[count];
            for (int i = 0; i < count; i++) {
                pool[i] = new Number("");
            }

            freeNumber = new ArrayList<>();
            takenNumber = new ArrayList<>();
            index = new AtomicInteger(0);
        }

        boolean takeNumber(Number number)
        {
            synchronized (number) {
                if (!number.isTaken.get()) {
                    number.isTaken.set(true);
                    return true;
                } else {
                    return false;
                }
            }
        }

        boolean isTaken(Number number)
        {
            return number.isTaken.get();
        }

        Number getANumber()
        {
            boolean success = false;

            while (!success) {
                int myIndex = index.getAndAdd(1);
                while (pool[myIndex].isTaken.get()) {
                    myIndex = index.getAndIncrement();
                }

                if (takeNumber(pool[myIndex])) {
                    success = true;
                    return pool[myIndex];
                }
            }

            return null;
        }
    }
}
