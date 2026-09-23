package uberDup.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uberDup.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
