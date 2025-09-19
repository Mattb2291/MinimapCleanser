package com.minimapcleanser;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;

@ConfigGroup("minimapcleanser")
public interface minimapCleanserConfig extends Config
{
    enum GIMIconEnum {
        VIEW_ALWAYS,
        CONDITIONAL,
        HIDE_ALWAYS
    }
    @ConfigItem(
            keyName = "GIMConfig",
            name = "Hide Group Ironman Transport",
            description = "Choose whether to always view or hide the icon, or conditional based on the account.",
            position = 1
    )
    default GIMIconEnum GIMConfig() { return GIMIconEnum.CONDITIONAL; }

    //region Game Features Region
    @ConfigItem(
            keyName = "gameFeaturesBoolean",
            name = "Hide all Game Features",
            description = "Remove all game features from the minimap (overrides selection below).",
            position = 2
    )
    default boolean gameFeaturesBoolean() { return false; }

    @ConfigSection(
            name = "Game Features",
            description = "The minimap icons of game features.",
            position = 3,
            closedByDefault = true
    )
    String gameFeatureIconSection = "gameFeatureIconSection";

    enum AgilitySCIconEnum {
        VIEW_ALL,
        //VIEW_ABLE_ONLY,
        HIDE_ALL
    }
    @ConfigItem(
            keyName = "agiligySCConfig",
            name = "Agility Shortcuts",
            description = "Choose whether to show all icons, show only accessible agility shortcuts, or hide all icons.",
            section = gameFeatureIconSection
    )
    default AgilitySCIconEnum agiligySCConfig() { return AgilitySCIconEnum.VIEW_ALL; }

    @ConfigItem(
            keyName = "altarBoolean",
            name = "Altars",
            description = "Remove altar icons from the minimap",
            section = gameFeatureIconSection
    )
    default boolean altarBoolean() { return false; }

    @ConfigItem(
            keyName = "bankBoolean",
            name = "Banks",
            description = "Remove bank icons from the minimap",
            section = gameFeatureIconSection
    )
    default boolean bankBoolean() { return false; }

    @ConfigItem(
            keyName = "clanHubBoolean",
            name = "Clan Hub",
            description = "Remove clan hub icons from the minimap",
            section = gameFeatureIconSection
    )
    default boolean clanHubBoolean() { return false; }

    @ConfigItem(
            keyName = "combatAchievementsBoolean",
            name = "Combat Achievements",
            description = "Remove combat achievement icons from the minimap",
            section = gameFeatureIconSection
    )
    default boolean combatAchievementsBoolean() { return false; }

    @ConfigItem(
            keyName = "deathsOfficeBoolean",
            name = "Death's Office",
            description = "Remove Death's office icons from the minimap",
            section = gameFeatureIconSection
    )
    default boolean deathsOfficeBoolean() { return false; }

    @ConfigItem(
            keyName = "DnDBoolean",
            name = "Distraction and Diversions",
            description = "Remove D&D icons from the minimap",
            section = gameFeatureIconSection
    )
    default boolean DnDBoolean() { return false; }

    @ConfigItem(
            keyName = "dungeonBoolean",
            name = "Dungeons",
            description = "Remove dungeon icons from the minimap",
            section = gameFeatureIconSection
    )
    default boolean dungeonBoolean() { return false; }

    @ConfigItem(
            keyName = "hairBoolean",
            name = "Hairdresser",
            description = "Remove hairdresser icons from the minimap",
            section = gameFeatureIconSection
    )
    default boolean hairBoolean() { return false; }

    @ConfigItem(
            keyName = "holidayBoolean",
            name = "Holiday Events",
            description = "Remove holiday event icons from the minimap",
            section = gameFeatureIconSection
    )
    default boolean holidayBoolean() { return false; }

    @ConfigItem(
            keyName = "houseBoolean",
            name = "House Portal",
            description = "Remove house portal icons from the minimap",
            section = gameFeatureIconSection
    )
    default boolean houseBoolean() { return false; }

    @ConfigItem(
            keyName = "makeoverBoolean",
            name = "Makeover Mage",
            description = "Remove makeover mage icons from the minimap",
            section = gameFeatureIconSection
    )
    default boolean makeoverBoolean() { return false; }

