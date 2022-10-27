package com.bic.bit_o_everything.item;

import com.bic.bit_o_everything.BitOEverything;
import com.bic.bit_o_everything.block.ModBlocks;
import com.bic.bit_o_everything.entity.custom.ModBoatEntity;
import com.bic.bit_o_everything.entity.custom.ModChestBoatEntity;
import com.bic.bit_o_everything.item.custom.*;
import com.bic.bit_o_everything.spells.*;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.HoneyBottleItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SignItem;
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
    public static final RegistryObject<Item> MOD_BOOK = ITEMS.register("mod_book",
            () -> new ModBookItem(new Item.Properties().tab(ModCreativeModeTab.MODDED)));

    public static final RegistryObject<Item> SLAG = ITEMS.register("slag",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODDED)));

    public static final RegistryObject<Item> FRIED_EGG = ITEMS.register("fried_egg",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODDED).food(ModFoods.FRIED_EGG)));

    public static final RegistryObject<Item> SILVER_ARROW = ITEMS.register("silver_arrow",
            () -> new SilverArrowItem(new Item.Properties().tab(ModCreativeModeTab.MODDED), 1.5F));

    public static final RegistryObject<Item> RAINBOW_DYE = ITEMS.register("rainbow_dye",
            () -> new RainbowDyeItem(new Item.Properties().tab(ModCreativeModeTab.MODDED)));
    //region Wood Types
    //region Cherry Wood
    public static final RegistryObject<Item> CHERRY_SIGN = ITEMS.register("cherry_sign",
            () -> new SignItem(new Item.Properties().tab(ModCreativeModeTab.WOOD).stacksTo(16),
                    ModBlocks.CHERRY_SIGN.get(), ModBlocks.CHERRY_WALL_SIGN.get()));
    
    public static final RegistryObject<Item> CHERRY_BOAT = ITEMS.register("cherry_boat",
            () -> new ModBoatItem(ModBoatEntity.Type.CHERRY,
                    (new Item.Properties()).stacksTo(1).tab(ModCreativeModeTab.WOOD)));
    
    public static final RegistryObject<Item> CHERRY_CHEST_BOAT = ITEMS.register("cherry_chest_boat",
            () -> new ModChestBoatItem(ModChestBoatEntity.Type.CHERRY,
                    (new Item.Properties()).stacksTo(1).tab(ModCreativeModeTab.WOOD)));
    //endregion
    //region Maple Wood
    public static final RegistryObject<Item> MAPLE_SIGN = ITEMS.register("maple_sign",
            () -> new SignItem(new Item.Properties().tab(ModCreativeModeTab.WOOD).stacksTo(16),
                    ModBlocks.MAPLE_SIGN.get(), ModBlocks.MAPLE_WALL_SIGN.get()));
    
    public static final RegistryObject<Item> MAPLE_BOAT = ITEMS.register("maple_boat",
            () -> new ModBoatItem(ModBoatEntity.Type.MAPLE,
                    (new Item.Properties()).stacksTo(1).tab(ModCreativeModeTab.WOOD)));
    
    public static final RegistryObject<Item> MAPLE_CHEST_BOAT = ITEMS.register("maple_chest_boat",
            () -> new ModChestBoatItem(ModChestBoatEntity.Type.MAPLE,
                    (new Item.Properties()).stacksTo(1).tab(ModCreativeModeTab.WOOD)));
    //endregion
    //region Dogwood Wood
    public static final RegistryObject<Item> DOGWOOD_SIGN = ITEMS.register("dogwood_sign",
            () -> new SignItem(new Item.Properties().tab(ModCreativeModeTab.WOOD).stacksTo(16),
                    ModBlocks.DOGWOOD_SIGN.get(), ModBlocks.DOGWOOD_WALL_SIGN.get()));
    
    public static final RegistryObject<Item> DOGWOOD_BOAT = ITEMS.register("dogwood_boat",
            () -> new ModBoatItem(ModBoatEntity.Type.DOGWOOD,
                    (new Item.Properties()).stacksTo(1).tab(ModCreativeModeTab.WOOD)));
    
    public static final RegistryObject<Item> DOGWOOD_CHEST_BOAT = ITEMS.register("dogwood_chest_boat",
            () -> new ModChestBoatItem(ModChestBoatEntity.Type.DOGWOOD,
                    (new Item.Properties()).stacksTo(1).tab(ModCreativeModeTab.WOOD)));
    //endregion
    //region Redwood Wood
    public static final RegistryObject<Item> REDWOOD_SIGN = ITEMS.register("redwood_sign",
            () -> new SignItem(new Item.Properties().tab(ModCreativeModeTab.WOOD).stacksTo(16),
                    ModBlocks.REDWOOD_SIGN.get(), ModBlocks.REDWOOD_WALL_SIGN.get()));
    
    public static final RegistryObject<Item> REDWOOD_BOAT = ITEMS.register("redwood_boat",
            () -> new ModBoatItem(ModBoatEntity.Type.REDWOOD,
                    (new Item.Properties()).stacksTo(1).tab(ModCreativeModeTab.WOOD)));
    
    public static final RegistryObject<Item> REDWOOD_CHEST_BOAT = ITEMS.register("redwood_chest_boat",
            () -> new ModChestBoatItem(ModChestBoatEntity.Type.REDWOOD,
                    (new Item.Properties()).stacksTo(1).tab(ModCreativeModeTab.WOOD)));
    //endregion
    //region Olive Wood
    public static final RegistryObject<Item> OLIVE_SIGN = ITEMS.register("olive_sign",
            () -> new SignItem(new Item.Properties().tab(ModCreativeModeTab.WOOD).stacksTo(16),
                    ModBlocks.OLIVE_SIGN.get(), ModBlocks.OLIVE_WALL_SIGN.get()));
    
    public static final RegistryObject<Item> OLIVE_BOAT = ITEMS.register("olive_boat",
            () -> new ModBoatItem(ModBoatEntity.Type.OLIVE,
                    (new Item.Properties()).stacksTo(1).tab(ModCreativeModeTab.WOOD)));
    
    public static final RegistryObject<Item> OLIVE_CHEST_BOAT = ITEMS.register("olive_chest_boat",
            () -> new ModChestBoatItem(ModChestBoatEntity.Type.OLIVE,
                    (new Item.Properties()).stacksTo(1).tab(ModCreativeModeTab.WOOD)));
    //endregion
    //region Peach Wood
    public static final RegistryObject<Item> PEACH_SIGN = ITEMS.register("peach_sign",
            () -> new SignItem(new Item.Properties().tab(ModCreativeModeTab.WOOD).stacksTo(16),
                    ModBlocks.PEACH_SIGN.get(), ModBlocks.PEACH_WALL_SIGN.get()));
    
    public static final RegistryObject<Item> PEACH_BOAT = ITEMS.register("peach_boat",
            () -> new ModBoatItem(ModBoatEntity.Type.PEACH,
                    (new Item.Properties()).stacksTo(1).tab(ModCreativeModeTab.WOOD)));
    
    public static final RegistryObject<Item> PEACH_CHEST_BOAT = ITEMS.register("peach_chest_boat",
            () -> new ModChestBoatItem(ModChestBoatEntity.Type.PEACH,
                    (new Item.Properties()).stacksTo(1).tab(ModCreativeModeTab.WOOD)));
    //endregion
    //region Ebony Wood
    public static final RegistryObject<Item> EBONY_SIGN = ITEMS.register("ebony_sign",
            () -> new SignItem(new Item.Properties().tab(ModCreativeModeTab.WOOD).stacksTo(16),
                    ModBlocks.EBONY_SIGN.get(), ModBlocks.EBONY_WALL_SIGN.get()));
    
    public static final RegistryObject<Item> EBONY_BOAT = ITEMS.register("ebony_boat",
            () -> new ModBoatItem(ModBoatEntity.Type.EBONY,
                    (new Item.Properties()).stacksTo(1).tab(ModCreativeModeTab.WOOD)));
    
    public static final RegistryObject<Item> EBONY_CHEST_BOAT = ITEMS.register("ebony_chest_boat",
            () -> new ModChestBoatItem(ModChestBoatEntity.Type.EBONY,
                    (new Item.Properties()).stacksTo(1).tab(ModCreativeModeTab.WOOD)));
    //endregion
    //region Plum Wood
    public static final RegistryObject<Item> PLUM_SIGN = ITEMS.register("plum_sign",
            () -> new SignItem(new Item.Properties().tab(ModCreativeModeTab.WOOD).stacksTo(16),
                    ModBlocks.PLUM_SIGN.get(), ModBlocks.PLUM_WALL_SIGN.get()));
    
    public static final RegistryObject<Item> PLUM_BOAT = ITEMS.register("plum_boat",
            () -> new ModBoatItem(ModBoatEntity.Type.PLUM,
                    (new Item.Properties()).stacksTo(1).tab(ModCreativeModeTab.WOOD)));
    
    public static final RegistryObject<Item> PLUM_CHEST_BOAT = ITEMS.register("plum_chest_boat",
            () -> new ModChestBoatItem(ModChestBoatEntity.Type.PLUM,
                    (new Item.Properties()).stacksTo(1).tab(ModCreativeModeTab.WOOD)));
    //endregion
    //region Orange Wood
    public static final RegistryObject<Item> ORANGE_SIGN = ITEMS.register("orange_sign",
            () -> new SignItem(new Item.Properties().tab(ModCreativeModeTab.WOOD).stacksTo(16),
                    ModBlocks.ORANGE_SIGN.get(), ModBlocks.ORANGE_WALL_SIGN.get()));
    
    public static final RegistryObject<Item> ORANGE_BOAT = ITEMS.register("orange_boat",
            () -> new ModBoatItem(ModBoatEntity.Type.ORANGE,
                    (new Item.Properties()).stacksTo(1).tab(ModCreativeModeTab.WOOD)));
    
    public static final RegistryObject<Item> ORANGE_CHEST_BOAT = ITEMS.register("orange_chest_boat",
            () -> new ModChestBoatItem(ModChestBoatEntity.Type.ORANGE,
                    (new Item.Properties()).stacksTo(1).tab(ModCreativeModeTab.WOOD)));
    //endregion
    //region Infected Wood
    public static final RegistryObject<Item> INFECTED_SIGN = ITEMS.register("infected_sign",
            () -> new SignItem(new Item.Properties().tab(ModCreativeModeTab.WOOD).stacksTo(16),
                    ModBlocks.INFECTED_SIGN.get(), ModBlocks.INFECTED_WALL_SIGN.get()));
    
    public static final RegistryObject<Item> INFECTED_BOAT = ITEMS.register("infected_boat",
            () -> new ModBoatItem(ModBoatEntity.Type.INFECTED,
                    (new Item.Properties()).stacksTo(1).tab(ModCreativeModeTab.WOOD)));
    
    public static final RegistryObject<Item> INFECTED_CHEST_BOAT = ITEMS.register("infected_chest_boat",
            () -> new ModChestBoatItem(ModChestBoatEntity.Type.INFECTED,
                    (new Item.Properties()).stacksTo(1).tab(ModCreativeModeTab.WOOD)));
    //endregion
    //region Corrupt Wood
    public static final RegistryObject<Item> CORRUPT_SIGN = ITEMS.register("corrupt_sign",
            () -> new SignItem(new Item.Properties().tab(ModCreativeModeTab.WOOD).stacksTo(16),
                    ModBlocks.CORRUPT_SIGN.get(), ModBlocks.CORRUPT_WALL_SIGN.get()));
    
    public static final RegistryObject<Item> CORRUPT_BOAT = ITEMS.register("corrupt_boat",
            () -> new ModBoatItem(ModBoatEntity.Type.CORRUPT,
                    (new Item.Properties()).stacksTo(1).tab(ModCreativeModeTab.WOOD)));
    
    public static final RegistryObject<Item> CORRUPT_CHEST_BOAT = ITEMS.register("corrupt_chest_boat",
            () -> new ModChestBoatItem(ModChestBoatEntity.Type.CORRUPT,
                    (new Item.Properties()).stacksTo(1).tab(ModCreativeModeTab.WOOD)));
    //endregion
    //region Pear Wood
    public static final RegistryObject<Item> PEAR_SIGN = ITEMS.register("pear_sign",
            () -> new SignItem(new Item.Properties().tab(ModCreativeModeTab.WOOD).stacksTo(16),
                    ModBlocks.PEAR_SIGN.get(), ModBlocks.PEAR_WALL_SIGN.get()));
    
    public static final RegistryObject<Item> PEAR_BOAT = ITEMS.register("pear_boat",
            () -> new ModBoatItem(ModBoatEntity.Type.PEAR,
                    (new Item.Properties()).stacksTo(1).tab(ModCreativeModeTab.WOOD)));
    
    public static final RegistryObject<Item> PEAR_CHEST_BOAT = ITEMS.register("pear_chest_boat",
            () -> new ModChestBoatItem(ModChestBoatEntity.Type.PEAR,
                    (new Item.Properties()).stacksTo(1).tab(ModCreativeModeTab.WOOD)));
    //endregion
    //region Wisteria Wood
    public static final RegistryObject<Item> WISTERIA_SIGN = ITEMS.register("wisteria_sign",
            () -> new SignItem(new Item.Properties().tab(ModCreativeModeTab.WOOD).stacksTo(16),
                    ModBlocks.WISTERIA_SIGN.get(), ModBlocks.WISTERIA_WALL_SIGN.get()));
    
    public static final RegistryObject<Item> WISTERIA_BOAT = ITEMS.register("wisteria_boat",
            () -> new ModBoatItem(ModBoatEntity.Type.WISTERIA,
                    (new Item.Properties()).stacksTo(1).tab(ModCreativeModeTab.WOOD)));
    
    public static final RegistryObject<Item> WISTERIA_CHEST_BOAT = ITEMS.register("wisteria_chest_boat",
            () -> new ModChestBoatItem(ModChestBoatEntity.Type.WISTERIA,
                    (new Item.Properties()).stacksTo(1).tab(ModCreativeModeTab.WOOD)));
    //endregion
    //region Charred Wood
    public static final RegistryObject<Item> CHARRED_SIGN = ITEMS.register("charred_sign",
            () -> new SignItem(new Item.Properties().tab(ModCreativeModeTab.WOOD).stacksTo(16),
                    ModBlocks.CHARRED_SIGN.get(), ModBlocks.CHARRED_WALL_SIGN.get()));
    
    public static final RegistryObject<Item> CHARRED_BOAT = ITEMS.register("charred_boat",
            () -> new ModBoatItem(ModBoatEntity.Type.CHARRED,
                    (new Item.Properties()).stacksTo(1).tab(ModCreativeModeTab.WOOD)));
    
    public static final RegistryObject<Item> CHARRED_CHEST_BOAT = ITEMS.register("charred_chest_boat",
            () -> new ModChestBoatItem(ModChestBoatEntity.Type.CHARRED,
                    (new Item.Properties()).stacksTo(1).tab(ModCreativeModeTab.WOOD)));
    //endregion
    //region Ice Wood
    public static final RegistryObject<Item> ICE_SIGN = ITEMS.register("ice_sign",
            () -> new SignItem(new Item.Properties().tab(ModCreativeModeTab.WOOD).stacksTo(16),
                    ModBlocks.ICE_SIGN.get(), ModBlocks.ICE_WALL_SIGN.get()));
    
    public static final RegistryObject<Item> ICE_BOAT = ITEMS.register("ice_boat",
            () -> new ModBoatItem(ModBoatEntity.Type.ICE,
                    (new Item.Properties()).stacksTo(1).tab(ModCreativeModeTab.WOOD)));
    
    public static final RegistryObject<Item> ICE_CHEST_BOAT = ITEMS.register("ice_chest_boat",
            () -> new ModChestBoatItem(ModChestBoatEntity.Type.ICE,
                    (new Item.Properties()).stacksTo(1).tab(ModCreativeModeTab.WOOD)));
    //endregion
    //region Dead Wood
    public static final RegistryObject<Item> DEAD_SIGN = ITEMS.register("dead_sign",
            () -> new SignItem(new Item.Properties().tab(ModCreativeModeTab.WOOD).stacksTo(16),
                    ModBlocks.DEAD_SIGN.get(), ModBlocks.DEAD_WALL_SIGN.get()));
    
    public static final RegistryObject<Item> DEAD_BOAT = ITEMS.register("dead_boat",
            () -> new ModBoatItem(ModBoatEntity.Type.DEAD,
                    (new Item.Properties()).stacksTo(1).tab(ModCreativeModeTab.WOOD)));
    
    public static final RegistryObject<Item> DEAD_CHEST_BOAT = ITEMS.register("dead_chest_boat",
            () -> new ModChestBoatItem(ModChestBoatEntity.Type.DEAD,
                    (new Item.Properties()).stacksTo(1).tab(ModCreativeModeTab.WOOD)));
    //endregion
    //endregion
    //region Explosives
    public static final RegistryObject<Item> GRENADE = ITEMS.register("grenade",
            () -> new GrenadeItem(new Item.Properties().tab(ModCreativeModeTab.MODDED)));

    public static final RegistryObject<Item> STICKY_GRENADE = ITEMS.register("sticky_grenade",
            () -> new StickyGrenadeItem(new Item.Properties().tab(ModCreativeModeTab.MODDED)));

    public static final RegistryObject<Item> STICKY_DETONATOR = ITEMS.register("sticky_detonator",
            () -> new StickyDetonator(new Item.Properties().tab(ModCreativeModeTab.MODDED).stacksTo(1)));

    public static final RegistryObject<Item> EXPLOSIVE_ARROW = ITEMS.register("explosive_arrow",
            () -> new ExplosiveArrowItem(new Item.Properties().tab(ModCreativeModeTab.MODDED), 1.5F));

    public static final RegistryObject<Item> TIMED_ARROW_ONE = ITEMS.register("timed_arrow_one",
            () -> new TimedArrowItem(new Item.Properties().tab(ModCreativeModeTab.MODDED), 1.5F, 0.5));

    public static final RegistryObject<Item> TIMED_ARROW_TWO = ITEMS.register("timed_arrow_two",
            () -> new TimedArrowItem(new Item.Properties().tab(ModCreativeModeTab.MODDED), 1.5F, 1));

    public static final RegistryObject<Item> TIMED_ARROW_THREE = ITEMS.register("timed_arrow_three",
            () -> new TimedArrowItem(new Item.Properties().tab(ModCreativeModeTab.MODDED), 1.5F, 1.5));
    //endregion
    //region Magic
    //region Casters
    public static final RegistryObject<Item> WAND = ITEMS.register("wand",
            () -> new MagicCastingItem(new Item.Properties().tab(ModCreativeModeTab.MAGIC).stacksTo(1), 2, 1, 3));

    public static final RegistryObject<Item> SPELL_BOOK = ITEMS.register("spell_book",
            () -> new MagicCastingItem(new Item.Properties().tab(ModCreativeModeTab.MAGIC).stacksTo(1), 4, 2, 2));

    public static final RegistryObject<Item> STAFF = ITEMS.register("staff",
            () -> new MagicCastingItem(new Item.Properties().tab(ModCreativeModeTab.MAGIC).stacksTo(1), 6, 3, 1));
    //endregion
    //region Spells
    public static final RegistryObject<Item> FIREBALL_SPELL = registerSpell("fireball_spell", FireballSpell.FIREBALL);
    public static final RegistryObject<Item> SLOWFALLING_SPELL = registerSpell("slowfalling_spell", SlowfallingSpell.SLOWFALLING);
    public static final RegistryObject<Item> TORCH_SPELL = registerSpell("torch_spell", TorchSpell.TORCHSPELL);
    public static final RegistryObject<Item> WEATHER_SPELL = registerSpell("weather_spell", WeatherSpell.WEATHER);
    public static final RegistryObject<Item> HASTE_SPELL = registerSpell("haste_spell", HasteSpell.HASTE);
    public static final RegistryObject<Item> DAMAGE_SPELL = registerSpell("damage_spell", AOEDamageSpell.DAMAGE);
    //endregion
    //endregion
    //region Ores
    //region Pyrite
    public static final RegistryObject<Item> RAW_PYRITE = ITEMS.register("raw_pyrite",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MINERALS)));

    public static final RegistryObject<Item> PYRITE = ITEMS.register("pyrite",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MINERALS)));

    public static final RegistryObject<Item> PYRITE_NUGGET = ITEMS.register("pyrite_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MINERALS)));
    //endregion
    //region Silicon
    public static final RegistryObject<Item> UNREFINED_SILICON = ITEMS.register("unrefined_silicon",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MINERALS)));

    public static final RegistryObject<Item> RED_UNREFINED_SILICON = ITEMS.register("red_unrefined_silicon",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MINERALS)));

    public static final RegistryObject<Item> SILICON = ITEMS.register("silicon",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MINERALS)));
    //endregion
    //region Zinc
    public static final RegistryObject<Item> RAW_ZINC = ITEMS.register("raw_zinc",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MINERALS)));

    public static final RegistryObject<Item> ZINC_INGOT = ITEMS.register("zinc_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MINERALS)));

    public static final RegistryObject<Item> ZINC_NUGGET = ITEMS.register("zinc_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MINERALS)));
    //endregion
    //region Magnesium
    public static final RegistryObject<Item> RAW_MAGNESIUM = ITEMS.register("raw_magnesium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MINERALS)));

    public static final RegistryObject<Item> MAGNESIUM_INGOT = ITEMS.register("magnesium_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MINERALS)));

    public static final RegistryObject<Item> MAGNESIUM_NUGGET = ITEMS.register("magnesium_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MINERALS)));
    //endregion
    //region Silver
    public static final RegistryObject<Item> RAW_SILVER = ITEMS.register("raw_silver",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MINERALS)));

    public static final RegistryObject<Item> SILVER_INGOT = ITEMS.register("silver_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MINERALS)));

    public static final RegistryObject<Item> SILVER_NUGGET = ITEMS.register("silver_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MINERALS)));
    //endregion
    //region Tin
    public static final RegistryObject<Item> RAW_TIN = ITEMS.register("raw_tin",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MINERALS)));

    public static final RegistryObject<Item> TIN_INGOT = ITEMS.register("tin_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MINERALS)));

    public static final RegistryObject<Item> TIN_NUGGET = ITEMS.register("tin_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MINERALS)));
    //endregion
    //region Lead
    public static final RegistryObject<Item> RAW_LEAD = ITEMS.register("raw_lead",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MINERALS)));

    public static final RegistryObject<Item> LEAD_INGOT = ITEMS.register("lead_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MINERALS)));

    public static final RegistryObject<Item> LEAD_NUGGET = ITEMS.register("lead_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MINERALS)));
    //endregion
    //region Titanium
    public static final RegistryObject<Item> RAW_TITANIUM = ITEMS.register("raw_titanium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MINERALS)));

    public static final RegistryObject<Item> TITANIUM_INGOT = ITEMS.register("titanium_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MINERALS)));

    public static final RegistryObject<Item> TITANIUM_NUGGET = ITEMS.register("titanium_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MINERALS)));
    //endregion
    //region Ruby
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MINERALS)));

    public static final RegistryObject<Item> RUBY_SHARD = ITEMS.register("ruby_shard",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MINERALS)));
    //endregion
    //region Sapphire
    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MINERALS)));

    public static final RegistryObject<Item> SAPPHIRE_SHARD = ITEMS.register("sapphire_shard",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MINERALS)));
    //endregion
    //region Rosalite
    public static final RegistryObject<Item> ROSALITE = ITEMS.register("rosalite",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MINERALS)));

    public static final RegistryObject<Item> ROSALITE_SHARD = ITEMS.register("rosalite_shard",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MINERALS)));
    //endregion
    //region Bismuth
    public static final RegistryObject<Item> BISMUTH = ITEMS.register("bismuth",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MINERALS)));

    public static final RegistryObject<Item> BISMUTH_NUGGET = ITEMS.register("bismuth_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MINERALS)));

    public static final RegistryObject<Item> BISMUTH_INGOT = ITEMS.register("bismuth_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MINERALS)));
    //endregion
    //region Smoky Quartz
    public static final RegistryObject<Item> SMOKY_QUARTZ = ITEMS.register("smoky_quartz",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MINERALS)));
    //endregion
    //region Crystal Shards
    public static final RegistryObject<Item> TANZANITE_SHARD = ITEMS.register("tanzanite_shard",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MINERALS)));

    public static final RegistryObject<Item> RHODOCHROSITE_SHARD = ITEMS.register("rhodochrosite_shard",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MINERALS)));

    public static final RegistryObject<Item> MOLDAVITE_SHARD = ITEMS.register("moldavite_shard",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MINERALS)));

    public static final RegistryObject<Item> CITRINE_SHARD = ITEMS.register("citrine_shard",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MINERALS)));

    public static final RegistryObject<Item> CELESTITE_SHARD = ITEMS.register("celestite_shard",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MINERALS)));

    public static final RegistryObject<Item> AQUAMARINE_SHARD = ITEMS.register("aquamarine_shard",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MINERALS)));
    //endregion
    //region Unobtainium
    public static final RegistryObject<Item> UNOBTAINIUM_DUST = ITEMS.register("unobtainium_dust",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MINERALS)));
    //endregion
    //endregion
    //region Alloys
    //region Aluminum
    public static final RegistryObject<Item> ALUMINUM_INGOT = ITEMS.register("aluminum_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MINERALS)));

    public static final RegistryObject<Item> ALUMINUM_NUGGET = ITEMS.register("aluminum_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MINERALS)));
    //endregion
    //region Brass
    public static final RegistryObject<Item> BRASS_INGOT = ITEMS.register("brass_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MINERALS)));

    public static final RegistryObject<Item> BRASS_NUGGET = ITEMS.register("brass_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MINERALS)));
    //endregion
    //region Bronze
    public static final RegistryObject<Item> BRONZE_INGOT = ITEMS.register("bronze_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MINERALS)));

    public static final RegistryObject<Item> BRONZE_NUGGET = ITEMS.register("bronze_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MINERALS)));
    //endregion
    //region Electrum
    public static final RegistryObject<Item> ELECTRUM_INGOT = ITEMS.register("electrum_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MINERALS)));

    public static final RegistryObject<Item> ELECTRUM_NUGGET = ITEMS.register("electrum_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MINERALS)));
    //endregion
    //region Steel
    public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MINERALS)));

    public static final RegistryObject<Item> STEEL_NUGGET = ITEMS.register("steel_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MINERALS)));
    //endregion
    //region Draconium
    public static final RegistryObject<Item> DRACONIUM_INGOT = ITEMS.register("draconium_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MINERALS)));

    public static final RegistryObject<Item> DRACONIUM_NUGGET = ITEMS.register("draconium_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MINERALS)));
    //endregion
    //region Crystalline
    public static final RegistryObject<Item> CRYSTALLINE_INGOT = ITEMS.register("crystalline_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MINERALS)));

    public static final RegistryObject<Item> CRYSTALLINE_SHARD = ITEMS.register("crystalline_shard",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MINERALS)));
    //endregion
    //endregion
    //region Vanilla Shards & Nuggets
    public static final RegistryObject<Item> EMERALD_SHARD = ITEMS.register("emerald_shard",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MINERALS)));

    public static final RegistryObject<Item> DIAMOND_SHARD = ITEMS.register("diamond_shard",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MINERALS)));

    public static final RegistryObject<Item> COPPER_NUGGET = ITEMS.register("copper_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MINERALS)));
    //endregion
    
    public static final RegistryObject<Item> WILDBERRIES = ITEMS.register("wildberries",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODDED).food(Foods.SWEET_BERRIES)));
    
    public static final RegistryObject<Item> BLUEBERRIES = ITEMS.register("blueberries",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODDED).food(Foods.SWEET_BERRIES)));

    public static final RegistryObject<Item> GOOSEBERRIES = ITEMS.register("gooseberries",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODDED).food(Foods.SWEET_BERRIES)));

    public static final RegistryObject<Item> RASPBERRIES = ITEMS.register("raspberries",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODDED).food(Foods.SWEET_BERRIES)));

    public static final RegistryObject<Item> BLACKBERRIES = ITEMS.register("blackberries",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODDED).food(Foods.SWEET_BERRIES)));
    
    
    
    public static final RegistryObject<Item> SAP_BOTTLE = ITEMS.register("sap_bottle",
            () -> new HoneyBottleItem(new Item.Properties().tab(ModCreativeModeTab.MODDED).food(Foods.HONEY_BOTTLE).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16)));
    
    
    public static final RegistryObject<Item> OLIVES = ITEMS.register("olives",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODDED).food(Foods.SWEET_BERRIES)));
    
    public static final RegistryObject<Item> ORANGE = ITEMS.register("orange",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODDED).food(Foods.APPLE)));
    
    public static final RegistryObject<Item> PEAR = ITEMS.register("pear",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODDED).food(Foods.APPLE)));
    
    public static final RegistryObject<Item> PEACH = ITEMS.register("peach",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODDED).food(Foods.APPLE)));
    
    public static final RegistryObject<Item> PLUM = ITEMS.register("plum",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODDED).food(Foods.APPLE)));
    
    
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
