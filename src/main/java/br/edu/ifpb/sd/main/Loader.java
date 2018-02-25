package br.edu.ifpb.sd.main;

import br.edu.ifpb.sd.concorrencia.Interceptador;
import br.edu.ifpb.sd.infra.Operacao;
import br.edu.ifpb.sd.infra.OperacaoAtualizar;
import br.edu.ifpb.sd.infra.OperacaoDeletar;
import br.edu.ifpb.sd.infra.OperacaoInserir;
import br.edu.ifpb.sd.concorrencia.Sincronizador;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author rodrigobento
 */
public class Loader {

    public static void main(String[] args) throws SQLException, InterruptedException {
        Operacao operacao = new Operacao();
        // Limpando os dados da tabela (caso possuir)
        operacao.limparTabela();
        // Objeto para auxiliar no termino do for, para que so 3 threads disputem a concorrencia
        Interceptador intercept = new Interceptador();
        // Objeto para sincronizar e infileirar as 3 threads para que sejam executadas uma apos a outra
        Sincronizador auxiliar = new Sincronizador();
        Sincronizador auxiliar2 = new Sincronizador();
        final ThreadGroup grupo = new ThreadGroup("my-threads");
        for (int i = 0; i < 1000; i++) {
            intercept.travar();
            int id = i;
            // Threads que executarão o que foi pedido
            Thread t0 = new Thread(grupo, 
                    new OperacaoInserir(id, operacao, auxiliar));
            Thread t1 = new Thread(grupo, 
                    new OperacaoAtualizar(id, operacao, auxiliar, auxiliar2));
            Thread t2 = new Thread(grupo, 
                    new OperacaoDeletar(id, operacao, auxiliar2, intercept));
            t0.start();
            t1.start();
            t2.start();
            // Thread que poderá pausar e continuar o trabalho das threads
            if (i < 1) {
                new Thread(new Runnable() {
                    public void run() {
                        int cont = 0;
                        Scanner leitor = new Scanner(System.in);
                        while (true) {
                            if (cont == 0) {
                                System.out.println("(1) - para parar\n(3) - para finalizar a aplicação");
                            } else {
                                System.out.println("(2) - para reiniciar\n(3) - para finalizar a aplicação");
                            }
                            System.out.print("Sua opção: ");
                            String resposta = leitor.next();
                            if (resposta.equals("1")) {
                                System.out.println("\nPAUSADO !\n");
                                grupo.suspend();
                                cont++;
                            } else if (resposta.equals("2")) {
                                System.out.println("\nREINICIADO !\n");
                                grupo.resume();
                                cont = 0;
                            } else {   
                                System.exit(0);
                            }
                        }
                    }
                }).start();
            }
        }
    }
}
