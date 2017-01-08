package ru.shop.service;

import ru.shop.model.Shop;
import ru.shop.util.exception.NotFoundException;

import java.util.List;

/**
 * Created by Egor on 08.01.17.
 */
public interface ShopService {
    Shop get(int id) throws NotFoundException;

    void delete(int id) throws NotFoundException;

    List<Shop> getAll();

    Shop update(Shop shop) throws NotFoundException;

    Shop save(Shop shop);

}
