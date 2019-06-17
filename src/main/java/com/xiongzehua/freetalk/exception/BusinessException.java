package com.xiongzehua.freetalk.exception;

import com.xiongzehua.freetalk.common.BusinessStatus;

/**
 * Created by xiongzehua on 2019/2/21.
 */
public class BusinessException extends RuntimeException {
    private BusinessStatus businessStatus;

    public BusinessException(BusinessStatus businessStatus) {
        this.businessStatus = businessStatus;
    }

    public BusinessStatus getBusinessStatus() {
        return businessStatus;
    }

    public void setBusinessStatus(BusinessStatus businessStatus) {
        this.businessStatus = businessStatus;
    }
}
