package com.demo.observerdemo;

/**
 * Created by admin on 2018/4/10.
 */

public class Weather {

    private String desc;

    private String date;


    private Weather(Builder builder){
        desc = builder.desc;
        date = builder.date;
    }


    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    static class Builder{

        private String desc;

        private String date;


        public String getDesc() {
            return desc;
        }

        public Builder setDesc(String desc) {
            this.desc = desc;
            return this;
        }

        public String getDate() {
            return date;
        }

        public Builder setDate(String date) {
            this.date = date;
            return this;
        }

        public Weather build(){
            return new Weather(this);
        }
    }

    @Override
    public String toString() {
        return "Weather{" +
                "desc='" + desc + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
