package com.flogger;

public class FloggerJsonData<TData> {
    private TData data;
    private Boolean success;
    private String errorInfo;

    public FloggerJsonData(){}
    private FloggerJsonData(TData data){ this.data = data; }

    public static <TData> FloggerJsonData GetAsJson(TData data){
        FloggerJsonData response = new FloggerJsonData();
        try{
            if (data == null)
                throw new Exception("Error: No articles with this id detected");
            response.setData(data);
            response.setSuccess(true);
            response.setErrorInfo(null);
        }
        catch (Exception ex){
            response.setData(null);
            response.setErrorInfo(ex.getMessage());
            response.setSuccess(false);
        }
        return response;
    }

    public TData getData(){return data;}
    public void setData(TData data){this.data = data;}

    public Boolean getSuccess(){return success;}
    public void setSuccess(Boolean success){this.success = success;}

    public String getError(){return errorInfo;}
    public void setErrorInfo(String errorInfo){this.errorInfo = errorInfo;}
}
