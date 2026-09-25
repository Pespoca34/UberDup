package walkingBud.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import walkingBud.entity.WalkingBudEntity;

@Repository
public interface WalkingBudRepository extends JpaRepository<WalkingBudEntity, String> {
}
