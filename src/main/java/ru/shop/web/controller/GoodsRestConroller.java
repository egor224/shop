package ru.shop.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.shop.model.Goods;
import ru.shop.model.Shop;
import ru.shop.service.GoodsService;
import ru.shop.util.ValidationUtil;

import java.util.List;

/**
 * Created by Egor on 08.01.17.
 */
public class GoodsRestConroller {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private GoodsService service;

    public List<Goods> getAll() {
        log.info("getAll");
        return service.getAll();
    }

    public List<Goods> getByShop(Shop shop) {
        log.info("getByShop");
        return service.getByShop(shop);
    }

    public Goods get(int id) {
        log.info("get " + id);
        return service.get(id);
    }

    public Goods create(Goods goods) {
        ValidationUtil.checkNew(goods);
        log.info("create " + goods);
        return service.save(goods);
    }

    public void delete(int id) {
        log.info("delete " + id);
        service.delete(id);
    }

    public void update(Goods goods, int id) {
        ValidationUtil.checkIdConsistent(goods, id);
        log.info("update " + goods);
        service.update(goods);
    }

}
