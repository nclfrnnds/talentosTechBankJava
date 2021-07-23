package semana04.postgres;

import java.sql.*;

public class TestePostgres {

    public static void main(String[] args) {
        String urlPostgres = System.getenv("urlPostgres");
        String usuario = System.getenv("usuario");
        String senha = System.getenv("senha");
        try (
                Connection conn = DriverManager.getConnection(urlPostgres, usuario, senha);
                Statement stmt = conn.createStatement()) {
            String query = "select 1 as id, 'Nicoli' as nome";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("NOME: " + rs.getString("nome"));
            }
            rs.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

}
