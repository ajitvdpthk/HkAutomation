package utils;

public enum ErrorCodes {

    FRAMNOTFOUND(404, "The fram you want to switch to is not present of visible"),
    WINDOWNOTFOUND(404, "The fram you want to switch to is not present of visible"),
DRIVERNOTINITIALIZED(404,"The driver is null or it is not initalized");

    private  int error_id;
    private  String message;

    ErrorCodes(int error_id, String message) {
        this.error_id = error_id;
        this.message = message;
    }
    public int getError_id(){
        return this.error_id;
    }
    public String getMessage(){
        return this.message;
    }

}