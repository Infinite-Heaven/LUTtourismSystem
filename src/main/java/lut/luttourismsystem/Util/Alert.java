package lut.luttourismsystem.Util;

import lut.luttourismsystem.Entity.AlertReport;
import lut.luttourismsystem.Entity.TouristAttraction;
import lut.luttourismsystem.Service.AlertReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Alert {

    @Autowired
    AlertReportService alertReportService;

    //多态告警函数，在其他service层更新数据时使用，会生成一个警告实体写入警告数据表
    public void caution(TouristAttraction touristAttraction){
        //逻辑判断
        if(touristAttraction.getCurrentCapacity()>(touristAttraction.getMaxCapacity()*0.9)){
            System.out.println("景区人数已达上限的90%!");
            //告警报告写入数据库
            AlertReport alertReport_TA=new AlertReport();
            alertReport_TA.setContent("景区人数已达上限的90%");
            alertReportService.add(alertReport_TA);
        }

    }


}
