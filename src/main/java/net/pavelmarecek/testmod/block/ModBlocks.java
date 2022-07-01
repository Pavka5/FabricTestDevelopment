package net.pavelmarecek.testmod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.Identifier;
import net.pavelmarecek.testmod.TestMod;

public class ModBlocks {

    public static final Block PLATINUM_ORE = registerBlock("platinum_ore",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4.5f).requiresTool()), ItemGroup.BUILDING_BLOCKS);

    private static Block registerBlock(String name, Block block, ItemGroup group){
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(TestMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group){
        return Registry.register(Registry.ITEM, new Identifier(TestMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)));
    }
    public static void registerModBlocks() {
        TestMod.LOGGER.info("Registering ModBlocks for: " + TestMod.MOD_ID);
    }
}
