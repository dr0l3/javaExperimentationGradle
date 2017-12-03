import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.*;
import static test.generated.Tables.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        String urls = "jdbc:sqlite:C://sqlite/db/tests.db";
        String create = "CREATE TABLE IF NOT EXISTS hello( id integer PRIMARY KEY, world text);";
        String insert = "INSERT INTO hello(id,world) values(?,?);";
        String world = "hehehe";
        int id = 1;
        String select = "SELECT * FROM hello;";
        try(Connection connection = DriverManager.getConnection(urls)){
            Statement stmt = connection.createStatement();
            stmt.execute(create);
            PreparedStatement pstmt = connection.prepareStatement(insert);
            pstmt.setInt(1,id);
            pstmt.setString(2,world);
//            pstmt.executeUpdate();
            ResultSet rs = stmt.executeQuery(select);
            while(rs.next()){
                System.out.println(rs.getString(2));
                System.out.println(rs.getInt(1));
            }
            DSLContext context = DSL.using(connection, SQLDialect.SQLITE);
            context.selectFrom(MESSAGE);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
