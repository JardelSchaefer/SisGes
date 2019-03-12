package br.senai.sc.sisges.dao;

import br.senai.sc.sisges.modelo.Colaborador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ColaboradorDao extends ConnectionFactory {

    private Connection con;

    public ColaboradorDao() {
        this.con = this.getConnection();
    }

    public void inserir(Colaborador col) throws SQLException {

        String sql = "insert into colaborador "
                + "(nomCol, endCol, numCol "
                + "baiCol, cepCol, comCol, cpfC, "
                + "celCol, tipoCol,usuCol, senCol, equCol, dddCol) "
                + "values (?, ?, ?, ?, ?, ?, ?, ? ,? ,? , ?, ?, ?, ?);";

        try (PreparedStatement st = this.con.prepareStatement(sql)) {
            st.setString(1, col.getNomCol());
            st.setString(2, col.getEndCol());
            st.setLong(3, col.getNumCol());
            st.setString(4, col.getBaiCol());
            st.setLong(5, col.getCepCol());
            st.setString(6, col.getComCol());
            st.setLong(7, col.getCpfCol());
            st.setLong(8, col.getCelCol());
            st.setString(9, col.getTipoCol());
            st.setString(10, col.getUsuCol());
            st.setString(11, col.getSenCol());
            st.setString(12, col.getEquCol());
            st.setLong(13, col.getDddCol());

            st.execute();
            st.close();
        }

        this.con.close();

    }

    public void eliminar(int idCol) throws SQLException {

        String sql = "delete from colaborador where codigoC = ?";

        try (PreparedStatement st = this.con.prepareStatement(sql)) {
            st.setInt(1, idCol);
            st.execute();
            st.close();
        }

        this.con.close();

    }

    public void alterar(Colaborador col) throws SQLException {

        String sql = "update cliente set nomCol = ?, endCol = ?, numCol= ?, baiCol = ?,cepCol= ?, "
                + "comCol = ?, cpfCol=?, celCol = ?, tipoCol=?, usuCol=?, "
                + "senCol=?, equCol=?, dddCol=? where idCol = ?";

        try (PreparedStatement st = this.con.prepareStatement(sql)) {
            st.setString(1, col.getNomCol());
            st.setString(2, col.getEndCol());
            st.setLong(3, col.getNumCol());
            st.setString(4, col.getBaiCol());
            st.setLong(5, col.getCepCol());
            st.setString(6, col.getComCol());
            st.setLong(7, col.getCpfCol());
            st.setLong(8, col.getCelCol());
            st.setString(9, col.getTipoCol());
            st.setString(10, col.getUsuCol());
            st.setString(11, col.getSenCol());
            st.setString(12, col.getEquCol());
            st.setLong(13, col.getDddCol());
            st.setLong(14, col.getIdCol());

            st.execute();
            st.close();
        }

        this.con.close();

    }

    public List<Colaborador> listarClientes() throws SQLException {
        String sql = "select * from colaborador";
        List<Colaborador> clientes = null;

        try (PreparedStatement st = this.con.prepareStatement(sql)) {
            ResultSet rs = st.executeQuery();

            clientes = new ArrayList<Colaborador>();

            while (rs.next()) {
                Colaborador c = new Colaborador();
                c.setIdCol(rs.getInt("idCol"));
                c.setNomCol(rs.getString("nomCol"));
                c.setEndCol(rs.getString("endCol"));
                c.setNumCol(rs.getLong("numCol"));
                c.setBaiCol(rs.getString("baiCol"));
                c.setCepCol(rs.getInt("cepCol"));
                c.setComCol(rs.getString("comCol"));
                c.setCpfCol(rs.getInt("cpfCol"));
                c.setCelCol(rs.getInt("celCol"));
                c.setTipoCol(rs.getString("tipoCol"));
                c.setUsuCol(rs.getString("usuCol"));
                c.setSenCol(rs.getString("senCol"));
                c.setUltAcCol(rs.getString("ultAcCol"));
                c.setEquCol(rs.getString("equCol"));
                c.setDddCol(rs.getInt("dddCol"));
                clientes.add(c);
            }

            rs.close();
            st.close();

        }

        this.con.close();
        return clientes;
    }

    public Colaborador getColaborador(int idcol) throws SQLException {
        String sql = "select * from cliente where codigoC = ?";
        Colaborador col = null;

        try (PreparedStatement st = this.con.prepareStatement(sql)) {
            st.setInt(1, idcol);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    col = new Colaborador();
                     col.setIdCol(rs.getInt("idCol"));
                col.setNomCol(rs.getString("nomCol"));
                col.setEndCol(rs.getString("endCol"));
                col.setNumCol(rs.getLong("numCol"));
                col.setBaiCol(rs.getString("baiCol"));
                col.setCepCol(rs.getInt("cepCol"));
                col.setComCol(rs.getString("comCol"));
                col.setCpfCol(rs.getInt("cpfCol"));
                col.setCelCol(rs.getInt("celCol"));
                col.setTipoCol(rs.getString("tipoCol"));
                col.setUsuCol(rs.getString("usuCol"));
                col.setSenCol(rs.getString("senCol"));
                col.setUltAcCol(rs.getString("ultAcCol"));
                col.setEquCol(rs.getString("equCol"));
                col.setDddCol(rs.getInt("dddCol"));
                }
            }
            st.close();
        }

        this.con.close();
        return col;
    }

}
