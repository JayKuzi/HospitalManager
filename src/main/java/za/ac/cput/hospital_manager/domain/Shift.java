package za.ac.cput.hospital_manager.domain;

import java.time.LocalTime;
import java.util.Objects;

public class Shift {
    private int shiftId;
    private LocalTime shiftStartTime;
    private LocalTime shiftEndTime;

    protected Shift()
    {}

    private Shift(Builder builder)
    {
        this.shiftId = builder.shiftId;
        this.shiftStartTime = builder.shiftStartTime;
        this.shiftEndTime = builder.shiftEndTime;
    }

    public int getShiftId()
    {
        return shiftId;
    }

    public LocalTime getShiftStartTime()
    {
        return shiftStartTime;
    }

    public LocalTime getShiftEndTime()
    {
        return shiftEndTime;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Shift)) return false;
        Shift shift = (Shift) o;
        return getShiftId() == shift.getShiftId() && Objects.equals(getShiftStartTime(), shift.getShiftStartTime()) && Objects.equals(getShiftEndTime(), shift.getShiftEndTime());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getShiftId(), getShiftStartTime(), getShiftEndTime());
    }

    public static class Builder{
        private int shiftId;
        private LocalTime shiftStartTime;
        private LocalTime shiftEndTime;

        public Builder setShiftId(int shiftId)
        {
            this.shiftId = shiftId;
            return this;
        }

        public Builder setShiftStartTime(LocalTime shiftStartTime)
        {
            this.shiftStartTime = shiftStartTime;
            return this;
        }

        public Builder setShiftEndTime(LocalTime shiftEndTime)
        {
            this.shiftEndTime = shiftEndTime;
            return this;
        }

        public Builder copy(Shift shift)
        {
            this.shiftId = shift.shiftId;
            this.shiftStartTime = shift.shiftStartTime;
            this.shiftEndTime = shift.shiftEndTime;
            return this;
        }

        public Shift build()
        {
            return new Shift(this);
        }
    }
}
