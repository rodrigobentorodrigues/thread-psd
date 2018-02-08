package com.ifpb.psd.infra;

import com.ifpb.psd.interfaces.Dao;
import com.ifpb.psd.model.Teste;

/**
 *
 * @author Rodrigo Bento
 */
public class ThreadAtualizar implements Runnable {
    
    private Teste teste;
    private Dao dao;
    
    public ThreadAtualizar (Teste t, Dao d){
        this.teste = t;
        this.dao = d;
    }

    @Override
    public void run() {
        update();
    }
    
    private void update(){
        dao.atualizar(teste);
    }
    
}
