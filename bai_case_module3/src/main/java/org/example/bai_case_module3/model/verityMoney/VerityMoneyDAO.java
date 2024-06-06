package org.example.bai_case_module3.model.verityMoney;

import org.example.bai_case_module3.database.DBConnect;
import org.example.bai_case_module3.entity.VerityMoney;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class VerityMoneyDAO implements IVerityMoneyDAO {
    private Connection connection;

    public VerityMoneyDAO(){
        DBConnect dbConnection =new DBConnect();
        connection = dbConnection.getConnection();
    }

    @Override
    public void insertInto(VerityMoney verityMoney) throws SQLException {

    }

    @Override
    public VerityMoney selectById(int id) {
        return null;
    }

    @Override
    public List<VerityMoney> selectAll() {
        return null;
    }

    @Override
    public boolean deleteById(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(VerityMoney verityMoney) throws SQLException {
        return false;
    }
}
