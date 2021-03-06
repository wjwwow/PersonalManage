package com.davis.controller.imp;

import com.davis.DTO.R;

import com.davis.bean.User;
import com.davis.controller.UserController;
import com.davis.service.UserService;
import com.davis.util.JwtUtils;
import com.davis.util.KaisaUtil;
import com.davis.util.SendMail;
import io.jsonwebtoken.Claims;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.*;
import com.google.code.kaptcha.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Davis
 * @date 2021-11-09 - 11:37
 * @description
 */
@RestController
@CrossOrigin
public class UserControllerImpl implements UserController {
    @Autowired
    UserService userService;
    @Autowired
    private Producer kaptcha;
    private String text;
    @Resource
    private JavaMailSenderImpl mailSender;
    @PostMapping(value = "/user/login" )
    public R login(@Param("username") String username, @Param("password") String password){
        List<User> users = userService.queryUser(username, password);
        if (users.size()>0){
            String token = JwtUtils.generToken("1", "Jersey-Security-Basic", users.get(0).getUsername());
            return R.ok().data("token", token);
        }else {
            return R.error();
        }
    }

    @GetMapping("/user/info")
    public R info(@RequestParam("token") String token){
        Claims claims = JwtUtils.verifyToken(token);
        String username = claims.getSubject();
        List<User> users = userService.queryUserByUserName(username);
        return R.ok()
                .data("roles","[admin]")
                .data("name",username)
                .data("avatar",users.get(0).getAvatar())
                .data("introduction",users.get(0).getIntroduction())
                .data("email", users.get(0).getEmail());
    }


    @PostMapping("/register")
    public String register(@RequestBody User user) {
        try {
            if (text.equals(user.getCode())){
                Integer isRegister = userService.addUser(user);
                if (isRegister == 1) {
                    return "success";
                } else {
                    return "error";
                }
            }else {
                return "???????????????";
            }
        }catch (Exception e){
            return "error";
        }
    }

    @Override
    @GetMapping("/checkUserName/{username}")
    public String queryUser(@PathVariable("username") String username) {
        List<User> users = userService.queryUserByUserName(username);
        if (users.size()>0){
            return "exist";
        }else {
            return "no_exist";
        }
    }

    @Override
    @PostMapping("/updateUser")
    public String updateUser(@RequestBody User user) {
        Integer update = userService.update(user);
        if (update == 1){
            return "success";
        }else {
            return "error";
        }
    }

    @RequestMapping(path = "/kaptcha/{id}", method = RequestMethod.GET)
    public void getKaptcha(HttpServletResponse response, HttpServletRequest request) {
        text = kaptcha.createText();
        BufferedImage image = kaptcha.createImage(text);
        request.setAttribute("kaptcha", text);
        //????????????????????????
        response.setContentType("image/png");
        response.setHeader("pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        try {
            OutputStream out = response.getOutputStream();
            ImageIO.write(image, "png", out);
        } catch (IOException e) {
            System.out.println("??????????????????" + e.getMessage());
        }
    }

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody
    public String  upload(MultipartFile avatar, HttpServletRequest request) {
        System.out.println(avatar);
        String path = request.getSession().getServletContext().getRealPath("/static/upload");
        File filePath = new File(path);
        System.out.println("????????????????????????"+filePath);
        if(!filePath.exists() && !filePath.isDirectory()){
            System.out.println("???????????????");
            filePath.mkdir();
        }

        System.out.println(avatar);
        //????????????????????????(????????????)
        String originalFilename = avatar.getOriginalFilename();
        System.out.println("???????????????????????????"+originalFilename);

        //????????????????????????????????????`.`?????????
        String type = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        System.out.println("???????????????"+type);
        //???????????????????????????????????????
        String name = originalFilename.substring(0, originalFilename.lastIndexOf("."));

        //?????????????????????: ????????????+?????????????????????????????????
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String date = sdf.format(d);
        String fileName = date + "." + type;
        System.out.println("??????????????????" + fileName);

        //????????????????????????????????????
        File targetFile = new File(path, fileName);
        //???????????????????????????????????????

        try {
            avatar.transferTo(targetFile);
            System.out.println("????????????");
            //??????????????????????????????????????????
            System.out.println(fileName);
            return fileName;
        } catch (IOException e) {
            System.out.println("????????????");
            e.printStackTrace();
            return "error";
        }

    }

    @RequestMapping(value = "/updateimg",method = RequestMethod.POST)
    public Integer updateimg(@RequestBody User user){
        return userService.update(user);
    }

    @RequestMapping(value = "/updateEmail",method = RequestMethod.POST)
    public  Integer updateEmail(@RequestBody User user){
        return userService.update(user);
    }

    @PostMapping("/findPass")
    public String sendEmail(@RequestBody User user) {
        List<User> userByEmail = userService.findUserByEmail(user.getEmail());
        String password = userByEmail.get(0).getPassword();
        String s = KaisaUtil.decryptKaiser(password, 3);
        if (userByEmail.size()!=0&&userByEmail.get(0).getUsername().equals(user.getUsername())){
            String SMTPHost = mailSender.getHost();
            String Port = String.valueOf(mailSender.getPort());
            String MailUsername = mailSender.getUsername();
            String MailPassword = mailSender.getPassword();
            SendMail sendMail = new SendMail(SMTPHost, Port, MailUsername, MailPassword);

            String MailFrom = mailSender.getJavaMailProperties().getProperty("mail.smtp.from"); //?????????
            String MailTo = user.getEmail(); //?????????
            String MailCopyTo = null; //?????????
            String MailBCopyTo = null; //?????????
            String MailSubject = "????????????"; //????????????
            String MailBody = "????????????????????????????????????????????????????????????"+s; //????????????
            //????????????
            sendMail.sendingMimeMail(MailFrom, MailTo, MailCopyTo, MailBCopyTo, MailSubject, MailBody);
            return "success";
        }else {
            return "error";
        }




    }
}



