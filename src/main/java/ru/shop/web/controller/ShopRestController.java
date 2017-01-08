package ru.shop.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.shop.model.Shop;
import ru.shop.service.ShopService;
import ru.shop.util.ValidationUtil;

import java.util.List;

/**
 * Created by Egor on 08.01.17.
 */
public class ShopRestController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private ShopService service;

    public List<Shop> getAll() {
        log.info("getAll");
        return service.getAll();
    }

    public Shop get(int id) {
        log.info("get " + id);
        return service.get(id);
    }

    public Shop create(Shop shop) {
        ValidationUtil.checkNew(shop);
        log.info("create " + shop);
        return service.save(shop);
    }

    public void delete(int id) {
        log.info("delete " + id);
        service.delete(id);
    }

    public void update(Shop shop, int id) {
        ValidationUtil.checkIdConsistent(shop, id);
        log.info("update " + shop);
        service.update(shop);
    }

}
