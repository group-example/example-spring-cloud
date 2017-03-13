package spring.cloud.common;


/**
 *
 */
public class BusinessException extends Exception {

	/** 异常代码 */
	private String code ;
	/** 异常消息 */
	private String message ;

	public BusinessException(String code, String message){
		super(message);

	}

}
