package com.ifpb.psd.loader;

import com.ifpb.psd.infra.TesteDao;
import com.ifpb.psd.infra.ThreadAdicionar;
import com.ifpb.psd.model.Teste;

/**
 *
 * @author Rodrigo Bento
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
//        Utilizar uma fila de concorrencia (ConcurrentLinkedQueue)
        Thread t1 = new Thread(new ThreadAdicionar(new Teste("Rodrigo"), new TesteDao()));
        Thread t2 = new Thread();
        Thread t3 = new Thread();
    }

}
