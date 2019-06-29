package day01;

import java.io.IOException;
import java.io.InputStream;

public class Request {
    private InputStream inputStream;
    private String uri;

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Request(InputStream inputStream){
        this.inputStream = inputStream;
    }
    public void parse(){
        /*StringBuffer request = new StringBuffer(2048);
        int i;
        byte[] buffer = new byte[2048];
        try{
            i = inputStream.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
            i = -1;
        }
        for(int j = 0;j<1;j++){
            request.append(buffer[j]);
        }
        System.out.println(request.toString());*/
        byte[] buffer = new byte[2048];
        try {
            int i = inputStream.read(buffer);
            String request = new String(buffer);
            System.out.println(request);
            uri = parseUri(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String parseUri(String requestString){
        System.out.println(requestString+"<<<<<<<<<<");
        int index1;
        int index2 = 0;
        index1 = requestString.indexOf('/');
        System.out.println("index1====="+index1);
        if(index1 != -1){
            index2 = requestString.indexOf('/',index1+1);
            System.out.println("index2======"+index2);
        }
        if(index2>index1){
            return  requestString.substring(index1,index2);
        }
        return  null;
    }
}
