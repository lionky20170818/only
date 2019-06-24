package com.example.only.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.SecureRandom;

public class DesUtil {

	private final static String DES = "DES";
	// 自定义密钥
	public final static String DEFAULT_KEY = "zedkaOCJ72p&LHWyNdadOKry1YqXj2";

	public static void main(String[] args) throws Exception {

		String aaa = decryptWithDefaultKey("l6lMQnRLMFv1bpshGIN21w%3D%3D");
		// 请求参数组成结构(前缀标识:平台用户帐号:平台用户密码:数据客户端帐号:数据客户端密码:时间戳)
		// 一共六个参数,先后顺序不能错，任意一个参数校验失败将无法登录。
		//String data ="1"; 

		String data = "xforceplus:vendor:qdpy:"+System.currentTimeMillis();
//		String data = "xforceplus:admin:q1w2e3r4:DA100302:DA100302:"+System.currentTimeMillis();
		// 自定义密钥加密
		String dataEcrypt = encrypt(data, DEFAULT_KEY);
		System.out.println(dataEcrypt);
		// 加密后进行URL转码
		String dataUrlEncode = urlEncode (dataEcrypt);
		// 加密转码后的结果
		System.out.println(dataUrlEncode);
       /*
		System.out.println("");
		
		// URL反转码
		String dataUrlDecode = urlDecode(dataUrlEncode);	
		// 自定义密钥解密
		String dataDecrypt = decrypt(dataUrlDecode, key);
		// 反转码解码后的结果
		System.out.println(dataDecrypt);

		// 生成时间戳 如：1440129488646
		System.out.println(System.currentTimeMillis());
*/
		String dataUrlDecode = urlDecode("YoO45SINRHjAhUDIVIAkmUUaY5qMMgzrgKz%2FUnuGaua%2F2A%2BlMVJ9lQ%3D%3D");	
		// 自定义密钥解密
		String dataDecrypt = decrypt(dataUrlDecode, DEFAULT_KEY);
		// 反转码解码后的结果
		System.out.println(dataDecrypt);
		
		
	}

	/**
	 * Description 根据键值进行加密
	 * 
	 * @param data
	 * @param key
	 *            加密键byte数组
	 * @return
	 * @throws Exception
	 */
 	public static String encrypt(String data, String key) throws Exception {
		byte[] bt = encrypt(data.getBytes(), key.getBytes());
		String strs = new BASE64Encoder().encode(bt);
		return strs;
	} 

	/**
	 * Description 转urlEncode
	 * 
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static String urlEncode(String data) throws Exception {
		return URLEncoder.encode(data, "utf-8");
	}

	/**
	 * Description 反转转urlEncode
	 * 
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static String urlDecode(String data) throws Exception {
		return URLDecoder.decode(data, "utf-8");
	}

	/**
	 * Description 根据键值进行解密
	 * 
	 * @param data
	 * @param key
	 *            加密键byte数组
	 * @return
	 * @throws IOException
	 * @throws Exception
	 */
	public static String decrypt(String data, String key) throws IOException,
			Exception {
		if (data == null)
			return null;
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] buf = decoder.decodeBuffer(data);
		byte[] bt = decrypt(buf, key.getBytes());
		return new String(bt);
	}

	/**
	 * Description 根据键值进行加密
	 * 
	 * @param data
	 * @param key
	 *            加密键byte数组
	 * @return
	 * @throws Exception
	 */
	private static byte[] encrypt(byte[] data, byte[] key) throws Exception {
		// 生成一个可信任的随机数源
		SecureRandom sr = new SecureRandom();

		// 从原始密钥数据创建DESKeySpec对象
		DESKeySpec dks = new DESKeySpec(key);

		// 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
		SecretKey securekey = keyFactory.generateSecret(dks);

		// Cipher对象实际完成加密操作
		Cipher cipher = Cipher.getInstance(DES);

		// 用密钥初始化Cipher对象
		cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);

		return cipher.doFinal(data);
	}

	/**
	 * Description 根据键值进行解密
	 * 
	 * @param data
	 * @param key
	 *            加密键byte数组
	 * @return
	 * @throws Exception
	 */
	private static byte[] decrypt(byte[] data, byte[] key) throws Exception {
		// 生成一个可信任的随机数源
		SecureRandom sr = new SecureRandom();

		// 从原始密钥数据创建DESKeySpec对象
		DESKeySpec dks = new DESKeySpec(key);

		// 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
		SecretKey securekey = keyFactory.generateSecret(dks);

		// Cipher对象实际完成解密操作
		Cipher cipher = Cipher.getInstance(DES);

		// 用密钥初始化Cipher对象
		cipher.init(Cipher.DECRYPT_MODE, securekey, sr);

		return cipher.doFinal(data);
	}


    public static String encryptWithDefaultKey(String datas) throws Exception{
    	String data=datas+System.currentTimeMillis();
    	// 自定义密钥加密
    	String dataEcrypt = encrypt(data, DEFAULT_KEY);
    	// 加密后进行URL转码
    	String dataUrlEncode = urlEncode(dataEcrypt);
    	return dataUrlEncode;
    }

	public static String encryptWithDefaultKeyWithoutTs(String datas) throws Exception{
		// 自定义密钥加密
		String dataEcrypt = encrypt(datas, DEFAULT_KEY);
		// 加密后进行URL转码
		String dataUrlEncode = urlEncode(dataEcrypt);
		return dataUrlEncode;
	}

	public static String decryptWithDefaultKey(String data) throws Exception {
		return decrypt(data, DEFAULT_KEY);
	}

	/**
	 * 把16进制字符串转换成字节数组
	 *
	 * @param hex
	 * @return
	 */
	public static byte[] hexStringToByte(String hex) {
		int len = (hex.length() / 2);
		byte[] result = new byte[len];
		char[] achar = hex.toCharArray();
		for (int i = 0; i < len; i++) {
			int pos = i * 2;
			result[i] = (byte) (toByte(achar[pos]) << 4 | toByte(achar[pos + 1]));
		}
		return result;
	}

	private static byte toByte(char c) {
		byte b = (byte) "0123456789ABCDEF".indexOf(c);
		return b;
	}

	/**
	 * 把字节数组转换成16进制字符串
	 *
	 * @param bArray
	 * @return
	 */
	public static final String bytesToHexString(byte[] bArray) {
		if(bArray == null )
		{
			return "";
		}
		StringBuffer sb = new StringBuffer(bArray.length);
		String sTemp;
		for (int i = 0; i < bArray.length; i++) {
			sTemp = Integer.toHexString(0xFF & bArray[i]);
			if (sTemp.length() < 2) {
				sb.append(0);
			}
			sb.append(sTemp.toUpperCase());
		}
		return sb.toString();
	}

	/**
	 * 16进制加密
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String hexEncrypt(String data, String key) throws  Exception {
		return bytesToHexString(encrypt(data.getBytes(), key.getBytes()));
	}

	/**
	 * 16进制解密-字母大写
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String hexDecrypt(String data, String key) throws  Exception {
		return new String(decrypt(hexStringToByte(data.toUpperCase()), key.getBytes()));
	}

	public static String hexEncryptWithDefaultKey(String data) throws Exception {
		return bytesToHexString(encrypt(data.getBytes(), DEFAULT_KEY.getBytes()));
	}

	public static String hexDecryptWithDefaultKey(String data) throws  Exception {
		return new String(decrypt(hexStringToByte(data.toUpperCase()), DEFAULT_KEY.getBytes()));
	}

}