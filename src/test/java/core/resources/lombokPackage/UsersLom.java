package core.resources.lombokPackage;

import core.resources.pojos.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsersLom {
    private String firstName;
    private String lastName;
    private AddressLom address;
}

//✔ Getters/Setters auto-generated
//✔ Clean code
//✔ Immutable option available
