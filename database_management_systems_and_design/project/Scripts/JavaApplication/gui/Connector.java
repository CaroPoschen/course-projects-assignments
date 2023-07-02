package gui;

import gui.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Connector {

    private final Connection connection;

    public Connector() throws Exception {
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        connection = this.getConnection();
    }

    public List<SurgeryInstrument> readInstrumentTable()
            throws SQLException {
        try (Connection connection = this.getConnection();
                Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM SURGERY_INSTRUMENT");
             ) {
            List<SurgeryInstrument> list = new ArrayList<>();
            while(resultSet.next()) {
                list.add(new SurgeryInstrument(resultSet.getInt("s_i_id"), resultSet.getInt("person"),
                        resultSet.getInt("surgery"), resultSet.getInt("scalpel"),
                        resultSet.getInt("scissors"), resultSet.getInt("clamps"),
                        resultSet.getInt("surgicalTweezer")));
            }
            return list;
        }
    }

    public List<SurgeryMaterial> readMaterialTable()
            throws SQLException {
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select * from surgery_material")) {
             List<SurgeryMaterial> list = new ArrayList<>();
             while(resultSet.next()) {
                 list.add(new SurgeryMaterial(resultSet.getInt("s_m_id"), resultSet.getInt("person"),
                         resultSet.getInt("surgery"), resultSet.getInt("swab"),
                         resultSet.getInt("bandage"), resultSet.getInt("sutureMaterial"),
                         resultSet.getInt("surgicalMask"), resultSet.getInt("surgicalGlove")));
            }
            return list;
        }
    }

    public InstrumentView readInstrumentView()  throws SQLException {
        try (Connection connection = this.getConnection();
                Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select * from overviewInstrument")) {
            if (resultSet.next()) {
                return new InstrumentView(resultSet.getInt("scalpel"), resultSet.getInt("scissors"),
                        resultSet.getInt("clamps"), resultSet.getInt("surgicalTweezer"));
            }
            return null;
        }
    }

    public MaterialView readMaterialView()  throws SQLException {
        try (Connection connection = this.getConnection();
                Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select * from overviewMaterial")) {
            if (resultSet.next()) {
                return new MaterialView(resultSet.getInt("swap"), resultSet.getInt("bandage"),
                        resultSet.getInt("sutureMaterial"), resultSet.getInt("surgicalMask"),
                        resultSet.getInt("surgicalGlove"));
            }
            return null;
        }
    }

    public List<Surgery> readSurgeryTable() throws SQLException {
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select * from surgery")) {
            List<Surgery> list = new ArrayList<>();
            while(resultSet.next()) {
                list.add(new Surgery(resultSet.getInt("surgery_id"), resultSet.getString("surgery_name"),
                        resultSet.getInt("patient_id")));
            }
            return list;
        }
    }

    public List<MedicalPersonal> readMedicalPersonalTable() throws SQLException {
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select * from medical_personal")) {
            List<MedicalPersonal> list = new ArrayList<>();
            while(resultSet.next()) {
                list.add(new MedicalPersonal(resultSet.getInt("person_id"),
                        resultSet.getString("person_name")));
            }
            return list;
        }
    }

    public void putValue(String table, List<Integer> values) {
        try (Connection connection = this.getConnection();
                Statement statement = connection.createStatement()) {
            String sqlStatement = "Insert into " + table + " values (";
            for(int i = 0; i < values.size() - 1; i++) {
                sqlStatement = sqlStatement + values.get(i) + ", ";
            }
            sqlStatement = sqlStatement + values.get(values.size() - 1) +  ")";
            statement.executeQuery(sqlStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:system", "system", "sys");
    }
}
