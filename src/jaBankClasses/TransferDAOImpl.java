package jaBankClasses;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransferDAOImpl implements TransferDAO{
    public void createTransfer(Transfer aTransfer) throws DuplicatedObjectException {
        String from = aTransfer.getFrom();
        String to = aTransfer.getTo();
        String amount = aTransfer.getAmount();
        String id = aTransfer.getId();
        String state = aTransfer.getState();
        
        
        Date d = new Date();

        Connection c = DBManager.connect();
        try {

            PreparedStatement ps = c.prepareStatement("INSERT INTO transfers (id, t_from, t_to, amount, state) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, id);
            ps.setString(2, from);
            ps.setString(3, to);
            ps.setString(4, amount);
            ps.setString(5, state);
            ps.executeUpdate();
            c.commit();
        } catch (SQLException e) {
            try {
                c.rollback();
                e.printStackTrace();
                if(e.getErrorCode() == 23505) {
                    throw new DuplicatedObjectException();
                }
            } catch (SQLException e1) {
                e.printStackTrace();
            }
        } finally {
            try {
                c.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    public void deleteTransfer(String id) throws DAOException {
        String sql = "DELETE FROM transfers WHERE id = '" + id + "'";
        Connection c = DBManager.connect();
        try {
            Statement s = c.createStatement();
            s.executeUpdate(sql);
            c.commit();
        } catch (SQLException e) {
            try {
                c.rollback();
            } catch (SQLException ex) {
            }
            throw new DAOException();
        } finally {
            try {
                c.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
//            throw new DAOException("ATENCION NO SE PUEDO CERRAR LA CXN");
        }
    }

    public void updateTransfer(Transfer aTransfer) {
    	String from = aTransfer.getFrom();
        String to = aTransfer.getTo();
        String amount = aTransfer.getAmount();
        String id = aTransfer.getId();
        String state = aTransfer.getState();
        
        String sql = "UPDATE transfers set t_from = '" + from + "', t_to = '" + to + "', amount = '" + amount + "', state = '" + state + "' WHERE id = '" + id + "'";
        Connection c = DBManager.connect();
        try {
            Statement s = c.createStatement();
            s.executeUpdate(sql);
            c.commit();
        } catch (SQLException e) {
            try {
                c.rollback();
                e.printStackTrace();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                c.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
    
    public List<Transfer> listAllTransfers() {
    	List<Transfer> resultado = new ArrayList<>();
        String sql = "SELECT * FROM transfers";
        Connection c = DBManager.connect();
        try {
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(sql);

            
            while (rs.next()) {
            	String id = rs.getString("id");
                String from = rs.getString("t_from");
                String to = rs.getString("t_to");
                String amount = rs.getString("amount");
                String state = rs.getString("state");
                Transfer t = new Transfer(id, from, to, amount, state);
                resultado.add(t);

            }
        } catch (SQLException e) {
            try {
                c.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                c.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        return resultado;
    }
	
    public Transfer muestraUsuario(String id) {
        String sql = "SELECT * FROM transfers WHERE id = '" + id + "'";
        Connection c = DBManager.connect();
        try {
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(sql);

            
            if (rs.next()) {
                String from = rs.getString("from");
                String to = rs.getString("to");
                String amount = rs.getString("amount");
                String state = rs.getString("state");
                Transfer t = new Transfer(id, from, to, amount, state);
                return t;
            }

        } catch (SQLException e) {
            try {
                c.rollback();
                e.printStackTrace();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                c.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        return null;
    }

}
