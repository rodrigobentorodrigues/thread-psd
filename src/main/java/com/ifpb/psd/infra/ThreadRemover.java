package com.ifpb.psd.infra;

import com.ifpb.psd.interfaces.Dao;
import com.ifpb.psd.model.Teste;

/**
 *
 * @author Rodrigo Bento
 */
public class ThreadRemover implements Runnable {

    private Teste teste;
    private Dao dao;
    
    public ThreadRemover (Teste t, Dao d){
        this.teste = t;
        this.dao = d;
    }
    
    @Override
    public void run() {
        remove();
    }
    
    private void remove(){
        dao.remover(teste);
    }
    
}
