package phys.web.controller;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import phys.web.common.normal.R;

@RestController
public class ValidController {

  @Data
  public static class User {

    @NotBlank(message = "Name is mandatory")
    private String name;
  }

  @PostMapping("/user")
  R<String> addUser(@RequestBody @Valid User user) {

    return R.success("User is valid");
  }



}
