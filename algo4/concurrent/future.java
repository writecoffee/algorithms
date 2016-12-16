import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class future
{
    public static void main(String[] args)
    {
        ExecutorService executor = Executors.newCachedThreadPool();

        Future<Integer> future = executor.submit(new Callable<Integer>() {

            @Override
            public Integer call()
            {
                Random random = new Random();
                int duration = random.nextInt(4000);

                try {
                    Thread.sleep(duration);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Finished my task. ");
                return duration;
            }
        });

//        Future<Integer> future2 = executor.submit(new Callable<Integer>() {
//
//            @Override
//            public Integer call()
//            {
//                Random random = new Random();
//                int duration = random.nextInt(4000);
//
//                try {
//                    Thread.sleep(duration);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//                System.out.println("Finished . ");
//                return duration;
//            }
//        });

        try {
            System.out.println("Task duration is: " + future.get());
            System.out.println("Global is done");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

}
