public class BaseProduct {

    public static final int DEFAULT_ROTATION_DAYS = 30;
    public static final int DEFAULT_WARNING_DAYS = 5;

    private String name;
    private String category;
    private String unitOfMeasure;
    private int internalRotationDays;
    private int earlyWarningDays;
    // Using Double wrapper to allow null for unconfigured limits
    private Double minQuantity;
    private Double maxQuantity;



    public BaseProduct(String name, String category, String unitOfMeasure, int internalRotationDays, int earlyWarningDays, Double minQuantity, Double maxQuantity){
        this.name = name;
        this.category = category;
        this.unitOfMeasure = unitOfMeasure;
        setInternalRotationDays(internalRotationDays);
        setEarlyWarningDays(earlyWarningDays);
        this.minQuantity = minQuantity;
        this.maxQuantity = maxQuantity;
    }

    // Secondary constructor: defaults stock limits to null (no rule set)
    public BaseProduct(String name, String category, String unitOfMeasure, int internalRotationDays, int earlyWarningDays) {
        this(name, category, unitOfMeasure, internalRotationDays, earlyWarningDays, null, null);
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

    public double getMinQuantity() {
        return minQuantity;
    }

    public void setMinQuantity(double minQuantity) {
        this.minQuantity = minQuantity;
    }

    public double getMaxQuantity() {
        return maxQuantity;
    }

    public void setMaxQuantity(double maxQuantity) {
        this.maxQuantity = maxQuantity;
    }
}