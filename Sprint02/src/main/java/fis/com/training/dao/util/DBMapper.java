package fis.com.training.dao.util;

import fis.com.training.core.enums.*;
import fis.com.training.core.object.*;
import fis.com.training.dao.*;
import fis.com.training.dao.mem.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.time.Instant;
import java.time.ZoneId;

public class DBMapper {
    public static final Logger logger = LoggerFactory.getLogger(DBMapper.class);

    public static CriminalCase getCriminalCase(ResultSet criminalCase){
        IDetectiveDAO DetectiveDAO = new DetectiveDAOMemImpl();
        try{
            CriminalCase cri = new CriminalCase();
            cri.setId(criminalCase.getLong("id"));
            cri.setVersion(criminalCase.getInt("version"));
            cri.setNumber(criminalCase.getString("number"));
            cri.setType(CaseType.valueOf(criminalCase.getString("type")));
            cri.setShortDescription(criminalCase.getString("shortDescription"));
            cri.setDetailedDescription(criminalCase.getString("detailedDescription"));
            cri.setStatus(CaseStatus.valueOf(criminalCase.getString("status")));
            cri.setNotes(criminalCase.getString("note"));
            cri.setLeadInvestigator(DetectiveDAO.getDetectiveById(criminalCase.getLong("leadDetective")));
            return cri;
        }catch(Exception e){
            logger.error(e.getMessage());
        }
        return null;

    }


    public static Detective getDetective(ResultSet detective){
        IDetectiveDAO DetectiveDAO = new DetectiveDAOMemImpl();
        PersonDAO personDAO = new PersonDAOJdbcImp();
        try{
            Detective det = new Detective();
            det.setId(detective.getLong("id"));
            det.setVersion(detective.getInt("version"));
            det.setPerson(personDAO.getPersonById(detective.getLong("personId")));
            det.setBadgeNumber(detective.getString("badgeNumber"));
            det.setRank(Rank.valueOf(detective.getString("rank")));
            det.setArmed(Boolean.parseBoolean(detective.getString("armed")));
            det.setStatus(EmploymentStatus.valueOf(detective.getString("status")));
            return det;
        }catch(Exception e){
            logger.error(e.getMessage());
        }
        return null;
    }

    public static Evidence getEvidence(ResultSet evidences){
        ICriminalDAO criminalDAO = new CriminalDAOMemImpl();
        IStorgeDAO st = new StorageDAOMemImpl();
        try{
            Evidence evi = new Evidence();
            evi.setId(evidences.getLong("id"));
            evi.setVersion(evidences.getInt("version"));
            evi.setCriminalCase(criminalDAO.getCriminalById(evidences.getLong("criminalId")));
            evi.setStorage(st.getStorageById(evidences.getLong("storageId")));
            evi.setNumber(evidences.getString("number"));
            evi.setItemName(evidences.getString("itemName"));
            evi.setNotes(evidences.getString("note"));
            evi.setArchired(evidences.getBoolean("archired"));
            return evi;
        }catch(Exception e){
            logger.error(e.getMessage());
        }
        return null;
    }

    public static Storage getStorage(ResultSet storages) {
        IEvidenceDAO evidenceDAO = new EvidenceDAOMemImpl();
        try {
            Storage storage = new Storage();
            storage.setId(storages.getLong("id"));
            storage.setVersion(storages.getInt("version"));
            storage.setName(storages.getString("name"));
            storage.setLocation(storages.getString("location"));
            return storage;
        } catch(Exception e){
            logger.error(e.getMessage());
        }
        return null;
    }

    public static TrackEntry getTrackEntry(ResultSet tracks) {
        IEvidenceDAO evidenceDAO = new EvidenceDAOMemImpl();
        IDetectiveDAO DetectiveDAO = new DetectiveDAOMemImpl();
        try {
            TrackEntry trackEntry = new TrackEntry();
            trackEntry.setId(tracks.getLong("id"));
            trackEntry.setVersion(tracks.getInt("version"));
            trackEntry.setDate(Instant.ofEpochMilli(tracks.getDate("date").getTime())
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime());
            trackEntry.setEvidence(evidenceDAO.getEvidenceById(tracks.getLong("evidenceId")));
            trackEntry.setDerevtive(DetectiveDAO.getDetectiveById(tracks.getLong("detectiveId")));
            trackEntry.setAction(TrackAction.valueOf(tracks.getString("action")));
            trackEntry.setReason(tracks.getString("reason"));
            return trackEntry;
        }catch(Exception e){
            logger.error(e.getMessage());
        }
        return null;
    }

    public static Person getPerson(ResultSet person){
        try{
            Person per = new Person();
            per.setId(person.getLong("id"));
            per.setVersion(person.getInt("version"));
            per.setUserName(person.getString("userName"));
            per.setFirstName(person.getString("firstName"));
            per.setLastName(person.getString("lastName"));
            per.setPassWord(person.getString("passWord"));
            per.setHiringDate(Instant.ofEpochMilli(person.getDate("hiringDate").getTime())
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime());

            return per;
        }catch(Exception e){
            logger.error(e.getMessage() + "at getPerson()");
        }
        return null;
    }
}