    @ConfigItem(
            keyName = "minigameBoolean",
            name = "Minigames",
            description = "Remove minigame icons from the minimap",
            section = gameFeatureIconSection
    )
    default boolean minigameBoolean() { return false; }

    @ConfigItem(
            keyName = "pollBoolean",
            name = "Poll Booth",
            description = "Remove poll booth icons from the minimap",
            section = gameFeatureIconSection
    )
    default boolean pollBoolean() { return false; }

    enum QuestIconEnum {
        VIEW_ALL,
        //VIEW_OUTSTANDING,
        HIDE_ALL
    }
    @ConfigItem(
            keyName = "questConfig",
            name = "Quests",
            description = "Choose whether to show all icons, show only outstanding quests, or hide all icons.",
            section = gameFeatureIconSection
    )
    default QuestIconEnum questConfig() { return QuestIconEnum.VIEW_ALL; }

    @ConfigItem(
            keyName = "raidBoolean",
            name = "Raids",
            description = "Remove raid icons from the minimap",
            section = gameFeatureIconSection
    )
    default boolean raidBoolean() { return false; }

    @ConfigItem(
            keyName = "taskBoolean",
            name = "Task Masters",
            description = "Remove task master icons from the minimap",
            section = gameFeatureIconSection
    )
    default boolean taskBoolean() { return false; }

    @ConfigItem(
            keyName = "transportBoolean",
            name = "Transportation",
            description = "Remove transportation icons from the minimap",
            section = gameFeatureIconSection
    )
    default boolean transportBoolean() { return false; }

    @ConfigItem(
            keyName = "transportFRBoolean",
            name = "Transportation (Fairy Rings)",
            description = "Remove fairy ring transportation icons from the minimap",
            section = gameFeatureIconSection
    )
    default boolean transportFRBoolean() { return false; }
    //endregion

    //region Tutors Region
    @ConfigItem(
            keyName = "tutorsBoolean",
            name = "Hide all Tutors",
            description = "Remove all tutor icons from the minimap (overrides selection below).",
            position = 4
    )
    default boolean tutorsBoolean() { return false; }

    @ConfigSection(
            name = "Tutors",
            description = "The minimap icons of Tutors.",
            position = 5,
            closedByDefault = true
    )
    String tutorIconSection = "tutorIconSection";

    @ConfigItem(
            keyName = "bankTutBoolean",
            name = "Bank Tutor",
            description = "Remove the Bank Tutor icon from the minimap",
            section = tutorIconSection
    )
    default boolean bankTutBoolean() { return false; }

    @ConfigItem(
            keyName = "bondTutBoolean",
            name = "Bond Tutor",
            description = "Remove the Bond Tutor icon from the minimap",
            section = tutorIconSection
    )
    default boolean bondTutBoolean() { return false; }

    @ConfigItem(
            keyName = "clueTutBoolean",
            name = "Clue Tutor",
            description = "Remove the Clue Tutor icon from the minimap",
            section = tutorIconSection
    )
    default boolean clueTutBoolean() { return false; }

    @ConfigItem(
            keyName = "combatTutBoolean",
            name = "Combat Tutor",
            description = "Remove the Combat Tutor icon from the minimap",
            section = tutorIconSection
    )
    default boolean combatTutBoolean() { return false; }

    @ConfigItem(
            keyName = "cookTutBoolean",
            name = "Cooking Tutor",
            description = "Remove the Cooking Tutor icon from the minimap",
            section = tutorIconSection
    )
    default boolean cookTutBoolean() { return false; }

    @ConfigItem(
            keyName = "craftTutBoolean",
            name = "Crafting Tutor",
            description = "Remove the Crafting Tutor icon from the minimap",
            section = tutorIconSection
    )
    default boolean craftTutBoolean() { return false; }

    @ConfigItem(
            keyName = "dangerTutBoolean",
            name = "Danger Tutor",
            description = "Remove the Danger Tutor icon from the minimap",
            section = tutorIconSection
    )
    default boolean dangerTutBoolean() { return false; }

