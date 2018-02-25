package br.edu.ifpb.sd.infra;

import br.edu.ifpb.sd.concorrencia.Sincronizador;
import java.sql.SQLException;

/**
 *
 * @author rodrigobento
 */
public class OperacaoAtualizar implements Runnable {

    private final int id;
    private final Operacao operacao;
    private final Sincronizador sinc1;
    private final Sincronizador sinc2;

    public OperacaoAtualizar(int id, Operacao op, Sincronizador s1, Sincronizador s2) {
        this.operacao = op;
        this.sinc1 = s1;
        this.sinc2 = s2;
        this.id = id;
    }

    public void run() {
        try {
            sinc1.atender();
            operacao.atualizar(id);
            sinc2.enfileirar();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
