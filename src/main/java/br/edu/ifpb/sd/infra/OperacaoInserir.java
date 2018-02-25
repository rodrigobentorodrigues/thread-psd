package br.edu.ifpb.sd.infra;

import br.edu.ifpb.sd.concorrencia.Sincronizador;
import java.sql.SQLException;

/**
 *
 * @author rodrigobento
 */
public class OperacaoInserir implements Runnable {

    private final int id;
    private final Operacao operacao;
    private final Sincronizador sinc;

    public OperacaoInserir(int id, Operacao operacao, Sincronizador se) {
        this.operacao = operacao;
        this.sinc = se;
        this.id = id;
    }

    public void run() {
        try {
            operacao.inserir(id, "Rodrigo " + id);
            sinc.enfileirar();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