    @ConfigItem(
            keyName = "deadmanTutBoolean",
            name = "Deadman Tutor",
            description = "Remove the Deadman Tutor icon from the minimap",
            section = tutorIconSection
    )
    default boolean deadmanTutBoolean() { return false; }

    @ConfigItem(
            keyName = "fishTutBoolean",
            name = "Fishing Tutor",
            description = "Remove the Fishing Tutor icon from the minimap",
            section = tutorIconSection
    )
    default boolean fishTutBoolean() { return false; }

    @ConfigItem(
            keyName = "huntTutBoolean",
            name = "Hunter Tutor",
            description = "Remove the Hunter Tutor icon from the minimap",
            section = tutorIconSection
    )
    default boolean huntTutBoolean() { return false; }

    @ConfigItem(
            keyName = "ironTutBoolean",
            name = "Ironman Tutor",
            description = "Remove the Ironman Tutor icon from the minimap",
            section = tutorIconSection
    )
    default boolean ironTutBoolean() { return false; }

    @ConfigItem(
            keyName = "leaguesTutBoolean",
            name = "Leagues Tutor",
            description = "Remove the Leagues Tutor icon from the minimap",
            section = tutorIconSection
    )
    default boolean leaguesTutBoolean() { return false; }

    @ConfigItem(
            keyName = "lumbyTutBoolean",
            name = "Lumbridge Guide",
            description = "Remove the Lumbridge Guide icon from the minimap",
            section = tutorIconSection
    )
    default boolean lumbyTutBoolean() { return false; }

    @ConfigItem(
            keyName = "mineTutBoolean",
            name = "Mining Tutor",
            description = "Remove the Mining Tutor icon from the minimap",
            section = tutorIconSection
    )
    default boolean mineTutBoolean() { return false; }

    @ConfigItem(
            keyName = "prayTutBoolean",
            name = "Prayer Tutor",
            description = "Remove the Prayer Tutor icon from the minimap",
            section = tutorIconSection
    )
    default boolean prayTutBoolean() { return false; }

    @ConfigItem(
            keyName = "securityTutBoolean",
            name = "Security Tutor",
            description = "Remove the Security Tutor icon from the minimap",
            section = tutorIconSection
    )
    default boolean securityTutBoolean() { return false; }

    @ConfigItem(
            keyName = "smithTutBoolean",
            name = "Smithing Tutor",
            description = "Remove the Smithing Tutor icon from the minimap",
            section = tutorIconSection
    )
    default boolean smithTutBoolean() { return false; }

    @ConfigItem(
            keyName = "wcTutBoolean",
            name = "Woodcutting Tutor",
            description = "Remove the Woodcutting Tutor icon from the minimap",
            section = tutorIconSection
    )
    default boolean wcTutBoolean() { return false; }
    //endregion

    //region Training Region
    @ConfigItem(
            keyName = "trainingBoolean",
            name = "Hide all Training icons",
            description = "Remove all training icons from the minimap (overrides selection below).",
            position = 6
    )
    default boolean trainingBoolean() { return false; }

    @ConfigSection(
            name = "Training",
            description = "The minimap icons of training areas.",
            position = 7,
            closedByDefault = true
    )
    String trainingIconSection = "trainingIconSection";

    enum AgilityTrainIconEnum {
        VIEW_ALL,
        //VIEW_ABLE_ONLY,
        HIDE_ALL
    }
    @ConfigItem(
            keyName = "agiligyTrainConfig",
            name = "Agility Training",
            description = "Choose whether to show all icons, show only accessible agility training, or hide all icons.",
            section = trainingIconSection
    )
    default AgilityTrainIconEnum agiligyTrainConfig() { return AgilityTrainIconEnum.VIEW_ALL; }

    @ConfigItem(
            keyName = "anvilBoolean",
            name = "Anvils",
            description = "Remove anvil icons from the minimap",
            section = trainingIconSection
    )
    default boolean anvilBoolean() { return false; }

    @ConfigItem(
            keyName = "birdhousesBoolean",
            name = "Bird House Sites",
            description = "Remove bird house site icons from the minimap",
            section = trainingIconSection
    )
    default boolean birdhousesBoolean() { return false; }

