import java.util.ArrayList;
import java.util.Scanner;

public class CaixaEletronico {
    
    Scanner entrada = new Scanner(System.in);

    ArrayList<ContaBancaria> contas = new ArrayList<>();

    public void mostrarMenu(){
        System.out.println("```");
        System.out.println("1. Criar Conta Com Saldo");
        System.out.println("2. Criar Conta Sem Saldo");
        System.out.println("3. Exibir Todas as Contas");
        System.out.println("4. Consultar Saldo");
        System.out.println("5. Depositar");
        System.out.println("6. Sacar");
        System.out.println("7. Transferencia");
        System.out.println("8. Sair");
        System.out.println("```");
    }

    public void criarContaComSaldo(){
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

    public void criarContaSemSaldo(){
        Cliente novoCliente = new Cliente();
        System.out.println("Digite o nome:");
        novoCliente.setNome(entrada.nextLine());
        System.out.println("Digite o CPF:");
        novoCliente.setCpf(entrada.nextLine());
        ContaBancaria novaConta = new ContaBancaria(novoCliente);

        contas.add(novaConta);
        System.out.println("Conta número " + novaConta.getId() + " criada com sucesso.");
    }

    public void retornaTodasContas(){
        for(ContaBancaria conta : contas){
            if(conta != null){
                System.out.println(conta.getId() + " " + conta.getCliente().getNome());
            }
        }
    }

    public void consultarSaldo(){
        System.out.println("Digite o número da conta que deseja consultar: ");
        int idConta = Integer.parseInt(entrada.nextLine());
        for(ContaBancaria conta : contas){
            if(conta != null && conta.getId() == idConta){
                System.out.println(conta.getSaldo() + " " + conta.getCliente().getNome());
            }
        }
    }

    public void depositar(){
        System.out.println("Digite o número da conta que deseja fazer depósito: ");
        int idConta = Integer.parseInt(entrada.nextLine());
        for(ContaBancaria conta : contas){
            if(conta != null && conta.getId() == idConta){
                System.out.println("Digite a quantidade: ");
                conta.depositar(Double.parseDouble(entrada.nextLine()));
            }
        }
    }

    public void sacar(){
        System.out.println("Digite o número da conta que deseja fazer depósito: ");
        int idConta = Integer.parseInt(entrada.nextLine());
        for(ContaBancaria conta : contas){
            if(conta != null && conta.getId() == idConta){
                System.out.println("Digite a quantidade: ");
                conta.sacar(Double.parseDouble(entrada.nextLine()));
            }
        }
    }

    public void transferir(){
        System.out.println("Digite o número da conta de origem: ");
        int idOrigem = Integer.parseInt(entrada.nextLine());
        System.out.println("Digite o número da conta de destino: ");
        int idDestino = Integer.parseInt(entrada.nextLine());
        ContaBancaria contaOrigem = null;
        ContaBancaria contaDestino = null;
        for(ContaBancaria conta : contas){
            if(conta != null && conta.getId() == idOrigem){
                contaOrigem = conta;
            }
            if(conta != null && conta.getId() == idDestino){
                contaDestino = conta;
            }
        }
        System.out.println("Digite o valor a ser transferido: ");
        double valorTransferencia = Double.parseDouble(entrada.nextLine());
        contaOrigem.transferencia(valorTransferencia, contaDestino);
        System.out.println("Transferência realizada com sucesso.");
    }

    public void executar(){
        int opcao;
    do{
        mostrarMenu();
        opcao = Integer.parseInt(entrada.nextLine());
        executarOpcao(opcao);

    }while(opcao != 8);
    }

    public void executarOpcao(int opcao){
        switch(opcao){
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
                consultarSaldo();
                break;
            case 5:
                depositar();
                break;
            case 6:
                sacar();
                break;
            case 7:
                transferir();
                break;
        }
    }
}
