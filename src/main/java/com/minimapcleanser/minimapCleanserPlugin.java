package com.minimapcleanser;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.GroundObjectDespawned;
import net.runelite.api.events.GroundObjectSpawned;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.api.gameval.ObjectID;

import java.util.HashMap;

@Slf4j
@PluginDescriptor(
	name = "Minimap Cleanser"
)
public class minimapCleanserPlugin extends Plugin
{
    private static final WorldPoint GroupIronManTransport = new WorldPoint(3217,3235,0);
    private HashMap<WorldPoint, GroundObject> hiddenObjects = new HashMap<>();

    @Inject	private minimapCleanserConfig config;
	@Inject	private Client client;
    @Inject private ClientThread clientThread;

    @Override
	protected void startUp() throws Exception {
        clientThread.invoke(() -> {
            refreshSceneGroundObjects(true);
        });
	}

	@Override
	protected void shutDown() throws Exception {
        refreshSceneGroundObjects(false);
        this.hiddenObjects = new HashMap<>();
	}

    @Subscribe
    public void onGroundObjectSpawned(GroundObjectSpawned event) {
        checkObjects(event.getGroundObject(), event.getTile());
    }

    @Subscribe
    public void onGroundObjectDespawned(GroundObjectDespawned event) {
        final Tile tile = event.getTile();
        if (tile != null) {
            final WorldPoint tileLocation = tile.getWorldLocation();
            if (tileLocation != null) {
                this.hiddenObjects.remove(tileLocation);
            }
        }
    }

    @Subscribe
    public void onConfigChanged(ConfigChanged configChanged) {
        if (configChanged.getGroup().equals("minimapcleanser")) {
            clientThread.invoke(() -> {
                refreshSceneGroundObjects(true);
            });
        }
    }

