package com.schoolproject.rmats;

import com.schoolproject.rmats.DB.Dao.JdbcDaoImpl;
import com.schoolproject.rmats.DB.Dao.Alian;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RmatsApplication {

    public static void main(String[] args) {

        SpringApplication.run(RmatsApplication.class, args);

        Alian alian = new JdbcDaoImpl().getAlian(3);
        System.out.println(alian.getUserName() + " and his id is: " + alian.getUserId());
    }

}
