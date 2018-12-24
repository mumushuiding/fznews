package com.lt.cloud.service.impl;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lt.cloud.mapper.UserMapper;
import com.lt.cloud.pojo.User;
import com.lt.cloud.service.IdentityService;
@Component
public class IdentityServiceImpl implements IdentityService{
	@Autowired
	private UserMapper userMapper;
	@Override
	public User login(String loginname, String password) {
		User user=new User();
		
		user.setUSERCODE(loginname);
		user.setUSERPASSWORD(encryptBasedDes(password));
		return this.login(user);
	}
	@Override
	public User login(User user) {
		
		return userMapper.login(user);
	}
	@Override
	public List<User> selectAllUserWithHash(HashMap<String, Object> params) {
		
		return userMapper.selectAllUserWithHash(params);
	}
	@Override
	public User selectSingleUser(HashMap<String, Object> params) {
		List<User> users=this.selectAllUserWithHash(params);
		
		return users.size()>1?users.get(0):null;
	}
	@Override
	public Long updatePassword(Long userid,String password) {
		HashMap<String, Object> params=new HashMap<>();
		params.put("NUSERID", userid);
		params.put("USERPASSWORD", encryptBasedDes(password));
		try {
			return userMapper.updatePassword(params);
		} catch (Exception e) {
			e.printStackTrace();
			return 0l;
		}
		
		
	}
    /**
     *  EDS的加密解密代码
     */
    private static final byte[] DES_KEY = { 21, 1, -110, 82, -32, -85, -128, -65 };
      @SuppressWarnings("restriction")
      public static String encryptBasedDes(String data) {
          String encryptedData = null;
          try {
              // DES算法要求有一个可信任的随机数源
              SecureRandom sr = new SecureRandom();
              DESKeySpec deskey = new DESKeySpec(DES_KEY);
              // 创建一个密匙工厂，然后用它把DESKeySpec转换成一个SecretKey对象
              SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
              SecretKey key = keyFactory.generateSecret(deskey);
              // 加密对象
              Cipher cipher = Cipher.getInstance("DES");
              cipher.init(Cipher.ENCRYPT_MODE, key, sr);
              // 加密，并把字节数组编码成字符串
              encryptedData = new sun.misc.BASE64Encoder().encode(cipher.doFinal(data.getBytes()));
          } catch (Exception e) {
              // log.error("加密错误，错误信息：", e);
              throw new RuntimeException("加密错误，错误信息：", e);
          }
          return encryptedData;
      }
      @SuppressWarnings("restriction")
      public static String decryptBasedDes(String cryptData) {
          String decryptedData = null;
          try {
              // DES算法要求有一个可信任的随机数源
              SecureRandom sr = new SecureRandom();
              DESKeySpec deskey = new DESKeySpec(DES_KEY);
              // 创建一个密匙工厂，然后用它把DESKeySpec转换成一个SecretKey对象
              SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
              SecretKey key = keyFactory.generateSecret(deskey);
              // 解密对象
              Cipher cipher = Cipher.getInstance("DES");
              cipher.init(Cipher.DECRYPT_MODE, key, sr);
              // 把字符串进行解码，解码为为字节数组，并解密
              decryptedData = new String(cipher.doFinal(new sun.misc.BASE64Decoder().decodeBuffer(cryptData)));
          } catch (Exception e) {
              throw new RuntimeException("解密错误，错误信息：", e);
          }
          return decryptedData;
      }
      

}
