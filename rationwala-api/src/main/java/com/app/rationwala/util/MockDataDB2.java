package com.app.rationwala.util;

import com.app.rationwala.dto.enums.ItemUnitType;
import com.app.rationwala.entity.ItemInventory;
import com.app.rationwala.entity.UserProfile;
import com.app.rationwala.repository.ItemInventoryRepository;
import com.app.rationwala.entity.Item;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class MockDataDB2 {

    public static void pushInventoryData(ItemInventoryRepository repo, Item item) {
        LongStream.range(1, 11).forEach(i -> {
            IntStream.range(1, 11)
                    .forEach(j -> repo.save(new ItemInventory(new UserProfile(i), new Item(Long.parseLong(j + "")),
                            "Item seller description", Double.parseDouble(i + ""), j, j, ItemUnitType.COUNT.name())));
        });
    }
}
