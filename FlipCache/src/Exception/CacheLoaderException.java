package Exception;

import java.io.IOException;

public class CacheLoaderException extends IOException{

	private static final long serialVersionUID = 1L;

	public  CacheLoaderException(){
        super();
    }

    public CacheLoaderException(String message){
        super(message);
    }

    public CacheLoaderException(Throwable cause){
        super(cause);
    }

    public CacheLoaderException(String message, Throwable cause){
        super(message,cause);
    }

}