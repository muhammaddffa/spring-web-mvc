package learnspringboot.webmvc.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePersonRequest {

    private String firstName;

    private String middleName;

    private String lastName;

    private String email;

    private String phone;

    private CreateAddressRequest address;

    //List buat variabel awal
    private List<String> hobbies;

    // List ngambil dari object model CreateSosialMediaRequest
    private List<CreateSosialMediaRequest> socialMedias;
}
