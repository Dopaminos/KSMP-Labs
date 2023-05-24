import java.sql.*;

public class CommandsSQL {
    Connection connect;

    public CommandsSQL(Connection connect) {
        this.connect = connect;
    }

    public void outputAllData(String tableName) {
        try {
            String sqlQuery = "SELECT * FROM " + tableName;

            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            ResultSetMetaData metaData = getMetaDataOutputAllData(resultSet);

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            System.err.flush();
            System.err.println("repeat");
        }
    }

    public void outputOrderBy(String tableName, String columnName) {
        try {
            String sqlQuery = "SELECT * FROM " + tableName + " ORDER BY " + columnName;

            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            ResultSetMetaData metaData = getMetaDataOutputAllData(resultSet);

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            System.err.flush();
            System.err.println("repeat");
        }
    }

    public void outputWhere(String tableName, String conditions) {

        try {
            String sqlQuery = "SELECT * FROM " + tableName + " WHERE " + conditions;
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            ResultSetMetaData metaData = getMetaDataOutputAllData(resultSet);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            System.err.flush();
            System.err.println("repeat");
        }
    }

    public void outputAllTablesNames() {
        try {
            DatabaseMetaData dbMetaData = connect.getMetaData();
            ResultSet rsMetaData = dbMetaData.getTables(null, null, null, new String[]{"TABLE"});
            while (rsMetaData.next()) {
                System.out.print(rsMetaData.getString("TABLE_NAME") + ";   ");
            }
            System.out.println();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            System.err.flush();
            System.err.println("repeat");
        }
    }

    public ResultSetMetaData getMetaDataOutputAllData(ResultSet resultSet) {
        ResultSetMetaData metaData = null;
        try {
            metaData = resultSet.getMetaData();
            System.out.println('\n' + "—".repeat(metaData.getColumnCount() * 32));
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                System.out.printf(" %-30s|", metaData.getColumnName(i));
            }
            System.out.println('\n' + "—".repeat(metaData.getColumnCount() * 32));
            while (resultSet.next()) {
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    System.out.printf(" %-30s|", resultSet.getString(i));
                }
                System.out.println();
            }
            System.out.println("—".repeat(metaData.getColumnCount() * 32));

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            System.err.flush();
            System.err.println("repeat");
        }
        return metaData;
    }

    public void outputGroupBy(String tableName, String groupingColumnName, String associatedColumnsName) {
        try {
            String sqlQuery = "SELECT " + groupingColumnName + ", " + associatedColumnsName +
                    " FROM " + tableName + " GROUP BY " + groupingColumnName;
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            ResultSetMetaData metaData = getMetaDataOutputAllData(resultSet);

            System.out.println("—".repeat(metaData.getColumnCount() * 32));

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            System.err.flush();
            System.err.println("repeat");
        }

    }
}
