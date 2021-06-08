package com.wu;

import java.util.function.IntConsumer;

public class CN1116 {
    class ZeroEvenOdd {
        private int n;
        private int count;
        int flag = 0;


        public ZeroEvenOdd(int n) {
            this.n = n;
            this.count =1;
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            synchronized (this){
                while (true){
                    if(count>n)break;
                    if(flag==0){
                        printNumber.accept(0);
                        flag = 2-(count%2);
                        this.notifyAll();
                    }
                    else{
                        this.wait();
                    }
                }
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            synchronized (this){
                while (true){
                    if(count>n)break;
                    if(flag==2){
                        printNumber.accept(count);
                        count++;
                        flag = 0;
                        this.notifyAll();
                    }
                    else{
                        this.wait();
                    }
                }
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            synchronized (this){
                while (true){
                    if(count>n)break;
                    if(flag==1){
                        printNumber.accept(count);
                        count++;
                        flag = 0;
                        this.notifyAll();
                    }
                    else{
                        this.wait();
                    }
                }
            }
        }
    }
}
