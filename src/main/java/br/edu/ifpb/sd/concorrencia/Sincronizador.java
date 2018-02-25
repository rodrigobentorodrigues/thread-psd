package br.edu.ifpb.sd.concorrencia;

import java.util.concurrent.ArrayBlockingQueue;

/**
 *
 * @author rodrigobento
 */
public class Sincronizador {
    
    private ArrayBlockingQueue<Integer> lock;
    
    public Sincronizador() {
        lock = new ArrayBlockingQueue<>(1);
    }

    public void atender() throws InterruptedException {
        lock.take();
        
    }

    public void enfileirar() throws InterruptedException {
        lock.put(1);
    }
}
