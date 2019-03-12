package br.senai.sc.sisges.dao;

import br.senai.sc.sisges.modelo.Equipe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EquipeDao extends ConnectionFactory {

    private Connection con;

    public EquipeDao() {
        this.con = this.getConnection();
    }

    public void inserir(Equipe equ) throws SQLException {

        String sql = "insert into equipe "
                + "(nomEqu, desEqu, "
                + "idEqu)"
                + "values (?, ?, ?);";

        try (PreparedStatement st = this.con.prepareStatement(sql)) {
            st.setString(1, equ.getDesEqu());
            st.setString(2, equ.getNomEqu());
            st.setLong(3, equ.getIdEqu());          

            st.execute();
            st.close();
        }

        this.con.close();

    }
    
    public void eliminar(int codEqu) throws SQLException {

        String sql = "delete from equipe where codEqu = ?";

        try (PreparedStatement st = this.con.prepareStatement(sql)) {
            st.setInt(1, codEqu);
            st.execute();
            st.close();
        }

        this.con.close();

    }

    public void alterar(Equipe equ) throws SQLException {

        String sql = "update cliente set nomEqu = ?, desEqu = ?, IdEqu = ?";

        try (PreparedStatement st = this.con.prepareStatement(sql)) {
            st.setString(1, equ.getDesEqu());
            st.setString(2, equ.getNomEqu());
            st.setLong(3, equ.getIdEqu());   
            

            st.execute();
            st.close();
        }

        this.con.close();

    }

    public List<Equipe> listarEquipe() throws SQLException {
        String sql = "select * from equipe";
        List<Equipe> equipe = null;

        try (PreparedStatement st = this.con.prepareStatement(sql)) {
            ResultSet rs = st.executeQuery();

            equipe = new ArrayList<Equipe>();

            while (rs.next()) {
                Equipe e = new Equipe();
                e.setDesEqu(rs.getString("DesEqu"));
                e.setIdEqu(rs.getLong("IdEqu"));
                e.setNomEqu(rs.getString("NomEqu"));
                

                equipe.add(e);
            }

            rs.close();
            st.close();

        }

        this.con.close();
        return equipe;
    }

    public Equipe getEquipe(int codEqu) throws SQLException {
        String sql = "select * from equipe where codEqu = ?";
        Equipe equipe = null;

        try (PreparedStatement st = this.con.prepareStatement(sql)) {
            st.setInt(1, codEqu);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    Equipe eq = new Equipe();
                    eq.setDesEqu(rs.getString("DesEqu"));
                    eq.setIdEqu(rs.getLong("IdEqu"));
                    eq.setNomEqu(rs.getString("NomEqu"));
                    
                }
            }
            st.close();
        }

        this.con.close();
        return equipe;
    }

}