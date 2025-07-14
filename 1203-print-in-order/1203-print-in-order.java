class Foo {
    private Object lock;
    private boolean one;
    private boolean two;

    public Foo() {
        lock = new Object();
        one = false;
        two = false;
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        synchronized(lock){
            printFirst.run();
            one = true;
            lock.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        
        // printSecond.run() outputs "second". Do not change or remove this line.
        synchronized(lock){
            while(!one){
                lock.wait();
            }
            printSecond.run();
            two = true;
            lock.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        
        // printThird.run() outputs "third". Do not change or remove this line.
        synchronized(lock){
            while(!two){
                lock.wait();
            }
            printThird.run();
        }
    }
}

//notifyAll() : wakes up all threads waiting on the lock object. It’s used after first() finishes, so any thread waiting to run second() or third() gets a chance to check if it can proceed.
    