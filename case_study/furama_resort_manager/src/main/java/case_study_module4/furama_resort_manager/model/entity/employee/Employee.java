package case_study_module4.furama_resort_manager.model.entity.employee;

import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String dOB;
    private String identityNumber;
    private double salary;
    private String phoneNumber;
    private String email;
    private String address;

    @OneToOne(cascade = CascadeType.ALL)
    //tao 1 column user_id trong bang employee tham chieu den khoa chinh cua table user
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;

    @ManyToOne(targetEntity = Division.class)
    //tao 1 column division_id trong bang employee tham chieu den khoa chinh cua table Division
    @JoinColumn(name = "division_id",referencedColumnName = "id")
    private Division division;

    @ManyToOne(targetEntity = Position.class)
    //tao 1 column position_id trong bang employee tham chieu den khoa chinh cua table Position
    @JoinColumn(name = "position_id",referencedColumnName = "id")
    private Position position;

    @ManyToOne(targetEntity = Degree.class)
    //tao 1 column degree_id trong bang employee tham chieu den khoa chinh cua table Degree
    @JoinColumn(name = "degree_id",referencedColumnName = "id")
    private Degree degree;

    public Employee() {
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

    public String getdOB() {
        return dOB;
    }

    public void setdOB(String dOB) {
        this.dOB = dOB;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }
}
