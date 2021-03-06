package ru.shop;

import ru.shop.model.BaseEntity;
import ru.shop.util.MealsUtil;

/**
 * GKislin
 * 06.03.2015.
 */
public class AuthorizedUser {
    public static int id = BaseEntity.START_SEQ;

    public static int id() {
        return id;
    }

    public static void setId(int id) {
        AuthorizedUser.id = id;
    }

    public static int getCaloriesPerDay() {
        return MealsUtil.DEFAULT_CALORIES_PER_DAY;
    }
}
