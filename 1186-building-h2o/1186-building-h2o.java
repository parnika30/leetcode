class H2O {
    
    private Semaphore oxy, hydro;

    public H2O() {
        hydro = new Semaphore(2);
        oxy = new Semaphore(1);
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException{
		
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        hydro.acquire();
        releaseHydrogen.run();
        oxy.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException{
        
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        oxy.acquire(2);
		releaseOxygen.run();
        hydro.release(2);
    }
}

// 2 semaphores
// collectively H will be 2 times, then O realese 1 time. 