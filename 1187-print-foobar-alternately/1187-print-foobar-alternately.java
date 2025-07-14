class FooBar {
    private int n;
    volatile int state = 0;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
        	// printFoo.run() outputs "foo". Do not change or remove this line.
            synchronized(this){
                while(state!=0){
                    wait();
                }
                printFoo.run();
                state = 1;
                notifyAll();
            }	
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
            // printBar.run() outputs "bar". Do not change or remove this line.
        	synchronized(this){
                while(state!=1){
                    wait();
                }
                printBar.run();
                state = 0;
                notifyAll();
            }	
        }
    }
}

//When state == 1, it means foo() has finished and bar() can safely print.
//When state == 0, it means bar() has finished and foo() can safely print.