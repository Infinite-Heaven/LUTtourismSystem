package lut.luttourismsystem.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "user")
@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int userId;

    String name;
    String psw;

}
