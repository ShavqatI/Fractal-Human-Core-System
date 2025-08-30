package com.fractal.domain.abstraction;

import java.time.LocalDate;

public interface LifecycleRecord {
    LocalDate getOpenDate();
    void setOpenDate(LocalDate openDate);

    LocalDate getCloseDate();
    void setCloseDate(LocalDate closeDate);

    String getOpenReason();
    void setOpenReason(String openReason);

    String getCloseReason();
    void setCloseReason(String closeReason);

}
