package in.quiqua.service.impl;

import in.quiqua.dao.Employee;
import in.quiqua.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public Employee getEmployeeById(long id) {

        Employee employee = null;

        //Here goes your db connector which is not really important to us since we will be mocking it out
        //Hence we are putting dummy condition here to write our tests
        if (id == 1L) {
            employee = Employee.builder()
                    .id(1L)
                    .name("Pratyush")
                    .level(1)
                    .role("FTE")
                    .build();
        } else {
            employee = Employee.builder().build();
        }
        return employee;
    }
}
