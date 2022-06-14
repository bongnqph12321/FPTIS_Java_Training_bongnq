CREATE DATABASE  IF NOT EXISTS `criminal_system`
USE `criminal_system`;
DROP TABLE IF EXISTS `criminalcase`;
CREATE TABLE `criminalcase` (
                                `id` int NOT NULL,
                                `version` int NOT NULL,
                                `createdAt` datetime NOT NULL,
                                `modifiedAt` datetime NOT NULL,
                                `number` varchar(100) NOT NULL,
                                `type` enum('UNCATEGORIZED','INFRACTION','MISDEMEANOR','FELONY') DEFAULT NULL,
                                `shortDescription` varchar(500) NOT NULL,
                                `detailedDescription` text NOT NULL,
                                `status` enum('SUBMITTED','UNDER_INVESTIGATION','IN_COURT','CLOSED','DISMISSED','COLD') DEFAULT NULL,
                                `note` varchar(500) NOT NULL,
                                `leadInvestigatorId` int DEFAULT NULL,
                                PRIMARY KEY (`id`),
                                UNIQUE KEY `number` (`number`),
                                KEY `lead_investigator` (`leadInvestigatorId`),
                                CONSTRAINT `lead_investigator` FOREIGN KEY (`leadInvestigatorId`) REFERENCES `detective` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `detective`;
CREATE TABLE `detective` (
                             `id` int NOT NULL,
                             `version` int NOT NULL,
                             `createdAt` datetime NOT NULL,
                             `modifiedAt` datetime NOT NULL,
                             `username` varchar(100) NOT NULL,
                             `firstName` varchar(100) NOT NULL,
                             `lastName` varchar(100) NOT NULL,
                             `pw` varchar(100) NOT NULL,
                             `hiringDate` datetime NOT NULL,
                             `badgeNumber` varchar(50) NOT NULL,
                             `rankOfDetective` enum('TRAINEE','JUNIOR','SENIOR','INSPECTOR','CHIEF_INSPECTOR') NOT NULL,
                             `armed` tinyint(1) NOT NULL,
                             `status` enum('ACTIVE','SUSPENDED','VACATION','UNDER_INVESTIGATION','RETIRED') NOT NULL,
                             PRIMARY KEY (`id`),
                             UNIQUE KEY `username` (`username`),
                             UNIQUE KEY `badgeNumber` (`badgeNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `evidence`;
CREATE TABLE `evidence` (
                            `id` int NOT NULL,
                            `version` int NOT NULL,
                            `createdAt` datetime NOT NULL,
                            `modifiedAt` datetime NOT NULL,
                            `number` varchar(100) NOT NULL,
                            `itemName` varchar(100) NOT NULL,
                            `note` varchar(500) NOT NULL,
                            `archived` smallint NOT NULL,
                            `criminalCaseId` int DEFAULT NULL,
                            `storageId` int DEFAULT NULL,
                            PRIMARY KEY (`id`),
                            UNIQUE KEY `number` (`number`),
                            KEY `cc_fk` (`criminalCaseId`),
                            KEY `s_fk` (`storageId`),
                            CONSTRAINT `cc_fk` FOREIGN KEY (`criminalCaseId`) REFERENCES `criminalcase` (`id`),
                            CONSTRAINT `s_fk` FOREIGN KEY (`storageId`) REFERENCES `storage` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `storage`;
CREATE TABLE `storage` (
                           `id` int NOT NULL,
                           `version` int NOT NULL,
                           `createdAt` datetime NOT NULL,
                           `modifiedAt` datetime NOT NULL,
                           `name` varchar(100) NOT NULL,
                           `location` varchar(500) NOT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `trackentry`;
CREATE TABLE `trackentry` (
                              `id` int NOT NULL,
                              `version` int NOT NULL,
                              `createdAt` datetime NOT NULL,
                              `modifiedAt` datetime NOT NULL,
                              `trackDate` datetime NOT NULL,
                              `action` enum('SUBMITTED','RETRIEVED','RETURNED') DEFAULT NULL,
                              `reason` varchar(100) NOT NULL,
                              `detectiveId` int DEFAULT NULL,
                              `evidenceId` int DEFAULT NULL,
                              PRIMARY KEY (`id`),
                              KEY `d_fk` (`detectiveId`),
                              KEY `e_fk` (`evidenceId`),
                              CONSTRAINT `d_fk` FOREIGN KEY (`detectiveId`) REFERENCES `detective` (`id`),
                              CONSTRAINT `e_fk` FOREIGN KEY (`evidenceId`) REFERENCES `evidence` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `working_detective_case`;
CREATE TABLE `working_detective_case` (
                                          `workingId` int NOT NULL,
                                          `detectiveId` int DEFAULT NULL,
                                          `criminalCaseId` int DEFAULT NULL,
                                          PRIMARY KEY (`workingId`),
                                          KEY `detective_fk` (`detectiveId`),
                                          KEY `case_fk` (`criminalCaseId`),
                                          CONSTRAINT `case_fk` FOREIGN KEY (`criminalCaseId`) REFERENCES `criminalcase` (`id`),
                                          CONSTRAINT `detective_fk` FOREIGN KEY (`detectiveId`) REFERENCES `detective` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
