package db;

import db.dao.HouseDAO;
import org.postgresql.ds.PGPoolingDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
public class Main {
    public static DataSource createDataSource() {

        final String url = "localhost";
        final String user = "postgres";
        final String u = "housing organization";
        final String password = "piramida741147";
        Connection conn = null;


        PGPoolingDataSource poolingDataSource = new PGPoolingDataSource();
        poolingDataSource.setDataSourceName("Lab 1 data source");

        poolingDataSource.setServerName(url);
        poolingDataSource.setDatabaseName(u);
        poolingDataSource.setUser(user);
        poolingDataSource.setPassword(password);
        poolingDataSource.setMaxConnections(8);
        poolingDataSource.setInitialConnections(1);
        return poolingDataSource;
    }


    public static void main(String[] args) throws SQLException {
        DataSource dataSource = createDataSource();


        // System.out.println("Hello World! This is lab1 example for java-db course.");
        HouseDAO houseDao = new HouseDAO(dataSource);
//departments_idDAO.insert(4,"Мясникова О.В","Овощи",8124);
        System.out.println("= = = = = house = = = = = =");
        houseDao.list().stream().forEach(house-> System.out.println(String.format("%s (id: %03d) (id: %03d)", house.getAdress(),  house.getId(),house.getRoom_count())));

//
// departments_idDAO.delete(3);
// System.out.println("= = = = = Departments_id delete = = = = = =");
// departments_idDAO.list().stream().forEach(departments_id -> System.out.println(String.format("%s (id: %03d) %s (id: %03d)"

        //System.out.println("= = = = = Order list = = = = = =");
        //+O name_magDAO=new Name_magDAO(dataSource);
//List<name_mag> orders = name_magDAO.list();
// name_magDAO.delete(4);
        //name_magDAO.insert(7,"Рязанская ул,дом №68","Лукашина А.А",4,147487);
        // name_magDAO.list().stream().forEach(name_mag -> System.out.println(String.format("(id: %03d) (id: %03d) %s %s (id: %03d)", name_mag.getname_id(), name_mag.getId(), name_mag.getadress(), name_mag.getseller(),name_mag.getware())));
// name_magDAO.delete(2);


    }
}