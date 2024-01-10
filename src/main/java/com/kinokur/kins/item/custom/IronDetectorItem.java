package com.kinokur.kins.item.custom;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import javax.naming.Context;

public class IronDetectorItem extends Item {
    public IronDetectorItem(Properties properties){
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(!pContext.getLevel().isClientSide){
            BlockPos positClick = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean fonBlock = false;
            for (int i = 0; i <= positClick.getY()+ 64; i++){
                BlockState state = pContext.getLevel().getBlockState(positClick.below(i));

                if (isValuableBlock(state)){
                    outputValuableCoordinates(positClick.below(i), player, state.getBlock());
                    fonBlock = true;

                    break;

                }
            }

            if (!fonBlock) {
                player.sendSystemMessage(Component.literal("Sorry, no valuables Found"));
            }

        }

        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(), player -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return InteractionResult.SUCCESS;
    }

    private void outputValuableCoordinates(BlockPos below, Player player, Block block) {
        int PlayerY = player.getBlockY();
        int depth = PlayerY - below.getY();
        player.sendSystemMessage(Component.literal("Найдено "+ I18n.get(block.getDescriptionId())+ " на высоте "+ below.getY()+"("+ depth+" глубине от вас)"));
    }

    private boolean isValuableBlock(BlockState state) {
        return state.is(Blocks.IRON_ORE) || state.is(Blocks.GOLD_ORE) || state.is(Blocks.DIAMOND_ORE) || state.is(Blocks.DEEPSLATE_DIAMOND_ORE);
    }
}
