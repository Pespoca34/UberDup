package uberDup.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uberDup.api.UserApi;
import uberDup.entity.dto.UserCreateRequest;
import uberDup.entity.dto.UserInfo;
import uberDup.service.UserService;

@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {

    private final UserService userService;

    @Override
    public ResponseEntity<UserInfo> createUser(@RequestBody UserCreateRequest user){
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<UserInfo> getUserInfo(@PathVariable String userId){
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> deleteUser(@PathVariable String userId){
        return ResponseEntity.ok().build();
    }
}
