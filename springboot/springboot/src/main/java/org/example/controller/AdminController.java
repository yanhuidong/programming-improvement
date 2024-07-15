package org.example.controller;

import com.github.pagehelper.PageInfo;
import org.example.common.Result;
import org.example.entity.Admin;
import org.example.entity.Params;
import org.example.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController {

    private static final Logger log = LoggerFactory.getLogger(AdminController.class);

    @Resource
    private AdminService adminService;

    @GetMapping
    public Result findAll() {
        List<Admin> list = adminService.findAll();
        return Result.success(list);
    }

    @GetMapping("/search")
    public Result findBySearch(Params params) {
        log.info("拦截器已放行,正式调用接口,查询管理员信息");
        PageInfo<Admin> info = adminService.findBySearch(params);
        return Result.success(info);
    }

    @PostMapping("/selfexcept")
    public Result save1(@RequestBody Admin admin){
        if(admin.getId() == null){
            adminService.add(admin);
        }else {
            adminService.update1(admin);
        }
        return Result.success();
    }

    @PostMapping
    public Result save(@RequestBody Admin admin){
        if(admin.getId() == null){
            adminService.add(admin);
        }else {
            adminService.update(admin);
        }
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        adminService.delete(id);
        return Result.success();
    }

    @PostMapping("/login")
    public Result login(@RequestBody Admin admin) {
        Admin loginUser = adminService.login(admin);
        return Result.success(loginUser);
    }

    @PostMapping("/register")
    public Result register(@RequestBody Admin admin) {
        adminService.add(admin);
        return Result.success();
    }
}

