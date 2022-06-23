package fis.com.training.core.object;

import static org.junit.jupiter.api.Assertions.*;

import fis.com.training.core.enums.EmploymentStatus;
import fis.com.training.core.enums.Rank;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class DetectiveTest {
    @Test
    public void testConstructor(){
        //Arrange
        Detective detective = new Detective(1L,null, "1",Rank., true,
                EmploymentStatus.ACTIVE);

        //Action
        long id = detective.getId();

        //Assert
        assertEquals(1L, id);
    }

    public static List<Detective> create3Detective(){
        List<Detective> detectiveList = new ArrayList<>();
        //Dummy Data
        Person person = new Person();
        person.setUsername("phuocnt");
        person.setFirstName("Phuoc");
        person.setLastName("Nguyen Thanh");

        Detective detective = new Detective(1L, person, "1", Rank., true,
                EmploymentStatus.ACTIVE);


        detectiveList.add(detective);

        return detectiveList;
    }
}