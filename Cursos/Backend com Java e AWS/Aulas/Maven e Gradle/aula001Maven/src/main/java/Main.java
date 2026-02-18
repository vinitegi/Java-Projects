import org.example.dto.UserDTO;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        var dto = new UserDTO();
        dto.setId(1);
        dto.setName("Juan");
        dto.setBirthDate(LocalDate.now().minusYears(30));
    }
}
