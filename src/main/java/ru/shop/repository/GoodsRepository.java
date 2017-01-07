package ru.shop.repository;

import ru.shop.model.Goods;
import ru.shop.model.Shop;

/**
 * Created by Egor on 07.01.17.
 */
public interface GoodsRepository {

    Goods save(Goods goods);

    boolean delete(int id);

    Goods get(int id);

    Goods getByShop(Shop shop);
}