    @ConfigItem(
            keyName = "breweryBoolean",
            name = "Brewery",
            description = "Remove brewery icons from the minimap",
            section = trainingIconSection
    )
    default boolean breweryBoolean() { return false; }

    @ConfigItem(
            keyName = "dummyBoolean",
            name = "Combat Training",
            description = "Remove combat training icons from the minimap",
            section = trainingIconSection
    )
    default boolean dummyBoolean() { return false; }

    @ConfigItem(
            keyName = "cookRangeBoolean",
            name = "Cooking Range",
            description = "Remove cooking range icons from the minimap",
            section = trainingIconSection
    )
    default boolean cookRangeBoolean() { return false; }

    @ConfigItem(
            keyName = "dairyBoolean",
            name = "Dairy Churn",
            description = "Remove dairy churn icons from the minimap",
            section = trainingIconSection
    )
    default boolean dairyBoolean() { return false; }

    @ConfigItem(
            keyName = "dairyCowBoolean",
            name = "Dairy Cow",
            description = "Remove dairy cow icons from the minimap",
            section = trainingIconSection
    )
    default boolean dairyCowBoolean() { return false; }

    @ConfigItem(
            keyName = "farmPatchBoolean",
            name = "Farming Patches",
            description = "Remove farming patch icons from the minimap",
            section = trainingIconSection
    )
    default boolean farmPatchBoolean() { return false; }

    @ConfigItem(
            keyName = "fishSpotBoolean",
            name = "Fishing Spots",
            description = "Remove fishing icons from the minimap",
            section = trainingIconSection
    )
    default boolean fishSpotBoolean() { return false; }

    @ConfigItem(
            keyName = "furnaceBoolean",
            name = "Furnace",
            description = "Remove furnace icons from the minimap",
            section = trainingIconSection
    )
    default boolean furnaceBoolean() { return false; }

    @ConfigItem(
            keyName = "grindBoolean",
            name = "Grindstone",
            description = "Remove grindstone icons from the minimap",
            section = trainingIconSection
    )
    default boolean grindBoolean() { return false; }

    @ConfigItem(
            keyName = "huntTrainingBoolean",
            name = "Hunter Training",
            description = "Remove hunter icons from the minimap",
            section = trainingIconSection
    )
    default boolean huntTrainingBoolean() { return false; }

    @ConfigItem(
            keyName = "loomBoolean",
            name = "Loom",
            description = "Remove loom icons from the minimap",
            section = trainingIconSection
    )
    default boolean loomBoolean() { return false; }

    @ConfigItem(
            keyName = "miningSiteBoolean",
            name = "Mining Site",
            description = "Remove mining icons from the minimap",
            section = trainingIconSection
    )
    default boolean miningSiteBoolean() { return false; }

    @ConfigItem(
            keyName = "polishWheelBoolean",
            name = "Polishing Wheel",
            description = "Remove polishing wheel icons from the minimap",
            section = trainingIconSection
    )
    default boolean polishWheelBoolean() { return false; }

    @ConfigItem(
            keyName = "potteryWheelBoolean",
            name = "Pottery Wheel",
            description = "Remove pottery wheel icons from the minimap",
            section = trainingIconSection
    )
    default boolean potteryWheelBoolean() { return false; }

    @ConfigItem(
            keyName = "rareTreesBoolean",
            name = "Rare Trees",
            description = "Remove rare tree icons from the minimap",
            section = trainingIconSection
    )
    default boolean rareTreesBoolean() { return false; }

    @ConfigItem(
            keyName = "sandBoolean",
            name = "Sandpit",
            description = "Remove sandpit icons from the minimap",
            section = trainingIconSection
    )
    default boolean sandBoolean() { return false; }

    @ConfigItem(
            keyName = "singbowlBoolean",
            name = "Singing Bowl",
            description = "Remove singing bowl icons from the minimap",
            section = trainingIconSection
    )
    default boolean singbowlBoolean() { return false; }

    @ConfigItem(
            keyName = "slayerMasterBoolean",
            name = "Slayer Master",
            description = "Remove slayer master icons from the minimap",
            section = trainingIconSection
    )
    default boolean slayerMasterBoolean() { return false; }

