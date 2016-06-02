package com.hogan.letyoucool.bean;

/**
 * 作者: 陈虎
 * 日期: 2016/5/31  16:28
 * 描述: 身份证Bean
 */
public class CardIdBean {

    /**
     * errNum : 0
     * retMsg : success
     * retData : {"address":"湖南省衡阳市衡阳县","sex":"M","birthday":"1988-03-28"}
     */

    private int errNum;
    private String retMsg;
    /**
     * address : 湖南省衡阳市衡阳县
     * sex : M
     * birthday : 1988-03-28
     */

    private RetDataBean retData;

    public int getErrNum() {
        return errNum;
    }

    public void setErrNum(int errNum) {
        this.errNum = errNum;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    public RetDataBean getRetData() {
        return retData;
    }

    public void setRetData(RetDataBean retData) {
        this.retData = retData;
    }

    public static class RetDataBean {
        private String address;
        private String sex;
        private String birthday;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }
    }
}
