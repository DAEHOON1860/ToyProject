package demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity(name = "student")
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String password;

    public Student(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public Student(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
