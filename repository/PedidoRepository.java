package repository;

import model.Pedido;

public interface PedidoRepository {

    public void procurarPorNumero(int numero);

    public void listarTodas();

    public void cadastrar(Pedido pedido);

    public void atualizar(Pedido pedido);

    public void deletar(int numero);

    public void metodoDePagamento(int numero);
    public void listarPedidosPagos();
    public void listarPedidosNaoPagos();
    public void relatorioVendas();


}
