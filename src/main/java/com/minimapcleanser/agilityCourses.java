package com.minimapcleanser;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Skill;
import net.runelite.api.coords.WorldPoint;

@Slf4j
enum agilityCourses
{
    GNOME(new WorldPoint(2475, 3436, 0), 1, null),
    BRIMHAVEN(new WorldPoint(2807, 3193, 0), 1, null),
    SHAYZIEN(new WorldPoint(1552, 3632, 0), 1, null),
    DRAYNOR(new WorldPoint(3104, 3279, 0), 1, null),
    AL_KHARID(new WorldPoint(3273, 3195, 0), 20, null),
    PYRAMID(new WorldPoint(3348, 2827, 0), 30, null),
    VARROCK(new WorldPoint(3220, 3414, 0), 30, null),
    PENGUIN(new WorldPoint(2639, 4041, 1), 30, quests.COLDWAR),
    BARBARIAN(new WorldPoint(2545, 3569, 0), 35, quests.MINIQUEST_BARCRAWL),
    CANIFIS(new WorldPoint(3507, 3490, 0), 40, quests.PRIESTINPERIL),
    APE_ATOLL(new WorldPoint(2753, 2742, 0), 48, quests.MONKEYMADNESS1), // Cheat slightly and require completion of Monkey Madness I (full quest completion not actually required)
    FALADOR(new WorldPoint(3036, 3342, 0), 50, null),
    COLOSSAL_WYRM(new WorldPoint(1650, 2930, 0), 50, quests.CHILDRENOFTHESUN),
    WILDERNESS(new WorldPoint(2998, 3916, 0), 52, null),
    WEREWOLF(new WorldPoint(3543, 3463, 0), 60, quests.CREATUREOFFENKENSTRAIN),
    SEERS(new WorldPoint(2729, 3488, 0), 60, null),
    DORGESH(new WorldPoint(2720, 5241, 3), 60, quests.DEATHTOTHEDORGESHUUN),
    POLLNIVNEACH(new WorldPoint(3351, 2963, 0), 70, null),
    PRIFDDINAS(new WorldPoint(3254, 6109, 0), 75, quests.SONGOFTHEELVES),
    RELLEKA(new WorldPoint(2625, 3677, 0), 80, null),
    ARDOUGNE(new WorldPoint(2674, 3298, 0), 90, null);

    private final WorldPoint courseIconWorldPoint;
    private final int requiredAgilityLevel;
    private final quests questRequirement;

    agilityCourses(WorldPoint courseIconWorldPoint, Integer requiredAgilityLevel, quests questRequirement) {
        this.requiredAgilityLevel = requiredAgilityLevel;
        this.courseIconWorldPoint = courseIconWorldPoint;
        this.questRequirement = questRequirement;
    }

    public static boolean doesPlayerMeetRequirements(Client client, WorldPoint wp) {
        for (agilityCourses ac : agilityCourses.values()) {
            if (ac.courseIconWorldPoint.equals(wp)) {
                if (client.getBoostedSkillLevel(Skill.AGILITY) < ac.requiredAgilityLevel) {
                    return false;
                }
                if (ac.questRequirement != null) {
                    return quests.isQuestComplete(client, ac.questRequirement);
                }
                return true;
            }
        }

        log.error("The Agility course icon at WorldPoint: " + wp.toString() + " is not recorded yet. Please raise an issue to correct.");
        return false; // Agility Course wasn't found, therefore show the icon
    }
}