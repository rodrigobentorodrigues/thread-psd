package com.ifpb.psd.infra;

import com.ifpb.psd.interfaces.Dao;
import com.ifpb.psd.model.Teste;

/**
 *
 * @author ifpb
 */
public class ThreadAdicionar implements Runnable {
    
    private Teste teste;
    private Dao dao;
    
    public ThreadAdicionar(Teste t, Dao d){
        this.teste = t;
        this.dao = d;
    }

    @Override
    public void run() {
        adicionar();
    }
    
    private void adicionar(){
        dao.adicionar(teste);
    }
    
}
