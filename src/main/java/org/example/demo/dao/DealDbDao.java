package org.example.demo.dao;

import org.example.demo.domain.Deal;
import org.example.demo.domain.SubAccount;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DealDbDao implements RepositoryDAO<Deal>  {
    private static final String select_all_deal = "SELECT id, agreement, tiker, order_, number_, date_, quantity, price, totalCost, trader, commission FROM deal ORDER BY agreement ASC";

    private static final String select_deal_ById = "SELECT id, agreement, tiker, order_, number_, date_, quantity, price, totalCost, trader, commission FROM deal WHERE id = ?";

    private static final String insert_deal = "INSERT INTO deal(agreement, tiker, order_, number_, date_, quantity, price, totalCost, trader, commission) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String edit_deal = "UPDATE deal SET agreement = ?, tiker = ?, order_ = ?, number_ = ?, date_ = ?, quantity = ?, price = ?, totalCost = ?, trader = ?, commission = ? WHERE id = ?";

    private static final String delete_deal = "DELETE FROM deal WHERE id = ?";

    private ConnectionBuilder builder = new DbConnectionBuilder();

    private Connection getConnection() throws SQLException {
        return builder.getConnection();
    }
    @Override
    public Long insert(Deal o) throws SQLDataException {
        try(Connection con = getConnection(); PreparedStatement pst = con.prepareStatement(insert_deal, new String[]{"id"})) {
            Long Id = -1L;
            pst.setString(1, o.getAgreement());
            pst.setString(2, o.getTiker());
            pst.setString(3, o.getOrder());
            pst.setInt(4, o.getNumber());
            pst.setString(5, o.getDate());
            pst.setInt(6, o.getQuantity());
            pst.setFloat(7, o.getPrice());
            pst.setFloat(8, o.getTotalCost());
            pst.setString(9, o.getTrader());
            pst.setFloat(10, o.getCommission());
            pst.executeUpdate();
            ResultSet gk = pst.getGeneratedKeys();
            if(gk.next()){
                Id = gk.getLong("id");
            }
            gk.close();
            return Id;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Deal o) throws SQLDataException {
        try(Connection con = getConnection(); PreparedStatement pst = con.prepareStatement(edit_deal)) {
            pst.setString(1, o.getAgreement());
            pst.setString(2, o.getTiker());
            pst.setString(3, o.getOrder());
            pst.setInt(4, o.getNumber());
            pst.setString(5, o.getDate());
            pst.setInt(6, o.getQuantity());
            pst.setFloat(7, o.getPrice());
            pst.setFloat(8, o.getTotalCost());
            pst.setString(9, o.getTrader());
            pst.setFloat(10, o.getCommission());
            pst.executeUpdate();
        }catch (Exception e){
            throw new SQLDataException();
        }
    }

    @Override
    public void delete(Deal o) throws SQLDataException {
        try(Connection con = getConnection(); PreparedStatement pst = con.prepareStatement(delete_deal)) {
            pst.setLong(1, o.getId());
            pst.executeUpdate();
        }catch (Exception e){
            throw new SQLDataException();
        }
    }

    @Override
    public Deal findById(Long id) throws SQLDataException {
        Deal deal = null;
        try (Connection con = getConnection();
             PreparedStatement pst = con.prepareStatement(select_deal_ById)) {
            pst.setLong(1, id);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    deal = fillDeal(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Логирование исключения для выявления причины
            throw new SQLDataException("Error occurred while fetching country by ID");
        }
        return deal;
    }

    @Override
    public List<Deal> findAll() throws SQLDataException {
        List<Deal> list = new LinkedList<>();
        try (Connection con = getConnection();
             PreparedStatement pst = con.prepareStatement(select_all_deal);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                list.add(fillDeal(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Log the exception for debugging purposes
            throw new SQLDataException("Error occurred while fetching all countries");
        }
        return list;
    }

    private Deal fillDeal(ResultSet rs) throws SQLException {
        Deal deal = new Deal();
        deal.setId(rs.getLong("id"));
        deal.setAgreement(rs.getString("agreement"));
        deal.setTiker(rs.getString("tiker"));
        deal.setOrder(rs.getString("order_"));
        deal.setNumber(rs.getInt("number_"));
        deal.setDate(rs.getString("date_"));
        deal.setQuantity(rs.getInt("quantity"));
        deal.setPrice(rs.getFloat("price"));
        deal.setTotalCost(rs.getFloat("totalCost"));
        deal.setTrader(rs.getString("trader"));
        deal.setCommission(rs.getFloat("commission"));
        return deal;
    }
}
