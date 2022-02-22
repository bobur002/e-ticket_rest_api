package uz.pdp.eticket_rest_api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.eticket_model.dto.receive.CarReceiveDTO;
import uz.pdp.eticket_rest_api.service.CarService;



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
    @GetMapping("/types")
    public ResponseEntity<Object> getCarTypes(){
        System.out.println("uraaaaaaa");
        return ResponseEntity.ok(carService.getCarTypes());
    }

    @GetMapping("/list")
    public ResponseEntity<Object> getCarList(){
        System.out.println("uraaaaaaa");
        return ResponseEntity.ok(carService.getCarList());
    }
}
