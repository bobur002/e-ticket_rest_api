package uz.pdp.eticket_rest_api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.eticket_model.dto.receive.TrainReceiveDTO;
import uz.pdp.eticket_rest_api.repository.noSql.TrainRepository;
import uz.pdp.eticket_rest_api.service.TrainService;

@RestController
@RequestMapping("admin/train")
@RequiredArgsConstructor
public class TrainController {

    private  final TrainService trainService;

    @PostMapping("/add")
    public ResponseEntity<Object> addTrain(
            @RequestBody TrainReceiveDTO trainReceiveDTO
    ){
        System.out.println("uraaa");
        return ResponseEntity.ok(trainService.addTrain(trainReceiveDTO));
    }
}
