package lut.luttourismsystem.Service;

import lut.luttourismsystem.Dao.ComplaintReportDao;
import lut.luttourismsystem.Dao.CreditArchiveDao;
import lut.luttourismsystem.Entity.ComplaintReport;
import lut.luttourismsystem.Entity.CreditArchive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class CreditArchiveService {
    @Autowired
    CreditArchiveDao creditArchiveDao;
    
    @Autowired
    ComplaintReportDao complaintReportDao;

    public void addCreditArchive(CreditArchive creditArchive) {
        if (creditArchive.getCreateTime() == null || creditArchive.getCreateTime().isEmpty()) {
            creditArchive.setCreateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        }
        creditArchive.setUpdateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        creditArchiveDao.save(creditArchive);
    }

    public void deleteCreditArchive(int archiveId) {
        creditArchiveDao.deleteById(archiveId);
    }

    public CreditArchive findCreditArchive(int archiveId) {
        return creditArchiveDao.findById(archiveId).orElse(null);
    }

    public CreditArchive findCreditArchiveByEntity(String entityType, int entityId) {
        List<CreditArchive> archives = creditArchiveDao.findByEntityTypeAndEntityId(entityType, entityId);
        if (archives != null && !archives.isEmpty()) {
            return archives.get(0);
        }
        return null;
    }

    public Iterable<CreditArchive> findAllCreditArchives() {
        return creditArchiveDao.findAll();
    }

    public List<CreditArchive> findCreditArchivesByType(String entityType) {
        return creditArchiveDao.findByEntityType(entityType);
    }

    public List<CreditArchive> findCreditArchivesByLevel(String creditLevel) {
        return creditArchiveDao.findByCreditLevel(creditLevel);
    }

    public void updateCreditArchive(CreditArchive creditArchive) {
        creditArchive.setUpdateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        creditArchiveDao.save(creditArchive);
    }

    // 根据投诉信息更新诚信档案
    public void updateCreditArchiveFromComplaint(String entityType, int entityId) {
        CreditArchive archive = findCreditArchiveByEntity(entityType, entityId);
        if (archive == null) {
            // 如果不存在，创建新的诚信档案
            archive = new CreditArchive();
            archive.setEntityType(entityType);
            archive.setEntityId(entityId);
        }

        // 查询该实体的所有投诉
        List<ComplaintReport> complaints = complaintReportDao.findByComplainedTypeAndComplainedId(entityType, entityId);
        
        int totalComplaints = complaints.size();
        int resolvedComplaints = 0;
        int unresolvedComplaints = 0;
        int seriousComplaints = 0;
        double totalSatisfaction = 0;
        int satisfactionCount = 0;

        for (ComplaintReport complaint : complaints) {
            if ("已处理".equals(complaint.getStatus()) || "已关闭".equals(complaint.getStatus())) {
                resolvedComplaints++;
                // 计算处理及时率（假设7天内处理为及时）
                if (complaint.getHandleTime() != null && complaint.getComplaintDate() != null) {
                    // 这里简化处理，实际应该解析时间字符串计算
                }
            } else {
                unresolvedComplaints++;
            }
            
            // 判断是否为严重投诉（可以根据投诉内容或其他标准）
            if (complaint.getContent() != null && (complaint.getContent().contains("严重") || 
                complaint.getContent().contains("重大") || complaint.getContent().contains("事故"))) {
                seriousComplaints++;
            }
            
            // 统计满意度
            if (complaint.getSatisfactionRating() > 0) {
                totalSatisfaction += complaint.getSatisfactionRating();
                satisfactionCount++;
            }
        }

        archive.setTotalComplaints(totalComplaints);
        archive.setResolvedComplaints(resolvedComplaints);
        archive.setUnresolvedComplaints(unresolvedComplaints);
        archive.setSeriousComplaints(seriousComplaints);
        
        if (totalComplaints > 0) {
            archive.setHandleTimelyRate((double) resolvedComplaints / totalComplaints * 100);
        }
        
        if (satisfactionCount > 0) {
            archive.setHandleSatisfaction(totalSatisfaction / satisfactionCount);
        }

        // 计算诚信评分（简化算法，实际应该更复杂）
        int creditScore = 100;
        creditScore -= totalComplaints * 5; // 每个投诉扣5分
        creditScore -= unresolvedComplaints * 10; // 未处理投诉扣10分
        creditScore -= seriousComplaints * 20; // 严重投诉扣20分
        if (satisfactionCount > 0) {
            creditScore += (int)(archive.getHandleSatisfaction() * 2); // 满意度加分
        }
        creditScore = Math.max(0, Math.min(100, creditScore)); // 限制在0-100之间
        
        archive.setCreditScore(creditScore);
        
        // 设置诚信等级
        if (creditScore >= 90) {
            archive.setCreditLevel("优秀");
        } else if (creditScore >= 80) {
            archive.setCreditLevel("良好");
        } else if (creditScore >= 60) {
            archive.setCreditLevel("一般");
        } else if (creditScore >= 40) {
            archive.setCreditLevel("较差");
        } else {
            archive.setCreditLevel("差");
        }

        archive.setLastEvaluationTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        updateCreditArchive(archive);
    }
}

