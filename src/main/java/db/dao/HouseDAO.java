package db.dao;

import db.model.House;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class HouseDAO extends AbstractCachingDAO<House> {
    public static final String SELECT_BY_ID = "SELECT * FROM House WHERE number_id = ?";
    public static final String SELECT_ALL = "SELECT * FROM House ORDER BY adress";
    public static final String SELECT_FOR_FILM = "SELECT C.* FROM House c JOIN FILM_CATEGORY FC USING(number_id) WHERE film_id = ?";
    public static final String INSERT = "INSERT INTO House (adress) VALUES(?)";
    public static final String UPDATE = "UPDATE House SET adress = ? WHERE number_id = ?";
    public static final String DELETE = "DELETE FROM House WHERE number_id = ?";

    public HouseDAO(DataSource dataSource) {
        super(dataSource, SELECT_ALL, SELECT_BY_ID, INSERT, UPDATE, DELETE);
    }

    @Override
    public House readObject(ResultSet rs) throws SQLException {
        House s = new House();
        s.setId(rs.getLong("number_id"));
        s.setAdress(rs.getString("adress"));
        s.setRoom_count(rs.getLong("room_count"));
        return s;
    }

    @Override
    protected int writeObject(House obj, PreparedStatement ps, int idx) throws SQLException {
        ps.setString(idx++, obj.getAdress());
        return idx;
    }


}