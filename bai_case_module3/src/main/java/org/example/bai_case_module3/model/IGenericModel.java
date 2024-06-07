package org.example.bai_case_module3.model;

import java.sql.SQLException;
import java.util.List;

public interface IGenericModel<Generic> {
    public void insertInto(Generic generic) throws SQLException;

    public Generic selectById(int id);

    public List<Generic> selectAll() throws SQLException;

    public boolean deleteById(int id) throws SQLException;

    public boolean update(Generic generic) throws SQLException;
}
