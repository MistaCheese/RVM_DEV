package SQL

import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.Statement
import java.util.*


class DB {
    private val url: String = "jdbc:postgresql://192.168.0.17:5432/rwminvest"
    private fun connect(): Connection {

        val props = Properties()
        props.setProperty("user", "rwminvest")
        props.setProperty("password", "Pjiwn8&2hdbPq)")
        return DriverManager.getConnection(url, props)
    }

    fun getID(selectText: String, tableName: String, whereText: String): String {
        val st: Statement = connect().createStatement()
        val rs = st.executeQuery("SELECT $selectText FROM $tableName WHERE $whereText")
        var id: String = ""
        while (rs.next()) {
            id = rs.getString(1)
        }
        rs.close()
        st.close()
        return id
    }

    fun delDocFromUser(userID: String): Int {
        val st: Statement = connect().createStatement()
        val rowsDell: Int = st.executeUpdate("DELETE FROM doc WHERE user_id =\'$userID\'")
        st.close()
        return rowsDell
    }


}