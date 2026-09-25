package walkingBud.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import walkingBud.api.UserApi;
import walkingBud.entity.dto.UserCreateRequest;
import walkingBud.entity.dto.UserCreatedResponse;
import walkingBud.entity.dto.UserData;
import walkingBud.service.UserService;

@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {

    private final UserService userService;

    public ResponseEntity<UserCreatedResponse> createUser(@RequestBody UserCreateRequest newUser){

        try{
            UserCreatedResponse newUserInfo = userService.createUser(newUser);
            return ResponseEntity.ok(newUserInfo);
        }catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity<UserData> getUserData(@PathVariable String userId){
        try{
            UserData userData = userService.userData(userId);
            return ResponseEntity.ok(userData);
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Void> deleteUser(@PathVariable String userId){
        try{
            userService.userDelete(userId);
            return ResponseEntity.noContent().build();
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
