package fis.com.training.dao.jdbc;


import fis.com.training.core.object.CriminalCase;
import fis.com.training.core.object.Person;
import fis.com.training.dao.ICriminalDAO;
import fis.com.training.dao.util.DBMapper;
import fis.com.training.dao.util.DatabaseUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCCriminalCaseDAO implements ICriminalDAO {
    public final static String URL = "jdbc:mysql://localhost:3306/criminal_edivence_db";
    public final static String USER_NAME = "root";
    public final static String PASSWORD = "nguyenquybong199";

    private final static Logger logger = LoggerFactory.getLogger(JDBCCriminalCaseDAO.class);

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public CriminalCase getCriminalById(long criminalId) {
        return null;
    }

    @Override
    public void save(CriminalCase criminalCase) {
        try (Connection con = DatabaseUtility.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO criminal_case values (?,?,?,?,?,?,?,?)");
            stmt.setLong(1, criminalCase.getId());
            stmt.setString(2, criminalCase.getNumber());
            stmt.setString(3, criminalCase.getType().toString());
            stmt.setString(4, criminalCase.getShortDescription());
            stmt.setString(5, criminalCase.getDetailedDescription());
            stmt.setString(6, criminalCase.getStatus().toString());
            stmt.setString(7, criminalCase.getNotes());
            stmt.executeUpdate ();

        } catch (Exception ex) {
            logger.error(ex.toString());
        }
    }

    @Override
    public Optional<CriminalCase> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<CriminalCase> getAll() {
        List<CriminalCase> criminalCases = new ArrayList<>();
        String sql = "SELECT * FROM criminal" ;
        try (Connection con = DatabaseUtility.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery();) {
            while (rs.next()) {
                CriminalCase criminalCase = DBMapper.getCriminalCase(rs);
                if (criminalCase != null) criminalCases.add(criminalCase);
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return criminalCases;
    }

    @Override
    public Person update(CriminalCase criminalCase) {
        try(Connection con = DatabaseUtility.getConnection()) {
            PreparedStatement stmt =
                    con.prepareStatement("UPDATE criminalcase " +
                            "SET version = ?,createdAt = ?, modifiedAt = ?, number = ?, type = ?, " +
                            "short_description = ?, detailed_description = ?" +
                            ",status = ?, notes = ?, lead_investigator = ? WHERE id = ?");
            stmt.setInt(1,criminalCase.getVersion());
            stmt.setDate(2, Date.valueOf(criminalCase.getCreatedAt().toLocalDate()));
            stmt.setDate(3, Date.valueOf(criminalCase.getModifiedAt().toLocalDate()));
            stmt.setString(4,criminalCase.getNumber());
            stmt.setString(5, criminalCase.getType().toString());
            stmt.setString(6,criminalCase.getShortDescription());
            stmt.setString(7,criminalCase.getDetailedDescription());
            stmt.setString(8, criminalCase.getStatus().toString());
            stmt.setString(9, criminalCase.getNotes());
            stmt.setLong(10, criminalCase.getLeadInvestigator().getId());
            stmt.setLong(11,criminalCase.getId());
            stmt.executeUpdate();
        }catch (Exception ex) {
            logger.error(ex.toString());
        }
        return criminalCase;
    }

    @Override
    public void delete(CriminalCase criminalCase) {
        try(Connection con = DatabaseUtility.getConnection()) {
            PreparedStatement stmt =
                    con.prepareStatement("DELETE FROM criminalcase WHERE id = ?");
            stmt.setLong(1,criminalCase.getId());
            stmt.executeUpdate();
        }catch (Exception ex) {
            logger.error(ex.toString());
        }
    }
}
