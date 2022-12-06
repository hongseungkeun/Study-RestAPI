package com.example.repositoryTest;

import com.example.repository.Generated;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GeneratedTest {
    @Test
    @DisplayName("올바르게 1이 증가 되는지")
    public void generatedTest(){
        Runnable run1 = new CheckThread();
        Runnable run2 = new CheckThread();
        Runnable run3 = new CheckThread();
        Runnable run4 = new CheckThread();
        Runnable run5 = new CheckThread();

        Thread thread1 = new Thread(run1);
        Thread thread2 = new Thread(run2);
        Thread thread3 = new Thread(run3);
        Thread thread4 = new Thread(run4);
        Thread thread5 = new Thread(run5);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
    class CheckThread implements Runnable{

        @Override
        public void run() {
            System.out.println(Generated.incrementId());
        }
    }
}
