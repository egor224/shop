package ru.shop.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.shop.model.Shop;

import static ru.shop.ShopTestData.MATCHER;
import static ru.shop.ShopTestData.SHOP1;


/**
 * Created by Egor on 08.01.17.
 */
@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class ShopServiceTest {

    @Autowired
    private ShopService service;

    @Test
    public void testGet() throws Exception {
        Shop shop = service.get(100000);
        MATCHER.assertEquals(SHOP1, shop);
    }


}
