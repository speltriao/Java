package db;

public class DbException extends RuntimeException{ //Runtime exceptions doesn't necessarily needs to be treated and can be avoided with an 'if'
    private static final long serialVersionUID=1l;

    public DbException(String message) {
        super(message);
    }
}