    @ConfigItem(
            keyName = "spinWheelBoolean",
            name = "Spinning Wheel",
            description = "Remove spinning wheel icons from the minimap",
            section = trainingIconSection
    )
    default boolean spinWheelBoolean() { return false; }

    @ConfigItem(
            keyName = "stagnantWaterBoolean",
            name = "Stagnant Water Source",
            description = "Remove stagnant water source icons from the minimap",
            section = trainingIconSection
    )
    default boolean stagnantWaterBoolean() { return false; }

    @ConfigItem(
            keyName = "thiefActivityBoolean",
            name = "Thieving Activity",
            description = "Remove thieving icons from the minimap",
            section = trainingIconSection
    )
    default boolean thiefActivityBoolean() { return false; }

    @ConfigItem(
            keyName = "tripHammerBoolean",
            name = "Trip Hammer",
            description = "Remove trip hammer icons from the minimap",
            section = trainingIconSection
    )
    default boolean tripHammerBoolean() { return false; }

    @ConfigItem(
            keyName = "valeTotemBoolean",
            name = "Vale Totem",
            description = "Remove vale totem icons from the minimap",
            section = trainingIconSection
    )
    default boolean valeTotemBoolean() { return false; }

    @ConfigItem(
            keyName = "waterSourceBoolean",
            name = "Water Source",
            description = "Remove water source icons from the minimap",
            section = trainingIconSection
    )
    default boolean waterSourceBoolean() { return false; }

    @ConfigItem(
            keyName = "windmillBoolean",
            name = "Windmill",
            description = "Remove windmill icons from the minimap",
            section = trainingIconSection
    )
    default boolean windmillBoolean() { return false; }

    @ConfigItem(
            keyName = "wcStumpBoolean",
            name = "Woodcutting Stump",
            description = "Remove woodcutting stump icons from the minimap",
            section = trainingIconSection
    )
    default boolean wcStumpBoolean() { return false; }
    //endregion

    //region Shopping Region
    @ConfigItem(
            keyName = "shoppingBoolean",
            name = "Hide all Shopping icons",
            description = "Remove all shops from the minimap (overrides selection below).",
            position = 8
    )
    default boolean shoppingBoolean() { return false; }

    @ConfigSection(
            name = "Shopping",
            description = "The minimap icons of shops.",
            position = 9,
            closedByDefault = true
    )
    String shoppingIconSection = "shoppingIconSection";

    @ConfigItem(
            keyName = "amuletShopBoolean",
            name = "Amulet Shop",
            description = "Remove amulet shop icons from the minimap",
            section = shoppingIconSection
    )
    default boolean amuletShopBoolean() { return false; }

    @ConfigItem(
            keyName = "apothecaryBoolean",
            name = "Apothecary",
            description = "Remove apothecary icons from the minimap",
            section = shoppingIconSection
    )
    default boolean apothecaryBoolean() { return false; }

    @ConfigItem(
            keyName = "archeryShopBoolean",
            name = "Archery Shop",
            description = "Remove archery shop icons from the minimap",
            section = shoppingIconSection
    )
    default boolean archeryShopBoolean() { return false; }

    @ConfigItem(
            keyName = "axeShopBoolean",
            name = "Axe Shop",
            description = "Remove axe shop icons from the minimap",
            section = shoppingIconSection
    )
    default boolean axeShopBoolean() { return false; }

    @ConfigItem(
            keyName = "BHshopBoolean",
            name = "Bounty Hunter Shop",
            description = "Remove Bounty Hunter shop icons from the minimap",
            section = shoppingIconSection
    )
    default boolean BHshopBoolean() { return false; }

    @ConfigItem(
            keyName = "candleShopBoolean",
            name = "Candle Shop",
            description = "Remove candle shop icons from the minimap",
            section = shoppingIconSection
    )
    default boolean candleShopBoolean() { return false; }

    @ConfigItem(
            keyName = "chainbodyShopBoolean",
            name = "Chainbody Shop",
            description = "Remove chainbody shop icons from the minimap",
            section = shoppingIconSection
    )
    default boolean chainbodyShopBoolean() { return false; }

