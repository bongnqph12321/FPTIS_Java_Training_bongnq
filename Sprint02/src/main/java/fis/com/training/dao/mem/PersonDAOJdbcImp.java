package fis.com.training.dao.mem;


import fis.com.training.core.object.Person;
import fis.com.training.dao.PersonDAO;
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

public class PersonDAOJdbcImp implements PersonDAO {
    static Logger logger = LoggerFactory.getLogger(PersonDAOJdbcImp.class);

    @Override
    public void save(Person person) {
        String sql = "INSERT INTO person(`id`,`version`, `userName`, `firstName`, `lastName`, `passWord`, `hiringDate`) " +
                " VALUES (? ,?, ?, ?, ?, ?, ?)";
        try (Connection con = DatabaseUtility.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);) {
            stmt.setLong(1, Long.valueOf(person.getId()));
            stmt.setInt(2, person.getVersion());
            stmt.setString(3, person.getUserName());
            stmt.setString(4, person.getFirstName());
            stmt.setString(5, person.getLastName());
            stmt.setString(6, person.getPassWord());
            stmt.setDate(7, java.sql.Date.valueOf(person.getHiringDate().toLocalDate()));

            int rowInserted = stmt.executeUpdate();
            if (rowInserted == 0) {
                logger.error("Insert Failed");
            }

        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public Optional<Person> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Person> getAll() {
        List<Person> personList = new ArrayList<>();
        String sql = "SELECT * FROM person" ;
        try (Connection con = DatabaseUtility.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery();) {
            while (rs.next()) {
                Person p = DBMapper.getPerson(rs);
                if (p != null) personList.add(p);
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return personList;
    }

    @Override
    public Person update(Person person) {

        String sql = "UPDATE `Person` SET " +
                "`version` = ?, " +
                "`userName` = ?, " +
                "`firstName` = ?, " +
                "`lastName` = ?, " +
                "`passWord` = ?, " +
                "`hiringDate` = ? " +
                "WHERE `id` = ?";
        try(Connection con = DatabaseUtility.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);){
            stmt.setInt(1, person.getVersion());
            stmt.setString(2, person.getUserName());
            stmt.setString(3, person.getFirstName());
            stmt.setString(4, person.getLastName());
            stmt.setString(5, person.getPassWord());
            stmt.setDate(6, java.sql.Date.valueOf(person.getHiringDate().toLocalDate()));
            stmt.setLong(7, person.getId());
            int update = stmt.executeUpdate();
            if(update == 0){
                logger.error("Update Failed");
                return null;
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return null;
        }
        return person;
    }

    @Override
    public void delete(Person person) {
        String sql = "DELETE  FROM `person` "
                + "WHERE `id` = ? "
                + "LIMIT 1";
        try (
                Connection connect = DatabaseUtility.getConnection();
                PreparedStatement stmt = connect.prepareStatement(sql);) {
            stmt.setLong(1, person.getId());
            int rowDeleted = stmt.executeUpdate();
            if (rowDeleted == 0) {
                logger.error("Delete Failed !");
            }
        } catch (Exception e) {
            logger.error("Delete Failed !");
        }
    }

    @Override
    public Person getPersonById(long personId) {
        Person p = new Person();
        String sql = "SELECT * FROM person WHERE `id` = ?";
        try (Connection con = DatabaseUtility.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);) {
            stmt.setLong(1, personId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                p = DBMapper.getPerson(rs);
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return p;
    }
}
