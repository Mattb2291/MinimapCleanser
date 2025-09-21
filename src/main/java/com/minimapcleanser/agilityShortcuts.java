package com.minimapcleanser;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Skill;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.gameval.VarbitID;

import java.util.List;
import java.util.Map;

import static java.util.Map.entry;

@Slf4j
enum agilityShortcuts
{
    // Some shortcuts only require partial completion of quests, but for ease for now this assumes full completion to display
    // Some shortcuts also can't be boosted, but again for ease this only checks the boosted level as for the majority of cases the agility skill wouldn't naturally be boosted

    CRUMBLING_WALL_1(new WorldPoint(2937, 3357, 0),Map.ofEntries(entry(Skill.AGILITY, 5)),null,null),
    BROKEN_RAFT_LUMBRIDGE(new WorldPoint(3246, 3179, 0),Map.ofEntries(entry(Skill.AGILITY, 8), entry(Skill.STRENGTH, 19), entry(Skill.RANGED, 37)),null,null),
    BROKEN_RAFT_AL_KHARID(new WorldPoint(3259, 3179, 0),Map.ofEntries(entry(Skill.AGILITY, 8), entry(Skill.STRENGTH, 19), entry(Skill.RANGED, 37)),null,null),
    ROCKS_1(new WorldPoint(2546, 2871, 0),Map.ofEntries(entry(Skill.AGILITY, 10)),null,null),
    WALL_1(new WorldPoint(3032, 3391, 0),Map.ofEntries(entry(Skill.AGILITY, 11), entry(Skill.STRENGTH, 37), entry(Skill.RANGED, 19)),null,null),
    FENCE(new WorldPoint(3240, 3334, 0),Map.ofEntries(entry(Skill.AGILITY, 13)),null,null),
    TIGHT_GAP_1(new WorldPoint(2926, 3523, 0),Map.ofEntries(entry(Skill.AGILITY, 14)),Map.ofEntries(entry(VarbitID.FALADOR_EASY_REWARD ,0)),null),
    PILLAR_1(new WorldPoint(1981, 8996, 1),Map.ofEntries(entry(Skill.AGILITY, 15)),Map.ofEntries(entry(VarbitID.CORSAIR_COVE_RESOURCE_ENTRY ,0)), List.of(quests.DRAGONSLAYER1)),
    UNDERWALL_TUNNEL_1(new WorldPoint(2575, 3109, 0),Map.ofEntries(entry(Skill.AGILITY, 16)),null,null),
    CRACK_1_SOUTH(new WorldPoint(1646, 10001, 0),Map.ofEntries(entry(Skill.AGILITY, 17)),null,null),
    CRACK_1_NORTH(new WorldPoint(1648, 10008, 0),Map.ofEntries(entry(Skill.AGILITY, 17)),null,null),
    LOG_BALANCE_1(new WorldPoint(2599, 3475, 0),Map.ofEntries(entry(Skill.AGILITY, 20)),null,null),
    UNDERWALL_TUNNEL_2(new WorldPoint(3140, 3515, 0),Map.ofEntries(entry(Skill.AGILITY, 21)),null,null),
    PIPE_1(new WorldPoint(2655, 9569, 0),Map.ofEntries(entry(Skill.AGILITY, 22)),null,null),
    ROCKS_2(new WorldPoint(2448, 3155, 0),Map.ofEntries(entry(Skill.AGILITY, 23), entry(Skill.STRENGTH, 28), entry(Skill.RANGED, 24)),null,List.of(quests.OBSERVATORY)),
    BROKEN_WALL_SOUTH(new WorldPoint(1369, 3295, 0),Map.ofEntries(entry(Skill.AGILITY, 24)),null,null),
    BROKEN_WALL_SOUTH_EAST(new WorldPoint(1387, 3302, 0),Map.ofEntries(entry(Skill.AGILITY, 24)),null,null),
    BROKEN_WALL_EAST(new WorldPoint(1390, 3309, 0),Map.ofEntries(entry(Skill.AGILITY, 24)),null,null),
    ROCKS_3(new WorldPoint(2321, 3499, 0),Map.ofEntries(entry(Skill.AGILITY, 25)),null,null),
    UNDERWALL_TUNNEL_3(new WorldPoint(2948, 3313, 0),Map.ofEntries(entry(Skill.AGILITY, 26)),null,null),
    STONES_SOUTH(new WorldPoint(1610, 10060, 0),Map.ofEntries(entry(Skill.AGILITY, 28)),null,null),
    STONES_NORTH(new WorldPoint(1614, 10071, 0),Map.ofEntries(entry(Skill.AGILITY, 28)),null,null),
    ROCKS_5(new WorldPoint(1325, 3782, 0),Map.ofEntries(entry(Skill.AGILITY, 29)),null,null),
    ROCKS_6(new WorldPoint(2487, 2898, 0),Map.ofEntries(entry(Skill.AGILITY, 30)),Map.ofEntries(entry(VarbitID.CORSAIR_COVE_RESOURCE_ENTRY ,0)),List.of(quests.DRAGONSLAYER1)),
    STEPPING_STONES_3(new WorldPoint(2925, 2946, 0),Map.ofEntries(entry(Skill.AGILITY, 30)),null,null),
    STEPPING_STONE_1(new WorldPoint(3151, 3362, 0),Map.ofEntries(entry(Skill.AGILITY, 31)),null,null),
    ROCKS_7(new WorldPoint(2869, 3429, 0),Map.ofEntries(entry(Skill.AGILITY, 32), entry(Skill.STRENGTH, 35), entry(Skill.RANGED, 35)),null,null),
    STEPPING_STONE_2(new WorldPoint(2864, 2974, 0),Map.ofEntries(entry(Skill.AGILITY, 32)),null,null),
    LOG_BALANCE_3(new WorldPoint(2603, 3336, 0),Map.ofEntries(entry(Skill.AGILITY, 33)),null,null),
    TUNNEL_1(new WorldPoint(1368, 3325, 0),Map.ofEntries(entry(Skill.AGILITY, 33)),null,null),
    CRACK_2_SOUTH(new WorldPoint(1716, 10057, 0),Map.ofEntries(entry(Skill.AGILITY, 34)),null,null),
    CRACK_2_NORTH(new WorldPoint(1706, 10077, 0),Map.ofEntries(entry(Skill.AGILITY, 34)),null,null),
    TRELLIS(new WorldPoint(3228, 3471, 0),Map.ofEntries(entry(Skill.AGILITY, 35)),null,List.of(quests.GARDENOFTRANQUILLITY)),
    STEPPING_STONE_3(new WorldPoint(1396, 3309, 0),Map.ofEntries(entry(Skill.AGILITY, 36)),null,null),
    ROCKS_8(new WorldPoint(2486, 3515, 0),Map.ofEntries(entry(Skill.AGILITY, 37)),null,List.of(quests.GRANDTREE, quests.TREEGNOMEVILLAGE)),
    ROCKS_9(new WorldPoint(3306, 3315, 0),Map.ofEntries(entry(Skill.AGILITY, 38)),null,null),
    WALL_2(new WorldPoint(2553, 3072, 0),Map.ofEntries(entry(Skill.AGILITY, 39), entry(Skill.STRENGTH, 38), entry(Skill.RANGED, 21)),null,null),
    STEPPING_STONES_4_EAST(new WorldPoint(1613, 3570, 0),Map.ofEntries(entry(Skill.AGILITY, 40)),null,null),
    STEPPING_STONES_4_WEST(new WorldPoint(1605, 3572, 0),Map.ofEntries(entry(Skill.AGILITY, 40)),null,null),
    LOG_BALANCE_4(new WorldPoint(1284, 3144, 0),Map.ofEntries(entry(Skill.AGILITY, 40)),null,null),
    ROCKS_10(new WorldPoint(2870, 3670, 0),Map.ofEntries(entry(Skill.AGILITY, 41)),null,null),
    ROCKS_NEMUS_RETREAT(new WorldPoint(1394, 3322, 0),Map.ofEntries(entry(Skill.AGILITY, 41)),null,null),
    NARROW_CREVICE_1(new WorldPoint(3035, 9806, 0),Map.ofEntries(entry(Skill.AGILITY, 42)),null,null),
    UNDERWALL_TUNNEL_4(new WorldPoint(3069, 3261, 0),Map.ofEntries(entry(Skill.AGILITY, 42)),null,null),
    ROCKS_11(new WorldPoint(2877, 3666, 0),Map.ofEntries(entry(Skill.AGILITY, 43)),null,null),
    CREVICE_1(new WorldPoint(2730, 10008, 0),Map.ofEntries(entry(Skill.AGILITY, 43)),null,null),
    ROCKS_12(new WorldPoint(1272, 3001, 0),Map.ofEntries(entry(Skill.AGILITY, 43)),null,null),
    ROCKS_13(new WorldPoint(2908, 3686, 0),Map.ofEntries(entry(Skill.AGILITY, 44)),null,null),
    STEPPING_STONES_5(new WorldPoint(1721, 3551, 0),Map.ofEntries(entry(Skill.AGILITY, 45)),null,null),
    LOG_BALANCE_6(new WorldPoint(1402, 3287, 0),Map.ofEntries(entry(Skill.AGILITY, 45)),null,null),
    ROCKS_14(new WorldPoint(1589, 3260, 0),Map.ofEntries(entry(Skill.AGILITY, 45)),null,null),
    JUTTING_WALL_1(new WorldPoint(2400, 4403, 0),Map.ofEntries(entry(Skill.AGILITY, 46)),null,null),
    NARROW_CREVICE_2_SOUTH(new WorldPoint(3046, 10327, 0),Map.ofEntries(entry(Skill.AGILITY, 46)),Map.ofEntries(entry(VarbitID.WILDERNESS_MEDIUM_REWARD,0)),null),
    NARROW_CREVICE_2_NORTH(new WorldPoint(3048, 10335, 0),Map.ofEntries(entry(Skill.AGILITY, 46)),Map.ofEntries(entry(VarbitID.WILDERNESS_MEDIUM_REWARD,0)),null),
    LOG_BALANCE_AND_STEPPING_STONE_1(new WorldPoint(1304, 9399, 0),Map.ofEntries(entry(Skill.AGILITY, 46)),null,null),
    LOG_BALANCE_AND_STEPPING_STONE_2(new WorldPoint(1315, 9379, 0),Map.ofEntries(entry(Skill.AGILITY, 46)),null,null),
    ROCKS_15(new WorldPoint(2903, 3680, 0),Map.ofEntries(entry(Skill.AGILITY, 47)),null,null),
    ROCKS_16_EAST(new WorldPoint(1464, 3128, 0),Map.ofEntries(entry(Skill.AGILITY, 47)),null,null),
    ROCKS_16_WEST(new WorldPoint(1456, 3128, 0),Map.ofEntries(entry(Skill.AGILITY, 47)),null,null),
    LOG_BALANCE_7(new WorldPoint(2722, 3591, 0),Map.ofEntries(entry(Skill.AGILITY, 48)),null,null),
    BOULDER(new WorldPoint(1775, 3888, 0),Map.ofEntries(entry(Skill.AGILITY, 49)),null,null),
    STEPPING_STONE_4(new WorldPoint(3419, 3326, 0),Map.ofEntries(entry(Skill.AGILITY, 50)),null,null),
    OBSTACLE_PIPE_2(new WorldPoint(3153, 9905, 0),Map.ofEntries(entry(Skill.AGILITY, 51)),null,null),
    ROCKS_17(new WorldPoint(1771, 3851, 0),Map.ofEntries(entry(Skill.AGILITY, 52)),null,null),
    STRONG_TREE_SOUTH(new WorldPoint(2875, 3128, 0),Map.ofEntries(entry(Skill.AGILITY, 53), entry(Skill.STRENGTH, 21), entry(Skill.RANGED, 42)),null,null),
    STRONG_TREE_NORTH(new WorldPoint(2874, 3143, 0),Map.ofEntries(entry(Skill.AGILITY, 53), entry(Skill.STRENGTH, 21), entry(Skill.RANGED, 42)),null,null),
    ROCKS_18(new WorldPoint(1341, 2916, 0),Map.ofEntries(entry(Skill.AGILITY, 54)),null,null),
    DARK_TUNNEL_1_SOUTH(new WorldPoint(3744, 5641, 0),Map.ofEntries(entry(Skill.AGILITY, 54)),Map.ofEntries(entry(VarbitID.FALADOR_EASY_REWARD,0),entry(VarbitID.FALADOR_MEDIUM_REWARD ,0)),null),
    DARK_TUNNEL_1_NORTH(new WorldPoint(3745, 5646, 0),Map.ofEntries(entry(Skill.AGILITY, 54)),Map.ofEntries(entry(VarbitID.FALADOR_EASY_REWARD,0),entry(VarbitID.FALADOR_MEDIUM_REWARD ,0)),null),
    DARK_TUNNEL_2_EAST(new WorldPoint(3765, 5671, 0),Map.ofEntries(entry(Skill.AGILITY, 54)),Map.ofEntries(entry(VarbitID.FALADOR_EASY_REWARD,0),entry(VarbitID.FALADOR_MEDIUM_REWARD ,0)),null),
    DARK_TUNNEL_2_WEST(new WorldPoint(3759, 5670, 0),Map.ofEntries(entry(Skill.AGILITY, 54)),Map.ofEntries(entry(VarbitID.FALADOR_EASY_REWARD,0),entry(VarbitID.FALADOR_MEDIUM_REWARD ,0)),null),
    STEPPING_STONE_5(new WorldPoint(2573, 3862, 0),Map.ofEntries(entry(Skill.AGILITY, 55)),null,null),
    STEPPING_STONES_6_SOUTH(new WorldPoint(2694, 9529, 0),Map.ofEntries(entry(Skill.AGILITY, 56)),null,null),
    STEPPING_STONES_6_NORTH(new WorldPoint(2686, 9547, 0),Map.ofEntries(entry(Skill.AGILITY, 56)),null,null),
    BROKEN_FENCE(new WorldPoint(2689, 3697, 0),Map.ofEntries(entry(Skill.AGILITY, 57)),null,null),
    ROCKS_19(new WorldPoint(2346, 3300, 0),Map.ofEntries(entry(Skill.AGILITY, 59)),null,List.of(quests.REGICIDE)),
    ROCKY_HANDHOLDS_2_EAST(new WorldPoint(2944, 3770, 0),Map.ofEntries(entry(Skill.AGILITY, 60)),null,List.of(quests.TROLLSTRONGHOLD)),
    ROCKY_HANDHOLDS_2_WEST(new WorldPoint(2929, 3760, 0),Map.ofEntries(entry(Skill.AGILITY, 60)),null,List.of(quests.TROLLSTRONGHOLD)),
    LITTLE_CRACK(new WorldPoint(2901, 3712, 0),Map.ofEntries(entry(Skill.AGILITY, 60)),null,null),
    STEPPING_STONE_6(new WorldPoint(3711, 2970, 0),Map.ofEntries(entry(Skill.AGILITY, 60)),null,null),
    GAP_1(new WorldPoint(1630, 4023, 1),Map.ofEntries(entry(Skill.AGILITY, 60)),null,null),
    TUNNEL_2_EAST(new WorldPoint(2990, 9547, 0),Map.ofEntries(entry(Skill.AGILITY, 60)),null,null),
    TUNNEL_2_WEST(new WorldPoint(2969, 9549, 0),Map.ofEntries(entry(Skill.AGILITY, 60)),null,null),
    SPIKEY_CHAIN_1_BOTTOM(new WorldPoint(3421, 3551, 0),Map.ofEntries(entry(Skill.AGILITY, 61)),null,null),
    SPIKEY_CHAIN_1_TOP(new WorldPoint(3422, 3550, 1),Map.ofEntries(entry(Skill.AGILITY, 61)),null,null),
    STRANGE_FLOOR_1(new WorldPoint(2771, 10003, 0),Map.ofEntries(entry(Skill.AGILITY, 61)),null,null),
    ROCKS_20(new WorldPoint(1323, 3791, 0),Map.ofEntries(entry(Skill.AGILITY, 62)),null,null),
    STEPPING_STONE_7_1(new WorldPoint(3294, 2706, 0),Map.ofEntries(entry(Skill.AGILITY, 62)),null,null),
    STEPPING_STONE_7_2(new WorldPoint(3292, 2700, 0),Map.ofEntries(entry(Skill.AGILITY, 62)),null,null),
    LOOSE_RAILING(new WorldPoint(2936, 9811, 0),Map.ofEntries(entry(Skill.AGILITY, 63)),null,null),
    WALL_3(new WorldPoint(3670, 3375, 1),Map.ofEntries(entry(Skill.AGILITY, 63)),null,null),
    STRANGE_FLOOR_2(new WorldPoint(1820, 9946, 0),Map.ofEntries(entry(Skill.AGILITY, 63)),null,null),
    ROCKS_21(new WorldPoint(2946, 3678, 0),Map.ofEntries(entry(Skill.AGILITY, 64)),null,null),
    ROPE(new WorldPoint(3781, 3822, 0),Map.ofEntries(entry(Skill.AGILITY, 64)),null,null),
    STEPPING_STONE_8(new WorldPoint(1309, 9784, 0),Map.ofEntries(entry(Skill.AGILITY, 64)),null,null),
    ORNATE_RAILING(new WorldPoint(3423, 3476, 0),Map.ofEntries(entry(Skill.AGILITY, 65)),null,List.of(quests.PRIESTINPERIL)),
    PILLAR_JUMP_EASY(new WorldPoint(3221, 10086, 0),Map.ofEntries(entry(Skill.AGILITY, 65)),null,null),
    CLIMBING_ROCKS_2(new WorldPoint(2946, 3439, 0),Map.ofEntries(entry(Skill.AGILITY, 66)),null,null),
    JUTTING_WALL_2(new WorldPoint(2409, 4401, 0),Map.ofEntries(entry(Skill.AGILITY, 66)),null,null),
    STEPPING_STONE_9(new WorldPoint(3211, 3135, 0),Map.ofEntries(entry(Skill.AGILITY, 66)),null,null),
    CREVICE_2_SOUTH(new WorldPoint(2914, 9895, 0),Map.ofEntries(entry(Skill.AGILITY, 67)),Map.ofEntries(entry(VarbitID.FALADOR_HARD_REWARD ,0)),List.of(quests.HEROES)),
    CREVICE_2_NORTH(new WorldPoint(2899, 9901, 0),Map.ofEntries(entry(Skill.AGILITY, 67)),Map.ofEntries(entry(VarbitID.FALADOR_HARD_REWARD ,0)),List.of(quests.HEROES)),
    ROCKS_22(new WorldPoint(2338, 3288, 0),Map.ofEntries(entry(Skill.AGILITY, 68)),null,List.of(quests.REGICIDE)),
    ROCKS_23(new WorldPoint(2999, 3484, 0),Map.ofEntries(entry(Skill.AGILITY, 68)),null,null),
    ROCKS_24(new WorldPoint(1760, 3873, 0),Map.ofEntries(entry(Skill.AGILITY, 69)),null,null),
    OBSTACLE_PIPE_3(new WorldPoint(2887, 9798, 0),Map.ofEntries(entry(Skill.AGILITY, 70)),null,null),
    HOLE_SOUTH(new WorldPoint(3715, 3816, 0),Map.ofEntries(entry(Skill.AGILITY, 70)),null,null),
    HOLE_NORTH(new WorldPoint(3713, 3828, 0),Map.ofEntries(entry(Skill.AGILITY, 70)),null,null),
    ARMADYL(new WorldPoint(2872, 5280, 2),Map.ofEntries(entry(Skill.RANGED, 70)),null,null),
    ROCK_FIRST(new WorldPoint(2913, 5300, 2),Map.ofEntries(entry(Skill.AGILITY, 70)),null,null),
    ROCK_SECOND(new WorldPoint(2920, 5275, 1),Map.ofEntries(entry(Skill.AGILITY, 70)),null,null),
    BIG_WINDOWBROKEN_WALL(new WorldPoint(3294, 3158, 0),Map.ofEntries(entry(Skill.AGILITY, 70)),null,List.of(quests.PRINCEALIRESCUE)),
    SPIKEY_CHAIN_2_BOTTOM(new WorldPoint(3448, 3578, 1),Map.ofEntries(entry(Skill.AGILITY, 71)),null,null),
    SPIKEY_CHAIN_2_TOP(new WorldPoint(3447, 3576, 2),Map.ofEntries(entry(Skill.AGILITY, 71)),null,null),
    CRUMBLING_WALL_2(new WorldPoint(2546, 3032, 0),Map.ofEntries(entry(Skill.AGILITY, 71)),null,null),
    STEPPING_STONE_10(new WorldPoint(3372, 2958, 0),Map.ofEntries(entry(Skill.AGILITY, 71)),null,null),
    STEPPING_STONE_11(new WorldPoint(1577, 3251, 1),Map.ofEntries(entry(Skill.AGILITY, 71)),null,null),
    DRY_STONE_WALL(new WorldPoint(3545, 3282, 0),Map.ofEntries(entry(Skill.AGILITY, 72)),null,null),
    STEPPING_STONE_12(new WorldPoint(3268, 3628, 0),Map.ofEntries(entry(Skill.AGILITY, 72)),null,null),
    TUNNEL_3(new WorldPoint(2432, 9806, 0),Map.ofEntries(entry(Skill.AGILITY, 72)),null,null),
    TUNNEL_4_NORTH(new WorldPoint(3026, 9570, 0),Map.ofEntries(entry(Skill.AGILITY, 72)),null,null),
    TUNNEL_4_SOUTH(new WorldPoint(3034, 9559, 0),Map.ofEntries(entry(Skill.AGILITY, 72)),null,null),
    ROCKS_25(new WorldPoint(2842, 3694, 0),Map.ofEntries(entry(Skill.AGILITY, 73)),null,List.of(quests.MYARMSBIGADVENTURE)),
    ROCKS_26(new WorldPoint(1743, 3853, 0),Map.ofEntries(entry(Skill.AGILITY, 73)),null,null),
    GAP_2(new WorldPoint(1443, 10098, 1),Map.ofEntries(entry(Skill.AGILITY, 73)),null,null),
    STEPPING_STONE_13(new WorldPoint(3201, 3807, 0),Map.ofEntries(entry(Skill.AGILITY, 74)),null,null),
    CAVE_2_NORTH(new WorldPoint(3560, 9811, 0),Map.ofEntries(entry(Skill.AGILITY, 74)),null,null),
    CAVE_2_SOUTH(new WorldPoint(3555, 9786, 0),Map.ofEntries(entry(Skill.AGILITY, 74)),null,null),
    PILLAR_JUMP_MEDIUM_NORTH(new WorldPoint(3181, 10209, 0),Map.ofEntries(entry(Skill.AGILITY, 75)),null,null),
    PILLAR_JUMP_MEDIUM_MIDDLE(new WorldPoint(3202, 10195, 0),Map.ofEntries(entry(Skill.AGILITY, 75)),null,null),
    PILLAR_JUMP_MEDIUM_SOUTH(new WorldPoint(3200, 10135, 0),Map.ofEntries(entry(Skill.AGILITY, 75)),null,null),
    PILLAR_2(new WorldPoint(1311, 9508, 1),Map.ofEntries(entry(Skill.AGILITY, 75)),null,null),
    STEPPING_STONE_14(new WorldPoint(2157, 3073, 0),Map.ofEntries(entry(Skill.AGILITY, 76)),null,List.of(quests.REGICIDE)),
    ROCKS_27(new WorldPoint(1478, 3307, 0),Map.ofEntries(entry(Skill.AGILITY, 76)),null,null),
    CREVICE_3_NORTH_WEST(new WorldPoint(3342, 10149, 0),Map.ofEntries(entry(Skill.AGILITY, 77)),null,null),
    CREVICE_3_WEST(new WorldPoint(3334, 10119, 0),Map.ofEntries(entry(Skill.AGILITY, 77)),null,null),
    CREVICE_3_EAST(new WorldPoint(3435, 10115, 0),Map.ofEntries(entry(Skill.AGILITY, 77)),null,null),
    TIGHT_GAP_2_EAST(new WorldPoint(3222, 12441, 0),Map.ofEntries(entry(Skill.AGILITY, 78)),null,null),
    TIGHT_GAP_2_WEST(new WorldPoint(3216, 12441, 0),Map.ofEntries(entry(Skill.AGILITY, 78)),null,null),
    ROCKS_28(new WorldPoint(2871, 3003, 0),Map.ofEntries(entry(Skill.AGILITY, 79)),null,null),
    VINE_1(new WorldPoint(2898, 2939, 0),Map.ofEntries(entry(Skill.AGILITY, 79)),null,List.of(quests.LEGENDS)),
    STRANGE_FLOOR_3(new WorldPoint(2878, 9813, 0),Map.ofEntries(entry(Skill.AGILITY, 80)),null,null),
    CREVICE_4(new WorldPoint(1853, 4406, 3),Map.ofEntries(entry(Skill.AGILITY, 81)),null,null),
    STEPPING_STONE_15(new WorldPoint(3093, 3880, 0),Map.ofEntries(entry(Skill.AGILITY, 82)),null,null),
    TUNNEL_5_EAST(new WorldPoint(3023, 9553, 0),Map.ofEntries(entry(Skill.AGILITY, 82)),null,null),
    TUNNEL_5_WEST(new WorldPoint(3013, 9549, 1),Map.ofEntries(entry(Skill.AGILITY, 82)),null,null),
    CHAIN(new WorldPoint(1436, 10076, 2),Map.ofEntries(entry(Skill.AGILITY, 83)),null,null),
    ROCKS_29(new WorldPoint(2832, 3252, 0),Map.ofEntries(entry(Skill.AGILITY, 84)),null,null),
    TIGHT_GAP_3_WEST(new WorldPoint(3232, 12420, 0),Map.ofEntries(entry(Skill.AGILITY, 84)),null,null),
    TIGHT_GAP_3_EAST(new WorldPoint(3242, 12420, 0),Map.ofEntries(entry(Skill.AGILITY, 84)),null,null),
    ROCKS_30(new WorldPoint(2547, 3750, 0),Map.ofEntries(entry(Skill.AGILITY, 85)),null,null),
    ROCKS_31(new WorldPoint(2338, 3253, 0),Map.ofEntries(entry(Skill.AGILITY, 85)),null,List.of(quests.REGICIDE)),
    CREVICE_5(new WorldPoint(3503, 9508, 0),Map.ofEntries(entry(Skill.AGILITY, 86)),Map.ofEntries(entry(VarbitID.DESERT_ELITE_REWARD ,0)),null),
    VINE_2(new WorldPoint(2673, 9582, 0),Map.ofEntries(entry(Skill.AGILITY, 87)),null,null),
    MYSTERIOUS_PIPE_EAST(new WorldPoint(1346, 10230, 0),Map.ofEntries(entry(Skill.AGILITY, 88)),null,null),
    MYSTERIOUS_PIPE_WEST(new WorldPoint(1317, 10214, 0),Map.ofEntries(entry(Skill.AGILITY, 88)),null,null),
    PILLAR_JUMP_HARD(new WorldPoint(3241, 10144, 0),Map.ofEntries(entry(Skill.AGILITY, 89)),null,null),
    CAVE_3_EAST(new WorldPoint(3541, 9772, 0),Map.ofEntries(entry(Skill.AGILITY, 93)),null,List.of(quests.DARKNESSOFHALLOWVALE)),
    CAVE_3_WEST(new WorldPoint(3534, 9768, 0),Map.ofEntries(entry(Skill.AGILITY, 93)),null,List.of(quests.DARKNESSOFHALLOWVALE)),
    CREVICE_6(new WorldPoint(2769, 9340, 0),Map.ofEntries(entry(Skill.AGILITY, 96)),null,null);

