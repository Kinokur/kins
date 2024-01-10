package com.kinokur.kins.creativetab;

import com.kinokur.kins.Kins;
import com.kinokur.kins.block.ModBlocks;
import com.kinokur.kins.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Kins.MOD_ID);

    public static final RegistryObject<CreativeModeTab> ITEMS_TAB = CREATIVE_MODE_TABS.register("item_tab", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .title(Component.translatable("creativemodetab.kins.item_tab"))
            .icon(() -> ModItems.TOPAZ.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
            output.accept(ModItems.TOPAZ.get());
            output.accept(ModItems.RAW_TOPAZ.get());

            output.accept(ModBlocks.TOPAZ_ORE.get());
            output.accept(ModBlocks.TOPAZ_BLOCK.get());
            }).build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
