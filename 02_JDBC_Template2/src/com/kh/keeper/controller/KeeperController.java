package com.kh.keeper.controller;

import java.util.List;
import java.util.Map;

import com.kh.keeper.model.dto.KeeperDto;
import com.kh.keeper.model.service.KeeperService;
import com.kh.keeper.model.vo.Keeper;

public class KeeperController {
	
	public int insertKeeper(KeeperDto kd) {
		int result = new KeeperService().insertKeeper(kd);
		return result;
	}
	public List<Keeper> selectKeeperList() {
		return new KeeperService().selectKeeperList();
	}
	public int updateKeeper(Map<String, String> keeper) {
		return new KeeperService().updateKeeper(keeper);
	}
	public int deleteKeeper(String keeperId) {
		return new KeeperService().deleteKeeper(keeperId);
	}
}
