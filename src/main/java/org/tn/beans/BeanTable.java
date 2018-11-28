package org.tn.beans;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Stateless бин для поиска значений в таблице obj_type
 */
@Stateless
public class BeanTable {

    private static final String SQL = "select * from obj_type where obj_type_id = ?";

    @Resource(mappedName = "jdbc/OracleDataSource")
    private DataSource ds;

    public List<String> loadData(int id) {
        List<String> result = new ArrayList<>();
        try(Connection connect = ds.getConnection();
            PreparedStatement pstm = connect.prepareStatement(SQL)) {
            pstm.setInt(1, id);
            ResultSet res = pstm.executeQuery();
            while(res.next()) {
                result.add(res.getString(1) + " " +
                        res.getString(2) + " " +
                        res.getString(3));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
