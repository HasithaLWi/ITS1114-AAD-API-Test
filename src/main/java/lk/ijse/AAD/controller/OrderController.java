package lk.ijse.AAD.controller;

import lk.ijse.AAD.dto.OrderDTO;
import lk.ijse.AAD.dto.OrderSaveDTO;
import lk.ijse.AAD.service.OrderService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "v1/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public OrderDTO saveCustomer(@RequestBody OrderSaveDTO orderSaveDTO) {
        return orderService.saveOrder(orderSaveDTO);
    }
}
