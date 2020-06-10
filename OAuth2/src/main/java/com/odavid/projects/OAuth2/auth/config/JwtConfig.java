package com.odavid.projects.OAuth2.auth.config;

public class JwtConfig {

	private static final String RSA_PRIVATE="-----BEGIN RSA PRIVATE KEY-----\n" + 
			"MIIEpAIBAAKCAQEAtra5b30daY1Wxb6KjObJ+3TNGMCpxtLgU3L0xp6mQCwXSNCm\n" + 
			"Zmb7o7LQem7jO4YcglSvmpnDW0A/6/URF/BNqSq6XjJZAiydDcyq78cvM7IeHU6Z\n" + 
			"jvPRQH29Fe+e2AHzPDdaqF7CFjShUnctBTJCWJD6SE+ALFs49JPLGLehgh99/9Uc\n" + 
			"rMWI0efkbQUzD83SEQ6OJcFuGD/Lm6RdRoelvM8Oi1+IelyiOV/D7xqdH1cFnZGm\n" + 
			"Q2hOZAERpnlcvb8QNIbiKgdoO56wc6mtyE0Z/CwiLk+LVl931dL+xyIf7F4ygRkh\n" + 
			"7YINitzGAdPYg3/sYV0SqChOwCJxcdOoeFQZ2QIDAQABAoIBAH0JZLNQKr2eFMC0\n" + 
			"WXp9QcJMN0L2Lfk7PHq/E5WM4nbN9Y1GBGnVleV7rEHs+qI0b/Qc4iNpkJA00sm1\n" + 
			"5uG7+FmJPQrTZ6geQcg8xMncRIgbH5KsxFdYsV1x7uFBHzHxe7Q8qVTJrAaoM7IM\n" + 
			"jomc0FxtsmmjxjIUp1Bwh689k1BI9pffL/TCniaPlb/vRFIzQ9AXh3oAcDhVNmtY\n" + 
			"WCXEM89kztf0l4ZGfvsC62gqEdQS7aUb1JhII9PzEt3kVumz38WiYrE6HPjvBylE\n" + 
			"kxQ9bE4VzjPOKCUyh+k0qydOlkiXxVB7N0mww6CBTI2dcjo42L46WLwfziUnmVaq\n" + 
			"AvUmU/UCgYEA4bhjBIaXUbQtaIex6gE7oI/dTsVYbogd5PUQ8OisHI4ImX685YjS\n" + 
			"1KOaE7CvMxXRqwWbrAA7f/XxT8OiyrnXuO6p+HPePAoXu09zaYwoOdBpeMiiW2Wn\n" + 
			"vd0WLQEP6O6PfZ7kCLZEaoMMgf4IItI5lh3L/NO9hl8y2NHbn1RWC48CgYEAzzls\n" + 
			"GhQppMcsVyxJobHHHNERmsmyCvgP3uVfE+ca/p3YMNV52wI3klDHmSeBOYScS83I\n" + 
			"9EkSrKBbDZ7fDzE/5Iy9ImfzSZ4/jh2EmJVwE3Xj3pTLWsQGiuBGem3sX3F8f/f4\n" + 
			"GopjuBYBEDthcyCO7pr/Dn94//seCLTdMWSN8BcCgYBtV4fH0ncM4i44+7rIs44x\n" + 
			"6l73YIvFB3ULy1dIjD2Lm5Y43PcebdhLn3Ds5uMH6SLnKNFPUdGA3B/oVsnOUJZa\n" + 
			"hGqb620VQoJaf1NWJsn5r6bYFsDna2gFhkrOxDvzx1SFMuod+kVMH214rxk73QB+\n" + 
			"YrLFJ8EgjY8xDv/Hv+/qqwKBgQDD5sEvlkgYIsLkVlX1qp9VusAt2OecPw6h5a2Q\n" + 
			"nzaB5q7u26GrTdlDVWKcgyBDQ/6OGykS59HjqGTr53lwX1rLsdFLqYHx4syqiXVE\n" + 
			"2mFtxFF7pqboU9DrkUKPk0OWpy7Pu5itXo8PBJ5Uvg5OTEVThOwCxLebJ8co6/MA\n" + 
			"MtOMWQKBgQDAOcxVWeI2/CagdJz+md5yjYG7r37ZliscugRV622vGmWC5JHHKpLA\n" + 
			"EHSDc7CP7cRanePpOj4oARd8/XkaBG7YJfOYcsENdJ0DJoy1nwMUIgXKr58EqTmb\n" + 
			"2893vTuLK0Zt70WxbecdGzds9XYX3eCfZ7liEKTkTli99XFXQKWHMQ==\n" + 
			"-----END RSA PRIVATE KEY-----";
	
	
	private static final String RSA_PUBLIC="-----BEGIN PUBLIC KEY-----\n" + 
			"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtra5b30daY1Wxb6KjObJ\n" + 
			"+3TNGMCpxtLgU3L0xp6mQCwXSNCmZmb7o7LQem7jO4YcglSvmpnDW0A/6/URF/BN\n" + 
			"qSq6XjJZAiydDcyq78cvM7IeHU6ZjvPRQH29Fe+e2AHzPDdaqF7CFjShUnctBTJC\n" + 
			"WJD6SE+ALFs49JPLGLehgh99/9UcrMWI0efkbQUzD83SEQ6OJcFuGD/Lm6RdRoel\n" + 
			"vM8Oi1+IelyiOV/D7xqdH1cFnZGmQ2hOZAERpnlcvb8QNIbiKgdoO56wc6mtyE0Z\n" + 
			"/CwiLk+LVl931dL+xyIf7F4ygRkh7YINitzGAdPYg3/sYV0SqChOwCJxcdOoeFQZ\n" + 
			"2QIDAQAB\n" + 
			"-----END PUBLIC KEY-----";

	public static String getKeyPriv() {
		return RSA_PRIVATE;
	}
	
	public static String getKeyPub() {
		return RSA_PUBLIC;
	}
}
