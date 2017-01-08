package ru.shop.repository;

import ru.shop.model.Goods;
import ru.shop.model.Shop;

import java.util.List;

/**
 * Created by Egor on 07.01.17.
 */
public interface GoodsRepository {

    Goods save(Goods goods);

    boolean delete(int id);

    Goods get(int id);

    List<Goods> getByShop(Shop shop);

    List<Goods> getAll();

}
