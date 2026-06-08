package lk.ijse.AAD.controller;

import lk.ijse.AAD.constant.CommonResponse;
import lk.ijse.AAD.dto.UsersDTO;
import lk.ijse.AAD.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static lk.ijse.AAD.constant.ResponseMassage.SUCCESS_MESSAGE;
import static lk.ijse.AAD.constant.ResponseStatusCode.OPERATION_SUCCESS;

@RestController
@RequestMapping(value = "v1/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {

        this.userService = userService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse saveUser(@RequestBody UsersDTO userDTO) {

         userService.saveUser(userDTO);

         return new CommonResponse(OPERATION_SUCCESS,SUCCESS_MESSAGE);

    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UsersDTO> getUsers() {
        return userService.getUsers();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/user-details/{id}")
    public UsersDTO getUserDetails(@PathVariable long id) {
        return userService.getUserDetails(id);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/update")
    public UsersDTO updateUser(@RequestBody UsersDTO usersDTO) {
        return userService.updateUser(usersDTO);
    }

    @PatchMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/update-status")
    public String updateUserStatus(@RequestBody UsersDTO usersDTO) {
        userService.updateUserStatus(usersDTO);
        return "User status update successfully";
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE,value = "/delete/{id}")
    public String deleteDepartment(@PathVariable long id) {
        userService.deleteUser(id);
        return "User delete successfully";
    }
    @GetMapping (produces = MediaType.APPLICATION_JSON_VALUE, value = "/filter")
    public List<UsersDTO> getUserByName(@RequestParam(value = "firstName", required = true) String firstName, @RequestParam(value = "lastName", required = true) String lastName) {
        return userService.getUserByName(firstName, lastName);
    }
}
