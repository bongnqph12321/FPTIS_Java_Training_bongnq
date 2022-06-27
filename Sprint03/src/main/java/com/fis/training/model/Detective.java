package com.fis.training.model;


import com.fis.training.core.EmploymentStatus;
import com.fis.training.core.Rank;


import javax.persistence.*;
import java.util.Objects;
import java.util.Set;



@Entity
@Table(name = "detective")
public class Detective extends AbstractEntity{
    @Column(name = "username", unique = true)
    private String username;

    private String firstName;

    private String lastName;

    private String password;
    private String badgeNumber;
    @Column(name = "rank_detective")
    @Enumerated(EnumType.STRING)
    private Rank rank;
    private Boolean armed = false;
    @Column(name = "status_detective")
    @Enumerated(EnumType.STRING)
    private EmploymentStatus status = EmploymentStatus.ACTIVE;
    //private Set<CriminalCase> criminalCases = new HashSet<>();
    @OneToMany(mappedBy = "detective",fetch = FetchType.EAGER)
    private Set<TrackEntry> trackEntries;

    private  Person person;

    public Detective() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBadgeNumber() {
        return badgeNumber;
    }

    public void setBadgeNumber(String badgeNumber) {
        this.badgeNumber = badgeNumber;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Boolean getArmed() {
        return armed;
    }

    public void setArmed(Boolean armed) {
        this.armed = armed;
    }

    public EmploymentStatus getStatus() {
        return status;
    }

    public void setStatus(EmploymentStatus status) {
        this.status = status;
    }

    public Set<TrackEntry> getTrackEntries() {
        return trackEntries;
    }

    public void setTrackEntries(Set<TrackEntry> trackEntries) {
        this.trackEntries = trackEntries;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Detective detective = (Detective) o;
        return username.equals(detective.username) && firstName.equals(detective.firstName) && lastName.equals(detective.lastName) && password.equals(detective.password) && badgeNumber.equals(detective.badgeNumber) && rank == detective.rank && armed.equals(detective.armed) && status == detective.status && trackEntries.equals(detective.trackEntries) && person.equals(detective.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, firstName, lastName, password, badgeNumber, rank, armed, status, trackEntries, person);
    }
}
