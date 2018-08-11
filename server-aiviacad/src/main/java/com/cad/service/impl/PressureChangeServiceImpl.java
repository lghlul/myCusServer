package com.cad.service.impl;

import org.springframework.stereotype.Service;

import com.cad.domain.PressureChange;
import com.cad.service.IPressureChangeService;
import com.cad.utils.ConstantUtil;
import com.cad.utils.DataFormatUtil;

@Service
public class PressureChangeServiceImpl
  implements IPressureChangeService
{
  public PressureChange change(PressureChange pressureChange)
  {
    double value_1 = 0.0D;
    double value_2 = 0.0D;
    double value_3 = 0.0D;
    double value_4 = 0.0D;
    double value_5 = 0.0D;
    double value_6 = 0.0D;
    double value_7 = 0.0D;
    double value_8 = 0.0D;
    double value_9 = 0.0D;
    double value_10 = 0.0D;
    double value_11 = 0.0D;
    double value_12 = 0.0D;
    double value_13 = 0.0D;
    double value_14 = 0.0D;
    double value = 0.0D;
    double proportion = 0.0D;
    value = pressureChange.getValue();
    switch (pressureChange.getType()) {
    case 1:
      proportion = ConstantUtil.PressureChage.PROPORTION_1;
      break;
    case 2:
      proportion = ConstantUtil.PressureChage.PROPORTION_2;
      break;
    case 3:
      proportion = ConstantUtil.PressureChage.PROPORTION_3;
      break;
    case 4:
      proportion = ConstantUtil.PressureChage.PROPORTION_4;
      break;
    case 5:
      proportion = ConstantUtil.PressureChage.PROPORTION_5;
      break;
    case 6:
      proportion = ConstantUtil.PressureChage.PROPORTION_6;
      break;
    case 7:
      proportion = ConstantUtil.PressureChage.PROPORTION_7;
      break;
    case 8:
      proportion = ConstantUtil.PressureChage.PROPORTION_8;
      break;
    case 9:
      proportion = ConstantUtil.PressureChage.PROPORTION_9;
      break;
    case 10:
      proportion = ConstantUtil.PressureChage.PROPORTION_10;
      break;
    case 11:
      proportion = ConstantUtil.PressureChage.PROPORTION_11;
      break;
    case 12:
      proportion = ConstantUtil.PressureChage.PROPORTION_12;
      break;
    case 13:
      proportion = ConstantUtil.PressureChage.PROPORTION_13;
      break;
    case 14:
      proportion = ConstantUtil.PressureChage.PROPORTION_14;
      break;
    }

    value_1 = value * (ConstantUtil.PressureChage.PROPORTION_1 / proportion);
    value_2 = value * (ConstantUtil.PressureChage.PROPORTION_2 / proportion);
    value_3 = value * (ConstantUtil.PressureChage.PROPORTION_3 / proportion);
    value_4 = value * (ConstantUtil.PressureChage.PROPORTION_4 / proportion);
    value_5 = value * (ConstantUtil.PressureChage.PROPORTION_5 / proportion);
    value_6 = value * (ConstantUtil.PressureChage.PROPORTION_6 / proportion);
    value_7 = value * (ConstantUtil.PressureChage.PROPORTION_7 / proportion);
    value_8 = value * (ConstantUtil.PressureChage.PROPORTION_8 / proportion);
    value_9 = value * (ConstantUtil.PressureChage.PROPORTION_9 / proportion);
    value_10 = value * (ConstantUtil.PressureChage.PROPORTION_10 / proportion);
    value_11 = value * (ConstantUtil.PressureChage.PROPORTION_11 / proportion);
    value_12 = value * (ConstantUtil.PressureChage.PROPORTION_12 / proportion);
    value_13 = value * (ConstantUtil.PressureChage.PROPORTION_13 / proportion);
    value_14 = value * (ConstantUtil.PressureChage.PROPORTION_14 / proportion);
    pressureChange.setValue_1(DataFormatUtil.doubleFormat(value_1));
    pressureChange.setValue_2(DataFormatUtil.doubleFormat(value_2));
    pressureChange.setValue_3(DataFormatUtil.doubleFormat(value_3));
    pressureChange.setValue_4(DataFormatUtil.doubleFormat(value_4));
    pressureChange.setValue_5(DataFormatUtil.doubleFormat(value_5));
    pressureChange.setValue_6(DataFormatUtil.doubleFormat(value_6));
    pressureChange.setValue_7(DataFormatUtil.doubleFormat(value_7));
    pressureChange.setValue_8(DataFormatUtil.doubleFormat(value_8));
    pressureChange.setValue_9(DataFormatUtil.doubleFormat(value_9));
    pressureChange.setValue_10(DataFormatUtil.doubleFormat(value_10));
    pressureChange.setValue_11(DataFormatUtil.doubleFormat(value_11));
    pressureChange.setValue_12(DataFormatUtil.doubleFormat(value_12));
    pressureChange.setValue_13(DataFormatUtil.doubleFormat(value_13));
    pressureChange.setValue_14(DataFormatUtil.doubleFormat(value_14));
    return pressureChange;
  }
}
