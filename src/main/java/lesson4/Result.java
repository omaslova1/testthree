package lesson4;

public class Result {
    public Integer id;
    public String title;
    public String image;
    public String imageType;
    private String nutrition;
    private Double results;
    private String nutrients;
    private String name;
    private Double amount;
    private Double offset;
    private Double number;
    private Double totalResults;

    public Result(Integer id, String title, String image, String imageType) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.imageType = imageType;
    }

    public Result(Integer id, String title, String image, String imageType, String nutrition, Double results, String nutrients, String name, Double amount, Double offset, Double number, Double totalResults) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.imageType = imageType;
        this.nutrition = nutrition;
        this.results = results;
        this.nutrients = nutrients;
        this.name = name;
        this.amount = amount;
        this.offset = offset;
        this.number = number;
        this.totalResults = totalResults;
    }

    public String getNutrition() {
        return nutrition;
    }

    public void setNutrition(String nutrition) {
        this.nutrition = nutrition;
    }

    public Double getResults() {
        return results;
    }

    public void setResults(Double results) {
        this.results = results;
    }

    public String getNutrients() {
        return nutrients;
    }

    public void setNutrients(String nutrients) {
        this.nutrients = nutrients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getOffset() {
        return offset;
    }

    public void setOffset(Double offset) {
        this.offset = offset;
    }

    public Double getNumber() {
        return number;
    }

    public void setNumber(Double number) {
        this.number = number;
    }

    public Double getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Double totalResults) {
        this.totalResults = totalResults;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageType() {
        return imageType;
    }
    public void setImageType(String imageType) {
        this.imageType = imageType;
    }
}
