package com.epam.jmp;

/**
 * Created by Gleb88 on 09.06.2017.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        Result result = new Result(0);

        Thread thread1 = new Thread(()->
            {
                synchronized(result){
                    result.setR(result.getR() + 5);
                }

            }
        );
        Thread thread2  = new Thread(()->
            {
                synchronized(result) {
                    result.setR(result.getR() * 3);
                }
            }
        );
        Thread thread3  = new Thread(()->
            {
                synchronized(result) {
                    result.setR(result.getR() - 7);
                }
            }
        );

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println(result.getR());

        Result concurrenRresult = new Result(0);
        Thread concurrentThread1 = new Thread(()->
        {
            concurrenRresult.lock.lock();
            concurrenRresult.setR(concurrenRresult.getR() + 5);
            concurrenRresult.lock.unlock();

        }
        );
        Thread concurrentThread2  = new Thread(()->
        {
            concurrenRresult.lock.lock();
            concurrenRresult.setR(concurrenRresult.getR() * 3);
            concurrenRresult.lock.unlock();
        }
        );
        Thread concurrentThread3  = new Thread(()->
        {
            concurrenRresult.lock.lock();
            concurrenRresult.setR(concurrenRresult.getR() - 7);
            concurrenRresult.lock.unlock();
        }
        );

        concurrentThread1.start();
        concurrentThread2.start();
        concurrentThread3.start();

        concurrentThread1.join();
        concurrentThread2.join();
        concurrentThread3.join();

        System.out.println(concurrenRresult.getR());

    }
}
