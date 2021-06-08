package com.wu;


import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;

public class CN1115 {
    class FooBar {
        private int n;
        int flag=0;
        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                // printFoo.run() outputs "foo". Do not change or remove this line.
                synchronized (this) {
                    while(true) {
                        if (flag == 0) {
                            printFoo.run();
                            flag = 1;
                            this.notify();
                            break;
                        }
                        else{
                            this.wait();
                        }
                    }
                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                // printBar.run() outputs "bar". Do not change or remove this line.
                synchronized (this) {
                    while(true) {
                        if (flag == 1) {
                            printBar.run();
                            flag = 0;
                            this.notify();
                            break;
                        }
                        else {
                            this.wait();
                        }
                    }
                }
            }
        }
    }
}
