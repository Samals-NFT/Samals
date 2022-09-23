package com.project.samals.controller;

import com.project.samals.dto.NftDto;
import com.project.samals.dto.request.ReqUserDto;
import com.project.samals.dto.SaleDto;
import com.project.samals.dto.UserDto;
import com.project.samals.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
@Api(tags={"사용자 API"})
public class UserController {

    private final UserService userService;


    @ApiOperation(value = "회원 등록")
    @PostMapping("/signup")
    public ResponseEntity<UserDto> signup(@RequestBody ReqUserDto userDto) {
        return new ResponseEntity<>(userService.signup(userDto), HttpStatus.CREATED);
    }

    @ApiOperation(value = "회원 정보 조회")
    @GetMapping("/{address}")
    public ResponseEntity<UserDto> getUserInfo(@PathVariable String address) {
        return new ResponseEntity<>(userService.getUserInfo(address), HttpStatus.OK);
    }

    @ApiOperation(value = "회원 탈퇴")
    @DeleteMapping("/{address}")
    public ResponseEntity<String> withdrawal(@PathVariable String address) {
        return new ResponseEntity<>(userService.withdrawal(address), HttpStatus.OK);
    }

    @ApiOperation(value = "회원 정보 수정")
    @PutMapping("/update")
    public ResponseEntity<UserDto> updateUser(@RequestBody ReqUserDto userDto) {
        return new ResponseEntity<>(userService.updateUser(userDto), HttpStatus.OK);
    }


}