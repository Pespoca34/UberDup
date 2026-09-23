package uberDup.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uberDup.entity.DriverProfileEntity;

public interface DriverRepository extends JpaRepository<DriverProfileEntity, String> {
}
