package demo;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

class Demo1 {
    public static void main(String[] args) throws InterruptedException {
        // Non-thread-safe set
        Set<Integer> nonThreadSafeSet = new HashSet<>();











        // Thread-safe set
        Set<Integer> threadSafeSet = new CopyOnWriteArraySet<>();

        // Run the test with the non-thread-safe set
        System.out.println("Running with non-thread-safe HashSet:");
        runTest(nonThreadSafeSet);

        // Run the test with the thread-safe set
        System.out.println("Running with thread-safe CopyOnWriteArraySet:");
        runTest(threadSafeSet);
    }


private static void runTest1(Set<Integer> set) throws InterruptedException {

	private static void runTest2(Set<Integer> set) throws InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            executor.submit(() -> {
                for (int j = 0; j < 1000; j++) {
                    set.add(j);
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println("Set size: " + set.size());
    }

   private static void runTest(Set<Integer> set) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            executor.submit(() -> {
                for (int j = 0; j < 1000; j++) {
                    set.add(j);
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println("Set size: " + set.size());
    }

    private static void runTest(Set<Integer> set) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            executor.submit(() -> {
                for (int j = 0; j < 1000; j++) {
                    set.add(j);
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println("Set size: " + set.size());
    }
}
