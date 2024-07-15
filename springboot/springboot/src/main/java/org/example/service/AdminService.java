package org.example.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.example.common.JwtTokenUtils;
import org.example.dao.AdminDao;
import org.example.entity.Admin;
import org.example.entity.Params;
import org.example.exception.CustomException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminService {

    @Resource
    private AdminDao adminDao;

    public List<Admin> findAll() {
        return adminDao.getUser();
    }

    public PageInfo<Admin> findBySearch(Params params) {
        PageHelper.startPage(params.getPageNum(), params.getPageSize());
        List<Admin> list = adminDao.findBySearch(params);
        return PageInfo.of(list);
    }

    public void add(Admin admin) {
        if(admin.getName()==null || "".equals(admin.getName())){
            throw new CustomException("用户名不能为空");
        }

        Admin user = adminDao.findByName(admin.getName());
        if(user!=null){
            throw new CustomException("该用户名已存在，请更换用户名");
        }

        if(admin.getPassword()==null){
            admin.setPassword("123456");
        }
        adminDao.insertSelective(admin);
    }

    public void update(Admin admin) {
        Admin user = adminDao.findByName(admin.getName());
        if(user!=null){
            throw new CustomException("该用户名已存在，请更换用户名");
        }

        if(admin.getName()==null || "".equals(admin.getName())){
            throw new CustomException("用户名不能为空");
        }
        adminDao.updateByPrimaryKeySelective(admin);
    }

    public void update1(Admin admin) {
        if(admin.getName()==null || "".equals(admin.getName())){
            throw new CustomException("用户名不能为空");
        }
        adminDao.updateByPrimaryKeySelective(admin);
    }

    public void delete(Integer id) {
        adminDao.deleteByPrimaryKey(id);
    }

    public Admin login(Admin admin) {
        if(admin.getName()==null || "".equals(admin.getName())){
            throw new CustomException("用户名不能为空");
        }
        if(admin.getPassword()==null || "".equals(admin.getPassword())){
            throw new CustomException("密码不能为空");
        }

        Admin user = adminDao.findByNameAndPassowrd(admin.getName(),admin.getPassword());
        if(user==null){
            throw new CustomException("用户名或密码输入错误");
        }
        String token = JwtTokenUtils.genToken(user.getId().toString(),user.getPassword());
        user.setToken(token);
        return user;
    }

    public Admin findById(Integer id) {
        return adminDao.selectByPrimaryKey(id);

    }
}
