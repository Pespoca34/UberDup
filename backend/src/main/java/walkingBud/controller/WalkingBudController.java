package walkingBud.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import walkingBud.api.WalkBudApi;
import walkingBud.entity.dto.WalkingBudCreatedResponse;
import walkingBud.service.WalkingBudService;

@Controller
@RequiredArgsConstructor
public class WalkingBudController implements WalkBudApi {

    private final WalkingBudService walkingBudService;

    @Override
    public ResponseEntity<WalkingBudCreatedResponse> createWalkingBud(@PathVariable String userId){
        try{
            WalkingBudCreatedResponse walkingBudCreatedResponse = walkingBudService.createWalker(userId);
            return ResponseEntity.ok(walkingBudCreatedResponse);
        }catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity<Void> deleteWalkingBud(@PathVariable String walkerId){
        try{
            walkingBudService.deleteWalker(walkerId);
            return ResponseEntity.noContent().build();
        }catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
