package fis.com.training.dao.mem;

import fis.com.training.core.object.Storage;
import fis.com.training.dao.IStorgeDAO;
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

public class StorageDAOMemImpl implements IStorgeDAO {
    Logger logger = LoggerFactory.getLogger(StorageDAOMemImpl.class);
    @Override
    public void save(Storage storage) {
        String sql = "INSERT INTO storage(`id`,`version`, `name`, `location`) " +
                " VALUES (? ,?, ?, ?)";
        try (Connection con = DatabaseUtility.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);) {
            stmt.setLong(1, Long.valueOf(storage.getId()));
            stmt.setInt(2, storage.getVersion());
            stmt.setString(3, storage.getName());
            stmt.setString(4, storage.getLocation());

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
        List<Storage> storages = new ArrayList<>();
        try(Connection con = DatabaseUtility.getConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM `storage`");
            ResultSet rs = stmt.executeQuery();
        ) {
            while (rs.next()){
                Storage storage = DBMapper.getStorage(rs);
                storages.add(storage);
            }

        }catch (Exception ex){
            logger.error(ex.getMessage());
        }
        return storages;
    }

    public Storage update(Storage storage) {

        String sql = "UPDATE `storage` SET " +
                "`version` = ?, " +
                "`name` = ?, " +
                "`location` = ? " +
                "WHERE `id` = ?";
        try(Connection con = DatabaseUtility.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);){
            stmt.setInt(1, storage.getVersion());
            stmt.setString(2, storage.getName());
            stmt.setString(3, storage.getLocation());
            stmt.setLong(4, storage.getId());
            int update = stmt.executeUpdate();
            if(update == 0){
                logger.error("Update Failed");
                return null;
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return null;
        }
        return storage;
    }

    @Override
    public void delete(Storage storage) {
        String sql = "DELETE FROM `storage` WHERE `id` = ?";
        try(Connection con = DatabaseUtility.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);){
            stmt.setLong(1, storage.getId());
            int delete = stmt.executeUpdate();
            if (delete == 0){
                logger.error("Delete Failed");
            }
        } catch (Exception  ex) {
            logger.error(ex.getMessage());

        }
    }
    }

    @Override
    public Storage getStorageById(long storageId) {
        Storage storage = new Storage();
        try(Connection con = DatabaseUtility.getConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM `storage` WHERE `id` = ?");){
            stmt.setLong(1, storageId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                storage = DBMapper.getStorage(rs);
                return storage;
            }
        } catch (Exception ex){
            logger.error(ex.getMessage());
            return null;
        }
        return null;
    }
}
