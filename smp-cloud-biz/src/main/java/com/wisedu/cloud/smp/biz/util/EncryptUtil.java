package com.wisedu.cloud.smp.biz.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Random;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * the util for encrypting Created by yanghua on 12/9/14.
 */
public class EncryptUtil {

	private static final Log LOGGER = LogFactory.getLog(EncryptUtil.class);

	/**
	 * encrypt password with add-in salt
	 *
	 * @param salt
	 *            the password's salt
	 * @param hashedPwd
	 *            the hashed password
	 * @return the char array of encrypted password
	 */
	public static char[] generateEncryptedPwd(String salt, char[] hashedPwd) {
		byte[] data = (salt + Arrays.toString(hashedPwd)).getBytes();

		try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
			messageDigest.update(data);

			char[] result = new HexBinaryAdapter().marshal(
					messageDigest.digest()).toCharArray();

			LOGGER.debug("salt is : " + salt);
			LOGGER.debug("hashedPwd is : " + new String(hashedPwd));
			LOGGER.debug("generated is : " + new String(result));

			return result;
		} catch (NoSuchAlgorithmException e) {
			LOGGER.error("[generateEncryptedPwd] occurs a NoSuchAlgorithmException : "
					,e);
		}

		return new char[0];
	}

	/**
	 * generate hashed password
	 *
	 * @param original
	 *            the original pwd string
	 * @return generated hashed-password
	 */
	public static char[] getHashedPassword(String original) {
		char[] result = new char[0];
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
			messageDigest.update(original.getBytes());

			result = new HexBinaryAdapter().marshal(messageDigest.digest())
					.toCharArray();
			processHashCharacters(result);
		} catch (NoSuchAlgorithmException e) {
			LOGGER.error("",e);
		}

		return result;
	}

	/**
	 * check two variable's equality
	 *
	 * @param p1
	 *            one password
	 * @param p2
	 *            another password
	 * @return if two passwords' every character equals, return true otherwise
	 *         return false
	 */
	public static boolean checkPasswordEquality(char[] p1, char[] p2) {
		return Arrays.equals(p1, p2);
	}

	/**
	 * generate random character and number mixed sequence with a given
	 * <p>
	 * length
	 * </p>
	 *
	 * @param length
	 *            the sequence's length that will be generated
	 * @return generated sequence
	 */
	public static String generateSalt(int length) {
		StringBuilder sb = new StringBuilder();
		Random rand = new Random();
		Random randdata = new Random();
		int data = 0;

		for (int i = 0; i < length; i++) {
			int index = rand.nextInt(3);
			switch (index) {
			case 0:
				data = randdata.nextInt(10);
				sb.append(data);
				break;
			case 1:
				data = randdata.nextInt(26) + 65;
				sb.append((char) data);
				break;
			case 2:
				data = randdata.nextInt(26) + 97;
				sb.append((char) data);
				break;
			default:
				break;
			}
		}

		return sb.toString();
	}

	private static void processHashCharacters(char[] original) {
		for (int i = 0; i < original.length; i++) {
			if (original[i] >= 65 && original[i] <= 91) {
				original[i] = (char) (original[i] + 32);
			}
		}
	}

	/**
	 * generate sequence with double-hash strategy like hash(hash(original))
	 * then substring from 0 to num - 1
	 * 
	 * @param original
	 *            the original string
	 * @param num
	 *            substring num length
	 * @return generated sequence
	 */
	public static String generateWithReHash(String original, int num)
			throws NoSuchAlgorithmException {
		int numNew = num > 16 ? 16 : num;

		String tmp = DigestUtils.md5Hex(original);
		String target = DigestUtils.shaHex(tmp);

		if (target.length() < 16) {
			throw new RuntimeException(
					"generate error : the target sequence less than 16-bit");
		}

		return target.substring(0, numNew);
	}

	public static void main(String[] args) {
		String url = "/hr-service/ProxyService/JzgZpGetProxyService";
		try {
			generateWithReHash(url, 12);
		} catch (NoSuchAlgorithmException e) {
			LOGGER.error("",e);
		}
	}

}
