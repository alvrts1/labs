package org.example.demo.dao;

import org.example.demo.domain.AccountPlan;
import org.example.demo.domain.SubAccount;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class SubAccountDbDao implements RepositoryDAO<SubAccount>  {
    private static final String select_all_subAccount = "SELECT id, name_, number_, accountPlanId FROM subAccount ORDER BY name_ ASC";

    private static final String select_subAccount_ById = "SELECT id, name_, number_, accountPlanId FROM subAccount WHERE id = ?";

    private static final String insert_subAccount = "INSERT INTO subAccount(name_, number_, accountPlanId) VALUES(?, ?, ?)";

    private static final String edit_subAccount = "UPDATE subAccount SET name_ = ?, number_, subAccountId = ? WHERE id = ?";

    private static final String delete_subAccount = "DELETE FROM subAccount WHERE id = ?";

    private ConnectionBuilder builder = new DbConnectionBuilder();

    private Connection getConnection() throws SQLException {
        return builder.getConnection();
    }
    @Override
    public Long insert(SubAccount o) throws SQLDataException {
        try(Connection con = getConnection(); PreparedStatement pst = con.prepareStatement(insert_subAccount, new String[]{"id"})) {
            Long Id = -1L;
            pst.setString(1, o.getName());
            pst.setInt(2, o.getNumber());
            pst.setLong(3, o.getAccountId());
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
    public void update(SubAccount o) throws SQLDataException {
        try(Connection con = getConnection(); PreparedStatement pst = con.prepareStatement(edit_subAccount)) {
            pst.setString(1, o.getName());
            pst.setInt(2, o.getNumber());
            pst.setString(3, o.getAccountPlan());
            pst.executeUpdate();
        }catch (Exception e){
            throw new SQLDataException();
        }
    }

    @Override
    public void delete(SubAccount o) throws SQLDataException {
        try(Connection con = getConnection(); PreparedStatement pst = con.prepareStatement(delete_subAccount)) {
            pst.setLong(1, o.getId());
            pst.executeUpdate();
        }catch (Exception e){
            throw new SQLDataException();
        }
    }

    @Override
    public SubAccount findById(Long id) throws SQLDataException {
        SubAccount subAccount = null;
        try (Connection con = getConnection();
             PreparedStatement pst = con.prepareStatement(select_subAccount_ById)) {
            pst.setLong(1, id);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    subAccount = fillSubAccount(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Логирование исключения для выявления причины
            throw new SQLDataException("Error occurred while fetching country by ID");
        }
        return subAccount;
    }

    @Override
    public List<SubAccount> findAll() throws SQLDataException {
        List<SubAccount> list = new LinkedList<>();
        try (Connection con = getConnection();
             PreparedStatement pst = con.prepareStatement(select_all_subAccount);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                list.add(fillSubAccount(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Log the exception for debugging purposes
            throw new SQLDataException("Error occurred while fetching all countries");
        }
        return list;
    }

    private SubAccount fillSubAccount(ResultSet rs) throws SQLException {
        Long idAccountPlan = rs.getLong("accountPlanId");
        SubAccount subAccount = new SubAccount();
        subAccount.setId(rs.getLong("id"));
        subAccount.setName(rs.getString("name_"));
        subAccount.setNumber(rs.getInt("number_"));
        subAccount.setAccountId(idAccountPlan);
        return subAccount;
    }
}