    @ConfigItem(
            keyName = "clothesShopBoolean",
            name = "Clothes Shop",
            description = "Remove clothes shop icons from the minimap",
            section = shoppingIconSection
    )
    default boolean clothesShopBoolean() { return false; }

    @ConfigItem(
            keyName = "cookeryShopBoolean",
            name = "Cookery Shop",
            description = "Remove cookery shop icons from the minimap",
            section = shoppingIconSection
    )
    default boolean cookeryShopBoolean() { return false; }

    @ConfigItem(
            keyName = "craftingShopBoolean",
            name = "Crafting Shop",
            description = "Remove crafting shop icons from the minimap",
            section = shoppingIconSection
    )
    default boolean craftingShopBoolean() { return false; }

    @ConfigItem(
            keyName = "dyeShopBoolean",
            name = "Dye Trader",
            description = "Remove dye trader icons from the minimap",
            section = shoppingIconSection
    )
    default boolean dyeShopBoolean() { return false; }

    @ConfigItem(
            keyName = "estateBoolean",
            name = "Estate Agent",
            description = "Remove estate agent icons from the minimap",
            section = shoppingIconSection
    )
    default boolean estateBoolean() { return false; }

    @ConfigItem(
            keyName = "farmingShopBoolean",
            name = "Farming Shop",
            description = "Remove farming shop icons from the minimap",
            section = shoppingIconSection
    )
    default boolean farmingShopBoolean() { return false; }

    @ConfigItem(
            keyName = "fishingShopBoolean",
            name = "Fishing Shop",
            description = "Remove fishing shop icons from the minimap",
            section = shoppingIconSection
    )
    default boolean fishingShopBoolean() { return false; }

    @ConfigItem(
            keyName = "foodShopBoolean",
            name = "Food Shop",
            description = "Remove food shop icons from the minimap",
            section = shoppingIconSection
    )
    default boolean foodShopBoolean() { return false; }

    @ConfigItem(
            keyName = "forestryShopBoolean",
            name = "Forestry Shop",
            description = "Remove forestry shop icons from the minimap",
            section = shoppingIconSection
    )
    default boolean forestryShopBoolean() { return false; }

    @ConfigItem(
            keyName = "furShopBoolean",
            name = "Fur Trader",
            description = "Remove fur trader icons from the minimap",
            section = shoppingIconSection
    )
    default boolean furShopBoolean() { return false; }

    @ConfigItem(
            keyName = "gardenSupplierBoolean",
            name = "Garden Supplier",
            description = "Remove garden supplier icons from the minimap",
            section = shoppingIconSection
    )
    default boolean gardenSupplierBoolean() { return false; }

    @ConfigItem(
            keyName = "gemShopBoolean",
            name = "Gem Shop",
            description = "Remove gem shop icons from the minimap",
            section = shoppingIconSection
    )
    default boolean gemShopBoolean() { return false; }

    @ConfigItem(
            keyName = "generalStoreBoolean",
            name = "General Store",
            description = "Remove general store icons from the minimap",
            section = shoppingIconSection
    )
    default boolean generalStoreBoolean() { return false; }

    @ConfigItem(
            keyName = "GEBoolean",
            name = "Grand Exchange",
            description = "Remove grand exchange icons from the minimap",
            section = shoppingIconSection
    )
    default boolean GEBoolean() { return false; }

    @ConfigItem(
            keyName = "helmetShopBoolean",
            name = "Helmet Shop",
            description = "Remove helmet shop icons from the minimap",
            section = shoppingIconSection
    )
    default boolean helmetShopBoolean() { return false; }

    @ConfigItem(
            keyName = "herbalistBoolean",
            name = "Herbalist",
            description = "Remove herbalist icons from the minimap",
            section = shoppingIconSection
    )
    default boolean herbalistBoolean() { return false; }

    @ConfigItem(
            keyName = "holidayItemsBoolean",
            name = "Holiday Items Trader",
            description = "Remove holiday items trader icons from the minimap",
            section = shoppingIconSection
    )
    default boolean holidayItemsBoolean() { return false; }

    @ConfigItem(
            keyName = "hunterShopBoolean",
            name = "Hunter Shop",
            description = "Remove hunter shop icons from the minimap",
            section = shoppingIconSection
    )
    default boolean hunterShopBoolean() { return false; }

