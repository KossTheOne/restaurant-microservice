package ua.koss.client.component;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ua.koss.client.entity.Client;
import ua.koss.client.entity.Dishes;
import ua.koss.client.repository.IClientDao;
import ua.koss.client.repository.IDishesDao;

import static java.util.List.of;

@Component
@AllArgsConstructor(onConstructor_ = @Autowired)
public class DataInitializer implements CommandLineRunner {

    private IDishesDao iDishesDao;
    private IClientDao iClientDao;

    @Override
    public void run(String... args) throws Exception {
        Dishes hamburger = Dishes.builder().name("Hamburger").price(7.50).build();
        Dishes cheeseBurger = Dishes.builder().name("Cheese burger").price(8.50).build();
        iDishesDao.saveAll(of(hamburger,cheeseBurger));

        Client samWinchester = Client.builder().firstName("Sam").secondName("Winchester").address("Road Str 17").phoneNumber("911").build();
        Client deanWinchester = Client.builder().firstName("Dean").secondName("Winchester").address("Road Str 18").phoneNumber("1115").build();
        iClientDao.saveAll(of(samWinchester,deanWinchester));
    }
}
