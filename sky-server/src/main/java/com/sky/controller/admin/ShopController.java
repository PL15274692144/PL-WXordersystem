package com.sky.controller.admin;

import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController("adminShopController")
@Slf4j
@RequestMapping("/admin/shop")
@Api(tags = "店铺相关接口")
public class ShopController {

    private static final String key="SHOP_STATUS";

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 设置店铺的营业状态
     * @param status
     * @return
     */
    @PutMapping("/{status}")
    @ApiOperation("设置店铺的营业状态")
    public Result SetStatus(@PathVariable("status") Integer status){
        log.info("设置营业状态为：{}",status == 1 ? "营业中":"打烊中");
        redisTemplate.opsForValue().set(key,status);
        return Result.success();
    }

    /**
     * 获取店铺的营业状态
     * @return
     */
    @GetMapping("/status")
    @ApiOperation("获取店铺的营业状态")
    public Result GetStatus(){
        // TODO 设置营业状态
        Integer status = (Integer) redisTemplate.opsForValue().get(key);
        log.info("当前营业状态为：{}",status == 1 ? "营业中":"打烊中");
        return Result.success(status);
    }
}
