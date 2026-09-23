package uberDup.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import uberDup.entity.dto.DriverStatus;

@Entity
@Table(name = "driver_profiles")
@AllArgsConstructor
@NoArgsConstructor
public class DriverProfileEntity {

    @Column(unique = true)
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @OneToOne(optional = false)
    @NotBlank
    private UserEntity user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @NotBlank
    private DriverStatus status;
}
