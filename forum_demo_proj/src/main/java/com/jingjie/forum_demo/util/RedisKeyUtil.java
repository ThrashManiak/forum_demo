package com.jingjie.forum_demo.util;

/**
 *
 * The class is for generating keys in Redis.
 *
 * @author jingjiejiang
 * @history
 * 1. Created on Jan 29, 2018
 *
 */
public class RedisKeyUtil {

    private static String KEY_DELIMITER = "#";
    private static String KEY_LIKE = "LIKE";
    private static String KEY_DISLIKE = "DISLIKE";
    private static String KEY_EVENT_QUEUE = "EVENT_QUEUE";
    private static String KEY_FOLLOWER = "FOLLOWER";
    private static String KEY_FOLLOWEE = "FOLLOWEE";

    public static String getLikeKey (int enittyType, int entityId) {

        return KEY_LIKE + KEY_DELIMITER + String.valueOf(enittyType) +
                KEY_DELIMITER + String.valueOf(entityId);
    }

    public static String getDislikeKey (int entityType, int entityId) {

        return KEY_DISLIKE + KEY_DELIMITER + String.valueOf(entityType) +
                KEY_DELIMITER + String.valueOf(entityId);
    }

    public static String getKeyEventQueue () {

        return KEY_EVENT_QUEUE;
    }

    // follower key for a entity (follow certain entityType and entityId)

    /**
     *
     * Get a follower key for a entity (follow certain entityType and entityId)
     * NB: the follower key will be used in zset:
     * <followerKey (key), time (score), userId (value)>
     *
     *
     * @param entityType
     * @param entityId
     * @return
     */
    public static String getKeyFollower (int entityType, int entityId) {

        return KEY_FOLLOWER + KEY_DELIMITER + String.valueOf(entityType) +
                KEY_DELIMITER + String.valueOf(entityId);
    }

    /**
     *
     * Get a followee key for a user (a user followes an entity)
     * NB: the followee key will be used in zset:
     * <followeeKey (key), time (score), entityId (value)>
     *
     *
     * @param userId
     * @param entityType
     * @return
     */
    public static String getKeyFollowee (int userId, int entityType) {

        return KEY_FOLLOWEE + KEY_DELIMITER + String.valueOf(userId) +
                KEY_DELIMITER + String.valueOf(entityType);
    }
}
