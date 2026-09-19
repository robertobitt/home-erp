public class BaseProduct {

    public static final int DEFAULT_ROTATION_DAYS = 30;
    public static final int DEFAULT_WARNING_DAYS = 5;

    private String name;
    private String category;
    private String unitOfMeasure;
    private int internalRotationDays;
    private int earlyWarningDays;

    public BaseProduct(String name, String category, String unitOfMeasure, int internalRotationDays, int earlyWarningDays){
        this.name = name;
        this.category = category;
        this.unitOfMeasure = unitOfMeasure;
        setInternalRotationDays(internalRotationDays);
        setEarlyWarningDays(earlyWarningDays);
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public int getInternalRotationDays() {
        return internalRotationDays;
    }

    public void setInternalRotationDays(int internalRotationDays) {
        if (internalRotationDays > 0) {
            this.internalRotationDays = internalRotationDays;
        } else{
            this.internalRotationDays = DEFAULT_ROTATION_DAYS;
        }
    }

    public int getEarlyWarningDays() {
        return earlyWarningDays;
    }

    public void setEarlyWarningDays(int earlyWarningDays) {
        if (earlyWarningDays >= 0) {
            this.earlyWarningDays = earlyWarningDays;
        }else {
            this.earlyWarningDays = DEFAULT_WARNING_DAYS;
        }
    }


}