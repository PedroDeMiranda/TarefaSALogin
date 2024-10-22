package loginUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.Conexao;

public class Usuario {
    private int Id;
    private String permissao;
    private int PessoaId;

    public boolean autenticar(String username, String password) {
    String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
    try (Connection con = Conexao.conectar();
         PreparedStatement stmt = con.prepareStatement(sql)) {
        stmt.setString(1, username);
        stmt.setString(2, password);
        ResultSet rs = stmt.executeQuery();
        return rs.next(); // Retorna true se um usuário correspondente for encontrado
    } catch (SQLException | ClassNotFoundException ex) {
        System.out.println("Erro ao autenticar usuário: " + ex.getMessage());
        return false; // Retorna false em caso de erro
    }
}
    
    //getters e setters
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getPermissao() {
        return permissao;
    }

    public void setPermissao(String permissao) {
        this.permissao = permissao;
    }

    public int getPessoaId() {
        return PessoaId;
    }

    public void setPessoaId(int pessoaId) {
        PessoaId = pessoaId;
    }
}
