package ru.shop;

import ru.shop.matcher.ModelMatcher;
import ru.shop.model.Shop;
import ru.shop.model.User;

import java.util.Objects;

import static ru.shop.model.BaseEntity.START_SEQ;

/**
 * Created by Egor on 08.01.17.
 */
public class ShopTestData {
    public static final int SHOP_ID1 = START_SEQ;
    public static final int SHOP_ID2 = START_SEQ + 1;

    public static final Shop SHOP1 = new Shop(SHOP_ID1, "Магазин N1", "Москва 111");
    public static final Shop SHOP2 = new Shop(SHOP_ID2, "Магазин N2", "Москва 222");

    public static final ModelMatcher<Shop> MATCHER = new ModelMatcher<>(
            (expected, actual) -> expected == actual ||
                    (Objects.equals(expected.getAddres(), actual.getAddres())
                            && Objects.equals(expected.getId(), actual.getId())
                            && Objects.equals(expected.getName(), actual.getName())
                    )
    );
}
