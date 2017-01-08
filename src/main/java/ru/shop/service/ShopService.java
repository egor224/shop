package ru.shop.service;

import ru.shop.model.Meal;
import ru.shop.model.Shop;
import ru.shop.util.exception.NotFoundException;

import java.util.Collection;

/**
 * Created by Egor on 08.01.17.
 */
public interface ShopService {
    Shop get(int id) throws NotFoundException;

    void delete(int id) throws NotFoundException;

    Collection<Shop> getAll();

    Shop update(Shop shop) throws NotFoundException;

    Shop save(Shop shop);

}