    private final WorldPoint shortcutIconWorldPoint;
    private final Map<Skill, Integer> mapOfRequiredSkillsAndLevels;
    private final Map<Integer, Integer> mapOfRequiredAchievementDiaryAndIncompleteValue;
    private final List<quests> listOfQuestRequirements;


    agilityShortcuts(WorldPoint shortcutIconWorldPoint, Map<Skill, Integer> mapOfRequiredSkillsAndLevels, Map<Integer, Integer> mapOfRequiredAchievementDiaryAndIncompleteValue, List<quests> listOfQuestRequirements) {
        this.shortcutIconWorldPoint = shortcutIconWorldPoint;
        this.mapOfRequiredSkillsAndLevels = mapOfRequiredSkillsAndLevels;
        this.mapOfRequiredAchievementDiaryAndIncompleteValue = mapOfRequiredAchievementDiaryAndIncompleteValue;
        this.listOfQuestRequirements = listOfQuestRequirements;
    }

    public static boolean doesPlayerMeetRequirements(Client client, WorldPoint wp) {
        for (agilityShortcuts as : agilityShortcuts.values()) {
            if (as.shortcutIconWorldPoint.equals(wp)) {
                for (Map.Entry<Skill, Integer> entry : as.mapOfRequiredSkillsAndLevels.entrySet()) {
                    if (client.getBoostedSkillLevel(entry.getKey()) < entry.getValue()) {
                        return false;
                    }
                }
                if (as.mapOfRequiredAchievementDiaryAndIncompleteValue != null) {
                    for (Map.Entry<Integer, Integer> entry : as.mapOfRequiredAchievementDiaryAndIncompleteValue.entrySet()) {
                        if (client.getVarbitValue(entry.getKey()) == entry.getValue()) {
                            return false;
                        }
                    }
                }
                if (as.listOfQuestRequirements != null) {
                    for (quests q : as.listOfQuestRequirements) {
                        if (!quests.isQuestComplete(client,q)) {
                            return false;
                        }
                    }
                }
                return true;
            }
        }

        log.error("The Agility shortcut icon at WorldPoint: " + wp.toString() + " is not recorded yet. Please raise an issue to correct.");
        return false; // Agility shortcut wasn't found, therefore show the icon
    }
}