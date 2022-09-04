package com.bic.bit_o_everything.item;

import com.bic.bit_o_everything.BitOEverything;
import com.bic.bit_o_everything.block.ModBlocks;
import com.bic.bit_o_everything.entity.custom.ModBoatEntity;
import com.bic.bit_o_everything.entity.custom.ModChestBoatEntity;
import com.bic.bit_o_everything.item.custom.*;
import com.bic.bit_o_everything.spells.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, BitOEverything.MOD_ID);

    public static RegistryObject<Item> registerSpell(String name, AbstractSpell spell) {
        AbstractSpell.SPELLS.add(spell);
        return ITEMS.register(name,
                () -> new SpellItem(new Item.Properties().tab(ModCreativeModeTab.MAGIC).stacksTo(1), spell));
    }

    // Create items here
    public static final RegistryObject<Item> RAW_PYRITE = ITEMS.register("raw_pyrite",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODDED)));

    public static final RegistryObject<Item> PYRITE = ITEMS.register("pyrite",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODDED)));

    public static final RegistryObject<Item> MOD_BOOK = ITEMS.register("mod_book",
            () -> new ModBookItem(new Item.Properties().tab(ModCreativeModeTab.MODDED)));

    public static final RegistryObject<Item> SLAG = ITEMS.register("slag",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODDED)));

    public static final RegistryObject<Item> FRIED_EGG = ITEMS.register("fried_egg",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODDED).food(ModFoods.FRIED_EGG)));

    public static final RegistryObject<Item> CHERRY_SIGN = ITEMS.register("cherry_sign",
            () -> new SignItem(new Item.Properties().tab(ModCreativeModeTab.MODDED).stacksTo(16),
                    ModBlocks.CHERRY_SIGN.get(), ModBlocks.CHERRY_WALL_SIGN.get()));

    public static final RegistryObject<Item> CHERRY_BOAT = ITEMS.register("cherry_boat",
            () -> new ModBoatItem(ModBoatEntity.Type.CHERRY,
                    (new Item.Properties()).stacksTo(1).tab(ModCreativeModeTab.MODDED)));

    public static final RegistryObject<Item> CHERRY_CHEST_BOAT = ITEMS.register("cherry_chest_boat",
            () -> new ModChestBoatItem(ModChestBoatEntity.Type.CHERRY,
                    (new Item.Properties()).stacksTo(1).tab(ModCreativeModeTab.MODDED)));

    public static final RegistryObject<Item> RAW_ZINC = ITEMS.register("raw_zinc",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODDED)));

    public static final RegistryObject<Item> ZINC_INGOT = ITEMS.register("zinc_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODDED)));

    public static final RegistryObject<Item> RAW_MAGNESIUM = ITEMS.register("raw_magnesium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODDED)));

    public static final RegistryObject<Item> MAGNESIUM_INGOT = ITEMS.register("magnesium_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODDED)));

    public static final RegistryObject<Item> RAW_SILVER = ITEMS.register("raw_silver",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODDED)));

    public static final RegistryObject<Item> SILVER_INGOT = ITEMS.register("silver_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODDED)));

    public static final RegistryObject<Item> RAW_TIN = ITEMS.register("raw_tin",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODDED)));

    public static final RegistryObject<Item> TIN_INGOT = ITEMS.register("tin_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODDED)));

    public static final RegistryObject<Item> RAW_TITANIUM = ITEMS.register("raw_titanium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODDED)));

    public static final RegistryObject<Item> TITANIUM_INGOT = ITEMS.register("titanium_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODDED)));

    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODDED)));

    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODDED)));

    public static final RegistryObject<Item> EXPLOSIVE_ARROW = ITEMS.register("explosive_arrow",
            () -> new ExplosiveArrowItem(new Item.Properties().tab(ModCreativeModeTab.MODDED), 1.5F));

    public static final RegistryObject<Item> TIMED_ARROW_ONE = ITEMS.register("timed_arrow_one",
            () -> new TimedArrowItem(new Item.Properties().tab(ModCreativeModeTab.MODDED), 1.5F, 0.5));

    public static final RegistryObject<Item> TIMED_ARROW_TWO = ITEMS.register("timed_arrow_two",
            () -> new TimedArrowItem(new Item.Properties().tab(ModCreativeModeTab.MODDED), 1.5F, 1));

    public static final RegistryObject<Item> TIMED_ARROW_THREE = ITEMS.register("timed_arrow_three",
            () -> new TimedArrowItem(new Item.Properties().tab(ModCreativeModeTab.MODDED), 1.5F, 1.5));

    public static final RegistryObject<Item> SILVER_ARROW = ITEMS.register("silver_arrow",
            () -> new SilverArrowItem(new Item.Properties().tab(ModCreativeModeTab.MODDED), 1.5F));

    public static final RegistryObject<Item> RAINBOW_DYE = ITEMS.register("rainbow_dye",
            () -> new RainbowDyeItem(new Item.Properties().tab(ModCreativeModeTab.MODDED)));

    public static final RegistryObject<Item> GRENADE = ITEMS.register("grenade",
            () -> new GrenadeItem(new Item.Properties().tab(ModCreativeModeTab.MODDED)));

    public static final RegistryObject<Item> STICKY_GRENADE = ITEMS.register("sticky_grenade",
            () -> new StickyGrenadeItem(new Item.Properties().tab(ModCreativeModeTab.MODDED)));

    public static final RegistryObject<Item> STICKY_DETONATOR = ITEMS.register("sticky_detonator",
            () -> new StickyDetonator(new Item.Properties().tab(ModCreativeModeTab.MODDED).stacksTo(1)));

    public static final RegistryObject<Item> WAND = ITEMS.register("wand",
            () -> new MagicCastingItem(new Item.Properties().tab(ModCreativeModeTab.MAGIC).stacksTo(1), 2, 1, 3));

    public static final RegistryObject<Item> SPELL_BOOK = ITEMS.register("spell_book",
            () -> new MagicCastingItem(new Item.Properties().tab(ModCreativeModeTab.MAGIC).stacksTo(1), 4, 2, 2));

    public static final RegistryObject<Item> STAFF = ITEMS.register("staff",
            () -> new MagicCastingItem(new Item.Properties().tab(ModCreativeModeTab.MAGIC).stacksTo(1), 6, 3, 1));

    public static final RegistryObject<Item> FIREBALL_SPELL = registerSpell("fireball_spell", FireballSpell.FIREBALL);
    public static final RegistryObject<Item> SLOWFALLING_SPELL = registerSpell("slowfalling_spell", SlowfallingSpell.SLOWFALLING);
    public static final RegistryObject<Item> TORCH_SPELL = registerSpell("torch_spell", TorchSpell.TORCHSPELL);
    public static final RegistryObject<Item> WEATHER_SPELL = registerSpell("weather_spell", WeatherSpell.WEATHER);
    public static final RegistryObject<Item> HASTE_SPELL = registerSpell("haste_spell", HasteSpell.HASTE);
    public static final RegistryObject<Item> DAMAGE_SPELL = registerSpell("damage_spell", AOEDamageSpell.DAMAGE);

    //region Crystal Shards
    public static final RegistryObject<Item> TANZANITE_SHARD = ITEMS.register("tanzanite_shard",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODDED)));

    public static final RegistryObject<Item> RHODOCHROSITE_SHARD = ITEMS.register("rhodochrosite_shard",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODDED)));

    public static final RegistryObject<Item> MOLDAVITE_SHARD = ITEMS.register("moldavite_shard",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODDED)));

    public static final RegistryObject<Item> CITRINE_SHARD = ITEMS.register("citrine_shard",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODDED)));

    public static final RegistryObject<Item> CELESTITE_SHARD = ITEMS.register("celestite_shard",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODDED)));

    public static final RegistryObject<Item> AQUAMARINE_SHARD = ITEMS.register("aquamarine_shard",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODDED)));
    //endregion
    //region Alloys
    public static final RegistryObject<Item> ALUMINUM_INGOT = ITEMS.register("aluminum_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODDED)));

    public static final RegistryObject<Item> ALUMINUM_NUGGET = ITEMS.register("aluminum_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODDED)));

    public static final RegistryObject<Item> BRASS_INGOT = ITEMS.register("brass_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODDED)));

    public static final RegistryObject<Item> BRASS_NUGGET = ITEMS.register("brass_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODDED)));

    public static final RegistryObject<Item> BRONZE_INGOT = ITEMS.register("bronze_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODDED)));

    public static final RegistryObject<Item> BRONZE_NUGGET = ITEMS.register("bronze_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODDED)));

    public static final RegistryObject<Item> ELECTRUM_INGOT = ITEMS.register("electrum_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODDED)));

    public static final RegistryObject<Item> ELECTRUM_NUGGET = ITEMS.register("electrum_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODDED)));

    public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODDED)));

    public static final RegistryObject<Item> STEEL_NUGGET = ITEMS.register("steel_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODDED)));

    public static final RegistryObject<Item> DRACONIUM_INGOT = ITEMS.register("draconium_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODDED)));

    public static final RegistryObject<Item> DRACONIUM_NUGGET = ITEMS.register("draconium_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODDED)));

    public static final RegistryObject<Item> CRYSTALLINE_INGOT = ITEMS.register("crystalline_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODDED)));

    public static final RegistryObject<Item> CRYSTALLINE_SHARD = ITEMS.register("crystalline_shard",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODDED)));
    //endregion
    //region Nuggets & Shards
    public static final RegistryObject<Item> ZINC_NUGGET = ITEMS.register("zinc_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODDED)));
    public static final RegistryObject<Item> TITANIUM_NUGGET = ITEMS.register("titanium_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODDED)));
    public static final RegistryObject<Item> TIN_NUGGET = ITEMS.register("tin_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODDED)));
    public static final RegistryObject<Item> SILVER_NUGGET = ITEMS.register("silver_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODDED)));
    public static final RegistryObject<Item> SAPPHIRE_SHARD = ITEMS.register("sapphire_shard",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODDED)));
    public static final RegistryObject<Item> RUBY_SHARD = ITEMS.register("ruby_shard",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODDED)));
    public static final RegistryObject<Item> PYRITE_NUGGET = ITEMS.register("pyrite_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODDED)));
    public static final RegistryObject<Item> MAGNESIUM_NUGGET = ITEMS.register("magnesium_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODDED)));
    public static final RegistryObject<Item> LEAD_NUGGET = ITEMS.register("lead_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODDED)));
    public static final RegistryObject<Item> EMERALD_SHARD = ITEMS.register("emerald_shard",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODDED)));
    public static final RegistryObject<Item> DIAMOND_SHARD = ITEMS.register("diamond_shard",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODDED)));
    public static final RegistryObject<Item> COPPER_NUGGET = ITEMS.register("copper_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODDED)));
    //endregion
    //region Rosalite
    public static final RegistryObject<Item> ROSALITE = ITEMS.register("rosalite",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODDED)));
    public static final RegistryObject<Item> ROSALITE_SHARD = ITEMS.register("rosalite_shard",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODDED)));
    //endregion
    //region Bismuth
    public static final RegistryObject<Item> BISMUTH = ITEMS.register("bismuth",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODDED)));
    public static final RegistryObject<Item> BISMUTH_NUGGET = ITEMS.register("bismuth_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODDED)));
    public static final RegistryObject<Item> BISMUTH_INGOT = ITEMS.register("bismuth_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODDED)));
    //endregion
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);

    }
}
