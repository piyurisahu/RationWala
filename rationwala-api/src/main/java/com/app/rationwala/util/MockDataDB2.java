package com.app.rationwala.util;

import com.app.rationwala.dto.enums.ItemUnitType;
import com.app.rationwala.entity.ItemInventory;
import com.app.rationwala.entity.UserProfile;
import com.app.rationwala.repository.ItemInventoryRepository;
import com.app.rationwala.entity.Item;

import java.util.Random;
import java.util.stream.LongStream;

public class MockDataDB2 {

    public static void pushInventoryData(ItemInventoryRepository repo, Item item, Double price,
                                         Integer instock, Integer quantity, String unit) {
        Random random = new Random();

        LongStream.range(1, 11)
                    .forEach(i -> {
                        repo.save(new ItemInventory(new UserProfile(i), item,
                                "Seller Specific Item Description", price + random.nextInt(10),
                                instock + random.nextInt(50), quantity, unit));
                    });;
    }
}
