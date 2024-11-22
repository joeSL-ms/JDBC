package Model;

import com.mysql.jdbc.Connection;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public class DB {
    private String username;
    private String database;
    private String password;
    private String servername;
    private Connection conexion;
    private Statement ejecutor;
    private boolean connect;


    public DB(String username, String database, String password, String servername) {
        this.username = username;
        this.database = database;
        this.password = password;
        this.servername = servername;
        this.conexion = null;
        this.ejecutor = null;
    }

    public DB(String username, String database, String password) {
        this.username = username;
        this.database = database;
        this.password = password;
        this.servername = "localhost";
        this.conexion = null;
        this.ejecutor = null;
    }

    public Statement getEjecutor() {
        return ejecutor;
    }

    public void setEjecutor(Statement ejecutor) {
        this.ejecutor = ejecutor;
    }

    public boolean isConnect() {
        return connect;
    }

    public void setConnect(boolean connect) {
        this.connect = connect;
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(java.sql.Connection conexion) {
        this.conexion = (Connection) conexion;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getServername() {
        return servername;
    }

    public void setServername(String servername) {
        this.servername = servername;
    }

    @Override
    public String toString() {
        return "DB{" +
                "username='" + username + '\'' +
                ", database='" + database + '\'' +
                ", password='" + password + '\'' +
                ", servername='" + servername + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DB db = (DB) o;
        return Objects.equals(getUsername(), db.getUsername()) && Objects.equals(getDatabase(), db.getDatabase()) && Objects.equals(getPassword(), db.getPassword()) && Objects.equals(getServername(), db.getServername());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsername(), getDatabase(), getPassword(), getServername());
    }

    //Connection to database
    public void connection() throws SQLException {
        try {
            //conectar con la base de datos
            Class.forName("com.mysql.jdbc.Driver");
            setConexion(DriverManager.getConnection("jdbc:mysql://" + getServername() + "/" + getDatabase(),
                    getUsername(), getPassword()));
            initStatement();
            setConnect(true);
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println("No se ha podido conectar a la base de datos");
            ;
        }
    }


    //Method witch main function is establish an activity with database, example: queries,update,delete,inserts
    private void initStatement() {
        try {
            if (conexion == null || conexion.isClosed()) {
                throw new SQLException("No hay conexión activa a la base de datos.");
            } else {
                ejecutor = conexion.createStatement();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void udiTables(String sql) {
        try {
            getEjecutor().executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //This method is specific to do consults
    public ArrayList<String> consult(String sql) throws SQLException {
        ArrayList<String> datos = new ArrayList<>();
        ResultSet rs = null;
        try {
            rs = ejecutor.executeQuery(sql);
            if (rs.getFetchSize() > 1) {
                datos.add(rs.getString("doctor"));
            } else {
                while (rs.next()) {
                    datos.add(rs.getString("doctor"));
                }
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return datos;
    }

    public ArrayList<List<String>> extracDataFromTable(String table) {
        ArrayList<List<String>> datos = new ArrayList<>();
        String[] lista;
        ResultSet rs = null;
        List<String> columns = getColumans(table); // Guardamos las columnas en una variable
        int size = columns.size();
        try {
            rs = ejecutor.executeQuery("SELECT * FROM " + table + ";");
            while (rs.next()) {
                lista = new String[size];
                for (int i = 0; i < size; i++) {
                    lista[i] = rs.getString(columns.get(i)); // Usamos columns directamente
                }
                datos.add(new ArrayList<>(Arrays.asList(lista))); // Usamos una lista mutable
            }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            if (rs != null) {
                try {
                    rs.close(); // Asegúrate de cerrar el ResultSet
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return datos;
    }

    //this method just only use to get a name of columns of the table,
    // reuse the main function(consult) but adding a new action.
    public ArrayList<String> getColumans(String tabla) {
        int nColumns;
        ArrayList<String> columns = new ArrayList<>();
        String columnsData;
        try {
            ResultSet rs = ejecutor.executeQuery("SELECT * from " + tabla);
            ResultSetMetaData metaDatos = rs.getMetaData();
            nColumns = metaDatos.getColumnCount();
            for (int i = 1; i <= nColumns; i++) {
                columns.add(metaDatos.getColumnName(i));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return columns;
    }

    public ArrayList<String> getTables() {
        ArrayList<String> tables = new ArrayList<>();
        try {
            ResultSet rs = ejecutor.executeQuery("SHOW TABLES");
            ResultSetMetaData metaData = rs.getMetaData();

            while (rs.next()) {
                String tableName = rs.getString(1);
                tables.add(tableName);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tables;
    }

    public void closeConnection() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                System.out.println("Conexión cerrada correctamente.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
/*
"adminphp
morcilla01
adminphp"*/