/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import apoio.ConexaoBD;
import entidade.Livros;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Eduardo
 */
public class LivrosDAO {
    //salvar
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
            System.out.println("Erro ao SALVAR LIVROS:" + e);
            return false;
        }
    }

    //consultar um
    public Livros consultar(int codigo) {
        Livros livros = new Livros();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "select * from livros "
                    + "where "
                    + "id = " + codigo;

            System.out.println("SQL:" + sql);

            ResultSet resultado = st.executeQuery(sql);

            resultado.next();
            livros.setId(resultado.getInt("id"));
            livros.setTitulo(resultado.getString("titulo"));
            livros.setAutor(resultado.getString("autor"));
            livros.setDescricao(resultado.getString("descricao"));
            livros.setPublicacai(resultado.getString("publicacai"));
            livros.setAvaliacao(resultado.getString("avaliacao"));

        } catch (Exception e) {
            System.out.println("Erro ao CONSULTAR UM LIVRO:" + e);
        }
        return livros;
    }

    //consultar todos
    public ArrayList consultar() {
        ArrayList<Livros> livros = new ArrayList<>();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "select * from livros";

            System.out.println("SQL:" + sql);

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                Livros l = new Livros();
                l.setId(resultado.getInt("id"));
                l.setTitulo(resultado.getString("titulo"));
                l.setAutor(resultado.getString("autor"));
                l.setDescricao(resultado.getString("descricao"));
                l.setPublicacai(resultado.getString("publicacai"));
                l.setAvaliacao(resultado.getString("avaliacao"));

                livros.add(l);
            }
        } catch (Exception e) {
            System.out.println("Erro ao CONSULTAR LIVROS:" + e);
        }
        return livros;
    }
    //excluir
    public boolean excluir(int parametro) {

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "delete from livros "
                    + "where "
                    + "id = " + parametro;

            System.out.println("SQL:" + sql);

            st.executeUpdate(sql);

            return true;
        } catch (Exception e) {
            System.out.println("Erro ao EXCLUIR LIVROS:" + e);
            return false;
        }
    }
    //atualizar
    public boolean atualizar(Livros c) {
              
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "update livros "
                    + "set "
                    + "titulo = '" + c.getTitulo() + "', "
                    + "autor = '" + c.getAutor() + "', "
                    + "descricao = '" + c.getDescricao() + "',"
                    + "publicacai = '" + c.getPublicacai() + "', "
                    + "avaliacao = " + c.getAvaliacao() + " "
                    + "where id = " + c.getId();

            System.out.println("SQL:" + sql);

            st.executeUpdate(sql);

            return true;
        } catch (Exception e) {
            System.out.println("Erro ao ATUALIZAR LIVROS:" + e);
            return false;
        }
    }
}
