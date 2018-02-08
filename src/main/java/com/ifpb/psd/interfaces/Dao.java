package com.ifpb.psd.interfaces;

import com.ifpb.psd.model.Teste;

/**
 *
 * @author Rodrigo Bento
 */
public interface Dao {
    
    void adicionar(Teste teste);
    void remover(Teste teste);
    void atualizar(Teste teste);
    
}
