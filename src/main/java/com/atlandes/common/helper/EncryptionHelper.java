package com.atlandes.common.helper;

import com.atlandes.auth.po.User;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by XD.Wang on 2017/6/21.
 * 加密工具
 */
@Component
public class EncryptionHelper {

    private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

    private int hashIter;

    private String algorithm;

    @Value("${encryption.hashIter}")
    public void setHashIter(int hashIter) {
        this.hashIter = hashIter;
    }

    @Value("${encryption.algorithm}")
    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public void encryptPassword(User user) {
        user.setSalt(randomNumberGenerator.nextBytes().toHex());
        String credit = user.getPasswordCredit();
        String newPassword = new SimpleHash(algorithm, user.getPassword(), ByteSource.Util.bytes(credit), hashIter).toHex();
        user.setPassword(newPassword);
    }

}
