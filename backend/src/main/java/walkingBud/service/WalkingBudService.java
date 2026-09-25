package walkingBud.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import walkingBud.entity.UserEntity;
import walkingBud.entity.WalkingBudEntity;
import walkingBud.entity.dto.WalkingBudCreatedResponse;
import walkingBud.entity.repository.UserRepository;
import walkingBud.entity.repository.WalkingBudRepository;
import walkingBud.exceptions.UserDontExistException;
import walkingBud.exceptions.WalkerDontExistsException;

@Service
@RequiredArgsConstructor
public class WalkingBudService {

    private final WalkingBudRepository walkingBudRepository;
    private final UserRepository userRepository;

    public WalkingBudCreatedResponse createWalker(String userId) {

        UserEntity user = userRepository.findById(userId).orElseThrow(
                UserDontExistException::new
        );

        WalkingBudEntity walker = new WalkingBudEntity();
        walker.setUser(user);

        walkingBudRepository.save(walker);

        return new WalkingBudCreatedResponse()
                .walkerId(walker.getId())
                .name(walker.getUser().getName());
    }

    public void deleteWalker(String walkerId) {
        if(!walkingBudRepository.existsById(walkerId)){
            throw new WalkerDontExistsException();
        }
        walkingBudRepository.deleteById(walkerId);
    }
}
