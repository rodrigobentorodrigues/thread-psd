package br.edu.ifpb.sd.concorrencia;

/**
 *
 * @author rodrigobento
 */
public class Interceptador {

    private int estado = 0;
    private Object lock = new Object();

    public void travar() throws InterruptedException {
        synchronized (lock) {
            if (estado == 1) {
                lock.wait();
            } else {
                estado = 1;
            }
        }
    }

    public void destravar() {
        synchronized (lock) {
            lock.notify();
        }
    }

}
