package quarkusrest.dto;

public class AwsResponse {
    private int id;
    private String name;
    private String awsCode;
    private String city;


    public AwsResponse(int id, String name, String awsCode, String city) {
        this.id = id;
        this.name = name;
        this.awsCode = awsCode;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAwsCode() {
        return awsCode;
    }

    public void setAwsCode(String awsCode) {
        this.awsCode = awsCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
