package com.tim.app.server.entry.db;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

import java.util.Date;

/**
 * @创建者 倪军
 * @创建时间 04/12/2017
 * @描述
 */
@Entity(nameInDb = "running_activity_data")
public class RunningActivityDataRecord {

    @Property(nameInDb = "id")
    @Id(autoincrement = true)
    public Long id;

    @Property(nameInDb = "activity_id")
    public long activityId;
    @Property(nameInDb = "acquisition_time")

    @Convert(converter = DateStringConverter.class, columnType = String.class)
    public Date acquisitionTime;
    @Property(nameInDb = "step_count")
    public int stepCount;
    @Property(nameInDb = "step_count_cal")
    public int stepCountCal;
    @Property(nameInDb = "distance")
    public int distance;
    @Property(nameInDb = "distance_per_step")
    public double distancePerStep;
    @Property(nameInDb = "step_per_second")
    public long stepPerSecond;
    @Property(nameInDb = "longitude")
    public double longitude;
    @Property(nameInDb = "latitude")
    public double latitude;
    @Property(nameInDb = "location_type")
    public int locationType;
    @Property(nameInDb = "is_normal")
    public boolean isNormal;

    @Convert(converter = DateStringConverter.class, columnType = String.class)
    @Property(nameInDb = "created_at")
    public Date createdAt;

    @Convert(converter = DateStringConverter.class, columnType = String.class)
    @Property(nameInDb = "updated_at")
    public Date updatedAt;

    @Generated(hash = 294229296)
    public RunningActivityDataRecord(Long id, long activityId, Date acquisitionTime,
            int stepCount, int stepCountCal, int distance, double distancePerStep,
            long stepPerSecond, double longitude, double latitude, int locationType,
            boolean isNormal, Date createdAt, Date updatedAt) {
        this.id = id;
        this.activityId = activityId;
        this.acquisitionTime = acquisitionTime;
        this.stepCount = stepCount;
        this.stepCountCal = stepCountCal;
        this.distance = distance;
        this.distancePerStep = distancePerStep;
        this.stepPerSecond = stepPerSecond;
        this.longitude = longitude;
        this.latitude = latitude;
        this.locationType = locationType;
        this.isNormal = isNormal;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    @Generated(hash = 1910225190)
    public RunningActivityDataRecord() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getActivityId() {
        return this.activityId;
    }

    public void setActivityId(long activityId) {
        this.activityId = activityId;
    }

    public Date getAcquisitionTime() {
        return this.acquisitionTime;
    }

    public void setAcquisitionTime(Date acquisitionTime) {
        this.acquisitionTime = acquisitionTime;
    }

    public int getStepCount() {
        return this.stepCount;
    }

    public void setStepCount(int stepCount) {
        this.stepCount = stepCount;
    }

    public int getStepCountCal() {
        return this.stepCountCal;
    }

    public void setStepCountCal(int stepCountCal) {
        this.stepCountCal = stepCountCal;
    }

    public int getDistance() {
        return this.distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public double getDistancePerStep() {
        return this.distancePerStep;
    }

    public void setDistancePerStep(double distancePerStep) {
        this.distancePerStep = distancePerStep;
    }

    public long getStepPerSecond() {
        return this.stepPerSecond;
    }

    public void setStepPerSecond(long stepPerSecond) {
        this.stepPerSecond = stepPerSecond;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public int getLocationType() {
        return this.locationType;
    }

    public void setLocationType(int locationType) {
        this.locationType = locationType;
    }

    public boolean getIsNormal() {
        return this.isNormal;
    }

    public void setIsNormal(boolean isNormal) {
        this.isNormal = isNormal;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

}
