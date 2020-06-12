package jdbcTest;

import java.sql.*;

public class JDBCTest {
    public static void main(String[] args) throws SQLException {

        // JDBC用到的三个接口
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        // 数据连接的配置
        String url = "jdbc:mysql://127.0.0.1:3306/test";
        String userName = "root";
        String passWord = "QFIZsy_gNEcd8wAeHV8t9vXgB1AN_ruH";


        try {

            // 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 建立连接
            connection = DriverManager.getConnection(url, userName, passWord);
            String sql = "select * from tb_user where  id = ? ";

            // 创建preparedStatement
            preparedStatement = connection.prepareStatement(sql);

            // 设置参数
            preparedStatement.setLong(1, 1);

            // 返回执行结果的对象
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getString("id"));
                System.out.println(resultSet.getString("user_name"));
                System.out.println(resultSet.getString("name"));

            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
