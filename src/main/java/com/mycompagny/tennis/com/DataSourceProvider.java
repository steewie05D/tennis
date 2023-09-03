package com.mycompagny.tennis.com;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;

public class DataSourceProvider {
    private static BasicDataSource singleDataSource;

    public static DataSource getSingleDataSourceInstance() {
        // on a besoin data source on passe par cette methode static
        if (singleDataSource == null) ;
        {
            singleDataSource  = new BasicDataSource();
            singleDataSource.setUrl("jdbc:mysql://localhost:3306/tennis?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=Europe/Paris");
            //   dataSource.setInitialSize(5);
            singleDataSource.setUsername("root");
            singleDataSource.setPassword("root");
        }
        return singleDataSource;
    }

}