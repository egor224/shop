package ru.shop.repository;

import ru.shop.model.Shop;

/**
 * Created by Egor on 07.01.17.
 */
public interface ShopRepository {

    Shop save(Shop shop);

    boolean delete (int id);

    Shop get(int id);
}
