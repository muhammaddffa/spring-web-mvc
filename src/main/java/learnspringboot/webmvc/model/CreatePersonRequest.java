package learnspringboot.webmvc.model;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePersonRequest {

    @NotBlank
    private String firstName;

    private String middleName;

    private String lastName;

    @NotBlank
    private String email;

    @NotBlank
    private String phone;

    private CreateAddressRequest address;

    //List buat variabel awal
    private List<String> hobbies;

    // List ngambil dari object model CreateSosialMediaRequest
    private List<CreateSosialMediaRequest> socialMedias;
}
