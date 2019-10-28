CREATE TABLE IF NOT EXISTS `${TABLE_NAME}`
(
    `story_id`    INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `storyName`   TEXT,
    `lastUpdated` INTEGER                           NOT NULL,
    `favorite`    INTEGER                           NOT NULL,
    `alert`       INTEGER                           NOT NULL
)
CREATE TABLE IF NOT EXISTS `${TABLE_NAME}`
(
    `chapter_id`  INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `story_id`    INTEGER                           NOT NULL,
    `chapterName` TEXT                              NOT NULL,
    `lastUpdate`  INTEGER                           NOT NULL,
    `lastRead`    INTEGER                           NOT NULL,
    FOREIGN KEY (`story_id`) REFERENCES `Story` (`story_id`) ON UPDATE NO ACTION ON DELETE CASCADE
)
