package case_study_module4.furama_resort_manager.model.entity.employee;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Degree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    //1 trinh do thi co nhieu nhan vien
    @OneToMany(mappedBy = "degree")
    private Set<Employee> employees;

    public Degree() {
    }

    public Degree(int id, String name, Set<Employee> employees) {
        this.id = id;
        this.name = name;
        this.employees = employees;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
