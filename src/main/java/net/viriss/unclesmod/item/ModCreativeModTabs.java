package net.viriss.unclesmod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.viriss.unclesmod.UnclesMod;
import net.viriss.unclesmod.block.ModBlocks;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MOD_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, UnclesMod.MOD_ID);

public static final RegistryObject<CreativeModeTab> UNCLESMOD_TAB =
        CREATIVE_MOD_TABS.register("unclesmod_tab",
                () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SAPPHIRE.get()))
                        .title(Component.translatable("creativetab.unclesmod_tab"))
                        .displayItems((pParameters, pOutput) -> {
                            for(RegistryObject<Block> rb : ModBlocks.BLOCKS.getEntries()){
                                if (!rb.getKey().toString().contains("potted")) {
                                    pOutput.accept(rb.get());
                                }
                            }
                        })
                        .build());


    public static void register(IEventBus eventBus){
        CREATIVE_MOD_TABS.register(eventBus);
    }
}
