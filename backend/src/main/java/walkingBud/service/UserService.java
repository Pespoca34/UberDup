package walkingBud.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import walkingBud.entity.UserEntity;
import walkingBud.entity.dto.UserCreateRequest;
import walkingBud.entity.dto.UserCreatedResponse;
import walkingBud.entity.dto.UserData;
import walkingBud.entity.repository.UserRepository;
import walkingBud.exceptions.AlreadyExistUser;
import walkingBud.exceptions.UserDontExistException;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserCreatedResponse createUser(UserCreateRequest newUser) {

        UserEntity userEntity = userRepository.findByEmail(newUser.getEmail()).orElse(null);
        //check if user already exists
        if(userEntity == null){
            throw new AlreadyExistUser();
        }

        // if not exists create new user
        userEntity.setEmail(newUser.getEmail());
        userEntity.setPassword(newUser.getPassword());
        userEntity.setName(newUser.getName());
        userEntity.setAddress(newUser.getResidence());
        userEntity.setSex(newUser.getSex());
        userEntity.setAge(newUser.getAge());
        userEntity.setCreatedAt(new Date());
        userRepository.save(userEntity);

        return new UserCreatedResponse()
                .id(userEntity.getId())
                .email(newUser.getEmail());
    }

    public UserData userData(String userId) {

        UserEntity userEntity = userRepository.findById(userId).orElse(null);

        if(userEntity == null){
            throw new UserDontExistException();
        }

        return new UserData()
                .email(userEntity.getEmail())
                .name(userEntity.getName())
                .residence(userEntity.getAddress())
                .sex(userEntity.getSex())
                .age(userEntity.getAge());
    }

    public void userDelete(String userId) {

        if(!userRepository.existsById(userId)){
            throw new UserDontExistException();
        }
        userRepository.deleteById(userId);
    }
}
