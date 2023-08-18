package model;

import controller.PedidoController;

public class Pedido {

    private int numero;

    private String nomeCliente;
    private String nomeIphone;
    private float valorIphone;
    private String acessorios;
    private float valorTotalAcessorios;
    private float valorTotal;
    private float valorTotalPedido;
    private boolean pago;
    private String formaDePagamento = "A fazer! ";


    public Pedido(int numero, String nomeCliente, String nomeIphone, float valorIphone, String acessorios, float valorTotalAcessorios) {
        this.numero = numero;
        this.nomeCliente = nomeCliente;
        this.nomeIphone = nomeIphone;
        this.valorIphone = valorIphone;
        this.acessorios = acessorios;
        this.valorTotalAcessorios = valorTotalAcessorios;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Pedido(int numero, String nomeCliente, String nomeIphone, float valorIphone) {
        this.numero = numero;
        this.nomeCliente = nomeCliente;
        this.nomeIphone = nomeIphone;
        this.valorIphone = valorIphone;
        this.valorTotal = valorIphone;
    }

    public Pedido() {
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getNomeIphone() {
        return nomeIphone;
    }

    public void setNomeIphone(String nomeIphone) {
        this.nomeIphone = nomeIphone;
    }

    public float getValorIphone() {
        return valorIphone;
    }

    public void setValorIphone(float valorIphone) {
        this.valorIphone = valorIphone;
    }

    public String getAcessorios() {
        return acessorios;
    }

    public void setAcessorios(String acessorios) {
        this.acessorios = acessorios;
    }

    public float getValorTotalAcessorios() {
        return valorTotalAcessorios;
    }

    public void setValorTotalAcessorios(float valorTotalAcessorios) {
        this.valorTotalAcessorios = valorTotalAcessorios;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public String getFormaDePagamento() {
        return formaDePagamento;
    }

    public void setFormaDePagamento(String formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }

    public float getValorTotalPedido() {
        return valorTotalPedido;
    }

    public void setValorTotalPedido(float valorTotalPedido) {
        this.valorTotalPedido = valorTotalPedido;
    }

    public void visualizar() {
        System.out.println("\n*********************************************\n");
        System.out.println("Número do pedido: " + getNumero());
        System.out.println("Nome Cliente: " + nomeCliente);
        System.out.println("Iphone: " + nomeIphone);
        System.out.println("Valor Iphone: " + PedidoController.formatarMoeda(valorIphone));
        if (acessorios == null && valorTotalAcessorios == 0) {
            System.out.println("Não possui acessórios!");
        } else {
            System.out.println("Itens escolhidos: " + acessorios);
            System.out.println("Valor total dos acessórios: " + PedidoController.formatarMoeda(valorTotalAcessorios));
        }
        System.out.println("Pedido pago? " + isPago());
        System.out.println("Valor Total do Pedido: " + PedidoController.formatarMoeda(getValorTotalPedido()));
        System.out.println("Forma de Pagamento: " + getFormaDePagamento());
        System.out.println("Valor Total a Pagar: " + PedidoController.formatarMoeda(getValorTotal()));
        System.out.println("\n*********************************************\n");

    }

}
