package phys.web.common.normal;

import java.util.Objects;

public class R<T> {

    private final static String SUCCESS = "0000";
    private final static String FAIL = "-1";

    private T data;

    private String code;

    private String message;

    private String detail;

    public R(T data, String code, String message, String detail) {
        this.data = data;
        this.code = code;
        this.message = message;
        this.detail = detail;
    }

    public Boolean succeed() {
        return Objects.equals(this.code, SUCCESS);
    }

    public Boolean failed() {
        return !Objects.equals(this.code, SUCCESS);
    }

    public static <T> R<T> success(T data) {
        return new R<>(data, SUCCESS, "成功", null);
    }

    public static <T> R<T> fail(String msg) {
        return new R<>(null, FAIL, msg, null);
    }

    public static R fail() {
        return new R<>(null, FAIL, "失败", null);
    }

    public void setData(T data) {
        this.data = data;
    }

    public static R fail(String msg, String detail) {
        return new R<>(null, FAIL, msg, detail);
    }


    public T getData() {
        return data;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "GenericR{" +
                "data=" + data +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }
}
