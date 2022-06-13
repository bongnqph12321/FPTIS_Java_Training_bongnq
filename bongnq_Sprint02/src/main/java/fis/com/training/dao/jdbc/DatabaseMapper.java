package fis.com.training.dao.jdbc;

import fis.com.training.core.object.CriminalCase;
import fis.com.training.core.object.Detective;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseMapper {
    public static final Logger logger = LoggerFactory.getLogger(DatabaseMapper.class);

    public static CriminalCase getCriminalCase(ResultSet criminalCaseResultSet){
        try {
            CriminalCase criminalCase = new CriminalCase();

            criminalCase.setId(criminalCaseResultSet.getLong("id"));
            criminalCase.setNumber(criminalCaseResultSet.getString("number"));
            //TODO add some add.

            return criminalCase;
        }catch (SQLException ex){
            logger.error(ex.toString());
        }
        return null;
    }

    public static Detective getDetective(ResultSet detectiveResultSet){
        //TODO mapper
        return null;
    }

}
