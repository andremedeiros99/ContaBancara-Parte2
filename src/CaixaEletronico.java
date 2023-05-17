import java.util.ArrayList;
import java.util.Scanner;

public class CaixaEletronico {

    Scanner entrada = new Scanner(System.in);

    ArrayList<ContaBancaria> contas = new ArrayList<>();

    public void mostrarMenu() {
        System.out.println("```");
        System.out.println("1. Criar Conta Com Saldo");
        System.out.println("2. Criar Conta Sem Saldo");
        System.out.println("3. Exibir Todas as Contas");
        System.out.println("4. Exibir Contas Por Nome");
        System.out.println("5. Consultar Saldo");
        System.out.println("6. Depositar");
        System.out.println("7. Sacar");
        System.out.println("8. Transferencia");
        System.out.println("9. Remover uma Conta");
        System.out.println("10. Sair");
        System.out.println("```");
    }

    public void criarContaComSaldo() {
        Cliente novoCliente = new Cliente();
        System.out.println("Digite o nome:");
        novoCliente.setNome(entrada.nextLine());
        System.out.println("Digite o CPF:");
        novoCliente.setCpf(entrada.nextLine());
        ContaBancaria novaConta = new ContaBancaria(novoCliente);
        System.out.println("Digite o saldo inicial:");
        novaConta.setSaldo(Double.parseDouble(entrada.nextLine()));

        contas.add(novaConta);
        System.out.println("Conta número " + novaConta.getId() + " criada com sucesso.");
    }

    public void criarContaSemSaldo() {
        Cliente novoCliente = new Cliente();
        System.out.println("Digite o nome:");
        novoCliente.setNome(entrada.nextLine());
        System.out.println("Digite o CPF:");
        novoCliente.setCpf(entrada.nextLine());
        ContaBancaria novaConta = new ContaBancaria(novoCliente);

        contas.add(novaConta);
        System.out.println("Conta número " + novaConta.getId() + " criada com sucesso.");
    }

    public void retornaTodasContas() {
        for (ContaBancaria conta : contas) {
            if (conta != null) {
                System.out.println(conta.getId() + " " + conta.getCliente().getNome());
            }
        }
    }

    public void filtrarPorNome() {
        System.out.println("Digite o nome da conta:");
        String nomeConta = entrada.nextLine();
        boolean achou = false;

        for(ContaBancaria conta : contas){
            if (conta.getCliente().getNome().toLowerCase().contains(nomeConta)) {
                System.out.println(conta.getId() + " " + conta.getCliente().getNome());
                achou = true;
            } //else {
                //isso não funciona!!! ele sempre imprime Conta nao encontrada, vou criar um bool para fazer a verificação.
                //System.out.println("Conta não encontrada!");
            //}
        }
        if(!achou){
            System.out.println("Conta não encontrada!");
        }

    }

    public void consultarSaldo() {
        System.out.println("Digite o número da conta que deseja consultar: ");
        int idConta = Integer.parseInt(entrada.nextLine());
        for (ContaBancaria conta : contas) {
            if (conta != null && conta.getId() == idConta) {
                System.out.println(conta.getSaldo() + " " + conta.getCliente().getNome());
            }
        }
    }

    public void depositar() {
        System.out.println("Digite o número da conta que deseja fazer depósito: ");
        int idConta = Integer.parseInt(entrada.nextLine());
        for (ContaBancaria conta : contas) {
            if (conta != null && conta.getId() == idConta) {
                System.out.println("Digite a quantidade: ");
                conta.depositar(Double.parseDouble(entrada.nextLine()));
            }
        }
    }

    public void sacar() {
        System.out.println("Digite o número da conta que deseja fazer saque: ");
        int idConta = Integer.parseInt(entrada.nextLine());
        for (ContaBancaria conta : contas) {
            if (conta != null && conta.getId() == idConta) {
                System.out.println("Digite a quantidade: ");
                conta.sacar(Double.parseDouble(entrada.nextLine()));
            }
        }
    }

    public void transferir() {
        System.out.println("Digite o número da conta de origem: ");
        int idOrigem = Integer.parseInt(entrada.nextLine());
        System.out.println("Digite o número da conta de destino: ");
        int idDestino = Integer.parseInt(entrada.nextLine());
        ContaBancaria contaOrigem = null;
        ContaBancaria contaDestino = null;
        for (ContaBancaria conta : contas) {
            if (conta != null && conta.getId() == idOrigem) {
                contaOrigem = conta;
            }
            if (conta != null && conta.getId() == idDestino) {
                contaDestino = conta;
            }
        }
        System.out.println("Digite o valor a ser transferido: ");
        double valorTransferencia = Double.parseDouble(entrada.nextLine());
        contaOrigem.transferencia(valorTransferencia, contaDestino);
        System.out.println("Transferência realizada com sucesso.");
    }

    public void removerConta() {
        System.out.println("Digite o número da conta que deseja remover: ");
        int idConta = Integer.parseInt(entrada.nextLine());
        for (ContaBancaria conta : contas) {
            if (conta != null && conta.getId() == idConta && conta.getSaldo() == 0) {
                contas.remove(conta);
                System.out.println("Conta número: " + idConta + " removida com sucesso!");
                break;
            } else if (conta.getSaldo() <= 0) {
                System.out.println(
                        "A conta não pôde ser removida pois seu saldo de " + conta.getSaldo() + " está negativo");
            } else if (conta.getSaldo() >= 0) {
                System.out.println("A conta não pôde ser removida pois ainda possui " + conta.getSaldo()
                        + " de saldo ou não existe");
            }
        }

    }

    public void executar() {
        int opcao;
        do {
            mostrarMenu();
            opcao = Integer.parseInt(entrada.nextLine());
            executarOpcao(opcao);

        } while (opcao != 10);
    }

    public void executarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                criarContaComSaldo();
                break;
            case 2:
                criarContaSemSaldo();
                break;
            case 3:
                retornaTodasContas();
                break;
            case 4:
                filtrarPorNome();
                break;
            case 5:
                consultarSaldo();
                break;
            case 6:
                depositar();
                break;
            case 7:
                sacar();
                break;
            case 8:
                transferir();
                break;
            case 9:
                removerConta();
                break;
        }
    }
}
