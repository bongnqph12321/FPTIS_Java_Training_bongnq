package com.fis.training.repository.jdbctemplate.advance;

import com.fis.training.core.EmploymentStatus;
import com.fis.training.core.Rank;
import com.fis.training.model.Detective;
import com.fis.training.model.Person;
import com.fis.training.repository.jdbctemplate.JdbcDetectiveRepo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Repository
public class ExtraJdbcDetectiveRepo extends JdbcDetectiveRepo {

    public ExtraJdbcDetectiveRepo(JdbcTemplate  jdbcTemplate ) {
        super(jdbcTemplate);
    }

    @Override
    public Optional<Detective> findByIdWithPersonDetails(Long id) {
        String sql = "select d.ID id," +
                " p.ID pid, " +
                " p.USERNAME un," +
                " p.FIRSTNAME fn, " +
                " p.LASTNAME ln, " +
                " p.HIRINGDATE hd," +
                " d.BADGE_NUMBER bno," +
                " d.RANK rank," +
                " d.ARMED armed," +
                " d.STATUS status" +
                " from DETECTIVE d, PERSON p where d.PERSON_ID=p.ID and d.ID=" + id;
        return Optional.of(jdbcTemplate.query(sql, new DetectiveExtractor()));
    }

    private class DetectiveExtractor implements ResultSetExtractor<Detective> {
        @Override
        public Detective extractData(ResultSet rs) throws SQLException {
            Detective detective = null;
            while (rs.next()) {
                if (detective == null) {
                    detective = new Detective();
                    // set internal entity identifier (primary key)
                    detective.setId(rs.getLong("id"));
                    detective.setBadgeNumber(rs.getString("bno"));
                    detective.setRank(Rank.valueOf(rs.getString("rank")));
                    detective.setArmed(rs.getBoolean("armed"));
                    detective.setStatus(EmploymentStatus.valueOf(rs.getString("status")));
                }
                Person p = new Person();
                p.setId(rs.getLong("pid"));
                p.setUsername(rs.getString("un"));
                p.setFirstName(rs.getString("fn"));
                p.setLastName(rs.getString("ln"));
                p.setHiringDate(rs.getTimestamp("hd").toLocalDateTime());
                detective.setPerson(p);
            }
            return detective;
        }
    }
}