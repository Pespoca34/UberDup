package walkingBud.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import walkingBud.entity.dto.Sex;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="walker_info")
public class WalkingBudEntity {

    @Column(nullable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private String id;

    @OneToOne
    @JoinColumn(name="user_id", nullable=false, unique=true)
    private UserEntity user;
}
