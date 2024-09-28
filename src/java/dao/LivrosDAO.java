/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import apoio.ConexaoBD;
import entidade.Livros;
import java.sql.Statement;

/**
 *
 * @author Eduardo
 */
public class LivrosDAO {

    public boolean salvar(Livros c) {

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "insert into livros values ("
                    + "default,"
                    + "'" + c.getTitulo() + "', "
                    + "'" + c.getAutor() + "', "
                    + "'" + c.getDescricao() + "', "
                    + "'" + c.getPublicacai() + "', "
                    + "'" + c.getAvaliacao() + "' "
                    + ")";

            System.out.println("SQL:" + sql);

            st.executeUpdate(sql);

            return true;
        } catch (Exception e) {
            System.out.println("Erro ao SALVAR LIVRO:" + e);
            return false;
        }
    }

}
