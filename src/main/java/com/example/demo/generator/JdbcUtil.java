package com.example.demo.generator;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @Describe
 * @Author Corey
 * @Date 2018/7/9.
 */
public class JdbcUtil {

    /**
     * 数据库连接参数
     */
    public static final String JDBC_URL = getProperty("spring.datasource.url");
    public static final String JDBC_USERNAME = getProperty("spring.datasource.username");
    public static final String JDBC_PASSWORD = getProperty("spring.datasource.password");
    public static final String JDBC_DIVER_CLASS_NAME = getProperty("spring.datasource.driver-class-name");
    static {
        try {
            // 初始化JDBC驱动并让驱动加载到jvm中
            Class.forName(JDBC_DIVER_CLASS_NAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static List<String> getTables() {
        Connection conn = getConnection();
        ResultSet rs = null;
        List<String> tables = null;
        try {
            DatabaseMetaData dbmd = conn.getMetaData();

            // 可为:"TABLE", "VIEW", "SYSTEM TABLE",
            // "GLOBAL TEMPORARY", "LOCAL TEMPORARY", "ALIAS", "SYNONYM"
            String[] types = { "TABLE" };
            rs = dbmd.getTables(null, null, null, types);
            tables = new ArrayList<String>();

            while (rs.next()) {

				 /*记录集的结构如下:
			      TABLE_CAT       String   =>   table   catalog   (may   be   null)
			      TABLE_SCHEM   String   =>   table   schema   (may   be   null)
			      TABLE_NAME     String   =>   table   name
			      TABLE_TYPE     String   =>   table   type.
			      REMARKS           String   =>   explanatory   comment   on   the   table
			      TYPE_CAT         String   =>   the   types   catalog   (may   be   null)
			      TYPE_SCHEM     String   =>   the   types   schema   (may   be   null)
			      TYPE_NAME       String   =>   type   name   (may   be   null)
			      SELF_REFERENCING_COL_NAME   String   =>   name   of   the   designated   "identifier"   column   of   a   typed   table   (may   be   null)
			      REF_GENERATION   String   =>   specifies   how   values   in   SELF_REFERENCING_COL_NAME   are   created.   Values   are   "SYSTEM",   "USER",   "DERIVED".   (may   be   null)
			    */

                // 只要表名这一列
                tables.add(rs.getString("TABLE_NAME"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(rs, conn);
        }
        return tables;
    }



    /** 读取配置文件 */
    private static String getProperty(String name) {
        InputStream inputStream = JdbcUtil.class.getResourceAsStream("/config.properties");
        Properties p = new Properties();
        try {
            p.load(inputStream);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return p.getProperty(name);

    }

    /**
     * 连接数据库
     * 设置可获取REMARK备注信息 Properties props =new Properties();
     * props.put("remarksReporting","true"); props.put("user", USER);
     * props.put("password", PASS); conn =DriverManager.getConnection(URL,props);
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            System.out.println(JDBC_URL);
            System.out.println(JDBC_USERNAME);
            System.out.println(JDBC_PASSWORD);
            System.out.println(JDBC_DIVER_CLASS_NAME);
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    /** 关闭连接 */
    public static void close(ResultSet rs, Connection conn) {
        close(rs);
        close(conn);
    }
    /** 关闭连接 */
    public static void close(Object o) {
        if (o == null) {
            return;
        }
        if (o instanceof ResultSet) {
            try {
                ((ResultSet) o).close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (o instanceof Statement) {
            try {
                ((Statement) o).close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (o instanceof Connection) {
            Connection c = (Connection) o;
            try {
                if (!c.isClosed()) {
                    c.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
