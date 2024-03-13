package bookstore.app.book.web.api;


import bookstore.app.book.config.AppConfig;
import bookstore.app.book.dto.UserDto;
import bookstore.app.book.entity.Account;
import bookstore.app.book.service.IAccountService;
import bookstore.app.book.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserApi {

    private final IUserService userService;
    private final IAccountService accountService;
    private final AppConfig appConfig;


    @GetMapping("/info")
    public ResponseEntity<UserDto> getUser(
                                  Authentication authentication){
        if(authentication.getName() == null){
            return ResponseEntity.notFound().build();
        }
        Account account = accountService.getByUserName(authentication.getName());
        UserDto user = userService.getByUserId(account.getUser().getId());
        return ResponseEntity.ok().body(user);
    }

    @PutMapping("/info")
    public ResponseEntity<UserDto> updateUser(@Valid @ModelAttribute("user") UserDto user,
                             BindingResult result,
                             @RequestParam("avatarcover") MultipartFile multipartFile,
                             Authentication authentication
    ) {
        try {
            if(result.hasErrors()){
                System.out.println(result.getAllErrors());
                return ResponseEntity.status(HttpStatus.NON_AUTHORITATIVE_INFORMATION).build();
            }
            Account account = accountService.getByUserName(authentication.getName());
            user.setId(account.getUser().getId());
            if (!multipartFile.isEmpty()){
                uploadImage(multipartFile,"user",user);
            }
            StringBuilder newAvatar = new StringBuilder("/data/user/");
            newAvatar.append(user.getId());
            newAvatar.append("/");
            newAvatar.append(user.getAvatar());
            user.setAvatar(newAvatar.toString());
            UserDto newUser = userService.getByUserId(user.getId());
            user.setOrderTotal(newUser.getOrderTotal());
            newUser = userService.save(user);
            return ResponseEntity.ok().body(newUser);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    private void uploadImage(MultipartFile multipartFile, String folder, UserDto user) throws IOException {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        user.setAvatar(fileName);
        String uploadDir = "./" + appConfig.getFileUploadPath() + "/"+ folder +"/" + user.getId();
        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath)){
            Files.createDirectories(uploadPath);
        }
        try {
            InputStream inputStream = multipartFile.getInputStream();
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream,filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException IOE){
            IOE.printStackTrace();
        }
    }


}
