package in.quiqua;

import in.quiqua.dao.Employee;
import in.quiqua.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class EmployeeControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @Test
    public void shouldReturnEmployeeIfExists() throws Exception {

        Employee employee = Employee.builder()
                .id(1L)
                .name("quiqua")
                .salary(10000)
                .build();

        Mockito.when(employeeService.getEmployeeById(1)).thenReturn(employee);

        this.mockMvc.perform(get("/employee/1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id")
                        .value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name")
                        .value("quiqua"));
    }

    @Test
    public void shouldThrowEmployeeDoesNotExistExceptionWhenNoEmployeeExists() throws Exception {

        Employee employee = Employee.builder().build();
        Mockito.when(employeeService.getEmployeeById(1)).thenReturn(employee);

        this.mockMvc.perform(get("/employee/1"))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().string(""));
    }
}
