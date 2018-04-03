package org.client.com.server.model;

import java.io.Serializable;

/**
 * @author ld
 * @name 收货地址
 * @table
 * @remarks
 */
public class CargoAddressModel implements Serializable{

    private String uuid;
    private String accId;
    private String address;
    //    是否为默认收货地址
    private String defaults;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getAccId() {
        return accId;
    }

    public void setAccId(String accId) {
        this.accId = accId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDefaults() {
        return defaults;
    }

    public void setDefaults(String defaults) {
        this.defaults = defaults;
    }

    public CargoAddressModel() {
        super();
    }

    public CargoAddressModel(String uuid, String accId, String address, String defaults) {
        this.uuid = uuid;
        this.accId = accId;
        this.address = address;
        this.defaults = defaults;
    }

    @Override
    public String toString() {
        return "CargoAddressModel{" +
                "uuid='" + uuid + '\'' +
                ", accId='" + accId + '\'' +
                ", address='" + address + '\'' +
                ", defaults='" + defaults + '\'' +
                '}';
    }
}
