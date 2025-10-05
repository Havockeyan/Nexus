package Nexus.HttpParser;

import org.json.simple.JSONObject;

public class HttpRequestData {
    private String method;
    private String path;
    private String httpVersion;
    JSONObject payLoad;

    public HttpRequestData(String method, String path, String httpVersion) {
        this.method = method;
        this.path = path;
        this.httpVersion = httpVersion;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setHttpVersion(String httpVersion) {
        this.httpVersion = httpVersion;
    }

    public JSONObject getPayLoad() {
        return payLoad;
    }

    public void setPayLoad(JSONObject payLoad) {
        this.payLoad = payLoad;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getMethod() {
        return method;
    }

    public String getPath() {
        return path;
    }

    public String getHttpVersion() {
        return httpVersion;
    }
}
