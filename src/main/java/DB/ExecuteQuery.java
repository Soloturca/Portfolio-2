package DB;

import base.AutomationConstants;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteQuery extends DataBase {
    public ExecuteQuery(HashMapNew dictionary, DBType oDBType) {
        super(dictionary, oDBType);
    }


    public ResultSet getRedBoxMSISDN() {
        ResultSet rs = null;
        try {
            String query = "select * from Red_Package_MSISDN where Status='Y' AND ROWNUM <2";
            Statement stmt = DataBaseConn(AutomationConstants.connectionString);
            //MyTestNGBaseClass.allureReport("", "Connected to Oracle database!", false);
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet updateStatusOfMSISDN() {
        ResultSet rs = null;
        try {
            String updateQuery = "update Red_Package_MSISDN set Status='N' where MSISDN='" + AutomationConstants.msisdn + "'";
            Statement stmt = DataBaseConn(AutomationConstants.connectionString);
            //MyTestNGBaseClass.allureReport("", "Updated to Oracle database!", false);
            rs = stmt.executeQuery(updateQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet commitMSISDN() {
        ResultSet rs = null;
        try {
            String commit = "commit";
            Statement stmt = DataBaseConn(AutomationConstants.connectionString);
            rs = stmt.executeQuery(commit);
            //MyTestNGBaseClass.allureReport("", "Commited to Oracle database!", false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

}




