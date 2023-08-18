package controller;

import model.Pedido;
import repository.PedidoRepository;

import java.text.NumberFormat;
import java.util.ArrayList;

public class PedidoController implements PedidoRepository {
    ArrayList<Pedido> listaPedidos = new ArrayList<Pedido>();
    int numero = 0;


    @Override
    public void procurarPorNumero(int numero) {
        var pedido = buscarNaCollection(numero);
        if (pedido == null) {
            System.out.println("Pedido não encontrado! ");
        } else {
            pedido.visualizar();
        }


    }

    @Override
    public void listarTodas() {
        if (listaPedidos.size() != 0) {
            for (var conta : listaPedidos) {
                conta.visualizar();
            }
        } else {
            System.out.println("Não há pedidos criados! ");
        }
    }

    @Override
    public void cadastrar(Pedido pedido) {
        listaPedidos.add(pedido);
        pedido.setValorTotal(totalPedido(pedido));
        pedido.setValorTotalPedido(totalPedido(pedido));
        System.out.println("Pedido número: " + pedido.getNumero() + " Criado com sucesso!");
    }

    @Override
    public void atualizar(Pedido pedido) {

        var buscaConta = buscarNaCollection(pedido.getNumero());

        if (buscaConta != null) {
            listaPedidos.set(listaPedidos.indexOf(buscaConta), pedido);
            System.out.println("\nO Pedido numero: " + pedido.getNumero() + " foi atualizada com sucesso!");
        } else {
            System.out.println("\nO Pedido numero: " + pedido.getNumero() + " não foi encontrada!");
        }

    }

    @Override
    public void deletar(int numero) {
        var pedido = buscarNaCollection(numero);

        if (pedido != null) {
            if (listaPedidos.remove(pedido) == true) {
                System.out.println("\nO pedido número: " + numero + " foi deletado com sucesso! ");
            }
        } else {
            System.out.println("\nO Pedido número: " + numero + " não foi encontrado!");
        }


    }

    @Override
    public void metodoDePagamento(int numero) {
        var pedido = buscarNaCollection(numero);

        if (pedido != null) {

            String formaPagamento;

            switch (numero) {
                case 1 -> {
                    formaPagamento = "Pix";
                    System.out.println("Valor Total a pagar do pedido número " + numero + ": " + formatarMoeda(pedido.getValorTotal()));
                    pedido.setPago(true);
                    pedido.setValorTotal(0);
                    pedido.setFormaDePagamento(formaPagamento);
                    System.out.println("Pedido sendo pago...");
                    System.out.println("Pedido pago com sucesso!");
                }
                case 2 -> {
                    formaPagamento = "Cartao de Debito";
                    System.out.println("Valor a pagar do pedido número: " + numero);
                    System.out.println("Valor Total a pagar do pedido número " + numero + ": " + formatarMoeda(pedido.getValorTotal()));
                    pedido.setPago(true);
                    pedido.setValorTotal(0);
                    pedido.setFormaDePagamento(formaPagamento);
                    System.out.println("Pedido sendo pago...");
                    System.out.println("Pedido pago com sucesso!");
                }
                case 3 -> {
                    formaPagamento = "Dinheiro";
                    System.out.println("Valor a pagar do pedido número: " + numero);
                    System.out.println("Valor Total a pagar do pedido número " + numero + ": " + formatarMoeda(pedido.getValorTotal()));
                    pedido.setPago(true);
                    pedido.setValorTotal(0);
                    pedido.setFormaDePagamento(formaPagamento);
                    System.out.println("Pedido sendo pago...");
                    System.out.println("Pedido pago com sucesso!");
                }
                case 4 -> {
                    formaPagamento = "Cartao de Credito";
                    System.out.println("Obs. Pagamento em crédito permitido somente à vista!");
                    System.out.println("Valor a pagar do pedido número: " + numero);
                    System.out.println("Valor Total a pagar do pedido número " + numero + ": " + formatarMoeda(pedido.getValorTotal()));
                    pedido.setPago(true);
                    pedido.setValorTotal(0);
                    pedido.setFormaDePagamento(formaPagamento);
                    System.out.println("Pedido sendo pago...");
                    System.out.println("Pedido pago com sucesso!");

                }
                default -> {
                    System.out.println("Opção de pagamento inexistente! ");
                }

            }


        } else {
            System.out.println("Pedido inexistente!");
        }

    }

