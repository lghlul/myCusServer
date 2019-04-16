package customer.supu.mapper;

import customer.supu.domain.LotteryRecord;

import java.util.List;
import java.util.Map;

public interface LotteryRecordMapper extends BaseMapper<LotteryRecord> {
    int selectJoinNum(Map<String, Object> map);

    List<LotteryRecord> selectMyPrize(Map<String, Object> map);

    List<LotteryRecord> selectPageWithPrize(Map<String, Object> map);

    int selectCountWithPrize(Map<String, Object> map);
}