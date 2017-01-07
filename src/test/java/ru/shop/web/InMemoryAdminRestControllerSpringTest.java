package ru.shop.web;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.shop.UserTestData;
import ru.shop.model.User;
import ru.shop.repository.UserRepository;
import ru.shop.util.exception.NotFoundException;
import ru.shop.web.user.AdminRestController;

import java.util.Collection;

/**
 * GKislin
 * 13.03.2015.
 */
@ContextConfiguration({"classpath:spring/spring-app.xml", "classpath:spring/mock.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class InMemoryAdminRestControllerSpringTest {

    @Autowired
    private AdminRestController controller;

    @Autowired
    private UserRepository repository;

    @Before
    public void setUp() throws Exception {
        repository.getAll().forEach(u -> repository.delete(u.getId()));
        repository.save(UserTestData.USER);
        repository.save(UserTestData.ADMIN);
    }

    @Test
    public void testDelete() throws Exception {
        controller.delete(UserTestData.USER_ID);
        Collection<User> users = controller.getAll();
        Assert.assertEquals(users.size(), 1);
        Assert.assertEquals(users.iterator().next(), UserTestData.ADMIN);
    }

    @Test(expected = NotFoundException.class)
    public void testDeleteNotFound() throws Exception {
        controller.delete(10);
    }
}
