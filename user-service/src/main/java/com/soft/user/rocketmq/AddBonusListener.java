package com.soft.user.rocketmq;

import com.soft.user.domain.dto.UserAddBonusDto;
import com.soft.user.domain.entity.BonusEventLog;
import com.soft.user.domain.entity.User;
import com.soft.user.repository.BonusEventLogRepository;
import com.soft.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author: crq
 * @description:
 * @date: 2022/10/6 09:36
 */
@Service
@RocketMQMessageListener(consumerGroup = "test-group",topic = "add-bonus1")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AddBonusListener implements RocketMQListener<UserAddBonusDto> {
    private final UserRepository userRepository;
    private final BonusEventLogRepository bonusEventLogRepository;

    @Override
    public void onMessage(UserAddBonusDto userAddBonusDto) {
        Integer userId = userAddBonusDto.getUserId();
        User user = userRepository.findById(userId).orElse(null);
        if(user != null) {
            user.setBonus(user.getBonus() + userAddBonusDto.getBonus());
            userRepository.saveAndFlush(user);
        }

        bonusEventLogRepository.save(
                BonusEventLog.builder()
                        .userId(userId)
                        .value(userAddBonusDto.getBonus())
                        .event("CONTRIBUTE")
                        .createTime(new Date())
                        .description("投稿加积分")
                        .build());
    }
}
