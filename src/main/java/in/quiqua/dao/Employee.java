package in.quiqua.dao;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Builder
@Data
public class Employee {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int level;
    private String role;
    private long salary;
}
