package customer.supu.mapper;

import customer.supu.domain.Activity;

public interface ActivityMapper extends BaseMapper<Activity>{

    Activity selectWithPrize(String id);

}