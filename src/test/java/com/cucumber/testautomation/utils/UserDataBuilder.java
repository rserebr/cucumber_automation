package com.cucumber.testautomation.utils;

public class UserDataBuilder {

    private String firstName;
    private String lastName;
    private String password;
    private String day;
    private String month;
    private String year;
    private String addressOne;
    private String city;
    private String state;
    private String zip;
    private String country;
    private String mobile;

    public static class Builder {
        private String firstName = "userName";
        private String lastName = "lastName";
        private String password = "password";
        private String day = "1";
        private String month = "1";
        private String year = "2020";
        private String addressOne = "addressOne";
        private String city = "city";
        private String state = "1";
        private String zip = "12345";
        private String country = "21";
        private String mobile = "123456789";


        public Builder setAddressOne(String addressOne) {
            this.addressOne = addressOne;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setState(String state) {
            this.state = state;
            return this;
        }

        public Builder setZip(String zip) {
            this.zip = zip;
            return this;
        }

        public Builder setCountry(String country) {
            this.country = country;
            return this;
        }

        public Builder setMobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setDay(String day) {
            this.day = day;
            return this;
        }

        public Builder setMonth(String month) {
            this.month = month;
            return this;
        }

        public Builder setYear(String year) {
            this.year = year;
            return this;
        }

        public UserDataBuilder build(){
            return new UserDataBuilder(this);
        }
    }

    private UserDataBuilder(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.password = builder.password;
        this.day = builder.day;
        this.month = builder.month;
        this.year = builder.year;
        this.addressOne = builder.addressOne;
        this.city = builder.city;
        this.state = builder.state;
        this.zip = builder.zip;
        this.country = builder.country;
        this.mobile = builder.mobile;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }
    public String getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public String getAddressOne() {
        return addressOne;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public String getCountry() {
        return country;
    }

    public String getMobile() {
        return mobile;
    }
}
