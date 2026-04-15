package com.kh.keeper.model.vo;

import java.sql.Date;

public record Keeper(String keeperId, String keeperName, Date hireDate, String zoneId) {

}
