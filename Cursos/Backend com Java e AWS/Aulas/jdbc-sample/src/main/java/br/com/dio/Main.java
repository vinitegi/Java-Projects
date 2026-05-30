package br.com.dio;

import br.com.dio.persistence.EmployeeDAO;
import br.com.dio.persistence.entity.EmployeeEntity;
import org.flywaydb.core.Flyway;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class Main {
    private final static EmployeeDAO employeeDAO = new EmployeeDAO();

    public static void main(String[] args) {
        var flyway = Flyway.configure()
                .dataSource("jdbc:mysql://localhost:3306/jdbc_sample",
                        "root",
                        "VALCARVILA132v!")
                .load();
        flyway.migrate();


        var employee2 = new EmployeeEntity();
        employee2.setName("Carlos");
        employee2.setSalary(new BigDecimal("5000"));
        employee2.setDateOfBirth(OffsetDateTime.now().minusYears(20));


        System.out.println(employee2);
        employeeDAO.insert(employee2);
        System.out.println(employee2);

    }
}
