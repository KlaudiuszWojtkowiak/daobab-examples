package io.daobab.example.springboot.blank.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import io.daobab.generator.ClassGenerator;

import javax.sql.DataSource;

//@Configuration
//@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class DaobabCreator {

    private static String IP="localhost";
    private static String PORT="3306";
    private static String USER="root";
    private static String PASS="admin";
   private static String SCHEMA="pizza";

   private static String JAVA_PACKAGE="io.daobab.example.springboot.blank.dao";
   private static String FILE_DIRECTORY_PATH ="C:\\DAOBAB_SRC_FOLDER\\src\\main\\java\\io\\daobab\\example\\springboot\\blank\\dao";



    public static void main(String[] args){
        ClassGenerator cg=new ClassGenerator(mySQLDatabase());
        cg.setSchema(SCHEMA);
        cg.setJavaPackage(JAVA_PACKAGE);
        cg.setFileDirectoryPath(FILE_DIRECTORY_PATH);
        cg.setGenerateTypeScriptClasses(true);

        cg.createTables();

    }

    private static DataSource mySQLDatabase(){

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://"+IP+":"+PORT+"/"+SCHEMA+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false");
        config.setUsername(USER);
        config.setPassword(PASS);
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        config.setSchema(SCHEMA);
        return new HikariDataSource( config );

    }


    private static DataSource oracleDatabase(){
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl( "jdbc:oracle:thin://@IP:PORT/orcl" );
        config.setUsername( USER );
        config.setPassword( PASS );
        config.setDriverClassName("oracle.jdbc.OracleDriver");
        config.setSchema(SCHEMA);
        return new HikariDataSource( config );
    }
}
