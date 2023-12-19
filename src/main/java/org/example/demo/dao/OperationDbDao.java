package org.example.demo.dao;

import org.example.demo.domain.Deal;
import org.example.demo.domain.Operation;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class OperationDbDao implements RepositoryDAO<Operation> {
    private static final String select_all_operation = "SELECT id, number_, date_, type_, sum_, saldoInput, saldoOutput, dealId, subAccountID FROM operation ORDER BY number_ ASC";

    private static final String select_operation_ById = "SELECT id, number_, date_, type_, sum_, saldoInput, saldoOutput, dealId, subAccountID FROM operation WHERE id = ?";

    private static final String insert_operation = "INSERT INTO operation(number_, date_, type_, sum_, saldoInput, saldoOutput, dealId, subAccountID) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String edit_operation = "UPDATE operation SET number_ = ?, date_ = ?, type_ = ?, sum_ = ?, saldoInput = ?, saldoOutput = ?, dealId = ?, subAccountID = ? WHERE id = ?";

    private static final String delete_operation = "DELETE FROM operation WHERE id = ?";

    private ConnectionBuilder builder = new DbConnectionBuilder();

    private Connection getConnection() throws SQLException {
        return builder.getConnection();
    }
    @Override
    public Long insert(Operation o) throws SQLDataException {
        try(Connection con = getConnection(); PreparedStatement pst = con.prepareStatement(insert_operation, new String[]{"id"})) {
            Long Id = -1L;
            pst.setInt(1, o.getNumber());
            pst.setString(2, o.getDate());
            pst.setString(3, o.getType());
            pst.setFloat(4, o.getSum());
            pst.setFloat(5, o.getSaldoInput());
            pst.setFloat(6, o.getSaldoOutput());
            pst.setLong(7, o.getDealId());
            pst.setLong(8, o.getSubAccountId());
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
    public void update(Operation o) throws SQLDataException {
        try(Connection con = getConnection(); PreparedStatement pst = con.prepareStatement(edit_operation)) {
            pst.setInt(1, o.getNumber());
            pst.setString(2, o.getDate());
            pst.setString(3, o.getType());
            pst.setFloat(4, o.getSum());
            pst.setFloat(5, o.getSaldoInput());
            pst.setFloat(6, o.getSaldoOutput());
            pst.setLong(7, o.getDealId());
            pst.setLong(8, o.getSubAccountId());
            pst.executeUpdate();
        }catch (Exception e){
            throw new SQLDataException();
        }
    }

    @Override
    public void delete(Operation o) throws SQLDataException {
        try(Connection con = getConnection(); PreparedStatement pst = con.prepareStatement(delete_operation)) {
            pst.setLong(1, o.getId());
            pst.executeUpdate();
        }catch (Exception e){
            throw new SQLDataException();
        }
    }

    @Override
    public Operation findById(Long id) throws SQLDataException {
        Operation operation = null;
        try (Connection con = getConnection();
             PreparedStatement pst = con.prepareStatement(select_operation_ById)) {
            pst.setLong(1, id);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    operation = fillOperation(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Логирование исключения для выявления причины
            throw new SQLDataException("Error occurred while fetching country by ID");
        }
        return operation;
    }

    @Override
    public List<Operation> findAll() throws SQLDataException {
        List<Operation> list = new LinkedList<>();
        try (Connection con = getConnection();
             PreparedStatement pst = con.prepareStatement(select_all_operation);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                list.add(fillOperation(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Log the exception for debugging purposes
            throw new SQLDataException("Error occurred while fetching all countries");
        }
        return list;
    }

    private Operation fillOperation(ResultSet rs) throws SQLException {
        Long dealId = rs.getLong("dealId");
        Long subAccountId = rs.getLong("subAccountId");
        Operation operation = new Operation();
        operation.setId(rs.getLong("id"));
        operation.setNumber(rs.getInt("number_"));
        operation.setDate(rs.getString("date_"));
        operation.setType(rs.getString("type_"));
        operation.setSum(rs.getFloat("sum_"));
        operation.setSaldoInput(rs.getFloat("saldoInput"));
        operation.setSaldoOutput(rs.getInt("saldoOutput"));
        operation.setDealId(dealId);
        operation.setSubAccountId(subAccountId);
        return operation;
    }
}
