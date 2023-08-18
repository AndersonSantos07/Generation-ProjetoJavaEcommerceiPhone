import controller.PedidoController;
import model.Pedido;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        PedidoController pedido = new PedidoController();

        Scanner leia = new Scanner(System.in);


        int opcao = 0;
        boolean loop = true;

        while (loop) {


            System.out.println("""
                    **********************************************************************************************
                                        
                    ██╗██████╗░██╗░░██╗░█████╗░███╗░░██╗███████╗        ░██████╗████████╗░█████╗░██████╗░███████╗
                    ██║██╔══██╗██║░░██║██╔══██╗████╗░██║██╔════╝        ██╔════╝╚══██╔══╝██╔══██╗██╔══██╗██╔════╝
                    ██║██████╔╝███████║██║░░██║██╔██╗██║█████╗░░        ╚█████╗░░░░██║░░░██║░░██║██████╔╝█████╗░░
                    ██║██╔═══╝░██╔══██║██║░░██║██║╚████║██╔══╝░░        ░╚═══██╗░░░██║░░░██║░░██║██╔══██╗██╔══╝░░
                    ██║██║░░░░░██║░░██║╚█████╔╝██║░╚███║███████╗        ██████╔╝░░░██║░░░╚█████╔╝██║░░██║███████╗
                    ╚═╝╚═╝░░░░░╚═╝░░╚═╝░╚════╝░╚═╝░░╚══╝╚══════╝        ╚═════╝░░░░╚═╝░░░░╚════╝░╚═╝░░╚═╝╚══════╝
                                        
                    **********************************************************************************************
                                        
                    (1) Criar Pedido;
                    (2) Atualizar Pedido;
                    (3) Deletar Pedido;
                    (4) Pagamento;
                    (5) Mostrar Pedido Específico;
                    (6) Listar todos os pedidos;
                    (7) Relatórios;
                    (9) Sair do Sistema;
                                        
                    ************************************************************************************************
                    Escolha uma das opções: 
                    """);

            try {
                opcao = leia.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Digite valores inteiros!");
                leia.nextLine();
                opcao = 0;
            }


            if (opcao == 9) {
                System.out.println("\nObrigado por utilizar nosso sistema! ");
                loop = false;
                leia.close();
                System.exit(0);
            }

            String nomeCliente;
            int opcaoIphone=0;
            String nomeIphone = "Não escolhido";
            float valor = 0;


            switch (opcao) {
                case 1:

                    System.out.println("Fazendo pedido... ");
                    System.out.println("Digite seu nome: ");
                    leia.skip("\\R?");
                    nomeCliente = leia.nextLine();



                        System.out.println("""
                                                                
                                *************************************************************
                                                                
                                  APARELHOS                  VALORES
                                (1) IPhone 8               R$ 1.100,00
                                (2) IPhone XR              R$ 1.800,00
                                (3) IPhone 11              R$ 2.300,00
                                (4) IPhone 12              R$ 3.000,00
                                (5) IPhone 13              R$ 3.600,00
                                (6) IPhone 14              R$ 4.600,00
                                                                
                                **************************************************************  
                                           
                                Escolha uma das opções: 
                                """);
                        boolean opcaoIphoneLoop = true;

                        while(opcaoIphoneLoop){
                            try {
                                opcaoIphone = leia.nextInt();
                                if(opcaoIphone > 0 && opcaoIphone< 7){
                                    opcaoIphoneLoop = false;
                                }else{
                                    System.out.println("""                                
                                *************************************************************
                                                                
                                  APARELHOS                  VALORES
                                (1) IPhone 8               R$ 1.100,00
                                (2) IPhone XR              R$ 1.800,00
                                (3) IPhone 11              R$ 2.300,00
                                (4) IPhone 12              R$ 3.000,00
                                (5) IPhone 13              R$ 3.600,00
                                (6) IPhone 14              R$ 4.600,00
                                                                
                                **************************************************************  
                                """);
                                    System.out.println("Digite um valor da tabela (1 a 6): ");

                                }
                            } catch (InputMismatchException e) {
                                System.out.println("""                                
                                *************************************************************
                                                                
                                  APARELHOS                  VALORES
                                (1) IPhone 8               R$ 1.100,00
                                (2) IPhone XR              R$ 1.800,00
                                (3) IPhone 11              R$ 2.300,00
                                (4) IPhone 12              R$ 3.000,00
                                (5) IPhone 13              R$ 3.600,00
                                (6) IPhone 14              R$ 4.600,00
                                                                
                                **************************************************************  
                                """);
                                System.out.println("\nDigite valores inteiros de (1 a 6): ");
                                leia.nextLine();
                                opcaoIphone = 0;
                            }
                        }



                        if (opcaoIphone == 1) {

                            nomeIphone = "IPhone 8";
                            valor = 1100f;

                        } else if (opcaoIphone == 2) {

                            nomeIphone = "IPhone XR";
                            valor = 1800f;

                        } else if (opcaoIphone == 3) {

                            nomeIphone = "IPhone 11";
                            valor = 2200f;

                        } else if (opcaoIphone == 4) {

                            nomeIphone = "IPhone 12";
                            valor = 3000f;

                        } else if (opcaoIphone == 5) {

                            nomeIphone = "IPhone 13";
                            valor = 3600f;

                        } else if (opcaoIphone == 6) {

                            nomeIphone = "IPhone 14";
                            valor = 4600f;

                        } else {
                            System.out.println("Opção inválida!");
                        }

                    System.out.println("\nProduto escolhido: " + nomeIphone);
                    System.out.println("\nValor do IPhone: " + PedidoController.formatarMoeda(valor));

                    String adicional;
                    String nomeAcessorio = "nada";
                    String acessoriosEscolhidos = "";
                    float valorAcessorio = 0;
                    float valorTotalAcessorio = 0;

                    System.out.println("Deseja adicionar acessórios para o IPhone? (S/N)");
                    adicional = leia.next();

                    if ("S".equalsIgnoreCase(adicional)) {
                        int opcaoAcessorio = 0;

                        String opcaoItens = "S";

                        do {

                            System.out.println("""
                                    *************************************************************
                                          
                                             ITENS                       VALORES      
                                    (1) Fone de Ouvido com fio			R$ 180,00
                                    (2) Fone de Ouvido sem fio			R$ 300,00
                                    (3) Carregador USB-C                R$ 219,00
                                    (4) Cabo de USB-C                   R$ 219,00
                                    (5) Capinha de Silicone             R$ 60,00
                                    (6) Película de Vidro				R$ 30,00
                                                   
                                    *************************************************************
                                             
                                    Escolha uma das opções:                                         
                                    """);

                            boolean opcaoAcessorioLoop = true;
                            while(opcaoAcessorioLoop){
                                try {
                                    opcaoAcessorio = leia.nextInt();
                                    if(opcaoAcessorio > 0 && opcaoAcessorio< 7){
                                       opcaoAcessorioLoop = false;
                                    }else{

                                        System.out.println("Digite um valor da tabela (1 a 6): ");
                                        System.out.println("""
                                    ***************************************************************   
                                             ITENS                       VALORES      
                                    (1) Fone de Ouvido com fio			R$ 180,00
                                    (2) Fone de Ouvido sem fio			R$ 300,00
                                    (3) Carregador USB-C                R$ 219,00
                                    (4) Cabo de USB-C                   R$ 219,00
                                    (5) Capinha de Silicone             R$ 60,00
                                    (6) Película de Vidro				R$ 30,00
                                    ****************************************************************                                       
                                    """);

                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("""
                                    ***************************************************************   
                                             ITENS                       VALORES      
                                    (1) Fone de Ouvido com fio			R$ 180,00
                                    (2) Fone de Ouvido sem fio			R$ 300,00
                                    (3) Carregador USB-C                R$ 219,00
                                    (4) Cabo de USB-C                   R$ 219,00
                                    (5) Capinha de Silicone             R$ 60,00
                                    (6) Película de Vidro				R$ 30,00
                                    ****************************************************************                                       
                                    """);
                                    System.out.println("\nDigite valores inteiros de (1 a 6): ");
                                    leia.nextLine();
                                    opcaoAcessorio = 0;
                                }
                            }

                            switch (opcaoAcessorio) {

                                case 1 -> {
                                    nomeAcessorio = "Fone de Ouvido com fio";
                                    valorAcessorio = 180f;
                                    acessoriosEscolhidos += nomeAcessorio + ", ";
                                    valorTotalAcessorio += valorAcessorio;
                                }
                                case 2 -> {
                                    nomeAcessorio = "Fone de Ouvido sem fio";
                                    valorAcessorio = 300f;
                                    acessoriosEscolhidos += nomeAcessorio + ", ";
                                    valorTotalAcessorio += valorAcessorio;

                                }
                                case 3 -> {
                                    nomeAcessorio = "Carregador USB-C";
                                    valorAcessorio = 219f;
                                    acessoriosEscolhidos += nomeAcessorio + ", ";
                                    valorTotalAcessorio += valorAcessorio;

                                }
                                case 4 -> {
                                    nomeAcessorio = "Cabo USB-C";
                                    valorAcessorio = 219f;
                                    acessoriosEscolhidos += nomeAcessorio + ", ";
                                    valorTotalAcessorio += valorAcessorio;

                                }
                                case 5 -> {
                                    nomeAcessorio = "Capinha de Silicone";
                                    valorAcessorio = 60f;
                                    acessoriosEscolhidos += nomeAcessorio + ", ";
                                    valorTotalAcessorio += valorAcessorio;
                                }
                                case 6 -> {
                                    nomeAcessorio = "Película";
                                    valorAcessorio = 30f;
                                    acessoriosEscolhidos += nomeAcessorio + ", ";
                                    valorTotalAcessorio += valorAcessorio;
                                }

                            }
                            System.out.println("Deseja escolher mais acessórios? (S/N)");
                            opcaoItens = leia.next();

                        } while (opcaoItens.equalsIgnoreCase("S"));


                        pedido.cadastrar(new Pedido(pedido.gerarNumero(), nomeCliente, nomeIphone, valor, acessoriosEscolhidos, valorTotalAcessorio));


                    } else {

                        pedido.cadastrar((new Pedido(pedido.gerarNumero(), nomeCliente, nomeIphone, valor)));

                    }
                    keyPress();
                    break;
                case 2:
                    System.out.println("Atualize seu pedido: ");
                    int numPedido;
                    System.out.println("Digite o número do pedido que deseja atualizar: ");
                    try{
                        numPedido = leia.nextInt();

                    }catch(InputMismatchException e){
                        System.out.println("Digite valores inteiros");
                        leia.nextLine();
                        numPedido = 0;
                    }


                    if (pedido.buscarNaCollection(numPedido) != null) {
                        System.out.println("Digite seu nome: ");
                        leia.skip("\\R?");
                        nomeCliente = leia.nextLine();


                        System.out.println("""
                                                                
                                *************************************************************
                                                                
                                  APARELHOS                  VALORES
                                (1) IPhone 8               R$ 1.100,00
                                (2) IPhone XR              R$ 1.800,00
                                (3) IPhone 11              R$ 2.300,00
                                (4) IPhone 12              R$ 3.000,00
                                (5) IPhone 13              R$ 3.600,00
                                (6) IPhone 14              R$ 4.600,00
                                                                
                                **************************************************************  
                                           
                                Escolha uma das opções: 
                                """);
                        boolean opcaoIphoneAtLoop = true;

                        while (opcaoIphoneAtLoop) {
                            try {
                                opcaoIphone = leia.nextInt();
                                if (opcaoIphone > 0 && opcaoIphone < 7) {
                                    opcaoIphoneAtLoop = false;
                                } else {
                                    System.out.println("""                                
                                            *************************************************************
                                                                            
                                              APARELHOS                  VALORES
                                            (1) IPhone 8               R$ 1.100,00
                                            (2) IPhone XR              R$ 1.800,00
                                            (3) IPhone 11              R$ 2.300,00
                                            (4) IPhone 12              R$ 3.000,00
                                            (5) IPhone 13              R$ 3.600,00
                                            (6) IPhone 14              R$ 4.600,00
                                                                            
                                            **************************************************************  
                                            """);
                                    System.out.println("Digite um valor da tabela (1 a 6): ");

                                }
                            } catch (InputMismatchException e) {
                                System.out.println("""                                
                                        *************************************************************
                                                                        
                                          APARELHOS                  VALORES
                                        (1) IPhone 8               R$ 1.100,00
                                        (2) IPhone XR              R$ 1.800,00
                                        (3) IPhone 11              R$ 2.300,00
                                        (4) IPhone 12              R$ 3.000,00
                                        (5) IPhone 13              R$ 3.600,00
                                        (6) IPhone 14              R$ 4.600,00
                                                                        
                                        **************************************************************  
                                        """);
                                System.out.println("\nDigite valores inteiros de (1 a 6): ");
                                leia.nextLine();
                                opcaoIphone = 0;
                            }
                        }


                        if (opcaoIphone == 1) {

                            nomeIphone = "IPhone 8";
                            valor = 1100f;

                        } else if (opcaoIphone == 2) {

                            nomeIphone = "IPhone XR";
                            valor = 1800f;

                        } else if (opcaoIphone == 3) {

                            nomeIphone = "IPhone 11";
                            valor = 2200f;

                        } else if (opcaoIphone == 4) {

                            nomeIphone = "IPhone 12";
                            valor = 3000f;

                        } else if (opcaoIphone == 5) {

                            nomeIphone = "IPhone 13";
                            valor = 3600f;

                        } else if (opcaoIphone == 6) {

                            nomeIphone = "IPhone 14";
                            valor = 4600f;

                        } else {
                            System.out.println("Opção inválida!");
                        }

                        System.out.println("\nProduto escolhido: " + nomeIphone);
                        System.out.println("\nValor do IPhone: " + PedidoController.formatarMoeda(valor));

                         adicional = "";
                         nomeAcessorio = "nada";
                         acessoriosEscolhidos = "";
                         valorAcessorio = 0f;
                         valorTotalAcessorio = 0f;

                        System.out.println("Deseja adicionar acessórios para o IPhone? (S/N)");
                        adicional = leia.next();

                        if ("S".equalsIgnoreCase(adicional)) {
                            int opcaoAcessorio = 0;

                            String opcaoItens = "S";

                            do {

                                System.out.println("""
                                        *************************************************************
                                              
                                                 ITENS                       VALORES      
                                        (1) Fone de Ouvido com fio			R$ 180,00
                                        (2) Fone de Ouvido sem fio			R$ 300,00
                                        (3) Carregador USB-C                R$ 219,00
                                        (4) Cabo de USB-C                   R$ 219,00
                                        (5) Capinha de Silicone             R$ 60,00
                                        (6) Película de Vidro				R$ 30,00
                                                       
                                        *************************************************************
                                                 
                                        Escolha uma das opções:                                         
                                        """);

                                boolean opcaoAcessorioLoop = true;
                                while (opcaoAcessorioLoop) {
                                    try {
                                        opcaoAcessorio = leia.nextInt();
                                        if (opcaoAcessorio > 0 && opcaoAcessorio < 7) {
                                            opcaoAcessorioLoop = false;
                                        } else {

                                            System.out.println("Digite um valor da tabela (1 a 6): ");
                                            System.out.println("""
                                                    ***************************************************************   
                                                             ITENS                       VALORES      
                                                    (1) Fone de Ouvido com fio			R$ 180,00
                                                    (2) Fone de Ouvido sem fio			R$ 300,00
                                                    (3) Carregador USB-C                R$ 219,00
                                                    (4) Cabo de USB-C                   R$ 219,00
                                                    (5) Capinha de Silicone             R$ 60,00
                                                    (6) Película de Vidro				R$ 30,00
                                                    ****************************************************************                                       
                                                    """);

                                        }
                                    } catch (InputMismatchException e) {
                                        System.out.println("""
                                                ***************************************************************   
                                                         ITENS                       VALORES      
                                                (1) Fone de Ouvido com fio			R$ 180,00
                                                (2) Fone de Ouvido sem fio			R$ 300,00
                                                (3) Carregador USB-C                R$ 219,00
                                                (4) Cabo de USB-C                   R$ 219,00
                                                (5) Capinha de Silicone             R$ 60,00
                                                (6) Película de Vidro				R$ 30,00
                                                ****************************************************************                                       
                                                """);
                                        System.out.println("\nDigite valores inteiros de (1 a 6): ");
                                        leia.nextLine();
                                        opcaoAcessorio = 0;
                                    }
                                }

                                switch (opcaoAcessorio) {

                                    case 1 -> {
                                        nomeAcessorio = "Fone de Ouvido com fio";
                                        valorAcessorio = 180f;
                                        acessoriosEscolhidos += nomeAcessorio + ", ";
                                        valorTotalAcessorio += valorAcessorio;
                                    }
                                    case 2 -> {
                                        nomeAcessorio = "Fone de Ouvido sem fio";
                                        valorAcessorio = 300f;
                                        acessoriosEscolhidos += nomeAcessorio + ", ";
                                        valorTotalAcessorio += valorAcessorio;

                                    }
                                    case 3 -> {
                                        nomeAcessorio = "Carregador USB-C";
                                        valorAcessorio = 219f;
                                        acessoriosEscolhidos += nomeAcessorio + ", ";
                                        valorTotalAcessorio += valorAcessorio;

                                    }
                                    case 4 -> {
                                        nomeAcessorio = "Cabo USB-C";
                                        valorAcessorio = 219f;
                                        acessoriosEscolhidos += nomeAcessorio + ", ";
                                        valorTotalAcessorio += valorAcessorio;

                                    }
                                    case 5 -> {
                                        nomeAcessorio = "Capinha de Silicone";
                                        valorAcessorio = 60f;
                                        acessoriosEscolhidos += nomeAcessorio + ", ";
                                        valorTotalAcessorio += valorAcessorio;
                                    }
                                    case 6 -> {
                                        nomeAcessorio = "Película";
                                        valorAcessorio = 30f;
                                        acessoriosEscolhidos += nomeAcessorio + ", ";
                                        valorTotalAcessorio += valorAcessorio;
                                    }

                                }
                                System.out.println("Deseja escolher mais acessórios? (S/N)");
                                opcaoItens = leia.next();

                            } while (opcaoItens.equalsIgnoreCase("S"));


                            pedido.atualizar(new Pedido(numPedido, nomeCliente, nomeIphone, valor, acessoriosEscolhidos, valorTotalAcessorio));


                        } else {

                            pedido.atualizar((new Pedido(numPedido, nomeCliente, nomeIphone, valor)));

                        }
                    }
                    keyPress();
                    break;
                case 3:
                    System.out.println("Escolha o pedido que deseja Deletar.");
                    int numero;
                    System.out.println("Digite o número do Pedido que deseja Deletar: ");
                    try{
                        numero = leia.nextInt();
                    }catch(InputMismatchException e){
                        System.out.println("Digite valores inteiros");
                        leia.nextLine();
                        numero = 0;
                    }

                    pedido.deletar(numero);

                    keyPress();
                    break;
                case 4:
                    System.out.println("Escolhendo a Forma de Pagamento! ");
                    System.out.println("Digite o número do Pedido que deseja efetuar o Pagamento: ");
                    int numeroPedidoPag = 0;
                    boolean loopNumeroPedido = true;
                    while(loopNumeroPedido){
                        try{

                            numeroPedidoPag = leia.nextInt();

                            if(numeroPedidoPag <= 0){
                                System.out.println("Digite o número do pedido correto: ");
                            }else{
                                loopNumeroPedido = false;
                            }

                        }catch(InputMismatchException e){
                            System.out.println("Digite valores inteiros");
                            leia.nextLine();
                            numeroPedidoPag = 0;
                        }

                    }

                    if(pedido.buscarNaCollection(numeroPedidoPag).isPago() != true ){
                        int opcaoPagamento;

                        System.out.println("""
                            ******************************************************************************
                                                        
                            (1) Pix;
                            (2) Débito;
                            (3) Dinheiro;
                            (4) Cartão de Crédito;
                                                        
                            ******************************************************************************
                            Escolha uma das opções de Pagamento:   
                            """);

                        try{
                            opcaoPagamento = leia.nextInt();
                        }catch(InputMismatchException e){
                            System.out.println("Digite valores inteiros");
                            leia.nextLine();
                            opcaoPagamento = 0;
                        }

                        pedido.metodoDePagamento(numeroPedidoPag);
                    }else{
                        System.out.println("Pedido já está pago! ");
                    }
                    keyPress();
                    break;
                case 5:
                    System.out.println("Mostrando pedido especifíco...");
                    int numeroPedido;
                    System.out.println("Digite o número do pedido que deseja encontrar: ");
                    try{
                        numeroPedido = leia.nextInt();
                    }catch(InputMismatchException e){
                        System.out.println("Digite valores inteiros");
                        leia.nextLine();
                        numeroPedido = 0;
                    }

                    pedido.procurarPorNumero(numeroPedido);

                    keyPress();
                    break;
                case 6:
                    System.out.println("Listando todos os pedidos...");
                    pedido.listarTodas();

                    keyPress();
                    break;
                case 7:
                    System.out.println("Relatórios");
                    System.out.println("""
                            ********************************************************************************
                                                        
                            (1) Relatório de Pedidos Pagos;
                            (2) Relatórios de Pedidos Não Pagos;
                            (3) Relatório de vendas do dia;
                                                        
                            ********************************************************************************
                            Escolha uma das opções dos Relatórios:
                            """);
                    int opcaoRelatorio = 0;
                    try{
                        opcaoRelatorio = leia.nextInt();
                        if(opcaoRelatorio < 0 || opcaoRelatorio > 3){
                            System.out.println("Digite um valor entre 1 e 3");
                        }
                    }catch(InputMismatchException e){
                        System.out.println("Digite um valor inteiro");
                        leia.nextLine();
                        opcaoRelatorio = 0;
                    }


                    switch (opcaoRelatorio) {
                        case 1 -> {
                            System.out.println("\t\t\tRelatório Pedidos Pagos");
                            pedido.listarPedidosPagos();

                        }
                        case 2 -> {
                            System.out.println("\t\t\tRelatório Pedidos não Pagos");
                            pedido.listarPedidosNaoPagos();

                        }
                        case 3 -> {
                            System.out.println("\t\t\tRelatório de Vendas do Dia");
                            pedido.relatorioVendas();

                        }
                        default -> {
                            System.out.println("Opção Desconhecida!");
                        }


                    }


                    keyPress();
                    break;
                default:
                    System.out.println("Opção desconhecida! ");

                    keyPress();
                    break;

            }

        }

    }

    public static void keyPress() {
        try {
            System.out.println("\n\nPressione Enter para Continuar...");
            System.in.read();
        } catch (IOException e) {
            System.out.println("Você pressionou uma tecla diferente de enter!");
        }
    }
}
