package com.lh.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lh.dao.UserMapper;
import com.lh.entity.User;
import com.lh.entity.UserExample;
import com.lh.service.UserService;
import com.lh.vo.DataVo;
import com.lh.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 用户的增、删、改、查
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public ResultVo getList(Integer pageNum, Integer pageSize, Long id) {
        //返回给前端的结果
        ResultVo resultVo;
        //分页相关的参数
        DataVo<User> userDataVo;
        // 结果中data对应的用户数组
        List<User> users;
        //如果说传递了Id,那就是findById
        if (id != null) {
            users = new ArrayList<>();
            //查询
            User user = userMapper.selectByPrimaryKey(id);

            //没有查到用户的情况
            if (user == null) {

                userDataVo = new DataVo<>(0L, users, pageNum, pageSize);

                resultVo = new ResultVo(4000, "查无此人", false, userDataVo);
            } else {
                //查到了用户扔到集合中
                users.add(user);
                userDataVo = new DataVo<>(1L, users, pageNum, pageSize);

                resultVo = new ResultVo(1000, "查到了该用户!", true, userDataVo);
            }
        } else {
            //开启分页
            PageHelper.startPage(pageNum, pageSize);
            //查询到多条数据封装到List集合
            users = userMapper.selectByExample(null);
            //如果数据库是空的，一个人都没查到
            if (users.size() == 0) {
                userDataVo = new DataVo<>(0L, users, pageNum, pageSize);

                resultVo = new ResultVo(41000, "没有用户！！！", false, userDataVo);
                //查到了
            } else {

                //拿到数据总数
                PageInfo<User> info = new PageInfo<>(users);
                //封装数据到对象
                userDataVo = new DataVo<>(info.getTotal(), users, pageNum, pageSize);
                //封装数据到对象
                resultVo = new ResultVo(1100, "查询用户信息成功", true, userDataVo);
            }

        }
        return resultVo;
    }

    @Override
    public ResultVo add(User user) {
        ResultVo vo;
//判断是否存在创建时间，没有自己加上
        if (user.getCreateTime()==null){
            user.setCreateTime(new Date());
        }
        int affectedRows = userMapper.insertSelective(user);

        if (affectedRows>0){
            vo=new ResultVo(1000,"添加用户成功",true,user);
        }else {
            vo=new ResultVo(5000,"添加用户失败",false,null);

        }
        return vo;
    }

    @Override
    public ResultVo update(User user) {
        int affectedRows = userMapper.updateByPrimaryKeySelective(user);
        ResultVo vo;
        if (affectedRows>0){
//            修改完成后，再重新查询一次，保证返回给前端的是修改后的结果
            user=userMapper.selectByPrimaryKey(user.getId());

            vo=new ResultVo(1000,"修改用户成功",true,user);
        }else {
            vo=new ResultVo(5000,"修改用户失败",false,null);

        }
        return vo;
    }

    @Override
    public ResultVo delete(long id) {
        int affectedRows = userMapper.deleteByPrimaryKey(id);
        ResultVo vo;

        if (affectedRows>0){
//

            vo=new ResultVo(1000,"删除用户成功",true,null);
        }else {
            vo=new ResultVo(5000,"删除用户失败",false,null);

        }
        return vo;
    }

    @Override
    public ResultVo login(String username, String password) {
        ResultVo vo = new ResultVo();

        vo.setCode(-1);
        vo.setMessage("登录失败，当前用户名不存在");
        vo.setSuccess(false);
        vo.setData(null);

        UserExample example = new UserExample();

        UserExample.Criteria criteria = example.createCriteria();

        criteria.andUsernameEqualTo(username);

        List<User> users = userMapper.selectByExample(example);

        // 能查出来说明用户名是存在的
        if (users.size() > 0) {
            User user = users.get(0);

            // 如果密码相同
            if (user.getPassword().equals(password)) {
                vo.setSuccess(true);
                vo.setMessage("登录成功！");
                vo.setCode(200);

                // 密码不要传给前端
                user.setPassword(null);

                // token - json web token

                // 盐值的存储应该存到缓存服务器中-Redis
                // 可以把盐值作为载荷直接发送给前端，每次我们获取到token后对其进行解析
                // 其实这是很不安全的，但是没办法，暂时这样用
                // 盐值
                String salt = String.valueOf((int) ((Math.random() * 9 + 1) * 100000));

                // 头部
                Map<String, Object> headers = new HashMap<>();

                headers.put("alg", "HS256");
                headers.put("typ", "JWT");

                // 获取token
                String token = JWT.create()
                        .withHeader(headers)
                        // 主题
                        .withSubject("登录权限验证")
                        // 签发人
                        .withIssuer("admin")
                        // 签发日期
                        .withIssuedAt(new Date())
                        // 过期时间
                        // 设置稍微长一点，后面有机会讲token续签的时候再改
                        .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 30))
                        .withClaim("id", user.getId())
                        .withClaim("username", username)
                        .withClaim("salt", salt)
                        // 使用盐值进行签发生成jwt
                        .sign(Algorithm.HMAC256(salt));

                Map<String, Object> result = new HashMap<>();

                result.put("user", user);
                result.put("token", token);

                vo.setData(result);
            } else {
                vo.setCode(-2);
                vo.setMessage("登录失败，请输入正确的密码");
            }
        }

        return vo;
    }
















}
