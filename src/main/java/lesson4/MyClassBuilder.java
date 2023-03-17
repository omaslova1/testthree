package lesson4;

public class MyClassBuilder {
    private String base_url;
    private String apiKey;

    private String complexSearch;


    public MyClassBuilder(String apiKey, String base_url, String complexSearch) {
        this.apiKey = apiKey;
        this.base_url = base_url;
        this.complexSearch = complexSearch;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getBase_url() {
        return base_url;
    }

    public void setBase_url(String base_url) {
        this.base_url = base_url;
    }
    public String getComplexSearch() {
        return complexSearch;
    }

    public void setComplexSearch(String complexSearch) {
        this.complexSearch = complexSearch;
    }




}
