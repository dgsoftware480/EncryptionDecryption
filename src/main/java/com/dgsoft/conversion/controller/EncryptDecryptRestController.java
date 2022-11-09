package com.dgsoft.conversion.controller;

import com.dgsoft.conversion.component.EncryptDecrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api")
public class EncryptDecryptRestController {

    @Autowired
    private EncryptDecrypt encryptDecrypt;

    @PostMapping(value = "/aesencrypt")
    public ResponseEntity<?> aesEncrypt(@RequestBody String str){
        return new ResponseEntity<>(encryptDecrypt.aesEncryption(str), HttpStatus.OK);
    }

    @PostMapping(value = "/aesdecrypt")
    public ResponseEntity<?> aesDecrypt(@RequestBody String str){
        return new ResponseEntity<>(encryptDecrypt.aesDecryption(str), HttpStatus.OK);
    }


    @PostMapping(value = "/rsaencrypt")
    public ResponseEntity<?> rsaEncrypt(@RequestBody String str){
        return new ResponseEntity<>(encryptDecrypt.rsaEncryption(str), HttpStatus.OK);
    }

    @PostMapping(value = "/rsadecrypt")
    public ResponseEntity<?> rsaDecrypt(@RequestBody String str){
        Object encryptedStr = encryptDecrypt.rsaDecryption(str);
        return new ResponseEntity<>(encryptedStr, HttpStatus.OK);
    }
}
