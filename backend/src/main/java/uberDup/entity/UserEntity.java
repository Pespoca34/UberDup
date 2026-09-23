package uberDup.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import uberDup.entity.dto.Habitation;

import java.util.Date;

@Entity
@Table(name = "user_info")
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Column(unique = true)
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(unique = true)
    @NotBlank
    private String email;

    @Column(nullable = false)
    @NotBlank
    private String password;

    @Column(nullable = false)
    @NotBlank
    private String name;

    private Habitation address;

    @Column(nullable = true)
    @Nullable
    private Character sex;

    @Column(nullable = true)
    @Nullable
    @CreatedDate
    private Date createdAt;
}
