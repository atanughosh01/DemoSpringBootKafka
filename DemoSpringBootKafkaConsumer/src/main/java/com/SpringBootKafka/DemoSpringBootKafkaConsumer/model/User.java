package com.SpringBootKafka.DemoSpringBootKafkaConsumer.model;

// Model class for User
public class User {

    // Attributes
    private String name;
    private String dept;
    private Long salary;

    // Empty Constructor
    public User() {}

    // Overloaded Constructor
    public User(String name, String dept, Long salary) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    // Overridden toString method
    @Override
    public String toString() {
        // final StringBuffer sb = new StringBuffer("User{");
        final StringBuffer sb = new StringBuffer("{");
        sb.append("name:'").append(name).append('\'');
        sb.append(", dept:'").append(dept).append('\'');
        sb.append(", salary:").append(salary);
        sb.append('}');
        return sb.toString();
    }
}
