package uz.pdp.eticket_rest_api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.eticket_model.dto.receive.CarReceiveDTO;
import uz.pdp.eticket_rest_api.service.CarService;

import javax.validation.Valid;

@RestController
@RequestMapping("/admin/car")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @PostMapping("/add")
    public ResponseEntity<Object> addCar(
            @RequestBody CarReceiveDTO carReceiveDTO
    ){
        System.out.println("uraaaaaaa");
        return ResponseEntity.ok(carService.addCar(carReceiveDTO));
    }
}
