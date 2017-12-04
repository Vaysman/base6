package db.web;

import db.dao.HouseDAO;
import org.postgresql.ds.PGPoolingDataSource;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener()
public class DbInitListener implements ServletContextListener {

    // Public constructor is required by servlet spec
    public DbInitListener() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().log("Initializing data source connection");

        PGPoolingDataSource poolingDataSource = new PGPoolingDataSource();
        poolingDataSource.setDataSourceName("Lab 2 data source");

        poolingDataSource.setServerName("localhost");
        poolingDataSource.setDatabaseName("housing organization");
        poolingDataSource.setUser("postgres");
        poolingDataSource.setPassword("piramida741147");
        poolingDataSource.setMaxConnections(8);
        poolingDataSource.setInitialConnections(1);



       HouseDAO houseDAO = new HouseDAO(poolingDataSource);


        sce.getServletContext().setAttribute("houseDAO", houseDAO);

        sce.getServletContext().setAttribute("datasource", poolingDataSource);

        sce.getServletContext().log("Initialized all DAOs");
    }

    public void contextDestroyed(ServletContextEvent sce) {
        sce.getServletContext().log("Closing connections pool");

        PGPoolingDataSource poolingDataSource = (PGPoolingDataSource) sce.getServletContext().getAttribute("datasource");
        poolingDataSource.close();

    }
}