    @ConfigItem(
            keyName = "jewelleryShopBoolean",
            name = "Jewellery Shop",
            description = "Remove jewellery shop icons from the minimap",
            section = shoppingIconSection
    )
    default boolean jewelleryShopBoolean() { return false; }

    @ConfigItem(
            keyName = "WOMBoolean",
            name = "Junk Checker",
            description = "Remove junk checker icons from the minimap",
            section = shoppingIconSection
    )
    default boolean WOMBoolean() { return false; }

    @ConfigItem(
            keyName = "kebabShopBoolean",
            name = "Kebab seller",
            description = "Remove kebab shop icons from the minimap",
            section = shoppingIconSection
    )
    default boolean kebabShopBoolean() { return false; }

    @ConfigItem(
            keyName = "maceShopBoolean",
            name = "Mace Shop",
            description = "Remove mace shop icons from the minimap",
            section = shoppingIconSection
    )
    default boolean maceShopBoolean() { return false; }

    @ConfigItem(
            keyName = "magicShopBoolean",
            name = "Magic Shop",
            description = "Remove magic shop icons from the minimap",
            section = shoppingIconSection
    )
    default boolean magicShopBoolean() { return false; }

    @ConfigItem(
            keyName = "miningShopBoolean",
            name = "Mining Shop",
            description = "Remove mining shop icons from the minimap",
            section = shoppingIconSection
    )
    default boolean miningShopBoolean() { return false; }

    @ConfigItem(
            keyName = "newspaperBoolean",
            name = "Newspaper Trader",
            description = "Remove newspaper trader icons from the minimap",
            section = shoppingIconSection
    )
    default boolean newspaperBoolean() { return false; }

    @ConfigItem(
            keyName = "petInsuranceBoolean",
            name = "Pet Insurance Shop",
            description = "Remove pet insurance icons from the minimap",
            section = shoppingIconSection
    )
    default boolean petInsuranceBoolean() { return false; }

    @ConfigItem(
            keyName = "platebodyShopBoolean",
            name = "Platebody Shop",
            description = "Remove platebody shop icons from the minimap",
            section = shoppingIconSection
    )
    default boolean platebodyShopBoolean() { return false; }

    @ConfigItem(
            keyName = "platelegsShopBoolean",
            name = "Platelegs Shop",
            description = "Remove platelegs shop icons from the minimap",
            section = shoppingIconSection
    )
    default boolean platelegsShopBoolean() { return false; }

    @ConfigItem(
            keyName = "skirtShopBoolean",
            name = "Plateskirt Shop",
            description = "Remove skirt shop icons from the minimap",
            section = shoppingIconSection
    )
    default boolean skirtShopBoolean() { return false; }

    @ConfigItem(
            keyName = "pricingExpertsRuneBoolean",
            name = "Pricing Experts (runes)",
            description = "Remove pricing expert (runes) icons from the minimap",
            section = shoppingIconSection
    )
    default boolean pricingExpertsRuneBoolean() { return false; }

    @ConfigItem(
            keyName = "pricingExpertsHerbsBoolean",
            name = "Pricing Experts (herbs)",
            description = "Remove pricing expert (herbs) icons from the minimap",
            section = shoppingIconSection
    )
    default boolean pricingExpertsHerbsBoolean() { return false; }

    @ConfigItem(
            keyName = "pricingExpertsLogsBoolean",
            name = "Pricing Experts (logs)",
            description = "Remove pricing expert (logs) icons from the minimap",
            section = shoppingIconSection
    )
    default boolean pricingExpertsLogsBoolean() { return false; }

    @ConfigItem(
            keyName = "pricingExpertsOreBoolean",
            name = "Pricing Experts (ores & bars)",
            description = "Remove pricing expert (ores & bars) icons from the minimap",
            section = shoppingIconSection
    )
    default boolean pricingExpertsOreBoolean() { return false; }

    @ConfigItem(
            keyName = "pricingExpertsWeaponBoolean",
            name = "Pricing Experts (weapons & armour)",
            description = "Remove pricing expert (weapons & armour) icons from the minimap",
            section = shoppingIconSection
    )
    default boolean pricingExpertsWeaponBoolean() { return false; }

