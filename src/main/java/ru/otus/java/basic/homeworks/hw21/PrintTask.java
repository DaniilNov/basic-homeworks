package ru.otus.java.basic.homeworks.hw21;

class PrintTask implements Runnable {
    private static final int TOTAL_PRINTS = 5;
    private static volatile String currentTurn = "A";

    private final char character;
    private final Object monitor;
    private final String myTurn;
    private final String nextTurn;

    public PrintTask(char character, Object monitor, String myTurn, String nextTurn) {
        this.character = character;
        this.monitor = monitor;
        this.myTurn = myTurn;
        this.nextTurn = nextTurn;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < TOTAL_PRINTS; i++) {
                synchronized (monitor) {
                    while (!currentTurn.equals(myTurn)) {
                        monitor.wait();
                    }
                    System.out.print(character);
                    currentTurn = nextTurn;
                    monitor.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
