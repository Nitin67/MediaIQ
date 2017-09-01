package Exception;

public class CacheException extends Exception{

	private static final long serialVersionUID = 1L;

	public  CacheException(){
        super();
    }

    public CacheException(String message){
        super(message);
    }

    public CacheException(Throwable cause){
        super(cause);
    }

    public CacheException(String message, Throwable cause){
        super(message,cause);
    }

}