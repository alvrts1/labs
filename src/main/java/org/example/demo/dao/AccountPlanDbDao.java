package org.example.demo.dao;

import org.example.demo.domain.AccountPlan;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class AccountPlanDbDao implements RepositoryDAO<AccountPlan>  {
    private static final String select_all_accountPlan = "SELECT id, name_, type_, number_ FROM accountPlan ORDER BY name_ ASC";

    private static final String select_accountPlan_ById = "SELECT id, name_, type_, number_ FROM accountPlan WHERE id = ?";

    private static final String insert_accountPlan = "INSERT INTO accountPlan(name_, type_, number_) VALUES(?, ?, ?)";

    private static final String edit_accountPlan = "UPDATE accountPlan SET name_ = ?, type_ = ?, number_ = ? WHERE id = ?";

    private static final String delete_accountPlan = "DELETE FROM accountPlan WHERE id = ?";

    private ConnectionBuilder builder = new DbConnectionBuilder();

    private Connection getConnection() throws SQLException {
        return builder.getConnection();
    }

    @Override
    public Long insert(AccountPlan o) throws SQLDataException {
        try(Connection con = getConnection(); PreparedStatement pst = con.prepareStatement(insert_accountPlan, new String[]{"id"})) {
            Long Id = -1L;
            pst.setString(1, o.getName());
            pst.setString(2, o.getType());
            pst.setInt(3, o.getNumber());
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
    public void update(AccountPlan o) throws SQLDataException {
        try(Connection con = getConnection(); PreparedStatement pst = con.prepareStatement(edit_accountPlan)) {
            pst.setString(1, o.getName());
            pst.setString(2, o.getType());
            pst.setInt(3, o.getNumber());
            pst.executeUpdate();
        }catch (Exception e){
            throw new SQLDataException();
        }
    }

    @Override
    public void delete(AccountPlan o) throws SQLDataException {
        try(Connection con = getConnection(); PreparedStatement pst = con.prepareStatement(delete_accountPlan)) {
            pst.setLong(1, o.getId());
            pst.executeUpdate();
        }catch (Exception e){
            throw new SQLDataException();
        }
    }

    @Override
    public AccountPlan findById(Long id) throws SQLDataException {
        AccountPlan accountPlan = null;
        try (Connection con = getConnection();
             PreparedStatement pst = con.prepareStatement(select_accountPlan_ById)) {
            pst.setLong(1, id);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    accountPlan = fillAccountPlan(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Логирование исключения для выявления причины
            throw new SQLDataException("Error occurred while fetching country by ID");
        }
        return accountPlan;
    }

    @Override
    public List<AccountPlan> findAll() throws SQLDataException {
        List<AccountPlan> list = new LinkedList<>();
        try (Connection con = getConnection();
             PreparedStatement pst = con.prepareStatement(select_all_accountPlan);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                list.add(fillAccountPlan(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Log the exception for debugging purposes
            throw new SQLDataException("Error occurred while fetching all countries");
        }
        return list;
    }

    private AccountPlan fillAccountPlan(ResultSet rs) throws SQLException {
        AccountPlan accountPlan = new AccountPlan();
        accountPlan.setId(rs.getLong("id"));
        accountPlan.setName(rs.getString("name_"));
        accountPlan.setType(rs.getString("type_"));
        accountPlan.setNumber(rs.getInt("number_"));
        return accountPlan;
    }
}