    @Override
    public void listarPedidosPagos() {
        if (listaPedidos.size() != 0) {
            for (var pedido : listaPedidos) {
                if (pedido.isPago() == true) {
                    pedido.visualizar();
                } else {
                    System.out.println("Não tem pedidos pagos!");
                }
            }

        } else {
            System.out.println("Não tem pedidos criados!");

        }

    }

    @Override
    public void listarPedidosNaoPagos() {

        if (listaPedidos.size() != 0) {
            for (var pedido : listaPedidos) {
                if (pedido.isPago() != true) {
                    pedido.visualizar();
                } else {
                    System.out.println("Não há pedidos não pagos!");
                }

            }

        } else {
            System.out.println("Não há pedidos criados!");

        }

    }

    @Override
    public void relatorioVendas() {
        int totalPedidos = 0;
        float totalValorPedidosNaoPagos = 0f, totalValorPedidosPagos = 0f, totalValorPedidosPagosPix = 0f, totalValorPedidosPagosDinheiro = 0f, totalValorPedidosPagosDebito = 0f, totalValorPedidosPagosCredito = 0f;

        if (listaPedidos.size() != 0) {
            for (var pedido : listaPedidos) {
                totalPedidos++;
                if (pedido.isPago() == false) {
                    totalValorPedidosNaoPagos += pedido.getValorTotal();
                } else if (pedido.isPago() == true) {
                    totalValorPedidosPagos += pedido.getValorTotalPedido();
                }
                if (pedido.getFormaDePagamento() == "Pix") {
                    totalValorPedidosPagosPix += pedido.getValorTotalPedido();

                } else if (pedido.getFormaDePagamento() == "Dinheiro") {
                    totalValorPedidosPagosDinheiro += pedido.getValorTotalPedido();

                } else if (pedido.getFormaDePagamento() == "Cartao de Debito") {
                    totalValorPedidosPagosDebito += pedido.getValorTotalPedido();

                } else if (pedido.getFormaDePagamento() == "Cartao de Credito") {
                    totalValorPedidosPagosCredito += pedido.getValorTotalPedido();

                }


            }
            System.out.println("**************************************************************************");
            System.out.println("********************Relatório de Vendas do dia!!**************************");
            System.out.println("Total de pedidos no dia: " + totalPedidos);
            System.out.println("Total em valor de pedidos não pagos: " + formatarMoeda(totalValorPedidosNaoPagos));
            System.out.println("Total em valor de pedidos pagos: " + formatarMoeda(totalValorPedidosPagos));
            System.out.println("****************************************************************************");
            System.out.println("Total em valor das Formas de Pagamento: ");
            System.out.println("Pix: " + formatarMoeda(totalValorPedidosPagosPix));
            System.out.println("Dinheiro: " + formatarMoeda(totalValorPedidosPagosDinheiro));
            System.out.println("Debito: " + formatarMoeda(totalValorPedidosPagosDebito));
            System.out.println("Credito: " + formatarMoeda(totalValorPedidosPagosCredito));
            System.out.println("**************************************************************************");
        } else {
            System.out.println("Não teve vendas no dia.");

        }


    }


    public int gerarNumero() {
        return ++numero;
    }

    public Pedido buscarNaCollection(int numero) {
        for (var pedido : listaPedidos) {
            if (pedido.getNumero() == numero) {
                return pedido;
            }
        }
        return null;
    }

    public float totalPedido(Pedido pedido) {

        if (pedido.getValorTotalAcessorios() != 0 && pedido.getAcessorios() != null) {
            float valorIphone = pedido.getValorIphone();
            float valorTotalAcessorios = pedido.getValorTotalAcessorios();
            float valorTotal = valorIphone + valorTotalAcessorios;

            return valorTotal;
        }
        return pedido.getValorTotal();
    }

    public static String formatarMoeda(float valor) {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        nf.setMinimumFractionDigits(2);
        String FormatoMoeda = nf.format(valor);
        return FormatoMoeda;
    }


}
