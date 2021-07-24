package semana04.projetojdbc.dao;

import semana04.projetojdbc.model.ItemVenda;
import semana04.projetojdbc.model.Venda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ItemVendaDao {

    private final Connection conn;

    public ItemVendaDao(Connection conn) {
        this.conn = conn;
    }

    public void adicionaItemNaVenda(ItemVenda item, Venda venda) throws SQLException {
        String query = "insert into tb_item_venda values(default, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement insertItemVenda = conn.prepareStatement(query)) {

            int i = 0;

            insertItemVenda.setLong(++i, venda.getId());
            insertItemVenda.setLong(++i, item.getProduto().getId());

            insertItemVenda.setBigDecimal(++i, item.getQuantidade());
            insertItemVenda.setBigDecimal(++i, item.getValorUnitario());
            insertItemVenda.setBigDecimal(++i, item.getValorTotal());
            insertItemVenda.setString(++i, item.getDescricao());

            insertItemVenda.executeUpdate();

        }
    }

}
