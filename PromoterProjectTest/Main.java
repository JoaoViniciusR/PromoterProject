package PromoterProjectTest;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        AplicativoEventos aplicativo = new AplicativoEventos();

        int opcao;
        do {
            String menu = "\n=== Menu ===\n" +
                    "1. Cadastrar Evento\n" +
                    "2. Cadastrar Pessoa em Evento\n" +
                    "3. Exibir Participantes de um Evento\n" +
                    "4. Atualizar Idade de uma Pessoa\n" +
                    "5. Remover Pessoa de um Evento\n" +
                    "6. Sair\n" +
                    "Escolha uma opção:";
            
            try {
                opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));

                switch (opcao) {
                    case 1:
                        String nomeEvento = JOptionPane.showInputDialog("Digite o nome do evento:");
                        aplicativo.cadastrarEvento(nomeEvento);
                        break;
                    case 2:
                        String nomePessoa = JOptionPane.showInputDialog("Digite o nome da pessoa:");
                        int idadePessoa = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade da pessoa:"));
                        String nomeEventoCadastro = JOptionPane.showInputDialog("Digite o nome do evento:");
                        aplicativo.cadastrarPessoa(nomePessoa, idadePessoa, nomeEventoCadastro);
                        break;
                    case 3:
                        String nomeEventoExibir = JOptionPane.showInputDialog("Digite o nome do evento:");
                        aplicativo.exibirParticipantes(nomeEventoExibir);
                        break;
                    case 4:
                        String nomePessoaAtualizar = JOptionPane.showInputDialog("Digite o nome da pessoa:");
                        int novaIdade = Integer.parseInt(JOptionPane.showInputDialog("Digite a nova idade da pessoa:"));
                        String nomeEventoAtualizar = JOptionPane.showInputDialog("Digite o nome do evento:");
                        aplicativo.atualizarIdadePessoa(nomePessoaAtualizar, novaIdade, nomeEventoAtualizar);
                        break;
                    case 5:
                        String nomePessoaRemover = JOptionPane.showInputDialog("Digite o nome da pessoa:");
                        String nomeEventoRemover = JOptionPane.showInputDialog("Digite o nome do evento:");
                        aplicativo.removerPessoa(nomePessoaRemover, nomeEventoRemover);
                        break;
                    case 6:
                        JOptionPane.showMessageDialog(null, "Saindo do programa.");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, digite um número válido para a opção.");
                opcao = 0; // Garante que o loop continuará até receber uma entrada válida.
            }
        } while (opcao != 6);
    }
}
