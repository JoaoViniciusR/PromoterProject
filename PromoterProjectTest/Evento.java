package PromoterProjectTest;

import java.util.ArrayList;
import java.util.List;

public class Evento {
    private String nome;
    private List<Pessoa> participantes;

    public Evento(String nome) {
        this.nome = nome;
        this.participantes = new ArrayList<>();
    }

    
    public void adicionarParticipante(Pessoa pessoa) {
        if (this.participantes != null) {
            this.participantes.add(pessoa);
        } else {
            System.out.println("Lista de participantes não inicializada para o evento " + this.nome + ".");
        }
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Pessoa> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Pessoa> participantes) {
        this.participantes = participantes;
    }

}
