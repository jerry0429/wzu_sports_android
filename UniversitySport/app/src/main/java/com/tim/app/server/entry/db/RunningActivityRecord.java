package com.tim.app.server.entry.db;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

import java.util.Date;

/**
 * Created by nimon on 2017/6/17.
 * 数据库记录
 */
@Entity(nameInDb = "running_activity")
public class RunningActivityRecord {

    @Property(nameInDb = "id")
    @Id(autoincrement = true)
    public Long id;

    @Property(nameInDb = "running_sport_id")
    public long runningSportId;
    @Property(nameInDb = "end_running_sport_id")
    public long endRunningSportId;
    @Property(nameInDb = "running_sport_name")
    private String runningSportName;

    @Property(nameInDb = "student_id")
    public long studentId;
    @Property(nameInDb = "distance")
    public int distance;
    @Property(nameInDb = "step_count")
    public int stepCount;
    @Property(nameInDb = "cost_time")
    public int costTime;
    @Property(nameInDb = "speed")
    public long speed;
    @Property(nameInDb = "step_per_second")
    public double stepPerSecond;
    @Property(nameInDb = "distance_per_step")
    public double distancePerStep;
    @Property(nameInDb = "target_finished_time")
    public long targetFinishedTime;

    @Convert(converter = DateStringConverter.class, columnType = String.class)
    @Property(nameInDb = "start_time")
    public Date startTime;

    @Property(nameInDb = "kcal_consumed")
    public int kcalConsumed;
    @Property(nameInDb = "qualified")
    public boolean qualified;
    @Property(nameInDb = "is_valid")
    public boolean isValid;
    @Property(nameInDb = "is_verified")
    public boolean isVerified;
    @Property(nameInDb = "qualified_distance")
    public int qualifiedDistance;
    @Property(nameInDb = "qualified_cost_time")
    public int qualifiedCostTime;
    @Property(nameInDb = "min_cost_time")
    public long minCostTime;

    @Convert(converter = DateStringConverter.class, columnType = String.class)
    @Property(nameInDb = "created_at")
    public Date createdAt;

    @Convert(converter = DateStringConverter.class, columnType = String.class)
    @Property(nameInDb = "updated_at")
    public Date updatedAt;

    @Convert(converter = DateStringConverter.class, columnType = String.class)
    @Property(nameInDb = "ended_at")
    public Date endedAt;

    @Property(nameInDb = "ended_by")
    public int endedBy;

    @Property(nameInDb = "sport_date")
    private String sportDate;

    @Generated(hash = 179327180)
    public RunningActivityRecord(Long id, long runningSportId,
            long endRunningSportId, String runningSportName, long studentId,
            int distance, int stepCount, int costTime, long speed,
            double stepPerSecond, double distancePerStep, long targetFinishedTime,
            Date startTime, int kcalConsumed, boolean qualified, boolean isValid,
            boolean isVerified, int qualifiedDistance, int qualifiedCostTime,
            long minCostTime, Date createdAt, Date updatedAt, Date endedAt,
            int endedBy, String sportDate) {
        this.id = id;
        this.runningSportId = runningSportId;
        this.endRunningSportId = endRunningSportId;
        this.runningSportName = runningSportName;
        this.studentId = studentId;
        this.distance = distance;
        this.stepCount = stepCount;
        this.costTime = costTime;
        this.speed = speed;
        this.stepPerSecond = stepPerSecond;
        this.distancePerStep = distancePerStep;
        this.targetFinishedTime = targetFinishedTime;
        this.startTime = startTime;
        this.kcalConsumed = kcalConsumed;
        this.qualified = qualified;
        this.isValid = isValid;
        this.isVerified = isVerified;
        this.qualifiedDistance = qualifiedDistance;
        this.qualifiedCostTime = qualifiedCostTime;
        this.minCostTime = minCostTime;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.endedAt = endedAt;
        this.endedBy = endedBy;
        this.sportDate = sportDate;
    }

    @Generated(hash = 1811433740)
    public RunningActivityRecord() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getRunningSportId() {
        return this.runningSportId;
    }

    public void setRunningSportId(long runningSportId) {
        this.runningSportId = runningSportId;
    }

    public long getEndRunningSportId() {
        return this.endRunningSportId;
    }

    public void setEndRunningSportId(long endRunningSportId) {
        this.endRunningSportId = endRunningSportId;
    }

    public String getRunningSportName() {
        return this.runningSportName;
    }

    public void setRunningSportName(String runningSportName) {
        this.runningSportName = runningSportName;
    }

    public long getStudentId() {
        return this.studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public int getDistance() {
        return this.distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getStepCount() {
        return this.stepCount;
    }

    public void setStepCount(int stepCount) {
        this.stepCount = stepCount;
    }

    public int getCostTime() {
        return this.costTime;
    }

    public void setCostTime(int costTime) {
        this.costTime = costTime;
    }

    public long getSpeed() {
        return this.speed;
    }

    public void setSpeed(long speed) {
        this.speed = speed;
    }

    public double getStepPerSecond() {
        return this.stepPerSecond;
    }

    public void setStepPerSecond(double stepPerSecond) {
        this.stepPerSecond = stepPerSecond;
    }

    public double getDistancePerStep() {
        return this.distancePerStep;
    }

    public void setDistancePerStep(double distancePerStep) {
        this.distancePerStep = distancePerStep;
    }

    public long getTargetFinishedTime() {
        return this.targetFinishedTime;
    }

    public void setTargetFinishedTime(long targetFinishedTime) {
        this.targetFinishedTime = targetFinishedTime;
    }

    public Date getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public int getKcalConsumed() {
        return this.kcalConsumed;
    }

    public void setKcalConsumed(int kcalConsumed) {
        this.kcalConsumed = kcalConsumed;
    }

    public boolean getQualified() {
        return this.qualified;
    }

    public void setQualified(boolean qualified) {
        this.qualified = qualified;
    }

    public boolean getIsValid() {
        return this.isValid;
    }

    public void setIsValid(boolean isValid) {
        this.isValid = isValid;
    }

    public boolean getIsVerified() {
        return this.isVerified;
    }

    public void setIsVerified(boolean isVerified) {
        this.isVerified = isVerified;
    }

    public int getQualifiedDistance() {
        return this.qualifiedDistance;
    }

    public void setQualifiedDistance(int qualifiedDistance) {
        this.qualifiedDistance = qualifiedDistance;
    }

    public int getQualifiedCostTime() {
        return this.qualifiedCostTime;
    }

    public void setQualifiedCostTime(int qualifiedCostTime) {
        this.qualifiedCostTime = qualifiedCostTime;
    }

    public long getMinCostTime() {
        return this.minCostTime;
    }

    public void setMinCostTime(long minCostTime) {
        this.minCostTime = minCostTime;
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

    public Date getEndedAt() {
        return this.endedAt;
    }

    public void setEndedAt(Date endedAt) {
        this.endedAt = endedAt;
    }

    public int getEndedBy() {
        return this.endedBy;
    }

    public void setEndedBy(int endedBy) {
        this.endedBy = endedBy;
    }

    public String getSportDate() {
        return this.sportDate;
    }

    public void setSportDate(String sportDate) {
        this.sportDate = sportDate;
    }

 
}
