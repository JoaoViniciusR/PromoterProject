package PromoterProjectTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AplicativoEventos {
    private List<Evento> eventos;

    public AplicativoEventos() {
        this.eventos = new ArrayList<>();
    }

    // Operação de criação (Create)
    public void cadastrarEvento(String nomeEvento) {
        Evento evento = new Evento(nomeEvento);
        eventos.add(evento);
        System.out.println("Evento cadastrado com sucesso.");
    }

    public void cadastrarPessoa(String nome, int idade, String nomeEvento) {
        Evento evento = encontrarEvento(nomeEvento);
        if (evento != null) {
            Pessoa pessoa = new Pessoa(nome, idade);
            evento.adicionarParticipante(pessoa);
            System.out.println("Pessoa cadastrada com sucesso no evento " + nomeEvento + ".");
        } else {
            System.out.println("Evento não encontrado.");
        }
    }

    // Operação de leitura (Read)
    public void exibirParticipantes(String nomeEvento) {
        Evento evento = encontrarEvento(nomeEvento);
        if (evento != null) {
            System.out.println("Participantes do evento " + nomeEvento + ":");
            if (evento.getParticipantes() != null) {
                for (Pessoa pessoa : evento.getParticipantes()) {
                    System.out.println("Nome: " + pessoa.getNome() + ", Idade: " + pessoa.getIdade());
                }
            } else {
                System.out.println("Lista de participantes não inicializada para o evento " + nomeEvento + ".");
            }
        } else {
            System.out.println("Evento não encontrado.");
        }
    }

    // Operação de atualização (Update)
    public void atualizarIdadePessoa(String nome, int novaIdade, String nomeEvento) {
        Evento evento = encontrarEvento(nomeEvento);
        if (evento != null && evento.getParticipantes() != null) {
            for (Pessoa pessoa : evento.getParticipantes()) {
                if (pessoa.getNome().equals(nome)) {
                    pessoa.setIdade(novaIdade);
                    System.out.println("Idade atualizada com sucesso para a pessoa " + nome + ".");
                    return;
                }
            }
            System.out.println("Pessoa não encontrada no evento " + nomeEvento + ".");
        } else {
            System.out.println("Evento não encontrado ou lista de participantes não inicializada.");
        }
    }

    // Operação de exclusão (Delete)
    public void removerPessoa(String nome, String nomeEvento) {
        Evento evento = encontrarEvento(nomeEvento);
        if (evento != null && evento.getParticipantes() != null) {
            Iterator<Pessoa> iterator = evento.getParticipantes().iterator();
            while (iterator.hasNext()) {
                Pessoa pessoa = iterator.next();
                if (pessoa.getNome().equals(nome)) {
                    iterator.remove();
                    System.out.println("Pessoa removida com sucesso do evento " + nomeEvento + ".");
                    return;
                }
            }
            System.out.println("Pessoa não encontrada no evento " + nomeEvento + ".");
        } else {
            System.out.println("Evento não encontrado ou lista de participantes não inicializada.");
        }
    }

    private Evento encontrarEvento(String nomeEvento) {
        for (Evento evento : eventos) {
            if (evento.getNome().equals(nomeEvento)) {
                return evento;
            }
        }
        return null;
    }

}