    @ConfigItem(
            keyName = "pubBarBoolean",
            name = "Pub/Bar",
            description = "Remove pub and bar icons from the minimap",
            section = shoppingIconSection
    )
    default boolean pubBarBoolean() { return false; }

    @ConfigItem(
            keyName = "ropeShopBoolean",
            name = "Rope Trader",
            description = "Remove rope trader icons from the minimap",
            section = shoppingIconSection
    )
    default boolean ropeShopBoolean() { return false; }

    @ConfigItem(
            keyName = "sawmillBoolean",
            name = "Sawmill",
            description = "Remove sawmill icons from the minimap",
            section = shoppingIconSection
    )
    default boolean sawmillBoolean() { return false; }

    @ConfigItem(
            keyName = "scimitarShopBoolean",
            name = "Scimitar Shop",
            description = "Remove scimitar shop icons from the minimap",
            section = shoppingIconSection
    )
    default boolean scimitarShopBoolean() { return false; }

    @ConfigItem(
            keyName = "shieldShopBoolean",
            name = "Shield Shop",
            description = "Remove shield shop icons from the minimap",
            section = shoppingIconSection
    )
    default boolean shieldShopBoolean() { return false; }

    @ConfigItem(
            keyName = "silkShopBoolean",
            name = "Silk Trader",
            description = "Remove silk trader icons from the minimap",
            section = shoppingIconSection
    )
    default boolean silkShopBoolean() { return false; }

    @ConfigItem(
            keyName = "silverShopBoolean",
            name = "Silver Shop",
            description = "Remove silver shop icons from the minimap",
            section = shoppingIconSection
    )
    default boolean silverShopBoolean() { return false; }

    @ConfigItem(
            keyName = "speedShopBoolean",
            name = "Speedrunning Shop",
            description = "Remove speedrunning shop icons from the minimap",
            section = shoppingIconSection
    )
    default boolean speedShopBoolean() { return false; }

    @ConfigItem(
            keyName = "spiceShopBoolean",
            name = "Spice Shop",
            description = "Remove spice shop icons from the minimap",
            section = shoppingIconSection
    )
    default boolean spiceShopBoolean() { return false; }

    @ConfigItem(
            keyName = "staffShopBoolean",
            name = "Staff Shop",
            description = "Remove staff shop icons from the minimap",
            section = shoppingIconSection
    )
    default boolean staffShopBoolean() { return false; }

    @ConfigItem(
            keyName = "stonemasonBoolean",
            name = "Stonemason",
            description = "Remove stonemason icons from the minimap",
            section = shoppingIconSection
    )
    default boolean stonemasonBoolean() { return false; }

    @ConfigItem(
            keyName = "swordShopBoolean",
            name = "Sword Shop",
            description = "Remove sword shop icons from the minimap",
            section = shoppingIconSection
    )
    default boolean swordShopBoolean() { return false; }

    @ConfigItem(
            keyName = "tanneryBoolean",
            name = "Tannery",
            description = "Remove tannery icons from the minimap",
            section = shoppingIconSection
    )
    default boolean tanneryBoolean() { return false; }

    @ConfigItem(
            keyName = "taxidermistBoolean",
            name = "Taxidermist",
            description = "Remove taxidermist icons from the minimap",
            section = shoppingIconSection
    )
    default boolean taxidermistBoolean() { return false; }

    @ConfigItem(
            keyName = "teaShopBoolean",
            name = "Tea Trader",
            description = "Remove tea trader icons from the minimap",
            section = shoppingIconSection
    )
    default boolean teaShopBoolean() { return false; }

    @ConfigItem(
            keyName = "vegShopBoolean",
            name = "Vegetable Store",
            description = "Remove vegetable store icons from the minimap",
            section = shoppingIconSection
    )
    default boolean vegShopBoolean() { return false; }

    @ConfigItem(
            keyName = "wineShopBoolean",
            name = "Wine Trader",
            description = "Remove wine trader icons from the minimap",
            section = shoppingIconSection
    )
    default boolean wineShopBoolean() { return false; }
    //endregion
}