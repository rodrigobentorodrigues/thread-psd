package br.edu.ifpb.sd.infra;

import br.edu.ifpb.sd.concorrencia.Interceptador;
import br.edu.ifpb.sd.concorrencia.Sincronizador;
import java.sql.SQLException;

/**
 *
 * @author rodrigobento
 */
public class OperacaoDeletar implements Runnable {

    private final int id;
    private final Operacao op;
    private final Sincronizador sinc;
    private final Interceptador intercept;

    public OperacaoDeletar(int id, Operacao operacao, Sincronizador se, 
            Interceptador intcp) {
        this.op = operacao;
        this.sinc = se;
        this.intercept = intcp;
        this.id = id;
    }

    public void run() {
        try {
            sinc.atender();
            op.excluir(id);
            intercept.destravar();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