    private void checkObjects(GroundObject obj, Tile tile) {
        if (obj == null || tile == null) {return;}

        switch (obj.getId()) {
            //region Game Features
            case ObjectID.TRANSPORTATION_ICON:
                if (tile.getWorldLocation().equals(GroupIronManTransport)) {
                    if (config.GIMConfig() == minimapCleanserConfig.GIMIconEnum.HIDE_ALWAYS) {
                        storeAndHideObject(obj,tile);
                    }
                    else if (config.GIMConfig() == minimapCleanserConfig.GIMIconEnum.CONDITIONAL && !client.getAccountType().isGroupIronman()) {
                        storeAndHideObject(obj,tile);
                    }
                }
                else {
                    if (config.gameFeaturesBoolean() || config.transportBoolean()) {
                        storeAndHideObject(obj,tile);
                    }
                }
                break;
            case ObjectID.AGILITY_SHORTCUT_ICON:
                if (config.gameFeaturesBoolean() || config.agiligySCConfig() == minimapCleanserConfig.AgilitySCIconEnum.HIDE_ALL) {
                    storeAndHideObject(obj,tile);
                }
                //else if (config.agiligySCConfig() == minimapCleanserConfig.AgilitySCIconEnum.VIEW_ABLE_ONLY) {
                    //Add shortcut ability here
                //}
                break;
            case ObjectID.ALTAR_ICON:
                if (config.gameFeaturesBoolean() || config.altarBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.BANK_STORE_ICON:
                if (config.gameFeaturesBoolean() || config.bankBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.CLAN_HUB_ICON:
                if (config.gameFeaturesBoolean() || config.clanHubBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.COMBAT_ACHIEVEMENTS_ICON:
                if (config.gameFeaturesBoolean() || config.combatAchievementsBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.DEATH_OFFICE_ICON:
                if (config.gameFeaturesBoolean() || config.deathsOfficeBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.DANDD_ICON:
                if (config.gameFeaturesBoolean() || config.DnDBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.DUNGEONENTRANCE_ICON_CLICKABLE:
            case ObjectID.MAPLINK_ICON:
            case ObjectID.DUNGEONENTRANCE_ICON:
                if (config.gameFeaturesBoolean() || config.dungeonBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.HAIRDRESSER_ICON:
                if (config.gameFeaturesBoolean() || config.hairBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.HOLIDAY_EVENT_ICON:
                if (config.gameFeaturesBoolean() || config.holidayBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.POH_PORTAL_ICON:
                if (config.gameFeaturesBoolean() || config.houseBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.MAKEOVERMAGE_ICON:
                if (config.gameFeaturesBoolean() || config.makeoverBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.MINIGAME_START_ICON:
                if (config.gameFeaturesBoolean() || config.minigameBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.POLL_BOOTH_ICON:
                if (config.gameFeaturesBoolean() || config.pollBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.QUEST_START_ICON_ANIMALMAGNETISM:
            case ObjectID.QUEST_START_ICON_ANOTHERSLICEOFHAM:
            case ObjectID.QUEST_START_ICON_ASCENTOFARCEUUS:
            case ObjectID.QUEST_START_ICON_ATFIRSTLIGHT:
            case ObjectID.QUEST_START_ICON_BELOWICEMOUNTAIN:
            case ObjectID.QUEST_START_ICON_BENEATHCURSEDSANDS:
            case ObjectID.QUEST_START_ICON_BETWEENAROCK:
            case ObjectID.QUEST_START_ICON_BIGCHOMPYBIRDHUNTING:
            case ObjectID.QUEST_START_ICON_BIOHAZARD:
            case ObjectID.QUEST_START_ICON_BLACKKNIGHTSFORTRESS:
            case ObjectID.QUEST_START_ICON_BONEVOYAGE:
            case ObjectID.QUEST_START_ICON_CABINFEVER:
            case ObjectID.QUEST_START_ICON_CHILDRENOFTHESUN:
            case ObjectID.QUEST_START_ICON_CLIENTOFKOUREND:
            case ObjectID.QUEST_START_ICON_CLOCKTOWER:
            case ObjectID.QUEST_START_ICON_COLDWAR:
            case ObjectID.QUEST_START_ICON_CONTACT:
            case ObjectID.QUEST_START_ICON_COOKSASSISTANT:
            case ObjectID.QUEST_START_ICON_CORSAIRCURSE:
            case ObjectID.QUEST_START_ICON_CREATUREOFFENKENSTRAIN:
            case ObjectID.QUEST_START_ICON_CURSEOFARRAV:
            case ObjectID.QUEST_START_ICON_DARKNESSOFHALLOWVALE:
            case ObjectID.QUEST_START_ICON_DEATHONTHEISLE:
            case ObjectID.QUEST_START_ICON_DEATHPLATEAU:
            case ObjectID.QUEST_START_ICON_DEATHTOTHEDORGESHUUN:
            case ObjectID.QUEST_START_ICON_DEFENDEROFVARROCK:
            case ObjectID.QUEST_START_ICON_DEMONSLAYER:
            case ObjectID.QUEST_START_ICON_DEPTHSOFDESPAIR:
            case ObjectID.QUEST_START_ICON_DESERTTREASURE:
            case ObjectID.QUEST_START_ICON_DESERTTREASURE2:
            case ObjectID.QUEST_START_ICON_DEVIOUSMINDS:
            case ObjectID.QUEST_START_ICON_DIGSITE:
            case ObjectID.QUEST_START_ICON_DORICS:
            case ObjectID.QUEST_START_ICON_DRAGONSLAYER1:
            case ObjectID.QUEST_START_ICON_DRAGONSLAYER2:
            case ObjectID.QUEST_START_ICON_DREAMMENTOR:
            case ObjectID.QUEST_START_ICON_DRUIDICRITUAL:
            case ObjectID.QUEST_START_ICON_DWARFCANNON:
            case ObjectID.QUEST_START_ICON_EADGARSRUSE:
            case ObjectID.QUEST_START_ICON_EAGLESPEAK:
            case ObjectID.QUEST_START_ICON_ELEMENTALWORKSHOP1:
            case ObjectID.QUEST_START_ICON_ELEMENTALWORKSHOP2:
            case ObjectID.QUEST_START_ICON_ENAKHRASLAMENT:
            case ObjectID.QUEST_START_ICON_ENLIGHTENEDJOURNEY:
            case ObjectID.QUEST_START_ICON_ERNESTTHECHICKEN:
            case ObjectID.QUEST_START_ICON_ETHICALLYACQUIREDANTIQUITIES:
            case ObjectID.QUEST_START_ICON_EXISTENTIALCRISIS:
            case ObjectID.QUEST_START_ICON_EYESOFGLOUPHRIE:
            case ObjectID.QUEST_START_ICON_FAIRYTALE1:
            case ObjectID.QUEST_START_ICON_FAIRYTALE2:
            case ObjectID.QUEST_START_ICON_FAMILYCREST:
            case ObjectID.QUEST_START_ICON_FEUD:
            case ObjectID.QUEST_START_ICON_FIGHTARENA:
            case ObjectID.QUEST_START_ICON_FINALDAWN:
            case ObjectID.QUEST_START_ICON_FISHINGCONTEST:
            case ObjectID.QUEST_START_ICON_FORGETTABLETALE:
            case ObjectID.QUEST_START_ICON_FORSAKENTOWER:
            case ObjectID.QUEST_START_ICON_FREMENNIKEXILES:
            case ObjectID.QUEST_START_ICON_FREMENNIKISLES:
            case ObjectID.QUEST_START_ICON_FREMENNIKTRIALS:
            case ObjectID.QUEST_START_ICON_GARDENOFDEATH:
            case ObjectID.QUEST_START_ICON_GARDENOFTRANQUILLITY:
            case ObjectID.QUEST_START_ICON_GERTRUDESCAT:
            case ObjectID.QUEST_START_ICON_GETTINGAHEAD:
            case ObjectID.QUEST_START_ICON_GHOSTSAHOY:
            case ObjectID.QUEST_START_ICON_GIANTDWARF:
            case ObjectID.QUEST_START_ICON_GOBLINDIPLOMACY:
            case ObjectID.QUEST_START_ICON_GOLEM:
            case ObjectID.QUEST_START_ICON_GRANDTREE:
            case ObjectID.QUEST_START_ICON_GREATBRAINROBBERY:
            case ObjectID.QUEST_START_ICON_GRIMTALES:
            case ObjectID.QUEST_START_ICON_HANDINTHESAND:
            case ObjectID.QUEST_START_ICON_HAUNTEDMINE:
            case ObjectID.QUEST_START_ICON_HAZEELCULT:
            case ObjectID.QUEST_START_ICON_HEARTOFDARKNESS:
            case ObjectID.QUEST_START_ICON_HEROES:
            case ObjectID.QUEST_START_ICON_HOLYGRAIL:
            case ObjectID.QUEST_START_ICON_HORRORFROMTHEDEEP:
            case ObjectID.QUEST_START_ICON_ICTHLARINSLITTLEHELPER:
            case ObjectID.QUEST_START_ICON_IMPCATCHER:
            case ObjectID.QUEST_START_ICON_IMPENDINGCHAOS:
            case ObjectID.QUEST_START_ICON_INAIDOFTHEMYREQUE:
            case ObjectID.QUEST_START_ICON_INSEARCHOFTHEMYREQUE:
            case ObjectID.QUEST_START_ICON_JUNGLEPOTION:
            case ObjectID.QUEST_START_ICON_KINGDOMDIVIDED:
            case ObjectID.QUEST_START_ICON_KINGSRANSOM:
            case ObjectID.QUEST_START_ICON_KNIGHTSSWORD:
            case ObjectID.QUEST_START_ICON_LANDOFTHEGOBLINS:
            case ObjectID.QUEST_START_ICON_LEGENDS:
            case ObjectID.QUEST_START_ICON_LOSTCITY:
            case ObjectID.QUEST_START_ICON_LOSTTRIBE:
            case ObjectID.QUEST_START_ICON_LUNARDIPLOMACY:
            case ObjectID.QUEST_START_ICON_MAKINGFRIENDSWITHMYARM:
            case ObjectID.QUEST_START_ICON_MAKINGHISTORY:
            case ObjectID.QUEST_START_ICON_MEATANDGREET:
            case ObjectID.QUEST_START_ICON_MERLINSCRYSTAL:
            case ObjectID.QUEST_START_ICON_MISTHALINMYSTERY:
            case ObjectID.QUEST_START_ICON_MONKEYMADNESS1:
            case ObjectID.QUEST_START_ICON_MONKEYMADNESS2:
            case ObjectID.QUEST_START_ICON_MONKSFRIEND:
            case ObjectID.QUEST_START_ICON_MOUNTAINDAUGHTER:
            case ObjectID.QUEST_START_ICON_MOURNINGSENDPART1:
            case ObjectID.QUEST_START_ICON_MOURNINGSENDPART2:
            case ObjectID.QUEST_START_ICON_MURDERMYSTERY:
            case ObjectID.QUEST_START_ICON_MYARMSBIGADVENTURE:
            case ObjectID.QUEST_START_ICON_NATURESPIRIT:
            case ObjectID.QUEST_START_ICON_NIGHTATTHETHEATRE:
            case ObjectID.QUEST_START_ICON_OBSERVATORY:
            case ObjectID.QUEST_START_ICON_OLAFS:
            case ObjectID.QUEST_START_ICON_ONESMALLFAVOUR:
            case ObjectID.QUEST_START_ICON_PATHOFGLOUPHRIE:
            case ObjectID.QUEST_START_ICON_PERILOUSMOONS:
            case ObjectID.QUEST_START_ICON_PIRATESTREASURE:
            case ObjectID.QUEST_START_ICON_PLAGUECITY:
            case ObjectID.QUEST_START_ICON_PORCINEOFINTEREST:
            case ObjectID.QUEST_START_ICON_PRIESTINPERIL:
            case ObjectID.QUEST_START_ICON_PRINCEALIRESCUE:
            case ObjectID.QUEST_START_ICON_QUEENOFTHIEVES:
            case ObjectID.QUEST_START_ICON_RAGANDBONEMAN1:
            case ObjectID.QUEST_START_ICON_RAGANDBONEMAN2:
            case ObjectID.QUEST_START_ICON_RATCATCHERS:
            case ObjectID.QUEST_START_ICON_RECIPEFORDISASTER:
            case ObjectID.QUEST_START_ICON_RECRUITMENTDRIVE:
            case ObjectID.QUEST_START_ICON_REGICIDE:
            case ObjectID.QUEST_START_ICON_RESTLESSGHOST:
            case ObjectID.QUEST_START_ICON_RIBBITINGTALE:
            case ObjectID.QUEST_START_ICON_ROMEOANDJULIET:
            case ObjectID.QUEST_START_ICON_ROVINGELVES:
            case ObjectID.QUEST_START_ICON_ROYALTROUBLE:
            case ObjectID.QUEST_START_ICON_RUMDEAL:
            case ObjectID.QUEST_START_ICON_RUNEMYSTERIES:
            case ObjectID.QUEST_START_ICON_SCORPIONCATCHER:
            case ObjectID.QUEST_START_ICON_SCRAMBLED:
            case ObjectID.QUEST_START_ICON_SEASLUG:
            case ObjectID.QUEST_START_ICON_SECRETSOFTHENORTH:
            case ObjectID.QUEST_START_ICON_SHADESOFMORTTON:
            case ObjectID.QUEST_START_ICON_SHADOWOFTHESTORM:
            case ObjectID.QUEST_START_ICON_SHADOWSOFCUSTODIA:
            case ObjectID.QUEST_START_ICON_SHEEPHERDER:
            case ObjectID.QUEST_START_ICON_SHEEPSHEARER:
            case ObjectID.QUEST_START_ICON_SHIELDOFARRAV:
            case ObjectID.QUEST_START_ICON_SHILOVILLAGE:
            case ObjectID.QUEST_START_ICON_SINSOFTHEFATHER:
            case ObjectID.QUEST_START_ICON_SLEEPINGGIANTS:
            case ObjectID.QUEST_START_ICON_SLUGMENACE:
            case ObjectID.QUEST_START_ICON_SONGOFTHEELVES:
            case ObjectID.QUEST_START_ICON_SOULSBANE:
            case ObjectID.QUEST_START_ICON_SPIRITSOFTHEELID:
            case ObjectID.QUEST_START_ICON_SWANSONG:
            case ObjectID.QUEST_START_ICON_TAIBWOWANNAITRIO:
            case ObjectID.QUEST_START_ICON_TAILOFTWOCATS:
            case ObjectID.QUEST_START_ICON_TALEOFTHERIGHTEOUS:
            case ObjectID.QUEST_START_ICON_TASTEOFHOPE:
            case ObjectID.QUEST_START_ICON_TEARSOFGUTHIX:
            case ObjectID.QUEST_START_ICON_TEMPLEOFIKOV:
            case ObjectID.QUEST_START_ICON_TEMPLEOFTHEEYE:
            case ObjectID.QUEST_START_ICON_THRONEOFMISCELLANIA:
            case ObjectID.QUEST_START_ICON_TOURISTTRAP:
            case ObjectID.QUEST_START_ICON_TOWEROFLIFE:
            case ObjectID.QUEST_START_ICON_TREEGNOMEVILLAGE:
            case ObjectID.QUEST_START_ICON_TRIBALTOTEM:
            case ObjectID.QUEST_START_ICON_TROLLROMANCE:
            case ObjectID.QUEST_START_ICON_TROLLSTRONGHOLD:
            case ObjectID.QUEST_START_ICON_TUTORIAL:
            case ObjectID.QUEST_START_ICON_TWILIGHTSPROMISE:
            case ObjectID.QUEST_START_ICON_UNDERGROUNDPASS:
            case ObjectID.QUEST_START_ICON_VAMPYRESLAYER:
            case ObjectID.QUEST_START_ICON_WANTED:
            case ObjectID.QUEST_START_ICON_WATCHTOWER:
            case ObjectID.QUEST_START_ICON_WATERFALL:
            case ObjectID.QUEST_START_ICON_WHATLIESBELOW:
            case ObjectID.QUEST_START_ICON_WHILEGUTHIXSLEEPS:
            case ObjectID.QUEST_START_ICON_WITCHSHOUSE:
            case ObjectID.QUEST_START_ICON_WITCHSPOTION:
            case ObjectID.QUEST_START_ICON_XMARKSTHESPOT:
            case ObjectID.QUEST_START_ICON_ZOGREFLESHEATERS:
                if (config.gameFeaturesBoolean() || config.questConfig() == minimapCleanserConfig.QuestIconEnum.HIDE_ALL) {
                    storeAndHideObject(obj,tile);
                }
                //else if (config.questConfig() == minimapCleanserConfig.QuestIconEnum.VIEW_OUTSTANDING) {
                //Add quests not yet completed here
                //}
                break;
            case ObjectID.RAID_ICON:
                if (config.gameFeaturesBoolean() || config.raidBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.TASK_ICON:
                if (config.gameFeaturesBoolean() || config.taskBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.TRANSPORTATION_ICON_AIP:
            case ObjectID.TRANSPORTATION_ICON_AIS:
            case ObjectID.TRANSPORTATION_ICON_AIR:
            case ObjectID.TRANSPORTATION_ICON_AIQ:
            case ObjectID.TRANSPORTATION_ICON_ALP:
            case ObjectID.TRANSPORTATION_ICON_ALS:
            case ObjectID.TRANSPORTATION_ICON_ALR:
            case ObjectID.TRANSPORTATION_ICON_AKP:
            case ObjectID.TRANSPORTATION_ICON_AKS:
            case ObjectID.TRANSPORTATION_ICON_AKR:
            case ObjectID.TRANSPORTATION_ICON_AKQ:
            case ObjectID.TRANSPORTATION_ICON_AJP:
            case ObjectID.TRANSPORTATION_ICON_AJS:
            case ObjectID.TRANSPORTATION_ICON_AJR:
            case ObjectID.TRANSPORTATION_ICON_AJQ:
            case ObjectID.TRANSPORTATION_ICON_DIP:
            case ObjectID.TRANSPORTATION_ICON_DIS:
            case ObjectID.TRANSPORTATION_ICON_DIR:
            case ObjectID.TRANSPORTATION_ICON_DIQ:
            case ObjectID.TRANSPORTATION_ICON_DLP:
            case ObjectID.TRANSPORTATION_ICON_DLS:
            case ObjectID.TRANSPORTATION_ICON_DLR:
            case ObjectID.TRANSPORTATION_ICON_DLQ:
            case ObjectID.TRANSPORTATION_ICON_DKP:
            case ObjectID.TRANSPORTATION_ICON_DKS:
            case ObjectID.TRANSPORTATION_ICON_DKR:
            case ObjectID.TRANSPORTATION_ICON_DKQ:
            case ObjectID.TRANSPORTATION_ICON_DJP:
            case ObjectID.TRANSPORTATION_ICON_DJS:
            case ObjectID.TRANSPORTATION_ICON_DJR:
            case ObjectID.TRANSPORTATION_ICON_DJQ:
            case ObjectID.TRANSPORTATION_ICON_CIP:
            case ObjectID.TRANSPORTATION_ICON_CIS:
            case ObjectID.TRANSPORTATION_ICON_CIR:
            case ObjectID.TRANSPORTATION_ICON_CIQ:
            case ObjectID.TRANSPORTATION_ICON_CLP:
            case ObjectID.TRANSPORTATION_ICON_CLS:
            case ObjectID.TRANSPORTATION_ICON_CLR:
            case ObjectID.TRANSPORTATION_ICON_CLQ:
            case ObjectID.TRANSPORTATION_ICON_CKP:
            case ObjectID.TRANSPORTATION_ICON_CKS:
            case ObjectID.TRANSPORTATION_ICON_CKR:
            case ObjectID.TRANSPORTATION_ICON_CKQ:
            case ObjectID.TRANSPORTATION_ICON_CJP:
            case ObjectID.TRANSPORTATION_ICON_CJS:
            case ObjectID.TRANSPORTATION_ICON_CJR:
            case ObjectID.TRANSPORTATION_ICON_CJQ:
            case ObjectID.TRANSPORTATION_ICON_BIP:
            case ObjectID.TRANSPORTATION_ICON_BIS:
            case ObjectID.TRANSPORTATION_ICON_BIR:
            case ObjectID.TRANSPORTATION_ICON_BIQ:
            case ObjectID.TRANSPORTATION_ICON_BLP:
            case ObjectID.TRANSPORTATION_ICON_BLS:
            case ObjectID.TRANSPORTATION_ICON_BLR:
            case ObjectID.TRANSPORTATION_ICON_BLQ:
            case ObjectID.TRANSPORTATION_ICON_BKP:
            case ObjectID.TRANSPORTATION_ICON_BKS:
            case ObjectID.TRANSPORTATION_ICON_BKR:
            case ObjectID.TRANSPORTATION_ICON_BKQ:
            case ObjectID.TRANSPORTATION_ICON_BJP:
            case ObjectID.TRANSPORTATION_ICON_BJS:
            case ObjectID.TRANSPORTATION_ICON_BJR:
            case ObjectID.TRANSPORTATION_ICON_BJQ:
                if (config.gameFeaturesBoolean() || config.transportFRBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            //endregion
            //region Tutors
            case ObjectID.TUTOR_BANK_ICON:
                if (config.tutorsBoolean() || config.bankTutBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.TUTOR_BOND_ICON:
                if (config.tutorsBoolean() || config.bondTutBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.CLUESCROLL_TUTOR_ICON:
                if (config.tutorsBoolean() || config.clueTutBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.TUTOR_COMBAT_ICON:
                if (config.tutorsBoolean() || config.combatTutBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.TUTOR_COOKING_ICON:
                if (config.tutorsBoolean() || config.cookTutBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.TUTOR_CRAFTING_ICON:
                if (config.tutorsBoolean() || config.craftTutBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.TUTOR_DANGER_ICON:
                if (config.tutorsBoolean() || config.dangerTutBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.TUTOR_DEADMAN_ICON:
                if (config.tutorsBoolean() || config.deadmanTutBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.TUTOR_FISHING_ICON:
                if (config.tutorsBoolean() || config.fishTutBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.TUTOR_HUNTER_ICON:
                if (config.tutorsBoolean() || config.huntTutBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.TUTOR_IRONMAN_ICON:
                if (config.tutorsBoolean() || config.ironTutBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.LEAGUE_TUTOR_ICON:
                if (config.tutorsBoolean() || config.leaguesTutBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.TUTOR_MAIN_ICON:
                if (config.tutorsBoolean() || config.lumbyTutBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.TUTOR_MINING_ICON:
                if (config.tutorsBoolean() || config.mineTutBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.TUTOR_PRAYER_ICON:
                if (config.tutorsBoolean() || config.prayTutBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.TUTOR_SECURITY_ICON:
                if (config.tutorsBoolean() || config.securityTutBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.TUTOR_SMITHING_ICON:
                if (config.tutorsBoolean() || config.smithTutBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.TUTOR_WOODCUTTING_ICON:
                if (config.tutorsBoolean() || config.wcTutBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            //endregion
            //region Training
            case ObjectID.AGILITY_TRAINING_ICON:
                if (config.trainingBoolean() || config.agiligyTrainConfig() == minimapCleanserConfig.AgilityTrainIconEnum.HIDE_ALL) {
                    storeAndHideObject(obj,tile);
                }
                //else if (config.agiligyTrainConfig() == minimapCleanserConfig.AgilityTrainIconEnum.VIEW_ABLE_ONLY) {
                //Add shortcut ability here
                //}
                break;
            case ObjectID.ANVIL_ICON:
                if (config.trainingBoolean() || config.anvilBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.BIRD_HOUSE_ICON:
                if (config.trainingBoolean() || config.birdhousesBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.BREWING_ICON:
                if (config.trainingBoolean() || config.breweryBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.COMBATTRAINING_STORE_ICON: // COMBAT TRAINING DUMMY
                if (config.trainingBoolean() || config.dummyBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.RANGE_ICON_KITCHEN:
            case ObjectID.RANGE_ICON:
                if (config.trainingBoolean() || config.cookRangeBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.MILK_CHURN_ICON:
                if (config.trainingBoolean() || config.dairyBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.DAIRY_COW_ICON:
                if (config.trainingBoolean() || config.dairyCowBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.FARMING_PATCH_ICON:
                if (config.trainingBoolean() || config.farmPatchBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.FISHING_POINT_ICON:
                if (config.trainingBoolean() || config.fishSpotBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.FURNACE_ICON:
                if (config.trainingBoolean() || config.furnaceBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.GIANTS_FOUNDRY_TOOL_GRINDSTONE: // NOT SURE ABOUT THIS ----------------------------------------
                if (config.trainingBoolean() || config.grindBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.HUNTING_AREA_ICON:
                if (config.trainingBoolean() || config.huntTrainingBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.LOOM_ICON:
                if (config.trainingBoolean() || config.loomBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.MINING_SITE_ICON:
                if (config.trainingBoolean() || config.miningSiteBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.GIANTS_FOUNDRY_TOOL_POLISHING_WHEEL: // NOT SURE ABOUT THIS ----------------------------------------
                if (config.trainingBoolean() || config.polishWheelBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.POTTERY_ICON:
                if (config.trainingBoolean() || config.potteryWheelBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.RARE_TREES_ICON:
                if (config.trainingBoolean() || config.rareTreesBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.SANDPIT_ICON:
                if (config.trainingBoolean() || config.sandBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.SINGING_BOWL_ICON:
                if (config.trainingBoolean() || config.singbowlBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.SLAYER_MASTER_ICON:
                if (config.trainingBoolean() || config.slayerMasterBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.SPINNINGWHEEL_ICON:
                if (config.trainingBoolean() || config.spinWheelBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.STAGNENT_WATER_ICON:
                if (config.trainingBoolean() || config.stagnantWaterBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.THIEVING_ICON:
                if (config.trainingBoolean() || config.thiefActivityBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.GIANTS_FOUNDRY_TOOL_TRIP_HAMMER: // NOT SURE ABOUT THIS ----------------------------------------
                if (config.trainingBoolean() || config.tripHammerBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.V3_TOTEM_ICON:
                if (config.trainingBoolean() || config.valeTotemBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.WATER_SOURCE_ICON_KITCHEN:
            case ObjectID.WATER_SOURCE_ICON:
                if (config.trainingBoolean() || config.waterSourceBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.FLOUR_MILL_ICON :
                if (config.trainingBoolean() || config.windmillBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.FRIS_TREESTUMP_ICON:
                if (config.trainingBoolean() || config.wcStumpBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            //endregion
            //region Shopping
            case ObjectID.AMULET_STORE_ICON:
                if (config.shoppingBoolean() || config.amuletShopBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.POTIONS_STORE_ICON: // apothecary
                if (config.shoppingBoolean() || config.apothecaryBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.ARCHERY_STORE_ICON:
                if (config.shoppingBoolean() || config.archeryShopBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.AXE_STORE_ICON:
                if (config.shoppingBoolean() || config.axeShopBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.BH_ICON:
                if (config.shoppingBoolean() || config.BHshopBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.CANDLE_STORE_ICON:
                if (config.shoppingBoolean() || config.candleShopBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.CHAIN_SHOP_ICON:
                if (config.shoppingBoolean() || config.chainbodyShopBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.CLOTHING_STORE_ICON:
                if (config.shoppingBoolean() || config.clothesShopBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.COOKING_STORE_ICON:
                if (config.shoppingBoolean() || config.cookeryShopBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.CRAFTING_STORE_ICON:
                if (config.shoppingBoolean() || config.craftingShopBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.DYE_TRADER_ICON:
                if (config.shoppingBoolean() || config.dyeShopBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.POH_ESTATEAGENT_ICON:
                if (config.shoppingBoolean() || config.estateBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.FARM_SHOP_ICON:
                if (config.shoppingBoolean() || config.farmingShopBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.FISHING_STORE_ICON:
                if (config.shoppingBoolean() || config.fishingShopBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.FOOD_STORE_ICON:
                if (config.shoppingBoolean() || config.foodShopBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.FORESTRY_SHOP_ICON:
                if (config.shoppingBoolean() || config.forestryShopBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.FUR_STORE_ICON:
                if (config.shoppingBoolean() || config.furShopBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.GARDEN_SUPPLIER_ICON:
                if (config.shoppingBoolean() || config.gardenSupplierBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.GEM_STORE_ICON:
                if (config.shoppingBoolean() || config.gemShopBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.GENERAL_STORE_ICON:
                if (config.shoppingBoolean() || config.generalStoreBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.GE_MAPICON_EXCHANGE:
                if (config.shoppingBoolean() || config.GEBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.HELMET_STORE_ICON:
                if (config.shoppingBoolean() || config.helmetShopBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.HERBALIST_STORE_ICON:
                if (config.shoppingBoolean() || config.herbalistBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.HOLIDAY_SHOP_ICON:
                if (config.shoppingBoolean() || config.holidayItemsBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.HUNTING_SHOP_ICON:
                if (config.shoppingBoolean() || config.hunterShopBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.JEWLERY_STORE_ICON:
                if (config.shoppingBoolean() || config.jewelleryShopBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.QUEST_SHOP_ICON:
                if (config.shoppingBoolean() || config.WOMBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.KEBAB_STORE_ICON:
                if (config.shoppingBoolean() || config.kebabShopBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.MACE_STORE_ICON:
                if (config.shoppingBoolean() || config.maceShopBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.MAGIC_STORE_ICON:
                if (config.shoppingBoolean() || config.magicShopBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.MINING_SHOP_ICON:
                if (config.shoppingBoolean() || config.miningShopBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.NEWSPAPER_TRADER_ICON:
                if (config.shoppingBoolean() || config.newspaperBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.PET_ICON:
                if (config.shoppingBoolean() || config.petInsuranceBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.PLATE_STORE_ICON:
                if (config.shoppingBoolean() || config.platebodyShopBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.PLATELEGS_STORE_ICON:
                if (config.shoppingBoolean() || config.platelegsShopBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.SKIRTS_STORE_ICON:
                if (config.shoppingBoolean() || config.skirtShopBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.GE_MAPICON_RUNES:
                if (config.shoppingBoolean() || config.pricingExpertsRuneBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.GE_MAPICON_HERBS:
                if (config.shoppingBoolean() || config.pricingExpertsHerbsBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.GE_MAPICON_LOGS:
                if (config.shoppingBoolean() || config.pricingExpertsLogsBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.GE_MAPICON_ORES:
                if (config.shoppingBoolean() || config.pricingExpertsOreBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.GE_MAPICON_COMBAT:
                if (config.shoppingBoolean() || config.pricingExpertsWeaponBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.BEER_STORE_ICON:
                if (config.shoppingBoolean() || config.pubBarBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.ROPE_TRADER_ICON:
                if (config.shoppingBoolean() || config.ropeShopBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.POH_SAWMILL_ICON:
                if (config.shoppingBoolean() || config.sawmillBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.SCIMITAR_STORE_ICON:
                if (config.shoppingBoolean() || config.scimitarShopBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.SHIELD_STORE_ICON:
                if (config.shoppingBoolean() || config.shieldShopBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.SILK_STORE_ICON:
                if (config.shoppingBoolean() || config.silkShopBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.SILVER_STORE_ICON:
                if (config.shoppingBoolean() || config.silverShopBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.SPEEDRUNNING_ICON:
                if (config.shoppingBoolean() || config.speedShopBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.SPICE_STORE_ICON:
                if (config.shoppingBoolean() || config.spiceShopBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.STAFF_STORE_ICON:
                if (config.shoppingBoolean() || config.staffShopBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.POH_STONEMASON_ICON:
                if (config.shoppingBoolean() || config.stonemasonBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.SWORD_STORE_ICON:
                if (config.shoppingBoolean() || config.swordShopBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.TANNER_STORE_ICON:
                if (config.shoppingBoolean() || config.tanneryBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.TAXIDERMIST_ICON:
                if (config.shoppingBoolean() || config.taxidermistBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.TEA_SELLER_ICON:
                if (config.shoppingBoolean() || config.teaShopBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.VEG_STORE_ICON:
                if (config.shoppingBoolean() || config.vegShopBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            case ObjectID.WINE_TRADER_ICON:
                if (config.shoppingBoolean() || config.wineShopBoolean()) {
                    storeAndHideObject(obj,tile);
                }
                break;
            //endregion
            default:
                //
        }
    }

    private void storeAndHideObject(GroundObject obj, Tile tile) {
        this.hiddenObjects.put(tile.getWorldLocation(), obj);
        tile.setGroundObject(null);
    }

    private void refreshSceneGroundObjects(boolean rehide) {
        final Scene scene = client.getScene();
        final Tile[][][] tiles = scene.getTiles();

        if (tiles != null) {
            for (int plane = 0; plane < tiles.length; plane++) {
                for (int x = 0; x < tiles[plane].length; x++) {
                    for (int y = 0; y < tiles[plane][x].length; y++) {

                        final Tile currentTile = tiles[plane][x][y];
                        if (currentTile != null) {
                            final GroundObject groundObj = currentTile.getGroundObject();

                            if (groundObj == null && this.hiddenObjects.containsKey(currentTile.getWorldLocation())) {
                                GroundObject oHidden = this.hiddenObjects.get(currentTile.getWorldLocation());
                                currentTile.setGroundObject(oHidden);
                                this.hiddenObjects.remove(currentTile.getWorldLocation());
                            }

                            if (rehide) {
                                checkObjects(currentTile.getGroundObject(), currentTile);
                            }
                        }
                    }
                }
            }
        }
        clientThread.invoke(() -> {
            if (client.getGameState() == GameState.LOGGED_IN) {
                client.setGameState(GameState.LOADING);
            }
        });
    }

	@Provides
    minimapCleanserConfig provideConfig(ConfigManager configManager) {
		return configManager.getConfig(minimapCleanserConfig.class);
	}
}