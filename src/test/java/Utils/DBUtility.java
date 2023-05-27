package Utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DBUtility {
    static Connection conn=null;
    static Statement statement=null;
    private static ResultSet rset;
    private static ResultSetMetaData rSetMetaData;

    //this method create connection to DB, it will execute the query and return object for resultSet
    public static ResultSet getResultSet(String sqlQuery) {
        try {
            conn = DriverManager.getConnection(ConfigReader.getPropertyValue("urldb"),
                    ConfigReader.getPropertyValue("usernamedb"),
                    ConfigReader.getPropertyValue("passworddb"));
            statement= conn.createStatement();
            rset=statement.executeQuery(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rset;
    }
    //this method will return the object of rsetMetaData
    public static ResultSetMetaData getrSetMetaData(String query){
        rset=getResultSet(query);
        rSetMetaData=null; // once we will have value will provide
        //we use this line to get data in tabular format so that we can use these in column keys and values for retrieval operation

        try {
            rSetMetaData=rset.getMetaData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rSetMetaData;
    }
    //this method is extracting the data which will be stored in the list of maps

    public static List<Map<String,String>>getListOfMapsFromRset(String query){
       rSetMetaData= getrSetMetaData(query);
        List<Map<String,String>>lisfFromRSet=new ArrayList<>();
        try{
        while (rset.next()){
            Map<String,String>map=new LinkedHashMap<>();
            //iterate over columns
            for (int i = 1; i <rSetMetaData.getColumnCount() ; i++) {
                //fetching key and value from the columns
                String key=rSetMetaData.getColumnName(i);
                String value=rset.getString(key);
                map.put(key,value);

            }
            System.out.println(map);
            lisfFromRSet.add(map);
        }

        }catch (SQLException e){
            e.printStackTrace();
        }
        finally { //will return the data in the table format and then close the connection
            DBUtility.closeResultSet(rset);
            DBUtility.closeStatement(statement);
            DBUtility.closeConnection(conn);
        }
        return lisfFromRSet;
    }
    //connection, statement , resultSet
    public static void closeResultSet(ResultSet rset){
        if(rset!=null){
            try {
                rset.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }
    public static void closeStatement(Statement statement){
        if(statement!=null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    public static void closeConnection(Connection conn){
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
