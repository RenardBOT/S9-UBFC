package com.renardbot.ppc;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        int N = 5;
        int Q = 14;
        System.out.println("Q_"+Q/N+','+Q%N);
        /*Queen queen = new Queen();
        queen.build();
        queen.solve();*/
    }
}
