package studentTracking.model;

/**
 * 评价分项实体类
 */
public class JobEvaluateOption {
    /**
     * 分项id
     */
    private long optionId;
    /**
     * 分项名称
     */
    private String optionName;
    /**
     * 分项状态
     */
    private String optionState;

    public long getOptionId() {
        return optionId;
    }

    public void setOptionId(long optionId) {
        this.optionId = optionId;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public String getOptionState() {
        return optionState;
    }

    public void setOptionState(String optionState) {
        this.optionState = optionState;
    }
}
