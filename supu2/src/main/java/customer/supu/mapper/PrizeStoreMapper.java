package customer.supu.mapper;

import customer.supu.domain.PrizeStore;

import java.util.List;

public interface PrizeStoreMapper extends BaseMapper<PrizeStore>{
    List<PrizeStore> selectActivePrize(String activityId);
}