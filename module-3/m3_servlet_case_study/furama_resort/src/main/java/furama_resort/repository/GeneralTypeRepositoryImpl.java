package furama_resort.repository;

import furama_resort.model.GeneralType;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GeneralTypeRepositoryImpl implements IGeneralRepository {

    @Override
    public List<GeneralType> getAll(String typeName) {
        List<GeneralType> generalTypes = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        CallableStatement statement = null;
        String qry = "{CALL get_all_" + typeName +"()}";
        ResultSet rs = null;
        if (connection != null) {
            try {
                statement = connection.prepareCall(qry);
                rs = statement.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    generalTypes.add(new GeneralType(id, name));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    rs.close();
                    statement.close();
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return generalTypes;
    }
}
