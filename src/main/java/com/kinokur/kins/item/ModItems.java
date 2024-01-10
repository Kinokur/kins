package com.kinokur.kins.item;

import com.kinokur.kins.Kins;
import com.kinokur.kins.item.custom.IronDetectorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Kins.MOD_ID);

    public static final RegistryObject<Item> TOPAZ =
            ITEMS.register("topaz",() -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_TOPAZ =
            ITEMS.register("raw_topaz",() -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> IRON_DETECTOR =
            ITEMS.register("iron_detector",() -> new IronDetectorItem(new Item.Properties().durability(100)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
