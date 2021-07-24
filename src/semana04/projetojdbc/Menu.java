package semana04.projetojdbc;

import semana04.projetojdbc.dao.ItemVendaDao;
import semana04.projetojdbc.dao.ProdutoDao;
import semana04.projetojdbc.dao.VendaDao;
import semana04.projetojdbc.model.ItemVenda;
import semana04.projetojdbc.model.Produto;
import semana04.projetojdbc.model.Venda;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Menu {

    public static void main(String[] args) throws SQLException {

        DatabaseConnection databaseConnection = new DatabaseConnection();

        Connection conn = databaseConnection.getConnection();

        ProdutoDao produtoDao = new ProdutoDao(conn);
        VendaDao vendaDao = new VendaDao(conn);
        ItemVendaDao itemVendaDao = new ItemVendaDao(conn);

        // Cadastrei um novo produto
        Produto p = new Produto(
                "Pão Francês",
                BigDecimal.valueOf(0.7),
                BigDecimal.valueOf(70.0),
                "GR",
                "123",
                BigDecimal.valueOf(1.2)
        );
        p.cadastrarNovoProduto(produtoDao);

        // Inicializei uma nova venda
        Venda v = Venda.inicializarVenda(vendaDao);

        // Busquei um produto por código de barras
        List<Produto> resultadoBuscaProdutos = Produto.buscarProdutos(produtoDao, "123");
        Produto produtoEncontrado = resultadoBuscaProdutos.get(0);

        // Criei um novo item venda
        ItemVenda item = new ItemVenda();
        item.setProduto(produtoEncontrado);
        item.setQuantidade(BigDecimal.valueOf(100));

        v.adicionarItemNaVenda(itemVendaDao, item);

        v.concluirVenda(vendaDao);

        conn.close();

    }

}
