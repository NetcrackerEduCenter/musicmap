package com.akvone.entity;

import javax.persistence.*;
import java.util.Random;

/**
 * Created by Kirill on 30.10.2016.
 */
@Entity
@Table(name = "start_info")
public class StartInfo {
    public StartInfo() {
        this.id = new Random().nextInt();
        this.errorType = 1;
        this.latitude = 10.3;
        this.longitude = 10.2;
        this.accuracy = 2d;
        this.browserName = "b";
        this.operationSystem = "g";
        this.screenHeight = 1000;
        this.screenWidth = 2000;
    }

    private Integer id;
    private Short errorType;
    private Double latitude;
    private Double longitude;
    private Double accuracy;
    private String browserName;
    private String operationSystem;
    private Integer screenHeight;
    private Integer screenWidth;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "error_type", nullable = false)
    public Short getErrorType() {
        return errorType;
    }

    public void setErrorType(Short errorType) {
        this.errorType = errorType;
    }

    @Basic
    @Column(name = "latitude", nullable = true, precision = 0)
    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @Basic
    @Column(name = "longitude", nullable = true, precision = 0)
    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Basic
    @Column(name = "accuracy", nullable = true, precision = 0)
    public Double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(Double accuracy) {
        this.accuracy = accuracy;
    }

    @Basic
    @Column(name = "browser_name", nullable = true, length = 50)
    public String getBrowserName() {
        return browserName;
    }

    public void setBrowserName(String browserName) {
        this.browserName = browserName;
    }

    @Basic
    @Column(name = "operation_system", nullable = true, length = 50)
    public String getOperationSystem() {
        return operationSystem;
    }

    public void setOperationSystem(String operationSystem) {
        this.operationSystem = operationSystem;
    }

    @Basic
    @Column(name = "screen_height", nullable = false)
    public Integer getScreenHeight() {
        return screenHeight;
    }

    public void setScreenHeight(Integer screenHeight) {
        this.screenHeight = screenHeight;
    }

    @Basic
    @Column(name = "screen_width", nullable = false)
    public Integer getScreenWidth() {
        return screenWidth;
    }

    public void setScreenWidth(Integer screenWidth) {
        this.screenWidth = screenWidth;
    }

}
