package ru.shop.repository;

import ru.shop.model.Shop;

import java.util.List;

/**
 * Created by Egor on 07.01.17.
 */
public interface ShopRepository {

    Shop save(Shop shop);

    boolean delete (int id);

    Shop get(int id);

    List<Shop> getAll();

}
