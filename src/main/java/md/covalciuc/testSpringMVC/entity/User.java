package md.covalciuc.testSpringMVC.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Objects;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users",schema = "public")
public class User {
    @Id
    private String username;
    private String firstname;
    private String lastname;
    @Column(name = "birth_date")
    private LocalDate birth_date;
    private Integer age;


}
