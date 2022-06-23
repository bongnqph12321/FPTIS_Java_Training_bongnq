package fis.com.training.dao.mem;

import fis.com.training.core.object.Person;
import fis.com.training.core.object.TrackEntry;
import fis.com.training.dao.ITrackEntryDAO;
import fis.com.training.dao.util.DBMapper;
import fis.com.training.dao.util.DatabaseUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TrackEntryDAOMemImpl implements ITrackEntryDAO {
    Logger logger = LoggerFactory.getLogger(TrackEntryDAOMemImpl.class);
    @Override
    public void save(TrackEntry trackEntry) {
        String sql = "INSERT INTO trackentry(`id`,`version`, `date`, `evidenceId`, `detectiveId`, `action`, `reason`) " +
                " VALUES (? ,?, ?, ?, ?, ?, ?)";
        try (Connection con = DatabaseUtility.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);) {
            stmt.setLong(1, Long.valueOf(trackEntry.getId().toString()));
            stmt.setInt(2, trackEntry.getVersion());
            stmt.setDate(3, java.sql.Date.valueOf(trackEntry.getDate().toLocalDate()));
            stmt.setLong(4, trackEntry.getEvidence().getId());
            stmt.setLong(5,trackEntry.getDerevtive().getId());
            stmt.setString(6, trackEntry.getAction().name());
            stmt.setString(7, trackEntry.getReason());

            int rowInserted = stmt.executeUpdate();
            if (rowInserted == 0) {
                logger.error("Insert Failed");
            }

        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public Optional get(long id) {
        return Optional.empty();
    }

    @Override
    public List getAll() {
        List<TrackEntry> trackEntries = new ArrayList<>();
        try(Connection con = DatabaseUtility.getConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM `trackentry`");
            ResultSet rs = stmt.executeQuery();
        ) {
            while (rs.next()){
                TrackEntry track = DBMapper.getTrackEntry(rs);
                trackEntries.add(track);
            }

        }catch (Exception ex){
            logger.error(ex.getMessage());
        }
        return trackEntries;
    }

    @Override
    public Person update(TrackEntry trackEntry) {
        String sql = "UPDATE `trackentry` SET " +
                "`version` = ?, " +
                "`date` = ?, " +
                "`evidenceId` = ?, " +
                "`detectiveId` = ?, " +
                "`action` = ?, " +
                "`reason` = ? " +
                "WHERE `id` = ?";
        try(Connection con = DatabaseUtility.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);){
            stmt.setInt(1, trackEntry.getVersion());
            stmt.setDate(2, java.sql.Date.valueOf(trackEntry.getDate().toLocalDate()));
            stmt.setLong(3, trackEntry.getEvidence().getId());
            stmt.setLong(4,trackEntry.getDerevtive().getId());
            stmt.setString(5, trackEntry.getAction().name());
            stmt.setString(6, trackEntry.getReason());
            stmt.setLong(7, trackEntry.getId());
            int update = stmt.executeUpdate();
            if(update == 0) {
                logger.error("Update Failed");
                return null;
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return null;
        }
        return trackEntry;
    }

    @Override
    public void delete(TrackEntry trackEntry) {
        String sql = "DELETE FROM `trackentry` WHERE `id` = ?";
        try(Connection con = DatabaseUtility.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);){
            stmt.setLong(1, trackEntry.getId());
            int delete = stmt.executeUpdate();
            if (delete == 0){
                logger.error("Delete Failed");
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage());

        }
    }

    @Override
    public long getTrackEntryById(long id) {
        TrackEntry trackEntry = new TrackEntry();
        try(Connection con = DatabaseUtility.getConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM `trackentry` WHERE `id` = ?");){
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                trackEntry = DBMapper.getTrackEntry(rs);
                return trackEntry;
            }
        } catch (Exception ex){
            logger.error(ex.getMessage());
            return null;
        }
        return null;
    }
}
