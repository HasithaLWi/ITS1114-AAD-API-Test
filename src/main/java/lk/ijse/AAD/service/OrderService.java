package lk.ijse.AAD.service;


import lk.ijse.AAD.dto.OrderDTO;
import lk.ijse.AAD.dto.OrderSaveDTO;

public interface OrderService {
    OrderDTO saveOrder(OrderDTO orderDTO);
    OrderDTO saveOrder(OrderSaveDTO orderSaveDTO);
}
