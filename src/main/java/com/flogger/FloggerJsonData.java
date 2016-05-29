package com.flogger;

public class FloggerJsonData<TData> {
    private TData data;

    public FloggerJsonData(){}
    private FloggerJsonData(TData data){ this.data = data; }

    public static <TData> FloggerJsonData GetAsJson(TData data){
        return new FloggerJsonData(data);
    }

    public TData getData(){return data;}
    public void setData(TData data){this.data = data;}
}
