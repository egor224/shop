package ru.shop.service;

import ru.shop.model.Goods;
import ru.shop.model.Shop;
import ru.shop.util.exception.NotFoundException;

import java.util.Collection;

/**
 * Created by Egor on 08.01.17.
 */
public interface GoodsService {
    Goods get(int id) throws NotFoundException;

    void delete(int id) throws NotFoundException;

    Collection<Goods> getAll();

    Collection<Goods> getByShop(Shop shop);

    Goods update(Goods goods) throws NotFoundException;

    Goods save(Goods goods);

}
